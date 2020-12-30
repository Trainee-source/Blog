package negocio;

import java.util.ArrayList;

import entidad.comentarios;
import entidad.posts;

public interface ComentariosNegocio {
	public ArrayList<comentarios> ObtenerTodos(int idPosteo);
	
	public boolean CrearComentario(comentarios Com);
	public boolean ModificarComentario (comentarios Com);
	public boolean BorrarComentario(comentarios Com);
}
