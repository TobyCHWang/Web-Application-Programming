/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
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
@WebServlet(name = "loginPageController", urlPatterns = {"/loginPageController"})
public class loginPageController extends HttpServlet {

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
       String username=request.getParameter("username");
       String password=request.getParameter("password");
       String registerString=request.getParameter("register");
       ArrayList<User> userList=(ArrayList<User>)request.getServletContext().getAttribute("usernames");
        ArrayList<String> usernameList=new ArrayList<String>();
         ArrayList<String> passwordList=new ArrayList<String>();
      
       
       
       
       
        if (registerString==null) {
          
             }else if(registerString.equals("true")){
             
              request.getRequestDispatcher("WEB-INF/registerPage.jsp").forward(request, response);
          }
       
        if (username==null && password==null) {
            request.getRequestDispatcher("WEB-INF/loginPage.jsp").forward(request, response);
        }else if (username.equals("") || password.equals("")) {
            request.setAttribute("message", "Both username and password are required!");
            request.getRequestDispatcher("WEB-INF/loginPage.jsp").forward(request, response);
            
        }else{
            //need to test duplicate conditon
            if(userList==null){
                  request.setAttribute("message", "Invalid username or password!");
                 request.getRequestDispatcher("WEB-INF/loginPage.jsp").forward(request, response);
            }
            
            for(int i=0;i<userList.size();i++){
                usernameList.add(userList.get(i).getUsername());
                passwordList.add(userList.get(i).getPassword());
                
                if (username.equals(userList.get(i).getUsername()) && password.equals(userList.get(i).getPassword())) {
                     request.getRequestDispatcher("WEB-INF/notePage.jsp").forward(request, response);   
                }else{
                    request.setAttribute("message", "Invalid username or password!");
                    request.getRequestDispatcher("WEB-INF/loginPage.jsp").forward(request, response);
                }
            }
            
            System.out.println(usernameList);
            System.out.println(passwordList);
            
           
             
        }
        
  
        
           
    
    }
    
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
    {
  
      
        ArrayList<T> newList = new ArrayList<T>();
  
       
        for (T element : list) {
  
            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {
  
                newList.add(element);
            }
        }
  
       
        return newList;
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
