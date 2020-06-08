package hansin.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/my2")
public class example2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id =req.getParameter("id");
		String pwd =req.getParameter("pwd");
		String name =req.getParameter("name");
		String tel =req.getParameter("tel");
		String email =req.getParameter("email");
		String []dept =req.getParameterValues("dept");
		String gender =req.getParameter("gender");
		String birth =req.getParameter("birth");
		String introduction =req.getParameter("introduction");
		 resp.setContentType("text/html;charset=utf-8");
	        PrintWriter out = resp.getWriter();
	        out.println("<html>");
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("id :"+id+"<br/>");
			out.println("pwd :"+pwd+"<br/>");
			out.println("name :"+name+"<br/>");
			out.println("tel :"+tel+"<br/>");
			out.println("email :"+email+"<br/>");
			out.println("dept :"+Arrays.toString(dept)+"<br/>");
			out.println("gender :"+gender+"<br/>");
			out.println("birth :"+birth+"<br/>");
			out.println("introduction :"+introduction+"<br/>");
			out.println("</body>");
			out.println("</html>");
	}

}
