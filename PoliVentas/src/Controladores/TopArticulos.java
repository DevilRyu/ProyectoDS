/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.ProductoDAO;
import Modelos.Producto;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Diego
 */
public class TopArticulos implements Initializable {

    @FXML
    private AnchorPane top_articulos;
    @FXML
    private TableView<Producto> tablaArticulosMasBuscados;
    @FXML
    private TableColumn<Producto, String> columnaProducto;
    @FXML
    private TableColumn<Producto, String> columnaCategoria;
    @FXML
    private TableColumn<Producto, Double> columnaPrecio;

    private ArrayList<Producto> articulos = new ArrayList<Producto>();
    private ObservableList<Producto> lista = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarArticulosMasBsucados();
    } 
    private void mostrarArticulosMasBsucados() {
        articulos = ProductoDAO.articulosMasBuscados();
        actualizarLista();
        tablaArticulosMasBuscados.setItems(lista);
    }

    private void actualizarLista() {
        lista.clear();
        lista.addAll(articulos);
        columnaProducto.setCellValueFactory(new PropertyValueFactory<Producto,String>("nombre"));
        columnaCategoria.setCellValueFactory(new PropertyValueFactory<Producto,String>("categoria"));
        columnaPrecio.setCellValueFactory(new PropertyValueFactory<Producto,Double>("precio"));
    }
}
