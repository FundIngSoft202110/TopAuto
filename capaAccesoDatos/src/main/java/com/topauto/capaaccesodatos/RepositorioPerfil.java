package com.topauto.capaaccesodatos;

import com.topauto.capaentidades.Usuario;
import java.util.ArrayList;

public class RepositorioPerfil {

    public RepositorioPerfil() {
    }
    
    public ArrayList<Usuario> descargarPerfiles(){
        return new ArrayList<>();
    }
    
    public ArrayList<Usuario> descargarPaises(){
        return new ArrayList<>();
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
