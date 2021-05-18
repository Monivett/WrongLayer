/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;

import com.wl.WrongLayer.dao.CategoriaDAO;
import com.wl.WrongLayer.dao.FavoritoDAO;
import com.wl.WrongLayer.dao.PreguntaDAO;
import com.wl.WrongLayer.dao.RespuestaDAO;
import com.wl.WrongLayer.dao.UserDAO;
import com.wl.WrongLayer.dao.UtilDAO;
import com.wl.WrongLayer.models.Categoria;
import com.wl.WrongLayer.models.Favorito;
import com.wl.WrongLayer.models.Pregunta;
import com.wl.WrongLayer.models.Respuestas;
import com.wl.WrongLayer.models.User;
import com.wl.WrongLayer.models.Util;
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
@WebServlet(name = "VerUsuarioAjeno", urlPatterns = {"/VerUsuarioAjeno"})
public class VerUsuarioAjeno extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ID = Integer.parseInt(request.getParameter("id"), 10);
         User usuario = UserDAO.VerPerfilAjeno(ID); 
        request.setAttribute("usuario", usuario);
        
          List<Pregunta> pregunta =PreguntaDAO.MostrarPreguntaUsuario(ID);
            request.setAttribute("pregunta", pregunta);
            
            List<Respuestas> respuesta =RespuestaDAO.MostrarRespuestasUsuario(ID);
            request.setAttribute("respuesta", respuesta);
            
             List<Favorito> fav =FavoritoDAO.MostrarFavoritosUsuario(ID);
            request.setAttribute("fav", fav);
            
             List<Util> util =UtilDAO.MostrarUtilUsuario(ID);
            request.setAttribute("util", util);
            
               List<Pregunta> preguntas =PreguntaDAO.MostrarPreguntas();
            request.setAttribute("preguntas", preguntas);
            
                  List<Categoria> Categoria = CategoriaDAO.getCategories(); //Se crea el objeto de la lista
        request.setAttribute("Categories", Categoria); //Atributo del select, nombre de la lista
    
        
        request.getRequestDispatcher("PerfilAjeno.jsp").forward(request, response);
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
