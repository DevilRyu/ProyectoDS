/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controladores.VentanaPrincipal;
import DAO.EstudianteDAO;
import static DAO.EstudianteDAO.validarLogin;
import DAO.ProductoDAO;
import DAO.VentaDAO;
import Modelos.Compra;
import Modelos.Estudiante;
import Modelos.Producto;
import Modelos.Vendedor;
import Modelos.Venta;
import java.util.ArrayList;
import java.util.LinkedList;
import junit.framework.TestCase;
import org.junit.Assert;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel
 */
public class UnitTest extends TestCase {
    
    public static void testVerificacionEstudiante(){
        assertTrue(EstudianteDAO.verificarEstudiante(new Estudiante("9876543210","Diego","Muñoz")));
    }
    
    public static void testConsultarEstudiante(){
        Estudiante e1 = new Estudiante("9876543210","Diego","Muñoz");
        Estudiante e2 = EstudianteDAO.consultarEstudiante("9876543210");
        assertEquals(e1.getNombre(),e2.getNombre());
    }
    
    public static void testValidarLogin(){
        LinkedList<String> valorEsperado=new LinkedList<String>();
        valorEsperado.add("19uan96");
        valorEsperado.add("Comprador");
        
        ArrayList<String> valorObtenido=validarLogin("jdvera");
        
        assertEquals(valorEsperado.getFirst(),valorObtenido.get(0));
        
    }
    
    public static void testComprasPendientes(){
        VentanaPrincipal.estudianteLogeado=new Estudiante("1312561952",
                "Juan Diego","Vera Benavides");
        ArrayList<Compra> valorObtenido=ProductoDAO.comprasPendientes();
        Assert.assertSame(valorObtenido.size(), 2);
    }
    
    public static void testArticulosMasBuscados(){
        ArrayList<Producto> valorObtenido=ProductoDAO.articulosMasBuscados();
        Assert.assertSame(valorObtenido.size(), 8);
    }
    
    public static void testBusquedaSencilla(){
        ArrayList<Producto> tArticulo=ProductoDAO.busquedaSencilla("fonos");
        ArrayList<Producto> tArticulo2=new ArrayList<Producto>();
        tArticulo2.add(new Producto("Audifonos","Ligeros","Tecnologia",82,10,"0123456789",new Vendedor("123456789","Agente Pepe","prueba"),10));        
        assertArrayEquals(tArticulo.toArray(), tArticulo2.toArray());
    }
    
    public static void testVentasPendientes(){
        ArrayList<Venta> tVenta=VentaDAO.ventasPendientes("0923454321");
        ArrayList<Venta> tVenta2=new ArrayList<Venta>();
        tVenta2.add(new Venta("Audifonos","Juan Diego",10,"Kiosko 1"));
        tVenta2.add(new Venta("Gafas","Pablo Andres",50,"Kiosko 1"));
        assertArrayEquals(tVenta.toArray(), tVenta2.toArray());
    }
    
    public static void testobtenerProductosVendedor(){
        ArrayList<Producto>  tProductos=ProductoDAO.obtener_productosVendedor("234567890");
        ArrayList<Producto>  tProductos2=new ArrayList<Producto>();
        tProductos2.add(new Producto("Iphone 8","Nuevo de Paquete","Tecnologia",22,900,"0123456789",new Vendedor("234567890","Carmen","SanDiego"),1));
        tProductos2.add(new Producto("Gafas","De sol marca RayBan","Accesorios",84,50,"0123456789",new Vendedor("234567890","Carmen","SanDiego"),15));
        assertArrayEquals(tProductos.toArray(), tProductos2.toArray());
                
    }
    
    public static void testobtenerProductos(){
        ArrayList<Producto> productos=ProductoDAO.obtener_productos();
        Assert.assertSame(productos.size(),8);
                
    }
    
    public static void testverificarProducto(){
        Producto p=new Producto("Iphone 8","Nuevo de Paquete","Tecnologia",22,900,"0123456789",new Vendedor("234567890","Carmen","SanDiego"),1);
        ArrayList<Producto> productos=ProductoDAO.verificar_producto(p);
        Assert.assertSame(productos.size(),1);
                
    }
    
    
    
}
