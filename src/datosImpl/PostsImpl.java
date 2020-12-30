package datosImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;
import datos.PostsDao;
import entidad.categorias;
import entidad.posts;

public class PostsImpl implements PostsDao
{

	private Conexion cn;
	
	@Override
	public ArrayList<posts> ObtenerTodos() {
		cn = new Conexion();
		cn.Open();
		ResultSet rs;
		
		ArrayList<posts> lista = new ArrayList<posts>();
		String query ="Select * from posts where PostEstado = 1";
		System.out.println(query);
		 try
		 {
			 rs= cn.query(query);
			 
				 while(rs.next())
				 {
					 posts post = new posts();
					 
					 post.setPostId(rs.getInt("PostId"));
					 post.setPostTitulo(rs.getString("PostTitulos"));
					 post.setPostIntroduccion(rs.getString("PostDescripcion"));
					 post.setPostTexto(rs.getString("PostTexto"));
					 post.setPostCategoria(rs.getInt("PostIDCategoria"));
					 post.setPostImagen(rs.getString("PostImage"));
					 post.setPostUsuarioId(rs.getInt("PostIDUsuario"));
					 post.setPostFecha(rs.getDate("PostFechaCreacion"));
					 post.setPostPuntaje(rs.getInt("PostPuntaje"));
					 
					 lista.add(post);
					 
				 }

		 }
		catch(Exception e)
			{
				e.printStackTrace();
			}
		finally
			{
				cn.close();
			}
		
	return lista;
	}
	
	@Override
	public posts ObtenerUno(int postId) {
		
		cn = new Conexion();
		posts posteo = new posts();
		cn.Open();
		ResultSet rs;
		
		String query ="SELECT PostId, PostTitulos, PostDescripcion, PostTexto, PostIDCategoria, PostImage, PostIDUsuario, PostFechaCreacion, PostPuntaje FROM posts WHERE PostId = " + postId + " AND PostEstado = 1 ";
		System.out.println(query);
		 try
		 {
			 rs= cn.query(query);
				 while(rs.next())
				 {
					
					 
					 posteo.setPostId(rs.getInt("PostId"));
					 posteo.setPostTitulo(rs.getString("PostTitulos"));
					 posteo.setPostIntroduccion(rs.getString("PostDescripcion"));
					 posteo.setPostTexto(rs.getString("PostTexto"));
					 posteo.setPostCategoria(rs.getInt("PostIDCategoria"));
					 posteo.setPostImagen(rs.getString("PostImage"));
					 posteo.setPostUsuarioId(rs.getInt("PostIDUsuario"));
					 posteo.setPostFecha(rs.getDate("PostFechaCreacion"));
					 posteo.setPostPuntaje(rs.getInt("PostPuntaje"));
					 
				 }

		 }
		catch(Exception e)
			{
				e.printStackTrace();
			}
		finally
			{
				cn.close();
			}
		 
	return posteo;
	}

	@Override
	public ArrayList<posts> ObtenerBusqueda(String busqueda, int idCategoria) 
	{
		cn = new Conexion();
		cn.Open();
		ResultSet rs;
		String query;
		
		ArrayList<posts> lista = new ArrayList<posts>();
		if(idCategoria == 0){
		query ="Select * from posts where PostTitulos like '"+busqueda+"%' and PostEstado = 1";
		}else
		{
	    query ="Select * from posts where PostTitulos like '"+busqueda+"%' AND PostIDCategoria = "+ idCategoria +" and PostEstado = 1";
		}
		
		System.out.println(query);
		 try
		 {
			 rs= cn.query(query);
			 
				 while(rs.next())
				 {
					 posts post = new posts();
					 
					 post.setPostId(rs.getInt("PostId"));
					 post.setPostTitulo(rs.getString("PostTitulos"));
					 post.setPostIntroduccion(rs.getString("PostDescripcion"));
					 post.setPostTexto(rs.getString("PostTexto"));
					 post.setPostCategoria(rs.getInt("PostIDCategoria"));
					 post.setPostImagen(rs.getString("PostImage"));
					 post.setPostUsuarioId(rs.getInt("PostIDUsuario"));
					 post.setPostFecha(rs.getDate("PostFechaCreacion"));
					 post.setPostPuntaje(rs.getInt("PostPuntaje"));
					 
					 lista.add(post);
					 
				 }

		 }
		catch(Exception e)
			{
				e.printStackTrace();
			}
		finally
			{
				cn.close();
			}
		
	return lista;
	}
		

	@Override
	public ArrayList<posts> ObtenerDestacados() {
		cn = new Conexion();
		cn.Open();
		ResultSet rs;
		
		ArrayList<posts> lista = new ArrayList<posts>();
		String query ="Select * from posts where PostEstado = 1 AND PostPuntaje >= 5";
		System.out.println(query);
		 try
		 {
			 rs= cn.query(query);
			 
				 while(rs.next())
				 {
					 posts post = new posts();
					 
					 post.setPostId(rs.getInt("PostId"));
					 post.setPostTitulo(rs.getString("PostTitulos"));
					 post.setPostIntroduccion(rs.getString("PostDescripcion"));
					 post.setPostTexto(rs.getString("PostTexto"));
					 post.setPostCategoria(rs.getInt("PostIDCategoria"));
					 post.setPostImagen(rs.getString("PostImage"));
					 post.setPostUsuarioId(rs.getInt("PostIDUsuario"));
					 post.setPostFecha(rs.getDate("PostFechaCreacion"));
					 post.setPostPuntaje(rs.getInt("PostPuntaje"));
					 
					 lista.add(post);
					 
				 }

		 }
		catch(Exception e)
			{
				e.printStackTrace();
			}
		finally
			{
				cn.close();
			}
		
	return lista;
	}

	@Override
	public ArrayList<posts> ObtenerPublicados(int usuarioId) {
		cn = new Conexion();
		cn.Open();
		ResultSet rs;
		
		ArrayList<posts> lista = new ArrayList<posts>();
		String query ="Select * from posts where PostIDUsuario = '"+usuarioId+"' and PostEstado = 1";
		System.out.println(query);
		 try
		 {
			 rs= cn.query(query);
			 
				 while(rs.next())
				 {
					 posts post = new posts();
					 
					 post.setPostId(rs.getInt("PostId"));
					 post.setPostTitulo(rs.getString("PostTitulos"));
					 post.setPostIntroduccion(rs.getString("PostDescripcion"));
					 post.setPostTexto(rs.getString("PostTexto"));
					 post.setPostCategoria(rs.getInt("PostIDCategoria"));
					 post.setPostImagen(rs.getString("PostImage"));
					 post.setPostUsuarioId(rs.getInt("PostIDUsuario"));
					 post.setPostFecha(rs.getDate("PostFechaCreacion"));
					 post.setPostPuntaje(rs.getInt("PostPuntaje"));
					 
					 lista.add(post);
					 
				 }

		 }
		catch(Exception e)
			{
				e.printStackTrace();
			}
		finally
			{
				cn.close();
			}
		
	return lista;
	}

	@Override
	public boolean CrearPost(posts Posteo) {
		cn = new Conexion();
		cn.Open();
		boolean estado = true;
		
		String query= "INSERT INTO posts (PostTitulos, PostDescripcion, PostTexto, PostImage, PostIDCategoria, PostIDUsuario) VALUES ('"+Posteo.getPostTitulo()+"', '"+Posteo.getPostIntroduccion()+"', '"+Posteo.getPostTexto()+"', '"+Posteo.getPostImagen()+"', '"+Posteo.getPostCategoria()+"', '"+Posteo.getPostUsuarioId()+"')";
		System.out.println(query);
		
		try
		 {
			estado = cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		
		return estado;
	}

	@Override
	public boolean ModificarPost(posts Posteo) {
		boolean estado=true;

		Conexion cn = new Conexion();
		cn.Open();	

		String query = "UPDATE  posts SET PostTitulos='"+Posteo.getPostTitulo()+"', PostDescripcion='"+Posteo.getPostIntroduccion() + "', PostTexto='" + Posteo.getPostTexto() + "', PostImage='" + Posteo.getPostImagen() + "', PostIDCategoria ='" + Posteo.getPostCategoria() + "' WHERE PostId='"+Posteo.getPostId()+"' AND PostEstado=1";
		System.out.println(query);
		try
		 {
			estado = cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean BorrarPost(int idPosteo) {
		boolean estado=true;
		Conexion cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE posts SET PostEstado = 0 WHERE PostId= "+idPosteo;
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean VerificarLike(int idPosteo, int idUsuario) {
		boolean estado=true;
		ResultSet rs;
		Conexion cn = new Conexion();
		cn.Open();		 
		String query = "SELECT * FROM puntuacionxpost WHERE puntosIdPost = "+ idPosteo +" AND puntosIdUsuario = "+ idUsuario;
		try
		 {
			rs = cn.query(query);
			if (rs.next() == true)
			{
				estado = true;
			}
			else
				estado = false;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean Like(int idPosteo, int idUsuario) {
		boolean estado=true;
		Conexion cn = new Conexion();
		cn.Open();		 
		String query = "INSERT INTO puntuacionxpost (puntosIdPost, puntosIdUsuario, PuntuacionPuntaje) VALUES ("+ idPosteo +","+ idUsuario +",1)";
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean Dislike(int idPosteo, int idUsuario) {
		boolean estado=true;
		Conexion cn = new Conexion();
		cn.Open();
		String query = "DELETE FROM puntuacionxpost WHERE puntosIdPost = "+ idPosteo +" AND puntosIdUsuario = "+ idUsuario +" AND PuntuacionPuntaje = 1";
		//String query = "UPDATE puntuacionxpost SET PuntuacionPuntaje = 0 WHERE puntosIdPost = "+ idPosteo +" AND puntosIdUsuario = "+ idUsuario;
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean SumarLike(int idPosteo) {
		boolean estado=true;
		Conexion cn = new Conexion();
		cn.Open();
		String query = "UPDATE posts SET PostPuntaje = PostPuntaje+1 WHERE PostId = " + idPosteo;
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean RestarLike(int idPosteo) {
		boolean estado=true;
		Conexion cn = new Conexion();
		cn.Open();
		String query = "UPDATE posts SET PostPuntaje = PostPuntaje-1 WHERE PostId = " + idPosteo;
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	@Override
	public ArrayList<posts> ReportesDestacados(String desde, String hasta) 
	{
		cn = new Conexion();
		cn.Open();
		ResultSet rs;
		
		ArrayList<posts> lista = new ArrayList<posts>();
		String query ="Select PostPuntaje, PostId, PostTitulos   from posts where PostEstado = 1 and PostFechaCreacion between '"+desde+" 00:00:00.000' AND '"+hasta+" 23:59:59.000' ORDER BY PostPuntaje DESC limit 5";
		System.out.println(query);
		 try
		 {
			 rs= cn.query(query);
			 
				 while(rs.next())
				 {
					 posts post = new posts();
					 
					 post.setPostId(rs.getInt("PostId"));
					 post.setPostTitulo(rs.getString("PostTitulos"));
					 post.setPostPuntaje(rs.getInt("PostPuntaje"));
					 
					 lista.add(post);
					 
				 }

		 }
		catch(Exception e)
			{
				e.printStackTrace();
			}
		finally
			{
				cn.close();
			}
		
	return lista;
	}
	
	
	
	
	public List<posts> getRecords(int start,int total){
		Conexion cn;
		cn = new Conexion();
		cn.Open();
		List<posts> lista = new ArrayList<posts>();
		
		String query = "select * from posts WHERE PostPuntaje >= 5 AND PostEstado = 1 limit "+(start-1)+","+total;
		
		try{
			ResultSet rs = cn.query(query);
			
			while(rs.next()){
				posts post=new posts();
				
				 post.setPostId(rs.getInt("PostId"));
				 post.setPostTitulo(rs.getString("PostTitulos"));
				 post.setPostIntroduccion(rs.getString("PostDescripcion"));
				 post.setPostTexto(rs.getString("PostTexto"));
				 post.setPostCategoria(rs.getInt("PostIDCategoria"));
				 post.setPostImagen(rs.getString("PostImage"));
				 post.setPostUsuarioId(rs.getInt("PostIDUsuario"));
				 post.setPostFecha(rs.getDate("PostFechaCreacion"));
				 post.setPostPuntaje(rs.getInt("PostPuntaje"));
				 
				lista.add(post);
			}
			cn.close();
		}catch(Exception e){System.out.println(e);}
		
		
		
		return lista;
	}
	
}
