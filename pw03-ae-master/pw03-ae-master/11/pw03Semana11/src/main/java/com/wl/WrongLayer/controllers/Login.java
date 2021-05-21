package com.wl.WrongLayer.controllers;


import com.google.gson.Gson;
import com.wl.WrongLayer.dao.CategoriaDAO;
import com.wl.WrongLayer.dao.UserDAO;
import com.wl.WrongLayer.models.Categoria;
import com.wl.WrongLayer.models.User;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
@MultipartConfig(maxFileSize = 16177216)// 1.5mb
public class Login extends HttpServlet {
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
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
       
        PrintWriter out = response.getWriter();
       
            out.print(login(request));
     
        out.flush();
    }

    private String login(HttpServletRequest request) {

        HashMap resutado = new HashMap();
          String username = request.getParameter("usuario");
        //Password
        String pass = request.getParameter("password");

        User user = new User(username, pass);
        UserDAO userDao = new UserDAO();
        user = userDao.identificar(user);
        String json;
        HttpSession session;
        if (user != null) {
            session = request.getSession();
            session.setAttribute("Nombre",user.getNombre());
            session.setAttribute("Apellido",user.getAp());
            session.setAttribute("Correo",user.getEmail());
            session.setAttribute("Edad",user.getEdad());
            session.setAttribute("FechaNac",user.getDate());
            session.setAttribute("Estado",user.getEstado());
            session.setAttribute("username",user.getUsername());
            session.setAttribute("ID_Usuario", user.getId());
            session.setAttribute("Foto", user.getUrlImage());
            session.setAttribute("Contraseña", user.getPassword());
            session.setAttribute("usuarioID", user);  //Guardamos la información del usuario en usuarioID
           
            resutado.put("usuario", user);
            resutado.put("Respuesta", true);
            json = new Gson().toJson(resutado);

        } else {
            resutado.put("Respuesta", false);
            json = new Gson().toJson(resutado);
        }
        return json;
    }


}
