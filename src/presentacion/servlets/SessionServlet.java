package presentacion.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.usuarios;
import negocio.UsuariosNeg;
import negocioImpl.UsuariosNegImpl;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuariosNeg Usuarios = new UsuariosNegImpl();
	usuarios user = new usuarios();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        
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
		if(request.getParameter("btnLogear")!=null)
	    {
		
			String name = request.getParameter("txtMail").toString();
			String pass = request.getParameter("txtPassword").toString();
			
			if (Usuarios.VerificarUsuario(name, pass) == true)
			{
				user = Usuarios.Logear(name, pass);
				if (user != null)
				{
					HttpSession session= request.getSession(true);
					session.setAttribute("Usuario", user);
					
					request.setAttribute("Insert", user);
					
					RequestDispatcher miDispacher = request.getRequestDispatcher("/Login.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
				    miDispacher.forward(request, response);
				    
				}
			}
			else 
			{
				boolean estado = false;
				request.setAttribute("Verify", estado);
				   getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
			}
	    }
	}

}
