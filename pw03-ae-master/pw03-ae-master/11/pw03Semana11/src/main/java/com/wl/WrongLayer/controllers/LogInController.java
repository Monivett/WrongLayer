/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;

import com.wl.WrongLayer.dao.CategoriaDAO;
import com.wl.WrongLayer.dao.UserDAO;
import com.wl.WrongLayer.models.Categoria;
import com.wl.WrongLayer.models.User;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
 * CONTROLLER PARA HACER UN LOG IN
 * @author monic
 */
@WebServlet(name = "LogInController", urlPatterns = {"/LogInController"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25)
public class LogInController extends HttpServlet {
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Categoria> Categoria = CategoriaDAO.getCategories(); //Se crea el objeto de la lista
      
        request.setAttribute("Categories", Categoria); //Atributo del select, nombre de la lista
   
        request.getRequestDispatcher("PantallaInicio.jsp").forward(request, response); //Em que JSP está el comboBox
       
          
    }
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//Acentos
        //Username
        String username = request.getParameter("usuario");
        //Password
        String pass = request.getParameter("password");
     
        User user = new User (username, pass);
       
        User result =  UserDAO.LogInUser(user);//Guardamos la información en result (objeto de usuario)
        
      
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
            
            response.sendRedirect("PreguntasPrincipal");
    
    
        }
        else{
            //response.sendRedirect("PantallaInicio.jsp");
              PrintWriter out = response.getWriter();
         
            out.println("location='PantallaInicio.jsp';");
   out.println("alert('User or password incorrect');");
   
     // out.println("document.getElementById(Fecha).style.display = block";");
   out.println("location='PantallaInicio.jsp';");
   out.println("</script>");
        }
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
