<%@page import="entidad.categorias"%>
<%@page import="datos.CategoriasDao"%>
<%@page import="datosImpl.CategoriasImpl"%>
<%@page import="negocioImpl.CategoriasNegImpl"%>
<%@page import="negocio.CategoriasNeg"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="EstilosCargarPosteos.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open Sans">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<jsp:include page="MasterPage1.jsp"></jsp:include>
<style>
h1,h2,h3,h4,h5,h6 {font-family: "Oswald"}
body {font-family: "Open Sans"}
</style>
</head>
         
<body>

<form method="post" action="EditCategoriasServlet" >

<% 
categorias catAmodificar = new categorias();
catAmodificar = (categorias)request.getAttribute("Categoria");
%>
		
<div class="cargarPosteos">
      <!-- Subscribe -->
      <div class="w3-white w3-margin">
        <div class="w3-container w3-padding w3-black">
          <h4>Seleccione una categoria para editar</h4>
        </div>
        <div class="w3-container w3-white">
        
        <p>Completa los cambios y presiona aceptar</p>
        
          <p><input class="w3-input w3-border" id="txtCat" name="txtIdCat" type="text" value="<%=catAmodificar.getCategoriaId() %>" placeholder="Ingresa la categoria" style="width:100%" required></p>
          <p><input class="w3-input w3-border" id="txtCat" name="txtNombreCat" type="text" value="<%=catAmodificar.getCategoriaNombre() %>" placeholder="Ingresa la categoria" style="width:100%" required></p>
          
          <select class="w3-input w3-border" name="comboCate" placeholder="Ingresa una categoria para tu posteo" style="width:100%">
          <%if (catAmodificar.getCategoriaEstado()==1) 
          {%>
          <option value ="1">Activo</option>
          <option value ="0">Inactivo</option>
          <%}
          else {%>
          <option value ="0">Inactivo</option>
          <option value ="1">Activo</option>
          <%}%>
			</select>
                    <p> </p>
          <input type="submit" name="btnEditarC" value="Completar" onclick="document.getElementById('subscribe').style.display='block'" class="w3-button w3-block w3-red">
        
        </div>

      </div>

    </div>
  
  </form>
  
</body>
</html>