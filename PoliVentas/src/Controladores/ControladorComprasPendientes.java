/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import DAO.ProductoDAO;
import Modelos.Producto;
import Modelos.compraPendiente;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
/**
 * FXML Controller class
 *
 * @author Diego
 */
public class ControladorComprasPendientes implements Initializable {
    @FXML private AnchorPane comprasPendientes;
    @FXML private TableView<compraPendiente> tablaComprasPendientes;
    @FXML private TableColumn<Producto, String> columnaProducto;
    @FXML private TableColumn<Producto, Double> columnaPrecio;
    @FXML private TableColumn<Producto, Integer> columnaCalificionP;
    @FXML private TableColumn<Producto, Integer> columnaCalificacionV;
   

   private ArrayList<compraPendiente> articulos = new ArrayList<compraPendiente>();
    private ObservableList<compraPendiente> lista = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("se inicializó");
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
        columnaProducto.setCellValueFactory(new PropertyValueFactory<Producto,String>("producto"));
        columnaPrecio.setCellValueFactory(new PropertyValueFactory<Producto,Double>("precio"));
        columnaCalificacionV.setCellValueFactory(new PropertyValueFactory<Producto,Integer>("calificacionV"));
        columnaCalificionP.setCellValueFactory(new PropertyValueFactory<Producto,Integer>("calificacionP"));
    }
    
}
