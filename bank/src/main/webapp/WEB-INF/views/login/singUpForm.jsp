<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container" id="di1">

		<form action="/v1/bank/saveLoginD" method="post">
			<a> UserId: <input type="text" name="userId">
			</a> <br> <a> password: <input type="text" name="password">
			</a> <br> <a> Repeat password: <input type="text" name="password1">
			</a> <br> <a> First Name: <input type="text" name="fName">
			</a> <br> <a> Last Name : <input type="text" name="lName">
			</a> <br> <a> Mobile no: <input type="text" name="phone">
			</a> <br> <a> AccountNo: <input type="text" name="accNo">
			</a> <br>

			<button type="submit">Sing Up</button>
			<button type="reset">Reset</button>
			<br>
			<br>
			<h1>
				Back To return page <a href="/v1/bank/dashbord"> click Hare</a>
			</h1>


		</form>
</body>
</html>