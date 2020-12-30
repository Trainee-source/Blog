package presentacion.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.WordUtils;

import entidad.categorias;
import datos.CategoriasDao;
import datosImpl.CategoriasImpl;
import negocio.CategoriasNeg;
import negocioImpl.CategoriasNegImpl;

/**
 * Servlet implementation class RegisterCategoriasServlet
 */
@WebServlet("/RegisterCategoriasServlet")
public class RegisterCategoriasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CategoriasNeg Categorias = new CategoriasNegImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCategoriasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
				ArrayList<categorias> lista = Categorias.ObtenerTodos();
				
				request.setAttribute("listarCats", lista);
				
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("/CargarPosteos.jsp");
		    	
				dispatcher.forward(request, response);
				
				HttpSession session = request.getSession();
				session.setAttribute("categorias", lista);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getParameter("btnAceptarCat")!=null)
	    {
			String nombre = WordUtils.capitalizeFully(request.getParameter("txtCategoria"));
			
			if (!Categorias.VerificarCategoria(nombre))
			{
				boolean estado = true;
				estado = Categorias.InsertarCategoria(nombre);
				if (estado == true)
				{
					request.setAttribute("Insert", estado);
			    	RequestDispatcher dispatcher = request.getRequestDispatcher("/RegistrarCategoria.jsp");
					dispatcher.forward(request, response);
				}
			}
			else 
			{
				boolean categ = false;
				request.setAttribute("Verify", categ);
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("/RegistrarCategoria.jsp");
				dispatcher.forward(request, response);
			}
	    }
	}

}
