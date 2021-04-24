package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioPerfil;
import com.topauto.capaentidades.Pais;
import com.topauto.capaentidades.Usuario;
import com.topauto.capanegocio.interfaces.IControladorPerfil;
import java.util.ArrayList;

public class ControladorPerfil implements IControladorPerfil{

    private RepositorioPerfil persistenciaPerfil;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Pais> paises;

    public ControladorPerfil() {
    }

    public RepositorioPerfil getPersistenciaPerfil() {
        return persistenciaPerfil;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Pais> getPaises() {
        return paises;
    }
    
    public void setPersistenciaPerfil(RepositorioPerfil persistenciaPerfil) {
        this.persistenciaPerfil = persistenciaPerfil;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setPaises(ArrayList<Pais> paises) {
        this.paises = paises;
    }
    
    @Override
    public boolean descargarPerfiles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean descargarPaises() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
    
    @Override
    public boolean esCorreo(String cadena) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarCorreo(String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarUserName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean acceder(String identificador, String contrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrarPerfil(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarPerfil(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarContraseña(String nueva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
