package dominioServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Document;

import entidad.posts;
import entidad.usuarios;
import negocio.PostsNegocio;
import negocioImpl.PostsNegocioImpl;

/**
 * Servlet implementation class servletMasterPage
 */
@WebServlet("/servletMasterPage")
public class servletMasterPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostsNegocio PostT = new PostsNegocioImpl();
	usuarios userUsuario = new usuarios();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletMasterPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = (HttpSession )request.getSession();
		
		if(request.getParameter("btnInicio") != null)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/PaginaPrincipal.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("btnPostea!") != null)
		{
			if(session.getAttribute("Usuario")!= null){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/CargarPosteos.jsp");
				dispatcher.forward(request, response);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("btnExplora") != null)
		{
			ArrayList<posts> lista = PostT.ObtenerTodos();
			request.setAttribute("listPostsAll", lista);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Posteos.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("btnPerfil") != null)
		{
			if(session.getAttribute("Usuario") != null)
			{
				userUsuario = (usuarios) session.getAttribute("Usuario");
				ArrayList<posts> listaPublicados = PostT.ObtenerPublicados(userUsuario.getUsuarioid());
				
				request.setAttribute("listPostsPublicados", listaPublicados);
				
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Perfil.jsp");
			dispatcher.forward(request, response);
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("Param") !=null)
		{
			request.getSession().invalidate();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/PaginaPrincipal.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		
	}

}
