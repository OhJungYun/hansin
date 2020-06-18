package hansin.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/check3")
public class Check3 extends HttpServlet {
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
    	PrintWriter out = resp.getWriter();
        req.setCharacterEncoding("utf-8");
		String pwd =req.getParameter("pwd");
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String uid = "OhJungYun";
        String pass = "1234";
        String sql = "select * from member4 where pwd=?";
        
        try {
            con = DriverManager.getConnection(url, uid, pass);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
            	resp.sendRedirect("update");
            }
            else {
            	out.print("<h3>비밀번호가 다릅니다. DB저장...</h3>");
            	resp.sendRedirect("Check");
            }

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