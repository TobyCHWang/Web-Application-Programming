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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
         String name=request.getParameter("username");
            String passwordString=request.getParameter("password");
            
            String logOutString=request.getParameter("Logout");
            String messageString="Logged out";
            String bothMessageString="Both values are required";
            String invalidString="Invalid username or password!";
            
              if (logOutString==null) {
          
             }else if(logOutString.equals("true")){
                 request.setAttribute("message", messageString);
              request.getRequestDispatcher("/Login").forward(request, response);
          }
//           &password=
           if(name.equalsIgnoreCase("alice")&&passwordString.equals("pass")){
//               response.sendRedirect("MainPage?username="+name);
                request.setAttribute("username", name);
                request.setAttribute("password", passwordString);
                request.getRequestDispatcher("/Admin").forward(request, response);
           }else if(name.equalsIgnoreCase("bob")&&passwordString.equals("pass")){
//               response.sendRedirect("MainPage?username="+name);
                request.setAttribute("username", name);
                request.setAttribute("password", passwordString);
                request.getRequestDispatcher("/NormalUser").forward(request, response);
           }else if(name==null || name.isEmpty() || passwordString.isEmpty()){
               request.setAttribute("message", bothMessageString);
                request.getRequestDispatcher("/Login").forward(request, response);
//               response.sendRedirect("LoginPage?username="+name+"&password="+passwordString);
           }else if(!name.equalsIgnoreCase("adam")||!name.equalsIgnoreCase("betty")||!passwordString.equals("pass")){
//                response.sendRedirect("LoginPage?username="+name+"&password="+passwordString);
                 request.setAttribute("message",invalidString); 
                request.getRequestDispatcher("/Login").forward(request, response);
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

