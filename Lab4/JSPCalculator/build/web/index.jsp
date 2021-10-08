<%-- 
    Document   : index
    Created on : Sep. 30, 2021, 1:19:22 p.m.
    Author     : toby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simple JSP Calculator</h1>
        <form action="index.jsp" method="GET">
            First: <input type="text" name="first">
            <br>
             Second: <input type="text" name="sec">
             <br>
            <input type="submit" name="plus" value="+">
            <input type="submit" name="minus" value="-">
            <input type="submit" name="mul" value="*">
            <input type="submit" name="rem" value="%">
        </form>
        
        <% String textString="RESULT:  ";
                String first =request.getParameter("first");
                String sec =request.getParameter("sec");
                
                if (first==null || sec==null || first.isEmpty() || sec.isEmpty()) {
                       out.print(textString+="---") ;
                    }else if (request.getParameter("plus")!=null) {
                      if (!first.matches("[+-]?\\d*(\\.\\d+)?")|| !sec.matches("[+-]?\\d*(\\.\\d+)?")) {
                            out.print(textString+="---") ;
                       }else{
                         int firstNumber=Integer.parseInt(first);
                     int secNumber=Integer.parseInt(sec);
                     out.print(textString+=(firstNumber+secNumber));
                     }
                       
               }else if (request.getParameter("minus")!=null) {
                if (!first.matches("[+-]?\\d*(\\.\\d+)?")|| !sec.matches("[+-]?\\d*(\\.\\d+)?")) {
                            out.print(textString+="---") ;
                       }else{
                        int firstNumber=Integer.parseInt(first);
                      int secNumber=Integer.parseInt(sec);
                    out.print(textString+=(firstNumber-secNumber));
                    }
                     
                   }else if (request.getParameter("mul")!=null) {
                    if (!first.matches("[+-]?\\d*(\\.\\d+)?")|| !sec.matches("[+-]?\\d*(\\.\\d+)?")) {
                            out.print(textString+="---") ;
                       }else{
                         int firstNumber=Integer.parseInt(first);
                     int secNumber=Integer.parseInt(sec);
                    out.print(textString+=(firstNumber*secNumber));
                  }
                    
                   }else if (request.getParameter("rem")!=null) {
                    if (!first.matches("[+-]?\\d*(\\.\\d+)?")|| !sec.matches("[+-]?\\d*(\\.\\d+)?")) {
                            out.print(textString+="---") ;
                       }else{
                         int firstNumber=Integer.parseInt(first);
                     int secNumber=Integer.parseInt(sec);
                    out.print(textString+=(firstNumber%secNumber));
                 }
                    
                   }
                   
                 
        %>
    </body>
</html>
