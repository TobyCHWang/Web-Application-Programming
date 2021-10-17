/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toby
 */

@WebServlet(name = "ShoppingList", urlPatterns = {"/ShoppingList"})
public class ShoppingList extends HttpServlet {

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
            String username=request.getParameter("username");
            String welcomeString=(String)request.getSession().getAttribute("welcomeUsername");
//              ArrayList<String> wordArrayList= (ArrayList<String>)request.getSession().getAttribute("words");
            ArrayList<String> words=(ArrayList<String>)request.getSession().getAttribute("words");
            String wordString=request.getParameter("word");
             
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShoppingList</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Shopping List  "  + "</h1>");
            if (welcomeString==null) {
                out.println("  <form action=\"Validate\" method=\"POST\">\n" +
"            Username: <input type=\"text\" name=\"username\">\n" +
"            <input type=\"submit\" value=\"Register name\">\n" +
"        </form>");
              
            }else{
                out.println("<h3>Welcome, "  + welcomeString+"</h3>");
                out.println("<a href=\"Validate?logout=true\">Logout</a><br/>");
                out.println("<h2>List</h2>\n" +
"        <form action=\"Validate\" method=\"GET\">\n" +
"            Add item: <input type=\"text\" name=\"word\">\n" +
"            <input type=\"submit\" value=\"Add\">\n" +
"        </form>");
                out.println("<form action=\"Validate\" method=\"POST\">");
                   for(int i=1;i<words.size();i++){
                       out.println("<input type=\"radio\" name=\"option\" value=\"" + words.get(i) + "\">"+words.get(i)+"<br>");
                       
                   }
              
                   
                   if (words!=null) {
                    out.println(
"            <input type=\"submit\" name=\"delete\" value=\"Delete\">\n" +
"        </form>");
                }
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
