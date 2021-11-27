<%-- 
    Document   : Login
    Created on : Nov. 25, 2021, 12:56:30 p.m.
    Author     : toby
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="<c:url value="./css/firstPage.css" />" rel="stylesheet">
    </head>
       
    
    <body>
          <h1>Order Application</h1>
          <div class="borr">
        <form action="UserServices" method="POST">
            
            <b>Username</b>: <input type="text" name="username" placeholder="Your Username"><br>
            <b>Password</b>: <input type="password" name="password" placeholder="Your Password"><br>
            <input type="submit" name="login" value="Login"><br>
        </form>

              <b>${requestScope.message}</b> <br>

        <a href="UserServices?gotoRegister=true">Register new Account</a><br><br>
        
        </div>
    
    </body>
</html>
