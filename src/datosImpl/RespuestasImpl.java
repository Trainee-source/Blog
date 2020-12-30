package datosImpl;

import java.util.List;

import datos.RespuestasDao;
import entidad.comentarios;
import entidad.respuestas;

public class RespuestasImpl implements RespuestasDao
{

	@Override
	public List<comentarios> ObtenerTodos(respuestas Rs) {
		
		return null;
	}

	@Override
	public boolean CrearRespuesta(respuestas Rs) {
		
		return false;
	}

	@Override
	public boolean EditarRespuesta(respuestas Rs) {
		
		return false;
	}

	@Override
	public boolean BorrarRespuesta(respuestas Rs) {
		
		return false;
	}

}
