<%-- 
    Document   : PerfilAjeno
    Created on : 17/05/2021, 04:15:11 PM
    Author     : monic
--%>

<%@page import="com.wl.WrongLayer.models.Favorito"%>
<%@page import="com.wl.WrongLayer.models.Util"%>
<%@page import="com.wl.WrongLayer.models.Respuestas"%>
<%@page import="com.wl.WrongLayer.models.User"%>
<%@page import="com.wl.WrongLayer.models.Categoria"%>
<%@page import="com.wl.WrongLayer.models.Pregunta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
      List<Categoria> categorias = (List<Categoria>)request.getAttribute("Categories");
     List<Pregunta> preguntas = (List<Pregunta>)request.getAttribute("pregunta");//PREGUNTA QUE HIZO EL USUARIO
      List<Pregunta> preguntaT = (List<Pregunta>)request.getAttribute("preguntas");
   
     List<Respuestas> respuesta = (List<Respuestas>)request.getAttribute("respuesta");
      List<Util> util = (List<Util>)request.getAttribute("util");
     List<Favorito> fav = (List<Favorito>)request.getAttribute("fav");//FAVORITO QUE MARCÓ EL USUARIO
      User user =(User)request.getAttribute("usuario");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuario ajeno</title>
    <link rel="shortcut icon" href="IMG/Logo.png" type="image/x-icon">
    <link rel="stylesheet" href="CSS/PerfilAjeno_1.css">
    <link rel="stylesheet" href="Boostrap/css/bootstrap.min.css">
</head>
<body>
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
        <div class="botones">
            <button onclick="location.href='PreguntasPrincipal';" type="submit">Pantalla Principal</button>
             <jsp:include page= "navbar.jsp"/>
            <button onclick="location.href='PantallaInicio.html';" type="submit">Búsqueda Avanzada</button>
            <%  if (session.getAttribute("username") != null) {%>
         <form id="BTN_CerrarSession" action ="PreguntasPrincipal" method="POST">
                    <button onclick="location.href='PreguntasPrincipal';" type="submit">Cerrar Sesión</button>
             </form>
         <%  }%>
        </div>
    </nav>
    <!--PREGUNTAS Y RESPUESTAS-->

        <div class="Cartas">
                 
                  <%
                                  
                                if(preguntas!=null)
                                for(Pregunta pregunta: preguntas){%> 
                                    <% if(pregunta.isEliminada()== true){%>
                          <h8>Esta pregunta fue Eliminada</h8>
                          <br>
                                <%}else{%>
                  <br>            
        <div class=" Pregunta card" style="width: 790px;">
               
               <div class="card-body">  
                  
                <h1>Preguntas hechas</h1>
   
               <a name = "pregunta" href="VerPreguntaController?id=<%= pregunta.getId()%>">  
                   <h5 class="card-title"><b>Pregunta: </b> <%= pregunta.getPregunta()%> 
               </a>
            
                
                 <img src="<%= pregunta.getImagePath()%>" class="card-img-top" width="400" height="200"></h5>
                 <p class="card-text"> <b>Descripción: </b><%= pregunta.getDescription()%>
                 
                  </p>
                  <p class="card-text"><b>Categoría: </b><%= pregunta.getCategory().getName()%>
                
                  
                 </p>
                 <p class="card-text">Fecha:     <%= pregunta.getFecha()%></p>
                 <p class="card-text"><img src="<%= user.getUrlImage()%>" class="fotouser" width="50" height="50"> Usuario: <%= pregunta.getUser().getUsername()%></p>
                 
                 <br>
               </div>
               
             </div>
             <br>
                <%}%>
                 <%}%>
             <br>
      
                             <%
                                  
                                if(respuesta!=null)
                                for(Respuestas respuestas: respuesta){%> 
                                    <% if(respuestas.isEliminada()== true){%>
                                      <h8>Esta respuesta fue Eliminada</h8>
                          <br>
                                <%}else{%>
                                <br>
             <div class=" Respuestas card" style="width: 790px;">
               
               <div class="card-body">  
               <h1>Respuestas hechas</h1>
                   <a name = "pregunta" href="VerPreguntaController?id=<%= respuestas.getPreguntas()%>">  
                   <h5 class="card-title"><b>Pregunta: </b> <%= respuestas.getRespuesta()%> 
               </a>
      
                 <img src="<%= respuestas.getImagePath()%>" class="card-img-top" width="400" height="200"></h5>
              
                 <p class="card-text"><b>Fecha:</b>  <%= respuestas.getFecha()%> </p>
                 <p class="card-text"><img src="<%= respuestas.getUser().getUrlImage()%>" class="fotouser" width="50" height="50"> Usuario: <%= respuestas.getUser().getUsername()%></p>
                 <br>
               
             <% if(respuestas.isModificada()== true){%>
                          <p>Esta respuesta fue editada</p>
                                <%}%>
               </div>
             </div>
                            
             <br>
                 <%}%>
                <%}%>
             <br>
                 <%      
                                if(util!=null)                      
                                for(Util utilidad: util){                                 
                 %>  
            
                    <%  for(Pregunta preguntat: preguntaT){
                        if(utilidad.getPregunta() ==preguntat.getId()) {%>
                         <div class=" PreguntasUtil card" style="width: 790px;">
                     <div class="card-body">  
                    <h1>Preguntas que marcó como Útiles</h1>
                       <a name = "pregunta" href="VerPreguntaController?id=<%= preguntat.getId()%>">  
                   <h5 class="card-title"><b>Pregunta: </b> <%=preguntat.getPregunta()%>
               </a>
                   
                             <img src="<%= preguntat.getImagePath()%>" class="card-img-top" width="400" height="200"></h5>
                             <p class="card-text"> <b>Descripción: </b><%= preguntat.getDescription()%> </p>
               
                  <p class="card-text"><b>Fecha: </b>  <%= preguntat.getFecha()%></p>
                       <a href="VerUsuarioAjeno?id=<%= preguntat.getUser().getId()%>">
               <p class="card-text"><img src="<%= preguntat.getUser().getUrlImage()%>" class="fotouser" width="50" height="50"> Usuario: <%= preguntat.getUser().getUsername()%> </p>
          </a>
                 <br>
               </div>
         
                 
         
             </div>
             <br>
                <%}%>
                 <%}%>
              <%}%>
              <br>
                   <%
                                  
                                if(fav!=null)                      
                                for(Favorito favo: fav){                                 
                 %>  
                   <%  for(Pregunta preguntat: preguntaT){
                        if(favo.getPregunta() ==preguntat.getId()) {%>
              <div class=" PreguntasFAV card" style="width: 790px;">
               
                <div class="card-body">  
                 <h1>Preguntas Favoritas</h1>
                         <a name = "pregunta" href="VerPreguntaController?id=<%= preguntat.getId()%>">  
                    <h5 class="card-title"><b>Pregunta: </b> <%=preguntat.getPregunta()%>
               </a>
                
                  
                 <img src="<%=preguntat.getImagePath()%>" class="card-img-top" width="400" height="200"></h5>
                 <p class="card-text"> <b>Descripción: </b><%=preguntat.getDescription()%></p>
   
                  <p class="card-text"><b>Fecha: </b><%=preguntat.getFecha()%>  </p>
                        <a href="VerUsuarioAjeno?id=<%= preguntat.getUser().getId()%>">
               <p class="card-text"><img src="<%= preguntat.getUser().getUrlImage()%>" class="fotouser" width="50" height="50"> Usuario: <%= preguntat.getUser().getUsername()%> </p>
          </a>
                
     
                    <br>     
                </div>
              </div>
                 
                       <br>  <%}%>
               
                    <%}%>
                    <%}%>
              <br>
       </div>

    <div id="usuarioFoto" class="usuario">
                  <%  if (session.getAttribute("username") != null) {%>
         <img src="<%= session.getAttribute("Foto")%>" width="300" height="300">
      <input type="text" id="user" name="user" value="<%= session.getAttribute("username")%>"  readonly><br><br>
         <button id = "perfil" onclick="location.href='VerUsuarioPreguntaController?id=<%= session.getAttribute("ID_Usuario")%>';" type="submit">Mi perfil</button>   
    <% }else{%>
    <img src="IMG/default.png" width="300" height="300">
 <input type="text" id="user" name="user" value="Invitado" readonly><br><br>
<%}%>
    </div> 
 
      <!--INFO USUARIO-->
    <div class="InfoUser" > 
        <h4>INFORMACIÓN DEL USUARIO</h4>

        <p>Usuario
            <%=user.getUsername()%>
        </p>
        <p>Foto de Usuario</p>
        <img src=" <%=user.getUrlImage()%>"  id="Fotousuario" width="200" height="200">
   
      </div> 
   

<section class="paginacion">
			<ul>
				<li><a href="pagina1.html" class="active">1</a></li>
				<li><a href="pagina2.html"><</a></li>
				<li><a href="pagina3.html">></a></li>
		
			</ul>
		</section>
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

</body>
<script src="JAVASCRIPT/Perfil.js"></script>
<script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
<script src="Boostrap/js/bootstrap.min.js"></script>

</html>
