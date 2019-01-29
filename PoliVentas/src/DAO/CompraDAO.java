/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.GestionarBase;
import Modelos.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Public
 */
public class CompraDAO {
    public static ArrayList<Producto> comprasPendientes() {

        ArrayList<Producto> arreglo = new ArrayList<Producto>();
        ResultSet r;
        GestionarBase.llamarprocedimiento("{call obtener_productos()}");
        GestionarBase.ejecutarprocedimiento();
        r = GestionarBase.obtenerprocedmiento();
        try {
            while (r.next()) {
                Producto d;
                d = new Producto(r.getString("nombre"), r.getString("descripcion"), r.getString("categoria"), r.getInt("idProducto"), r.getFloat("precio"),
                        r.getString("idAdmin"), r.getString("idVendedor"), r.getInt("cantidad"));

                arreglo.add(d);

            }

            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        GestionarBase.cerrar();
        return arreglo;
    }
}
