/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Gabriel
 */
public class Compra {
    
    private String nombreProducto;
    private float precio;
    private Integer calificacionV;
    private Integer calificacionP;
    
    public Compra(String nombre,float precio,Integer caliV,Integer caliP){
        this.nombreProducto=nombre;
        this.precio=precio;
        this.calificacionP=caliP;
        this.calificacionV=caliV;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Integer getCalificacionV() {
        return calificacionV;
    }

    public void setCalificacionV(Integer calificacionV) {
        this.calificacionV = calificacionV;
    }

    public Integer getCalificacionP() {
        return calificacionP;
    }

    public void setCalificacionP(Integer calificacionP) {
        this.calificacionP = calificacionP;
    }
        
}
