<%@page import="entidad.usuarios"%>
<%@page import="entidad.posts"%>
<%@page import="datos.PostsDao"%>
<%@page import="datosImpl.PostsImpl"%>
<%@page import="negocio.PostsNegocio"%>
<%@page import="negocioImpl.PostsNegocioImpl"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JNISIBLOG</title>

<link href="EstilosPaginaPrincipal.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open Sans">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<jsp:include page="MasterPage1.jsp"></jsp:include>

<script language="JavaScript"> 
function load(){ 
	<%String href = request.getParameter("page");
	int bandera = 0;
	if(href == null)
	{
		bandera = 1;
	}else
	{
		if(Integer.parseInt(href) == 2)
		{
			bandera = 2;
		}
	}
	
	
	%>
} 
</script> 
</head>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Karma", sans-serif}
.w3-bar-block .w3-bar-item {padding:20px}
</style>





<body onload="load()">
<%
		PostsNegocio PostT = new PostsNegocioImpl();
		//ArrayList<posts> lista = PostT.ObtenerDestacados();
%>

<div class="parteSuperior">
    <div class="fondoPrincipal">
       <div class="texto-logo">UT NOTICIAS</div>
    </div>
</div>







<div class="parteMedio">
<%
int pageid;
if(bandera == 1)
{
	pageid = 1;
	bandera = 0;
}else{
String spageid = request.getParameter("page");
pageid = Integer.parseInt(spageid);  
}
int total=5;

if(pageid==1){}  
else{  
    pageid=pageid-1;  
    pageid=pageid*total+1;  
}

List<posts> lista= PostT.getRecords(pageid,total);
%>
<!-- !PAGE CONTENT! -->
<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:100px">

  <!-- First Photo Grid-->
  <div class="w3-row-padding w3-padding-16 w3-center" id="food">
  <%if (lista!=null)
	  {
	  int i;
	  for(posts p : lista)
	  {	
	  		i = p.getPostId();%>
		      <div class="w3-quarter">
		      <img src="<%= p.getPostImagen() %>" style="width:30px">
		      <h3><a href="MostrarPostsServlet?Param=<%=i%>">  <%=p.getPostTitulo()%></a></h3>
		      <p><%= p.getPostIntroduccion() %></p>
		    	</div>
    <%} 
    }%>
 </div>
</div>

<%--
out.print("<table border='1' cellpadding='4' width='60%'>");  
out.print("<tr><th>Id</th><th>Name</th><th>Salary</th>");

for(posts p: lista){  
    out.print("<tr><td>"+p.getPostId()+"</td><td>"+p.getPostTitulo()+"</td><td>"+p.getPostIntroduccion()+"</td></tr>");  
}  
out.print("</table>");  
--%>  


 <!-- Pagination -->
  <div class= "paginacion">
  <div class="w3-center w3-padding-32">
    <div class="w3-bar">
     <a href="PaginaPrincipal.jsp?page=1" class="w3-bar-item w3-black w3-hover-black">1</a>  
     <a href="PaginaPrincipal.jsp?page=2" class="w3-bar-item w3-black w3-hover-black">2</a>  
     <a href="PaginaPrincipal.jsp?page=3" class="w3-bar-item w3-black w3-hover-black">3</a>
    </div>
  </div>
  </div>
  
</div>
















<div class="parteInferior">

<div class="tags">
<div class="w3-third w3-serif">
      <h3>TAGS POPULARES</h3>
      <p>
        <span class="w3-tag w3-black w3-margin-bottom">Turismo</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Computadoras</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Deportes</span>
        <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Autos</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Famosos</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Animales</span>
        <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Juegos</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Edificios</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Clima</span>
        <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Cocina</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Universidades</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Muebles</span>
        <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Pesca</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Libros</span>
      </p>
</div>
</div>

<div class="linkRedes">
<div class="w3-white w3-margin">
        <div class="w3-container w3-padding w3-black">
          <h4>Seguinos en nuestras redes</h4>
        </div>
        <div class="w3-container w3-xlarge w3-padding">
          <i class="fa fa-facebook-official w3-hover-opacity"></i>
          <i class="fa fa-instagram w3-hover-opacity"></i>
          <i class="fa fa-snapchat w3-hover-opacity"></i>
          <i class="fa fa-pinterest-p w3-hover-opacity"></i>
          <i class="fa fa-twitter w3-hover-opacity"></i>
          <i class="fa fa-linkedin w3-hover-opacity"></i>
        </div>
      </div>
</div>

</div>



</body>
</html>