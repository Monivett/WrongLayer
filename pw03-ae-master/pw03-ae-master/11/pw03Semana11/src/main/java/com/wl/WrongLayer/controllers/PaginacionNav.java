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

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CONTROLLER PARA LA BARRA DE NAVEGACION
 * @author monic
 */
@WebServlet(name = "PaginacionNav", urlPatterns = {"/PaginacionNav"})
public class PaginacionNav extends HttpServlet {

  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                  
       String spageid=request.getParameter("page");
        int pageid=Integer.parseInt(spageid);
       
        int total = 10;
        if(pageid==1){}
        else{
            pageid=pageid-1;
            pageid=pageid*total+1;
        }
   
   //Pregunta
    String buscar = request.getParameter("buscar");
          request.setAttribute("navegacion", buscar);
      
       List<Pregunta> preguntas = null;
        preguntas =PreguntaDAO.BuscarPregunta(pageid, total,buscar);
         request.setAttribute("p", preguntas);

          List<Pregunta> TOTALpreguntas = null;
        TOTALpreguntas =PreguntaDAO.MostrarPreguntas();
         request.setAttribute("TOTALpreguntas", TOTALpreguntas);
       
         
         List<Categoria> Categoria = CategoriaDAO.getCategories(); //Se crea el objeto de la lista
        request.setAttribute("Categories", Categoria); //Atributo del select, nombre de la lista
 
        request.getRequestDispatcher("Busqueda.jsp").forward(request, response);


    }



    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
