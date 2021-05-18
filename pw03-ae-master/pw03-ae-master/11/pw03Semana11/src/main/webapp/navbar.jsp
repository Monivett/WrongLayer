<%-- 
    Document   : navbar
    Created on : 19/11/2020, 07:35:40 PM
    Author     : magoc
--%>



<%@page import="com.wl.WrongLayer.models.Categoria"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
     List<Categoria> categorias = (List<Categoria>)request.getAttribute("Categories");
%>

                        <select onChange="href=this.value name ="Categorias" id="Categorias">
                            <option> Categoria</option>
                              <%
                                  
                                if(categorias!=null)
                                for(Categoria categoria: categorias){%>  
                                <a href="VerPreguntaCategoria?id=<%=categoria.getId()%>" target="target">
                                <option value ="VerPreguntaCategoria?id=<%=categoria.getId()%>">
                                             
                                  <%= categoria.getName()%>
                                   </a>
                                </option>
  
                            <% } %> 
                            
                   
                        </select>
 <script>
    document.getElementById("Categorias").onchange = function() {
        if (this.selectedIndex!==0) {
            window.location.href = this.value;
        }        
    };
</script>