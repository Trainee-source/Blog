package presentacion.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.categorias;
import entidad.comentarios;
import entidad.posts;
import entidad.usuarios;
import negocio.ComentariosNegocio;
import negocio.PostsNegocio;
import negocio.UsuariosNeg;
import negocioImpl.ComentariosNegocioImpl;
import negocioImpl.PostsNegocioImpl;
import negocioImpl.UsuariosNegImpl;

/**
 * Servlet implementation class MostrarPostsServlet
 */
@WebServlet("/MostrarPostsServlet")
public class MostrarPostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostsNegocio PosteoN = new PostsNegocioImpl();
	ComentariosNegocio ComentariosM = new ComentariosNegocioImpl();
    posts posteo = new posts();
    posts posteoP = new posts();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarPostsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("Param") != null){
        	
        System.out.println(request.getParameter("Param"));
		posteo = PosteoN.ObtenerUno(Integer.parseInt(request.getParameter("Param")));
        
		request.setAttribute("llevarPosteo", posteo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/MostrarPosts.jsp");
		dispatcher.forward(request, response);
		
        }
        
        if(request.getParameter("btnEditar") != null)
        {
        	//posteo = (posts) request.getAttribute("llevarPosteoServlet");
        	//int idPosteo = Integer.parseInt(request.getParameter("datoEditar"));
        	
        	//request.setAttribute("llevarIdPosteo", idPosteo);
        	int idPosteo = Integer.parseInt(request.getParameter("datoIdPosteo"));
         	int id = Integer.parseInt(request.getParameter("datoUsuario"));
         	String titulo = request.getParameter("datoTitulo");
         	String descripcion = request.getParameter("datoDescripcion");
         	String texto = request.getParameter("datoTexto");
         	String imagen = request.getParameter("datoImagen");
         	int categoria = Integer.parseInt(request.getParameter("datoCategoria"));
        	
         	posteo.setPostId(idPosteo);
        	posteo.setPostUsuarioId(id);
        	posteo.setPostTitulo(titulo);
        	posteo.setPostIntroduccion(descripcion);
        	posteo.setPostTexto(texto);
        	posteo.setPostImagen(imagen);
        	posteo.setPostCategoria(categoria);
        	
        	request.setAttribute("postModif", posteo);
            
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarPosteos.jsp");
			dispatcher.forward(request, response);
        }
        
        if(request.getParameter("btnEliminar") != null)
        {
        	int id = Integer.parseInt(request.getParameter("datoIdPosteo"));
        	
        	request.setAttribute("llevarId", id);
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/Noticias.jsp");
			dispatcher.forward(request, response);
        	//PosteoN.BorrarPost(Integer.parseInt(request.getParameter("datoEliminar")));
        }
        
        if(request.getParameter("btnComentar") != null)
        {
        	HttpSession session= request.getSession();
        	usuarios user = new usuarios();
            comentarios com = new comentarios();
            
        	user = (usuarios)session.getAttribute("Usuario");
        	
        	int idPosteo = Integer.parseInt(request.getParameter("datoIdPosteo"));
        	
        	String comentario = request.getParameter("txtTextoComentario");
        	
        	
        	
        	com.setComentarioUsuarioId(user.getUsuarioid());
        	com.setPostId(idPosteo);
        	
        	com.setComentarioTexto(comentario);
        	
            boolean estado = true;
        	estado = ComentariosM.CrearComentario(com);
        	if(estado == true)
        	{
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/Posteos.jsp");
    			dispatcher.forward(request, response);
        	}
        	
        }
        
        
        if(request.getParameter("btnLike") != null)
        {
        	HttpSession session = (HttpSession )request.getSession();
        	
        	if(session.getAttribute("Usuario") != null){
        	
        	int idPosteo = Integer.parseInt(request.getParameter("IdPosteo"));
        	int idUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
        	
        	if(PosteoN.VerificarLike(idPosteo, idUsuario) == false)
        	{
        		PosteoN.SumarLike(idPosteo);
        		
        		PosteoN.Like(idPosteo, idUsuario);
        		
        		posts posteoP = PosteoN.ObtenerUno(idPosteo);
        		
             	/*String titulo = request.getParameter("datoTitulo");
             	int idUsuarioPosteo = Integer.parseInt(request.getParameter("datoIdUsuarioPosteo"));
             	String descripcion = request.getParameter("datoDescripcion");
             	String texto = request.getParameter("datoTexto");
             	String imagen = request.getParameter("datoImagen");
             	int categoria = Integer.parseInt(request.getParameter("datoCategoria"));
             	
             	
             	posteoP.setPostId(idPosteo);
            	posteoP.setPostUsuarioId(idUsuarioPosteo);
            	posteoP.setPostTitulo(titulo);
            	posteoP.setPostIntroduccion(descripcion);
            	posteoP.setPostTexto(texto);
            	posteoP.setPostImagen(imagen);
            	posteoP.setPostCategoria(categoria);
            	posteoP.setPostPuntaje(puntaje);
            	*/
        			
        		request.setAttribute("llevarPosteo", posteoP);
        		
        		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MostrarPosts.jsp");
        		dispatcher.forward(request, response);
        		 		
        	}
        	else
        	{
        		PosteoN.RestarLike(idPosteo);
        		
        		PosteoN.Dislike(idPosteo, idUsuario);
        		
        		posts posteoP = PosteoN.ObtenerUno(idPosteo);
        		
             	/*String titulo = request.getParameter("datoTitulo");
             	int idUsuarioPosteo = Integer.parseInt(request.getParameter("datoIdUsuarioPosteo"));
             	String descripcion = request.getParameter("datoDescripcion");
             	String texto = request.getParameter("datoTexto");
             	String imagen = request.getParameter("datoImagen");
             	int categoria = Integer.parseInt(request.getParameter("datoCategoria"));
             	
            	
             	posteoP.setPostId(idPosteo);
            	posteoP.setPostUsuarioId(idUsuarioPosteo);
            	posteoP.setPostTitulo(titulo);
            	posteoP.setPostIntroduccion(descripcion);
            	posteoP.setPostTexto(texto);
            	posteoP.setPostImagen(imagen);
            	posteoP.setPostCategoria(categoria);
            	*/
            	
        		
        		request.setAttribute("llevarPosteo", posteoP);
        		
        		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MostrarPosts.jsp");
        		dispatcher.forward(request, response);
        	}
        }else
        {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
			dispatcher.forward(request, response);
        }
        }
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
