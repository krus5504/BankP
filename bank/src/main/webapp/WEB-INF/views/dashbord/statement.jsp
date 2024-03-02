
<%@page import="java.util.List"%>
<%@page import="com.bank.model.Statements"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
#second {
	margin-bottom: 20px;
	align-content: center;
	/* background-color: lightgrey; */
	width: 80%;
	height: 5px;
	/* border: 5px solid green; */
	padding: 25px;
	margin: 5px;
}

#third {
	margin-bottom: 20px;
	align-content: center;
	/* background-color: lightgrey; */
	width: 80%;
	height: 120%;
	/* border: 5px solid green; */
	padding: 25px;
	margin: 5px;
}

#sd {
	align-content: right;
	/* background-color: lightgrey; */
	width: 95%;
	height: 2%;
	/*  border: 5px solid green; */
	padding: 25px;
	margin: 5px;
}

#r1 {
	align-content: right;
	background-color: #dd3737;
	width: 90%;
	height: 1%;
	/* border: 1px solid green;  */
	padding: 25px;
	margin: 5px;
}

.menu-bar :hover .sub-menu-1 ul li {
	width: 150px;
	padding: 10px;
	border-bottom: 1px dotted #fff;
	background: transparent;
	border-radius: 0;
	text-align: left;
}

.menu-bar {
	background: #fff;
	text-align: center;
}

.menu-bar ul {
	display: inline-flex;
	list-style: none;
	color: #dd3737;
}

.menu-bar ul li {
	width: 120px;
	margin: 15px;
	padding: 15px;
}

.menu-bar ul li a {
	text-decoration: none;
	color: black;
}

.active, .menu-bar ul li:hover {
	background: #dd3737;
	border-radius: 3px;
}

.menu-bar  .fa-solid {
	margin-right: 8px;
}

.sub-menu-1 {
	display: none;
}

.menu-bar ul li:hover .sub-menu-1 {
	display: block;
	position: absolute;
	background: rgb(0, 100, 0);
	margin-top: 15px;
	margin-left: -15px;
}

.menu-bar ul li:hover .sub-menu-1 ul {
	display: block;
	margin: 10px;
}

.menu-bar ul li:hover .sub-menu-1 ul li {
	width: 150px;
	padding: 10px;
	border-bottom: 1px dotted #fff;
	background: transparent;
	border-radius: 0;
	text-align: left;
}

.menu-bar ul li:hover .sub-menu-1 ul li:last-child {
	border-bottom: none;
}

.menu-bar ul li:hover .sub-menu-1 ul li a:hover {
	color: #b2ff00;
}
</style>




<body bgcolor="#dd3737">
	<h2></h2>
	
	   
	   
	   <div id="third" align="left" style="background-color: white">
	<h2>All Traffic Report</h2>


	<table align="center" border="5" width="1000">

		<tr bgcolor="00FF7F" align="center">
			<th><b>Date :</b></th>
			<th><b>Transaction Id</b></th>
			<th><b>Ref Account No</b></th>
			<th><b>Description</b></th>
			<th><b>withdrowals</b></th>
			<th><b>Deposits</b></th>
			<th><b> Action</b></th>
		</tr>
		<%
		
			List<Statements> all = (List<Statements>)request.getAttribute("statment");
			 for(Statements st: all){
				String name=(String)st.getDescr();
				out.println("Stirng Name is : "+name);
				%> 

		<tr>
			<td><%=st.getDate() %></td>
			<td><%=st.getTransId()%></td>
			<td><%=st.getRef() %></td>
			<td><%=st.getDescr() %></td>
			<td><%=st.getWithd() %></td>
			<td><%=st.getDepos() %></td>
			
			<td><a href="/traffic/v1/reports/div/<%=st.getSrNo()%>">
					select Action</a></td>
		</tr>


		 <% 	 
			 }
			%> 
	</table>
	<h2>All Route Report2</h2>


</div>

</body>



</head>
</html>