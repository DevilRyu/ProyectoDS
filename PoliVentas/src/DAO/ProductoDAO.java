package DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DataBase.GestionarBase;
import Modelos.Producto;

/**
 *
 * @author creditos
 */
public class ProductoDAO {

    public static void registrar_producto(Producto a) {
        GestionarBase.crearprocedimiento("{call registrar_producto(?,?,?,?,?,?)}");
        GestionarBase.asignarparametrosInt(1, a.getIdProducto());
        GestionarBase.asignarparametrosString(2, a.getNombre());
        GestionarBase.asignarparametrosString(3, a.getDescripcion());
        GestionarBase.asignarparametrosString(4, a.getCategoria());
        GestionarBase.asignarparametrosFloat(5, a.getPrecio());
        GestionarBase.asignarparametrosInt(6, a.getCantidad());

        GestionarBase.ejecutarprocedimiento();
        GestionarBase.cerrar();
    }

    public static ArrayList<Producto> obtener_productos() {

        ArrayList<Producto> arreglo = new ArrayList<Producto>();
        ResultSet r;
        GestionarBase.crearprocedimiento("{call obtener_productos()}");
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

    public static ArrayList<Producto> verificar_producto(Producto a) {

        ArrayList<Producto> arreglo = new ArrayList<Producto>();
        ResultSet r;
        GestionarBase.crearprocedimiento("{call verificar_productos(?)}");
        GestionarBase.asignarparametrosString(1, a.getNombre());
        GestionarBase.ejecutarprocedimiento();
        r = GestionarBase.obtenerprocedmiento();
        try {
            while (r.next()) {
                Producto d = new Producto(r.getString("nombre"), r.getString("descripcion"), r.getString("categoria"), r.getInt("idProducto"), r.getFloat("precio"),
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

    public static ArrayList<Producto> obtener_productosVendedor(String a) {

        ArrayList<Producto> arreglo = new ArrayList<Producto>();
        ResultSet r;
        GestionarBase.crearprocedimiento("{call obtener_productosVendedor(?)}");
        GestionarBase.asignarparametrosString(1, a);
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

    public static void eliminar_producto(String a, String b) {
        GestionarBase.crearprocedimiento("{call eliminar_producto(?,?)}");
        GestionarBase.asignarparametrosString(1, a);
        GestionarBase.asignarparametrosString(2, b);
        GestionarBase.ejecutarprocedimiento();
        GestionarBase.cerrar();

    }

    public static ArrayList<Producto> articulosMasBuscados() {
        ArrayList<Producto> articulos  = new ArrayList();
        ResultSet r;
        GestionarBase.crearprocedimiento("{call articulosMasBuscados()}");
        GestionarBase.ejecutarprocedimiento();
        r = GestionarBase.obtenerprocedmiento();
        try {
            while (r.next()) {
                Producto articulo = new Producto(r.getString("nombre"), r.getString("descripcion"), r.getString("categoria"), r.getInt("idProducto"), r.getFloat("precio"),
                        r.getString("idAdmin"), r.getString("idVendedor"), r.getInt("cantidad"));
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
