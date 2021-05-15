<%-- 
    Document   : EditarPreg
    Created on : 15/05/2021, 09:41:31 AM
    Author     : monic
--%>

<%@page import="com.wl.WrongLayer.models.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="com.wl.WrongLayer.models.Pregunta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Pregunta preguntas = (Pregunta)request.getAttribute("preguntas");
  
      List<Categoria> categorias = (List<Categoria>)request.getAttribute("Categories");
     
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Pregunta</title>
    <link rel="shortcut icon" href="IMG/Logo.png" type="image/x-icon">
    <link rel="stylesheet" href="CSS/EditarPreg.css">
    <link rel="stylesheet" href="Boostrap/css/bootstrap.min.css">
</head>
<body>
    <nav>
        <div class="logo">
            <img src="IMG/logo.png" alt="" height="100" width="100">
        </div>
        <input type="text" name="" id="search" required><span class="barra"></span>
        <label for="">Barra de Búsqueda</label>
        </input>
        <div class="botones">
            <button onclick="location.href='PantallaPrincipal.html';" type="submit">Pantalla Principal</button>
            <jsp:include page= "navbar.jsp"/>
            <button onclick="location.href='PantallaPrincipal.html';" type="submit">Busqueda Avanzada</button>
        </div>
    </nav>
    <!--PREGUNTAS Y RESPUESTAS-->
    <form action="EditarPreguntaController" method="POST"  enctype="multipart/form-data" id="Pregunta" >
       <div class="Cartas">
        <div class=" Pregunta card" style="width: 790px;">
               
               <div class="card-body">  
                <h1>Pregunta</h1>
                 <h5 class="card-title"><b>Pregunta: </b>
                    <input type="text" name="Pregunta" id="Pregunta" value="<%= preguntas.getPregunta()%> "  >   
                 <img src="<%= preguntas.getImagePath()%>" class="card-img-top" width="400" height="200"></h5>
                 <p class="card-text"> Descripción:
                    <input type="text" name="Descripcion" id="Descripcion" value="<%= preguntas.getDescription()%>" >   
                  </p>
                    <input type="hidden" name="ID" id="ID" value="<%= preguntas.getId()%>" >   
                 <p class="card-text">Categoría:  
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
                 <p class="card-text">Fecha:  <%= preguntas.getFecha()%></p>
                  <p class="card-text"><img src="<%= preguntas.getUser().getUrlImage()%>" class="fotouser" width="50" height="50"> Usuario: <%= preguntas.getUser().getUsername()%> </p>
                 
                 <div class="puntuacion">
                   <p>
                   <b> Puntuación:</b>  
                   <b> Útil:</b> 
                   <b> No útil:</b>
                   <b> Favorito:</b>  
                   </p>
                       <i class="Like fas fa-thumbs-up"></i>
                       <i class="Unlike fas fa-thumbs-down"></i>
                       <i class="FAV fas fa-star"></i>
                       <br>
                       <br>
                       <input type="file" name="image" required>
                       <button  id="BTN_EDITARPREG" type="submit">Editar</button>
                       <button  id="BTN_ELIMINAR">Eliminar</button>
                        </div>
               </div>
               
             </div>

       </div>   
    </form>
  

       

    <div id="usuarioFoto" class="usuario">
       <img src="<%= session.getAttribute("Foto")%>" width="300" height="300">
    </div> 
 <input id="user" value="<%= session.getAttribute("username")%>" disabled>
  <button  class="BTN_PERFIL" onclick="location.href='VerUsuarioPreguntaController?id=<%= session.getAttribute("ID_Usuario")%>';" type="submit">Mi perfil</button> 




<footer>
    Categorias
</footer>
  

</body>
<script src="JAVASCRIPT/Perfil.js"></script>
<script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
<script src="Boostrap/js/bootstrap.min.js"></script>

</html>
