package datos;

import java.util.List;
import entidad.comentarios;
import entidad.respuestas;

public interface RespuestasDao 
{
	public List<comentarios> ObtenerTodos(respuestas Rs);
	
	public boolean CrearRespuesta(respuestas Rs );
	public boolean EditarRespuesta( respuestas Rs );
	public boolean BorrarRespuesta( respuestas Rs );
}
