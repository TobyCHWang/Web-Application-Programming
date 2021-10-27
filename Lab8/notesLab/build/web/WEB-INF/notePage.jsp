<%-- 
    Document   : index
    Created on : Oct. 26, 2021, 5:33:51 p.m.
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
        <h1>Manage Notes</h1>
        <h3>Add Note</h3>

        <form action="DBcontroller" method="GET">
            Enter new note: <input type="text" name="newNote">
            <input type="hidden" name="action" value="add">
            <input type="submit" name="add" value="add"><br>

            ${requestScope.message}<br>

            <h3>Notes List</h3>

            <table>
                <tr>
                    <th>Note Text</th>
                    <th>Date/Time</th>
                    <th>Delete</th>
                </tr>
                
           
            <c:forEach var="note" items="${requestScope.noteList}">
                <c:set var="count" value="${count+1}"/>
             <tr>
                 
           <td>  ${note.note} </td>
            <td>  ${note.date} </td>
            <td><a href="DBcontroller?delete= ${note.date}">Delete</a></td>
            
            
       
             
             </tr>
             </c:forEach>
          
           
         
      
            
                
        
                
                
                
                
                
               
                    
                
            </table><br>
</html>

