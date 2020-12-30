<%@page import="entidad.usuarios"%>
<%@page import="entidad.posts"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="EstilosPerfil.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<jsp:include page="MasterPage1.jsp"></jsp:include>
</head>

<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif}
</style>



<body class="w3-light-grey">

<form method="post" action="EditarPerfil">

<%--DECLARACIONES --%>
<% usuarios user1 = new usuarios(); %>
<% user1 = (usuarios) session.getAttribute("Usuario"); %>
<% ArrayList<posts> listaPosteosPublicados = (ArrayList) request.getAttribute("listPostsPublicados"); %>
 

<div class="Perfil">

<!-- Page Container -->
<div class="w3-content w3-margin-top" style="max-width:1400px;">

  <!-- The Grid -->
  <div class="w3-row-padding">
  
    <!-- Left Column -->
    <div class="w3-third">
    
      <div class="w3-white w3-text-grey w3-card-4">
        <div class="w3-display-container">
          <img src="<%=user1.getUsuarioUrlImagen() %>" style="width:50%" alt="Avatar">
          <%--
          <div class="w3-display-bottomleft w3-container w3-text-black">
            <h2><%= user1.getUsuarioNombre() %></h2>
          </div>
          --%>
        </div>
        
        <div class="w3-container">
          <p><i class="fa fa-briefcase fa-fw w3-margin-right w3-large w3-text-teal"></i><%= user1.getUsuarioNombre()%> <%= user1.getUsuarioApellido() %></p>
          <p><i class="fa fa-envelope fa-fw w3-margin-right w3-large w3-text-teal"></i><%= user1.getUsuarioMail() %></p>
          <p><i class="fa fa-times fa-fw w3-margin-right w3-large w3-text-teal"></i><%= user1.getUsuarioFecha() %></p>
          <hr>

          <div class="botonEditarPerfil">
          <input type="submit" name="btnEditarPerfil" value="Editar">
          </div>
          
          <%if(user1.getUsuarioTipo() == 2)
          {%>
        	  <div class="botonAgregarCategorias">
              <input type="submit" name="btnAgregarCategorias" value="Agregar Categoria">
              </div>
              
              <div class="botonAgregarCategorias">
              <input type="submit" name="btnEditarCategorias" value="Editar Categoria">
              </div>
              
              <div class="botonAgregarCategorias">
              <input type="submit" name="btnReportesPost" value="Reportes de Posts">
              </div>
              
              <div class="botonAgregarCategorias">
              <input type="submit" name="btnReportesCategorias" value="Reportes de Categorias">
              </div>
         <% } %>
          
                 
          <%--          
          <div class="botonEliminarPerfil">
          <input type="submit" name="btnEliminarPerfil" value="Eliminar">
          </div>
          --%>
          
          <br>
        </div>
      </div><br>
      
    <!-- End Left Column -->
    </div>






    <!-- Right Column -->
    <div class="w3-twothird">
    
      <div class="w3-container w3-card w3-white w3-margin-bottom">
      
        <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Tus Posteos</h2>
        
          <%if (listaPosteosPublicados !=null )
          {
        	  int i;
        	  for(posts p : listaPosteosPublicados)
        	  {
        		  i = p.getPostId();
          %>
        <div class="w3-container">
          <h5 class="w3-opacity"><a href="MostrarPostsServlet?Param=<%=i%>"> <%=p.getPostTitulo()%></a></h5>
          <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right"></i><%=p.getPostFecha()%><span class="w3-tag w3-teal w3-round">Post</span></h6>
          <p><%=p.getPostIntroduccion()%></p>
          <hr>
        </div>
        <%} %>
        <%} %>
        
      </div>


    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->
  </div>
  
  <!-- End Page Container -->
</div>

<footer class="w3-container w3-teal w3-center w3-margin-top">
  <p>Buscame en las redes sociales.</p>
  <i class="fa fa-facebook-official w3-hover-opacity"></i>
  <i class="fa fa-instagram w3-hover-opacity"></i>
  <i class="fa fa-snapchat w3-hover-opacity"></i>
  <i class="fa fa-pinterest-p w3-hover-opacity"></i>
  <i class="fa fa-twitter w3-hover-opacity"></i>
  <i class="fa fa-linkedin w3-hover-opacity"></i>
</footer>
    
    
    </div>
    
</form>

</body>
</html>