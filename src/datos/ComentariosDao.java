package datos;

import entidad.comentarios;
import entidad.posts;

import java.util.ArrayList;
import java.util.List;

public interface ComentariosDao 
{
	public ArrayList<comentarios> ObtenerTodos(int idPosteo);
	
	public boolean CrearComentario(comentarios Com );
	public boolean EditarComentario( comentarios Com );
	public boolean BorrarComentario( comentarios Com );

}
