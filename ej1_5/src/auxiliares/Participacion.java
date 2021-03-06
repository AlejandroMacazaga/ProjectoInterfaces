package auxiliares;

public class Participacion {
	private Evento evento;
	private Deportista deportista;
	private Equipo equipo;
	private int edad;
	private String medalla;
	
	public Participacion(Evento evento, Deportista deportista, Equipo equipo, int edad, String medalla) {
		this.evento = evento;
		this.deportista = deportista;
		this.equipo = equipo;
		this.edad = edad;
		this.medalla = medalla;
	}




	@Override
	public String toString() {
		return "deportista: " + deportista.getNombre() + ", evento:" + evento.getNombre() + ", equipo:" + equipo.getNombre()
				+ ", edad:" + edad + ", medalla: " + medalla;
	}

	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deportista == null) ? 0 : deportista.hashCode());
		result = prime * result + edad;
		result = prime * result + ((equipo == null) ? 0 : equipo.hashCode());
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
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
		if (deportista == null) {
			if (other.deportista != null)
				return false;
		} else if (!deportista.equals(other.deportista))
			return false;
		if (edad != other.edad)
			return false;
		if (equipo == null) {
			if (other.equipo != null)
				return false;
		} else if (!equipo.equals(other.equipo))
			return false;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (medalla == null) {
			if (other.medalla != null)
				return false;
		} else if (!medalla.equals(other.medalla))
			return false;
		return true;
	}


	public Deportista getDeportista() {
		return deportista;
	}


	public Evento getEvento() {
		return evento;
	}


	public Equipo getEquipo() {
		return equipo;
	}


	public int getEdad() {
		return edad;
	}


	public String getMedalla() {
		return medalla;
	}




	public void setEvento(Evento evento) {
		this.evento = evento;
	}




	public void setDeportista(Deportista deportista) {
		this.deportista = deportista;
	}




	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}




	public void setEdad(int edad) {
		this.edad = edad;
	}




	public void setMedalla(String medalla) {
		this.medalla = medalla;
	}
	
	
	
}
