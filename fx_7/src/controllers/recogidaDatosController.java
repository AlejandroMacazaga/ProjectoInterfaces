package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import aux.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class recogidaDatosController implements Initializable {

	@FXML
	Button btnCancelar, btnAceptar;
	
	@FXML
	TextField txtNombre, txtApellidos, txtEdad;
	
	private Person p;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void aceptar(ActionEvent event) throws Exception {
		String nombre = txtNombre.getText(); 
		String apellidos = txtApellidos.getText(); 
		int edad = Integer.parseInt(txtEdad.getText());
		this.p = new Person(nombre, apellidos, edad);
		Stage stage = (Stage) btnAceptar.getScene().getWindow();
		System.out.println("POG");
	    stage.close();
		
	}
	
	@FXML
	public void cancelar(ActionEvent event) throws Exception {
		p = null;
		Stage stage = (Stage) btnCancelar.getScene().getWindow();
		stage.close();
	}
	
	public Person getPerson() {
		return p;
	}
	
	public void setPerson(Person p) {
		this.p = p;
		txtNombre.setText(p.getName());
		txtApellidos.setText(p.getSurname());
		txtEdad.setText(p.getAge() + "");
	}

}
