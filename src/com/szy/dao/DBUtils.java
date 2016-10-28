package com.szy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private static Connection conn=null;
	
	
	public static void DBInit(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			System.out.println("1");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("2");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("3");
			e.printStackTrace();
		}
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/user_info?useSSL=false","root","123456");
			//conn=DriverManager.getConnection("jdbc:mysql://localhost/user_info?user=root&password=123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("get connection faild!");
			e.printStackTrace();
		}
	}
	
	public static ResultSet getData(String sqlState) throws SQLException{
		if(conn==null){
			DBInit();
		}
		
		Statement stmt;
		stmt=conn.createStatement();
		
		//select
		ResultSet res=stmt.executeQuery(sqlState);
		//stmt.close();
		//conn.close();
		return res;
	}
	
	public static long updateData(String sqlState) throws SQLException{
		if(conn==null){
			DBInit();
		}
		
		Statement stmt;
		stmt=conn.createStatement();
		
		//update(insert, delete, update)
		long res=stmt.executeUpdate(sqlState);
		//stmt.close();
		//conn.close();
		return res;
		
	}
}
