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
        boolean result = instance.crearPublicacion(publicacion);
        assertTrue("se creo", result);
    }

    /**
     * Test of modificarPublicacion method, of class ControladorPublicacion.
     */
    @Test
    public void testModificarPublicacion() {
        System.out.println("modificarPublicacion");
        Publicacion publicacion = null;
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.modificarPublicacion(publicacion);
        assertTrue("modifico", result);
    }

    /**
     * Test of borrarPublicacion method, of class ControladorPublicacion.
     */
    @Test
    public void testBorrarPublicacion() {
        System.out.println("borrarPublicacion");
        String idPublicacion = "";
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.borrarPublicacion(idPublicacion);
        assertTrue("Se borro", result);
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
        assertTrue("Se denuncio", result);
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
        boolean result = instance.puntuarPublicacion(idPublicacion, puntoEnContra);
        assertTrue("Se puntuo", result);
    }
    
}
