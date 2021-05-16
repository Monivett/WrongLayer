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
import com.pw.pw03semana11.models.News;
import com.wl.WrongLayer.dao.CategoriaDAO;
import com.wl.WrongLayer.models.Categoria;
import com.wl.WrongLayer.models.Pregunta;
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
@WebServlet(name = "PreguntasPrincipal", urlPatterns = {"/PreguntasPrincipal"})
public class PreguntasPrincipal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    
        List<Pregunta> preguntas = null;
        preguntas =PreguntaDAO.MostrarPreguntas();
         request.setAttribute("preguntas", preguntas);
         
         List<Categoria> Categoria = CategoriaDAO.getCategories(); //Se crea el objeto de la lista
        request.setAttribute("Categories", Categoria); //Atributo del select, nombre de la lista
   
        
        
        request.getRequestDispatcher("PantallaPrincipal.jsp").forward(request, response);
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
