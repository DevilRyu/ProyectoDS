/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import DAO.ProductoDAO;
import Modelos.Producto;
import conexion.Conexion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Diego
 */
public class TopArticulosController implements Initializable {
    
    ProductoDAO productoDAO;
    Conexion conexion = Conexion.getInstance();

    @FXML
    private AnchorPane top_articulos;
    @FXML
    private TableView<Producto> tablaArticulosMasBuscados;
    @FXML
    private TableColumn<Producto, Producto> t;//
    @FXML
    private TableColumn<Producto, String> columnaProducto;
    @FXML
    private TableColumn<Producto, String> columnaCategoria;
    @FXML
    private TableColumn<Producto, Double> columnaPrecio;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarArticulosMasBsucados();
    }    
    
    private void mostrarArticulosMasBsucados(){
        productoDAO = new ProductoDAO(conexion);
        ObservableList<Producto> articulos = FXCollections.observableArrayList();
        productoDAO.articulosMasBuscados(articulos);
        tablaArticulosMasBuscados.setItems(articulos);
    }
}
