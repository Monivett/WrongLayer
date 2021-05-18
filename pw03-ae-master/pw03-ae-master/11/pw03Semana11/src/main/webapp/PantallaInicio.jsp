<%-- 
    Document   : PantallaInicio
    Created on : 8/05/2021, 10:41:37 AM
    Author     : monic
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
    <title>Iniciar Sesión</title>
    <link rel="shortcut icon" href="IMG/Logo.png" type="image/x-icon">
    <link rel="stylesheet" href="CSS/PantallaInicio_1_1_1.css">
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
        <button onclick="location.href='PantallaInicio.html';" type="submit">Búsqueda Avanzada</button>
    <button onclick="location.href='CategoriaRegistro';" type="submit">Registrarse</button>
    </div>
</nav>
     <div class="logoFORMS">
    <img src="IMG/LogoWrongLayer.png" alt="" height="150" width="150">
  </div>
    <form action="LogInController" method="POST" id="form">  
 
    <div class="form">
      
        <h1>Iniciar Sesión</h1>
        <div class="grupo">
            <input type="text" name="usuario" id="nombre" required><span class="barra"></span>
            <label for="">Nombre de Usuario</label>
        </div>
        <div class="grupo">
            <input type="password" name="password" id="contra" required><span class="barra"></span>
            <label for="">Contraseña</label>
        </div>
        <button type="submit" id ="Entrar">Entrar</button>
        
   
    </div> 
  
</form>
 
</body>
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

</html>