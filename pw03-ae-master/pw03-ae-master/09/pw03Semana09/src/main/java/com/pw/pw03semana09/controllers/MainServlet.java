/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.pw03semana09.controllers;

import com.pw.pw03semana09.models.Card;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author magoc
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

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
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet MainServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet MainServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        List<Card> cards = new ArrayList<>();
        // Mock Data
        // Informacion prueba
        cards.add(new Card("https://cdna.artstation.com/p/assets/images/images/029/771/244/large/joanne-tran-zagkeyart-wip4.jpg?1598586282",
                "Hades",
                "I did the background keyart done for Hades Character art by the giga talented Jen Zee!!",
                "https://www.artstation.com/artwork/mDO0V8"));
        cards.add(new Card("https://cdnb.artstation.com/p/assets/images/images/031/149/097/large/dorothy-shan-0616.jpg?1602746184",
                "LOL Coven Zyra fan art",
                "Coven Zyra fan art",
                "https://www.artstation.com/artwork/mD6ZwY"));
        cards.add(new Card("https://cdnb.artstation.com/p/assets/images/images/031/190/953/4k/room-8-studio-troll-boss-2.jpg?1602862085",
                "Trolls",
                "The Swamp Trolls are an enemy type that enters the arena with a very large health pool and regenerates health over time.",
                "https://www.artstation.com/artwork/B1Vk49"));
        request.setAttribute("titulo", "Titulo Header");
        request.setAttribute("cards", cards);
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
