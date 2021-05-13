/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;

import com.pw.pw03semana11.utils.FileUtils;
import com.wl.WrongLayer.dao.RespuestaDAO;
import com.wl.WrongLayer.models.Respuestas;
import com.wl.WrongLayer.models.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
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
@WebServlet(name = "RespuestasController", urlPatterns = {"/RespuestasController"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25)
public class RespuestasController extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String Respuesta = request.getParameter("Respuesta");
       String ID = request.getParameter("IdPregunta");
       int IDPregunta =Integer.parseInt(ID,10);
          //FOTO
        Part file = request.getPart("archivo");
        String path = request.getServletContext().getRealPath("");
        String contentType = file.getContentType();
        String nameImage = file.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType);
        String fullPath = path  + FileUtils.RUTE_USER_IMAGE + "/" + nameImage;
        file.write(fullPath);
        HttpSession  session = request.getSession();
        User user = (User)session.getAttribute("usuarioID");
       ServletContext context= getServletContext();
     
   
           Respuestas respuesta = new Respuestas(Respuesta,user,IDPregunta,FileUtils.RUTE_USER_IMAGE + "/" + nameImage);
        
        RespuestaDAO.InsertarRespuesta(respuesta);
       
       request.getRequestDispatcher("/VerPreguntaController?id="+IDPregunta).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
