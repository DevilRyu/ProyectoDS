/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackages;

import DAO.EstudianteDAO;
import Modelos.Estudiante;
import junit.framework.TestCase;

/**
 *
 * @author Diego
 */
public class EstudianteDAOJunit extends TestCase{
    
    public static void main(String[] args) {
        testVerificacionEstudiante();
        testConsultarEstudiante();
    }
    
    public static void testVerificacionEstudiante(){
        assertTrue(EstudianteDAO.verificarEstudiante(new Estudiante("9876543210","Diego","Muñoz")));
    }
    
    public static void testConsultarEstudiante(){
        Estudiante e1 = new Estudiante("9876543210","Diego","Muñoz");
        Estudiante e2 = EstudianteDAO.consultarEstudiante("9876543210");
        assertEquals(e1.getNombre(),e2.getNombre());
    }
}