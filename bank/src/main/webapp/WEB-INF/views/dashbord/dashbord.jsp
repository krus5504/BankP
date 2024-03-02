<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
     
      
   
   .center{ 
   height: 500px;
   align-items: flex-start;
   margin: 10px;
   background-color:#e9e6b9;
   color: orange;
   
  border: 3px  solid green;
  float: left;
  width: 16.33%;
  size:10ex;
  padding: 50px;
  
   }
   .center2{
    align-items: flex-start;
   margin: 10px;
   background-color:white;
   color: orange;
   
 
  float: left;
  width: 60.33%;
  height: 500px;
  padding: 50px;
   }
   .center1{ 
   
   align-items: flex-start;
   margin: 10px;
   background-color:#e9e6b9;
   color: orange;
   
  border: 3px  solid green;
  float: left;
  width: 18.33%;
  height: 500px;
  padding: 50px;
   }
  
  .div1::after{
	  margin-bottom: 500px;
	align-content:flex-start;
   background-color:orange;
	 width: 33.33%;
	
	 border: 5px solid green; 
	padding: 25px;
	margin: 80px;   
	margin-top: 10px; 
	 }
   
    
   
   * {
  box-sizing: border-box;
 
  border-color: red;
}

.box {
 border: 1px  solid green;
  float: left;
  width: 33.33%;
  padding: 50px;
}

.clearfix::after {
  content: "";
  clear: both;
  display: table;
}
   
   

</style>

</head>
<body bgcolor="#9f9f9f">

   <h1>DashBord page</h1>
   
       <div class="container" >
       	        <%
       	        String fname=(String)request.getAttribute("fname");
       	       String lname=(String)request.getAttribute("lname");
       	        
       	        %><div align="center" >
                  <h1> <a style="color: pink"> Welcome to <%=fname %> <%= lname%> </a></h1>
                   </div>
       	 <div class="div1" >
       	             
       	             <h2 align="right"> <a href="/v1/bank/app"> LogOut</a></h2>
       	             
			<div class="center" style="bgcolor: green;">
 

				 <a href="/v1/bank/loginDone"> Create New Account</a> <br><br>
				 <a href="/v1/bank/dashbord/balence"> Check Ballence</a> <br><br> 
				 <a href="/v1/bank/dashbord/f_trans"> Fund Trasfer</a> <br> <br>
				 <a href="/v1/bank/dashbord/statement"> views Statments</a> <br>
				 
				<br>

			</div>
			<div class="center2">
			  <a><img alt="/police/mainpage.png" src="*mainpage.png"></a>
			
			</div>
		
			
		 	  <div class="center1">
					<ul > <ins>
					        <a href="">About</a>
					       </ins>
					</ul>
					
					<ul>
						<ins><a href=""> Complaint</a></ins>
					</ul>
					
					<ul>
						<ins><a href=""> Views Bank Imformation</a></ins>
					</ul>
			    </div>
		</div>
	</div>


	<div class="clearfix">
		<div class="box" style="background-color: #bbb">
			<p>Some text inside the box.</p>
		</div>
		<div class="box" style="background-color: #ccc">
			<p>Some text inside the box.</p>
		</div>
		<div class="box" style="background-color: #ddd">
			<p>Some text inside the box.</p>
		</div>
	</div>







</body>
</html>