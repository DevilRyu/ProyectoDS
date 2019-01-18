/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Date;

/**
 *
 * @author Diego
 */
public class Producto {
    
    private String idProducto;
    private String codProducto;
    private String nombre;
    private String descripcion;
    private String categoria;
    private Date tiempoMax;
    private int contadorBusqueda;
    private Date fechaIngreso;
    private double calificacionPP;
    private double precio;
    private boolean eliminadoP;
    private String idAdmin;
    private String idVendedor;

    public String getIdProducto() {
        return idProducto;
    }

    public double getCalificacionPP() {
        return calificacionPP;
    }

    public void setCalificacionPP(double calificacionPP) {
        this.calificacionPP = calificacionPP;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getTiempoMax() {
        return tiempoMax;
    }

    public void setTiempoMax(Date tiempoMax) {
        this.tiempoMax = tiempoMax;
    }

    public int getContadorBusqueda() {
        return contadorBusqueda;
    }

    public void setContadorBusqueda(int contadorBusqueda) {
        this.contadorBusqueda = contadorBusqueda;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEliminadoP() {
        return eliminadoP;
    }

    public void setEliminadoP(boolean eliminadoP) {
        this.eliminadoP = eliminadoP;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }
    
    
    
}
