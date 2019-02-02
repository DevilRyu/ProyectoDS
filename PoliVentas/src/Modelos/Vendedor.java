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
public class Vendedor extends Estudiante {

    private double calificacionPV;

    public Vendedor(String cedula, String nombre, String apellido) {
        super(cedula, nombre, apellido);
    }

    @Override
    public void registrarEstudiante() {
        GestionarBase.llamarprocedimiento("{call registrarVendedor(?,?)}");
        GestionarBase.asignarparametrosString(1, this.getCedula());
        GestionarBase.asignarparametrosDouble(2, this.getCalificacionPV());
        GestionarBase.ejecutarprocedimiento();
        GestionarBase.llamarprocedimiento("{call agregarRol(?,?,?)}");
        GestionarBase.asignarparametrosString(1, this.getCedula());
        GestionarBase.asignarparametrosString(2, "1");
        GestionarBase.asignarparametrosString(3, "Vendedor");
        GestionarBase.ejecutarprocedimiento();
    }
    
    @Override
    public void actualizarEstudiante(){
        this.registrarEstudiante();
    }

    public double getCalificacionPV() {
        return calificacionPV;
    }

    public void setCalificacionPV(double calificacionPV) {
        this.calificacionPV = calificacionPV;
    }

    @Override
    public String toString() {
        return super.getNombre() + " " + super.getApellido();
    }
}
