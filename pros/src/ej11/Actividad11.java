package ej11;
import java.io.*;

public class Actividad11 {
	public static void main(String[] args){
		Runtime r=Runtime.getRuntime();
		String comando="java Ejemplo2"; // Comando a ejecutar
	    Process p=null;
		try {
			p = r.exec (comando); // Ejecutamos el comando
			InputStream is = p.getInputStream(); // Creamos un input stream que recoge lo que devuelva el commando
			BufferedReader br = new BufferedReader (new InputStreamReader(is));
			String linea;
			while((linea = br.readLine()) != null) // lee una linea
				System.out.println(linea);
			br.close();
			}
		catch (Exception e) {
				e.printStackTrace();
		}
		///// Comprobación: Valor= 0 bien, Valor = - 1 mal
		int exitVal;
		try {
				exitVal=p.waitFor(); // recogemos el valor de salida del comando
				System.out.println ("Valor de Salida "+exitVal + 
						(exitVal == 1 ? " sin errores." : " con errores"));
		}  catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}