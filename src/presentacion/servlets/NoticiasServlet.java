package presentacion.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.PostsNegocio;
import negocioImpl.PostsNegocioImpl;

/**
 * Servlet implementation class NoticiasServlet
 */
@WebServlet("/NoticiasServlet")
public class NoticiasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticiasServlet() {
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
    if(request.getParameter("btnAceptar") != null)
    {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/PaginaPrincipal.jsp");
		dispatcher.forward(request, response);
    }
    
    if(request.getParameter("btnConfirmarEliminar") != null)
    {
    	int id = Integer.parseInt(request.getParameter("datoUsuario"));
    	PostsNegocio PosteoN = new PostsNegocioImpl();
    	boolean estado = true;
    	estado = PosteoN.BorrarPost(id);
    	
    	request.setAttribute("ConfirmaElimino", estado);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/Noticias.jsp");
		dispatcher.forward(request, response);
    }
    
    if(request.getParameter("btnNegarEliminar") != null)
    {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/PaginaPrincipal.jsp");
		dispatcher.forward(request, response);
    }
	}

}
