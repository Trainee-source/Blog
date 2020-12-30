package entidad;

public class respuestas 
{
	private int RespuestaId;
	private int RespuestaUsuarioId;
	private int ComentarioId;
	private int ComentarioUsuarioId;
	private int PostId;
	private int PostUsuarioId;
	private String RespuestaTexto;
	private int RespuestaEstado;
	
	
	
	
	
	
	public respuestas(int respuestaUsuarioId, int comentarioId, int comentarioUsuarioId, int postId, int postUsuarioId,
			String respuestaTexto) {
		
		RespuestaUsuarioId = respuestaUsuarioId;
		ComentarioId = comentarioId;
		ComentarioUsuarioId = comentarioUsuarioId;
		PostId = postId;
		PostUsuarioId = postUsuarioId;
		RespuestaTexto = respuestaTexto;
	}
	
	public respuestas()
	{
		
	}
	
	public int getRespuestaId() {
		return RespuestaId;
	}
	public void setRespuestaId(int respuestaId) {
		RespuestaId = respuestaId;
	}
	public int getRespuestaUsuarioId() {
		return RespuestaUsuarioId;
	}
	public void setRespuestaUsuarioId(int respuestaUsuarioId) {
		RespuestaUsuarioId = respuestaUsuarioId;
	}
	public int getComentarioId() {
		return ComentarioId;
	}
	public void setComentarioId(int comentarioId) {
		ComentarioId = comentarioId;
	}
	public int getComentarioUsuarioId() {
		return ComentarioUsuarioId;
	}
	public void setComentarioUsuarioId(int comentarioUsuarioId) {
		ComentarioUsuarioId = comentarioUsuarioId;
	}
	public int getPostId() {
		return PostId;
	}
	public void setPostId(int postId) {
		PostId = postId;
	}
	public int getPostUsuarioId() {
		return PostUsuarioId;
	}
	public void setPostUsuarioId(int postUsuarioId) {
		PostUsuarioId = postUsuarioId;
	}
	public String getRespuestaTexto() {
		return RespuestaTexto;
	}
	public void setRespuestaTexto(String respuestaTexto) {
		RespuestaTexto = respuestaTexto;
	}
	public int getRespuestaEstado() {
		return RespuestaEstado;
	}
	public void setRespuestaEstado(int respuestaEstado) {
		RespuestaEstado = respuestaEstado;
	}
	
	

}
