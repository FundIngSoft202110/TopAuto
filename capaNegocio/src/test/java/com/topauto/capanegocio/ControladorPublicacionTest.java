/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioPublicacion;
import com.topauto.capaentidades.Publicacion;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Richard Fonseca
 */
public class ControladorPublicacionTest {
    
    public ControladorPublicacionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPersistenciaPublicacion method, of class ControladorPublicacion.
     */
   /* @Test
    public void testGetPersistenciaPublicacion() {
        System.out.println("getPersistenciaPublicacion");
        ControladorPublicacion instance = new ControladorPublicacion();
        RepositorioPublicacion expResult = null;
        RepositorioPublicacion result = instance.getPersistenciaPublicacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getPublicaciones method, of class ControladorPublicacion.
     */
  /*  @Test
    public void testGetPublicaciones() {
        System.out.println("getPublicaciones");
        ControladorPublicacion instance = new ControladorPublicacion();
        ArrayList<Publicacion> expResult = null;
        ArrayList<Publicacion> result = instance.getPublicaciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setPersistenciaPublicacion method, of class ControladorPublicacion.
     */
   /* @Test
    public void testSetPersistenciaPublicacion() {
        System.out.println("setPersistenciaPublicacion");
        RepositorioPublicacion persistenciaPublicacion = null;
        ControladorPublicacion instance = new ControladorPublicacion();
        instance.setPersistenciaPublicacion(persistenciaPublicacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setPublicaciones method, of class ControladorPublicacion.
     */
  /*  @Test
    public void testSetPublicaciones() {
        System.out.println("setPublicaciones");
        ArrayList<Publicacion> publicaciones = null;
        ControladorPublicacion instance = new ControladorPublicacion();
        instance.setPublicaciones(publicaciones);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of descargarDatos method, of class ControladorPublicacion.
     */
   /* @Test
    public void testDescargarDatos() {
        System.out.println("descargarDatos");
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean expResult = false;
        boolean result = instance.descargarDatos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of crearPublicacion method, of class ControladorPublicacion.
     */
    @Test
    public void testCrearPublicacion() {
        System.out.println("crearPublicacion");
        Publicacion publicacion = null;
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean expResult = false;
        boolean result = instance.crearPublicacion(publicacion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarPublicacion method, of class ControladorPublicacion.
     */
    @Test
    public void testModificarPublicacion() {
        System.out.println("modificarPublicacion");
        Publicacion publicacion = null;
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean expResult = false;
        boolean result = instance.modificarPublicacion(publicacion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarPublicacion method, of class ControladorPublicacion.
     */
    @Test
    public void testBorrarPublicacion() {
        System.out.println("borrarPublicacion");
        String idPublicacion = "";
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean expResult = false;
        boolean result = instance.borrarPublicacion(idPublicacion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of denunciarPublicacion method, of class ControladorPublicacion.
     */
    @Test
    public void testDenunciarPublicacion() {
        System.out.println("denunciarPublicacion");
        String idPublicacion = "";
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean expResult = false;
        boolean result = instance.denunciarPublicacion(idPublicacion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of puntuarPublicacion method, of class ControladorPublicacion.
     */
    @Test
    public void testPuntuarPublicacion() {
        System.out.println("puntuarPublicacion");
        String idPublicacion = "";
        boolean puntoEnContra = false;
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean expResult = false;
        boolean result = instance.puntuarPublicacion(idPublicacion, puntoEnContra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
