package pros;

public class Hilo extends Thread {
	private String texto;
	public Hilo(String texto) {
		this.texto = texto;
	}
	public void run() {
		for (int i=1;i<100;i++)
			System.out.println(texto + " " + i);
	}
		
}

