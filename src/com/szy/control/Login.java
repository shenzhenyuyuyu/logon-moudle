package com.szy.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.szy.dao.DBUtils;

public class Login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		out.println("welcome <br>");
//		String userName=request.getParameter("username");
//		String password=request.getParameter("password");
//		out.println(userName+"  "+password);
		
		ResultSet rs=null;
		
		try {
			rs=DBUtils.getData("SELECT * FROM user");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String user_name="";
		String password="";
		
		try {
			if(rs.next()){
			try {
				user_name=rs.getString("user_name");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				password=rs.getString("password");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("user_name", user_name);
		request.setAttribute("user_password", password);
		
		
		RequestDispatcher view=request.getRequestDispatcher("welcome.jsp");
		
		view.forward(request, response);
	}
}
