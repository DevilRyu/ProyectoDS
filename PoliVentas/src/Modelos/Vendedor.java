/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Diego
 */
public class Vendedor extends Estudiante{
    
	
    public Vendedor(String cedula, String nombre, String apellido) {
		super(cedula, nombre, apellido);
	}

	private double calificacionPV;
    
    
   
    

    public double getCalificacionPV() {
        return calificacionPV;
    }

    public void setCalificacionPV(double calificacionPV) {
        this.calificacionPV = calificacionPV;
    }
    
    
}
