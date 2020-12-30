package entidad;
import java.util.Date;

public class usuarios {
	private int Usuarioid;
	private String UsuarioNombre;
	private String UsuarioApellido;
	private String UsuarioMail;
	private String UsuarioContraseña;
	private String UsuarioUrlImagen;
	private int UsuarioEstado;
	private Date UsuarioFecha;
	private int UsuarioTipo;
	
	public usuarios() {
		Usuarioid = 0;
		UsuarioNombre = "";
		UsuarioApellido = "";
		UsuarioMail = "";
		UsuarioUrlImagen = "";
		UsuarioEstado = 0;
		UsuarioContraseña = "";
	}

	public usuarios(String usuarioNombre, String usuarioApellido, String usuarioMail, String usuarioUrlImagen,
			int usuarioEstado, String usuarioContraseña) 
	{
		UsuarioNombre = usuarioNombre;
		UsuarioApellido = usuarioApellido;
		UsuarioMail = usuarioMail;
		UsuarioUrlImagen = usuarioUrlImagen;
		UsuarioEstado = usuarioEstado;
		UsuarioContraseña = usuarioContraseña;
	}

	public String getUsuarioContraseña() {
		return UsuarioContraseña;
	}

	public void setUsuarioContraseña(String usuarioContraseña) {
		UsuarioContraseña = usuarioContraseña;
	}

	public int getUsuarioid() {
		return Usuarioid;
	}

	public void setUsuarioid(int usuarioid) {
		Usuarioid = usuarioid;
	}

	public String getUsuarioNombre() {
		return UsuarioNombre;
	}

	public void setUsuarioNombre(String usuarioNombre) {
		UsuarioNombre = usuarioNombre;
	}

	public String getUsuarioApellido() {
		return UsuarioApellido;
	}

	public void setUsuarioApellido(String usuarioApellido) {
		UsuarioApellido = usuarioApellido;
	}

	public String getUsuarioMail() {
		return UsuarioMail;
	}

	public void setUsuarioMail(String usuarioMail) {
		UsuarioMail = usuarioMail;
	}

	public String getUsuarioUrlImagen() {
		return UsuarioUrlImagen;
	}

	public void setUsuarioUrlImagen(String usuarioUrlImagen) {
		UsuarioUrlImagen = usuarioUrlImagen;
	}

	public int getUsuarioEstado() {
		return UsuarioEstado;
	}

	public void setUsuarioEstado(int usuarioEstado) {
		UsuarioEstado = usuarioEstado;
	}

	public Date getUsuarioFecha() {
		return UsuarioFecha;
	}
	
	public void setUsuarioFecha(Date usuarioFecha)
	{
		UsuarioFecha = usuarioFecha;
	}
	
	public int getUsuarioTipo() {
		return UsuarioTipo;
	}
	
	public void setUsuarioTipo(int tipo) 
	{
		UsuarioTipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UsuarioApellido == null) ? 0 : UsuarioApellido.hashCode());
		result = prime * result + ((UsuarioContraseña == null) ? 0 : UsuarioContraseña.hashCode());
		result = prime * result + UsuarioEstado;
		result = prime * result + ((UsuarioFecha == null) ? 0 : UsuarioFecha.hashCode());
		result = prime * result + ((UsuarioMail == null) ? 0 : UsuarioMail.hashCode());
		result = prime * result + ((UsuarioNombre == null) ? 0 : UsuarioNombre.hashCode());
		result = prime * result + UsuarioTipo;
		result = prime * result + ((UsuarioUrlImagen == null) ? 0 : UsuarioUrlImagen.hashCode());
		result = prime * result + Usuarioid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		usuarios other = (usuarios) obj;
		if (UsuarioApellido == null) {
			if (other.UsuarioApellido != null)
				return false;
		} else if (!UsuarioApellido.equals(other.UsuarioApellido))
			return false;
		if (UsuarioContraseña == null) {
			if (other.UsuarioContraseña != null)
				return false;
		} else if (!UsuarioContraseña.equals(other.UsuarioContraseña))
			return false;
		if (UsuarioEstado != other.UsuarioEstado)
			return false;
		if (UsuarioFecha == null) {
			if (other.UsuarioFecha != null)
				return false;
		} else if (!UsuarioFecha.equals(other.UsuarioFecha))
			return false;
		if (UsuarioMail == null) {
			if (other.UsuarioMail != null)
				return false;
		} else if (!UsuarioMail.equals(other.UsuarioMail))
			return false;
		if (UsuarioNombre == null) {
			if (other.UsuarioNombre != null)
				return false;
		} else if (!UsuarioNombre.equals(other.UsuarioNombre))
			return false;
		if (UsuarioTipo != other.UsuarioTipo)
			return false;
		if (UsuarioUrlImagen == null) {
			if (other.UsuarioUrlImagen != null)
				return false;
		} else if (!UsuarioUrlImagen.equals(other.UsuarioUrlImagen))
			return false;
		if (Usuarioid != other.Usuarioid)
			return false;
		return true;
	}
	
	

}
