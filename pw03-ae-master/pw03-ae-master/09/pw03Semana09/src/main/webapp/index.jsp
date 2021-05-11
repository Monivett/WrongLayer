<%-- 
    Document   : index
    Created on : 29/10/2020, 08:01:38 PM
    Author     : magoc
--%>

<%@page import="com.pw.pw03semana09.models.Card"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Casting implicito no se puede usar asi
    // Hacer uso de casting explicito
    String titulo = (String) request.getAttribute("titulo");
    List<Card> cards = (List<Card>) request.getAttribute("cards");
    titulo = titulo != null ? titulo : "";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi Primer JSP</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="MainServlet">Link</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Dropdown
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                    </li>
                </ul>
                <%
                    if (1 == 1) {
                %>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="User" >
                    <input class="form-control mr-sm-2" type="password" placeholder="password">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
                </form>
                <%
                } else {
                %>
                <img width="30px" src="https://cdnb.artstation.com/p/assets/images/images/030/996/495/large/laura-peltomaki-ahsoka-full.jpg?1602264426"/> Jose
                <%
                    }
                %>
            </div>
        </nav>
        <div class="container">
            <h1>Hello World!</h1>
            <h2><%= titulo%></h2>
            <div class="row">
                <h2 class="col-12">Cards</h2>
                <%
                    if (cards != null) {
                        for (Card card : cards) {
                %>
                <div class="card col-4">
                    <img src="<%= card.getImgUrl()%>" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title"><%= card.getTitle()%></h5>
                        <p class="card-text"><%= card.getDescription()%></p>
                        <a href="<%= card.getLinkRef()%>" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
                <%
                        }
                    }
                %>
                <h2 class="col-12">For</h2>
                <%
                    for (int i = 0; i < 3; i++) {
                %>
                <!--<p>Categoria </p>-->
                <div class="card col-4">
                    <img src="https://cdnb.artstation.com/p/assets/images/images/030/784/057/large/fernando-estrela-fernando-estrela-crash-001.jpg?1601639297" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Crash Bandicoot</h5>
                        <p class="card-text">Hey guys! Today is a great day for the fans of this incredible character. Today is out his new game Crash Bandicoot 4: It's about time! Here is my FanArt version of this new design.</p>
                        <a href="https://www.artstation.com/artwork/48yDg8" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
                <%
                    }
                %>
                <h2 class="col-12">Noticias por aprobar</h2>
                <table class="col-12 table">
                    <tr>
                        <th>Titulo</th>
                        <th>Descripcion</th>
                        <th>Imagen</th>
                        <th>Link</th>
                        <th>Accion</th>
                    </tr>
                    <%
                        if (cards != null) {
                            for (Card card : cards) {
                    %>
                    <tr>
                        <td><%= card.getTitle()%></td>
                        <td><%= card.getDescription()%></td>
                        <td><%= card.getImgUrl()%></td>
                        <td><%= card.getLinkRef()%></td>
                        <td>
                            <a class="btn">Ver</a>
                            <a class="btn btn-success">Aprobar</a>
                            <a class="btn btn-danger">Eliminar</a>
                        </td>
                    </tr>
                    <div class="card col-4">
                        <img src="<%= card.getImgUrl()%>" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title"><%= card.getTitle()%></h5>
                            <p class="card-text"><%= card.getDescription()%></p>
                            <a href="<%= card.getLinkRef()%>" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                    <%
                            }
                        }
                    %>
                </table>
            </div>
            <!--            <p>Categoria</p>
                        <p>Categoria</p>
                        <p>Categoria</p>
                        <p>Categoria</p>
                        <p>Categoria</p>-->
        </div>
    </body>
</html>
