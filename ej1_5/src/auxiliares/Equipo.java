package auxiliares;

public class Equipo {
	private int id_equipo;
	private String nombre;
	private String iniciales;
	public Equipo(int id_equipo, String nombre, String iniciales) {
		super();
		this.id_equipo = id_equipo;
		this.nombre = nombre;
		this.iniciales = iniciales;
	}
	public int getId_equipo() {
		return id_equipo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_equipo;
		result = prime * result + ((iniciales == null) ? 0 : iniciales.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Equipo other = (Equipo) obj;
		if (id_equipo != other.id_equipo)
			return false;
		if (iniciales == null) {
			if (other.iniciales != null)
				return false;
		} else if (!iniciales.equals(other.iniciales))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	public String getNombre() {
		return nombre;
	}
	public String getIniciales() {
		return iniciales;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}
	
	
}
