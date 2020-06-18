package com.hansin.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
 
public class Check2 extends HttpServlet {
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
		String name =req.getParameter("name");
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String uid = "OhJungYun";
        String pass = "1234";
        String sql = "select * from member1 where name=?";
        
        try {
            con = DriverManager.getConnection(url, uid, pass);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(3, name);
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
            	resp.sendRedirect("Check3");
            }
            else {
            	resp.sendRedirect("LoginOk");
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