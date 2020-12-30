<%@page import="entidad.posts"%>
<%@page import="entidad.categorias"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="negocio.CategoriasNeg"%>
<%@page import="negocioImpl.CategoriasNegImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="EstilosPosteos.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open Sans">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<jsp:include page="MasterPage1.jsp"></jsp:include>
</head>
<style>
h1,h2,h3,h4,h5,h6 {font-family: "Oswald"}
body {font-family: "Open Sans"}
</style>



<body>

<form method="get" action="ExplorarReportes">


<%--DECLARACIONES --%>
<% categorias Cats= new categorias(); %>
<%ArrayList<categorias> lista = (ArrayList) request.getAttribute("listReportesC");%>
<%ArrayList<categorias> lista2 = (ArrayList) request.getAttribute("listaReportesCBuscar");%>
<%CategoriasNeg CategoriasT = new CategoriasNegImpl();%>
 


<div class="botonBuscar">
<!-- Subscribe -->
      <div class="w3-white w3-margin">
        <div class="w3-container w3-padding w3-black">
          <h4>Buscar lo que desees</h4>
        </div>
        <div class="w3-container w3-white">
          <p>Ingresa las fechas desde cuando hasta cuando desea obtener los reportes</p>
          <p>Desde: <input class="w3-input w3-border" id="txtDesde" name="txtDesdeC" type="date" min="2018-01-01" max="2019-12-18" style="width:30%"> 
          Hasta:<input class="w3-input w3-border" id="txtHasta" name="txtHastaC" type="date"  min="2018-01-01" max="2019-12-19" style="width:30%"></p>
          <input type="submit" name="btnReportesCategorias" value="Buscar" class="w3-button w3-block w3-red">
        </div>
      </div>
</div>


<%if (lista2!=null)
   { 
	  int i;
	  lista = null;
	  String categoria;
	  for(categorias p : lista2)
	  {	
		  i = p.getCategoriaId();
		  %>
		  <div class="posteos">
<!-- Grid -->


    <!-- Blog entries -->
    <div class="w3-col l8 s12">
    
      <!-- Blog entry -->
      <div class="w3-container w3-white w3-margin w3-padding-large">
        <div class="w3-center">
          <h3><a href="PostsExplorar?Param=<%=i%>">Categoria :   <%= p.getCategoriaNombre()%></a> | Cantidad de Posts: <%= p.getCantidadPosts() %></h3>
          

        </div>
      </div>
      <hr>

    </div>
    </div>
    
<%}}%>




<%if (lista!=null)
   { 
	  int i;
	  String categoria;
	  for(categorias p : lista)
	  {	
		  i = p.getCategoriaId();
%>
<div class="posteos">
<!-- Grid -->


    <!-- Blog entries -->
    <div class="w3-col l8 s12">
    
      <!-- Blog entry -->
      <div class="w3-container w3-white w3-margin w3-padding-large">
        <div class="w3-center">
        
          <h3><a href="PostsExplorar?Param=<%=i%>">Categoria :   <%= p.getCategoriaNombre()%></a> | Cantidad de Posts: <%= p.getCantidadPosts() %></h3>
          

        </div>
      </div>
      <hr>

    </div>
    </div>
    
    <%} %>
    <% } %>

</form>

</body>


</html>