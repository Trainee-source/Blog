package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.CategoriasDao;
import entidad.categorias;
import entidad.posts;
import entidad.usuarios;

public class CategoriasImpl implements CategoriasDao
{
	private Conexion cn;
	
	@Override
	public ArrayList<categorias> ObtenerCategorias() 
	{
		cn = new Conexion();
		cn.Open();
		ResultSet rs;
		
		ArrayList<categorias> lista = new ArrayList<categorias>();
		String query ="Select * from categorias";
		System.out.println(query);
		 try
		 {
			 rs= cn.query(query);
			 
				 while(rs.next())
				 {
					 categorias cats = new categorias();
					 
					 cats.setCategoriaId(rs.getInt("CatId"));
					 cats.setCategoriaNombre(rs.getString("CatNombre"));
					 
					 lista.add(cats);
					 
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
	public boolean InsertarCategoria(String cat) 
	{
		cn = new Conexion();
		cn.Open();
		boolean estado = true;
		
		String query= "INSERT INTO categorias (CatNombre) VALUES ('"+cat+"')";
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
	public boolean VerificarCategoria(String nombre) 
	{
		boolean estado = true;
		ResultSet rs;
		Conexion cn = new Conexion();
		cn.Open();		 
		String query = "SELECT * from categorias WHERE CatNombre = '" + nombre+"'";
		System.out.println(query);
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
	public boolean ModificarCategoria(int id, String nombre, byte state) 
	{
		boolean estado=true;

		Conexion cn = new Conexion();
		cn.Open();	

		String query = "UPDATE  categorias SET CatNombre ='"+nombre+"', CatEstado = '"+state+"' where CatId='"+id+"'";
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
	public String TraerNombreCategoria(int idCategoria) {
		ResultSet rs = null;
		String categoria = "";
		Conexion cn = new Conexion();
		cn.Open();
		
		String query = "SELECT CatNombre FROM categorias WHERE CatId = '" + idCategoria + "'";
		
		try
		 {
			rs = cn.query(query);
			while (rs.next())
			{
				categoria = rs.getString("categorias.CatNombre");
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
		
		return categoria;
	}

	@Override
	public categorias ObtenerUno(int categoriaId) {
		cn = new Conexion();
		categorias categoria = new categorias();
		cn.Open();
		ResultSet rs;
		
		String query ="SELECT CatNombre, CatEstado FROM categorias WHERE CatId = " + categoriaId;
		System.out.println(query);
		 try
		 {
			 rs= cn.query(query);
				 while(rs.next())
				 {
					 categoria.setCategoriaId(categoriaId);
					 categoria.setCategoriaNombre(rs.getString("CatNombre"));
					 categoria.setCategoriaEstado(rs.getInt("CatEstado"));
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
		 
	return categoria;
	}

	@Override
	public ArrayList<categorias> ObtenerBusqueda(String busqueda) {
		cn = new Conexion();
		cn.Open();
		ResultSet rs;
		
		ArrayList<categorias> lista = new ArrayList<categorias>();
		
		String query ="Select * from categorias where CatNombre = '"+busqueda+"%'";
		System.out.println(query);
		
		 try
		 {
			 rs= cn.query(query);
			 
				 while(rs.next())
				 {
					 categorias Cats = new categorias();
					 
					 Cats.setCategoriaId(rs.getInt("CatId"));
					 Cats.setCategoriaNombre(rs.getString("CatNombre"));
					 Cats.setCategoriaEstado(rs.getInt("CatEstado"));
					 
					 lista.add(Cats);
					 
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
	public ArrayList<categorias> ObtenerPagina(int offset, int noOfRecords) {
		cn = new Conexion();
		cn.Open();
		ResultSet rs;
		offset = (offset - 1) * noOfRecords;
		ArrayList<categorias> lista = new ArrayList<categorias>();
		String query ="select SQL_CALC_FOUND_ROWS * from categorias limit "+offset+","+ noOfRecords;
		System.out.println(query);
		 try
		 {
			 rs= cn.query(query);
			 
				 while(rs.next())
				 {
					 categorias cats = new categorias();
					 
					 cats.setCategoriaId(rs.getInt("CatId"));
					 cats.setCategoriaNombre(rs.getString("CatNombre"));
					 cats.setCategoriaEstado(rs.getInt("CatEstado"));
					 lista.add(cats);
					 
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
	public int ContarPaginas() {
		int paginas = 0;
		ResultSet rs = null;
		Conexion cn = new Conexion();
		cn.Open();	

		String query = "select COUNT(*) from categorias";
		System.out.println(query);
		try
		 {
			rs = cn.query(query);
			rs.next();
			paginas = rs.getInt(1);
			paginas = ( paginas + 4 ) / 5;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return paginas;
	}

	@Override
	public ArrayList<categorias> ObtenerTodos() {
		cn = new Conexion();
		cn.Open();
		ResultSet rs;
		
		ArrayList<categorias> lista = new ArrayList<categorias>();
		String query ="Select * from categorias";
		System.out.println(query);
		 try
		 {
			 rs= cn.query(query);
			 
				 while(rs.next())
				 {
					 categorias cats = new categorias();
					 
					 cats.setCategoriaId(rs.getInt("CatId"));
					 cats.setCategoriaNombre(rs.getString("CatNombre"));
					 cats.setCategoriaEstado(rs.getInt("CatEstado"));
					 lista.add(cats);
					 
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
	public ArrayList<categorias> ReportesCategorias(String desde, String hasta) {
		cn = new Conexion();
		cn.Open();
		ResultSet rs;
		
		
		ArrayList<categorias> lista = new ArrayList<categorias>();
		String query ="select CatId, CatNombre, COUNT(PostId) as Cantidad from categorias INNER JOIN posts on PostIDCategoria = CatId and PostFechaCreacion between '"+desde+" 00:00:00.000' and '"+hasta+" 23:59:59.000' GROUP BY 1 ORDER BY Cantidad DESC LIMIT 5";
		System.out.println(query);
		 try
		 {
			 rs= cn.query(query);
			 
				 while(rs.next())
				 {
					 categorias cats = new categorias();
					 
					 cats.setCategoriaId(rs.getInt("CatId"));
					 cats.setCategoriaNombre(rs.getString("CatNombre"));
					 cats.setCantidadPosts(rs.getInt("Cantidad"));
					 
					 lista.add(cats);
					 
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

	
	
}		
