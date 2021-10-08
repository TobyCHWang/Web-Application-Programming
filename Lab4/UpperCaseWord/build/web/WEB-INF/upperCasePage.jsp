<%-- 
    Document   : upperCasePage
    Created on : Oct. 1, 2021, 2:11:08 p.m.
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
        <h1>Upper Case Page</h1>
        The upper case version of the word you entered is ${requestScope.uppercase}
        <br><!-- comment -->
        <a href="UCwordController?Logout=true">Back to word entry page</a>
    </body>
</html>
