<%@page import="java.util.Arrays"%>
<%@page import="entidad.categorias"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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

<form method="post" action="CategoriasBuscar">


<%--DECLARACIONES --%>

	<%ArrayList<categorias> lista2 = (ArrayList<categorias>)request.getAttribute("listaBusqueda");%>

	<%ArrayList<categorias> lista = (ArrayList<categorias>)request.getAttribute("CategoriasPagina");%>
 
	<%
	int paginas = (int)request.getAttribute("NumeroPaginas"); 
	int current = (int)request.getAttribute("PaginaAhora");
	int fromIndex = (current - 1) * 5;
	int toIndex = (current * 5);
	List<categorias> paginacion = lista.subList(fromIndex, toIndex);
	%>

<div class="botonBuscar">
<!-- Subscribe -->
      <div class="w3-white w3-margin">
        <div class="w3-container w3-padding w3-black">
          <h4>Buscar la categoria que desees editar</h4>
        </div>
        <div class="w3-container w3-white">
          <p>Ingresa lo que queres buscar</p>
          <p><input class="w3-input w3-border" name="txtBusquedaC" type="text" placeholder="Busca" style="width:100%"></p>
          <input type="submit" name="btnBuscar2" value="Buscar" class="w3-button w3-block w3-red">
        </div>
      </div>
      </div>
<%
if (paginacion !=null)
   { 
	  int i;
	  for(categorias p : paginacion)
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
          <h3><a href="EditCategoriasServlet?Param=<%=i%>">Editar   </a> |   Categoria :   <%= p.getCategoriaNombre()%> | Estado : <%if (p.getCategoriaEstado() == 1){%>Activo<%} else %>Inactivo %></h3>
          

        </div>
      </div>
      <hr>

    </div>
     
    </div>

    <%} %>
    <% } %>
     <div class= "paginacion">
  <div class="w3-center w3-padding-32">
    <div class="w3-bar">
    <%if (current!= 1){ %>
      <a href="CategoriasBuscar?Param=<%=current - 1%>" class="w3-bar-item w3-button w3-hover-black">«</a>
      <%} %>
      <%for (int pag = 1; pag <= paginas; pag++) {%>
      		<a  class="w3-bar-item w3-button w3-hover-black"><%=pag%></a>
      <%} %>
      <%if (current != paginas){ %>
      <a href="CategoriasBuscar?Param=<%=current + 1%>" class="w3-bar-item w3-button w3-hover-black">»</a>
      <%} %>
    </div>
  </div>
  </div>
  
</form>

</body>


</html>