/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioVehiculo;
import com.topauto.capaentidades.Fabricante;
import com.topauto.capaentidades.Pais;
import com.topauto.capaentidades.Vehiculo;
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
public class ControladorVehiculoTest {
    
    public ControladorVehiculoTest() {
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
     * Test of descargarDatos method, of class ControladorVehiculo.
     */
    /*@Test
    public void testDescargarDatos() {
        System.out.println("descargarDatos");
        ControladorVehiculo instance = new ControladorVehiculo();
        boolean expResult = false;
        boolean result = instance.descargarDatos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of crearVehiculo method, of class ControladorVehiculo.
     */
    @Test
    public void testCrearVehiculo() {
        System.out.println("crearVehiculo");
        Vehiculo vehiculo = null;
        ControladorVehiculo instance = new ControladorVehiculo();
        boolean result = instance.crearVehiculo(vehiculo);
        assertTrue("Se creo", result);
    }

    /**
     * Test of modificarVehiculo method, of class ControladorVehiculo.
     */
    @Test
    public void testModificarVehiculo() {
        System.out.println("modificarVehiculo");
        Vehiculo vehiculo = null;
        ControladorVehiculo instance = new ControladorVehiculo();
        boolean result = instance.modificarVehiculo(vehiculo);
        assertTrue("se modifico", result);
    }

    /**
     * Test of borrarVehiculo method, of class ControladorVehiculo.
     */
    @Test
    public void testBorrarVehiculo() {
        System.out.println("borrarVehiculo");
        String idVehiculo = "";
        ControladorVehiculo instance = new ControladorVehiculo();
        boolean result = instance.borrarVehiculo(idVehiculo);
        assertTrue("Se borro", result);
    }

    /**
     * Test of buscarVehiculo method, of class ControladorVehiculo.
     */
    @Test
    public void testBuscarVehiculo() {
        System.out.println("buscarVehiculo");
        String busqueda = "";
        ControladorVehiculo instance = new ControladorVehiculo();
        boolean result = instance.buscarVehiculo(busqueda);
        assertTrue("Se busco", result);
    }
    
}
