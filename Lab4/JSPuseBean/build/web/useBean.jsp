<%-- 
    Document   : useBean
    Created on : Sep. 30, 2021, 1:19:22 p.m.
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
        <h1>Use User Bean</h1>
        
        <form action="useBean.jsp" method="GET">
            Enter username: <input type="text" name="username">
            <br>
            <input type="submit" value="Set username">
        </form>
        
        <jsp:useBean id="otherBean" class="ca.sait.itsd.UserBean" scope="session" />  
        <jsp:setProperty name="otherBean" property="username" value="${param.username}" />
        
        <% if (request.getParameter("username")==null || request.getParameter("username").isEmpty()) {

              }else{
              out.println("Your name is "+otherBean.getUsername());
            } %>
     
    </body>
</html>
