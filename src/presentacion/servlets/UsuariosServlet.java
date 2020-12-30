package presentacion.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.WordUtils;

import entidad.usuarios;
import datos.UsuariosDao;
import datosImpl.UsuariosImpl;
import negocio.UsuariosNeg;
import negocioImpl.UsuariosNegImpl;


@WebServlet("/UsuariosServlet")
public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuariosNeg Usuarios = new UsuariosNegImpl();
       
    public UsuariosServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("btnAceptar")!= null)
		{
			if (!request.getParameter("txtMail").isEmpty() && !request.getParameter("txtNombre").isEmpty() && !request.getParameter("txtApellido").isEmpty() && !request.getParameter("txtPassword1").isEmpty() && !request.getParameter("txtPassword2").isEmpty()  )
			{
				if(request.getParameter("txtPassword1").equals(request.getParameter("txtPassword2")))
				{
					if (!Usuarios.VerificarUsuario(request.getParameter("txtMail").toString(), (request.getParameter("txtPassword1").toString())))
					{
						usuarios a = new usuarios();
						
						String nombre = WordUtils.capitalizeFully(request.getParameter("txtNombre"));
						String apellido = WordUtils.capitalizeFully(request.getParameter("txtApellido"));
						
						a.setUsuarioMail(request.getParameter("txtMail"));
						a.setUsuarioNombre(nombre);
						a.setUsuarioApellido(apellido);
						a.setUsuarioContraseña(request.getParameter("txtPassword1"));
						
						boolean estado=true;
				    	estado = Usuarios.InsertarUsuario(a);
							if(estado == true)
							{
							request.setAttribute("Estado", estado);
					    	RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.jsp");
							dispatcher.forward(request, response);
							}
					}
					else
					{
						boolean mail = false;
						request.setAttribute("Verificar", mail);
				    	RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.jsp");
						dispatcher.forward(request, response);
					}
				}
				else
				{
					boolean contraseña = false;
					request.setAttribute("Password", contraseña);
			    	RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.jsp");
					dispatcher.forward(request, response);
				}
			}
			else
			{
				boolean textos = false;
				request.setAttribute("Textos", textos);
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
