package hansin.database;
//서블릿에 한번에 5-1) , 5-2) 해결하였습니다.
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
1. 서버 사이드 저장 기술은 어느것들인가?
1)config 내장객체
2)application 내장객체
3)cookie 
4)session

2. ServletContext와 HttpSession의 차이?
1)모든 서블릿의 어플리케이션에 전체 데이터를 가져오나 Session은 서블릿의 데이터 정보를 웹 서버(WAS)에 저장하여 가져온다.

3. HttpSession 키는 어디에 저장되어 있는지?
1)웹 서버에 저장된다.(WAS)

4. Cookie의 옵션 중 Path와 MaxAge 기능 설명
1)Path는 쿠키 내에 URL을 설정 할 수 있음 
2)MaxAge는 정보 유지기간을 설정
 
5.서버 사이드 저장 기술 대비 클라이언트 사이드 저장 기술의 장점?
1)옵션 설정에 따라 특정 URL에서만 상태정보 저장할 수 있고, 만료시간까지 브라우저가 꺼지더라도 항상 유지할 수 있음 (기간이 길다라고 하면 무조건 Cookie를 사용해야 함)
2)브라우저 닫으면 세션 ID 사라지기 때문에 세션 공간이 유지되지 않음 -> 새롭게 할당되면 서버자원 낭비
3)특정 URL 에만 사용하는 거라면 (어쩌다 한번 필요한 데이터라면) application, session에 저장하면 낭비임
*/
@WebServlet("/my3")
public class example3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 5-1.1)Application 저장소 선언
				ServletContext application = request.getServletContext();
				// 5-1.2)Session 선언
				HttpSession session = request.getSession();	
				// 5-2)Cookie 선언
				Cookie[] cookies = request.getCookies();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				String value_ = request.getParameter("value");
				String op = request.getParameter("operator");
				int value = 0;
						
				if(!value_.equals("")) value = Integer.parseInt(value_);
				// 계산
				if(op.equals("=")) {
//					5-1.1)int x = (Integer) application.getAttribute("value");
//					5-1.2)int x = (Integer) session.getAttribute("value");
					int x = 0;
					for(Cookie c : cookies) {
						if(c.getName().equals("value")) {
							x = Integer.parseInt(c.getValue());
							break;
						}
					}
					int y = value;
//					5-1.1)String operator = (String) application.getAttribute("op");
//					5-1.2)String operator = (String) session.getAttribute("op");
					String operator = "";
					for(Cookie c : cookies) {
						if(c.getName().equals("op")) {
							operator = c.getValue();
							break;
						}
					}
					int result = 0;
					if(operator.equals("+")) {
						result = x + y;					
					} else {
						result = x - y;
					}
					response.getWriter().printf("결과 값 : %d\n", result);
				} else { // 값 저장
//					5-1.1)application.setAttribute("value", value);
//					5-1.1)application.setAttribute("op", op);
//					5-1.2)session.setAttribute("value", value);
//					5-1.2)session.setAttribute("op", op);
					Cookie valueCookie = new Cookie("value", String.valueOf(value));
					Cookie opCookie = new Cookie("op", op);
					response.addCookie(valueCookie);
					response.addCookie(opCookie);
				}
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
