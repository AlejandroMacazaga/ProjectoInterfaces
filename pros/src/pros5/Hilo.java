package pros5;


public class Hilo extends Thread {
	private static int num_global = 0;
	private int num;
	public Hilo() {
		num_global++;
		num = num_global;
	}
	
	public void run() {
		for(int i = 0; i < 5; i++) {
			String timeStamp = new java.text.SimpleDateFormat("HH:mm:ss")
					.format(new java.util.Date());
			System.out.println("Hilo "  + num + " - " + timeStamp);
			try {
				this.sleep(1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
