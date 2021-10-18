<%-- 
    Document   : WebCounter
    Created on : Oct. 15, 2021, 11:53:44 a.m.
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
       <h1>Web Counter Session</h1>

        <form action="SessionStateController" method="GET">
           
            <input type="submit" name="increment" value="increment">
            <input type="submit" name="reset" value="reset">
           
       </form>
       <br>

      Count: ${sessionScope.count}
    </body>
</html>
