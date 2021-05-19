<%-- 
    Document   : EditarPreg
    Created on : 15/05/2021, 09:41:31 AM
    Author     : monic
--%>

<%@page import="com.wl.WrongLayer.models.Respuestas"%>
<%@page import="com.wl.WrongLayer.models.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="com.wl.WrongLayer.models.Pregunta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Pregunta preguntas = (Pregunta)request.getAttribute("preguntas");
    Respuestas respuestas = (Respuestas)request.getAttribute("respuestas");
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
            <img src="IMG/Logo.png" alt="" height="100" width="100">
        </div>
                    <form action = "NavegacionController" method = "POST" id = Nav>
                         <input type="text" name="navegacion" id="search" required><span class="barra"></span>
                        <label for="">Barra de Búsqueda</label>
                        </input>
                        <button onclick="location.href='NavegacionController';" id="nav"type="submit" style="display: none;"></button>
                    </form>
        <div class="botones">
             <button onclick="location.href='PreguntasPrincipal';" type="submit">PantallaPrincipal</button>
            <jsp:include page= "navbar.jsp"/>
            <button onclick="location.href='PantallaPrincipal.html';" type="submit">Busqueda Avanzada</button>
               <form id="BTN_CerrarSession" action ="PreguntasPrincipal" method="POST">
                    <button onclick="location.href='PreguntasPrincipal';" type="submit">Cerrar Sesión</button>
             </form>
        </div>
    </nav>
            
    <!--PREGUNTAS -->
    <%  if(preguntas!=null){%>
    
    <form action="EditarPreguntaController" method="POST"  enctype="multipart/form-data" id="Pregunta" >
       <div class="Cartas">
        <div class=" Pregunta card" style="width: 790px;">
               
               <div class="card-body">  
                <h1>Pregunta</h1>
                 <h5 class="card-title"><b>Pregunta: </b>
                    <input type="text" name="Pregunta" id="Pregunta" value="<%= preguntas.getPregunta()%> "required  >   
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
                 
   
                       &nbsp<input type="file" name="image" >
                       <br>
                       <br>
                       <button  id="BTN_EDITARPREG" type="submit">Editar</button>
             
               </div>
               
             </div>

     
    </form>         
           
                      </div>   
  
    <%}%>
        <!--RESPUESTAS -->
    <%  if(respuestas!=null){%>
    
    <form action="EditarRespuestaController" method="POST"  enctype="multipart/form-data" id="Pregunta" >
       <div class="Cartas">
        <div class=" Pregunta card" style="width: 790px;">
               
               <div class="card-body">  
                <h1>Pregunta</h1>
                 <h5 class="card-title"><b>Respuesta: </b>
                    <input type="text" name="Respuesta" id="Respuesta" value="<%= respuestas.getRespuesta()%> "  >   
                 <img src="<%= respuestas.getImagePath()%>" class="card-img-top" width="400" height="200"></h5>
               
                    <input type="hidden" name="ID" id="ID" value="<%= respuestas.getId()%>" >   
        
                 <p class="card-text">Fecha:  <%= respuestas.getFecha()%></p>
                  <p class="card-text"><img src="<%= respuestas.getUser().getUrlImage()%>" class="fotouser" width="50" height="50"> Usuario: <%= respuestas.getUser().getUsername()%> </p>
                 
                      &nbsp  <input type="file" name="image" >
                       <button  id="BTN_EDITARRESP" type="submit">Editar</button>
                   
               </div>
               
             </div>

       </div>   
    </form>
  
    <%}%>
       

    <div id="usuarioFoto" class="usuario">
       <img src="<%= session.getAttribute("Foto")%>" width="300" height="300">
    </div> 
 <input id="user" value="<%= session.getAttribute("username")%>" disabled>
  <button  class="BTN_PERFIL" onclick="location.href='VerUsuarioPreguntaController?id=<%= session.getAttribute("ID_Usuario")%>';" type="submit">Mi perfil</button> 



    <footer>
        <h4> <b>Categorias: </b></h4>
        <br>
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
