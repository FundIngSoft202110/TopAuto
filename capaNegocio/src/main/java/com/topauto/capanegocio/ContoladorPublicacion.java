package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioPublicacion;
import com.topauto.capaentidades.Comentario;
import com.topauto.capaentidades.Publicacion;
import com.topauto.capanegocio.interfaces.IControladorPublicacion;
import java.util.ArrayList;

public class ContoladorPublicacion implements IControladorPublicacion{

    private RepositorioPublicacion persistenciaPublicacion;
    private ArrayList<Publicacion> publicaciones;

    public ContoladorPublicacion() {
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
    
    @Override
    public boolean descargarPublicaciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean crearPublicacion(Publicacion publicacion) {
        //Yerro
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarPublicacion(Publicacion publicacion) {
        //Yerro
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrarPublicacion(String idPublicacion) {
        //Yerro
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregarComentario(String idPublicacion, Comentario cometario) {
        //Yerro
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean denunciarPublicacion(String idPublicacion) {
        //Yerro
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean puntuarPublicacion(String idPublicacion, boolean puntoEnContra) {
        //Castri
        try{
            //No puede haber instancias de Publicación
            //Hay una lista de objetos Publicación
            //Creo que está mal
            //TODO: Resolver duda (Ramo)
        }
        catch(Exception e){
            System.out.println("No se ha podido puntuar la publicación");
        }
    }
    
}
