/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioPerfil;
import com.topauto.capaentidades.Pais;
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
        boolean result = instance.esCorreo(cadena);
        assertEquals(true, result);
    }

    @Test
    public void testNoEsCorreo() {
        System.out.println("No esCorreo");
        String cadena = "richfonpan";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.esCorreo(cadena);
        assertEquals(false, result);
    }

    @Test
    public void testEsCorreoNuevo() {
        System.out.println("EsCorreo no registrado");
        String cadena = "r2d2@hotmail.com";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.esCorreo(cadena);
        assertEquals(true, result);
    }

    @Test
    public void testEsCorreoVacio() {
        System.out.println("EsCorreo vacio");
        String cadena = "";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.esCorreo(cadena);
        assertEquals(false, result);
    }

    /**
     * Test of validarCorreo method, of class ControladorPerfil.
     */
    @Test
    public void testValidarCorreo() {
        System.out.println("validarCorreo");
        String correo = "richfonpan@yahoo.com";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.validarCorreo(correo);
        assertEquals(true, result);
    }

    @Test
    public void testValidarNoCorreoRegis() {
        System.out.println("validarCorreo no regis");
        String correo = "r2d2@hotmail.com";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.validarCorreo(correo);
        assertEquals(false, result);
    }

    @Test
    public void testValidarCorreoVacio() {
        System.out.println("validarCorreo vacio");
        String correo = "";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.validarCorreo(correo);
        assertEquals(false, result);
    }

    @Test
    public void testValidarCorreoDatoNoVal() {
        System.out.println("validarCorreo no valido");
        String correo = "hola";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.validarCorreo(correo);
        assertEquals(false, result);
    }

    /**
     * Test of validarUserName method, of class ControladorPerfil.
     */
    @Test
    public void testValidarUserName() {
        System.out.println("validarUserName");
        String username = "richfon";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.validarUserName(username);
        assertEquals(true, result);
    }

    @Test
    public void testValidarUserNameNoRegis() {
        System.out.println("validarUserName no registrado");
        String username = "r2d2";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.validarUserName(username);
        assertEquals(false, result);
    }

    @Test
    public void testValidarUserNameVacio() {
        System.out.println("validarUserName vacio");
        String username = "";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.validarUserName(username);
        assertEquals(false, result);
    }

    @Test
    public void testValidarUserNameCapLock() {
        System.out.println("validarUserName caplock");
        String username = "RichFon";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.validarUserName(username);
        assertEquals(false, result);
    }

    /**
     * Test of acceder method, of class ControladorPerfil.
     */
    @Test
    public void testAcceder() {
        System.out.println("acceder");
        String identificador = "richfon";
        String contrasenia = "richfon123";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.acceder(identificador, contrasenia);
        assertEquals(true, result);
    }

    @Test
    public void testAccederNoUser() {
        System.out.println("acceder no user");
        String identificador = "Aaa";
        String contrasenia = "richfon123";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.acceder(identificador, contrasenia);
        assertEquals(false, result);
    }

    @Test
    public void testAccederNoContra() {
        System.out.println("acceder no contrasenia");
        String identificador = "richfon";
        String contrasenia = "azul";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.acceder(identificador, contrasenia);
        assertEquals(false, result);
    }

    @Test
    public void testAccederCapLock() {
        System.out.println("acceder caplock");
        String identificador = "RichFon";
        String contrasenia = "rIchfON123";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.acceder(identificador, contrasenia);
        assertEquals(false, result);
    }

    @Test
    public void testAccederContraVacia() {
        System.out.println("acceder sin contrasenia");
        String identificador = "richfon";
        String contrasenia = "";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.acceder(identificador, contrasenia);
        assertEquals(false, result);
    }

    /**
     * Test of registrarPerfil method, of class ControladorPerfil.
     */
    @Test
    public void testRegistrarPerfil() {
        System.out.println("registrarPerfil");
        Pais pais = new Pais("Colombia");
        Usuario usuario = new Usuario("Arturo", "r2d2", "r2d2@gmail.com", "azul", pais);
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.registrarPerfil(usuario);
        assertEquals(true, result);
    }

    @Test
    public void testRegistrarPerfilYaRegistrado() {
        System.out.println("registrarPerfil");
        Pais pais = new Pais("Colombia");
        Usuario usuario = new Usuario("Pepe", "richfon", "richfonpan@yahoo.com", "azul", pais);
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.registrarPerfil(usuario);
        assertEquals(false, result);
    }

    @Test
    public void testRegistrarPerfilNoContraseña() {
        System.out.println("registrarPerfil");
        Pais pais = new Pais("Italia");
        Usuario usuario = new Usuario("Pepe", "richfon", "richfonpan@yahoo.com", "", pais);
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.registrarPerfil(usuario);
        assertEquals(false, result);
    }

    @Test
    public void testRegistrarPerfilYaRegistradoCapLock() {
        System.out.println("registrarPerfil");
        Pais pais = new Pais("Japon");
        Usuario usuario = new Usuario("Ricardo", "Richfon", "richfonpan@yahoo.com", "azul", pais);
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.registrarPerfil(usuario);
        assertEquals(false, result);
    }

    /**
     * Test of modificarPerfil method, of class ControladorPerfil.
     */
    @Test
    public void testModificarPerfilDesIgual() {
        System.out.println("modificarPerfil Igual");
        Usuario usuario = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo123", "Critico profesional de automoviles e integrante importante de TopAuto");
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.modificarPerfil(usuario);
        assertEquals(true, result);
    }

    @Test
    public void testModificarPerfilDesVacio() {
        System.out.println("modificarPerfil vacio");
        Usuario usuario = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo123", "");
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.modificarPerfil(usuario);
        assertEquals(true, result);
    }

    @Test
    public void testModificarPerfilNUlO() {
        System.out.println("modificarPerfil null");
        Usuario usuario = null;
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.modificarPerfil(usuario);
        assertEquals(false, result);
    }

    @Test
    public void testModificarPerfilDes() {
        System.out.println("modificarPerfil des");
        Usuario usuario = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo123", "Un critico profesional de automoviles e integrante importante de TopAuto");
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.modificarPerfil(usuario);
        assertEquals(true, result);
    }

    @Test
    public void testModificarPerfilUsername() {
        System.out.println("modificarPerfil username");
        Usuario usuario = new Usuario("Richard Fonseca", "richfon8", "richfonpan@yahoo123", "Critico profesional de automoviles e integrante importante de TopAuto");
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.modificarPerfil(usuario);
        assertEquals(false, result);
    }

    /**
     * Test of modificarContraseña method, of class ControladorPerfil.
     */
    @Test
    public void testModificarContraseña() {
        System.out.println("modificarContrasenia");
        String identificador = "ramo";
        String nueva = "ramo124";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.modificarContraseña(identificador, nueva);
        assertEquals(true, result);
    }

    @Test
    public void testModificarContraseñaIgual() {
        System.out.println("modificarContrasenia esta igual");
        String identificador = "ramo";
        String nueva = "ramo123";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.modificarContraseña(identificador, nueva);
        assertEquals(true, result);
    }

    @Test
    public void testModificarContraseñaUserNoExist() {
        System.out.println("modificarContrasenia user no exist");
        String identificador = "diosito";
        String nueva = "ramo123";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.modificarContraseña(identificador, nueva);
        assertEquals(false, result);
    }

    @Test
    public void testModificarContraseñaUsername() {
        System.out.println("modificarContrasenia contra=user");
        String identificador = "ramo";
        String nueva = "ramo";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.modificarContraseña(identificador, nueva);
        assertEquals(false, result);
    }

    @Test
    public void testModificarContraseñavacio() {
        System.out.println("modificarContrasenia contra=user");
        String identificador = "ramo";
        String nueva = "";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.modificarContraseña(identificador, nueva);
        assertEquals(false, result);
    }

    /**
     * Test of borrarUsuario method, of class ControladorPerfil.
     */
    @Test
    public void testBorrarUsuario() {
        System.out.println("borrarUsuario");
        String username = "richfon";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.borrarUsuario(username);
        assertEquals(true, result);
    }

    @Test
    public void testBorrarUsuariovacio() {
        System.out.println("borrarUsuario vacio");
        String username = "";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.borrarUsuario(username);
        assertEquals(false, result);
    }

    @Test
    public void testBorrarUsuarioNoVal() {
        System.out.println("borrarUsuario");
        String username = "Yepeto";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.borrarUsuario(username);
        assertEquals(false, result);
    }

    @Test
    public void testBorrarUsuarioYaBorrado() {
        System.out.println("borrarUssuario ya borrado");
        String username = "richfon";
        ControladorPerfil instance = new ControladorPerfil();
        boolean result = instance.borrarUsuario(username);
        assertEquals(false, result);
    }
}
