package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.ComentariosDao;
import entidad.comentarios;
import entidad.posts;

public class ComentariosImpl implements ComentariosDao
{
	private Conexion cn;

	@Override
	public ArrayList<comentarios> ObtenerTodos(int idPosteo){
		cn = new Conexion();
		cn.Open();
		ResultSet rs;
		
		ArrayList<comentarios> lista = new ArrayList<comentarios>();
		String query ="Select * from comentarios where ComIDPost ="+ idPosteo + " AND ComEstado = 1";
		System.out.println(query);
		 try
		 {
			 rs= cn.query(query);
			 
				 while(rs.next())
				 {
					 comentarios Com = new comentarios();
					 
					 Com.setComentarioId(rs.getInt("ComId"));
					 Com.setComentarioTexto(rs.getString("ComTexto"));
					 Com.setComentarioUsuarioId(rs.getInt("ComIDUsuario"));
					 Com.setPostId(rs.getInt("ComIDPost"));
					 Com.setComentarioFecha(rs.getDate("ComFechaCreacion"));
					 
					 
					 lista.add(Com);
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
		
	return lista;
	}

	@Override
	public boolean CrearComentario(comentarios Com) {
		cn = new Conexion();
		cn.Open();
		boolean estado = true;
		
		String query= "INSERT INTO comentarios (ComIDPost, ComIDUsuario, ComTexto) VALUES ('"+Com.getPostId()+"', '"+Com.getComentarioUsuarioId()+"', '"+Com.getComentarioTexto()+"')";
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
	public boolean EditarComentario(comentarios Com) {
		
		return false;
	}

	@Override
	public boolean BorrarComentario(comentarios Com) {
		
		return false;
	}

}
