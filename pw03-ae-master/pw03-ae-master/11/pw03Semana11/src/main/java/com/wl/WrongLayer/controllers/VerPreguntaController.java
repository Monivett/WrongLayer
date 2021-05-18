/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;

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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *CONTROLLER PARA VER LA PREGUNTA A DETALLE Y SUS RESPUESTAS
 * @author magoc
 */
@WebServlet(name = "VerPreguntaController", urlPatterns = {"/VerPreguntaController"})
public class VerPreguntaController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //--------------------------PREGUNTA---------------------
        int ID = Integer.parseInt(request.getParameter("id"), 10);
       //MUESTRA LA PREGUNTA SELECCIONADA A DETALLE
        Pregunta pregunta = PreguntaDAO.MostrarPreguntaID(ID); 
        request.setAttribute("preguntas", pregunta);
        //MUESTRA LA CANTIDAD DE PERSONAS QUE MARCARON COMO UTIL A LA PREGUNTA
         Util utilC = UtilDAO.MostrarUtilCantidadPregunta(ID);
         request.setAttribute("utilc", utilC);
         //MUESTRA UTILIDAD DE LA PREGUNTA
         List<Util> util =UtilDAO.MostrarUtilPregunta(ID);
         request.setAttribute("Util", util);
         //MUESTRA LA CANTIDAD DE PERSONAS QUE MARCARON COMO FAVORITO A LA PREGUNTA
         Favorito FavC = FavoritoDAO.MostrarFAVCantidadPregunta(ID);
         request.setAttribute("FAVC", FavC);
         //MUESTRA LO FAVORITO DE LA PREGUNTA
           List<Favorito> FAV =FavoritoDAO.MostrarFavoritoPregunta(ID);
         request.setAttribute("FAV", FAV);
         //MUESTRA LA CANTIDAD DE PERSONAS QUE MARCARON COMO NO UTIL A LA PREGUNTA
          NOutil NOutilC = NOutilDAO.MostrarNOUtilCantidadPregunta(ID);
         request.setAttribute("NOutilC", NOutilC);
         //MUESTRA LA NO UTILIDAD DE LA PREGUNTA
         List<NOutil> NOutil =NOutilDAO.MostrarNOUtilPregunta(ID);
         request.setAttribute("NOUtil", NOutil);
         
         //---------------------RESPUESTAS---------------
         //MUESTRA LAS RESPUESTAS DE LA PREGUNTA SELECCIONADA
         List<Respuestas> respuestas =RespuestaDAO.MostrarRespuestas(ID); 
        request.setAttribute("respuestas", respuestas);
         //MUESTRA UTILIDAD DE LA RESPUESTA
         
         List<Util> utilR =UtilDAO.MostrarUtilRespuesta(ID);
         request.setAttribute("UtilR", utilR);
         
         //MUESTRA LA CANTIDAD DE PERSONAS QUE MARCARON COMO UTIL A LA RESPUESTA
        Util utilCR = UtilDAO.MostrarUtilCantidadRespuesta(ID);
         request.setAttribute("utilcR", utilCR);
         
         //MUESTRA NO UTILIDAD DE LA RESPUESTA
          List<NOutil> NutilR =NOutilDAO.MostrarNOUtilRespuesta(ID);
         request.setAttribute("NUtilR", NutilR);
         
          NOutil NoUtilR = NOutilDAO.MostrarNOUtilCantidadRespuesta(ID);
         request.setAttribute("NoUtilR", NoUtilR);
         
          List<Categoria> Categoria = CategoriaDAO.getCategories(); //Se crea el objeto de la lista
        request.setAttribute("Categories", Categoria); //Atributo del select, nombre de la lista
    
        request.getRequestDispatcher("Pregunta.jsp").forward(request, response);
    }

  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    int ID = Integer.parseInt(request.getParameter("id"), 10);
       //MUESTRA LA PREGUNTA SELECCIONADA A DETALLE
        Pregunta pregunta = PreguntaDAO.MostrarPreguntaID(ID); 
        request.setAttribute("preguntas", pregunta);
        //MUESTRA LA CANTIDAD DE PERSONAS QUE MARCARON COMO UTIL A LA PREGUNTA
         Util utilC = UtilDAO.MostrarUtilCantidadPregunta(ID);
         request.setAttribute("utilc", utilC);
         //MUESTRA UTILIDAD DE LA PREGUNTA
         List<Util> util =UtilDAO.MostrarUtilPregunta(ID);
         request.setAttribute("Util", util);
         //MUESTRA LA CANTIDAD DE PERSONAS QUE MARCARON COMO FAVORITO A LA PREGUNTA
         Favorito FavC = FavoritoDAO.MostrarFAVCantidadPregunta(ID);
         request.setAttribute("FAVC", FavC);
         //MUESTRA LO FAVORITO DE LA PREGUNTA
           List<Favorito> FAV =FavoritoDAO.MostrarFavoritoPregunta(ID);
         request.setAttribute("FAV", FAV);
         //MUESTRA LA CANTIDAD DE PERSONAS QUE MARCARON COMO NO UTIL A LA PREGUNTA
          NOutil NOutilC = NOutilDAO.MostrarNOUtilCantidadPregunta(ID);
         request.setAttribute("NOutilC", NOutilC);
         //MUESTRA LA NO UTILIDAD DE LA PREGUNTA
         List<NOutil> NOutil =NOutilDAO.MostrarNOUtilPregunta(ID);
         request.setAttribute("NOUtil", NOutil);
         
         //---------------------RESPUESTAS---------------
         //MUESTRA LAS RESPUESTAS DE LA PREGUNTA SELECCIONADA
         List<Respuestas> respuestas =RespuestaDAO.MostrarRespuestas(ID); 
        request.setAttribute("respuestas", respuestas);
         //MUESTRA UTILIDAD DE LA RESPUESTA
         
         List<Util> utilR =UtilDAO.MostrarUtilRespuesta(ID);
         request.setAttribute("UtilR", utilR);
         
         //MUESTRA LA CANTIDAD DE PERSONAS QUE MARCARON COMO UTIL A LA RESPUESTA
        Util utilCR = UtilDAO.MostrarUtilCantidadRespuesta(ID);
         request.setAttribute("utilcR", utilCR);
         
         //MUESTRA NO UTILIDAD DE LA RESPUESTA
          List<NOutil> NutilR =NOutilDAO.MostrarNOUtilRespuesta(ID);
         request.setAttribute("NUtilR", NutilR);
         
          NOutil NoUtilR = NOutilDAO.MostrarNOUtilCantidadRespuesta(ID);
         request.setAttribute("NoUtilR", NoUtilR);
         
          List<Categoria> Categoria = CategoriaDAO.getCategories(); //Se crea el objeto de la lista
        request.setAttribute("Categories", Categoria); //Atributo del select, nombre de la lista
    
        request.getRequestDispatcher("Pregunta.jsp").forward(request, response);
        
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
