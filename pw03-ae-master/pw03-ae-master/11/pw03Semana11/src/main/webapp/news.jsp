<%-- 
    Document   : news
    Created on : 26/11/2020, 07:20:20 PM
    Author     : magoc
--%>
<%@page import="com.pw.pw03semana11.models.Commentary"%>
<%@page import="java.util.List"%>
<%@page import="com.pw.pw03semana11.models.News"%>
<%
    News element = (News) request.getAttribute("New");
    List<Commentary> commentaries = (List<Commentary>) request.getAttribute("Commentaries");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>News</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="assets/css/main.css">
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">
            <div class="row">
                <h1 class="col-12"><%= element.getTitle()%></h1>
                <small class="text-muted col-12">Categoria: <%= element.getCategory().getName()%></small>
                <div id="carouselExampleControls" class="carousel slide col-12" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="<%= element.getImagePath()%>" class="d-block w-100" alt="...">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
                <article class="col-12">
                    <p>
                        <%= element.getDescription()%>
                    </p>
                </article>
                <div class="col-12 commentary">
                    <h2>Comentarios</h2>
                    <form method="POST" action="CommentaryController">
                        <div class="form-group">
                            <label for="content">Comentario</label>
                            <textarea class="form-control" name="content" id="content"></textarea>
                            <input type="hidden" name="idNew" value="<%= element.getId()%>">
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-success" value="Comentar">
                        </div>
                    </form>
                    <div class="comments-container">
                        <%
                            for (Commentary commentary : commentaries) {
                        %>
                        <div class="media">
                            <%
//                                if((int)session.getAttribute("rol") == 4){
                            %>
                            <a class="btn btn-danger" href="DeleteCommentaryController?id=<%= commentary.getId() %>&idNew=<%= element.getId() %>">Eliminar</a>
                            <%
//                                }
                            %>
                            <img src="https://cdna.artstation.com/p/assets/images/images/031/378/590/4k/sixmorevodka-studio-shyvana-human.jpg?1603443851" class="mr-3" alt="...">
                            <div class="media-body">
                                <h5 class="mt-0"><%= commentary.getUser().getUserName()%></h5>
                                <%= commentary.getContent()%>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
