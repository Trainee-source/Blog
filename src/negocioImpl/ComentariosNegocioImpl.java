package negocioImpl;

import java.util.ArrayList;

import datos.ComentariosDao;
import datosImpl.ComentariosImpl;
import entidad.comentarios;
import negocio.ComentariosNegocio;

public class ComentariosNegocioImpl implements ComentariosNegocio{
	
	private ComentariosDao Comentarios = new ComentariosImpl();

	@Override
	public ArrayList<comentarios> ObtenerTodos(int idPosteo) {
		return Comentarios.ObtenerTodos(idPosteo);
	}

	@Override
	public boolean CrearComentario(comentarios Com) {
		return Comentarios.CrearComentario(Com);
	}

	@Override
	public boolean ModificarComentario(comentarios Com) {
		
		return false;
	}

	@Override
	public boolean BorrarComentario(comentarios Com) {
		
		return false;
	}

}
