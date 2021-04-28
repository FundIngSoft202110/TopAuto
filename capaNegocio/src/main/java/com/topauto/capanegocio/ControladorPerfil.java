package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioPerfil;
import com.topauto.capaentidades.Usuario;
import java.util.ArrayList;

public class ControladorPerfil {

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
    
    public boolean descargarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean esCorreo(String cadena) {
        //Castri
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean validarCorreo(String correo) {
        //Castri
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean validarUserName(String username) {
        //Castri
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean acceder(String identificador, String contrasenia) {
        //Yerro
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean registrarPerfil(Usuario usuario) {
        //Yerro
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
        }
        
        return false;
    }

    public boolean modificarContraseña(String nueva) {
        //Yerro
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
