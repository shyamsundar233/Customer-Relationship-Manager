package com.project1.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = "springstudent";
		String password = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";

		PrintWriter pw = response.getWriter();
		
		try {
			
			pw.println("Connecting to database: " + jdbcUrl);
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			
			pw.println("Connected to database...");
			
			conn.close();
			
			pw.println("Terminated");
			
		}catch(Exception e) {
			pw.println(e);
		}
		
	}

}
