package Controladores;

import java.util.ArrayList;

import DAO.ProductoDAO;
import DAO.VendedorDAO;
import Modelos.Producto;
import Modelos.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import org.controlsfx.control.CheckListView;
import javafx.collections.ListChangeListener;

public class AdministrarProductos {

    @FXML
    private AnchorPane productos;
    @FXML
    private TextField producto, cantidad, precio;
    @FXML
    private TextArea descripcion;
    @FXML
    private ComboBox<String> cb_categoria, cb_vendedor;
    @FXML
    private Button crear, eliminar;
    private ArrayList<Producto> datos = new ArrayList<Producto>();
    private ArrayList<Producto> datosProducto = new ArrayList<Producto>();
    private ArrayList<Vendedor> lista = new ArrayList<Vendedor>();
    private ObservableList<String> list = FXCollections.observableArrayList();
    private CheckListView<String> checkListView;
    private ObservableList<String> lstCheck = FXCollections.observableArrayList();
    private String valor;
    private boolean delete;

    @FXML
    public void initialize() {
        cargar_productos();
        cargar_vendedores();
        buscar();
        ObservableList<String> categorias = FXCollections.observableArrayList("Tecnologia", "Vestuario", "Calzado",
                "Accesorios", "Comida", "Libros");
        this.cantidad.setText("0");
        this.precio.setText("0");
        this.cb_categoria.getItems().removeAll(cb_categoria.getItems());
        this.cb_categoria.getItems().addAll(categorias);
        this.cb_categoria.getSelectionModel().selectFirst();
        actualizarLista();
        this.checkListView = new CheckListView<String>(list);
        checkListView.setLayoutX(350);
        checkListView.setLayoutY(232);
        checkListView.setPrefSize(181, 250);
        checkListView.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends String> c) {
                lstCheck = checkListView.getCheckModel().getCheckedItems();

            }
        });

        productos.getChildren().add(checkListView);

    }

    private boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            mostrar_mensaje("ERROR", "DEBE INGRESAR NUMEROS EN LUGAR DE LETRAS");
            return false;
        }
    }

    @FXML
    public void crear_producto() {

        if (validar()) {

            if (!existeProducto()) {

                Producto a = new Producto(producto.getText(), descripcion.getText(), cb_categoria.getValue(), 0,
                        Float.parseFloat(precio.getText()), Integer.parseInt(cantidad.getText()));
                ProductoDAO.registrar_producto(a);
                mostrar_mensaje("REGISTRO EXITOSO", "EL PRODUCTO FUE REGISTRADO CORRECTAMENTE");
            } else {
                int x = actualizar_registro();
                Producto b = new Producto(producto.getText(), descripcion.getText(), cb_categoria.getValue(), x,
                        Float.parseFloat(precio.getText()), Integer.parseInt(cantidad.getText()));
                mostrar_mensaje("ACTUALIZACION EXITOSA", "EL PRODUCTO FUE ACTUALIZADO CORRECTAMENTE");
                ProductoDAO.registrar_producto(b);
            }

        } else {
            mostrar_mensaje("CAMPOS VACIOS", "DEBE COMPLETAR LOS CAMPOS OBLIGATORIOS");

        }
    }

    private int actualizar_registro() {
        cargar_productos();
        for (int i = 0; i < datosProducto.size(); i++) {
            if (datosProducto.get(i).getNombre().equals(producto.getText())) {
                return datosProducto.get(i).getIdProducto();
            }
        }
        return 0;
    }

    private boolean existeProducto() {
        ArrayList<Producto> data = new ArrayList<Producto>();
        Producto a = new Producto(producto.getText(), descripcion.getText(), cb_categoria.getValue(), 0,
                Float.parseFloat(precio.getText()), Integer.parseInt(cantidad.getText()));
        data = ProductoDAO.verificar_producto(a);
        return data.size() >= 1;
    }

    private boolean validar() {
        return !producto.getText().equals("") && !cantidad.getText().equals("0") && !precio.getText().equals("0")
                && !descripcion.getText().equals("") && isNumeric(precio.getText()) && isNumeric(cantidad.getText());
    }

    @FXML
    public void eliminar_producto() {
        delete = false;
        buscar();
        for (String s : lstCheck) {
            ProductoDAO.eliminar_producto(valor, s);
            delete = true;
        }

        if (delete) {
            mostrar_mensaje("INFORMACION", "EL PRODUCTO FUE ELIMINADO CORRECTAMENTE");
        }
    }

    @FXML
    public void limpiar() {
        cargar_productos();
        cargar_vendedores();
        this.producto.setText("");
        this.descripcion.setText("");
        this.precio.setText("0");
        this.cantidad.setText("0");
        cb_vendedor.getSelectionModel().selectFirst();
        cb_categoria.getSelectionModel().selectFirst();
        buscar();

    }

    @FXML
    public void buscar() {
        String aux = cb_vendedor.getValue();
        for (int i = 0; i < lista.size(); i++) {
            String t = lista.get(i).getNombre() + " " + lista.get(i).getApellido();
            if (aux.equals(t)) {
                valor = lista.get(i).getCedula();
                datos = ProductoDAO.obtener_productosVendedor(valor);
                actualizarLista();
            }
        }

    }

    public void actualizarLista() {
        list.clear();
        for (int i = 0; i < datos.size(); i++) {
            list.add(datos.get(i).getNombre());
        }
    }

    private void cargar_vendedores() {

        cb_vendedor.getItems().removeAll(cb_vendedor.getItems());
        lista.clear();
        lista = VendedorDAO.obtener_vendedores();
        for (int i = 0; i < lista.size(); i++) {
            cb_vendedor.getItems().add(lista.get(i).getNombre() + " " + lista.get(i).getApellido());
        }
        cb_vendedor.getSelectionModel().selectFirst();

    }

    private void cargar_productos() {
        datosProducto = ProductoDAO.obtener_productos();
    }

    private void mostrar_mensaje(String texto1, String texto2) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(texto1);
        alert.setHeaderText(null);
        alert.setContentText(texto2);
        alert.showAndWait();

    }

}
