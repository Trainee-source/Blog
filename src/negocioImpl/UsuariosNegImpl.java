package negocioImpl;

import datos.UsuariosDao;
import datosImpl.UsuariosImpl;
import entidad.usuarios;
import negocio.UsuariosNeg;

public class UsuariosNegImpl implements UsuariosNeg
{
	private UsuariosDao usuDao = new UsuariosImpl();
	
	public UsuariosNegImpl()
	{
		
	}
	
	@Override
	public usuarios Logear(String mail, String password)
	{
		return usuDao.Logear(mail, password);
	}
	
	@Override
	public boolean InsertarUsuario (usuarios Usuario )
	{
		return usuDao.InsertarUsuario(Usuario);
	}
	@Override
	public boolean EditarUsuario (usuarios Usuario)
	{
		return usuDao.EditarUsuario(Usuario);
	}
	@Override
	public boolean VerificarUsuario(String email, String pass)
	{
		return usuDao.VerificarUsuario(email, pass);
	}
	@Override
	public boolean BorrarUsuario (int id) 
	{
		return usuDao.BorrarUsuario(id);
	}

	@Override
	public usuarios TraerUsuarioPCR(int idUsuario)
	{
	   return usuDao.TraerUsuarioPCR(idUsuario);
	}
}
