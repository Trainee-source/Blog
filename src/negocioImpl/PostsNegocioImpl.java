package negocioImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidad.posts;
import datos.PostsDao;
import datosImpl.PostsImpl;
import negocio.PostsNegocio;

public class PostsNegocioImpl implements PostsNegocio{
	
	private PostsDao Posts = new PostsImpl();

	@Override
	public ArrayList<posts> ObtenerTodos() {
		return Posts.ObtenerTodos();
	}
	
	@Override
	public posts ObtenerUno(int PostId) {
		
		return Posts.ObtenerUno(PostId);
	}

	@Override
	public ArrayList<posts> ObtenerBusqueda(String busqueda, int idCategoria) {

		return Posts.ObtenerBusqueda(busqueda, idCategoria);
	}

	@Override
	public ArrayList<posts> ObtenerDestacados() {

		return Posts.ObtenerDestacados();
	}

	@Override
	public ArrayList<posts> ObtenerPublicados(int UsuarioId) {
		
		return Posts.ObtenerPublicados(UsuarioId);
	}

	@Override
	public boolean CrearPost(posts Posteo) {

		return Posts.CrearPost(Posteo);
		
	}

	@Override
	public boolean ModificarPost(posts Posteo) {
		return Posts.ModificarPost(Posteo);
	}

	@Override
	public boolean BorrarPost(int idPosteo) {
			return Posts.BorrarPost(idPosteo);
	}

	@Override
	public boolean VerificarLike(int idPosteo, int idUsuario) {
		
		return Posts.VerificarLike(idPosteo, idUsuario);
	}

	@Override
	public boolean Like(int idPosteo, int idUsuario) {
		
		return Posts.Like(idPosteo, idUsuario);
	}

	@Override
	public boolean Dislike(int idPosteo, int idUsuario) {
		
		return Posts.Dislike(idPosteo, idUsuario);
	}

	@Override
	public boolean SumarLike(int idPosteo) {

		return Posts.SumarLike(idPosteo);
	}

	@Override
	public boolean RestarLike(int idPosteo) {

		return Posts.RestarLike(idPosteo);
	}

	@Override
	public ArrayList<posts> ReportesDestacados(String desde, String hasta) 
	{
		return Posts.ReportesDestacados(desde, hasta);
	}

	@Override
	public List<posts> getRecords(int start, int total)
	{
		return Posts.getRecords(start, total);
	}
	
	


}
