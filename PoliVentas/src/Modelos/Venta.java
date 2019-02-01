/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Public
 */
public class Venta {
    private String producto;
    private String comprador;
    private Double precio;
    private String lugar;

    public Venta(String Producto, String comprador, Double precio, String lugar) {
        this.producto = Producto;
        this.comprador = comprador;
        this.precio = precio;
        this.lugar = lugar;
    }            

    @Override
    public String toString() {
        return "Venta{" + "producto=" + producto + ", comprador=" + comprador + ", precio=" + precio + ", lugar=" + lugar + '}';
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    
}
