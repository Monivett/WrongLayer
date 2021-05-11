<%-- 
    Document   : FormNews
    Created on : 19/11/2020, 07:39:39 PM
    Author     : magoc
--%>

<%@page import="com.wl.WrongLayer.models.Categoria"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
     List<Categoria> categorias = (List<Categoria>)request.getAttribute("Categories");
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
                        <button onclick="location.href='PantallaBusquedaAvanzada.html';" type="submit">Búsqueda Avanzada</button>
                                <select class="filtrocategoria">
                            <%
                                  
                                if(categorias!=null)
                                for(Categoria categoria: categorias){%>  
                                <option name ="Categorias" value ="<%=categoria.getId()%>">
                                             
                                  <%= categoria.getName()%>
                                   
                                </option>
                            <% } %> 
                            </select>
                        <button onclick="location.href='PantallaInicio.jsp';" type="submit">Iniciar Sesión</button>
                        <button onclick="location.href='Registro.html';" type="submit">Registrarse</button>
                   </div>
                </nav>
                <div class="usuario">
    
                    <input type="text" id="user" name="user" value="" readonly><br><br>
                    <div class ="usuarioFoto">

                    </div>
                    <button id = "perfil" onclick="location.href='Perfil.html';" type="submit">Mi Perfil</button>
                </div>
            
                   
            
            
                <form action="AddNews" method="POST" >
                  
                  <div class ="Quest">
                        <h1>¿Tienes una pregunta a la que no le encuentras respuesta? ¡Pregunta! </h1>
                        <p>Pregunta: </p>
                        <p>Descripcion: </p> 
                        <p>Categoría
                            <select class="filtrocategoria">
                                <option>Categoría 1</option>
                                <option>Categoría 2</option>
                                <option>Categoría 3</option>
                                <option>Categoría 4</option>
                                <option>Categoría 5</option>
                            </select>
                        </p>
                        <p>Imagen:</p>
        
                     <input type="text" name="title" id="pregunta" placeholder="Escribe tu pregunta" required>
                           <input type="text" name="descripcion" id="descripcion" placeholder="Danos un poco mas de informacion, explica con mas detalle tu duda">
               <input type="file" name="archivo" id="archivo">
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