package Controladores;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Dashboard {

	@FXML
	private AnchorPane dashboard;
	
	@FXML
	private void ingresar(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaPrincipal.fxml"));
		this.dashboard.getChildren().setAll(pane);
		
	}
	
    public void initialize() {
		
		
	}
}
