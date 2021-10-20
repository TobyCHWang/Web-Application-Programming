<%-- 
    Document   : jstlCalculator
    Created on : Oct. 19, 2021, 7:39:14 p.m.
    Author     : toby
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
          <h1>JSTL Calculator</h1>
        <form action="JSTLCalculatorController" method="GET">
            First: <input type="text" name="first">
            <br>
             Second: <input type="text" name="sec">
             <br>
            <input type="submit" name="option" value="+">
            <input type="submit" name="option" value="-">
            <input type="submit" name="option" value="*">
            <input type="submit" name="option" value="%">
        </form>
          
           <c:set var="first" value="${param.first}" scope="page"/>
           <c:set var="second" value="${param.sec}" scope="page"/>
           <c:set var="option" value="${param.option}" scope="page"/>
           <fmt:parseNumber var = "firstNumber" integerOnly = "true" type = "number" value = "${first}" />
           <fmt:parseNumber var = "secNumber" integerOnly = "true" type = "number" value = "${second}" />
           
           <c:choose>
                <c:when test="${( first==null) || (second==null) }">
                 
               </c:when>
               
               <c:when test="${(empty first) || (empty second) }">
                   Result:--
               </c:when>
                   
                <c:when test="${option eq '+' }">
                    <c:out value="Result: ${firstNumber+secNumber}"/>       
               </c:when>
                   
                 <c:when test="${option eq '-' }">
                    <c:out value="Result: ${firstNumber-secNumber}"/>       
               </c:when>
                   
                   <c:when test="${option eq '*' }">
                    <c:out value="Result: ${firstNumber*secNumber}"/>       
               </c:when>
                   
                   <c:when test="${option eq '%' }">
                    <c:out value="Result: ${firstNumber%secNumber}"/>       
               </c:when>
                   
           </c:choose>
          
        
          
    
</html>
