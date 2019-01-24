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
        GestionarBase.llamarprocedimiento("{call registrarEstudiante(?,?,?,?,?,?,?,?,?,?,?,?)}");
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
            GestionarBase.llamarprocedimiento("{call registrarVendedor(?,?)}");
            GestionarBase.asignarparametrosString(1, e.getCedula());
            GestionarBase.asignarparametrosDouble(2, ((Vendedor) e).getCalificacionPV());
            GestionarBase.ejecutarprocedimiento();
            GestionarBase.llamarprocedimiento("{call agregarRol(?,?,?)}");
            GestionarBase.asignarparametrosString(1, e.getCedula());
            GestionarBase.asignarparametrosString(2, "1");
            GestionarBase.asignarparametrosString(3, "Vendedor");
            GestionarBase.ejecutarprocedimiento();
        } else if (e instanceof Administrador) {
            GestionarBase.llamarprocedimiento("{call agregarRol(?,?,?)}");
            GestionarBase.asignarparametrosString(1, e.getCedula());
            GestionarBase.asignarparametrosString(2, "0");
            GestionarBase.asignarparametrosString(3, "Administrador");
            GestionarBase.ejecutarprocedimiento();
        } else if (e instanceof Comprador) {
            GestionarBase.llamarprocedimiento("{call agregarRol(?,?,?)}");
            GestionarBase.asignarparametrosString(1, e.getCedula());
            GestionarBase.asignarparametrosString(2, "2");
            GestionarBase.asignarparametrosString(3, "Comprador");
            GestionarBase.ejecutarprocedimiento();
        }
        GestionarBase.cerrar();
    }

    public static void actualizarEstudiante(Estudiante e) {
        GestionarBase.llamarprocedimiento("{call actualizarEstudiante(?,?,?,?,?,?,?,?,?)}");
        GestionarBase.asignarparametrosString(1, e.getCedula());
        GestionarBase.asignarparametrosString(9, e.getMatricula());
        GestionarBase.asignarparametrosString(4, e.getNombre());
        GestionarBase.asignarparametrosString(5, e.getApellido());
        GestionarBase.asignarparametrosString(2, e.getNombreU());
        GestionarBase.asignarparametrosString(3, e.getTelefono());
        GestionarBase.asignarparametrosBoolean(8, e.isWhatsapp());
        GestionarBase.asignarparametrosString(7, e.getEmail());
        GestionarBase.asignarparametrosString(6, e.getDireccion());
        GestionarBase.ejecutarprocedimiento();
        if (e instanceof Vendedor) {
            Vendedor v = (Vendedor) e;
            GestionarBase.llamarprocedimiento("{call registrarVendedor(?,?)}");
            GestionarBase.asignarparametrosString(1, e.getCedula());
            GestionarBase.asignarparametrosDouble(2, ((Vendedor) e).getCalificacionPV());
            GestionarBase.ejecutarprocedimiento();
            GestionarBase.llamarprocedimiento("{call agregarRol(?,?,?)}");
            GestionarBase.asignarparametrosString(1, e.getCedula());
            GestionarBase.asignarparametrosString(2, "1");
            GestionarBase.asignarparametrosString(3, "Vendedor");
            GestionarBase.ejecutarprocedimiento();
        } else if (e instanceof Administrador) {
            GestionarBase.llamarprocedimiento("{call agregarRol(?,?,?)}");
            GestionarBase.asignarparametrosString(1, e.getCedula());
            GestionarBase.asignarparametrosString(2, "0");
            GestionarBase.asignarparametrosString(3, "Administrador");
            GestionarBase.ejecutarprocedimiento();
        } else if (e instanceof Comprador) {
            GestionarBase.llamarprocedimiento("{call agregarRol(?,?,?)}");
            GestionarBase.asignarparametrosString(1, e.getCedula());
            GestionarBase.asignarparametrosString(2, "2");
            GestionarBase.asignarparametrosString(3, "Comprador");
            GestionarBase.ejecutarprocedimiento();
        }
        GestionarBase.cerrar();
    }

    public static boolean verificarEstudiante(Estudiante e) {
        ResultSet r;
        GestionarBase.llamarprocedimiento("{call verificarEstudiante(?)}");
        GestionarBase.asignarparametrosString(1, e.getCedula());
        GestionarBase.ejecutarprocedimiento();
        r = GestionarBase.obtenerprocedmiento();
        boolean resultado = false;
        try {
            resultado = r.next();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public static Estudiante consultarEstudiante(String cedula) {
        Estudiante e = new Estudiante(cedula, null, null);
        ResultSet r;
        GestionarBase.llamarprocedimiento("{call consultarEstudiante(?)}");
        GestionarBase.asignarparametrosString(1, cedula);
        GestionarBase.ejecutarprocedimiento();
        r = GestionarBase.obtenerprocedmiento();
        try {
            while (r.next()) {
                if (r.getString("Rol.nombre").equals("Admministrador")) {
                    e = new Administrador(r.getString("Estudiante.cedula"),
                            r.getString("Estudiante.nombre"), r.getString("Estudiante.apellido"));
                } else if (r.getString("Rol.nombre").equals("Vendedor")) {
                    e = new Vendedor(r.getString("Estudiante.cedula"),
                            r.getString("Estudiante.nombre"), r.getString("Estudiante.apellido"));
                } else if (r.getString("Rol.nombre").equals("Comprador")) {
                    e = new Comprador(r.getString("Estudiante.cedula"),
                            r.getString("Estudiante.nombre"), r.getString("Estudiante.apellido"));
                }
                e.setMatricula(r.getString("Estudiante.matricula"));
                e.setNombreU(r.getString("Estudiante.usuario"));
                e.setTelefono(r.getString("Estudiante.telefono"));
                e.setDireccion(r.getString("Estudiante.direccion"));
                e.setEmail(r.getString("Estudiante.correo"));
                e.setWhatsapp(r.getBoolean("Estudiante.whatsapp"));
                e.setEliminadoE(r.getBoolean("Estudiante.eliminadoE"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        GestionarBase.cerrar();
        return e;
    }
    
    public static void eliminarEstudiante(String cedula) {
        GestionarBase.llamarprocedimiento("{call eliminarEstudiante(?)}");
        GestionarBase.asignarparametrosString(1, cedula);
        GestionarBase.ejecutarprocedimiento();
    }
}
