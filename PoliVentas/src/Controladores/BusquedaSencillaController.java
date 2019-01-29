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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Public
 */
public class BusquedaSencillaController implements Initializable {

    @FXML
    private AnchorPane busqueda_sencilla;
    @FXML
    private TextField cuadro;
    @FXML
    private ImageView search;
    @FXML
    private TableColumn<Producto, String> columnaProducto;
    @FXML
    private TableColumn<Producto, String> columnaVendedor;
    @FXML
    private TableColumn<Producto, Double> columnaCosto;
    @FXML
    private TableColumn<Producto, Integer> columnaDisponible;
    @FXML
    private TableColumn<Producto, Integer> columnaEstrella;
    @FXML
    private TableView<Producto> tablBusquedaSencilla;

    private ArrayList<Producto> articulos = new ArrayList<Producto>();
    private ObservableList<Producto> lista = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarArticulosBusqueda();
    }    
    
    private void mostrarArticulosBusqueda() {
        if(!cuadro.getText().isEmpty()){
            System.out.println(cuadro.getText());
            articulos = ProductoDAO.busquedaSencilla(cuadro.getText());
            actualizarLista();
            tablBusquedaSencilla.setItems(lista);
        }
    }
    

    @FXML
    private void busquedaSencilla(ActionEvent event) {
        mostrarArticulosBusqueda();
    }

    private void actualizarLista() {
        lista.clear();
        lista.addAll(articulos);
        columnaProducto.setCellValueFactory(new PropertyValueFactory<Producto,String>("nombre"));
        columnaVendedor.setCellValueFactory(new PropertyValueFactory<Producto,String>("vendedor"));
        columnaCosto.setCellValueFactory(new PropertyValueFactory<Producto,Double>("precio"));
        columnaDisponible.setCellValueFactory(new PropertyValueFactory<Producto,Integer>("cantidad"));
        columnaEstrella.setCellValueFactory(new PropertyValueFactory<Producto,Integer>("calificacionPP"));
        
    }
    
}
