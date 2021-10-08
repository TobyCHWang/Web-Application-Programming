<%-- 
    Document   : wordForm
    Created on : Oct. 1, 2021, 2:10:55 p.m.
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
        <h1>Word Form</h1>
    
    
    <form action="UCwordController" method="POST">
        Enter a word in lower case: <input type="text" name="case"><br>
            <input type="submit" value="Make Upper Case">
            
    </form>
    ${requestScope.message}
    </body>
</html>
