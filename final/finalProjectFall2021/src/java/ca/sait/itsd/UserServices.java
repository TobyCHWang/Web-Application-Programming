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
import javax.servlet.http.HttpSession;

/**
 *
 * @author toby
 */
@WebServlet(name = "UserServices", urlPatterns = {"/UserServices"})
public class UserServices extends HttpServlet {

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
         //Database      
         DBoperations dbOps = new DBoperations();
         
         
         //Database   link 
         String gotoRegister = request.getParameter("gotoRegister");
         String gotoLogin=request.getParameter("gotoLogin");
         String logout=request.getParameter("logout");
         
         //Login page parameter
         
         String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //Register page parameter
         String newUsername = request.getParameter("newUsername");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword=request.getParameter("confirmNewPassword");
        String page=request.getParameter("page");
        
        //normaluser parameter
        
        String changeusername = request.getParameter("changeusername");
        String confirmChange = request.getParameter("confirmChange");
        
        //sessionuserattribute
         HttpSession session = request.getSession();
         String sessionUsername = (String) session.getAttribute("username");
        
//        users database list
         ArrayList<User> usersArrayList=dbOps.getUser();
        
//        Login page
        if(page==null){
              // registration link page
        if (gotoRegister != null) {
            request.getRequestDispatcher("WEB-INF/Registration.jsp").forward(request, response);
        } //Login link page
        else if (gotoLogin!=null) {
            request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
        }//logout
        else if(logout!=null){
              session.invalidate();
              request.setAttribute("message", "Logout!");
             request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
        }
         //Login page
         else if (username == null || password == null) {
            request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
        } // missing login data
        else if (username.isEmpty() || password.isEmpty()) {
            request.setAttribute("message", "Both username and password are required!");
            request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
        } // validate
        else if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
                 for (int i = 0; i < usersArrayList.size(); i++) {
                if (usersArrayList.get(i).getUsername().equalsIgnoreCase(username) && usersArrayList.get(i).getPassword().equals(password)) {
                    if (usersArrayList.get(i).getLocked().equals("Locked")) {
                         request.setAttribute("message", "Account is locked, contact system administrator");
                         request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
                    }
                    else if (usersArrayList.get(i).getUsertype().equals("Normal")) {
                         session.setAttribute("username", username);
                    request.getRequestDispatcher("WEB-INF/NormalUser.jsp").forward(request, response);
                    }else if (usersArrayList.get(i).getUsertype().equals("Admin")) {
                         session.setAttribute("username", username);
                         request.setAttribute("userList", dbOps.getUser());
                    request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);
                  }
                   
                }
            }
                  request.setAttribute("message", "Invalid username or password!");
                  request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
            }
      }//reguster page
        else if (page.equals("register")) {
             if (newUsername.isEmpty() || newPassword.isEmpty()|| confirmNewPassword.isEmpty()) {
            request.setAttribute("message", "All values are required!");
            request.getRequestDispatcher("WEB-INF/Registration.jsp").forward(request, response);
        }// validate
           else if (!newUsername.isEmpty() && !newPassword.isEmpty()) {
                 if (dbOps.addUsername(newPassword, newPassword) && newPassword.equals(confirmNewPassword)) {
                       request.setAttribute("message", "New account created,please log in");
                       request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
                 }else if (!newPassword.equals(confirmNewPassword)) {
                      request.setAttribute("message", "Passwords do not match");
                       request.getRequestDispatcher("WEB-INF/Registration.jsp").forward(request, response);
                 }else{
                     request.setAttribute("message", "Error adding account, account already exist!");
                       request.getRequestDispatcher("WEB-INF/Registration.jsp").forward(request, response);
                 }
           }  
     }//Normal userpage
        else if (page.equals("change")) {
             if (changeusername == null ||  confirmChange == null) {
            request.setAttribute("page", page);
            request.getRequestDispatcher("WEB-INF/NormalUser.jsp").forward(request, response);
        }//empty
            else if (changeusername.isEmpty() || confirmChange.isEmpty()) {
            request.setAttribute("message", "Both username values are required");
            request.setAttribute("page", page);
            request.getRequestDispatcher("WEB-INF/NormalUser.jsp").forward(request, response);
        }// validate
            else if(!changeusername.isEmpty() && !confirmChange.isEmpty()){
//               
                   if (!changeusername.equals(confirmChange)) {
                      request.setAttribute("message", "Username do not match!");
                    request.setAttribute("page", page);
                    request.getRequestDispatcher("WEB-INF/NormalUser.jsp").forward(request, response);
                 }else if (changeusername.equals(confirmChange)) {
                     if (dbOps.updateUsername(sessionUsername, changeusername)){
                          request.setAttribute("page", "finish");
                        request.setAttribute("finishMessage", "Username changed");
                       request.getRequestDispatcher("WEB-INF/NormalUser.jsp").forward(request, response);
                     }else{
                          request.setAttribute("message", "Error adding account, account already exist!");
                      request.setAttribute("page", page);
                       request.getRequestDispatcher("WEB-INF/NormalUser.jsp").forward(request, response);
                     }
                 }


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
