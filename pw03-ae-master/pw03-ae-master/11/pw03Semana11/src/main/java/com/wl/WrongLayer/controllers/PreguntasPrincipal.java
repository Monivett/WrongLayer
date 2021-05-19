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
 * CONTROLLER PARA VER LAS PREGUNTAS EN LA PAGINA PRINCIPAL
 * @author magoc
 */
@WebServlet(name = "PreguntasPrincipal", urlPatterns = {"/PreguntasPrincipal"})
public class PreguntasPrincipal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out=response.getWriter();
   
            
        List<Pregunta> preguntas = null;
        preguntas =PreguntaDAO.getRecords(1, 10);
         request.setAttribute("p", preguntas);

          List<Pregunta> TOTALpreguntas = null;
        TOTALpreguntas =PreguntaDAO.MostrarPreguntas();
         request.setAttribute("TOTALpreguntas", TOTALpreguntas);
       
         
         List<Categoria> Categoria = CategoriaDAO.getCategories(); //Se crea el objeto de la lista
        request.setAttribute("Categories", Categoria); //Atributo del select, nombre de la lista
 
        request.getRequestDispatcher("PantallaPrincipal.jsp").forward(request, response);
    
      /*ORIGINAL
        List<Pregunta> preguntas = null;
        preguntas =PreguntaDAO.MostrarPreguntas();
         request.setAttribute("preguntas", preguntas);
         
         List<Categoria> Categoria = CategoriaDAO.getCategories(); //Se crea el objeto de la lista
        request.setAttribute("Categories", Categoria); //Atributo del select, nombre de la lista
 
        request.getRequestDispatcher("paginacion.jsp").forward(request, response);*/  
    }
       @Override
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        //CIERRA SESIÓN
      
        HttpSession session = request.getSession();
        User usuario = null;
        session.setAttribute("username", usuario);
      
            List<Pregunta> preguntas = null;
        preguntas =PreguntaDAO.getRecords(1, 10);
         request.setAttribute("p", preguntas);

          List<Pregunta> TOTALpreguntas = null;
        TOTALpreguntas =PreguntaDAO.MostrarPreguntas();
         request.setAttribute("TOTALpreguntas", TOTALpreguntas);
       
         
         List<Categoria> Categoria = CategoriaDAO.getCategories(); //Se crea el objeto de la lista
        request.setAttribute("Categories", Categoria); //Atributo del select, nombre de la lista
 
 
        request.getRequestDispatcher("PantallaPrincipal.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
