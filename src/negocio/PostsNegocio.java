package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidad.posts;

public interface PostsNegocio 
{
	public ArrayList<posts> ObtenerTodos();
	public posts ObtenerUno(int PostId);
	public ArrayList<posts> ObtenerBusqueda( String busqueda, int idCategoria);
	public ArrayList<posts> ObtenerDestacados();
	public ArrayList<posts> ObtenerPublicados(int UsuarioId);
	
	public boolean CrearPost(posts Posteo);
	public boolean ModificarPost ( posts Posteo);
	public boolean BorrarPost(int idPosteo);
	
	public boolean VerificarLike(int idPosteo, int idUsuario);
	public boolean Like(int idPosteo, int idUsuario);
	public boolean Dislike(int idPosteo, int idUsuario);
	public boolean SumarLike(int idPosteo);
	public boolean RestarLike(int idPosteo);
	
	public ArrayList<posts> ReportesDestacados(String desde, String hasta);
	
	public List<posts> getRecords(int start,int total);
}
