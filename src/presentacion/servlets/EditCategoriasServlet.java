package presentacion.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entidad.categorias;
import negocio.CategoriasNeg;
import negocioImpl.CategoriasNegImpl;
/**
 * Servlet implementation class EditCategoriasServlet
 */
@WebServlet("/EditCategoriasServlet")
public class EditCategoriasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoriasNeg cats = new CategoriasNegImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCategoriasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null)
		{
			Integer opcion = Integer.parseInt(request.getParameter("Param"));
			
			request.setAttribute("Categoria", cats.ObtenerUno(opcion));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarCategoria.jsp");
			dispatcher.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getParameter("btnEditarC") != null)
		{
			String nombre = request.getParameter("txtNombreCat").toString();
			int id = Integer.parseInt(request.getParameter("txtIdCat"));
			byte estate = (byte)Integer.parseInt(request.getParameter("comboCate"));
			
			
			
				boolean estado = true;
				estado = cats.ModificarCategoria(id, nombre, estate);
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/Perfil.jsp");
				dispatcher.forward(request, response);
			
		}
		}
	}



