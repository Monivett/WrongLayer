<%-- 
    Document   : Publicar
    Created on : 18/05/2021, 10:01:10 AM
    Author     : monic
--%>

<%@page import="com.wl.WrongLayer.models.Pregunta"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.wl.WrongLayer.models.Categoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
     List<Categoria> categorias = (List<Categoria>)request.getAttribute("Categories");
    List<Pregunta> preguntas = (List<Pregunta>)request.getAttribute("preguntas");
%>
<!DOCTYPE html>
<html lang="es">
    <head>
       <meta charset="UTF-8">
  <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Wrong Layer</title>
        <link rel="shortcut icon" href="IMG/Logo.png" type="image/x-icon">
        <link rel="stylesheet" href="CSS/Publicar_1.css">
        <body>
            <section id="page">
                <nav>
                    <div class="logo">
                        <img src="IMG/Logo.png" alt="" height="100" width="100">
                     </div>
                    <form action = "NavegacionController" method = "POST" id = Nav>
                         <input type="text" name="navegacion" id="search" required><span class="barra"></span>
                        <label for="">Barra de Búsqueda</label>
                        </input>
                        <button onclick="location.href='NavegacionController';" id="nav"type="submit" style="display: none;"></button>
                    </form>
                        <script>
                        var input = document.getElementById("search");
                        input.addEventListener("keyup", function(event) {
                        if (event.keyCode === 13) {
                        event.preventDefault();
                        document.getElementById("nav").click();
                            }
                        });
</script>
                        <div class="botones">
                        <button onclick="location.href='PreguntasPrincipal';" type="submit">PantallaPrincipal</button>
                        <jsp:include page= "navbar.jsp"/>
            <button onclick="location.href='';" type="submit">Búsqueda Avanzada</button>
             <form id="BTN_CerrarSession" action ="PreguntasPrincipal" method="POST">
                    <button onclick="location.href='PreguntasPrincipal';" type="submit">Cerrar Sesión</button>
             </form>
           
           
                   </div>
                </nav>
              <div class="usuario">
   
     <img src="<%= session.getAttribute("Foto")%>" width="200" height="200">
     
     <input type="text" id="user" name="user" value="<%= session.getAttribute("username")%>" value="<%= session.getAttribute("ID_Usuario")%>" readonly><br><br>
             <button id = "perfil" onclick="location.href='VerUsuarioPreguntaController?id=<%= session.getAttribute("ID_Usuario")%>';" type="submit">Mi perfil</button>                
   
</div>
            
                <form id="form"action="PreguntaController" method="POST" enctype="multipart/form-data" >
                  
                  <div class ="Quest">
                        <h1>¿Tienes una pregunta a la que no le encuentras respuesta? ¡Pregunta! </h1>
                        <p>Pregunta: </p>
                        <p>Descripcion: </p> 
                        <p>Categoría
                           
                            <select name ="Categorias" id="Categorias" class="filtrocategoria">
                            <%
                                  
                                if(categorias!=null)
                                for(Categoria categoria: categorias){%>  
                                <option name ="Categorias" value ="<%=categoria.getId()%>">
                                             
                                  <%= categoria.getName()%>
                                   
                                </option>
                            <% } %> 
                            </select>
                        </p>
                        <p>Imagen:</p>
        
                     <input type="text" name="pregunta" id="pregunta" placeholder="Escribe tu pregunta" required>
                           <input type="text" name="descripcion" id="descripcion" placeholder="Danos un poco mas de informacion, explica con mas detalle tu duda">
               <input type="file" name="image" id="archivo">
                    <div class="enviar">
                        <input type="submit" value="Enviar pregunta">
                    </div>
                 </div>
                       
                </form>
              <footer>
        <h4> <b>Categorias: </b></h4>
           <h4>
        <%
                                  
                                if(categorias!=null)
                                for(Categoria categoria: categorias){%>  
                          
                           °      <%= categoria.getName()%> &nbsp

                            <% } %> 
   </h4>
    </footer>
              </section>
        </body>
    </head>
   
</html>