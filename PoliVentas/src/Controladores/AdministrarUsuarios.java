/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private ComboBox<?> perfil;
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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void consultar(KeyEvent event) {
    }

    @FXML
    private void crearActualizar(MouseEvent event) {
        
    }

    @FXML
    private void eliminarEstudiante(MouseEvent event) {
    }
    
}
