package auxiliares;

public class Deporte {
	private int id_deporte;
	private String nombre;
	
	public Deporte(String nombre) {
		this.id_deporte = 0;
	}
	
	public Deporte(int id, String nombre) {
		this.id_deporte = id;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return id_deporte + ", " + nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_deporte;
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
		Deporte other = (Deporte) obj;
		if (id_deporte != other.id_deporte)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public int getId_deporte() {
		return id_deporte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	
}
