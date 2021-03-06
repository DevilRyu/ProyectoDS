/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.ProductoDAO;
import Modelos.Producto;
import Modelos.Compra;
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
public class ControladorComprasPendientes implements Initializable {

    @FXML
    private TableColumn<Producto, String> columnaProducto;
    @FXML
    private TableColumn<Producto, Double> columnaPrecio;
    @FXML
    private TableColumn<Producto, Integer> columnaCalificionP;
    @FXML
    private TableColumn<Producto, Integer> columnaCalificacionV;
    private ArrayList<Compra> articulos = new ArrayList<Compra>();
    private ObservableList<Compra> lista = FXCollections.observableArrayList();
    @FXML
    private TableView<Compra> tablaComprasPendientes;
    @FXML
    private AnchorPane compras_pendientes;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarComprasPendientes();
    }

    public void mostrarComprasPendientes() {
        articulos = ProductoDAO.comprasPendientes();
        actualizarLista();
        tablaComprasPendientes.setItems(lista);
    }

    private void actualizarLista() {
        lista.clear();
        lista.addAll(articulos);
        columnaProducto.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombreProducto"));
        columnaPrecio.setCellValueFactory(new PropertyValueFactory<Producto, Double>("precio"));
        columnaCalificacionV.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("calificacionV"));
        columnaCalificionP.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("calificacionP"));
    }

}
