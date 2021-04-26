package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioPublicacion;
import com.topauto.capaentidades.Publicacion;
import com.topauto.capaentidades.Usuario;
import com.topauto.capanegocio.interfaces.IControladorPublicacion;
import java.util.ArrayList;

public class ContoladorPublicacion implements IControladorPublicacion{

    private RepositorioPublicacion persistenciaPublicacion;
    private ArrayList<Publicacion> publicaciones;
    private ArrayList<Usuario> usuarios;

    public ContoladorPublicacion() {
    }

    public RepositorioPublicacion getPersistenciaPublicacion() {
        return persistenciaPublicacion;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public void setPersistenciaPublicacion(RepositorioPublicacion persistenciaPublicacion) {
        this.persistenciaPublicacion = persistenciaPublicacion;
    }

    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    @Override
    public boolean descargarPublicaciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean crearPublicacion(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarPublicacion(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrarPublicacion(String idPublicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean denunciarPublicacion(String idPublicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean puntuarPublicacion(String idPublicacion, boolean puntoEnContra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
