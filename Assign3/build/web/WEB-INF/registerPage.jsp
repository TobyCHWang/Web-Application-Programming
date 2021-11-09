<%-- 
    Document   : registerPage
    Created on : Nov. 8, 2021, 3:35:51 p.m.
    Author     : toby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: ${cookie.option.value}">
        <h1>Register New User</h1>
        <form action="registerPageController" method="POST">
            Enter Username: <input type="text" name="usernameRegister"><br/>
            Enter password: <input type="password" name="passwordRegister"><br/>
            <input type="submit" value="Register">
        </form>
        ${requestScope.message}
        <br/>
        <a href="loginPageController?login=true">Back to Login Page</a> <br><br>
    </body>
</html>
