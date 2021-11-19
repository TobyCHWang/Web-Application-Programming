<%-- 
    Document   : index
    Created on : Nov. 16, 2021, 5:25:04 p.m.
    Author     : toby
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Logged Word List</h1>
        
       
        <a href="LogController?logout=true">Invalidate</a><br/>
        
        <h2>Add Word</h2>
        <form action="LogController" method="GET">
            New word: <input type="text" name="word"><br/>
            <input type="submit" value="Add">
        </form>
        
        <h3>Word List</h3>
        <c:forEach var="word" items="${sessionScope.wordList}">
            ${word}<br/>
        </c:forEach>
    </body>
</html>
