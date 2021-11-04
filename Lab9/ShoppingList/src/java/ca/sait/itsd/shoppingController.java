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
@WebServlet(name = "shoppingController", urlPatterns = {"/shoppingController"})
public class shoppingController extends HttpServlet {

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
          DBoperations dbOps = new DBoperations();
          String itemString=request.getParameter("newItem");
        String action=request.getParameter("action");
        String deleteString=request.getParameter("delete");
        String cartString=request.getParameter("cart");
          
            if (action!=null && !action.equals("")) {
             if (action.equals("add")) {
                 if (dbOps.addList(itemString)) {
                     request.setAttribute("message", "Item added");
                    
                 }else{
                      request.setAttribute("message", "Error adding item");
                 }
             } 
             
             
        }
            
           if (deleteString!=null) {
                   String deleteItem=request.getParameter("itemDelete");
                 if (dbOps.deleteItem(deleteItem)) {
                     request.setAttribute("message", "Item deleted");
                    
                 }else{
                      request.setAttribute("message", "Error deleting item");
                       
                 }
                 
                 
            }
           
             if (cartString!=null) {
                   String changeCart=request.getParameter("itemChange");
                  if (cartString.equals("true")) {
                       if (dbOps.updateCart(changeCart)) {
                     request.setAttribute("message", "Item added to cart");
                    
                 }else{
                      request.setAttribute("message", "Error adding item");
                       
                 }
                     
                 }else if(cartString.equals("false")){
                      if (dbOps.updateCart(changeCart)) {
                     request.setAttribute("message", "Item removed from cart");
                    
                 }else{
                      request.setAttribute("message", "Error removing item");
                       
                 }
                 }
                
                 
                 
            }
          
           request.setAttribute("itemCartList", dbOps.getCartList());
        request.setAttribute("itemList", dbOps.getList());
        request.getRequestDispatcher("WEB-INF/shoppingPage.jsp").forward(request, response);
       
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
