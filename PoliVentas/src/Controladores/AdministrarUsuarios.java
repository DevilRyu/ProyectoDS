/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.EstudianteDAO;
import Modelos.Estudiante;
import conexion.Conexion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void consultar(KeyEvent event) {
        if(event.getCode().toString().equals("ENTER")){
            mostrarInformacion();
        }
    }

    @FXML
    private void crearActualizar(MouseEvent event) {
    }
    
    private void mostrarInformacion(){
        this.estudianteDAO = new EstudianteDAO(conexion);
        Estudiante e = estudianteDAO.consultarEstudiante(cedula.getText());
        this.usuario.setText(e.getNombreU());
        this.nombres.setText(e.getNombre());
        this.direccion.setText(e.getDireccion());
        this.matricula.setText(e.getMatricula());
        this.telefono.setText(e.getTelefono());
        this.apellidos.setText(e.getApellido());
        this.correo.setText(e.getEmail());
        if(e.isWhatsapp()){
            this.ws_si.selectedProperty().setValue(Boolean.TRUE);
        }else{
            this.ws_si.selectedProperty().setValue(Boolean.FALSE);
            this.ws_no.selectedProperty().setValue(Boolean.TRUE);
        }
        this.perfil.setValue(e.getClass().getSimpleName());
    }
    
}
