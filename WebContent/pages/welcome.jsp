<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<body>

<h1>Welcome</h1>

<%
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	out.println(username+" "+password+"<br>");
	
	
	
%>


<h1>DATABASE</h1>

<%
	String user_name=(String)request.getAttribute("user_name");
	String pass=(String)request.getAttribute("user_password");
	
	out.println(user_name+" "+pass+"<br>");

%>

</body>
</html>