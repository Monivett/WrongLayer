/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;

import com.wl.WrongLayer.dao.CategoriaDAO;
import com.wl.WrongLayer.dao.PreguntaDAO;
import com.wl.WrongLayer.dao.RespuestaDAO;
import com.wl.WrongLayer.models.Categoria;
import com.wl.WrongLayer.models.Pregunta;
import com.wl.WrongLayer.models.Respuestas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author monic
 */
@WebServlet(name = "RespuestaCorrectaController", urlPatterns = {"/RespuestaCorrectaController"})
public class RespuestaCorrectaController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String stringID = request.getParameter("IDR");
        int ID = Integer.parseInt(stringID, 10);
                String stringP = request.getParameter("ID_P");
        int Preg = Integer.parseInt(stringP, 10);   
       
           Respuestas resp = new Respuestas(ID,Preg);

        RespuestaDAO.RespuestaCorrecta(resp);
          List<Respuestas> TOTALR =RespuestaDAO.MostrarRespuestas(ID);
         request.setAttribute("TOTALrespuestas", TOTALR);
                List<Categoria> categories = CategoriaDAO.getCategories();  
       request.setAttribute("Categories", categories);
         List<Pregunta> preguntasP = PreguntaDAO.getRecords(1, 10);
          request.setAttribute("p", preguntasP);
        List<Pregunta> TOTALpreguntas = null;
       TOTALpreguntas =PreguntaDAO.MostrarPreguntas();
         request.setAttribute("TOTALpreguntas", TOTALpreguntas);
        
           request.getRequestDispatcher("/VerPreguntaController?ID="+Preg).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
