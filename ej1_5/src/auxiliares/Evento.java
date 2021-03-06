package auxiliares;

public class Evento {
	private int id_evento;
	private Olimpiada olimpiada;
	private Deporte deporte;
	private String nombre;
	
	public Evento(int id_evento, Olimpiada olimpiada, Deporte deporte, String nombre) {
		super();
		this.id_evento = id_evento;
		this.olimpiada = olimpiada;
		this.deporte = deporte;
		this.nombre = nombre;
	}
	
	

	@Override
	public String toString() {
		return "Evento de " + olimpiada.getNombre() + " en deporte " + deporte.getNombre()
				+ " con nombre " + nombre;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deporte == null) ? 0 : deporte.hashCode());
		result = prime * result + id_evento;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((olimpiada == null) ? 0 : olimpiada.hashCode());
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
		if (deporte == null) {
			if (other.deporte != null)
				return false;
		} else if (!deporte.equals(other.deporte))
			return false;
		if (id_evento != other.id_evento)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (olimpiada == null) {
			if (other.olimpiada != null)
				return false;
		} else if (!olimpiada.equals(other.olimpiada))
			return false;
		return true;
	}

	

	public Olimpiada getOlimpiada() {
		return olimpiada;
	}



	public void setOlimpiada(Olimpiada olimpiada) {
		this.olimpiada = olimpiada;
	}



	public Deporte getDeporte() {
		return deporte;
	}



	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}



	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getId_evento() {
		return id_evento;
	}


	public String getNombre() {
		return nombre;
	}
	
	
	
}
