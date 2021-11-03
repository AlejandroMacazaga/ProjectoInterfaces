package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import aux.Person;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class tableController implements Initializable {
	@FXML
	private Button btnAgregar/* , btnEliminar, btnModificar */;
	/*
	 * @FXML private TextField txtNombre, txtApellidos, txtEdad;
	 */

	@FXML
	private TableView<Person> table;

	@FXML
	private TableColumn<Person, String> rowNombre;

	@FXML
	private TableColumn<Person, String> rowApellidos;

	@FXML
	private TableColumn<Person, String> rowEdad;

	private static ObservableList<Person> data = FXCollections.observableArrayList();

	/*
	 * @FXML public void agregar(ActionEvent event) throws Exception {
	 * 
	 * try { String nombre = txtNombre.getText(); String apellidos =
	 * txtApellidos.getText(); int edad = Integer.parseInt(txtEdad.getText());
	 * Person p = new Person(nombre, apellidos, edad); if(!data.contains(p)) {
	 * data.add(p); }
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */

	@FXML
	public void agregar(ActionEvent event) throws Exception {
		System.out.println("Pog");
		try {
			Locale locale = new Locale("es", "ES");
			BufferedReader br = new BufferedReader(new FileReader(new File("language")));
			String line;
			if ((line = br.readLine()) != null) {
				locale = new Locale(line.trim().substring(0, line.trim().indexOf(' ')),
						line.trim().substring(line.trim().indexOf(' ') + 1));
			}
			br.close();

			ResourceBundle bundle = ResourceBundle.getBundle("strings", locale);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/recogidaDatos.fxml"), bundle);
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			Stage myStage = (Stage) this.btnAgregar.getScene().getWindow();
			stage.initOwner(myStage);
			stage.setScene(scene);
			stage.setTitle("Nuevo Usuario");
			stage.showAndWait();
			recogidaDatosController controller = loader.getController();
			Person p = controller.getPerson();
			if(!data.contains(p) && p != null) data.add(p);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * @FXML public void modificar(ActionEvent event) throws Exception { Person p =
	 * table.getSelectionModel().getSelectedItem(); if(!p.equals(null)) { String
	 * nombre = txtNombre.getText(); String apellidos = txtApellidos.getText();
	 * 
	 * if(!nombre.isEmpty()) { p.setName(nombre); } if(!apellidos.isEmpty()) {
	 * p.setSurname(apellidos); } if(!txtEdad.getText().isEmpty()) { int edad =
	 * Integer.parseInt(txtEdad.getText()); p.setAge(edad); } table.refresh(); } }
	 */

	/*
	 * @FXML public void eliminar(ActionEvent event) throws Exception { Person p =
	 * table.getSelectionModel().getSelectedItem(); if(!p.equals(null)) {
	 * data.remove(p); } }
	 */

	@FXML
	public void initialize(URL arg0, ResourceBundle arg1) {
		table.setItems(data);
		rowNombre.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
		rowApellidos.setCellValueFactory(new PropertyValueFactory<Person, String>("surname"));
		rowEdad.setCellValueFactory(new PropertyValueFactory<Person, String>("age"));

	}

}

