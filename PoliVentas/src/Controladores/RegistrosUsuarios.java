package Controladores;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RegistrosUsuarios {

	@FXML
	private TextField nombres, apellidos, usuario, cedula, direccion, telefono, correo, matricula;
	@FXML
	private AnchorPane registrosUsuarios;
	@FXML
	private ComboBox<String> perfil;
	@FXML
	private CheckBox ws_si, ws_no;

	@FXML
	public void initialize() {
		perfil.getItems().removeAll(perfil.getItems());
		perfil.getItems().add("VENDEDOR");
		perfil.getItems().add("COMPRADOR");

	}

	@FXML
	public void registrar() throws IOException {
		AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaPrincipal.fxml"));
		this.registrosUsuarios.getChildren().setAll(pane);
	}
	
	
}
