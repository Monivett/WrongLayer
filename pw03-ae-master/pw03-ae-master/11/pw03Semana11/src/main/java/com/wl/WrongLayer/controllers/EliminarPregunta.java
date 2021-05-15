/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;

import com.pw.pw03semana11.utils.FileUtils;
import com.wl.WrongLayer.dao.PreguntaDAO;
import com.wl.WrongLayer.dao.RespuestaDAO;
import com.wl.WrongLayer.models.Categoria;
import com.wl.WrongLayer.models.Pregunta;
import com.wl.WrongLayer.models.Respuestas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author monic
 */
@WebServlet(name = "EliminarPregunta", urlPatterns = {"/EliminarPregunta"})
public class EliminarPregunta extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int ID = Integer.parseInt(request.getParameter("id"), 10);
           Pregunta pregunta = new Pregunta(ID);

        PreguntaDAO.EliminarPregunta(pregunta);
                 List<Respuestas> respuesta =RespuestaDAO.MostrarRespuestasUsuario(ID);
     request.setAttribute("respuestas", respuesta);
       List<Pregunta> preg =PreguntaDAO.MostrarPreguntaUsuario(ID);
        request.setAttribute("preguntas", preg);
      
        request.getRequestDispatcher("Perfil.jsp").forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
