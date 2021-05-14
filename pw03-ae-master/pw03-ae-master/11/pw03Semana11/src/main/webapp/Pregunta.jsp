<%-- 
    Document   : Pregunta
    Created on : 11/05/2021, 09:22:18 AM
    Author     : monic
--%>

<%@page import="com.wl.WrongLayer.models.Categoria"%>
<%@page import="com.wl.WrongLayer.models.Pregunta"%>
<%@page import="com.wl.WrongLayer.models.User"%>
<%@page import="com.wl.WrongLayer.models.Respuestas"%>
<%@page import="java.util.List"%>


<% 
    Pregunta preguntas = (Pregunta)request.getAttribute("preguntas");
    User user =(User)request.getAttribute("usuario");
      List<Categoria> categorias = (List<Categoria>)request.getAttribute("Categories");
     List<Respuestas> respuestas = (List<Respuestas>)request.getAttribute("respuestas");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="shortcut icon" href="IMG/Logo.png" type="image/x-icon">
    <link rel="stylesheet" href="Boostrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="CSS/Pregunta.css">
</head>
<body>
    <nav>
        <div class="logo">
            <img src="IMG/Logo.png" alt="" height="100" width="100">
        </div>
        <input type="text" name="" id="search" required><span class="barra"></span>
        <label for="">Barra de Búsqueda</label>
        </input>
        <div class="botones">
             <button onclick="location.href='PreguntasPrincipal';" type="submit">PantallaPrincipal</button>
            <jsp:include page= "navbar.jsp"/>
            <button onclick="location.href='CategoriaInicio';" type="submit">Iniciar Sesión</button>
           <button onclick="location.href='CategoriaRegistro';" type="submit">Registrarse</button>
        </div>
    </nav>
<div class="usuario">
    <img src="<%= session.getAttribute("Foto")%>" width="200" height="200">
        <%  if (session.getAttribute("username") != null) {%>
      <input type="text" id="user" name="user" value="<%= session.getAttribute("username")%>"  readonly><br><br>
          <button id = "perfil" onclick="location.href='Perfil.jsp';" type="submit">Mi Perfil</button>
    <% }else{%>
 <input type="text" id="user" name="user" value="Invitado" readonly><br><br>
<%}%>
     
   
</div>
    <div class="Cartas">
 <div class=" Pregunta card" style="width: 950px;">
        
        <div class="card-body">  
        
          <h5 class="card-title"><b>Pregunta: </b> <%= preguntas.getPregunta()%>
          <img src="<%= preguntas.getImagePath()%>" class="card-img-top" width="400" height="200">
          <p class="card-text">Descripción: <%= preguntas.getDescription()%></p>
          <p class="card-text">Categoría: <%= preguntas.getCategory().getName()%> </p>
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
                 </div>
        </div>
      </div>
      <br>

      <div class=" RespuestaC card" style="width: 950px;">
        
        <div class="card-body">  
        
          <h5 class="card-title"><b>Respuesta Correcta: </b> <img src="" class="card-img-top" width="400" height="200"></h5>
       
          <p class="card-text">Fecha:  </p>
          <p class="card-text"><img src="..." class="fotouser" width="50" height="50"> Usuario: </p>
        
          <div class="puntuacion">
            <p>
            <b> Puntuación:</b>  
            <b> Útil:</b> 
            <b> No útil:</b>
          
            </p>
                <i class="Like fas fa-thumbs-up"></i>
                <i class="Unlike fas fa-thumbs-down"></i>
        
                <br>
                <br>
                 </div>
        </div>
      </div>
      <br>
         
          <%    if(respuestas!=null)
              for(Respuestas respuesta: respuestas){%>
            
      <div class=" Respuestas card" style="width: 950px;">
        
        <div class="card-body">  
        
          <h5 class="card-title"><b>Respuesta: </b><%= respuesta.getRespuesta()%> <img src="<%= respuesta.getImagePath()%>" class="card-img-top" width="400" height="200"></h5>
       
          <p class="card-text">Fecha:  <%= respuesta.getFecha()%></p>
          <p class="card-text"><img src="<%= respuesta.getUser().getUrlImage()%>" class="fotouser" width="50" height="50"> Usuario: <%= respuesta.getUser().getUsername()%></p>
        
          <div class="puntuacion">
            <p>
            <b> Puntuación:</b>  
            <b> Útil:</b> 
            <b> No útil:</b>
          
            </p>
                <i class="Like fas fa-thumbs-up"></i>
                <i class="Unlike fas fa-thumbs-down"></i>
        
                <br>
                <br>
                 </div>
        </div>
      </div>
      <br>
        <%}%>     
</div>
     
      </div>
      <%  if (session.getAttribute("username") != null) {%> 
        
          <form method="POST" action="RespuestasController" enctype="multipart/form-data">
                <div class="Comentario mb-3">
                    <input type="hidden" name="IdPregunta" value="<%=preguntas.getId()%>">
                       
        <label for="exampleFormControlTextarea1" class="txt form-label">Tu Respuesta</label>
        <textarea name="Respuesta"class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
        <input type="file" name="archivo"id="archivo">
                   <input type="submit" value="Responder">
      </div>
                </form>  
<% }else{%>
      <h1> Inicia Sesión y responde la pregunta</h1>
       <button id = "publicar" onclick="location.href='CategoriaInicio';" type="submit">Registrate</button>
     <%}%>
</body>
<script src="Boostrap/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
</html>