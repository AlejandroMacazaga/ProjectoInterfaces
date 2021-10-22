package pros2;

public class Posicion implements Runnable {
	
	private String pos;
	
	public Posicion(String pos) {
		this.pos = pos;
	}
	@Override
	public void run() {
		for (int i=1;i<100;i++)
			System.out.println( pos + " " + i );
	}
}


