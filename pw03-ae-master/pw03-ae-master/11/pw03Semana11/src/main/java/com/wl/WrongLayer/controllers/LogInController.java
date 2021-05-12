/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;

import com.wl.WrongLayer.dao.UserDAO;
import com.wl.WrongLayer.models.User;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "LogInController", urlPatterns = {"/LogInController"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25)
public class LogInController extends HttpServlet {
  
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        //Username
        String username = request.getParameter("usuario");
        //Password
        String pass = request.getParameter("password");
     
        User user = new User (username, pass);
       
        User result =  UserDAO.LogInUser(user);//Guardamos la información en result (objeto de usuario)
        
      
      
     
        
        
        if (result!=null){
            HttpSession session =  request.getSession();
            session.setAttribute("username",result.getUsername());
            session.setAttribute("ID_Usuario", result.getId());
            session.setAttribute("Foto", result.getUrlImage());
            session.setAttribute("usuarioID", result);  //Guardamos la información del usuario en usuarioID
            
            response.sendRedirect("PreguntasPrincipal");
        //   request.getRequestDispatcher("PantallaPrincipal.jsp").forward(request, response);
    
        }
        else{
            response.sendRedirect("PantallaInicio.jsp");
        }
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
