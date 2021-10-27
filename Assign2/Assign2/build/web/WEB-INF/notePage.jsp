<%-- 
    Document   : notePage
    Created on : Oct. 21, 2021, 9:03:22 a.m.
    Author     : toby
--%>

<%@page import="java.time.ZoneId"%>
<%@page import="java.time.ZonedDateTime"%>
<%@page import="java.time.ZoneOffset"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
        <%String deleteString = request.getParameter("delete");
            String itemString = request.getParameter("item");
            if (deleteString != null) {
                out.println("Note deleted");
            }

            if (itemString != null) {
                out.println("Background colour set");
            }


        %>




        <h3>Note List</h3>
        <%            String noteString = request.getParameter("note");
            ArrayList<Note> noteList = (ArrayList<Note>) request.getSession().getAttribute("notes");
            ArrayList<String> notelistStrings = new ArrayList<String>();
            ArrayList<String> datelist = new ArrayList<String>();

            if (noteString == null) {

            } else {
                for (int i = 0; i < noteList.size(); i++) {
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


                <%      for (int i = 0; i < datelist.size(); i++) {
                        LocalDateTime localDateTime = LocalDateTime.parse(datelist.get(i));
                        // parse it to a specified format

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMMdd.HH:mm:ss z yyyy  ");

                        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
                        String formattedString = zonedDateTime.format(formatter);

                        out.println("<tr>"
                                + "<td>" + formattedString + "</td>"
                                + "<td>" + notelistStrings.get(i) + "</td>"
                                + "<td>" + "<a href=notePageController?delete=" + datelist.get(i) + "" + ">Delete" + "</td>"
                                + "</tr>");
                    }

                    if (deleteString != null) {
                        ArrayList<Note> list = (ArrayList<Note>) request.getSession().getAttribute("notes");
                        ArrayList<String> notelistString = new ArrayList<String>();
                        ArrayList<String> datelists = new ArrayList<String>();
                        for (int i = 0; i < noteList.size(); i++) {
                            notelistStrings.add(noteList.get(i).getNote());
                            datelist.add(noteList.get(i).getDateTime());
                        }

                        for (int i = 0; i < datelist.size(); i++) {
                            if (deleteString.equals(datelist.get(i))) {
                                datelist.remove(datelist.get(i));
                                notelistStrings.remove(notelistStrings.get(i));
                            }
                        }

                        for (int i = 0; i < datelist.size(); i++) {
                            LocalDateTime localDateTime = LocalDateTime.parse(datelist.get(i));
                            // parse it to a specified format

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMMdd.HH:mm:ss z yyyy  ");

                            ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
                            String formattedString = zonedDateTime.format(formatter);

                            out.println("<tr>"
                                    + "<td>" + formattedString + "</td>"
                                    + "<td>" + notelistStrings.get(i) + "</td>"
                                    + "<td>" + "<a href=notePageController?delete=" + datelist.get(i) + "" + ">Delete" + "</td>"
                                    + "</tr>");
                        }

                    }


                %>


                <%                    if (noteList == null) {

                    } else {
                        ArrayList<Note> lists = (ArrayList<Note>) request.getSession().getAttribute("notes");
                        if (itemString != null) {

                            for (int i = 0; i < noteList.size(); i++) {
                                notelistStrings.add(noteList.get(i).getNote());
                                datelist.add(noteList.get(i).getDateTime());
                            }

                            for (int i = 0; i < datelist.size(); i++) {
                                LocalDateTime localDateTime = LocalDateTime.parse(datelist.get(i));
                                // parse it to a specified format

                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMMdd.HH:mm:ss z yyyy  ");

                                ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
                                String formattedString = zonedDateTime.format(formatter);

                                out.println("<tr>"
                                        + "<td>" + formattedString + "</td>"
                                        + "<td>" + notelistStrings.get(i) + "</td>"
                                        + "<td>" + "<a href=notePageController?delete=" + datelist.get(i) + "" + ">Delete" + "</td>"
                                        + "</tr>");
                            }

                        }
                    }


                %>










        </table>

        <br/>

        <a href="notePageController?logout=true">Logout</a> <br><br>

        <h3>Set Preferred Background Colour</h3>

        <form action="notePageController" method="POST">
            <input type="radio" name="option" value="white" checked>White 
            <input type="radio" name="option" value="Aqua">Aqua 
            <input type="radio" name="option" value="Olive">Olive 
            <input type="submit"  name="background" value="Set Background Colour">
        </form>






    </body>
</html>
