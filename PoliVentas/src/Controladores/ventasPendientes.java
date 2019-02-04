/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.VentaDAO;
import Modelos.Venta;
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
 * @author Public
 */
public class ventasPendientes implements Initializable {

    @FXML
    private AnchorPane ventas_pendientes;
    @FXML
    private TableColumn<Venta, String> columnProducto;
    @FXML
    private TableColumn<Venta, String> columnComprador;
    @FXML
    private TableColumn<Venta, Double> columnPrecio;
    @FXML
    private TableColumn<Venta, String> ColumnLugar;
    @FXML
    private TableView<Venta> tablaVentasPendientes;
    
    private ArrayList<Venta> articulos = new ArrayList<Venta>();
    private ObservableList<Venta> lista = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarVentasPendientes();
    }    
    
    public void mostrarVentasPendientes() {
        articulos = VentaDAO.ventasPendientes(VentanaPrincipal.estudianteLogeado.getCedula());
        actualizarLista();
        tablaVentasPendientes.setItems(lista);
    }

    private void actualizarLista() {
        lista.clear();
        lista.addAll(articulos);
        columnProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
        columnComprador.setCellValueFactory(new PropertyValueFactory<>("comprador"));
        columnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        ColumnLugar.setCellValueFactory(new PropertyValueFactory<>("lugar"));
    }
    
}
