package pros;


public class Actividad2 {
	public static void main(String[] args) {
		crearNHilos(20);
		System.out.println("Fin del programa.");
	}
	
	private static void crearNHilos(int n) {
		for(int i = 1; i <= n; i++) {
			new Hilo2().run();
		}
	}
}
