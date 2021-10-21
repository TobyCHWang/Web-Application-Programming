<%-- 
    Document   : notePage
    Created on : Oct. 21, 2021, 9:03:22 a.m.
    Author     : toby
--%>

<%@page import="ca.sait.itsd.Note"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        table, th, td {
             border:1px solid black;
        }
    </style>
    
    
    <body style="background-color: ${cookie.option.value}">
        <h1>Note Page</h1>
        
        <div>Welcome, ${applicationScope.welcomeMessage}</div>
        
        <h3>Add Note</h3>
        
        <form action="notePageController" method="POST">
            Enter new note: <input type="text" name="note">
            <input type="submit" value="Add">
        </form>
        
        ${requestScope.message}
        
       
        
        <h3>Note List</h3>
          <%
              String noteString=request.getParameter("note");
              ArrayList<Note> noteList=(ArrayList<Note>)request.getSession().getAttribute("notes");
              ArrayList<String> notelistStrings=new ArrayList<String>();
              ArrayList<String> datelist=new ArrayList<String>();
               if(noteString==null){
          
            }else{
              for(int i=0;i<noteList.size();i++){
                notelistStrings.add(noteList.get(i).getNote());
                datelist.add(noteList.get(i).getDateTime());
            }
              }
             
              
              System.out.println(notelistStrings);
                System.out.println(datelist);
        %>
        <table> 
            <tr>
            <th>Date/Time</th>
            <th>Note Text</th>
            <th>Delete</th>
            
            <%
                if (noteList==null) {
                        
                    }
                    else{
            
            %>
                 <%
                    for(int i=0;i<datelist.size();i++){
                    out.println("<tr>"
                    + "<td>"+datelist.get(i)+"</td>"
                    +"<td>"+notelistStrings.get(i)+"</td>"
                    +"<td>"+"<a href='notePageController?delete=true'>Delete"+"</td>"
                    + "</tr>");
                    }
                     }
                
                    %>
                    
                   
                   
           
                   
            
        </table>
        
        <br/>
        
        <a href="notePageController?logout=true">Logout</a> <br><br>
        
        <h3>Set Preferred Background Colour</h3>
        
        <form action="notePageController" method="POST">
            <input type="radio" name="option" value="white">White 
            <input type="radio" name="option" value="Aqua">Aqua 
            <input type="radio" name="option" value="Olive">Olive 
         <input type="submit"  name="background" value="Set Background Colour">
        </form>
        
     
        
        
        
        
    </body>
</html>
