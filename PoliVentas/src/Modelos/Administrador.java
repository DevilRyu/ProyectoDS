/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import DataBase.GestionarBase;

/**
 *
 * @author Diego
 */
public class Administrador extends Estudiante {

    public Administrador(String cedula, String nombre, String apellido) {
        super(cedula, nombre, apellido);
    }

    @Override
    public void registrarEstudiante() {
        GestionarBase.llamarprocedimiento("{call agregarRol(?,?,?)}");
        GestionarBase.asignarparametrosString(1, this.getCedula());
        GestionarBase.asignarparametrosString(2, "0");
        GestionarBase.asignarparametrosString(3, "Administrador");
        GestionarBase.ejecutarprocedimiento();
    }
    
    @Override
    public void actualizarEstudiante(){
        this.registrarEstudiante();
    }
}
