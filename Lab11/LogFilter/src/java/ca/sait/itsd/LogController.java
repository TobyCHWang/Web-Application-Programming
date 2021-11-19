/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author toby
 */
@WebServlet(name = "LogController", urlPatterns = {"/LogController"})
public class LogController extends HttpServlet {

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
       String logout = request.getParameter("logout");
        String newWord=request.getParameter("word");
        HttpSession session = request.getSession();
          ArrayList<String> words = new ArrayList<String>();
         if (logout != null) {
            session.invalidate();
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        } else if (newWord != null && !newWord.equals("")) {
                if (((ArrayList<String>) session.getAttribute("wordList")) != null) {
                    ((ArrayList<String>) session.getAttribute("wordList")).add(newWord);

//                       ((ArrayList<String>)session.getAttribute("words")).add(newWord);
                } else {
                    session.setAttribute("wordList", words);
                    ((ArrayList<String>) session.getAttribute("wordList")).add(newWord);
                }

            }

//                 session.setAttribute("words", new ArrayList<String>());
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
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
