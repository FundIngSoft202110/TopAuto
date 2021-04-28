package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioPublicacion;
import com.topauto.capaentidades.Fabricante;
import com.topauto.capaentidades.PRgeneral;
import com.topauto.capaentidades.PRrelacionada;
import com.topauto.capaentidades.Pais;
import com.topauto.capaentidades.Publicacion;
import com.topauto.capaentidades.Resenia;
import com.topauto.capaentidades.Usuario;
import com.topauto.capaentidades.Vehiculo;
import java.util.ArrayList;

public class ControladorPublicacion {

    private RepositorioPublicacion persistenciaPublicacion;
    private ArrayList<Publicacion> publicaciones;

    public ControladorPublicacion() {
        this.persistenciaPublicacion = new RepositorioPublicacion();
    }

    public RepositorioPublicacion getPersistenciaPublicacion() {
        return persistenciaPublicacion;
    }
    
    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }
    
    public void setPersistenciaPublicacion(RepositorioPublicacion persistenciaPublicacion) {
        this.persistenciaPublicacion = persistenciaPublicacion;
    }
    
    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
    
    public boolean descargarDatos() {
        ControladorPerfil controladorPerfil = new ControladorPerfil();
        ControladorVehiculo controladorVehiculo = new ControladorVehiculo();
        
        ArrayList<Pais> paises = controladorVehiculo.getPersistenciaVehiculo().descargarPaises();
        ArrayList<Fabricante> fabricantes = controladorVehiculo.getPersistenciaVehiculo().descargarFabricantes();
        ArrayList<Vehiculo> vehiculos = controladorVehiculo.getPersistenciaVehiculo().descargarVehiculos();
        
        for (Fabricante fabricante: fabricantes) {
            for (Vehiculo vehiculo: vehiculos) {
                if(fabricante.getNombre().compareTo(vehiculo.getMarca().getNombre()) == 0){
                    vehiculo.setMarca(fabricante);
                    fabricante.getVehiculos().add(vehiculo);
                }
            }
        }
        
        for (Pais pais : paises) {
            for (Fabricante fabricante : fabricantes) {
                if(pais.getNombre().compareTo(fabricante.getPais().getNombre()) == 0){
                    fabricante.setPais(pais);
                    pais.getFabricantes().add(fabricante);
                }
            }
        }
        
        ArrayList<Usuario> usuarios = controladorPerfil.getPersistenciaPerfil().descargarPerfiles();
        publicaciones = persistenciaPublicacion.descargarPublicaciones();
        
        for (Usuario usuario : usuarios) {
            for(Pais pais: paises){
                if(usuario.getPais().getNombre().compareTo(pais.getNombre()) == 0){
                    usuario.setPais(pais);
                }
            }
            for (Publicacion publicacion: publicaciones) {
                if(usuario.getUserName().compareTo(publicacion.getPropietario().getUserName()) == 0){
                    publicacion.setPropietario(usuario);
                    if(publicacion instanceof Resenia){
                        for(Vehiculo vehiculo: vehiculos){
                            if(((Resenia)publicacion).getVehiculo().getId().compareTo(vehiculo.getId()) == 0){
                                ((Resenia) publicacion).setVehiculo(vehiculo);
                            }
                        }
                    }
                    else if(publicacion instanceof PRrelacionada){
                        for(Vehiculo vehiculo: vehiculos){
                            if(((PRrelacionada)publicacion).getVehiculo().getId().compareTo(vehiculo.getId()) == 0){
                                ((PRrelacionada) publicacion).setVehiculo(vehiculo);
                            }
                        }
                    }
                    usuario.getPublicaciones().add(publicacion);
                }
            }
        }

        return !publicaciones.isEmpty();
    }
    
    public boolean crearPublicacion(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean modificarPublicacion(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean borrarPublicacion(String idPublicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean denunciarPublicacion(String idPublicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean puntuarPublicacion(String idPublicacion, boolean puntoEnContra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
