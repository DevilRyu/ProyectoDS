package Controladores;

import DAO.EstudianteDAO;
import Modelos.Comprador;
import Modelos.Estudiante;
import Modelos.Vendedor;
import conexion.Conexion;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RegistrosUsuarios {

    private EstudianteDAO estudianteDAO;
    private Conexion conexion = Conexion.getInstance();
    private Alert alerta;

    @FXML
    private TextField nombres, apellidos, usuario, cedula, direccion, telefono, correo, matricula;
    @FXML
    private AnchorPane registrosUsuarios;
    @FXML
    private ComboBox<String> perfil;
    @FXML
    private CheckBox ws_si, ws_no;
    @FXML
    private TextField contrasenia;
    @FXML
    private TextField confiContra;
    @FXML
    private Label extension;

    public void initialize() {
        perfil.getItems().removeAll(perfil.getItems());
        perfil.getItems().add("VENDEDOR");
        perfil.getItems().add("COMPRADOR");

    }

    @FXML
    public void registrar() throws IOException {
        if (!verificarCampos()) {
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Confirmacion");
            alerta.setHeaderText("Confirmacion de Registro");
            alerta.setContentText("¿Está seguro de que desea realizar este registro?");
            alerta.showAndWait();
            if (alerta.getResult() == ButtonType.OK) {
                registrarEstudiante();
                AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaPrincipal.fxml"));
                this.registrosUsuarios.getChildren().setAll(pane);
            }
        } else {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Campos Vacios");
            alerta.setContentText("Revise los campos puede que alguno este vacio");
            alerta.showAndWait();
        }
    }

    private Estudiante crearEstudiante() {
        Estudiante e;
        if (this.perfil.selectionModelProperty().getValue().getSelectedItem().equals("VENDEDOR")) {
            e = new Vendedor();

        } else {
            e = new Comprador();
        }
        e.setCedula(this.cedula.getText());
        e.setMatricula(this.matricula.getText());
        e.setNombre(this.nombres.getText());
        e.setApellido(this.apellidos.getText());
        e.setNombreU(this.usuario.getText());
        e.setContrasenia(this.contrasenia.getText());
        e.setTelefono(this.telefono.getText());
        e.setWhatsapp(this.ws_si.isSelected());
        e.setEliminadoE(false);
        e.setEmail(this.correo.getText() + this.extension.getText());
        e.setSaldo(0);
        return e;
    }

    private void registrarEstudiante() {
        this.estudianteDAO = new EstudianteDAO(conexion);
        estudianteDAO.registrarEstudiante(crearEstudiante());
    }

    private boolean verificarCampos() {
        boolean comprobacion = this.cedula.getText().equals("") && this.matricula.getText().equals("")
                && this.nombres.getText().equals("") && this.apellidos.getText().equals("")
                && this.usuario.getText().equals("") && this.telefono.getText().equals("")
                && this.contrasenia.getText().equals("") && this.confiContra.getText().equals("")
                && (this.ws_si.isSelected() || this.ws_no.isSelected()) && this.correo.getText().equals("")
                && this.direccion.getText().equals("");
        return comprobacion;
    }

    @FXML
    private void retroceder(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaPrincipal.fxml"));
        this.registrosUsuarios.getChildren().setAll(pane);
    }

}
