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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author monic
 */
@WebServlet(name = "EditarUsuarioController", urlPatterns = {"/EditarUsuarioController"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25)
public class EditarUsuarioController extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> categories = CategoryDAO.getCategories();
        request.setAttribute("Categories", categories);
        request.getRequestDispatcher("Perfil.jsp").forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //Nombre
        String Nombre = request.getParameter("Nombre");
        //Apellido
        String Apellido = request.getParameter("Apellido");
        //Fecha de Nacimiento
        String FechaNac = request.getParameter("FechaNac");
         //Correo
        String correo = request.getParameter("Correo");
        
        //Password
        String pass = request.getParameter("contra");
        //FOTO
        Part file = request.getPart("image");
        
        String path = request.getServletContext().getRealPath("");
        String contentType = file.getContentType();
        String nameImage = file.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType);
        String fullPath = path  + FileUtils.RUTE_USER_IMAGE + "/" + nameImage;
        file.write(fullPath);
        
        //Username
        String usuario = request.getParameter("NombreUsuario");
  
       String stringID = request.getParameter("ID_Usuario");
        int ID = Integer.parseInt(stringID, 10);
        User user = new User (ID, Nombre,Apellido,FechaNac,correo, usuario, pass,FileUtils.RUTE_USER_IMAGE + "/" + nameImage);
        UserDAO.ModificarUser(user); 
       
       //Volvemos a mostrar los datos del usuario que inició sesión
     
        User usera = new User (usuario, pass);
       
        User result =  UserDAO.LogInUser(usera);//Guardamos la información en result (objeto de usuario)
        
      
        if (result!=null){
            HttpSession session =  request.getSession();
            
            session.setAttribute("Nombre",result.getNombre());
            session.setAttribute("Apellido",result.getAp());
            session.setAttribute("Correo",result.getEmail());
            session.setAttribute("Edad",result.getEdad());
            session.setAttribute("FechaNac",result.getDate());
            session.setAttribute("Estado",result.getEstado());
            session.setAttribute("username",result.getUsername());
            session.setAttribute("ID_Usuario", result.getId());
            session.setAttribute("Foto", result.getUrlImage());
              session.setAttribute("Contraseña", result.getPassword());
            session.setAttribute("usuarioID", result);  //Guardamos la información del usuario en usuarioID
        }
          
       List<Categoria> categories = CategoriaDAO.getCategories();  
       request.setAttribute("Categories", categories);
      //  List<News> news = PreguntaDAO.getNews();
      
       // request.setAttribute("News", news);*/
        
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
