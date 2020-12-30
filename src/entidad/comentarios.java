package entidad;

import java.util.Date;

public class comentarios 
{
	private int ComentarioId;
	private int ComentarioUsuarioId;
	private int PostId;
	private int PostUsuarioId;
	private String ComentarioTexto;
	private int ComentarioEstado;
	private Date ComentarioFecha;
	
	public comentarios(int comentarioUsuarioId, int postId, int postUsuarioId, String comentarioTexto) {

		ComentarioUsuarioId = comentarioUsuarioId;
		PostId = postId;
		PostUsuarioId = postUsuarioId;
		ComentarioTexto = comentarioTexto;
	}
	
	public comentarios()
	{
		
	}

	public Date getComentarioFecha() {
		return ComentarioFecha;
	}

	public void setComentarioFecha(Date comentarioFecha) {
		ComentarioFecha = comentarioFecha;
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

	public String getComentarioTexto() {
		return ComentarioTexto;
	}

	public void setComentarioTexto(String comentarioTexto) {
		ComentarioTexto = comentarioTexto;
	}

	public int getComentarioEstado() {
		return ComentarioEstado;
	}

	public void setComentarioEstado(int comentarioEstado) {
		ComentarioEstado = comentarioEstado;
	}
	
	
	
	

}
