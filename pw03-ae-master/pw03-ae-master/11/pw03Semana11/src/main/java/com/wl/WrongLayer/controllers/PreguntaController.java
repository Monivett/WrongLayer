/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;

import com.pw.pw03semana11.DAO.CategoryDAO;


import com.pw.pw03semana11.models.Category;

import com.pw.pw03semana11.utils.FileUtils;
import com.wl.WrongLayer.dao.CategoriaDAO;
import com.wl.WrongLayer.dao.PreguntaDAO;
import com.wl.WrongLayer.models.Categoria;
import com.wl.WrongLayer.models.Pregunta;
import com.wl.WrongLayer.models.User;
import java.io.IOException;
import java.util.List;
import javax.persistence.Convert;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author magoc
 */
@WebServlet(name = "PreguntaController", urlPatterns = {"/PreguntaController"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25)
public class PreguntaController extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<Category> categories =null;
        List<Pregunta> preguntas = null;
        
        categories = CategoryDAO.getCategories();
      //  preguntas =PreguntaDAO.MostrarPreguntas();
        
        request.setAttribute("Categories", categories);
        request.setAttribute("preguntas", preguntas);
        
        request.getRequestDispatcher("PantallaPrincipal.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("pregunta");
        String description = request.getParameter("descripcion");
        String stringCategory = request.getParameter("Categorias");
        int idCategory = Integer.parseInt(stringCategory, 10);
        //FOTO
        Part file = request.getPart("image");
        String path = request.getServletContext().getRealPath("");
        String contentType = file.getContentType();
        String nameImage = file.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType);
        String fullPath = path  + FileUtils.RUTE_USER_IMAGE + "/" + nameImage;
        file.write(fullPath);
        //USUARIO (sesion actual)
        HttpSession  session = request.getSession();
        User user = (User)session.getAttribute("usuarioID");
      
    
        Pregunta pregunta = new Pregunta(new Categoria(idCategory),title,FileUtils.RUTE_USER_IMAGE + "/" + nameImage,user,description);
        
        PreguntaDAO.InsertarPregunta(pregunta);

        List<Categoria> categories = CategoriaDAO.getCategories();  
       request.setAttribute("Categories", categories);
        List<Pregunta> preguntas = PreguntaDAO.MostrarPreguntas();;  
       request.setAttribute("preguntas", preguntas);
  
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
    }// </editor-fold>

}
