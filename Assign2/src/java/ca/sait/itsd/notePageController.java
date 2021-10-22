/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author toby
 */
@WebServlet(name = "notePageController", urlPatterns = {"/notePageController"})
public class notePageController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String logoutString = request.getParameter("logout");
        String background = request.getParameter("background");
        String option = request.getParameter("option");
        ArrayList<Note> noteList = new ArrayList<Note>();
        String noteString = request.getParameter("note");
        String deleteString = request.getParameter("delete");
        //date
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String formattedDateTime = currentDateTime.format(formatter);

        Note note = new Note(noteString, formattedDateTime);

        HttpSession session = request.getSession();

        if (noteString == null) {

        } else if (noteString.isEmpty()) {
            request.setAttribute("message", "Please enter note inforamtion");
            request.getRequestDispatcher("WEB-INF/notePage.jsp").forward(request, response);
        } else {
            if ((ArrayList<Note>) session.getAttribute("notes") != null) {

                ((ArrayList<Note>) session.getAttribute("notes")).add(note);

            } else {
                session.setAttribute("notes", noteList);
                ((ArrayList<Note>) session.getAttribute("notes")).add(note);

            }
              request.setAttribute("message", "New note added");
            request.getRequestDispatcher("WEB-INF/notePage.jsp").forward(request, response);
        }

        if (logoutString == null) {

        } else if (logoutString.equals("true")) {
            session.invalidate();
            request.setAttribute("message", "Logged out");
            Cookie optionCookie = new Cookie("option", option);
            optionCookie.setMaxAge(60 * 60);
            response.addCookie(optionCookie);
            request.getRequestDispatcher("WEB-INF/loginPage.jsp").forward(request, response);
        }

        if (option == null) {
            request.getRequestDispatcher("WEB-INF/notePage.jsp").forward(request, response);
        } else {
            if (background == null) {

            } else {

                Cookie optionCookie = new Cookie("option", option);
                optionCookie.setMaxAge(60 * 60);
                response.addCookie(optionCookie);
            }
            request.setAttribute("message", "Background colour set");
            request.getRequestDispatcher("WEB-INF/notePage.jsp").forward(request, response);
        }

        if (deleteString == null) {

        } else {
            ArrayList<Note> list = (ArrayList<Note>) request.getSession().getAttribute("notes");
            System.out.println(list);
            System.out.println(deleteString);
            ArrayList<String> notelistStrings = new ArrayList<String>();
            ArrayList<String> datelist = new ArrayList<String>();

            for (int i = 0; i < list.size(); i++) {
                notelistStrings.add(list.get(i).getNote());
                datelist.add(list.get(i).getDateTime());
            }

            for (int i = 0; i < datelist.size(); i++) {
                if (deleteString.equals(datelist.get(i))) {
                    datelist.remove(datelist.get(i));
                    notelistStrings.remove(notelistStrings.get(i));
                }
            }

            System.out.println(deleteString);
            System.out.println(notelistStrings);
            System.out.println(datelist);

            for (int i = 0; i < datelist.size(); i++) {
                noteList.add(new Note(notelistStrings.get(i), datelist.get(i)));
            }

            session.setAttribute("notes", noteList);

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
