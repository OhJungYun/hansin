package com.hansin.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class example1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    	System.out.println("=====service=====");
    	super.service(req, res);
    	
    }
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   System.out.println("======doGet======");
	   resp.setContentType("text/html; charset=UTF-8");
	   PrintWriter out = resp.getWriter();
	   out.print("<html>");
	   out.print("<head>");
	   out.print("<title>example1</title>");
	   out.print("</head>");
	   out.print("<body><h1>IT콘텐츠학과 오정윤 201637005</h1></body>");
	   out.print("</html>");
   }
}
