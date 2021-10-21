<%-- 
    Document   : registerPage
    Created on : Oct. 20, 2021, 3:41:35 p.m.
    Author     : toby
--%>

<%@page import="ca.sait.itsd.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register New User</h1>
        <form action="registerPageController" method="POST">
            Enter Username: <input type="text" name="usernameRegister"><br/>
            Enter password: <input type="password" name="passwordRegister"><br/>
            <input type="submit" value="Register">
        </form>
        ${requestScope.message}
        <br/>
        <a href="loginPageController?login=true">Back to Login Page</a> <br><br>
        
     
         
     	<%
         ArrayList<User> userList=(ArrayList<User>)request.getServletContext().getAttribute("usernames");
         String usernameString=request.getParameter("usernameRegister");
          ArrayList<String> list=new ArrayList<String>();
          
          if(usernameString==null){
          
            }else{
              for(int i=0;i<userList.size()-1;i++){
                list.add(userList.get(i).getUsername());
            }
        
        
        
             
         
         
         if(list.contains(usernameString)){
                out.println("Username is already taken, please select a different username");
            }else{
             out.println("User "+"'"+usernameString+"'"+" created successfully" );
            }
            }

     %>
	 
          
      
          
           
          
      
          
           
    </body>
    
</html>
