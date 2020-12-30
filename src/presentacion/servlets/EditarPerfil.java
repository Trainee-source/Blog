package presentacion.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.categorias;
import entidad.posts;
import entidad.usuarios;
import negocio.CategoriasNeg;
import negocio.PostsNegocio;
import negocio.UsuariosNeg;
import negocioImpl.CategoriasNegImpl;
import negocioImpl.PostsNegocioImpl;
import negocioImpl.UsuariosNegImpl;


/**
 * Servlet implementation class EditarPerfil
 */
@WebServlet("/EditarPerfil")
public class EditarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuariosNeg UsuariosT = new UsuariosNegImpl();
    usuarios user = new usuarios();
    CategoriasNeg catNegocio = new CategoriasNegImpl();
    PostsNegocio PtNegocio = new PostsNegocioImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPerfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnConfirmarEditar") != null)
        {
        	//if(!request.getParameter("txtMail").isEmpty() && !request.getParameter("txtNombre").isEmpty() && !request.getParameter("txtApellido").isEmpty() && !request.getParameter("txtContraseña1").isEmpty() && !request.getParameter("txtContraseña2").isEmpty())
        	//{
        		//if(request.getParameter("txtContraseña1").equals(request.getParameter("txtContraseña2")))
        		//{
			        usuarios a = new usuarios();
			        usuarios b = new usuarios();
			        HttpSession session= request.getSession();
			        b = (usuarios)session.getAttribute("Usuario");
			        
			        a.setUsuarioid(b.getUsuarioid());
					a.setUsuarioMail(request.getParameter("txtMail"));
					a.setUsuarioNombre(request.getParameter("txtNombre"));
					a.setUsuarioApellido(request.getParameter("txtApellido"));
					a.setUsuarioContraseña(request.getParameter("txtPassword"));
        			
        			
        			boolean estado = true;
        			estado = UsuariosT.EditarUsuario(a);
        			
        			if(estado == true){
        			request.setAttribute("Confirm", estado);
        			RequestDispatcher dispatcher = request.getRequestDispatcher("/Noticias.jsp");
    				dispatcher.forward(request, response);
    				request.getSession().invalidate();
        			}
        		//}
        	//}
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("btnEditarPerfil") != null)
        {
        	HttpSession session= request.getSession();
        	user = (usuarios) session.getAttribute("Usuario");
        	//int idPosteo = Integer.parseInt(request.getParameter("datoEditar"));
        	
        	//request.setAttribute("llevarIdPosteo", idPosteo);
        	request.setAttribute("llevarUsuariosModificar", user);
            
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarPerfiles.jsp");
			dispatcher.forward(request, response);
        }
        
        if(request.getParameter("btnAgregarCategorias") != null)
        {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/RegistrarCategoria.jsp");
			dispatcher.forward(request, response);
        }
        
        if (request.getParameter("btnEditarCategorias") != null)
		{
			request.setAttribute("CategoriasPagina", catNegocio.ObtenerTodos());
			request.setAttribute("NumeroPaginas", catNegocio.ContarPaginas());
			request.setAttribute("PaginaAhora", 1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarCategorias.jsp");
			dispatcher.forward(request, response);
		}
        
        if (request.getParameter("btnReportesPost") != null)
        {
        	String desde = "2019-01-01";
        	String hasta = "2019-12-31";
        	
        	ArrayList<posts> lista = PtNegocio.ReportesDestacados(desde, hasta);
    		
    		request.setAttribute("listReportes", lista);
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/ReportesPosts.jsp");
    		dispatcher.forward(request, response);
        }
        
        if (request.getParameter("btnReportesCategorias") != null)
        {
        	String desde = "2019-01-01";
        	String hasta = "2019-12-31";
        	
        	ArrayList<categorias> lista = catNegocio.ReportesCategorias(desde, hasta);
    		
    		request.setAttribute("listReportesC", lista);
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/ReportesCategorias.jsp");
    		dispatcher.forward(request, response);
        }
        
        /*if(request.getParameter("btnEliminarPerfil") != null)
        {
        	user = (usuarios) request.getAttribute("llevarPerfilServlet");
        	UsuariosT.BorrarUsuario((user.getUsuarioid()));
        	//PosteoN.BorrarPost(Integer.parseInt(request.getParameter("datoEliminar")));
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/PaginaPrincipal.jsp");
			dispatcher.forward(request, response);
        }*/
        
	}

}
