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
import conexion.Conexion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Diego
 */
public class AdministrarUsuarios implements Initializable {

    private EstudianteDAO estudianteDAO;
    private Conexion conexion = Conexion.getInstance();
    private Alert alerta;

    @FXML
    private AnchorPane admin_usuarios;
    @FXML
    private TextField cedula;
    @FXML
    private Label extension;
    @FXML
    private TextField usuario;
    @FXML
    private TextField telefono;
    @FXML
    private TextField direccion;
    @FXML
    private TextField correo;
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
    private Button crearActualizar;
    @FXML
    private Button eliminar;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void consultar(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER") && !this.cedula.getText().equals("")) {
            mostrarInformacion();
        }
    }

    @FXML
    private void crearActualizar(MouseEvent event) {
        if (!verificarCampos()) {
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Confirmacion");
            alerta.setHeaderText("Confirmacion de Actualización");
            alerta.setContentText("¿Está seguro de que desea realizar esta actualización?");
            alerta.showAndWait();
            if (alerta.getResult() == ButtonType.OK) {
                actualizarEstudiante();
                vaciarCampos();
            }
        } else {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Campos Vacios");
            alerta.setContentText("Revise los campos puede que alguno este vacio");
            alerta.showAndWait();
        }
    }

    private void mostrarInformacion() {
        this.estudianteDAO = new EstudianteDAO(conexion);
        Estudiante e = estudianteDAO.consultarEstudiante(cedula.getText());
        this.usuario.setText(e.getNombreU());
        this.nombres.setText(e.getNombre());
        this.direccion.setText(e.getDireccion());
        this.matricula.setText(e.getMatricula());
        this.telefono.setText(e.getTelefono());
        this.apellidos.setText(e.getApellido());
        this.correo.setText(e.getEmail());
        if (e.isWhatsapp()) {
            this.ws_si.selectedProperty().setValue(Boolean.TRUE);
        } else {
            this.ws_si.selectedProperty().setValue(Boolean.FALSE);
            this.ws_no.selectedProperty().setValue(Boolean.TRUE);
        }
        this.perfil.setValue(e.getClass().getSimpleName());
    }

    private Estudiante formarEstudiante() {
        Estudiante e;
        if (this.perfil.selectionModelProperty().getValue().getSelectedItem().equals("Vendedor")) {
            e = new Vendedor();

        } else if (this.perfil.selectionModelProperty().getValue().getSelectedItem().equals("Comprador")) {
            e = new Comprador();
        } else {
            e = new Administrador();
        }
        e.setCedula(this.cedula.getText());
        e.setMatricula(this.matricula.getText());
        e.setNombre(this.nombres.getText());
        e.setApellido(this.apellidos.getText());
        e.setNombreU(this.usuario.getText());
        e.setTelefono(this.telefono.getText());
        e.setWhatsapp(this.ws_si.isSelected());
        e.setEliminadoE(false);
        e.setEmail(this.correo.getText() + this.extension.getText());
        return e;

    }

    private void actualizarEstudiante() {
        this.estudianteDAO = new EstudianteDAO(conexion);
        estudianteDAO.registrarEstudiante(formarEstudiante());
    }

    private boolean verificarCampos() {
        boolean comprobacion = this.cedula.getText().equals("") && this.matricula.getText().equals("")
                && this.nombres.getText().equals("") && this.apellidos.getText().equals("")
                && this.usuario.getText().equals("") && this.telefono.getText().equals("")
                && (this.ws_si.isSelected() || this.ws_no.isSelected())&& this.correo.getText().equals("")
                && this.direccion.getText().equals("");
        return comprobacion;
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
    }

    @FXML
    private void eliminarEstudiante(MouseEvent event) {
        if (!verificarCampos()) {
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Confirmacion");
            alerta.setHeaderText("Confirmacion de Eliminación");
            alerta.setContentText("¿Está seguro de que desea eliminar este usuario?");
            alerta.showAndWait();
            if (alerta.getResult() == ButtonType.OK) {
                eliminar();
                vaciarCampos();;
            }
        } else {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Campos Vacios");
            alerta.setContentText("Revise los campos puede que alguno este vacio");
            alerta.showAndWait();
        }
    }

    private void eliminar() {
        this.estudianteDAO = new EstudianteDAO(conexion);
        estudianteDAO.eliminarEstudiante(formarEstudiante());
    }

}
