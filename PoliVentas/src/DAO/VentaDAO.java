/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.GestionarBase;
import Modelos.Producto;
import Modelos.Venta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Public
 */
public class VentaDAO {
    
    public static ArrayList<Venta> ventasPendientes(String cedula) {
        ArrayList<Venta> articulos = new ArrayList();
        ResultSet r;
        GestionarBase.llamarprocedimiento("{call ventasPendientes(?)}");
        GestionarBase.asignarparametrosString(1, cedula);

        GestionarBase.ejecutarprocedimiento();
        r = GestionarBase.obtenerprocedmiento();
        System.out.println(" query consultado");
        try {
            while (r.next()) {
                
                Venta articulo = new Venta(r.getString("pNombre"), 
                        r.getString("nombre"), r.getDouble("precio"), 
                        r.getString("lugar"));
                articulos.add(articulo);
            }

            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        GestionarBase.cerrar();
        return articulos;
    }
}
