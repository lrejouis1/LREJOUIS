module Occurences {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires junit;
	requires java.sql;
	
	
	opens application to javafx.graphics, javafx.fxml;
	opens javaFXControllers to javafx.graphics, javafx.fxml;

}
