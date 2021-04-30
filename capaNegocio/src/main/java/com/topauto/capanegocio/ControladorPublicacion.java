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
        //Yerro
        try{
            if(publicaciones.add(publicacion) == true){
                return true;
            }
        }
        catch(Exception e){
            System.out.println("Ocurrio un error al crear la publicación.");
        }
        return false;
    }

    public boolean modificarPublicacion(Publicacion publicacion) {
        //Yerro
        try{
            for(Publicacion p : publicaciones){
                if(p.getId().equals(publicacion.getId()) ){
                    //int pos = publicaciones.indexOf(p); por si las moscas
                    publicaciones.set(publicaciones.indexOf(p), publicacion);
                    return true;
                }
            }
        }
        catch(Exception e){
            System.out.println("Ocurrio un error al modificar la publicacion");
        }
        return false;
    }

    public boolean borrarPublicacion(String idPublicacion) {
        //Yerro
        try{
            for(Publicacion p : publicaciones){
                if(p.getId().equals(idPublicacion)){
                    publicaciones.remove(publicaciones.indexOf(p));
                    return true;
                }
            }
        }
        catch(Exception e){
            System.out.println("Ocurrio un error al borrar la publicacion");
        }
        return false;
    }

    public boolean denunciarPublicacion(String idPublicacion) {
        //Yerro
        try{
            for(Publicacion p : publicaciones){
                if(p.getId().equals(idPublicacion)){
                    p.setNumDenuncias(p.getNumDenuncias()+1); //al cambiar este valor de P ya se guarda o toca llamar la funcion?
                    if(modificarPublicacion(p) == true){
                        return true;
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Ocurrio un error al borrar la publicacion");
        }
        return false;
    }

    public boolean puntuarPublicacion(String idPublicacion, boolean puntoEnContra) {
        //Castri
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
