package pros3;

public class Hilo extends Thread {
	private String texto;

	
	public Hilo(String texto) {
		this.texto = texto;
	}
	
	public void run() {
		super.run();
		System.out.println("Ejecutando " + texto);
	}
}
