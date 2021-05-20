/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;

import com.pw.pw03semana11.utils.FileUtils;
import com.wl.WrongLayer.dao.CategoriaDAO;
import com.wl.WrongLayer.dao.FavoritoDAO;
import com.wl.WrongLayer.dao.NOutilDAO;
import com.wl.WrongLayer.dao.PreguntaDAO;
import com.wl.WrongLayer.dao.RespuestaDAO;
import com.wl.WrongLayer.dao.UtilDAO;
import com.wl.WrongLayer.models.Categoria;
import com.wl.WrongLayer.models.Favorito;
import com.wl.WrongLayer.models.NOutil;
import com.wl.WrongLayer.models.Pregunta;
import com.wl.WrongLayer.models.Respuestas;
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
 * CONTROLLER PARA ELIMINAR LA PREGUNTA
 * @author monic
 */
@WebServlet(name = "EliminarPregunta", urlPatterns = {"/EliminarPregunta"})
public class EliminarPregunta extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      
        
           String stringID = request.getParameter("IDO");
        int ID = Integer.parseInt(stringID, 10);
           Pregunta pregunta = new Pregunta(ID);

        PreguntaDAO.EliminarPregunta(pregunta);
       
            String stringuser = request.getParameter("user");
        int IDUsuario = Integer.parseInt(stringuser, 10);
    
            List<Respuestas> respuestaR =RespuestaDAO.MostrarRespuestasUsuario(IDUsuario);
            request.setAttribute("respuestas", respuestaR);
           
            List<Pregunta> preguntar =PreguntaDAO.MostrarPreguntaUsuario(IDUsuario);
            request.setAttribute("preguntas", preguntar);
            
            List<Pregunta> preguntas =PreguntaDAO.MostrarPreguntas();
            request.setAttribute("preguntastodas", preguntas);
       
             List<Util> util =UtilDAO.MostrarUtilUsuario(IDUsuario);
            request.setAttribute("util", util);
            
                List<NOutil> Noutil =NOutilDAO.MostrarNoUtilUsuario(IDUsuario);
            request.setAttribute("NOutil", Noutil);
            
            
              List<Favorito> fav =FavoritoDAO.MostrarFavoritosUsuario(IDUsuario);
            request.setAttribute("fav", fav);
            
                  List<Categoria> Categoria = CategoriaDAO.getCategories(); //Se crea el objeto de la lista
        request.setAttribute("Categories", Categoria); //Atributo del select, nombre de la lista
    
            
        request.getRequestDispatcher("Perfil.jsp").forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
