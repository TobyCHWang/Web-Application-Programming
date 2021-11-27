<%-- 
    Document   : index
    Created on : Nov. 19, 2021, 1:02:35 p.m.
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
    <style>
            table, th, td {border: 1px solid black;}
            
        </style>
    <body>
          <h1>Exam2:Contact Manager</h1>
          <h2>Add Contact</h2>
        
        <form action="ContactController" method="POST">
            Enter name: <input type="text" name="name"><br/>
            Enter city: <input type="text" name="city"><br/>
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Add"><br>
        </form>
        ${requestScope.message}<br>
        
        <h3>List of Contacts</h3>
        <table>
                <tr>
                    <th>Name</th>
                    <th>City</th>
                    <th>Delete</th>
                </tr>
                
                <c:forEach var="contact" items="${requestScope.contactList}">
             <tr>  
           <td>  ${contact.name} </td>
            <td>  ${contact.city} </td>
            <td><a href="ContactController?delete= ${contact.id}">Delete</a></td>
             </tr>
              </c:forEach>
    </body>
</html>
