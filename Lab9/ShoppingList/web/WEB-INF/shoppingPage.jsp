<%-- 
    Document   : shoppingPage
    Created on : Nov. 3, 2021, 11:10:08 a.m.
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
          
        <h1>Shopping List</h1>
        <h3>Add Item</h3>

        <form action="shoppingController" method="GET">
            Enter item: <input type="text" name="newItem">
            <input type="hidden" name="action" value="add">
            <input type="submit" name="add" value="add"><br>

            ${requestScope.message}<br>

            <h3>To Get</h3>

            <table>
                <tr>
                    <th>Item</th>
                    <th>In Cart</th>
                    <th>Delete</th>
                </tr>
                
              <c:forEach var="item" items="${requestScope.itemList}">
                <c:set var="count" value="${count+1}"/>
             <tr>
                 
           <td>  ${item.desc} </td>
            <td> <a href="shoppingController?cart=true&itemChange=${item.item}">Add to cart</a> </td>
            <td><a href="shoppingController?delete=true&itemDelete=${item.item}">Delete</a></td>
            
            
       
             
             </tr>
             </c:forEach>
             
             
             
         
                
            </table><br>
            
            <h3>In Cart</h3>

            <table>
                <tr>
                    <th>Item</th>
                    <th>Remove from Cart</th>
                    <th>Delete</th>
                </tr>
              <c:forEach var="itemCart" items="${requestScope.itemCartList}">
                <c:set var="count" value="${count+1}"/>
             <tr>
                 
           <td>  ${itemCart.desc} </td>
            <td> <a href="shoppingController?cart=false&itemChange=${itemCart.item}">Remove from Cart</a> </td>
            <td><a href="shoppingController?delete=true&itemDelete=${itemCart.item}">Delete</a></td>
            
            
       
             
             </tr>
             </c:forEach>

            </body>
</html>

