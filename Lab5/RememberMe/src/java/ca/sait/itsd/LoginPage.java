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
@WebServlet(name = "LoginPage", urlPatterns = {"/LoginPage"})
public class LoginPage extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String message = (String) request.getAttribute("message");
            String usernameString = request.getParameter("username");
            

            String rememberString = request.getParameter("rememberme");

           if(usernameString == null) {
            usernameString = "";
        }
        
        if(request.getCookies() != null) {
            for(Cookie c: request.getCookies()) {
                if(c.getName().equals("username")) {
                    if(!c.getValue().isEmpty()) {
                        usernameString = c.getValue();
                    } else if (c.getValue().isEmpty()) {
                        usernameString = "";
                    }
                }
                if(c.getName().equals("rememberme")) {
                    if(c.getValue() != null) {
                        rememberString = "checked";
                    } else if (c.getValue() == null) {
                       rememberString = "";
                    }
                }
            }
        }
           

               

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginPage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Remember Me Login Page</h1>");
            out.println("<form action=\"Validate\" method=\"POST\">");
            out.println(" Username: <input type=\"text\" name=\"username\" value=\"" + usernameString + "\">");
            out.println("<br>");
            out.println("Password: <input type=\"password\" name=\"password\"><br/>");
            out.println("  <input type=\"submit\"  name=\"button\" value=\"Login\">\n"
                    + "            <br>\n"
                    + "             <input type=\"checkbox\" name=\"rememberme\"" + rememberString + ">Remember Me<br/>\n"
                    + "        </form>");
             out.println("<br>");
              out.println("<br>");
            if (message != null) {
                out.println(message);
            } else {
                out.println("");
            }
            out.println("</body>");
            out.println("</html>");
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
