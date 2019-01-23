/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.GestionarBase;
import Modelos.Administrador;
import Modelos.Comprador;
import Modelos.Estudiante;
import Modelos.Vendedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class EstudianteDAO {

    public static void registrarEstudiante(Estudiante e) {
        GestionarBase.crearprocedimiento("{call registrarEstudiante(?,?,?,?,?,?,?,?,?,?,?,?)}");
        GestionarBase.asignarparametrosString(1, e.getCedula());
        GestionarBase.asignarparametrosString(2, e.getMatricula());
        GestionarBase.asignarparametrosString(3, e.getNombre());
        GestionarBase.asignarparametrosString(4, e.getApellido());
        GestionarBase.asignarparametrosString(5, e.getNombreU());
        GestionarBase.asignarparametrosString(6, e.getContrasenia());
        GestionarBase.asignarparametrosString(7, e.getTelefono());
        GestionarBase.asignarparametrosBoolean(8, e.isWhatsapp());
        GestionarBase.asignarparametrosBoolean(9, e.isEliminadoE());
        GestionarBase.asignarparametrosString(10, e.getEmail());
        GestionarBase.asignarparametrosString(11, e.getDireccion());
        GestionarBase.asignarparametrosDouble(12, e.getSaldo());
        GestionarBase.ejecutarprocedimiento();
        if (e instanceof Vendedor) {
            Vendedor v = (Vendedor) e;
            GestionarBase.crearprocedimiento("{call registrarVendedor(?,?)}");
            GestionarBase.asignarparametrosString(1, e.getCedula());
            GestionarBase.asignarparametrosDouble(2, ((Vendedor) e).getCalificacionPV());
            GestionarBase.ejecutarprocedimiento();
            GestionarBase.crearprocedimiento("{call agregarRol(?,?,?)}");
            GestionarBase.asignarparametrosString(1, e.getCedula());
            GestionarBase.asignarparametrosString(2, "1");
            GestionarBase.asignarparametrosString(3, "Vendedor");
            GestionarBase.ejecutarprocedimiento();
        } else if (e instanceof Administrador) {
            GestionarBase.crearprocedimiento("{call agregarRol(?,?,?)}");
            GestionarBase.asignarparametrosString(1, e.getCedula());
            GestionarBase.asignarparametrosString(2, "0");
            GestionarBase.asignarparametrosString(3, "Administrador");
            GestionarBase.ejecutarprocedimiento();
        } else if (e instanceof Comprador) {
            GestionarBase.crearprocedimiento("{call agregarRol(?,?,?)}");
            GestionarBase.asignarparametrosString(1, e.getCedula());
            GestionarBase.asignarparametrosString(2, "2");
            GestionarBase.asignarparametrosString(3, "Comprador");
            GestionarBase.ejecutarprocedimiento();
        }
        GestionarBase.cerrar();
    }

    public static boolean verificarEstudiante(Estudiante e) {
        ResultSet r;
        GestionarBase.crearprocedimiento("{call verificarEstudiante(?)}");
        GestionarBase.asignarparametrosString(1, e.getCedula());
        GestionarBase.ejecutarprocedimiento();
        r = GestionarBase.obtenerprocedmiento();
        boolean resultado = false;
        try {
            resultado = r.getString("cedula").equals(e.getCedula());
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    /*public Estudiante consultarEstudiante(String cedula) {
        Estudiante e = new Estudiante();
        conexion.obtener();
        try {
            PreparedStatement consulta = conexion.getCnx().prepareStatement(" Select * FROM Estudiante, Rol WHERE "
                    + "Estudiante.cedula = " + cedula + "AND Rol.idEstudiante = " + cedula + "')'");
            ResultSet resultados = consulta.executeQuery();
            conexion.cerrar();
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
        } catch (SQLException ex) {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Error de Conección");
            alerta.setContentText("Revise el estado del servidor");
            alerta.showAndWait();
        }
        conexion.cerrar();
        return e;
    }*/
}
