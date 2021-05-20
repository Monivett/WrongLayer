<%-- 
    Document   : Perfil
    Created on : 13/05/2021, 09:33:32 AM
    Author     : monic
--%>
<%@page import="com.wl.WrongLayer.models.NOutil"%>
<%@page import="com.wl.WrongLayer.models.User"%>
<%@page import="com.wl.WrongLayer.models.Favorito"%>
<%@page import="com.wl.WrongLayer.models.Util"%>
<%@page import="com.wl.WrongLayer.models.Respuestas"%>
<%@page import="com.wl.WrongLayer.models.Pregunta"%>
<%@page import="com.wl.WrongLayer.models.Categoria"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     List<Categoria> categorias = (List<Categoria>)request.getAttribute("Categories");
     List<Pregunta> preguntas = (List<Pregunta>)request.getAttribute("preguntas");
     List<Respuestas> respuestas = (List<Respuestas>)request.getAttribute("respuestas");
      List<Pregunta> preguntaT = (List<Pregunta>)request.getAttribute("preguntastodas");
     
      List<Util> util = (List<Util>)request.getAttribute("util");
       List<NOutil> NOutil = (List<NOutil>)request.getAttribute("NOutil");
     List<Favorito> fav = (List<Favorito>)request.getAttribute("fav");//FAVORITO QUE MARCÓ EL USUARIO
      User user =(User)request.getAttribute("usuario");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
    <link rel="shortcut icon" href="IMG/Logo.png" type="image/x-icon">
    <link rel="stylesheet" href="CSS/Perfil_1.css">
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
       <form id="BTN_CerrarSession" action ="PreguntasPrincipal" method="POST">
                    <button onclick="location.href='PreguntasPrincipal';" type="submit">Cerrar Sesión</button>
             </form>
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
                <br>
                 <h5 class="card-title"><b>Pregunta: </b>  <%= pregunta.getPregunta()%> 
                     <p hidden>
                         
                         <%= pregunta.getId()%>
                     </p>
                    
                   
                 <img src="<%= pregunta.getImagePath()%>" class="card-img-top" width="400" height="200"></h5>
                 <p class="card-text"> <b>Descripción: </b><%= pregunta.getDescription()%>
                  
                  </p>
                  <p class="card-text"><b>Categoría: </b> <%= pregunta.getCategory().getName()%> 
                   
                  
                 </p>
                 <p class="card-text"><b>Fecha: </b>     <%= pregunta.getFecha()%></p>
                 <p class="card-text"><img src="<%= session.getAttribute("Foto")%>" class="fotouser" width="50" height="50"> <b>Usuario: </b><%= session.getAttribute("username")%></p>
                 
                 <div class="puntuacion">
              
           
                       <input type="file" id ="FOTOPREG" style="display: none;" >
                     
                          <% if(pregunta.isModificada()== true){%>
                          <p>Esta pregunta fue editada</p>
                                <%}%>
                                  <br>
                               
                            <button onclick="location.href='EditarPreguntaController?id=<%= pregunta.getId()%>';" type="submit">Editar</button>
                            <br>
                <form action="EliminarPregunta" method="POST" " >
                        <input type="text" name="IDO" id="ID" value="<%= pregunta.getId()%>" style="display: none;" >   
                            <script>
                                    
                            function alerta() { //Alerta para el botón de borrar
   
                             var opcion = confirm("¿Está seguro de que quiere borrar la pregunta?");
                             if (opcion === true) {
        
                             window.location='EliminarPregunta?id=<%= pregunta.getId()%>'; 
                            } 	
                           };
                            </script>
                              <input type="hidden" name="user" id="ID" value="<%= session.getAttribute("ID_Usuario")%>" >   
                            <button id="BTNBORRARPREG"onclick="alerta()" type="submit">Borrar</button>
                       </form> 
                            <br>
                                <button onclick="location.href='VerPreguntaController?id=<%= pregunta.getId()%>';" type="submit">Ver</button>
                        </div>
                        <br>
               </div>
               
             </div>
             <br>
                <%}%>
                 <%}%>
          
        
                <%
                                  
                                if(respuestas!=null)
                                for(Respuestas respuesta: respuestas){%> 
                                    <% if(respuesta.isEliminada()== true){%>
                                      <h8>Esta respuesta fue Eliminada</h8>
                          <br>
                                <%}else{%>
                                <br>
             <div class=" Respuestas card" style="width: 790px;">
               
               <div class="card-body">  
               <h1>Respuestas hechas</h1>
                <h5 class="card-title"><b>Respuesta: </b> 
                      <p name="IDR"hidden>
                         
                         <%= respuesta.getId()%>
                     </p>
                     <p> <a name = "pregunta" href="VerPreguntaController?id=<%= respuesta.getPreguntas()%>"> <%= respuesta.getRespuesta()%> </p>
                    
                 <img src="<%= respuesta.getImagePath()%>" class="card-img-top" width="400" height="200"></h5>
              
                 <p class="card-text"><b>Fecha:</b>  <%= respuesta.getFecha()%> </p>
                 <p class="card-text"><img src="<%= session.getAttribute("Foto")%>" class="fotouser" width="50" height="50"> Usuario: </p>
               
                 <div class="puntuacion">
              
                <% if(respuesta.isModificada()== true){%>
                          <p>Esta respuesta fue editada</p>
                                <%}%>
                       <br>
                       <br>
                      
                         <input type="hidden" name="Respuesta" id="ID" value="<%= respuesta.getRespuesta()%>" >   
                        <button onclick="location.href='EditarRespuestaController?id=<%= respuesta.getId()%>';" type="submit">Editar</button>
                            <form action="EliminarRespuesta" method="POST" " >
                                  <input type="hidden" name="user" id="ID" value="<%= session.getAttribute("ID_Usuario")%>" >   
                        <input type="text" name="IDR" id="ID" value="<%= respuesta.getId()%>" style="display: none;" >   
                            <script>
                                    
                            function alerta2() { //Alerta para el botón de borrar
   
                             var opcion = confirm("¿Está seguro de que quiere borrar la respuesta?");
                             if (opcion === true) {
        
                             window.location='EliminarRespuesta?id=<%= respuesta.getId()%>'; 
                            } 	
                           };
                            </script>
                            <button onclick="alerta2()" type="submit">Borrar</button>
                       </form> 
                        </div>
               </div>
             </div>
                            
             <br>
                 <%}%>
                <%}%>
             
                          <%      
                                if(util!=null)                      
                                for(Util utilidad: util){   %>                                 
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
               
           
               </div>
         
                  
           
             </div>
     <%}%>
                 <%}%>
              <%}%>
          
                  <br> 
                                      <%      
                                if(NOutil!=null)                      
                                for(NOutil noutilidad: NOutil){                                 
                 %>  
            
                    <%  for(Pregunta preguntat: preguntaT){
                        if(noutilidad.getPregunta() ==preguntat.getId()) {%>
                         <div class=" PreguntasNOUtil card" style="width: 790px;">
                     <div class="card-body">  
                    <h1>Preguntas que marcó como NO Útiles</h1>
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
                
     
                 
                </div>
              </div>
            <br>
                 <%}%>
               
                    <%}%>
                    
                    <%}%>
                    <br>
       </div>
      
    <div id="usuarioFoto" class="usuario">
        <img src="<%= session.getAttribute("Foto")%>"  name="image" width="300" height="300">
    </div> 
    <input type="text" disabled id="user" name="ajio" value="<%= session.getAttribute("username")%> "  ><br><br>
      <!--INFO USUARIO-->
    <form action="EditarUsuarioController"class="InfoUser" id="FormEditar" method="POST" enctype="multipart/form-data"> 
        <h4>INFORMACIÓN DEL USUARIO</h4>
        <p>Nombre:
          <input type="text" value="<%= session.getAttribute("Nombre")%>"name="Nombre" id="Nombre" required onkeypress="return SoloLetras(event);"disabled >   
        </p>
       <p>Apellido: 
        <input type="text" value="<%= session.getAttribute("Apellido")%>"name="Apellido"  id="Apellido" required onkeypress="return SoloLetras(event);"disabled>
       </p>
        <p>Usuario
          <input type="text" value="<%= session.getAttribute("username")%>"name="NombreUsuario" id="NombreUsuario" required disabled  >   
        </p>
       <p>Correo:     
         <input type="email" value="<%= session.getAttribute("Correo")%>"name="Correo" id="Correo" required disabled>
       </p>
       <div id="Edad">
            <p>Edad:
            <input type="text" value="<%= session.getAttribute("Edad")%>"name="Edad"  id="Edad" required disabled>
        </p>
       </div>
       <div id="Fecha">
        <p>Fecha de Nacimiento:
        <input type="date" name="FechaNac"  value="<%= session.getAttribute("FechaNac")%>"id="FechaNac" required >
        <p class="ErrorFecha" id="ErrorFecha">La fecha NO debe ser después de la actual </p>
    </p>
   </div>
       <% Object estado = Integer.valueOf(1);
          if( estado == session.getAttribute("Estado")){
       %>
       
       <p>Usuario: Activo </p>
<%} else{%>
  <p>Usuario: Suspendido </p>
<%}%>
   
       <div id="Ocultar">
        <p>Contraseña:
           <input type="password" value="<%= session.getAttribute("Contraseña")%>" name="contra" id="Contraseña"required >
           <p class="ErrorContra" id="ErrorContra">Contraseña débil: La contraseña debe de tener:Mayúsculas,
            minúsculas,números y signos especiales </p>
       </p>
       <p>Confirmar Contraseña:
        <input type="password"  value="<%= session.getAttribute("Contraseña")%>" name="Contraseña2" id="Contraseña2"required>
        <p class="ErrorContra2" id="ErrorContra2">Ambas contraseñas tienen que ser iguales</p>
    </p>
       <input type="hidden"  value="<%= session.getAttribute("ID_Usuario")%>" name="ID_Usuario" id="Contraseña2"required>
       <p>Foto:
        <input type="file" id="foto" name="image" required>
       </p>
       </div>
       <button type="submit" id="BTN_MODIFICAR">Editar Información</button>
    </form> 
    <button  id="BTN_EDITAR">Editar</button>
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