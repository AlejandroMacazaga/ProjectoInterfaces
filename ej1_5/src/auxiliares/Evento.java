package auxiliares;

public class Evento {
	private int id_evento, id_olimpiada, id_deporte;
	private String nombre;
	
	public Evento(int id_olimpiada, int id_deporte, String nombre) {
		super();
		this.id_evento = 0;
		this.id_olimpiada = id_olimpiada;
		this.id_deporte = id_deporte;
		this.nombre = nombre;
	}
	
	public Evento(int id_evento, int id_olimpiada, int id_deporte, String nombre) {
		super();
		this.id_evento = id_evento;
		this.id_olimpiada = id_olimpiada;
		this.id_deporte = id_deporte;
		this.nombre = nombre;
	}
	
	

	@Override
	public String toString() {
		return "Evento [id_evento=" + id_evento + ", id_olimpiada=" + id_olimpiada + ", id_deporte=" + id_deporte
				+ ", nombre=" + nombre + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_deporte;
		result = prime * result + id_evento;
		result = prime * result + id_olimpiada;
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
		Evento other = (Evento) obj;
		if (id_deporte != other.id_deporte)
			return false;
		if (id_evento != other.id_evento)
			return false;
		if (id_olimpiada != other.id_olimpiada)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public int getId_evento() {
		return id_evento;
	}
	
	public int getId_olimpiada() {
		return id_olimpiada;
	}
	
	public int getId_deporte() {
		return id_deporte;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	
}
