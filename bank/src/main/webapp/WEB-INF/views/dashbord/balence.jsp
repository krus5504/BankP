<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  			<%
  			
  			Double balence	=(Double)request.getAttribute("balence");
  			%>



			<h1> total balance is : <%=balence %> </h1>
</body>
</html>