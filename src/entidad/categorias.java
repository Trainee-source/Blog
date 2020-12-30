package entidad;

public class categorias 
{
	private int CategoriaId;
	private String CategoriaNombre;
	private int CategoriaEstado;
	private int CantidadPosts;
	
	public categorias() 
	{
	}
	
	public int getCantidadPosts() {
		return CantidadPosts;
	}

	public void setCantidadPosts(int cantidadPosts) {
		CantidadPosts = cantidadPosts;
	}

	public categorias(String categoriaNombre) 
	{
	
		CategoriaNombre = categoriaNombre;
	}



	public int getCategoriaId() {
		return CategoriaId;
	}

	public void setCategoriaId(int categoriaId) {
		CategoriaId = categoriaId;
	}

	public String getCategoriaNombre() {
		return CategoriaNombre;
	}

	public void setCategoriaNombre(String nom) {
		CategoriaNombre = nom;
	}
	
	public int getCategoriaEstado() {
		return CategoriaEstado;
	}

	public void setCategoriaEstado(int categoriaEstado) {
		CategoriaEstado = categoriaEstado;
	}
	
	

}
