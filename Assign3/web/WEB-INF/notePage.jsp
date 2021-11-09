<%-- 
    Document   : notePage
    Created on : Nov. 8, 2021, 6:25:15 p.m.
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
    <body style="background-color: ${cookie.option.value}">
        <h1>Note Page</h1>

        <div>Welcome, ${requestScope.welcomeMessage}</div>

        <h3>Add Note</h3>

        <form action="notePageController?username=${requestScope.welcomeMessage}" method="POST">
            Enter new note: <input type="text" name="newNote">
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Add"> <br>
             ${requestScope.message}<br>
             
              <h3>Notes List</h3>

            <table>
                <tr>
                    <th>Date/Time</th>
                    <th>Note Text</th>
                    <th>Delete</th>
                </tr>
                
                <c:forEach var="note" items="${requestScope.noteList}">
                
             <tr>
               <td>  ${note.dateTime} </td>  
             <td>  ${note.note} </td>
            <td><a href="notePageController?username=${requestScope.welcomeMessage}&delete= ${note.noteID}">Delete</a></td>
            
            
       
             
             </tr>
             </c:forEach>
             
           
                </table>

        <br/>
        </form>
             <a href="notePageController?logout=true">Logout</a> <br><br>
             
              <form action="notePageController?username=${requestScope.welcomeMessage}" method="POST">
            <input type="radio" name="option" value="white" checked>White 
            <input type="radio" name="option" value="Aqua">Aqua 
            <input type="radio" name="option" value="Olive">Olive 
            <input type="submit"  name="background" value="Set Background Colour">
        </form>
    </body>
</html>
