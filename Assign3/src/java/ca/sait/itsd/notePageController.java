/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        
        DBoperations dbOps=new DBoperations();
        String noteString=request.getParameter("newNote");
        String deleteString=request.getParameter("delete");
       String usernameString=request.getParameter("username");
       String logoutString = request.getParameter("logout");
       String backgroundButton=request.getParameter("background");
        String option = request.getParameter("option");
         String refresh = request.getParameter("refresh");
         
           if (refresh != null) {
            if (refresh.equals("true")) {
                request.setAttribute("message", "Background color changed");
                   request.setAttribute("noteList", dbOps.getNotes(usernameString));
                      request.setAttribute("welcomeMessage",  usernameString);
                request.getRequestDispatcher("WEB-INF/notePage.jsp").forward(request, response);
            }
        } 
       
            if (logoutString == null) {

        } else if (logoutString.equals("true")) {
            request.setAttribute("message", "Logged out");
           
            request.getRequestDispatcher("WEB-INF/loginPage.jsp").forward(request, response);
        }
            
           
       
                 if (dbOps.addNotes(noteString, usernameString)) {
                     request.setAttribute("message", "New note added");
                    
                     request.setAttribute("noteList", dbOps.getNotes(usernameString));
                      request.setAttribute("welcomeMessage",  usernameString);
                     request.getRequestDispatcher("WEB-INF/notePage.jsp").forward(request, response);
                 }
                 
                 if (option != null) {
                 if(backgroundButton!=null){
                      request.setAttribute("message", "Background colour set");
                      
                      Cookie optionCookie = new Cookie("option", option);
                       optionCookie.setMaxAge(60 * 60);
                       response.addCookie(optionCookie);
                    
                     request.setAttribute("noteList", dbOps.getNotes(usernameString));
                      request.setAttribute("welcomeMessage",  usernameString);
                     response.sendRedirect("notePageController?refresh=true&username="+usernameString);
                 }
                 }
                 
                   if (deleteString!=null) {
                 if (dbOps.deleteNotes(deleteString)) {
                     
                     request.setAttribute("message", "Note deleted");
                     
                     request.setAttribute("noteList", dbOps.getNotes(usernameString));
                      request.setAttribute("welcomeMessage",  usernameString);
                   request.getRequestDispatcher("WEB-INF/notePage.jsp").forward(request, response);
                    
                    
                 }
                 
                 
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
