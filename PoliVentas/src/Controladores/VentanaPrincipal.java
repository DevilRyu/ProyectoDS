package Controladores;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class VentanaPrincipal {

	@FXML
	private TextField usuario;
	@FXML
	private AnchorPane ventanaPrincipal;
	@FXML
	private PasswordField password;
	
	
	@FXML
	private void iniciar_sesion(ActionEvent event) throws IOException{
		if(this.usuario.getText().equals("comprador")) {
		AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaComprador.fxml"));
		this.ventanaPrincipal.getChildren().setAll(pane);
		}
		
		if(this.usuario.getText().equals("vendedor")) {
			AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaVendedor.fxml"));
			this.ventanaPrincipal.getChildren().setAll(pane);
			}
		
		if(this.usuario.getText().equals("admin")) {
			AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaAdmin.fxml"));
			this.ventanaPrincipal.getChildren().setAll(pane);
			}
		
	}
	
	@FXML
	private void registrar(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaRegistro.fxml"));
		this.ventanaPrincipal.getChildren().setAll(pane);
	}
	
	
	@FXML
	private void salir(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/dashboard.fxml"));
		this.ventanaPrincipal.getChildren().setAll(pane);
	}
	
	@FXML
    public void initialize() {
		
		
	}
	
}