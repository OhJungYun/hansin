package com.hansin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/update")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void init() throws ServletException {
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로드 성공");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("드라이버 로드 실패");
        }
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
 
 
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
        String id =req.getParameter("id");
		String name =req.getParameter("name");
		String tel =req.getParameter("tel");
		String email =req.getParameter("email");
		String[] dept =req.getParameterValues("dept");
		String gender =req.getParameter("gender");
		String birth =req.getParameter("birth");
		String introduction =req.getParameter("introduction");
		resp.setContentType("text/html;charset=utf-8");
	    PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("id :"+id+"<br/>");
		out.println("name :"+name+"<br/>");
		out.println("tel :"+tel+"<br/>");
		out.println("email :"+email+"<br/>");
		out.println("dept :"+Arrays.toString(dept)+"<br/>");
		out.println("gender :"+gender+"<br/>");
		out.println("birth :"+birth+"<br/>");
		out.println("introduction :"+introduction+"<br/>");
		out.println("<h1>데이터 업데이트 성공</h1>");
		out.println("</body>");
		out.println("</html>");
        Connection con = null;
        PreparedStatement pstmt = null;
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String uid = "OhJungYun";
        String pass = "1234";
        String sql = "update member4 set tel = ?, email =?, dept = ? , gender=?, birth=?, introduction=?";
        
        try {
            con = DriverManager.getConnection(url, uid, pass);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(4, tel);
            pstmt.setString(5, email);
            pstmt.setString(6, dept.toString());
            pstmt.setString(7, gender);
            pstmt.setString(8, birth);
            pstmt.setString(9, introduction);
            pstmt.executeUpdate();
            

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(con != null) con.close();
                if(pstmt != null) pstmt.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        
    }
 
}