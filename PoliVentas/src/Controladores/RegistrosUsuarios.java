/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.EstudianteDAO;
import Modelos.Comprador;
import Modelos.Estudiante;
import Modelos.Vendedor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Diego
 */
public class RegistrosUsuarios implements Initializable {

    @FXML
    private AnchorPane registrosUsuarios;
    @FXML
    private TextField cedula;
    @FXML
    private TextField usuario;
    @FXML
    private TextField matricula;
    @FXML
    private TextField nombres;
    @FXML
    private TextField correo;
    @FXML
    private Label extension;
    @FXML
    private TextField direccion;
    @FXML
    private TextField telefono;
    @FXML
    private TextField apellidos;
    @FXML
    private CheckBox ws_si;
    @FXML
    private CheckBox ws_no;
    @FXML
    private ComboBox<String> perfil;
    @FXML
    private TextField contrasenia;
    @FXML
    private TextField confiContra;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        perfil.getItems().addAll("Vendedor", "Comprador");
    }

    @FXML
    public void registrar() throws IOException {
        if (!verificarCampos()) {
            registrarEstudiante();
        } else {
            mostrar_mensaje("Error en el registro", "Cuenta con campos vacios, reviselos porfavor.", AlertType.ERROR);
        }
    }

    private Estudiante crearEstudiante() {
        Estudiante e = new Estudiante(this.cedula.getText(), null, null);
        if (this.perfil.getValue().equals("Vendedor")) {
            e = new Vendedor(cedula.getText(), nombres.getText(), apellidos.getText());

        } else if (this.perfil.getValue().equals("Comprador")) {
            e = new Comprador(cedula.getText(), nombres.getText(), apellidos.getText());
        }
        e.setMatricula(this.matricula.getText());
        e.setNombreU(this.usuario.getText());
        e.setContrasenia(this.contrasenia.getText());
        e.setTelefono(this.telefono.getText());
        e.setWhatsapp(this.ws_si.isSelected());
        e.setDireccion(direccion.getText());
        e.setEliminadoE(false);
        e.setEmail(this.correo.getText());
        e.setSaldo(0);
        return e;
    }

    private void registrarEstudiante() throws IOException {
        Estudiante e = crearEstudiante();
        if (!existeEstudiante(e)) {
            EstudianteDAO.registrarEstudiante(e);
            mostrar_mensaje("REGISTRO EXITOSO", "HA SIDO REGISTRADO CORRECTAMENTE", AlertType.INFORMATION);
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaPrincipal.fxml"));
            this.registrosUsuarios.getChildren().setAll(pane);
        } else {
            mostrar_mensaje("ERROR DE REGISTRO", "ESTE USUARIO YA EXISTE EN EL SISTEMA", AlertType.WARNING);
        }
    }

    private boolean verificarCampos() {
        boolean comprobacion = this.cedula.getText().equals("") || this.matricula.getText().equals("")
                || this.nombres.getText().equals("") || this.apellidos.getText().equals("")
                || this.usuario.getText().equals("") || this.telefono.getText().equals("")
                || this.contrasenia.getText().equals("") || this.confiContra.getText().equals("")
                || !(this.ws_si.isSelected() || this.ws_no.isSelected()) || this.correo.getText().equals("")
                || this.direccion.getText().equals("") || this.perfil.getSelectionModel().isEmpty();
        return comprobacion;
    }

    private void mostrar_mensaje(String texto1, String texto2, AlertType tipo) {

        Alert alert = new Alert(tipo);
        alert.setTitle(texto1);
        alert.setHeaderText(null);
        alert.setContentText(texto2);
        alert.showAndWait();
    }

    private boolean existeEstudiante(Estudiante e) {
        return EstudianteDAO.verificarEstudiante(e);
    }

    @FXML
    private void retroceder(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaPrincipal.fxml"));
        this.registrosUsuarios.getChildren().setAll(pane);
    }

}
