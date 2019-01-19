/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Administrador;
import Modelos.Comprador;
import Modelos.Estudiante;
import Modelos.Vendedor;
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
            PreparedStatement ingreso = conexion.getCnx().prepareStatement("INSERT INTO Estudiante VALUES ("
                    + e.getCedula() + "','" + e.getMatricula() + "','" + e.getNombre() + "','" + e.getApellido() + "','"
                    + e.getNombreU() + "','" + e.getContrasenia() + "','" + e.getTelefono() + "','" + e.isWhatsapp() + "','"
                    + e.isEliminadoE() + "','" + e.getEmail() + "','" + e.getDireccion() + "','" + e.getSaldo() + "')'");
            ingreso.executeUpdate();
            if (e instanceof Vendedor) {
                Vendedor v = (Vendedor) e;
                PreparedStatement ingresoV = conexion.getCnx().prepareStatement("INSERT INTO Vendedor VALUES ("
                        + v.getCedula() + "','" + v.getCalificacionPV() + "')'");
                ResultSet resultados2 = ingresoV.executeQuery();

                PreparedStatement ingresoRV = conexion.getCnx().prepareStatement("INSERT INTO Rol VALUES ("
                        + v.getCedula() + "','" + 1 + "Vendedor)");
                ResultSet resultados3 = ingresoRV.executeQuery();
            } else if (e instanceof Administrador) {
                PreparedStatement ingresoRA = conexion.getCnx().prepareStatement("INSERT INTO Rol VALUES ("
                        + e.getCedula() + "','" + 0 + "Administrador)");
                ResultSet resultados4 = ingresoRA.executeQuery();
            } else if (e instanceof Comprador) {
                PreparedStatement ingresoRC = conexion.getCnx().prepareStatement("INSERT INTO Rol VALUES ("
                        + e.getCedula() + "','" + 2 + "Comprador)");
                ResultSet resultados4 = ingresoRC.executeQuery();
            }
            conexion.cerrar();
        } catch (SQLException ex) {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Error de Conección");
            alerta.setContentText("Revise el estado del servidor");
            alerta.showAndWait();
        }
    }

    public Estudiante consultarEstudiante(String cedula) {
        Estudiante e = new Estudiante();
        conexion.obtener();
        try {
            PreparedStatement consulta = conexion.getCnx().prepareStatement(" Select * FROM Estudiante, Rol WHERE "
                    + "Estudiante.cedula = " + cedula + "AND Rol.idEstudiante = " + cedula + " AND Estudiante.eliminadoE <> true')'");
            ResultSet resultados = consulta.executeQuery();
            switch (resultados.getString("Rol.nombre")) {
                case "Administrador":
                    e = new Administrador();
                    break;
                case "Vendedor":
                    e = new Vendedor();
                    break;
                case "Comprador":
                    e = new Comprador();
                    break;
            }
            e.setCedula(resultados.getString("estudiante.cedula"));
            e.setMatricula(resultados.getString("estudiante.matricula"));
            e.setNombre(resultados.getString("estudiante.nombre"));
            e.setApellido(resultados.getString("estudiante.apellido"));
            e.setNombreU(resultados.getString("estudiante.usuario"));
            e.setTelefono(resultados.getString("estudiante.telefono"));
            e.setDireccion(resultados.getString("estudiante.direccion"));
            e.setEmail(resultados.getString("estudiante.correo"));
            e.setWhatsapp(resultados.getBoolean("estudiante.whatsapp"));
            conexion.cerrar();
        } catch (SQLException ex) {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Error de Conección");
            alerta.setContentText("Revise el estado del servidor");
            alerta.showAndWait();
        }
        return e;
    }

    public void actualizarEstudiante(Estudiante e) {
        conexion.obtener();
        try {
            PreparedStatement modificar = conexion.getCnx().prepareStatement("UPDATE Estudiante "
                    + "SET ususario ='" + e.getNombreU() + "', telefono = '" + e.getTelefono()
                    + "', nombre = '" + e.getNombre() + "', apellido ='" + e.getApellido()
                    + "', direcion = '" + e.getDireccion() + "',correo = '" + e.getEmail()
                    + "',whatsapp = '" + e.isWhatsapp() + " WHERE cedula = " + e.getCedula() + "");
            modificar.executeUpdate();
            if (e instanceof Vendedor) {
                PreparedStatement modificacionRV = conexion.getCnx().prepareStatement("UPDATE Rol "
                        + "SET idRol = 1 SET nombre = Vendedor WHERE idEstudiante ='" + e.getCedula() + "");
                modificacionRV.executeUpdate();
            } else if (e instanceof Administrador) {
                PreparedStatement modificacionRA = conexion.getCnx().prepareStatement("UPDATE Rol "
                        + "SET idRol = 0 SET nombre = Administrador WHERE idEstudiante ='" + e.getCedula() + "");
                modificacionRA.executeUpdate();
            } else if (e instanceof Comprador) {
                PreparedStatement modificacionRC = conexion.getCnx().prepareStatement("UPDATE Rol "
                        + "SET idRol = 2 SET nombre = Comprador WHERE idEstudiante ='" + e.getCedula() + "");
                modificacionRC.executeUpdate();
            }
            conexion.cerrar();
        } catch (SQLException ex) {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Error de Conección");
            alerta.setContentText("Revise el estado del servidor");
            alerta.showAndWait();
        }
    }

    public void eliminarEstudiante(Estudiante e) {
        try {
            conexion.obtener();
            PreparedStatement eliminarEstudiante = conexion.getCnx().prepareStatement("UPDATE Estudiante "
                    + "SET eliminadoE  = true WHERE cedula ='" +e.getCedula()+ "");
            eliminarEstudiante.executeUpdate();
        } catch (SQLException ex) {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Error de Conección");
            alerta.setContentText("Revise el estado del servidor");
            alerta.showAndWait();
        }
    }
}
