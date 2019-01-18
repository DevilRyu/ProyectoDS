/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Producto;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author Diego
 */
public class ProductoDAO {
    
    private final Conexion conexion;
    private Alert alerta;
    
    public ProductoDAO(Conexion conexion){
        this.conexion = conexion;
    }
    
    public ObservableList<Producto> articulosMasBuscados(ObservableList<Producto> articulos) {
        conexion.obtener();
        try {
            PreparedStatement consulta = conexion.getCnx().prepareStatement("SELECT * FROM "
                    + "producto ORDER BY contadorBusqueda");
            ResultSet resultados = consulta.executeQuery();
            while (resultados.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(resultados.getString("producto.idProducto"));
                producto.setCodProducto(resultados.getString("producto.codProducto"));
                producto.setNombre(resultados.getString("producto.nombre"));
                producto.setDescripcion(resultados.getString("producto.descripcion"));
                producto.setCategoria(resultados.getString("producto.categoria"));
                producto.setTiempoMax(resultados.getDate("producto.tiempoMax"));
                producto.setContadorBusqueda(resultados.getInt("producto.contadorBusqueda"));
                producto.setFechaIngreso(resultados.getDate("producto.fechaIngreso"));
                producto.setCalificacionPP(resultados.getDouble("producto.calificacionPP"));
                producto.setPrecio(resultados.getDouble("producto.precio"));
                producto.setEliminadoP(resultados.getBoolean("producto.eliminadoP"));
                producto.setIdAdmin(resultados.getString("producto.idAdmin"));
                producto.setIdVendedor(resultados.getString("producto.idVendedor"));
                articulos.add(producto);
            }
            conexion.cerrar();
        } catch (SQLException ex) {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Error de Conección");
            alerta.setContentText("Revise el estado del servidor");
            alerta.showAndWait();
        }
        return articulos;
    }
}
