/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showtable;

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
@WebServlet(name = "ShowTable", urlPatterns = {"/ShowTable"})
public class ShowTable extends HttpServlet {

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
            String textString=" ";
            for(int i=1;i<=10;i++){
                if(i%2==0){
                      textString=textString+"<tr>" +"<td>"+i+"</td>" + "</tr>";
                }else{
                     textString=textString+"  <tr class=\"background\">\n" +
                                                            "    <td>\n" +i+
                                                            "      \n" +
                                                            "    </td>\n" +
                                                            "  </tr>";
                }
               
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowTable</title>");   
            out.println("<style>\n" +
                            "    .background{\n" +
                            "      background-color: gray;\n" +
                            "    }\n" +
                            "  </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Table of numbers between 1 and 10" + "</h1>");
            out.println("<table border=\"2\" width=\"100px\">\n" +
                               "  <tr>\n" +
                               "    <td><b>Number</b></td>\n" +
                               "  </tr>\n" +
                               textString+ 
                                "</table>");
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
