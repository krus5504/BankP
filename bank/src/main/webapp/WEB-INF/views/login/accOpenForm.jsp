<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Account open form</h1>

    <div>
    
       <div>
           <form action="/v1/bank/accDone" method="Post">
            <div>
            	<a > First Name :  <input  type="text"  name="fName"></a>
            </div>
           <div>
            	<a > Last Name :  <input  type="text"  name="lName"></a>
            </div>
            <div>
            	<a > Mobile No :  <input  type="text"  name="mobileNo"></a>
            </div>
            <div>
            	<a > Adhar Number :  <input  type="text"  name="adharId"></a>
            </div>
            <div>
            	<a > Address  :  <input  type="text"  name="address"></a>
            </div>
           
            <div>
            	 <button  type="submit"  name=""> Submit </button>
            	
            </div>
             <div>
            	 <button  type="reset"  name=""> reset </button>
            	
            </div>
           
           </form>
       
       
       </div>
    
    
    </div>

</body>
</html>