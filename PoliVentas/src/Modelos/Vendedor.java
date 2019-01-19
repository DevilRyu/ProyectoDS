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
public class Vendedor extends Comprador{
    
    private double calificacionPV;
    
    public Vendedor(){
        super();
    }

    public double getCalificacionPV() {
        return calificacionPV;
    }

    public void setCalificacionPV(double calificacionPV) {
        this.calificacionPV = calificacionPV;
    }
    
    
}
