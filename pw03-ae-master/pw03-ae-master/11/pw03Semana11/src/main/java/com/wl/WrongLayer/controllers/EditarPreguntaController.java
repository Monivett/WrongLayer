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
import com.wl.WrongLayer.models.User;
import com.wl.WrongLayer.models.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * CONTROLLER PARA EDITAR LA PREGUNTA
 * @author monic
 */
@WebServlet(name = "EditarPreguntaController", urlPatterns = {"/EditarPreguntaController"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25)
public class EditarPreguntaController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              int ID = Integer.parseInt(request.getParameter("id"), 10);
        Pregunta pregunta = PreguntaDAO.MostrarPreguntaID(ID);
       
         request.setAttribute("preguntas", pregunta);

        
          List<Categoria> Categoria = CategoriaDAO.getCategories(); //Se crea el objeto de la lista
      
        request.setAttribute("Categories", Categoria); //Atributo del select, nombre de la lista
   
        
        request.getRequestDispatcher("EditarPreg.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String stringID = request.getParameter("ID");
        int ID = Integer.parseInt(stringID, 10);
        String title = request.getParameter("Pregunta");
        String description = request.getParameter("Descripcion");
        String stringCategory = request.getParameter("Categorias");
        int idCategory = Integer.parseInt(stringCategory, 10);
        //FOTO
        Part file = request.getPart("image");
        String path = request.getServletContext().getRealPath("");
        String contentType = file.getContentType();
        String nameImage = file.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType);
        String fullPath = path  + FileUtils.RUTE_USER_IMAGE + "/" + nameImage;
        file.write(fullPath);
       
         
        
        Pregunta pregunta = new Pregunta(ID,title,description,FileUtils.RUTE_USER_IMAGE + "/" + nameImage,new Categoria(idCategory));

        PreguntaDAO.EditarPregunta(pregunta);
        
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
