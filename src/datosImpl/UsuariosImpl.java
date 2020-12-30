package datosImpl;
import java.sql.ResultSet;


import datos.UsuariosDao;
import entidad.usuarios;



public class UsuariosImpl implements UsuariosDao 
{
	public UsuariosImpl()
	{
		
	}

	@Override
	public usuarios Logear(String mail, String password) 
	{
		
		ResultSet rs = null;
		usuarios Nuevo = new usuarios();
		Conexion cn = new Conexion();
		cn.Open();
		
		String query = "SELECT * FROM Usuarios WHERE UsuEmail = '" +mail+"' AND UsuPassword = '"+ password +"'";
		
		try
		 {
			
			rs = cn.query(query);
			while (rs.next())
			{
				Nuevo.setUsuarioid(rs.getInt("usuarios.UsuId"));
				Nuevo.setUsuarioNombre(rs.getString("usuarios.UsuNombre"));
				Nuevo.setUsuarioApellido(rs.getString("usuarios.UsuApellido"));
				Nuevo.setUsuarioMail(rs.getString("usuarios.UsuEmail"));
				Nuevo.setUsuarioContraseña(rs.getString(("usuarios.UsuPassword")));
				Nuevo.setUsuarioUrlImagen(rs.getString("usuarios.UsuImage"));
				//Nuevo.setUsuarioEstado(rs.getInt("usuarios.UsuEstado"));
			    Nuevo.setUsuarioTipo(rs.getInt("usuarios.UsuTipo"));
			    Nuevo.setUsuarioFecha(rs.getDate("usuarios.UsuFechaCreacion"));
			}
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		
		return Nuevo;
	}
	
	@Override
	public boolean InsertarUsuario(usuarios Usuario) {
		
		boolean estado = true;
		
		Conexion cn = new Conexion();
		
		cn.Open();
		
		String query = "INSERT INTO usuarios (UsuNombre, UsuApellido, UsuEmail, UsuPassword) VALUES ('"+Usuario.getUsuarioNombre()+"','"+Usuario.getUsuarioApellido()+"','"+Usuario.getUsuarioMail()+"','"+Usuario.getUsuarioContraseña()+"')";
		System.out.println(query);
		
		try
		 {
			estado = cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		
		return estado;
	}

	@Override
	public boolean EditarUsuario(usuarios Usuario) {
		boolean estado=true;

		Conexion cn = new Conexion();
		cn.Open();	

		String query = "UPDATE  usuarios SET UsuNombre='"+Usuario.getUsuarioNombre()+"', UsuApellido='"+Usuario.getUsuarioApellido()+"', UsuEmail='"+Usuario.getUsuarioMail() + "' WHERE UsuId='"+Usuario.getUsuarioid()+"' AND UsuEstado=1";
		System.out.println(query);
		try
		 {
			estado = cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean BorrarUsuario(int id) {
		boolean estado=true;
		Conexion cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE usuarios SET UsuEstado = 0 WHERE UsuId="+id;
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}
	
	@Override
	public boolean VerificarUsuario(String mail, String pass)
	{
		boolean estado = true;
		ResultSet rs;
		Conexion cn = new Conexion();
		cn.Open();		 
		String query = "SELECT UsuEstado from usuarios WHERE UsuEmail = '" +mail+"' AND UsuPassword ='" + pass +"'";
		System.out.println(query);
		try
		 {
			rs = cn.query(query);
			if (rs.next() == true)
			{
				estado = true;
			}
			else
				estado = false;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		
		return estado;
	}

	@Override
	public usuarios TraerUsuarioPCR(int idUsuario)
	{
		ResultSet rs = null;
		usuarios Nuevo = new usuarios();
		Conexion cn = new Conexion();
		cn.Open();
		
		String query = "SELECT * FROM Usuarios WHERE UsuId = '" + idUsuario + "'";
		
		try
		 {
			
			rs = cn.query(query);
			while (rs.next())
			{
				Nuevo.setUsuarioid(rs.getInt("usuarios.UsuId"));
				Nuevo.setUsuarioNombre(rs.getString("usuarios.UsuNombre"));
				Nuevo.setUsuarioApellido(rs.getString("usuarios.UsuApellido"));
				Nuevo.setUsuarioMail(rs.getString("usuarios.UsuEmail"));
				Nuevo.setUsuarioContraseña(rs.getString(("usuarios.UsuPassword")));
				Nuevo.setUsuarioUrlImagen(rs.getString("usuarios.UsuImagen"));
				//Nuevo.setUsuarioEstado(rs.getInt("usuarios.UsuEstado"));
				Nuevo.setUsuarioTipo(rs.getInt("usuarios.UsuTipo"));
				Nuevo.setUsuarioFecha(rs.getDate("usuarios.UsuFechaCreacion"));
			}
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		
		return Nuevo;
	}
	
}
	
