package pros2;

public class Primero extends Thread {
	public void run() {
		for (int i=1;i<=15;i++)
		{
		System.out.println( "Primero " + i );
		try {
			sleep (100);
			} 	
			catch (InterruptedException e) {
				}
		}
	}
}
