<%-- 
    Document   : Perfil
    Created on : 13/05/2021, 09:33:32 AM
    Author     : monic
--%>
<%@page import="com.wl.WrongLayer.models.Respuestas"%>
<%@page import="com.wl.WrongLayer.models.Pregunta"%>
<%@page import="com.wl.WrongLayer.models.Categoria"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     List<Categoria> categorias = (List<Categoria>)request.getAttribute("Categories");
     List<Pregunta> preguntas = (List<Pregunta>)request.getAttribute("preguntas");
       List<Respuestas> respuestas = (List<Respuestas>)request.getAttribute("respuestas");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
    <link rel="shortcut icon" href="IMG/Logo.png" type="image/x-icon">
    <link rel="stylesheet" href="CSS/Perfil.css">
    <link rel="stylesheet" href="Boostrap/css/bootstrap.min.css">
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
            <button onclick="location.href='PreguntasPrincipal';" type="submit">Pantalla Principal</button>
            <select>
                <option>Categoría 1</option>
                <option>Categoría 2</option>
                <option>Categoría 3</option>
                <option>Categoría 4</option>
                <option>Categoría 5</option>
            </select>
            <button onclick="location.href='PantallaInicio.html';" type="submit">Búsqueda Avanzada</button>
       
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
                 <h5 class="card-title"><b>Pregunta: </b> 
                     <p hidden>
                         
                         <%= pregunta.getId()%>
                     </p>
                    
                    <input type="text" value=" <%= pregunta.getPregunta()%>"name="Pregunta" id="Pregunta" disabled >   
                 <img src="<%= pregunta.getImagePath()%>" class="card-img-top" width="400" height="200"></h5>
                 <p class="card-text"> Descripción:
                    <input type="text" value=" <%= pregunta.getDescription()%>" name="Descripcion" id="Descripcion" disabled >   
                  </p>
                 <p class="card-text">Categoría:  
                     <select id="Categoría"disabled>
                         <option>
                             <%= pregunta.getCategory().getName()%>
                         </option>
                     </select>
                  
                 </p>
                 <p class="card-text">Fecha:     <%= pregunta.getFecha()%></p>
                 <p class="card-text"><img src="<%= session.getAttribute("Foto")%>" class="fotouser" width="50" height="50"> Usuario: </p>
                 
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
                       <input type="file" id ="FOTOPREG" style="display: none;" >
                     
                          <% if(pregunta.isModificada()== true){%>
                          <p>Esta pregunta fue editada</p>
                                <%}%>
                                  <br>
                            <button onclick="location.href='EditarPreguntaController?id=<%= pregunta.getId()%>';" type="submit">Editar</button>
                            <script>
                                    
                            function alerta() { //Alerta para el botón de borrar
   
                             var opcion = confirm("¿Está seguro de que quiere borrar la pregunta?");
                             if (opcion === true) {
        
                             window.location='EliminarPregunta?id=<%= pregunta.getId()%>'; 
                            } 	
                           };
                            </script>
                            <button onclick="alerta()">Borrar</button>
                            
                        </div>
               </div>
               
             </div>
             <br>
                <%}%>
             <%}%>
       
                <%
                                  
                                if(respuestas!=null)
                                for(Respuestas respuesta: respuestas){%> 
             <div class=" Respuestas card" style="width: 790px;">
               
               <div class="card-body">  
                <h1>Respuestas hechas</h1>
                <h5 class="card-title"><b>Respuesta: </b> 
                    <input value="<%= respuesta.getRespuesta()%>" type="text" name="Respuesta" id="Respuesta" disabled >   
                 <img src="<%= respuesta.getImagePath()%>" class="card-img-top" width="400" height="200"></h5>
              
                 <p class="card-text"><b>Fecha:</b>  <%= respuesta.getFecha()%> </p>
                 <p class="card-text"><img src="<%= session.getAttribute("Foto")%>" class="fotouser" width="50" height="50"> Usuario: </p>
               
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
                       <button  id="BTN_EDITARRESP">Editar</button>
                        </div>
               </div>
             </div>
             <br>
                 <%}%>
             <div class=" PreguntasUtil card" style="width: 790px;">
               
               <div class="card-body">  
                <h1>Preguntas Útiles</h1>
                <h5 class="card-title"><b>Pregunta: </b> 
                    <input type="text" name="Pregunta" id="Pregunta" onkeypress="return SoloLetras(event);"disabled >   
                 <img src="" class="card-img-top" width="400" height="200"></h5>
                 <p class="card-text"> Descripción:
                    <input type="text" name="Descripcion" id="Descripcion" onkeypress="return SoloLetras(event);"disabled >   
                  </p>
              
                 <p class="card-text">Fecha:  </p>
                 <p class="card-text"><img src="..." class="fotouser" width="50" height="50"> Usuario: </p>
               
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
                       <button  id="BTN_EDITARUTIL">Editar</button>
                        </div>
               </div>
             </div>
             <br>
             <div class=" PreguntasNOUtil card" style="width: 790px;">
               
                <div class="card-body">  
                 <h1>Preguntas No Útiles</h1>
                 <h5 class="card-title"><b>Pregunta: </b> 
                    <input type="text" name="Pregunta" id="Pregunta" onkeypress="return SoloLetras(event);"disabled >   
                 <img src="" class="card-img-top" width="400" height="200"></h5>
                 <p class="card-text"> Descripción:
                    <input type="text" name="Descripcion" id="Descripcion" onkeypress="return SoloLetras(event);"disabled >   
                  </p>
               
                  <p class="card-text">Fecha:  </p>
                  <p class="card-text"><img src="..." class="fotouser" width="50" height="50"> Usuario: </p>
                
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
                         <button  id="BTN_EDITARINUTIL">Editar</button>
                </div>
              </div>
              <br>
              <div class=" PreguntasFAV card" style="width: 790px;">
               
                <div class="card-body">  
                 <h1>Preguntas Favoritas</h1>
                 <h5 class="card-title"><b>Pregunta: </b> 
                    <input type="text" name="Pregunta" id="Pregunta" onkeypress="return SoloLetras(event);"disabled >   
                 <img src="" class="card-img-top" width="400" height="200"></h5>
                 <p class="card-text"> Descripción:
                    <input type="text" name="Descripcion" id="Descripcion" onkeypress="return SoloLetras(event);"disabled >   
                  </p>
               
                  <p class="card-text">Fecha:  </p>
                  <p class="card-text"><img src="..." class="fotouser" width="50" height="50"> Usuario: </p>
                
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
                         <button  id="BTN_EDITARFAV">Editar</button>
                </div>
              </div>
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
       
       <p>Usuario:  <%=session.getAttribute("Estado") %>

       </p>
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

<footer>
    Categorias
</footer>
  

</body>
<script src="JAVASCRIPT/Perfil.js"></script>
<script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
<script src="Boostrap/js/bootstrap.min.js"></script>

</html>