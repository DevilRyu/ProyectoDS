package Controladores;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ControladorComprador {

    @FXML
    private AnchorPane ventanaComprador, ventanaDinamica;

    @FXML
    private void buscar(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/busquedaSencilla.fxml"));
        this.ventanaDinamica.getChildren().setAll(pane);
    }

    public void initialize() {

    }

    @FXML
    private void buscar_historial(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/historialPedidos.fxml"));
        this.ventanaDinamica.getChildren().setAll(pane);
    }

    @FXML
    private void compras_pendientes(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/pedidosPendientes.fxml"));
        this.ventanaDinamica.getChildren().setAll(pane);

    }

    @FXML
    private void busqueda_avanzada(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/busquedaAvanzada.fxml"));
        this.ventanaDinamica.getChildren().setAll(pane);

    }

    @FXML
    private void cerrar_sesion(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaPrincipal.fxml"));
        this.ventanaComprador.getChildren().setAll(pane);

    }

    @FXML
    private void top_articulos(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/Vistas/topArticulos.fxml"));
        this.ventanaDinamica.getChildren().setAll(pane);

    }

    @FXML
    private void articulos_nuevos(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/articulosNuevos.fxml"));
        this.ventanaDinamica.getChildren().setAll(pane);

    }

}
