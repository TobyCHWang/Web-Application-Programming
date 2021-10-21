<%-- 
    Document   : loginPage
    Created on : Oct. 20, 2021, 3:11:58 p.m.
    Author     : toby
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="ca.sait.itsd.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Assign2 Login Page</h1>
        <form action="loginPageController" method="POST">
            Username: <input type="text" name="username"><br/>
            Password: <input type="password" name="password"><br/>
            <input type="submit" value="Login">
        </form>
        ${requestScope.message}
        <br/>
        <a href="loginPageController?register=true">Register New User</a>
        
     <c:set var="username" value="${param.username}" scope="page"/>
         
       <c:forEach var="word" items="${applicationScope.usernames}">
           
           <c:set var="usernamelist" value=" ${word.username}" scope="page"/>
         
           <c:out value="${usernamelist}"></c:out>
       </c:forEach>
    </body>
</html>
