package auxiliares;

public class Deportista {
	private int id_deportista;
	private String nombre;
	private char sexo;
	private int peso;
	private int altura;
	
	public Deportista(String nombre, char sexo, int peso, int altura) {
		this.id_deportista = 0;
		this.nombre = nombre;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	public Deportista(int id_deportista, String nombre, char sexo, int peso, int altura) {
		this.id_deportista = id_deportista;
		this.nombre = nombre;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

	public int getId_deportista() {
		return id_deportista;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + altura;
		result = prime * result + id_deportista;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + peso;
		result = prime * result + sexo;
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
		Deportista other = (Deportista) obj;
		if (altura != other.altura)
			return false;
		if (id_deportista != other.id_deportista)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (peso != other.peso)
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id_deportista + ". " + nombre + ", " + (sexo == 'M' ? "mujer" : "hombre") + ", " + peso
				+ " kg, " + altura + " cm";
	}

	public String getNombre() {
		return nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public int getPeso() {
		return peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	
	
	
}
