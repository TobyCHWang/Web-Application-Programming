<%-- 
    Document   : registerPage
    Created on : Oct. 20, 2021, 3:41:35 p.m.
    Author     : toby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register New User</h1>
        <form action="registerPageController" method="POST">
            Enter Username: <input type="text" name="usernameRegister"><br/>
            Enter password: <input type="password" name="passwordRegister"><br/>
            <input type="submit" value="Register">
        </form>
        ${requestScope.message}
        <br/>
        <a href="loginPageController?login=true">Back to Login Page</a>
    </body>
    </body>
</html>
