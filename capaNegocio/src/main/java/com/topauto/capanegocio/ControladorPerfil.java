package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioPerfil;
import com.topauto.capaentidades.Usuario;
import com.topauto.capanegocio.interfaces.IControladorPerfil;
import java.util.ArrayList;

public class ControladorPerfil implements IControladorPerfil{

    private RepositorioPerfil persistenciaPerfil;
    private ArrayList<Usuario> usuarios;

    public ControladorPerfil() {
    }

    public RepositorioPerfil getPersistenciaPerfil() {
        return persistenciaPerfil;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public void setPersistenciaPerfil(RepositorioPerfil persistenciaPerfil) {
        this.persistenciaPerfil = persistenciaPerfil;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
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
        //Castri
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarCorreo(String correo) {
        //Castri
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarUserName(String username) {
        //Castri
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean acceder(String identificador, String contrasenia) {
        //Yerro
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrarPerfil(Usuario usuario) {
        //Yerro
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarPerfil(Usuario usuario) {
        //Castri
        //Se hace la búsqueda con el userName como criterio...
        try{
            for(Usuario u : usuarios){
                if(u.getUserName() == usuario.getUserName()){
                    int pos = usuarios.indexOf(u);
                    usuarios.set(pos, usuario);
                    return true;
                }
            }
        }
        catch(Exception e){
            System.out.println("No se ha podido modificar el perfil");
            return false;
        }
    }

    @Override
    public boolean modificarContraseña(String nueva) {
        //Yerro
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
