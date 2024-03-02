<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<style type="text/css">
 
  .center{ 
   height: 500px;
   align-items: flex-start;
   margin: 10px;
   background-color:#e9e1;
   color: black;
   
  border: 3px  solid green;
  float: left;
  width: 18.33%;
  size:70px;
  padding: 50px;
  
   }
 
 

</style>
</head>
<body>  
			<div  class="center" align="center" style="margin-bottom: 15%">
			    <form action="/v1/bank/loginDone" method="Post">
			    	<a > userName :<input type="text" name="userId">  </a><br>
			    	<a > password : <input type="text" name="password">  </a><br>
			        
			        <button type="submit"> submit</button>
			    
			    </form>
			   
			  <h5> forgot password :  <a href="/v1/bank/loginDone"> click</a></h5>
			
			</div>

</body>
</html>