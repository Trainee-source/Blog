<%@page import="entidad.usuarios"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inconsolata">
<style>
body, html {
  height: 100%;
  font-family: "Inconsolata", sans-serif;
}

.menu {
  display: none;
}

.lblUsuario
{
  position: relative;
  top: 55px;
  left: 1100px;
  font-family: Arial;
}
</style>
</head>




<body>

<form method="get" action="servletMasterPage">

<!-- MENU BARRA -->
<div class="w3-top">
  <div class="w3-row w3-padding w3-black">
    <div class="w3-col s3">
      <input name="btnInicio" type="submit" value="INICIO" class="w3-button w3-block w3-black" >
    </div>
    <div class="w3-col s3">
      <input name="btnPostea!" type="submit" value="POSTEA!" class="w3-button w3-block w3-black" >
    </div>
    <div class="w3-col s3">
      <input name="btnExplora" type="submit" value="EXPLORA" class="w3-button w3-block w3-black" >
    </div>
    <div class="w3-col s3">
      <input name="btnPerfil" type="submit" value="PERFIL" class="w3-button w3-block w3-black" >
    </div>
  </div>
</div>

<%if(session.getAttribute("Usuario") != null){%>

<div class="lblUsuario">
<%usuarios user1 = new usuarios();%>
<%user1 = (usuarios) session.getAttribute("Usuario");%>
<a><%=user1.getUsuarioNombre()%></a><a href="servletMasterPage?Param">[Salir]</a>
</div>
<%} %>


</form>





</body>
</html>