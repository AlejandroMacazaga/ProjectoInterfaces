module fx_1 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	
	opens aux to javafx.graphics, javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
	opens controllers to javafx.graphics, javafx.fxml;
	exports aux;
}
