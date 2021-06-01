/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioPublicacion;
import com.topauto.capaentidades.PRrelacionada;
import com.topauto.capaentidades.PRgeneral;
import com.topauto.capaentidades.Pais;
import com.topauto.capaentidades.Publicacion;
import com.topauto.capaentidades.Resenia;
import com.topauto.capaentidades.Usuario;
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
    public void testCrearPublicacionResenia() {
        System.out.println("crearResenia");
        Pais pa =new Pais("Colombia");
        Usuario us = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo.com", "richfon123", pa);
        Vehiculo ve=new Vehiculo("100");//Tesla Model S
        Resenia res = new Resenia(8, ve, "RES102", "Sorprendente", "El vehiculo es mejor de lo esperado", fecha, us);
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.crearPublicacion(res);
        assertEquals(true, result);
    }
    @Test
    public void testCrearPreguntaGeneral() {
        System.out.println("crearPregutaGeneral");
        Pais pa =new Pais("Colombia");
        Usuario us = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo.com", "richfon123", pa);
        new ArrayList<String>;
        PRgeneral prgen = new PRgeneral(tags, "PRG102", "Recomendacion de camioneta", "Necesito una camioneta para el trabajo", fecha, us);
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.crearPublicacion(prgen);
        assertEquals(true, result);
    }
    @Test
    public void testCrearPreguntaRelacionada() {
        System.out.println("crearPreguntaRelacionada");
        Pais pa =new Pais("Colombia");
        Usuario us = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo.com", "richfon123", pa);
        Vehiculo ve=new Vehiculo("101");//TOYOTA SUPRA
        PRrelacionada prrel = new PRrelacionada(ve, "PRA101", "Motor tiene sonidos", "el motor esta con unos sonidos rasposos alguna idea?", fecha, us);
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.crearPublicacion(prrel);
        assertEquals(true, result);
    }
           @Test
    public void testCrearPublicacion() {
        System.out.println("crearPublicacion nula");
        Publicacion pub = null;
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.crearPublicacion(pub);
        assertEquals(false, result);
    } 
    @Test
    public void testCrearPublicacionReseniaNoDesc() {
        System.out.println("crearResenia");
        Pais pa =new Pais("Colombia");
        Usuario us = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo.com", "richfon123", pa);
        Vehiculo ve=new Vehiculo("100");//Tesla Model S
        Resenia res = new Resenia(8, ve, "RES103", "Algo", "", fecha, us);
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.crearPublicacion(res);
        assertEquals(false, result);   
    }
       @Test
    public void testCrearPublicacionReseniaPuntoNega() {
        System.out.println("crearResenia");
        Pais pa =new Pais("Colombia");
        Usuario us = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo.com", "richfon123", pa);
        Vehiculo ve=new Vehiculo("100");//Tesla Model S
        Resenia res = new Resenia(-8, ve, "RES102", "Sorprendente", "El vehiculo es mejor de lo esperado", fecha, us);
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.crearPublicacion(res);
        assertEquals(false, result);
    }
       @Test
    public void testCrearPublicacionReseniaNoVehi() {
        System.out.println("crearResenia");
        Pais pa =new Pais("Colombia");
        Usuario us = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo.com", "richfon123", pa);
        Resenia res = new Resenia(8, null, "RES104", "Sorprendente", "El vehiculo es mejor de lo esperado", fecha, us);
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.crearPublicacion(res);
        assertEquals(false, result);
    }
       @Test
    public void testCrearPublicacionReseniaNoTitulo() {
        System.out.println("crearResenia");
        Pais pa =new Pais("Colombia");
        Usuario us = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo.com", "richfon123", pa);
        Vehiculo ve=new Vehiculo("100");//Tesla Model S
        Resenia res = new Resenia(8, ve, "RES105", "", "El vehiculo es mejor de lo esperado", fecha, us);
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.crearPublicacion(res);
        assertEquals(true, result);
    }
    /**
     * Test of modificarPublicacion method, of class ControladorPublicacion.
     */
    @Test
    public void testModificarPublicacionDesc() {
        System.out.println("modificarPublicacion");
        Pais pa =new Pais("Colombia");
        Usuario us = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo.com", "richfon123", pa);
        Vehiculo ve=new Vehiculo("100");//Tesla Model S
        Resenia res = new Resenia(8, ve, "RES102", "Sorprendente", "El vehiculo es mejor de lo esperado,creo", fecha, us);
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.modificarPublicacion(res);
        assertEquals(true, result);
    }
    
    @Test
    public void testModificarPublicacionPunt() {
        System.out.println("modificarPublicacion");
        Pais pa =new Pais("Colombia");
        Usuario us = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo.com", "richfon123", pa);
        Vehiculo ve=new Vehiculo("100");//Tesla Model S
        Resenia res = new Resenia(4, ve, "RES102", "Sorprendente", "El vehiculo es mejor de lo esperado", fecha, us);
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.modificarPublicacion(res);
        assertEquals(true, result);
    }
        @Test
    public void testModificarPublicacionTitu() {
        System.out.println("modificarPublicacion");
        Pais pa =new Pais("Colombia");
        Usuario us = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo.com", "richfon123", pa);
        Vehiculo ve=new Vehiculo("100");//Tesla Model S
        Resenia res = new Resenia(8, ve, "RES102", "Sorprende", "El vehiculo es mejor de lo esperado", fecha, us);
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.modificarPublicacion(res);
        assertEquals(true, result);
    }
        @Test
    public void testModificarPreguntaRel() {
        System.out.println("crearPreguntaRelacionada");
        Pais pa =new Pais("Colombia");
        Usuario us = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo.com", "richfon123", pa);
        Vehiculo ve=new Vehiculo("101");//TOYOTA SUPRA
        PRrelacionada prrel = new PRrelacionada(ve, "PRA101", "Motor tiene sonidos raros", "el motor esta con unos sonidos rasposos alguna idea?", fecha, us);
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.modificarPublicacion(prrel);
        assertEquals(true, result);
    }
    public void testModificarReseniaAuto() {
        System.out.println("modificarPublicacion");
        Pais pa =new Pais("Colombia");
        Usuario us = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo.com", "richfon123", pa);
        Vehiculo ve=new Vehiculo("101");//Tesla Model S->TOYOTA SUPRA
        Resenia res = new Resenia(8, ve, "RES102", "Sorprende", "El vehiculo es mejor de lo esperado", fecha, us);
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.modificarPublicacion(res);
        assertEquals(false, result);
    }
    @Test
    public void testModificarPreguntaGeneral() {
        System.out.println("ModificarPregutaGeneral");
        Pais pa =new Pais("Colombia");
        Usuario us = new Usuario("Richard Fonseca", "richfon", "richfonpan@yahoo.com", "richfon123", pa);
        new ArrayList<String>;//añadir un tag al array
        PRgeneral prgen = new PRgeneral(tags, "PRG102", "Recomendacion de camioneta", "Necesito una camioneta para el trabajo", fecha, us);
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.modificarPublicacion(prgen);
        assertEquals(true, result);
    }    
    /**
     * Test of borrarPublicacion method, of class ControladorPublicacion.
     */
    @Test
    public void testBorrarResenia() {
        System.out.println("borrarReseniaCreada");
        String idPublicacion = "RES100";
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.borrarPublicacion(idPublicacion);
        assertEquals(true, result);
    }
    @Test
    public void testBorrarReseniaNoCreada() {
        System.out.println("borrarReseniaCreada");
        String idPublicacion = "RES999";
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.borrarPublicacion(idPublicacion);
        assertEquals(false, result);
    }
        @Test
    public void testBorrarPublicacionVacio() {
        System.out.println("borrarReseniaCreada");
        String idPublicacion = "";
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.borrarPublicacion(idPublicacion);
        assertEquals(false, result);
    }
        @Test
    public void testBorrarPregunta() {
        System.out.println("borrarPreguntaCreada");
        String idPublicacion = "PRA100";
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.borrarPublicacion(idPublicacion);
        assertEquals(true, result);
    }
    /**
     * Test of denunciarPublicacion method, of class ControladorPublicacion.
     */
    @Test
    public void testDenunciarPublicacionRes() {
        System.out.println("denunciarPublicacion resenia");
        String idPublicacion = "RES100";
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.denunciarPublicacion(idPublicacion);
        assertEquals(true, result);
    }
   @Test
    public void testDenunciarPublicacionResNoExist() {
        System.out.println("denunciarPublicacion resenia no existe");
        String idPublicacion = "RES999";
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.denunciarPublicacion(idPublicacion);
        assertEquals(false, result);
    }
    @Test
    public void testDenunciarPublicacionVacio() {
        System.out.println("denunciarPublicacion resenia vacia");
        String idPublicacion = "";
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.denunciarPublicacion(idPublicacion);
        assertEquals(false, result);
    }
        @Test
    public void testDenunciarPublicacionPregAso() {
        System.out.println("denunciarPublicacion resenia vacia");
        String idPublicacion = "PRA100";
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.denunciarPublicacion(idPublicacion);
        assertEquals(true, result);
    }
    /**
     * Test of puntuarPublicacion method, of class ControladorPublicacion.
     */
    @Test
    public void testPuntuarPublicacion() {
        System.out.println("puntuarPublicacion");
        String idPublicacion = "RES101";
        boolean puntoEnContra = false;//+1
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.puntuarPublicacion(idPublicacion, puntoEnContra);
        assertEquals(true, result);
    }   
        @Test
    public void testPuntuarPublicacionNoExist() {
        System.out.println("puntuarPublicacion");
        String idPublicacion = "PRA999";
        boolean puntoEnContra = false;//+1
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.puntuarPublicacion(idPublicacion, puntoEnContra);
        assertEquals(false, result);
    }
        @Test
    public void testPuntuarPublicacionVacia() {
        System.out.println("puntuarPublicacion");
        String idPublicacion = "";
        boolean puntoEnContra = false;//+1
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.puntuarPublicacion(idPublicacion, puntoEnContra);
        assertEquals(false, result);
    }
        @Test
    public void testPuntuarPublicacionNegativo() {
        System.out.println("puntuarPublicacion");
        String idPublicacion = "RES101";
        boolean puntoEnContra = true;//-1
        ControladorPublicacion instance = new ControladorPublicacion();
        boolean result = instance.puntuarPublicacion(idPublicacion, puntoEnContra);
        assertEquals(true, result);
    } 
    
}
