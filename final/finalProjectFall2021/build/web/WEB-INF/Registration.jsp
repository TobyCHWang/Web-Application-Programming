<%-- 
    Document   : Registration
    Created on : Nov. 25, 2021, 1:01:16 p.m.
    Author     : toby
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<c:url value="./css/r.css" />" rel="stylesheet">
    </head>
    <body>
        <h1>Register New Account</h1>
        
        <div class="borr">
        <form action="UserServices?page=register" method="POST">
            <b>Username</b>: <input type="text" name="newUsername" placeholder="Enter Username"><br>
            <b>Password</b>: <input type="password" name="newPassword" placeholder="Enter Password"><br>
            <b>Confirm password</b>: <input type="password" name="confirmNewPassword" placeholder="Enter Password again"><br>
            <input type="submit" name="register" value="Register"><br>
        </form>

            <b>${requestScope.message}</b> <br>

        <a href="UserServices?gotoLogin=true">Login</a><br><br>
        </div>
        
    </body>
</html>
