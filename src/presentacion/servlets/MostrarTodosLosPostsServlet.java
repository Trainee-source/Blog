package presentacion.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.posts;
import negocio.PostsNegocio;
import negocioImpl.PostsNegocioImpl;

/**
 * Servlet implementation class MostrarTodosLosPostsServlet
 */
@WebServlet("/MostrarTodosLosPostsServlet")
public class MostrarTodosLosPostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostsNegocio PostT = new PostsNegocioImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarTodosLosPostsServlet() {
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
		ArrayList<posts> lista = PostT.ObtenerTodos();
		
		request.setAttribute("listPosts", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/PaginaPrincipal.jsp");
		dispatcher.forward(request, response);
	}

}
