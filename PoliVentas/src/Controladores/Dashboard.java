package Controladores;

import DAO.ProductoDAO;
import Modelos.Producto;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class Dashboard {

    private ArrayList<Producto> articulos = new ArrayList<Producto>();
    private ObservableList<Producto> lista = FXCollections.observableArrayList();

    @FXML
    private AnchorPane dashboard;
    @FXML
    private TableColumn<Producto, String> columnaProducto;
    @FXML
    private TableColumn<Producto, String> columnaCategoria;
    @FXML
    private TableColumn<Producto, Double> columnaPrecio;
    @FXML
    private TableView<Producto> tabla;

    @FXML
    private void ingresar(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaPrincipal.fxml"));
        this.dashboard.getChildren().setAll(pane);

    }

    public void initialize() {
        mostrarArticulosMasBsucados();
        
    }

    private void mostrarArticulosMasBsucados() {
        articulos = ProductoDAO.articulosMasBuscados();
        actualizarLista();
        tabla.setItems(lista);
    }

    private void actualizarLista() {
        lista.clear();
        lista.addAll(articulos);
        columnaProducto.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));
        columnaCategoria.setCellValueFactory(new PropertyValueFactory<Producto, String>("categoria"));
        columnaPrecio.setCellValueFactory(new PropertyValueFactory<Producto, Double>("precio"));
    }

}
