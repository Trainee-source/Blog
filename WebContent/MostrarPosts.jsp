<%@page import="entidad.categorias"%>
<%@page import="entidad.posts"%>
<%@page import="entidad.usuarios"%>
<%@page import="entidad.comentarios"%>
<%@page import="negocio.PostsNegocio"%>
<%@page import="negocio.UsuariosNeg"%>
<%@page import="negocio.ComentariosNegocio"%>
<%@page import="negocioImpl.PostsNegocioImpl"%>
<%@page import="negocioImpl.UsuariosNegImpl"%>
<%@page import="negocioImpl.ComentariosNegocioImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="EstilosMostrarPosts.css" rel="stylesheet" type="text/css">
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

<form method="get" action="MostrarPostsServlet">

<%--
		PostsNegocio PosteoT = new PostsNegocioImpl();
		posts posteo = new posts();
		int j = Integer.parseInt(request.getParameter("Param"));
--%>


<%-- DECLARACIONES --%>
<%posts posteo1 = new posts(); %>
<%usuarios user1 = new usuarios(); %>
<%usuarios userSession = new usuarios(); %>
<%UsuariosNeg UsuariosT = new UsuariosNegImpl(); %>
<%ComentariosNegocio ComentariosT = new ComentariosNegocioImpl(); %>

<%if(request.getAttribute("llevarPosteo") != null){%>
       <%posteo1 = (posts)request.getAttribute("llevarPosteo");%>
                              <%}%>
                              
<%
  user1 = UsuariosT.TraerUsuarioPCR(posteo1.getPostUsuarioId());
  userSession = (usuarios) session.getAttribute("Usuario");
  
  int id1 = user1.getUsuarioid();
  int id2 = 0;
  if(userSession != null){
     id2 = userSession.getUsuarioid();
  }
%>

<%
  ArrayList<comentarios> listaComentarios1 = ComentariosT.ObtenerTodos(posteo1.getPostId());
%>
                        
<!-- POST -->
<div class="postPrincipal">
 <div class="parteArriba">

                 <div class="informacionUsuario">
                           <div class="imagenPerfil">
                           <img src="Imagenes/imagenGeneral.png" width="70px" height="70px">
                           <p>Usuario:<%=user1.getUsuarioNombre() %></p>
                           </div>
                           
                           
                           
                           <%if(id1 == id2){%>
                           
                           <div class="botonEditar">
                           <input type="submit" name="btnEditar" value="Editar">
                           </div>
                           <%--request.setAttribute("llevarPosteoServlet", posteo1); --%>
                             
                           <div class="botonEliminar">
                           <input type="submit" name="btnEliminar" value="Eliminar">
                           </div>
                           
                           <input type="hidden" name="datoIdPosteo" value="<%=posteo1.getPostId()%>">
                           <input type="hidden" name="datoUsuario" value="<%=posteo1.getPostUsuarioId()%>">
                           <input type="hidden" name="datoTitulo" value="<%=posteo1.getPostTitulo()%>">
                           <input type="hidden" name="datoDescripcion" value="<%=posteo1.getPostIntroduccion()%>">
                           <input type="hidden" name="datoTexto" value="<%=posteo1.getPostTexto()%>"> 
                           <input type="hidden" name="datoImagen" value="<%=posteo1.getPostImagen()%>">
                           <input type="hidden" name="datoCategoria" value="<%=posteo1.getPostCategoria()%>">  
                           <%}%>
                  </div>

                  <%--posteo  = PosteoT.ObtenerUno(j); --%>
                          
                 <div class="Cuerpo">
                         <div class="imagenPosteo">
                            <img src="<%= posteo1.getPostImagen() %>" width="50%" >
                         </div>
                             <h2><%= posteo1.getPostTitulo() %></h2>
                             <p><%= posteo1.getPostIntroduccion() %></p>
                             <p><%= posteo1.getPostTexto() %></p>
                 </div>  
 </div>          
         
 <div class="parteAbajo">
                       
                       <div class="Likes">
                       <p class="w3-left"><input class="w3-button w3-white w3-border" type="submit" name="btnLike" value="Like"> <b><i class="fa fa-thumbs-up"></i> <%=posteo1.getPostPuntaje()%></b> </p>
                       <%--<p class="w3-left"> <input type="submit" class="w3-button w3-white w3-border" name="btnLike" value ="Like"> </p>--%>
                       </div>
                       
     

                       <input type="hidden" name="IdPosteo" value="<%=posteo1.getPostId()%>">
                       <input type="hidden" name="IdUsuario" value="<%=id2%>">
                       <input type="hidden" name="datoIdUsuarioPosteo" value="<%=id1%>">
                       <input type="hidden" name="datoTitulo" value="<%=posteo1.getPostTitulo()%>">
                       <input type="hidden" name="datoDescripcion" value="<%=posteo1.getPostIntroduccion()%>">
                       <input type="hidden" name="datoTexto" value="<%=posteo1.getPostTexto()%>"> 
                       <input type="hidden" name="datoImagen" value="<%=posteo1.getPostImagen()%>">
                       <input type="hidden" name="datoCategoria" value="<%=posteo1.getPostCategoria()%>">
                       <input type="hidden" name="datoFecha" value="<%=posteo1.getPostFecha()%>">
                       <input type="hidden" name="datoPuntaje" value="<%=posteo1.getPostPuntaje()%>">
                         

                       <div class="fechaDePosteo"><a>Posteado el: <%=posteo1.getPostFecha()%></a></div>     
                             
 </div>
</div>




<div class="comentariosAll">
<h1>Comentarios</h1>

<%if (listaComentarios1!=null)
	  {
	  for(comentarios c : listaComentarios1)
	  {
		  usuarios userComentario = new usuarios();
		  userComentario = UsuariosT.TraerUsuarioPCR(c.getComentarioUsuarioId());
	  		%>

<!-- COMENTARIOS -->
<div class="comentarios">
 <div class="parteArribaComentarios">
     
                 <div class="cuerpoComentarios">
		                     <p><%= c.getComentarioTexto() %></p>
                 </div>  
                 
                 <div class="informacionUsuarioComentario">
                           <p>Usuario: <%=userComentario.getUsuarioNombre()%></p>
                 </div>
                 </div>
                 
<div class="parteAbajoComentarios">
                 <div class="fechaDePosteoComentarios"> Comentado el: <%=c.getComentarioFecha()%></div>

 </div>
</div>          
       
       
         

<%}
}%>





<%if(userSession != null){%>
<div class="escribir">

<textarea placeholder="Escribi tu comentario" name="txtTextoComentario" cols="40" rows="5" required></textarea>
<input type="submit" name="btnComentar" value="Comentar" class="w3-button w3-block w3-red">
</div>
<input type="hidden" name="datoIdPosteo" value="<%=posteo1.getPostId()%>">
<%}%>

</div>


     
</form>

</body>
</html>