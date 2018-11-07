/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.session.konversibmi;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class konversiServlet extends HttpServlet {

    @EJB
    private konversibmi konversibmi;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {            
            out.println("<html>");
            out.println("<style>");
            out.println(".teks{padding:15px; width:250px; border-radius:5px}");
            out.println("</style>");
            out.println("<body>");
            out.println("<h1><center>Penghitung Poin Wajur Silat </center></h1>");
            out.println("<h3><center>Kelompok 22 </center></h3><br>");
            out.println("<hr><br>");
            String pukul = request.getParameter("pukul");
            String tendang = request.getParameter("tendang");
            String banting = request.getParameter("banting");
            
            if ((pukul != null) && (tendang != null) && (banting != null) && (pukul.length() > 0) && (tendang.length() > 0) && (banting.length() > 0) ) {
                double p = Double.parseDouble(pukul);
                double t = Double.parseDouble(tendang);
                double b = Double.parseDouble(banting);
                if (request.getParameter("konversibmi") != null){
                    String cefa = konversibmi.silat(p,t,b);
                    out.println("<center>");
                    out.println("<p> JUMLAH POIN= <b>"+cefa+"</b></p>");
                    out.println("</center>");

                    out.println("<br><hr><center>");
                    out.println("<p> KETERANGAN: </p>");
                    out.println("<p> Poin Pukul = jml pukul dikali 1 </p>");
                    out.println("<p> Poin Tendang = jml tendang dikali 2 </p>");
                    out.println("<p> Poin Banting = jml banting dikali 3 </p>");
                    out.println("</center>");
                }  
            } else {
                out.println("<center>");
                out.println("<form method=\"get\">");
                out.println("<label>jml Pukul :</label>");
                out.println("<p><input type=\"number\" name=\"pukul\" size=\"20\" placeholder=\"(pukul)\"></p>");
                out.println("<label>jml Tendang :</label>");
                out.println("<p><input type=\"number\" name=\"tendang\" size=\"20\" placeholder=\"(tendang)\"></p>");
                out.println("<label>jml Banting :</label>");
                out.println("<p><input type=\"number\" name=\"banting\" size=\"20\" placeholder=\"(banting)\"></p>");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"konversibmi\" value=\"HITUNG\">");
                out.println("</form>");
                out.println("</center>");
            }
        
        } finally {
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
            out.close();
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
