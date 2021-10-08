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
@WebServlet(name = "NormalUser", urlPatterns = {"/NormalUser"})
public class NormalUser extends HttpServlet {

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
            
            String aString=request.getParameter("text");
            String textString="Palindrome?";
            
            if (aString==null) {
                
            }else{
                if (isPalindrome(aString)) {
                    textString+="Yes";
                }else{
                    textString+="No";
                }
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NormalUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Normal User Page </h1>\n" +
                                "<form action=\"NormalUser\" method=\"get\">\n" +
                                "  <a href=\"Validate?Logout=true\">Logout</a>\n" +
                                "  <h3>Palindrome Check</h3>\n" +
                                "  Enter text: <input type=\"text\" name=\"text\">\n" +
                                "  <input type=\"submit\" value=\"Check Text\">\n" +
                                "</form>");
            out.println("<br>"+textString);
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public static boolean isPalindrome(String str) {
		String convertString=str.toLowerCase();
		String spaceString=convertString.replaceAll(" ", "");
		String finalString=spaceString.replaceAll("\\p{Punct}", "");
		 int i = 0, j = finalString.length() - 1;
		 while (i < j) {
			 
	            // If there is a mismatch
	            if (finalString.charAt(i) != finalString.charAt(j))
	                return false;
	 
	            // Increment first pointer and
	            // decrement the other
	            i++;
	            j--;
	        }
	 
	        // Given string is a palindrome
	        return true;
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
