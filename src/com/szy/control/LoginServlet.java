package com.szy.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.szy.dao.DBUtils;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		String userCode=request.getParameter("userCode");
		String password=request.getParameter("password");

		
		ResultSet rs=null;
		
		try {
			rs=DBUtils.getData("SELECT * FROM user Where user_code='"+userCode+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String user_code="";
		String user_password="";
		String user_name="";
		
		try {
			if(rs.next()){
			try {
				user_code=rs.getString("user_code");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				user_password=rs.getString("password");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				user_name=rs.getString("user_name");
			
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(user_code.equals(userCode)&&user_password.equals(password)){
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user_code);
			session.setAttribute("name",user_name );
			//setting session to 30 minus
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", user_code);
			
			
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			response.sendRedirect("welcome.jsp");
		}else{
			
			response.sendRedirect("login.html?err=1");
			
			
		}
		
		
		//RequestDispatcher view=request.getRequestDispatcher("/pages/login.html?err=1");
		
		//view.forward(request, response);
	}
}
