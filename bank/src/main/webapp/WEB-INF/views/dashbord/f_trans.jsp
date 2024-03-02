<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <h1> fund transfer</h1>


                 <div>
                     <div style="border: 3px;">
                       
                         <div align="center">
                           <form action="tranfer" method="Post">
                           
                                <a> Enter account No:  <input type="text" name="b_accNo" >  </a>
                               <br>
                                <a> Enter Amount :  <input type="text" name="amount" >  </a><br>
                                <a> Enter   Desc :  <input type="text" name="desc" >  </a><br>  <br>
                                <a> <button type="submit" > SentMoney</button></a>
                              
                              <button type="reset"> Reset</button>
                                <h3> back to Return : </h3><a href="/v1/bank/loginDone"> click hare </a>
                             </form>
                         </div>
                     
                     
                     
                     </div>
                 
                 
                 </div>
</body>
</html>