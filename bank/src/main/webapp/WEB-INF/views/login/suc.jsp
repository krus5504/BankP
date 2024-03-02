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
		String accountNo=(String)request.getAttribute("account");
	
			
	%>


	<h2> Apply sucssfully ........!!!</h2>
   
   
       <h3> : <%= accountNo%></h3>
</body>
</html>