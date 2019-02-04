/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Diego
 */
public class Producto {

	
	private String codProducto;
	private String nombre;
	private String descripcion;
	private String categoria;
	private Date tiempoMax;
	private int contadorBusqueda;
	private Date fechaIngreso;
	private int idProducto;
	private float calificacionPP;
	private float precio;
	private boolean eliminadoP;
	private String idAdmin;
	private Vendedor vendedor;
	private int cantidad;

	public Producto(String nombre, String descripcion, String categoria, int idProducto, float precio, int cantidad) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.idProducto = idProducto;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	
	
	public Producto(String nombre, String descripcion, String categoria, int idProducto, float precio, String idAdmin,
			Vendedor vendedor, int cantidad) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.idProducto = idProducto;
		this.precio = precio;
		this.idAdmin = idAdmin;
		this.vendedor = vendedor;
		this.cantidad = cantidad;
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

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setIdVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public float getCalificacionPP() {
		return calificacionPP;
	}

	public void setCalificacionPP(float calificacionPP) {
		this.calificacionPP = calificacionPP;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

    @Override
    public String toString() {
        return "Producto{" + "codProducto=" + codProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria + ", tiempoMax=" + tiempoMax + ", contadorBusqueda=" + contadorBusqueda + ", fechaIngreso=" + fechaIngreso + ", idProducto=" + idProducto + ", calificacionPP=" + calificacionPP + ", precio=" + precio + ", eliminadoP=" + eliminadoP + ", idAdmin=" + idAdmin + ", vendedor=" + vendedor + ", cantidad=" + cantidad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Producto other = (Producto) obj;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    
        
}
