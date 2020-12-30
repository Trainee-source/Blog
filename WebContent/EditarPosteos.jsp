<%@page import="entidad.categorias"%>
<%@page import="datos.CategoriasDao"%>
<%@page import="datosImpl.CategoriasImpl"%>
<%@page import="negocioImpl.CategoriasNegImpl"%>
<%@page import="negocio.CategoriasNeg"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.posts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
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
<form method="post" action="EditarPosts" >
		/////manejar primero al servlet, el servlet trae las categorias
		<%
		 CategoriasNeg Categorias = new CategoriasNegImpl();
		 ArrayList<categorias> lista = Categorias.ObtenerTodos();
		%>
		
		
		<%-- int id = (int) request.getAttribute("llevarIdPosteo"); --%>
		
<% posts posteo = new posts(); %>
<% posteo = (posts) request.getAttribute("postModif"); %>
		
<div class="cargarPosteos">
      <!-- Subscribe -->
      <div class="w3-white w3-margin">
        <div class="w3-container w3-padding w3-black">
          <h4>Edita tu posteo!!</h4>
        </div>
        <div class="w3-container w3-white">
        
          <p>Completa los campos y edita</p>
          
          <p><input class="w3-input w3-border" name="txtNombrePost" type="text" value="<%=posteo.getPostTitulo()%>" style="width:100%" required></p>
          
          <p><input class="w3-input w3-border" name="txtDescripcionPost" type="text" value="<%=posteo.getPostIntroduccion()%>" style="width:100%" required></p>
          
          <textarea name="txtTextoPost" cols="80" rows="10" spellcheck="true" required><%=posteo.getPostTexto()%></textarea>
          
          <p><input class="w3-input w3-border" name="linkImagen" value="<%=posteo.getPostImagen() %>" type="file" style="width:100%"></p>
          
          <select class="w3-input w3-border" name="comboCat"  style="width:100%">

         
          <%
          if (lista!=null)
          {
				for (categorias c : lista) 
					{
					if(c.getCategoriaId() == posteo.getPostCategoria())
					{
						%>
						<option value="<%=c.getCategoriaId()%>"><%=c.getCategoriaNombre()%></option>
						<%
					}
					}
				for (categorias c : lista) 
				{
					if(c.getCategoriaId() != posteo.getPostCategoria())
					{
					%>
					<option value="<%=c.getCategoriaId()%>"><%=c.getCategoriaNombre()%></option>
					<%
					}
				}
			}%>
			</select>
			
			
			
             <input type="hidden" name="datoEditar2" value="<%=posteo.getPostId()%>" />
             
          
          <input type="submit" name="btnEditar" value="Editar" class="w3-button w3-block w3-red">
        
        
             
        </div>

      </div>

    </div>

</form>

</body>
</html>