package pros;

public class Hilo2 extends Thread {
	private static int N = 0;
	private int n;
	public Hilo2() {
		N++;
		n = N;
	}
	
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println("Hilo " + n);
		}
	}
}
