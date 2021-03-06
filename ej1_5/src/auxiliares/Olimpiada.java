package auxiliares;

public class Olimpiada {
	private int id_olimpiada;
	private String nombre;
	private String anio;
	private	String temporada;
	private String ciudad;
	
	public Olimpiada(int id_olimpiada, String nombre, String anio, String temporada, String ciudad) {
		super();
		this.id_olimpiada = id_olimpiada;
		this.nombre = nombre;
		this.anio = anio;
		this.temporada = temporada;
		this.ciudad = ciudad;
	}

	public int getId_olimpiada() {
		return id_olimpiada;
	}
	
	@Override
	public String toString() {
		return id_olimpiada + ". " + nombre + " " + ciudad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anio == null) ? 0 : anio.hashCode());
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + id_olimpiada;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((temporada == null) ? 0 : temporada.hashCode());
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
		Olimpiada other = (Olimpiada) obj;
		if (anio == null) {
			if (other.anio != null)
				return false;
		} else if (!anio.equals(other.anio))
			return false;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (id_olimpiada != other.id_olimpiada)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (temporada == null) {
			if (other.temporada != null)
				return false;
		} else if (!temporada.equals(other.temporada))
			return false;
		return true;
	}

	public String getNombre() {
		return nombre;
	}

	public String getAnio() {
		return anio;
	}

	public String getTemporada() {
		return temporada;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
	
	
	
}
