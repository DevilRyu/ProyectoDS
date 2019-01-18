/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Estudiante;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Diego
 */
public class EstudianteDAO {

    private final Conexion conexion;
    private Alert alerta;

    public EstudianteDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public void registrarEstudiante(Estudiante e) {
        conexion.obtener();
        try {
            PreparedStatement consulta = conexion.getCnx().prepareStatement("INSERT INTO Estudiante VALUES "
                    + "producto ORDER BY contadorBusqueda");
            ResultSet resultados = consulta.executeQuery();
            conexion.cerrar();
        } catch (SQLException ex) {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Error de Conección");
            alerta.setContentText("Revise el estado del servidor");
            alerta.showAndWait();
        }
    }
}
