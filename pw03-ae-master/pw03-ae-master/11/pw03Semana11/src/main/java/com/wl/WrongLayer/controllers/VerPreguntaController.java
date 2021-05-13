/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;

import com.pw.pw03semana11.controllers.*;
import com.pw.pw03semana11.DAO.CategoryDAO;
import com.wl.WrongLayer.dao.PreguntaDAO;
import com.pw.pw03semana11.models.Category;

import com.wl.WrongLayer.dao.CategoriaDAO;
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
 * @author magoc
 */
@WebServlet(name = "VerPreguntaController", urlPatterns = {"/VerPreguntaController"})
public class VerPreguntaController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        int ID = Integer.parseInt(request.getParameter("id"), 10);
        Pregunta pregunta = PreguntaDAO.MostrarPreguntaID(ID);
       
         request.setAttribute("preguntas", pregunta);
         List<Respuestas> respuestas =RespuestaDAO.MostrarRespuestas(ID); 

        request.setAttribute("respuestas", respuestas);
        
          List<Categoria> Categoria = CategoriaDAO.getCategories(); //Se crea el objeto de la lista
      
        request.setAttribute("Categories", Categoria); //Atributo del select, nombre de la lista
   
        
        request.getRequestDispatcher("Pregunta.jsp").forward(request, response);
    }

  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
        int ID = Integer.parseInt(request.getParameter("id"), 10);
        Pregunta pregunta = PreguntaDAO.MostrarPreguntaID(ID);
        
         request.setAttribute("preguntas", pregunta);
           
        List<Category> categories =null;
        List<Respuestas> respuestas =null;
        categories = CategoryDAO.getCategories();
        respuestas =RespuestaDAO.MostrarRespuestas(ID); 

        request.setAttribute("respuestas", respuestas);
        
        request.setAttribute("Categories", categories);
       
        
        request.getRequestDispatcher("Pregunta.jsp").forward(request, response);
        
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
