package aux;

public class Error {
	private String message;
	private boolean status;
	public Error(String message) {
		this.message = message;
		this.status = true;
	}
	
	public Error() {
		this.status = false;
	}
	
	public void printmsg() {
		if(status)
			System.out.println(message);
		
	}
}
