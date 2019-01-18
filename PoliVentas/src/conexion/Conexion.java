/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author USRSIG
 */
public class Conexion {

    private Connection cnx;
    private static Conexion cnxp  = getInstance();
    private static final String USER = "rootpoliventas@localhost";
    private static final String PASS = "01234567";
    private static final String NOMBREDB = "poliventas";
    private static final String HOST = "jdbc:mysql://db4free,net:3306/";
    Alert alert;

    private Conexion() {
    }

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

    public Connection obtener() {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection(HOST + NOMBREDB, USER, PASS);
            } catch (ClassNotFoundException ex) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error de Clase");
                alert.setContentText("Revise la clase");
                alert.showAndWait();
            } catch (SQLException ex) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error de Conección");
                alert.setContentText("Revise el estado del servidor");
                alert.showAndWait();
            }
        }
        return cnx;
    }

    public void cerrar() {
        if (cnx != null) {
            try {
                cnx.close();
            } catch (SQLException ex) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error de Conección");
                alert.setContentText("Revise el estado del servidor");
                alert.showAndWait();
            }
        }
    }

    public static Conexion getInstance() {
        return cnxp =  new Conexion();
    }

}
