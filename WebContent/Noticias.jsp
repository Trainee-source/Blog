<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="EstilosNoticias.css" rel="stylesheet" type="text/css">
<jsp:include page="MasterPage1.jsp"></jsp:include>
</head>




<body>
<form method="post" action="NoticiasServlet">

<div class="Mensaje">
<%--POSTEO CARGADO--%>
<%if(request.getAttribute("Insert") != null)
{%>
<a>El posteo se ha cargado con exito</a>
<div class="botonAceptar">
<input type="submit" name="btnAceptar" value="Aceptar">
</div>
<%}%>


<%--USUARIO EDITADO--%>
<%if(request.getAttribute("Confirm") != null)
{%>
<a>El usuario se ha editado con exito</a>
<div class="botonAceptar">
<input type="submit" name="btnAceptar" value="Aceptar">
</div>
<%}%>


<%--CONFIRMAR ELIMINAR POSTEO--%>
<%if(request.getAttribute("llevarId") != null)
{
int id = (int) request.getAttribute("llevarId");%>

<input type="hidden" name="datoUsuario" value="<%=id%>">
<a>Esta seguro que desea eliminar este posteo?</a>
<div class="botonAceptar">
<input type="submit" name="btnConfirmarEliminar" value="Si"> <input type="submit" name="btnNegarEliminar" value="No">
</div>
<%}%>


<%if(request.getAttribute("ConfirmaElimino") != null)
{%>
<a>Se ha eliminado el posteo correctamente</a>
<div class="botonAceptar">
<input type="submit" name="btnAceptar" value="Aceptar">
</div>
<%} %>


<%--CONFIRMO EDITO POSTEO--%>
<%if(request.getAttribute("InsertPosteoEditado") != null)
{%>
<a>Se ha editado el posteo correctamente</a>
<div class="botonAceptar">
<input type="submit" name="btnAceptar" value="Aceptar">
</div>
<%} %>




</div>


</form>
</body>
</html>