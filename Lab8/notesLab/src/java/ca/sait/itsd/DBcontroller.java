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
@WebServlet(name = "DBcontroller", urlPatterns = {"/DBcontroller"})
public class DBcontroller extends HttpServlet {

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
        String action=request.getParameter("action");
        String deleteString=request.getParameter("delete");
       
<<<<<<< HEAD
       
=======
>>>>>>> 89a3b284ca8a30d8802c4684f5b80beeed363c99
        
        
        if (action!=null && !action.equals("")) {
             if (action.equals("add")) {
                 if (dbOps.addNotes(noteString)) {
                     request.setAttribute("message", "Note added");
<<<<<<< HEAD
                     
=======
                     request.setAttribute("noteList", dbOps.getNotes());
>>>>>>> 89a3b284ca8a30d8802c4684f5b80beeed363c99
                 }else{
                      request.setAttribute("message", "Error adding note");
                 }
            }
             
            
             
<<<<<<< HEAD
        
        }
        
         if (deleteString!=null) {
                     String noteDelete = request.getParameter("noteDelete");
                    String[] deleteArray = noteDelete.split(",");
                     String note = deleteArray[0];
                     String date = deleteArray[1];
                    
                       if (deleteString.equals("true")) {
                             dbOps.deleteNotes(note,date);
            }
                    
                
=======
             
        }
        
         if (deleteString!=null) {
                 if (dbOps.deleteNotes(deleteString)) {
                     request.setAttribute("message", "Note deleted");
                     request.setAttribute("noteList", dbOps.getNotes());
                    
                    
                 }else{
                      request.setAttribute("message", "Error deleting note");
                       
                 }
>>>>>>> 89a3b284ca8a30d8802c4684f5b80beeed363c99
                 
                 
            }
     
        
        
<<<<<<< HEAD
        request.setAttribute("notes", dbOps.getNotes());
=======
        
>>>>>>> 89a3b284ca8a30d8802c4684f5b80beeed363c99
        
        request.getRequestDispatcher("WEB-INF/notePage.jsp").forward(request, response);
        
        
        
       
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
