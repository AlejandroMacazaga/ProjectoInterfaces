package auxiliares;

public class Participacion {
	private int id_deportista, id_evento, id_equipo;
	private int edad;
	private String medalla;
	
	public Participacion(int id_deportista, int id_evento, int id_equipo, int edad, String medalla) {
		this.id_deportista = id_deportista;
		this.id_evento = id_evento;
		this.id_equipo = id_equipo;
		this.edad = edad;
		this.medalla = medalla;
	}

	
	@Override
	public String toString() {
		return "deportista: " + id_deportista + ", evento:" + id_evento + ", equipo:" + id_equipo
				+ ", edad:" + edad + ", medalla: " + medalla;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edad;
		result = prime * result + id_deportista;
		result = prime * result + id_equipo;
		result = prime * result + id_evento;
		result = prime * result + ((medalla == null) ? 0 : medalla.hashCode());
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
		Participacion other = (Participacion) obj;
		if (edad != other.edad)
			return false;
		if (id_deportista != other.id_deportista)
			return false;
		if (id_equipo != other.id_equipo)
			return false;
		if (id_evento != other.id_evento)
			return false;
		if (medalla == null) {
			if (other.medalla != null)
				return false;
		} else if (!medalla.equals(other.medalla))
			return false;
		return true;
	}


	public int getId_deportista() {
		return id_deportista;
	}


	public int getId_evento() {
		return id_evento;
	}


	public int getId_equipo() {
		return id_equipo;
	}


	public int getEdad() {
		return edad;
	}


	public String getMedalla() {
		return medalla;
	}
	
	
	
}