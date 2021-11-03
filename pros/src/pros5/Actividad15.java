package pros5;

public class Actividad15 {
	public static void main(String[] args) {
		Hilo h1 = new Hilo();
		Hilo h2 = new Hilo();
		Hilo h3 = new Hilo();
		h1.start();
		h2.start();
		h3.start();
	}
}
