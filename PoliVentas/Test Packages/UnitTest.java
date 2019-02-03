/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.EstudianteDAO;
import static DAO.EstudianteDAO.validarLogin;
import DAO.ProductoDAO;
import Modelos.Compra;
import Modelos.Estudiante;
import Modelos.Producto;
import java.util.ArrayList;
import java.util.LinkedList;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
        LinkedList<String> valorEsperado=new LinkedList<>();
        valorEsperado.add("19uan96");
        valorEsperado.add("Comprador");
        
        LinkedList<String> valorObtenido=validarLogin("jdvera");
        
        assertEquals(valorEsperado.getFirst(),valorObtenido.getFirst());
        
    }
    
    public static void testComprasPendientes(){
        ArrayList<Compra> valorObtenido=ProductoDAO.comprasPendientes();
        Assert.assertSame(valorObtenido.size(), 2);
    }
    
    public static void testArticulosMasBuscados(){
        ArrayList<Producto> valorObtenido=ProductoDAO.articulosMasBuscados();
        Assert.assertSame(valorObtenido.size(), 8);
    }
    
}
