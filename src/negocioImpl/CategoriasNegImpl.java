package negocioImpl;

import java.util.ArrayList;
import java.util.List;

import datos.CategoriasDao;
import datosImpl.CategoriasImpl;
import entidad.categorias;
import negocio.CategoriasNeg;

public class CategoriasNegImpl implements CategoriasNeg
{
	private CategoriasDao catsDao = new CategoriasImpl();
	
	@Override
	public ArrayList<categorias> ObtenerCategorias() 
	{
		return catsDao.ObtenerCategorias();
	}

	@Override
	public boolean InsertarCategoria(String cat) 
	{
		return catsDao.InsertarCategoria(cat);
	}

	@Override
	public boolean VerificarCategoria(String nombre) 
	{
		return catsDao.VerificarCategoria(nombre);
	}

	@Override
	public boolean ModificarCategoria(int id, String nombre, byte state) 
	{
		return catsDao.ModificarCategoria(id, nombre, state);
	}

	@Override
	public String TraerNombreCategoria(int idCategoria) {
		return catsDao.TraerNombreCategoria(idCategoria);
	}

	@Override
	public categorias ObtenerUno(int categoriaId) {
		return catsDao.ObtenerUno(categoriaId);
	}

	@Override
	public ArrayList<categorias> ObtenerBusqueda(String busqueda) {
		return catsDao.ObtenerBusqueda(busqueda);
	}

	@Override
	public ArrayList<categorias> ObtenerPagina(int offset, int noOfRecords) {
		return catsDao.ObtenerPagina(offset, noOfRecords);
	}

	@Override
	public int ContarPaginas() {
		return catsDao.ContarPaginas();
	}

	@Override
	public ArrayList<categorias> ObtenerTodos() {
		return catsDao.ObtenerTodos();
	}

	@Override
	public ArrayList<categorias> ReportesCategorias(String desde, String hasta) 
	{
		return catsDao.ReportesCategorias(desde, hasta);
	}
	
	

}
