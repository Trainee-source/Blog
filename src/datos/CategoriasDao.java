package datos;

import java.util.ArrayList;
import java.util.List;
import entidad.categorias;

public interface CategoriasDao 
{
	
	public ArrayList<categorias> ObtenerCategorias();
	public ArrayList<categorias> ObtenerTodos();
	public boolean InsertarCategoria(String cat);
	public boolean VerificarCategoria(String nombre);
	public boolean ModificarCategoria(int id, String nombre, byte state);
	public String TraerNombreCategoria(int idCategoria);
	public categorias ObtenerUno(int categoriaId);
	
	public ArrayList<categorias> ObtenerBusqueda( String busqueda);
	public ArrayList<categorias> ObtenerPagina( int offset, int noOfRecords);
	public int ContarPaginas();
	public ArrayList<categorias> ReportesCategorias( String desde, String hasta);
	
}
