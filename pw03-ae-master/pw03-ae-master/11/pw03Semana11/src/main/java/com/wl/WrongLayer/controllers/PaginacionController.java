/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;

import com.wl.WrongLayer.dao.CategoriaDAO;
import com.wl.WrongLayer.dao.PreguntaDAO;
import com.wl.WrongLayer.models.Categoria;
import com.wl.WrongLayer.models.Pregunta;
import java.io.IOException;
import java.io.PrintWriter;
import static java.util.Collections.list;
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
@WebServlet(name = "PaginacionController", urlPatterns = {"/PaginacionController"})
public class PaginacionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String spageid=request.getParameter("page");
        int pageid=Integer.parseInt(spageid);
       
        int total = 10;
        if(pageid==1){}
        else{
            pageid=pageid-1;
            pageid=pageid*total+1;
        }
   
        List<Pregunta> preguntas = null;
        preguntas =PreguntaDAO.getRecords(pageid, total);

         request.setAttribute("p", preguntas);
          List<Pregunta> TOTALpreguntas = null;
        TOTALpreguntas =PreguntaDAO.MostrarPreguntas();
         request.setAttribute("TOTALpreguntas", TOTALpreguntas);
       
         List<Categoria> Categoria = CategoriaDAO.getCategories(); //Se crea el objeto de la lista
        request.setAttribute("Categories", Categoria); //Atributo del select, nombre de la lista
  
        request.getRequestDispatcher("PantallaPrincipal.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
