package DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DataBase.GestionarBase;
import Modelos.Producto;
import Modelos.Compra;
import Modelos.Vendedor;

/**
 *
 * @author creditos
 */
public class ProductoDAO {

    public static void registrar_producto(Producto a) {
        GestionarBase.llamarprocedimiento("{call registrar_producto(?,?,?,?,?,?)}");
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
        GestionarBase.llamarprocedimiento("{call obtener_productos()}");
        GestionarBase.ejecutarprocedimiento();
        r = GestionarBase.obtenerprocedmiento();
        try {
            while (r.next()) {
                Producto d;
                d = new Producto(r.getString("pNombre"), r.getString("descripcion"), r.getString("categoria"), r.getInt("idProducto"), r.getFloat("precio"),
                        r.getString("idAdmin"), new Vendedor(r.getString("idVendedor"),"",""), r.getInt("cantidad"));

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
        GestionarBase.llamarprocedimiento("{call verificar_productos(?)}");
        GestionarBase.asignarparametrosString(1, a.getNombre());
        GestionarBase.ejecutarprocedimiento();
        r = GestionarBase.obtenerprocedmiento();
        try {
            while (r.next()) {
                Producto d = new Producto(r.getString("pNombre"), r.getString("descripcion"), r.getString("categoria"), r.getInt("idProducto"), r.getFloat("precio"),
                        r.getString("idAdmin"), new Vendedor(r.getString("idVendedor"),"",""), r.getInt("cantidad"));
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
        GestionarBase.llamarprocedimiento("{call obtener_productosVendedor(?)}");
        GestionarBase.asignarparametrosString(1, a);
        GestionarBase.ejecutarprocedimiento();
        r = GestionarBase.obtenerprocedmiento();
        try {
            while (r.next()) {

                Producto d;
                d = new Producto(r.getString("nombre"), r.getString("descripcion"), r.getString("categoria"), r.getInt("idProducto"), r.getFloat("precio"),
                        r.getString("idAdmin"), new Vendedor(r.getString("idVendedor"),"",""), r.getInt("cantidad"));

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
        GestionarBase.llamarprocedimiento("{call eliminar_producto(?,?)}");
        GestionarBase.asignarparametrosString(1, a);
        GestionarBase.asignarparametrosString(2, b);
        GestionarBase.ejecutarprocedimiento();
        GestionarBase.cerrar();

    }

    public static ArrayList<Producto> articulosMasBuscados() {
        ArrayList<Producto> articulos  = new ArrayList();
        ResultSet r;
        GestionarBase.llamarprocedimiento("{call articulosMasBuscados()}");
        GestionarBase.ejecutarprocedimiento();
        r = GestionarBase.obtenerprocedmiento();
        try {
            while (r.next()) {
                Producto articulo = new Producto(r.getString("pNombre"), r.getString("descripcion"), r.getString("categoria"), r.getInt("idProducto"), r.getFloat("precio"),
                        r.getString("idAdmin"), new Vendedor(r.getString("idVendedor"),"",""), r.getInt("cantidad"));
                articulos.add(articulo);
            }

            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        GestionarBase.cerrar();
        return articulos;
    }
    
    public static ArrayList<Producto> busquedaSencilla(String coincidencia) {
        ArrayList<Producto> articulos  = new ArrayList();
        ResultSet r;
        GestionarBase.llamarprocedimiento("{call busquedaSencilla(?)}");

        GestionarBase.asignarparametrosString(1, coincidencia);

        GestionarBase.ejecutarprocedimiento();
        r = GestionarBase.obtenerprocedmiento();
        System.out.println(" query consultado");
        try {
            while (r.next()) {
                /*Producto articulo = new Producto(r.getString("nombre"), r.getString("descripcion"), r.getString("categoria"), r.getInt("idProducto"), r.getFloat("precio"),
                        r.getString("idAdmin"),new Vendedor(r.getString("idVendedor"),"Andres","Ipa"), r.getInt("cantidad"));*/
                Producto articulo = new Producto(r.getString("pNombre"), r.getString("descripcion"), r.getString("categoria"), r.getInt("idProducto"), r.getFloat("precio"),
                        r.getString("idAdmin"),new Vendedor(r.getString("idVendedor"),r.getString("nombre"),r.getString("apellido")), r.getInt("cantidad"));
                articulos.add(articulo);
            }

            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        GestionarBase.cerrar();
        return articulos;
    }
    
    public static ArrayList<Compra> comprasPendientes() {
	ArrayList<Compra> comprasP  = new ArrayList();
        ResultSet r;
        GestionarBase.llamarprocedimiento("{call consultarCompraPendiente(?)}");
        GestionarBase.asignarparametrosString(1, "1312561952");
        GestionarBase.ejecutarprocedimiento();
        r = GestionarBase.obtenerprocedmiento();
        try {
            while (r.next()) {
                String nombreProducto=r.getString("pNombre");
                float precioProducto=r.getFloat("precio");
                int calificacionV=r.getInt("calificacionPV");
                int calificacionP=r.getInt("calificacionPP");
                Compra compra=new Compra(nombreProducto,precioProducto,calificacionV,calificacionP);
                comprasP.add(compra);
            }
            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        GestionarBase.cerrar();
        return comprasP;
    }
}
