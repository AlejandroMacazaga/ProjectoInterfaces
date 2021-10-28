package aux;

public class Operacion {
	private double op1, op2;
	public Operacion(double op1, double op2) {
		this.op1 = op1;
		this.op2 = op2;
	}
	
	public double sumar() {
		return op1 + op2;
	}
	
	public double restar() {
		return op1 - op2;
	}
	
	public double multiplicar() {
		return op1 * op2;
	}
	
	public double dividir() {
		return op1 / op2;
	}
}
