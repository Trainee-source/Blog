package presentacion.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.posts;
import entidad.usuarios;
import negocio.PostsNegocio;
import negocioImpl.PostsNegocioImpl;

/**
 * Servlet implementation class EditarPosts
 */
@WebServlet("/EditarPosts")
public class EditarPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostsNegocio Posts = new PostsNegocioImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPosts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if(request.getParameter("btnEditar") != null)
    {
    	if (request.getParameter("comboCat")!=null)
		{
			boolean estado = true;
			
			posts Post = new posts();
			Post.setPostTitulo(request.getParameter("txtNombrePost"));
			Post.setPostIntroduccion(request.getParameter("txtDescripcionPost"));
			Post.setPostTexto(request.getParameter("txtTextoPost"));
			Post.setPostCategoria(Integer.parseInt(request.getParameter("comboCat")));
			Post.setPostImagen(request.getParameter("linkImagen"));
			Post.setPostId(Integer.parseInt(request.getParameter("datoEditar2")));
			
			
			estado = Posts.ModificarPost(Post);
			if (estado == true)
			{
				request.setAttribute("InsertPosteoEditado", estado);
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("/Noticias.jsp");
				dispatcher.forward(request, response);
			}
			
		}
    }
	}

}
