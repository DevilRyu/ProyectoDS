package Controladores;

import DAO.EstudianteDAO;
import DAO.ProductoDAO;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class VentanaPrincipal {

    private LinkedList<String> info;
    
    @FXML
    public TextField usuario;
    @FXML
    private AnchorPane ventanaPrincipal;
    @FXML
    private TextField password;
    
    @FXML
    private void iniciar_sesion(ActionEvent event) throws IOException {
        info = EstudianteDAO.validarLogin(usuario.getText());
        if (info.size() > 0) {
            if (info.get(1).equals("Comprador")) {
                AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaComprador.fxml"));
                this.ventanaPrincipal.getChildren().setAll(pane);
            }

            if (info.get(1).equals("Vendedor")) {
                AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaVendedor.fxml"));
                this.ventanaPrincipal.getChildren().setAll(pane);
            }

            if (info.get(1).equals("admin")) {
                AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaAdmin.fxml"));
                this.ventanaPrincipal.getChildren().setAll(pane);
            }
        }else{
            Alert dialogoAlerta=new Alert(Alert.AlertType.ERROR);
            dialogoAlerta.setTitle("Poliventas");
            dialogoAlerta.setHeaderText(null);
            dialogoAlerta.setContentText("Usuario o contraseña invalida");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            dialogoAlerta.showAndWait();
        }

    }

    @FXML
    private void registrar(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/ventanaRegistro.fxml"));
        this.ventanaPrincipal.getChildren().setAll(pane);
    }

    @FXML
    private void salir(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Vistas/dashboard.fxml"));
        this.ventanaPrincipal.getChildren().setAll(pane);
    }

    @FXML
    public void initialize() {

    }
    
    

}
