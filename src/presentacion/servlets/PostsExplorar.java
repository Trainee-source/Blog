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
 * Servlet implementation class PostsExplorar
 */
@WebServlet("/PostsExplorar")
public class PostsExplorar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostsNegocio PostT = new PostsNegocioImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostsExplorar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if (request.getParameter("Param") != null)
		{
			String busqueda = "";
			int idCategoria;
	    	idCategoria = Integer.parseInt(request.getParameter("Param"));
	    	  
	    	ArrayList<posts> listaBusqueda = PostT.ObtenerBusqueda(busqueda, idCategoria);
	    	  
	  		request.setAttribute("listaBusq", listaBusqueda);
			
	  		RequestDispatcher dispatcher = request.getRequestDispatcher("/Posteos.jsp");
	  		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      if(request.getParameter("btnBuscar") != null)
      {
    	  if(request.getParameter("comboCategorias") != null){
    	  String busqueda = request.getParameter("txtBusqueda");
    	  int idCategoria;
    	  idCategoria = Integer.parseInt(request.getParameter("comboCategorias"));
    	  
    	ArrayList<posts> listaBusqueda = PostT.ObtenerBusqueda(busqueda, idCategoria);
    	  
  		request.setAttribute("listaBusq", listaBusqueda);
		
  		RequestDispatcher dispatcher = request.getRequestDispatcher("/Posteos.jsp");
  		dispatcher.forward(request, response);
    	}
      }
	}

}
