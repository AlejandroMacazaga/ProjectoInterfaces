package pros;

public class Actividad1 {
	public static void main(String[] args) {
		Hilo p = new Hilo("Primero");
		Hilo s = new Hilo("Segundo");
		p.start();
		s.start();
		System.out.println("Fin del programa");
	}
}
