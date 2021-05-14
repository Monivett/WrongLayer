<%-- 
    Document   : index
    Created on : 12/11/2020, 08:10:22 PM
    Author     : magoc
--%>

<%@page import="com.wl.WrongLayer.models.Pregunta"%>
<%@page import="com.wl.WrongLayer.models.User"%>
<%@page import="com.wl.WrongLayer.models.Categoria"%>


<%@page import="java.util.List"%>


<%/*
    List<Categorias> categorias = (List<Categorias>)request.getAttribute("Categorias");
    if(categorias!=null)
      for(Categorias categoria: categorias){*/%>  
     <!-- <option <//%=//categoria.getNombre()%>>
          
          
      </option>-->

<%
     List<Categoria> categorias = (List<Categoria>)request.getAttribute("Categories");
    List<Pregunta> preguntas = (List<Pregunta>)request.getAttribute("preguntas");
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
     
     <input type="text" id="user" name="user" value="<%= session.getAttribute("username")%>" value="<%= session.getAttribute("ID_Usuario")%>" readonly><br><br>
             <button id = "perfil" onclick="location.href='VerUsuarioPreguntaController?id=<%= session.getAttribute("ID_Usuario")%>';" type="submit">Mi perfil</button>                
   
</div>
            
                <form action="PreguntaController" method="POST" enctype="multipart/form-data" >
                  
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
                    <h4>Categorías</h4>
          </footer>
              </section>
        </body>
    </head>
   
</html>