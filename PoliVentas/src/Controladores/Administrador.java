package Controladores;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Administrador {

	@FXML
	private AnchorPane ventanaAdmin,ventanaDinamica;
	
	@FXML
	private void buscar(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/busquedaSencilla.fxml"));
		this.ventanaDinamica.getChildren().setAll(pane);
	}
	
	@FXML
	private void busqueda_avanzada(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/busquedaAvanzada.fxml"));
		this.ventanaDinamica.getChildren().setAll(pane);	
	}
	
	@FXML
	private void cerrar_sesion(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaPrincipal.fxml"));
		this.ventanaAdmin.getChildren().setAll(pane);
		
	}
	
	
	@FXML
	private void admin_usuarios(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/administrarUsuarios.fxml"));
		this.ventanaDinamica.getChildren().setAll(pane);
		
	}
	
	@FXML
	private void admin_productos(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/productos.fxml"));
		this.ventanaDinamica.getChildren().setAll(pane);
		
	}
	
	@FXML
	private void compras_pendientes(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/comprasPendientes.fxml"));
		this.ventanaDinamica.getChildren().setAll(pane);
		
	}
	
	
	@FXML
	private void compras_anuladas(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/comprasAnuladas.fxml"));
		this.ventanaDinamica.getChildren().setAll(pane);
		
	}
	
	@FXML
	private void compras_exitosas(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/comprasExitosas.fxml"));
		this.ventanaDinamica.getChildren().setAll(pane);
		
	}
	
	
	
}
