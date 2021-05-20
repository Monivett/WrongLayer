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
@WebServlet(name = "VerPreguntaCategoria", urlPatterns = {"/VerPreguntaCategoria"})
public class VerPreguntaCategoria extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
      String ID= request.getParameter("id");
     String spageid=request.getParameter("page");
            if(spageid==null){
              int  pageid=1;
            }
            else{
                int pageid=Integer.parseInt(spageid); 
            }
          request.setAttribute("navegacion", ID);
        List<Pregunta> preguntas = null;
        preguntas =PreguntaDAO.MostrarPreguntaCategoria(1, 10,ID);
        request.setAttribute("PREG", preguntas);
        
        List<Pregunta> TOTALpreguntas = null;
        TOTALpreguntas =PreguntaDAO.MostrarPreguntas();
         request.setAttribute("TOTALpreguntas", TOTALpreguntas);
          
         List<Categoria> Cate = CategoriaDAO.getCategories(); //Se crea el objeto de la lista
        request.setAttribute("Categories", Cate); //Atributo del select, nombre de la lista
 
        request.getRequestDispatcher("Busqueda_Cat.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String spageid=request.getParameter("page");
             int  pageid = 0;
            if(spageid==null){
                pageid=1;
            }
            else{
                 pageid=Integer.parseInt(spageid); 
            }
       
       
        int total = 10;
        if(pageid==1){}
        else{
            pageid=pageid-1;
            pageid=pageid*total+1;
        }
   
        
        String ID= request.getParameter("IDC");
              request.setAttribute("navegacion", ID);
        List<Pregunta> preguntas = null;
        preguntas =PreguntaDAO.MostrarPreguntaCategoria(pageid, total,ID);
        request.setAttribute("PREG", preguntas);
        
        List<Pregunta> TOTALpreguntas = null;
        TOTALpreguntas =PreguntaDAO.MostrarPreguntas();
         request.setAttribute("TOTALpreguntas", TOTALpreguntas);
          
         List<Categoria> Cate = CategoriaDAO.getCategories(); //Se crea el objeto de la lista
        request.setAttribute("Categories", Cate); //Atributo del select, nombre de la lista
 
        request.getRequestDispatcher("Busqueda_Cat.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
