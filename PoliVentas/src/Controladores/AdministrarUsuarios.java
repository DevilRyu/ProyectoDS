/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.EstudianteDAO;
import Modelos.Administrador;
import Modelos.Comprador;
import Modelos.Estudiante;
import Modelos.Vendedor;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Diego
 */
public class AdministrarUsuarios implements Initializable {

    @FXML
    private AnchorPane admin_usuarios;
    @FXML
    private TextField usuario;
    @FXML
    private TextField cedula;
    @FXML
    private TextField telefono;
    @FXML
    private TextField direccion;
    @FXML
    private TextField correo;
    @FXML
    private Label extension;
    @FXML
    private TextField matricula;
    @FXML
    private CheckBox ws_si;
    @FXML
    private CheckBox ws_no;
    @FXML
    private ComboBox<String> perfil;
    @FXML
    private TextField nombres;
    @FXML
    private TextField apellidos;
    @FXML
    private Button eliminar;
    @FXML
    private Button Actualizar;

    Alert alerta;
    @FXML
    private ComboBox<String> rol;
    @FXML
    private TableView<Estudiante> tabla;
    @FXML
    private TableColumn<Estudiante, String> columnaNombre;
    @FXML
    private TableColumn<Estudiante, String> columnaApellido;
    @FXML
    private TableColumn<Estudiante, String> columnaCedula;
    private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
    private ObservableList<Estudiante> lista = FXCollections.observableArrayList();
    @FXML
    private Button consultar;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rol.getItems().addAll("Vendedor", "Comprador","Administrador");
    }

    private void mostrarEstudiantesPorRol() {
        estudiantes = EstudianteDAO.obtenerPorRol(rol.getValue());
        actualizarLista();
        tabla.setItems(lista);
    }

    private void actualizarLista() {
        lista.clear();
        lista.addAll(estudiantes);
        columnaCedula.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("cedula"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("nombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("apellido"));
    }

    @FXML
    private void consultar(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER") && !this.cedula.getText().equals("")) {
            mostrarInformacion();
        }
    }

    private void mostrarInformacion() {
        Estudiante e = EstudianteDAO.consultarEstudiante(cedula.getText());
        if (e.isEliminadoE()) {
            mostrar_mensaje("USUARIO NO ENCONTRADO", "ESTE USUARIO FUE ELIMINADO DEL SISTEMA", Alert.AlertType.INFORMATION);
        } else {
            this.usuario.setText(e.getNombreU());
            this.telefono.setText(e.getTelefono());
            this.apellidos.setText(e.getApellido());
            this.correo.setText(e.getEmail());
            this.matricula.setText(e.getMatricula());
            this.nombres.setText(e.getNombre());
            this.direccion.setText(e.getDireccion());
            if (e.isWhatsapp()) {
                this.ws_si.selectedProperty().setValue(Boolean.TRUE);
            } else {
                this.ws_si.selectedProperty().setValue(Boolean.FALSE);
                this.ws_no.selectedProperty().setValue(Boolean.TRUE);
            }
            this.perfil.setValue(e.getClass().getSimpleName());
        }
    }

    @FXML
    private void crearActualizar(MouseEvent event) {
        if (!verificarCampos()) {
            actualizarEstudiante();
        } else {
            mostrar_mensaje("Error en el registro", "Cuenta con campos vacios, reviselos porfavor.", Alert.AlertType.ERROR);
        }

    }

    private boolean verificarCampos() {
        boolean comprobacion = this.cedula.getText().equals("") || this.matricula.getText().equals("")
                || this.nombres.getText().equals("") || this.apellidos.getText().equals("")
                || this.usuario.getText().equals("") || this.telefono.getText().equals("")
                || !(this.ws_si.isSelected() || this.ws_no.isSelected()) || this.correo.getText().equals("")
                || this.direccion.getText().equals("") || this.perfil.getSelectionModel().isEmpty();
        return comprobacion;
    }

    private void mostrar_mensaje(String texto1, String texto2, Alert.AlertType tipo) {

        Alert alert = new Alert(tipo);
        alert.setTitle(texto1);
        alert.setHeaderText(null);
        alert.setContentText(texto2);
        alert.showAndWait();
    }

    private void actualizarEstudiante() {
        Estudiante e = crearEstudiante();
        if (existeEstudiante(e)) {
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Confirmacion");
            alerta.setHeaderText("Confirmacion de Actualización");
            alerta.setContentText("¿Está seguro de que desea actualizar este usuario?");
            alerta.showAndWait();
            if (alerta.getResult() == ButtonType.OK) {
                EstudianteDAO.actualizarEstudiante(e);
                mostrar_mensaje("ACTUALIZACIÓN EXITOSA", "EL USUARIO HA SIDO ACTUALIZADO CORRECTAMENTE", Alert.AlertType.INFORMATION);
            }

        }
    }

    private boolean existeEstudiante(Estudiante e) {
        return EstudianteDAO.verificarEstudiante(e);
    }

    private Estudiante crearEstudiante() {
        Estudiante e;
        if (this.perfil.getValue().equals("Vendedor")) {
            e = new Vendedor(cedula.getText(), nombres.getText(), apellidos.getText());

        } else if (this.perfil.getValue().equals("Comprador")) {
            e = new Comprador(cedula.getText(), nombres.getText(), apellidos.getText());
        } else {
            e = new Administrador(cedula.getText(), nombres.getText(), apellidos.getText());
        }
        e.setMatricula(this.matricula.getText());
        e.setNombreU(this.usuario.getText());
        e.setTelefono(this.telefono.getText());
        e.setWhatsapp(this.ws_si.isSelected());
        e.setDireccion(direccion.getText());
        e.setEliminadoE(false);
        e.setEmail(this.correo.getText());
        e.setSaldo(0);
        return e;
    }

    @FXML
    private void eliminarEstudiante(MouseEvent event) {
        if (!this.cedula.getText().equals("")) {
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Confirmacion");
            alerta.setHeaderText("Confirmacion de Eliminación");
            alerta.setContentText("¿Está seguro de que desea eliminar este usuario?");
            alerta.showAndWait();
            if (alerta.getResult() == ButtonType.OK) {
                EstudianteDAO.eliminarEstudiante(cedula.getText());
                vaciarCampos();
                mostrar_mensaje("ELIMINACIÓN EXISTOSA", "LA ELIMINACIÓN SE HA REALIZADO CORRECTAMENTE", Alert.AlertType.INFORMATION);
            }
        } else {
            mostrar_mensaje("Error en la eliminación", "No ha especificado el usuario que desea eliminar", Alert.AlertType.ERROR);
        }
    }

    private void vaciarCampos() {
        this.apellidos.setText("");
        this.cedula.setText("");
        this.correo.setText("");
        this.direccion.setText("");
        this.matricula.setText("");
        this.nombres.setText("");
        this.perfil.setValue("");
        this.telefono.setText("");
        this.usuario.setText("");
        this.ws_no.setSelected(false);
        this.ws_si.setSelected(false);
    }

    @FXML
    private void consultarEstudiante(MouseEvent event) {
        mostrarEstudiantesPorRol();
    }
}
