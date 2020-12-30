package datos;

import entidad.posts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface PostsDao 
{
	public ArrayList<posts> ObtenerTodos();
	public posts ObtenerUno(int postId);
	public ArrayList<posts> ObtenerBusqueda( String busqueda, int idCategoria);
	public ArrayList<posts> ObtenerDestacados();
	public ArrayList<posts> ObtenerPublicados(int usuarioId);
	
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
