<%-- 
    Document   : Admin
    Created on : Nov. 25, 2021, 2:30:26 p.m.
    Author     : toby
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
         <link href="<c:url value="./css/d.css" />" rel="stylesheet">
     
  <script>
  function confirmComplete() {

var answer=confirm("Delete account?");
if (answer==true)
  {
    return true;
  }
else
  {
    return false;
  }
}
</script>

    </head>
    
    <body>
        <h1>Admin</h1>
         <%@include file="includes/welcomePage.jspf" %>
         
         <div class="borr">
          <h3>User Accounts</h3>
          
           <table>
            <tr>
                <th>Username</th>
                <th>User Type</th>
                <th>Delete</th>
                <th>Lock/Unlock</th>
            </tr>
            <c:forEach var="user" items="${requestScope.userList}">
                <tr>
                    <td><b>${user.username}</b></td>
                    <td><a href="AdminServices?type=true&name=${user.username}">${user.usertype}</a></td>
                    <td>
                    <form action="AdminServices?delete=true&name=${user.username}&typeR=${user.usertype}" method="POST">
                        <input type="submit" class="link-button" value="Delete"  onclick="{return confirmComplete()}"/>
                    </form>
                        </td>
                    <td><a href="AdminServices?locked=true&name=${user.username}" >${user.locked}</a></td>
                </tr>
            </c:forEach>
        </table><br>
        <b>${requestScope.message}</b>
         </div>
      
        
       
            
           
      
        
        
        
    </body>
</html>
