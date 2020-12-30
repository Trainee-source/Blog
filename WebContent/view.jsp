<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entidad.usuarios"%>
<%@page import="entidad.posts"%>
<%@page import="datos.PostsDao"%>
<%@page import="datosImpl.PostsImpl"%>
<%@page import="negocio.PostsNegocio"%>
<%@page import="negocioImpl.PostsNegocioImpl"%>
<%@page import="dao.EmpDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>




<body>
<%  
String spageid = request.getParameter("page");
int pageid = Integer.parseInt(spageid);  
int total=5;  
if(pageid==1){}  
else{  
    pageid=pageid-1;  
    pageid=pageid*total+1;  
}
List<posts> list= EmpDao.getRecords(pageid,total);

  
out.print("<h1>Page No: "+spageid+"</h1>");  
out.print("<table border='1' cellpadding='4' width='60%'>");  
out.print("<tr><th>Id</th><th>Name</th><th>Salary</th>");  
for(posts p: list){  
    out.print("<tr><td>"+p.getPostId()+"</td><td>"+p.getPostTitulo()+"</td><td>"+p.getPostIntroduccion()+"</td></tr>");  
}  
out.print("</table>");  
%>  
<a href="view.jsp?page=1">1</a>  
<a href="view.jsp?page=2">2</a>  
<a href="view.jsp?page=3">3</a>  


</body>
</html>