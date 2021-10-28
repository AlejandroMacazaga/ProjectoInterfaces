package controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;

import javafx.scene.control.TextField;

import javafx.scene.control.RadioButton;
import aux.Operacion;
import javafx.event.ActionEvent;

public class calculadoraController {
	@FXML
	private Button btnCalcular;
	@FXML
	private ToggleGroup GrupoToggle;
	@FXML
	private TextField txtOperador1;
	@FXML
	private TextField txtOperador2;
	@FXML
	private TextField txtResultado;
	@FXML
	private RadioButton btnRestar;
	@FXML
	private RadioButton btnSumar;
	@FXML
	private RadioButton btnMultiplicar;
	@FXML
	private RadioButton btnDividir;

	// Event Listener on Button[#btnCalcular].onAction
	@FXML
	public void calcular(ActionEvent event) {
		Operacion o = new Operacion(Double.parseDouble(txtOperador1.getText()), Double.parseDouble(txtOperador2.getText()));
		
		if(btnSumar.isSelected()) {
			txtResultado.setText(o.sumar() + "");
		}
		if(btnRestar.isSelected()) {
			txtResultado.setText(o.restar() + "");
		}
		if(btnMultiplicar.isSelected()) {
			txtResultado.setText(o.multiplicar() + "");
		}
		if(btnDividir.isSelected()) {
			txtResultado.setText(o.dividir() + "");
		}
	}
}
