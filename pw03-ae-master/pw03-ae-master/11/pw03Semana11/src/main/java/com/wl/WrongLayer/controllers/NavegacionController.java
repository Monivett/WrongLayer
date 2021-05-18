/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.controllers;

import com.pw.pw03semana11.DAO.CategoryDAO;
import com.pw.pw03semana11.models.Category;
import com.wl.WrongLayer.dao.PreguntaDAO;
import com.wl.WrongLayer.models.Pregunta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CONTROLLER PARA LA BARRA DE NAVEGACION
 * @author monic
 */
@WebServlet(name = "NavegacionController", urlPatterns = {"/NavegacionController"})
public class NavegacionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //Nombre
        String pregunta = request.getParameter("navegacion");
     
           List<Pregunta> buscar = null;
        buscar =PreguntaDAO.BuscarPregunta(pregunta);
        
        request.setAttribute("preguntas", buscar);
           
        List<Category> categories =null;
     
        categories = CategoryDAO.getCategories();
       
        request.setAttribute("Categories", categories);
       
        
        request.getRequestDispatcher("PantallaPrincipal.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
