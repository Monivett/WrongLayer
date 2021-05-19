/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;

import com.pw.pw03semana11.utils.FileUtils;
import com.wl.WrongLayer.dao.CategoriaDAO;
import com.wl.WrongLayer.dao.PreguntaDAO;
import com.wl.WrongLayer.dao.RespuestaDAO;
import com.wl.WrongLayer.dao.UserDAO;
import com.wl.WrongLayer.models.Categoria;
import com.wl.WrongLayer.models.Pregunta;
import com.wl.WrongLayer.models.Respuestas;
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
 * CONTROLLER PARA EDITAR EL USUARIO
 * @author monic
 */
@WebServlet(name = "EditarUsuarioController", urlPatterns = {"/EditarUsuarioController"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25)
public class EditarUsuarioController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               int ID = Integer.parseInt(request.getParameter("id"), 10);
            List<Respuestas> respuesta =RespuestaDAO.MostrarRespuestasUsuario(ID);
     request.setAttribute("respuestas", respuesta);
       List<Pregunta> pregunta =PreguntaDAO.MostrarPreguntaUsuario(ID);
        request.setAttribute("preguntas", pregunta);
      
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
      // List<Pregunta> Pregunta = PreguntaDAO.MostrarPreguntaUsuario(ID);
      
       // request.setAttribute("preguntas", Pregunta);
        
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
