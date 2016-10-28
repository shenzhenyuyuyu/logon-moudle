package com.szy.control;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.szy.dao.DBUtils;

public class Test {
	public static void main(String[] args) throws SQLException{
		ResultSet rs=null;
		
		rs=DBUtils.getData("SELECT * FROM user");
		String userName="";
	    while(rs.next()){
	    	userName=rs.getString("user_name");
	    }
		System.out.println(userName);
	}
}
