<%@page import="entidad.usuarios"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="EstilosRegister.css" rel="stylesheet" type="text/css">
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
<%usuarios userRecibido = new usuarios(); %>
<%userRecibido = (usuarios)request.getAttribute("llevarUsuariosModificar"); %>


<form method= "get" action= "EditarPerfil">

<div class="cuadradoSubscripcion">

      <!-- Subscribe -->
      <div class="w3-white w3-margin">
        <div class="w3-container w3-padding w3-black">
          <h4>Edita</h4>
        </div>
        <div class="w3-container w3-white">
          <p><input class="w3-input w3-border" type="email" name="txtMail" value="<%=userRecibido.getUsuarioMail()%>" style="width:100%" required></p>
          
          <p><input class="w3-input w3-border" type="text" onkeypress="return (event.charCode > 64 && 
event.charCode < 91) || (event.charCode > 96 && event.charCode < 123)" value="<%=userRecibido.getUsuarioNombre()%>" name="txtNombre" style="width:100%" required></p>
          
          <p><input class="w3-input w3-border" type="text" onkeypress="return (event.charCode > 64 && 
event.charCode < 91) || (event.charCode > 96 && event.charCode < 123)" value="<%=userRecibido.getUsuarioApellido()%>" name="txtApellido" style="width:100%" required></p>
          
          <p><input class="w3-input w3-border" type="text" name="txtPassword" value="<%=userRecibido.getUsuarioContraseña()%>" style="width:100%" required></p>
          
          <p><input class="w3-input w3-border" type="text" name="txtPassword" value="<%=userRecibido.getUsuarioContraseña()%>" style="width:100%" required></p>
          
          <input type="submit" name="btnConfirmarEditar" value="Editar"  class="w3-button w3-block w3-red">
        </div>
      </div>

</div>



</form>

</body>
</html>