/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;

import com.wl.WrongLayer.dao.PreguntaDAO;
import com.wl.WrongLayer.dao.RespuestaDAO;
import com.wl.WrongLayer.models.Pregunta;
import com.wl.WrongLayer.models.Respuestas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author monic
 */
@WebServlet(name = "EliminarRespuesta", urlPatterns = {"/EliminarRespuesta"})

public class EliminarRespuesta extends HttpServlet {


 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                 String stringID = request.getParameter("IDR");
        int ID = Integer.parseInt(stringID, 10);
               
       
           Respuestas resp = new Respuestas(ID);

        RespuestaDAO.EliminarRespuesta(resp);
        List<Respuestas> respuesta =RespuestaDAO.MostrarRespuestasUsuario(ID);
        request.setAttribute("respuestas", respuesta);
        List<Pregunta> preg =PreguntaDAO.MostrarPreguntaUsuario(ID);
        request.setAttribute("preguntas", preg);
        request.getRequestDispatcher("Perfil.jsp").forward(request, response);
    }

    @Override
 

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
