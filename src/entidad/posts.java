package entidad;
import java.util.Date;

public class posts {
	private int PostId;
	private int PostUsuarioId;
	private String PostTitulo;
	private String PostIntroduccion;
	private String PostTexto;
	private String PostImagen;
	private int PostCategoria;
	private int PostPuntaje;
	private Date PostFecha;
	
	public posts() {
		super();
	}

	public posts(int postUsuarioId, String postTitulo, String postIntroduccion, String postTexto, String postImagen,
			int postCategoria) 
	{
		PostUsuarioId = postUsuarioId;
		PostTitulo = postTitulo;
		PostIntroduccion = postIntroduccion;
		PostTexto = postTexto;
		PostImagen = postImagen;
		PostCategoria = postCategoria;
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

	public String getPostTitulo() {
		return PostTitulo;
	}

	public void setPostTitulo(String postTitulo) {
		PostTitulo = postTitulo;
	}

	public String getPostIntroduccion() {
		return PostIntroduccion;
	}

	public void setPostIntroduccion(String postIntroduccion) {
		PostIntroduccion = postIntroduccion;
	}

	public String getPostTexto() {
		return PostTexto;
	}

	public void setPostTexto(String postTexto) {
		PostTexto = postTexto;
	}

	public String getPostImagen() {
		return PostImagen;
	}

	public void setPostImagen(String postImagen) {
		PostImagen = postImagen;
	}

	public int getPostCategoria() {
		return PostCategoria;
	}

	public void setPostCategoria(int postCategoria) {
		PostCategoria = postCategoria;
	}

	public int getPostPuntaje() {
		return PostPuntaje;
	}

	public void setPostPuntaje(int postPuntaje) {
		PostPuntaje = postPuntaje;
	}

	public Date getPostFecha() {
		return PostFecha;
	}

	public void setPostFecha(Date postFecha) {
		PostFecha = postFecha;
	}
	
	
	
	

}
