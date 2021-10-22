<%-- 
    Document   : newjsp
    Created on : Oct. 21, 2021, 9:49:37 p.m.
    Author     : toby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: ${cookie.option.value}">
        <h1>Hello World!</h1>
        
            <form action="notePageController2" method="POST">
            <input type="radio" name="option" value="white">White 
            <input type="radio" name="option" value="Aqua">Aqua 
            <input type="radio" name="option" value="Olive">Olive 
            <input type="submit"  name="background" value="Set Background Colour">
        </form>
    </body>
</html>
