/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioPerfil;
import com.topauto.capaentidades.Usuario;
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
public class ControladorPerfilTest {
    
    public ControladorPerfilTest() {
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
     * Test of getPersistenciaPerfil method, of class ControladorPerfil.
     */
    /*@Test
    public void testGetPersistenciaPerfil() {
        System.out.println("getPersistenciaPerfil");
        ControladorPerfil instance = new ControladorPerfil();
        RepositorioPerfil expResult = null;
        RepositorioPerfil result = instance.getPersistenciaPerfil();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getUsuarios method, of class ControladorPerfil.
     */
    /*@Test
    public void testGetUsuarios() {
        System.out.println("getUsuarios");
        ControladorPerfil instance = new ControladorPerfil();
        ArrayList<Usuario> expResult = null;
        ArrayList<Usuario> result = instance.getUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setPersistenciaPerfil method, of class ControladorPerfil.
     */
    /*@Test
    public void testSetPersistenciaPerfil() {
        System.out.println("setPersistenciaPerfil");
        RepositorioPerfil persistenciaPerfil = null;
        ControladorPerfil instance = new ControladorPerfil();
        instance.setPersistenciaPerfil(persistenciaPerfil);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setUsuarios method, of class ControladorPerfil.
     */
    /*@Test
    public void testSetUsuarios() {
        System.out.println("setUsuarios");
        ArrayList<Usuario> usuarios = null;
        ControladorPerfil instance = new ControladorPerfil();
        instance.setUsuarios(usuarios);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of descargarDatos method, of class ControladorPerfil.
     */
  /*  @Test
    public void testDescargarDatos() {
        System.out.println("descargarDatos");
        ControladorPerfil instance = new ControladorPerfil();
        boolean expResult = false;
        boolean result = instance.descargarDatos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of esCorreo method, of class ControladorPerfil.
     */
    @Test
    public void testEsCorreo() {
        System.out.println("esCorreo");
        String cadena = "richfonpan@yahoo.com";
        ControladorPerfil instance = new ControladorPerfil();
        //boolean expResult = true;
        boolean result = instance.esCorreo(cadena);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test failed");
    }

    /**
     * Test of validarCorreo method, of class ControladorPerfil.
     */
    @Test
    public void testValidarCorreo() {
        System.out.println("validarCorreo");
        String correo = "richfonpan@yahoo.com";
        ControladorPerfil pr = new ControladorPerfil();
        boolean expResult = true;
        boolean result = pr.validarCorreo(correo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test failed");
    }

    /**
     * Test of validarUserName method, of class ControladorPerfil.
     */
    @Test
    public void testValidarUserName() {
        System.out.println("validarUserName");
        String username = "richfon";
        ControladorPerfil instance = new ControladorPerfil();
        boolean expResult = true;
        boolean result = instance.validarUserName(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test failed");
    }

    /**
     * Test of acceder method, of class ControladorPerfil.
     */
    @Test
    public void testAcceder() {
        System.out.println("acceder");
        String identificador = "";
        String contrasenia = "";
        ControladorPerfil instance = new ControladorPerfil();
        boolean expResult = false;
        boolean result = instance.acceder(identificador, contrasenia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarPerfil method, of class ControladorPerfil.
     */
    @Test
    public void testRegistrarPerfil() {
        System.out.println("registrarPerfil");
        Usuario usuario = null;
        ControladorPerfil instance = new ControladorPerfil();
        boolean expResult = false;
        boolean result = instance.registrarPerfil(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarPerfil method, of class ControladorPerfil.
     */
    @Test
    public void testModificarPerfil() {
        System.out.println("modificarPerfil");
        Usuario usuario = null;
        ControladorPerfil instance = new ControladorPerfil();
        boolean expResult = false;
        boolean result = instance.modificarPerfil(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarContraseña method, of class ControladorPerfil.
     */
    @Test
    public void testModificarContraseña() {
        System.out.println("modificarContrase\u00f1a");
        String identificador = "";
        String nueva = "";
        ControladorPerfil instance = new ControladorPerfil();
        boolean expResult = false;
        boolean result = instance.modificarContraseña(identificador, nueva);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
