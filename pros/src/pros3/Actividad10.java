package pros3;

public class Actividad10 {
	public static void main(String[] args) {
		Thread current = Thread.currentThread();
		
		Hilo hThread0 = new Hilo("Hilo-prioridad 3");
		Hilo hThread1 = new Hilo("Hilo-prioridad 7");
		hThread0.setPriority(3);
		hThread1.setPriority(7);
		System.out.println(current.getName() + " tiene la prioridad " + current.getPriority());
		System.out.println(hThread0.getName() + " tiene la prioridad " + hThread0.getPriority());
		System.out.println(hThread1.getName() + " tiene la prioridad " + hThread1.getPriority());
		hThread1.start();
		hThread0.start();
		
		System.out.println("Fin del programa");

	}
}
