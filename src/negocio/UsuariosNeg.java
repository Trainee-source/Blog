package negocio;

import entidad.usuarios;


public interface UsuariosNeg 
{
	public usuarios Logear(String mail, String password);
	public boolean InsertarUsuario (usuarios Usuario );
	public boolean EditarUsuario (usuarios Usuario);
	public boolean VerificarUsuario(String email, String pass);
	public boolean BorrarUsuario (int id);
	public usuarios TraerUsuarioPCR(int idUsuario);
}
