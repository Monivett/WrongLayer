/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;


import com.wl.WrongLayer.dao.CategoriaDAO;
import com.wl.WrongLayer.dao.FavoritoDAO;
import com.wl.WrongLayer.dao.PreguntaDAO;
import com.wl.WrongLayer.models.Categoria;
import com.wl.WrongLayer.models.Favorito;
import com.wl.WrongLayer.models.Pregunta;

import com.wl.WrongLayer.models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author monic
 */
@WebServlet(name = "DesmarcarFav", urlPatterns = {"/DesmarcarFav"})
public class DesmarcarFav extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         boolean FavB= true;
        String stringP = request.getParameter("PreguntaID");
        int pregunta = Integer.parseInt(stringP, 10);

        //USUARIO (sesion actual)
        HttpSession  session = request.getSession();
        User user = (User)session.getAttribute("usuarioID");
 
        Favorito Fav = new Favorito(FavB,pregunta,user);
        
        FavoritoDAO.DesmarcarFAV(Fav);

                 List<Categoria> categories = CategoriaDAO.getCategories();  
       request.setAttribute("Categories", categories);
        List<Pregunta> preguntas = PreguntaDAO.getRecords(1, 10);
          request.setAttribute("p", preguntas);
        List<Pregunta> TOTALpreguntas = null;
        TOTALpreguntas =PreguntaDAO.MostrarPreguntas();
         request.setAttribute("TOTALpreguntas", TOTALpreguntas);
  
       request.getRequestDispatcher("/VerPreguntaController?id="+pregunta).forward(request, response);
         
  
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
