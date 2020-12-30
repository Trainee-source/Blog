package presentacion.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.posts;
import entidad.categorias;

import negocio.PostsNegocio;
import negocio.CategoriasNeg;

import negocioImpl.PostsNegocioImpl;
import negocioImpl.CategoriasNegImpl;

/**
 * Servlet implementation class ExplorarReportes
 */
@WebServlet("/ExplorarReportes")
public class ExplorarReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostsNegocio PtNegocio = new PostsNegocioImpl();
	CategoriasNeg CatNegocio = new CategoriasNegImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExplorarReportes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btnReportesPosts") != null)
		{
			
			String desde = request.getParameter("txtDesde");
			String hasta = request.getParameter("txtHasta");
			if (desde == "")
			{
				desde = "2019-01-01";
			}
			
			if (hasta == "")
			{
				hasta = "2019-12-31";
			}
			ArrayList<posts> lista = PtNegocio.ReportesDestacados(desde, hasta);
    		
    		request.setAttribute("listaReportesBuscar", lista);
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/ReportesPosts.jsp");
    		dispatcher.forward(request, response);
		}
		
		if (request.getParameter("btnReportesCategorias") != null)
		{
			
			String desde = request.getParameter("txtDesdeC");
			String hasta = request.getParameter("txtHastaC");
			
			if (desde == "")
			{
				desde = "2019-01-01";
			}
			
			if (hasta == "")
			{
				hasta = "2019-12-31";
			}
			
			ArrayList<categorias> lista = CatNegocio.ReportesCategorias(desde, hasta);
    		
    		request.setAttribute("listaReportesCBuscar", lista);
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/ReportesCategorias.jsp");
    		dispatcher.forward(request, response);
    		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
