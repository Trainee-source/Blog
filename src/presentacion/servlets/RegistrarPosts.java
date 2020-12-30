package presentacion.servlets;

import entidad.posts;
import entidad.usuarios;
import datos.PostsDao;
import datosImpl.PostsImpl;
import negocio.PostsNegocio;
import negocioImpl.PostsNegocioImpl;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.WordUtils;

/**
 * Servlet implementation class RegistrarPosts
 */
@WebServlet("/RegistrarPosts")
public class RegistrarPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       PostsNegocio Posts = new PostsNegocioImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarPosts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		
		if (request.getParameter("btnAceptar")!=null)
		{
			if (request.getParameter("comboCat")!=null)
			{
				boolean estado = true;
				usuarios Usuario = new usuarios();
				Usuario = (usuarios) session.getAttribute("Usuario");
				
				String nombre = WordUtils.capitalizeFully(request.getParameter("txtNombrePost"));
				
				posts Post = new posts();
				Post.setPostTitulo(nombre);
				Post.setPostIntroduccion(request.getParameter("txtDescripcionPost"));
				Post.setPostTexto(request.getParameter("txtTextoPost"));
				Post.setPostCategoria(Integer.parseInt(request.getParameter("comboCat")));
				Post.setPostImagen("Imagenes/" + request.getParameter("linkImagen"));
				Post.setPostUsuarioId(Usuario.getUsuarioid());
				
				estado = Posts.CrearPost(Post);
				if (estado == true)
				{
					request.setAttribute("Insert", estado);
			    	RequestDispatcher dispatcher = request.getRequestDispatcher("/Noticias.jsp");
					dispatcher.forward(request, response);
				}
				
			}
		}
	}

}
