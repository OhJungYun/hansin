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
 
 
@WebServlet("/Check")
public class LoginOk extends HttpServlet {
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

		resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String id =req.getParameter("id");
		String pwd =req.getParameter("pwd");
		String name =req.getParameter("name");
		String tel =req.getParameter("tel");
		String email =req.getParameter("email");
		String[] dept =req.getParameterValues("dept");
		String gender =req.getParameter("gender");
		String birth =req.getParameter("birth");
		String introduction =req.getParameter("introduction");
		String send =req.getParameter("send");
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
		out.println("</body>");
		out.println("</html>");
        Connection con = null;
        PreparedStatement pstmt = null;
 
      
        if(send.contentEquals("DB보기")) {
        	resp.sendRedirect("list");
        }
        if(send.contentEquals("DB삭제")) {
        	resp.sendRedirect("delete");
        }

        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String uid = "OhJungYun";
        String pass = "1234";
        String sql = "insert into member4 values(?,?,?,?,?,?,?,?,?)";
        
        try {
            con = DriverManager.getConnection(url, uid, pass);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.setString(3, name);
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
 