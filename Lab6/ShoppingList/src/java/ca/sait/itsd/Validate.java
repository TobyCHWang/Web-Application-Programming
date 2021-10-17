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
import java.util.List;
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
@WebServlet(name = "Validate", urlPatterns = {"/Validate"})
public class Validate extends HttpServlet {

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
        String username = request.getParameter("username");
        String welcomeString = (String) request.getSession().getAttribute("welcomeUsername");
        String newWord = request.getParameter("word");
        HttpSession session = request.getSession();
        ArrayList<String> words = new ArrayList<String>(Arrays.asList("a"));
        String deleteString = request.getParameter("delete");
        String optionString = request.getParameter("option");
        ArrayList<String> word2 = (ArrayList<String>) request.getSession().getAttribute("words");

        if (deleteString != null) {
            if (optionString != null) {
                word2.remove(optionString);
            }

        }

        if (logout != null) {
            session.invalidate();
            request.getRequestDispatcher("ShoppingList").forward(request, response);
        } else if (username == null) {
            session.setAttribute("welcomeUsername", welcomeString);
            if (newWord != null && !newWord.equals("")) {
                if (((ArrayList<String>) session.getAttribute("words")) != null) {
                    ((ArrayList<String>) session.getAttribute("words")).add(newWord);

//                       ((ArrayList<String>)session.getAttribute("words")).add(newWord);
                } else {
                    session.setAttribute("words", words);
                    ((ArrayList<String>) session.getAttribute("words")).add(newWord);
                }

            }

//                 session.setAttribute("words", new ArrayList<String>());
            request.getRequestDispatcher("ShoppingList").forward(request, response);
        } else {

            session.setAttribute("welcomeUsername", username);
            request.getRequestDispatcher("ShoppingList").forward(request, response);
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
