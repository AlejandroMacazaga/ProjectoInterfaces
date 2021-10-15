package pros;

public class Actividad3 {
	public static void main(String[] args) {
		Thread t1 = new Thread();
		System.out.println("El nombre del Thread es " + t1.getName() 
		+ " y tiene la prioridad " + t1.getPriority());
		t1.setName("SUPER-HILO-DM2");
		t1.setPriority(6);
		System.out.println("El nombre del Thread es " + t1.getName() 
		+ " y tiene la prioridad " + t1.getPriority());
	}
}
