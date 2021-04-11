package com.topauto.capaaccesodatos;

import com.topauto.capaentidades.Usuario;

public class RepositorioPerfil {

    public RepositorioPerfil() {
    }
    
    public boolean buscarCorreo(String correo){
        return true;
    }
    
    public boolean buscarUserName(String username){
        return true;
    }
    
    public boolean persistirNuevoUsuario(Usuario usuario){
        return true;
    }
    
    public boolean persistirPerfilModificado(Usuario usuario){
        return true;
    }
    
    public boolean persistirNuevaContrasenia(String contrasenia){
        return true;
    }
}
