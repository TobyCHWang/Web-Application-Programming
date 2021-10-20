<%-- 
    Document   : jstlpalindromes
    Created on : Oct. 19, 2021, 10:12:47 p.m.
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
    <body>
        <h1>JSTL Palindromes </h1>
     
        
        
        <form action="JSTLpalindromesController" method="post">
Enter text: <input type = "text" name = "userstr" value="${param.userstr}">
<BR/>
<input type="hidden" name="submitted" value="true">
<input type = "Submit" name = "submit" value="Check"> <BR/>
</form>

<c:if test="${param.submitted}" >
    <c:set var ="str" value="${param.userstr}"/>
    <c:set var ="n" value="${(fn:length(str))-1}"/>
    <c:set var ="flag" value="true"/>
    <c:set var ="begin" value=""/>
    
    <c:forEach var="i" begin="0" end="${n}" step="1">
           <c:choose>
               <c:when test="${fn:substring(str,i,i+1).matches('[A-Za-z]+') || fn:substring(str,i,i+1).matches('[0-9]+')}">
                    <c:set var ="begin" value="${begin}${fn:substring(str,i,i+1)}"/>
               </c:when>
               <c:otherwise>
                    <c:set var ="begin" value="${fn:replace(begin,fn:substring(str,i,i+1),'')}"/>
                </c:otherwise>
           </c:choose>
           
       </c:forEach>
       <c:set var ="begin" value="${fn:toLowerCase(begin)}" scope="page"/>
       
       
    
    
   <c:set var ="str2" value="${begin}"/>
   <c:set var ="n2" value="${(fn:length(str2))-1}"/>
    
<c:forEach var="i" begin="0" end="${n2}" step="1">
    <c:set var="ch1" value = "${fn:substring(str2,i,i+1)}" />
    <c:set var="ch2" value = "${fn:substring(str2,n2-i,n2-i+1)}" />
<c:if test = "${ch1 != ch2}">
    <c:set var ="flag" value="false"/>
</c:if>
</c:forEach>
        
      
<c:choose>
<c:when test = "${flag}" >
    <c:out value = "${param.userstr} is a palindrome" /> <BR/>
</c:when>
<c:otherwise>
    <c:out value = "${param.userstr} is not a palindrome" /> <BR/>
</c:otherwise>
</c:choose>
</c:if>
        
       
    </body>
</html>
