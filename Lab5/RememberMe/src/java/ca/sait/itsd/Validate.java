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

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberme = request.getParameter("rememberme");
        
        String message = request.getParameter("message");
        
         if(message!= null) {
            if(message.equals("valid")) {
                request.setAttribute("message", "Valid");
                request.getRequestDispatcher("LoginPage").forward(request, response);
              
            } else if(message.equals("invalid")) {
                request.setAttribute("message", "Invalid");
                request.getRequestDispatcher("LoginPage").forward(request, response);
                
            }
        } 
        

        if (username == null || password == null) {
            request.getRequestDispatcher("LoginPage").forward(request, response);
        } else if (username.equals("") || password.equals("")) {
            request.setAttribute("message", "Both username and password are required!");
            request.getRequestDispatcher("LoginPage").forward(request, response);
        } else {
            if (username.equals("user") && password.equals("pass")) {

                if (rememberme != null) {
                    Cookie usernamecookie = new Cookie("username", username);
                    Cookie remembermecookie = new Cookie("rememberme", "rem");

                    usernamecookie.setMaxAge(60 * 60);
                    remembermecookie.setMaxAge(60 * 60);

                    response.addCookie(usernamecookie);
                    response.addCookie(remembermecookie);

                } else {
                    if(request.getCookies() != null) {
                        for(Cookie c: request.getCookies()) {
                            if(c.getName().equals("username") || c.getName().equals("rememberme")) {
                                c.setMaxAge(0);
                                response.addCookie(c);
                            }
                        }
                    }
                }
                response.sendRedirect("Validate?message=valid");
            } else if (username.equals("user") && !password.equals("pass")) {
                   if (rememberme != null) {
                    Cookie usernamecookie = new Cookie("username", username);
                    Cookie remembermecookie = new Cookie("rememberme", "rem");

                    usernamecookie.setMaxAge(60 * 60);
                    remembermecookie.setMaxAge(60 * 60);

                    response.addCookie(usernamecookie);
                    response.addCookie(remembermecookie);

                } else {
                    if(request.getCookies() != null) {
                        for(Cookie c: request.getCookies()) {
                            if(c.getName().equals("username") || c.getName().equals("rememberme")) {
                                c.setMaxAge(0);
                                response.addCookie(c);
                            }
                        }
                    }
                }
                response.sendRedirect("Validate?message=invalid");
            } else if(!username.equalsIgnoreCase("user") || !password.equals("pass")) {
                if(rememberme != null) {
                    Cookie usernameCookie = new Cookie("username", username);
                    Cookie rememberCookie = new Cookie("rememberme", "rem");

                    usernameCookie.setMaxAge(0);
                    rememberCookie.setMaxAge(0);

                    response.addCookie(usernameCookie);
                    response.addCookie(rememberCookie);
                }else {
                    if(request.getCookies() != null) {
                        for(Cookie c: request.getCookies()) {
                            if(c.getName().equals("username") || c.getName().equals("rememberme")) {
                                c.setMaxAge(0);
                                response.addCookie(c);
                            }
                        }
                    }
                }
                response.sendRedirect("Validate?message=invalid");
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
