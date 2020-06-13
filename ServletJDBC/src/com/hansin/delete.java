package com.hansin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
 
@WebServlet("/list")
public class delete extends HttpServlet {
	public void init() throws ServletException {
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로드 성공");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("드라이버 로드 실패");
        }
    }
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Connection con = null;
        Statement stmt = null;
        PrintWriter out = resp.getWriter();
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String uid = "OhJungYun";
        String pwd = "1234";
        String sql = "delete * from member4";
    	
        try {
        	con = DriverManager.getConnection(url,uid,pwd);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(con != null) con.close();
                if(stmt != null) stmt.close();
            }catch(Exception e){
                e.printStackTrace();
        }
        }
    }
    
}

