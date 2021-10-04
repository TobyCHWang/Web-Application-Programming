/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcage;

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
@WebServlet(name = "CalcAge", urlPatterns = {"/CalcAge"})
public class CalcAge extends HttpServlet {

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
         String ageString=request.getParameter("age");
           String textString="";
           if(ageString == null ) {
            } else if (ageString.isEmpty()) {
                textString+="<br>"+"You must give your current age";
            }else{
                int intAge = Integer.parseInt(ageString) + 1;
                textString+="<br>"+"Your age next birthday will be " + intAge;
            }
         
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalcAge</title>"); 
            out.println();
//            out.println("<script>");
//            out.println("function birthday(){\n" +
//                                "      let a=document.getElementById(\"age\").value;\n" +
//                                "      let text=\"\";\n" +
//                                "      let age=parseInt(a)+1;\n" +
//                                "      if (a==\"\"){\n" +
//                                "        text+=\"<br>\"+\"You must give your current age \" ;\n" +
//                                "      }else {\n" +
//                                "        text+=\"<br>\"+\"Your age next birthday will be \"+age;\n" +
//                                "      }\n" +
//                                "\n" +
//                                "      document.getElementById(\"test\").innerHTML=text;\n" +
//                                "    }");
//            out.println("</script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Age next birthday</h1>\n" +
                                "<form action=\"CalcAge\" method=\"get\">\n" +
                                "  Enter your current age: <input type=\"text\" name=\"age\" id=\"age\">\n" +
                                "  <input type=\"submit\" value=\"Age next birthday\" >\n" +
                                "  <div id=\"test\"></div>\n" +
                                "</form>");
            out.println(textString);
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
