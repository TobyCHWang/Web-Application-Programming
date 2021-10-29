<%-- 
    Document   : index
    Created on : Oct. 27, 2021, 3:30:20 p.m.
    Author     : toby
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List Users</h1>
        <h2>Sort Order</h2>
        <form action="DBcontroller" method="GET">
     <select name="datas" id="data">
            <option value="Ascending">Ascending</option>
            <option value="Descending">Descending</option>
  </select>
  <input type="submit" value="Get Data">
            
        </form>
        
        <h1>User List</h1>
        
        <c:forTokens var="username" delims="," items="${requestScope.namesList}">
            ${username}<br/>
        </c:forTokens>
    </body>
</html>
