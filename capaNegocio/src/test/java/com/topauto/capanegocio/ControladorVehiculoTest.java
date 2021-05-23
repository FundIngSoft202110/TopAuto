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
     * Test of getPersistenciaVehiculo method, of class ControladorVehiculo.
     */
   /* @Test
    public void testGetPersistenciaVehiculo() {
        System.out.println("getPersistenciaVehiculo");
        ControladorVehiculo instance = new ControladorVehiculo();
        RepositorioVehiculo expResult = null;
        RepositorioVehiculo result = instance.getPersistenciaVehiculo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getVehiculos method, of class ControladorVehiculo.
     */
    /*@Test
    public void testGetVehiculos() {
        System.out.println("getVehiculos");
        ControladorVehiculo instance = new ControladorVehiculo();
        ArrayList<Vehiculo> expResult = null;
        ArrayList<Vehiculo> result = instance.getVehiculos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getFabricantes method, of class ControladorVehiculo.
     */
   /* @Test
    public void testGetFabricantes() {
        System.out.println("getFabricantes");
        ControladorVehiculo instance = new ControladorVehiculo();
        ArrayList<Fabricante> expResult = null;
        ArrayList<Fabricante> result = instance.getFabricantes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getPaises method, of class ControladorVehiculo.
     */
    /*@Test
    public void testGetPaises() {
        System.out.println("getPaises");
        ControladorVehiculo instance = new ControladorVehiculo();
        ArrayList<Pais> expResult = null;
        ArrayList<Pais> result = instance.getPaises();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setPersistenciaVehiculo method, of class ControladorVehiculo.
     */
   /* @Test
    public void testSetPersistenciaVehiculo() {
        System.out.println("setPersistenciaVehiculo");
        RepositorioVehiculo persistenciaVehiculo = null;
        ControladorVehiculo instance = new ControladorVehiculo();
        instance.setPersistenciaVehiculo(persistenciaVehiculo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setVehiculos method, of class ControladorVehiculo.
     */
    /*@Test
    public void testSetVehiculos() {
        System.out.println("setVehiculos");
        ArrayList<Vehiculo> vehiculos = null;
        ControladorVehiculo instance = new ControladorVehiculo();
        instance.setVehiculos(vehiculos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setFabricantes method, of class ControladorVehiculo.
     */
    /*@Test
    public void testSetFabricantes() {
        System.out.println("setFabricantes");
        ArrayList<Fabricante> fabricantes = null;
        ControladorVehiculo instance = new ControladorVehiculo();
        instance.setFabricantes(fabricantes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setPaises method, of class ControladorVehiculo.
     */
   /* @Test
    public void testSetPaises() {
        System.out.println("setPaises");
        ArrayList<Pais> paises = null;
        ControladorVehiculo instance = new ControladorVehiculo();
        instance.setPaises(paises);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of descargarDatos method, of class ControladorVehiculo.
     */
    @Test
    public void testDescargarDatos() {
        System.out.println("descargarDatos");
        ControladorVehiculo instance = new ControladorVehiculo();
        boolean expResult = false;
        boolean result = instance.descargarDatos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearVehiculo method, of class ControladorVehiculo.
     */
    @Test
    public void testCrearVehiculo() {
        System.out.println("crearVehiculo");
        Vehiculo vehiculo = null;
        ControladorVehiculo instance = new ControladorVehiculo();
        boolean expResult = false;
        boolean result = instance.crearVehiculo(vehiculo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarVehiculo method, of class ControladorVehiculo.
     */
    @Test
    public void testModificarVehiculo() {
        System.out.println("modificarVehiculo");
        Vehiculo vehiculo = null;
        ControladorVehiculo instance = new ControladorVehiculo();
        boolean expResult = false;
        boolean result = instance.modificarVehiculo(vehiculo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarVehiculo method, of class ControladorVehiculo.
     */
    @Test
    public void testBorrarVehiculo() {
        System.out.println("borrarVehiculo");
        String idVehiculo = "";
        ControladorVehiculo instance = new ControladorVehiculo();
        boolean expResult = false;
        boolean result = instance.borrarVehiculo(idVehiculo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarVehiculo method, of class ControladorVehiculo.
     */
    @Test
    public void testBuscarVehiculo() {
        System.out.println("buscarVehiculo");
        String busqueda = "";
        ControladorVehiculo instance = new ControladorVehiculo();
        boolean expResult = false;
        boolean result = instance.buscarVehiculo(busqueda);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
