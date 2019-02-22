<%@ page import = "MVC_Package.MVC_Demo" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Welcome to home page <br/><br/>
<% MVC_Demo jb = (MVC_Demo)request.getAttribute("bean");
   out.print("Welcome  "+jb.getUsername());
   %>

</h3>
<a href ="home_page.jsp">home page</a>

</body>
</html>