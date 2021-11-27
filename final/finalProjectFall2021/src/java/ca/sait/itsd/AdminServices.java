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
@WebServlet(name = "AdminServices", urlPatterns = {"/AdminServices"})
public class AdminServices extends HttpServlet {

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
        //database
         DBoperations dbOps = new DBoperations();
       //type_username
       String usernameString=request.getParameter("name");
       String typeString=request.getParameter("type");
       int adminCount=dbOps.getAdminCount();
       int normalCount=dbOps.getNormalCount();
       
       //unlockadminuser
       int unLockAdmin=dbOps.getUnlockAdminCount();
       
       //delete
       String deleString=request.getParameter("delete");
       String type=request.getParameter("typeR");
     
        
       
//       locked
        String lockedString=request.getParameter("locked");
       
        if (typeString!=null&&usernameString!=null) {
            
            if (normalCount>=0 && adminCount>1) {
                  if (dbOps.toggleUsernameType(usernameString)) {
                      request.setAttribute("userList", dbOps.getUser());
                  request.setAttribute("message", "Type for account "+"'"+usernameString+"'"+" toggled");
                   request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);
                  }
                  
            }else if (normalCount>=1 && adminCount==1) {
                    if (dbOps.toggleUsernameTypeOnly(usernameString)) {
                      request.setAttribute("userList", dbOps.getUser());
                  request.setAttribute("message", "Type for account "+"'"+usernameString+"'"+" toggled");
                   request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);
                  }else{
                request.setAttribute("message", "Cannot toggle account type, must have at least one admin user!");
                request.setAttribute("userList", dbOps.getUser());
                   request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);
              }
            }
            
          
        }//locked toggle
        else if (lockedString!=null && usernameString!=null) {
            if (unLockAdmin==0) {
                   request.setAttribute("message", "Cannot toggle lock status for account, must have at least one unlocked admin user!");
                request.setAttribute("userList", dbOps.getUser());
                   request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);

            }else{
                    if (dbOps.toggleUsernameLocked(usernameString)) {
                        request.setAttribute("userList", dbOps.getUser());
                  request.setAttribute("message", "Lock status toggled for  "+"'"+usernameString+"'");
                   request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);
            }
            
            
            

            }
        }else if(deleString!=null && usernameString!=null){
            if (adminCount<=1&&type.equals("Admin")) {
                 request.setAttribute("userList", dbOps.getUser());
                  request.setAttribute("message", "Cannot delete, at least one admin user! ");
                   request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);
            }else{
                 if (dbOps.deleteUsername(usernameString)) {
                     request.setAttribute("userList", dbOps.getUser());
                  request.setAttribute("message", "Account "+"'"+usernameString+"'"+" deleted");
                   request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);
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
