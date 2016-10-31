<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>Welcome</title>
	<script src="../lib/jquery.js"></script>
	<script src="../lib/bootstrap.js"></script>
	
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="../css/user.css">
</head>
<body>

<%
	String user = null;
	String name= null;
	if(session.getAttribute("user") == null){
		response.sendRedirect("login.html");
	}else user = (String) session.getAttribute("user");
	
	if(session.getAttribute("name")==null){
		response.sendRedirect("login.html");
	}else name=(String) session.getAttribute("name");
	
	String userName = null;
	String sessionID = null;
	Cookie[] cookies = request.getCookies();
	if(cookies !=null){
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("user")) userName = cookie.getValue();
		if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
	}
	}
	
%>

<div class="sidebar">
	
	<div class="user-info">

	<div class="row">
		<div class="col-md-6">
			<img src="../img/not_login.jpg" class="img-circle" style="width: 100px;height: 100px;">
		</div>

		<div class="col-md-6">

		<div style="margin-top: 20px;">
			<span class="user-code"></span>
		</div>

		<div style="margin-top: 20px;">
			<span class="user-name"></span>
		</div>
			
		</div>
	</div>
		
	</div>
</div>

<script>
	$('.user-code').text('<%=user %>');
	$('.user-name').text('<%=name %>');
</script>

<nav class="navbar navbar-default narbar-fixd"></nav>

<div class="main-panel">
	
	

</div>

</body>
</html>