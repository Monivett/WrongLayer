/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;

import com.wl.WrongLayer.controllers.*;
import com.pw.pw03semana11.DAO.CategoryDAO;


import com.pw.pw03semana11.models.Category;
import com.pw.pw03semana11.models.News;
import com.pw.pw03semana11.utils.FileUtils;
import com.wl.WrongLayer.dao.CategoriaDAO;
import com.wl.WrongLayer.dao.PreguntaDAO;
import com.wl.WrongLayer.dao.UserDAO;
import com.wl.WrongLayer.models.Categoria;
import com.wl.WrongLayer.models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * CONTROLLER PARA REGISTRAR USUARIOS
 * @author magoc
 */
@WebServlet(name = "RegistroController", urlPatterns = {"/RegistroController"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25)
public class RegistroController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> categories = CategoryDAO.getCategories();
        request.setAttribute("Categories", categories);
        request.getRequestDispatcher("Registro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //Nombre
        String Nombre = request.getParameter("Nombres");
        //Apellido
        String Apellido = request.getParameter("Ap");
        //Fecha de Nacimiento
        String FechaNac = request.getParameter("FechaNac");
         //Correo
        String correo = request.getParameter("email");
        //Username
        String username = request.getParameter("username");
        //Password
        String pass = request.getParameter("password");
        //FOTO
        Part file = request.getPart("image");
        
        String path = request.getServletContext().getRealPath("");
        String contentType = file.getContentType();
        String nameImage = file.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType);
        String fullPath = path  + FileUtils.RUTE_USER_IMAGE + "/" + nameImage;
        file.write(fullPath);
        
        
     
     User user = new User (Nombre, Apellido,FechaNac,correo,username, pass, FileUtils.RUTE_USER_IMAGE + "/" + nameImage);
      UserDAO.insertUser(user); 
  
       List<Categoria> categories = CategoriaDAO.getCategories();  
       request.setAttribute("Categories", categories);

        request.getRequestDispatcher("PantallaInicio.jsp").forward(request, response);
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
