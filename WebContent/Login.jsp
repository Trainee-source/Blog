<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="EstilosLogin.css" rel="stylesheet" type="text/css">
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

<form method="post" action="SessionServlet">

<div class="cuadradoLogin">
      <!-- Subscribe -->
      <div class="w3-white w3-margin">
        <div class="w3-container w3-padding w3-black">
          <h4>Logeate</h4>
        </div>
        <div class="w3-container w3-white">
          <p><input name="txtMail" class="w3-input w3-border" type="text" placeholder="Ingresa tu mail" style="width:100%" required></p>
          <p><input name="txtPassword" class="w3-input w3-border" type="password" placeholder="Ingresa tu contraseña" style="width:100%" required></p>
          <input type="submit" name="btnLogear" value="Confirmar"  class="w3-button w3-block w3-red">
        </div>
      </div>

</div>

<div class="nuevoUsuario">

<a href="Register.jsp" target="self">Registrate</a>

</div>


<div class="cuadradoMensajes">
<%if (request.getAttribute("Verify") != null)
	{%>
	    
		El usuario ingresado es invalido.
		
	<%}
		else 
		{
			if (request.getAttribute("Insert") != null)
			{%>	
			
			    Se ha logeado con exito.
			    
			     <%
                   response.sendRedirect("PaginaPrincipal.jsp");
                 %>
			    
			<%
			} 
			
		}%>
</div>


</form>

</body>
</html>