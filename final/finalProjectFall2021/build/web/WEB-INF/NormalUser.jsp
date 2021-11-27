<%-- 
    Document   : NormalUser
    Created on : Nov. 25, 2021, 2:30:01 p.m.
    Author     : toby
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="<c:url value="./css/thirdPage.css" />" rel="stylesheet">
    </head>
    <body>
        <h1>Main Page</h1>
        <%@include file="includes/welcomePage.jspf" %>
        <br>
        <div class="borr">
        <a href="UserServices?page=change">Change username</a>
        
        <c:set var="change" value="${requestScope.page}" scope="page"/>
        
        <c:choose>
            <c:when test="${(change==null)}">
                
            </c:when>
            
            <c:when test="${change eq 'change' }">
               <form action="UserServices?page=change" method="POST">
                   <b>Enter new username</b>: <input type="text" name="changeusername" placeholder="New Username"><br>
                   <b>Confirm new username</b>: <input type="text" name="confirmChange" placeholder="Enter new username again"><br>
            <input type="submit" name="login" value="Change Username"><br>
            </form>
               <br>
               <b>${requestScope.message}</b>
                
            </c:when>
               
               <c:when test="${change eq 'finish' }">
                   <br>
                    ${requestScope.finishMessage}
               </c:when>
            
            
        </c:choose>
                   
         </div>
               
          
    </body>
</html>
