package com.topauto.capanegocio.interfaces;

import com.topauto.capaentidades.Usuario;

public interface IControladorPerfil {
    public boolean descargarPerfiles();
    public boolean descargarPaises();
    public boolean esCorreo(String cadena);
    public boolean validarCorreo(String correo);
    public boolean validarUserName(String username);
    public boolean acceder(String identificador, String contrasenia);
    public boolean registrarPerfil(Usuario usuario);
    public boolean modificarPerfil(Usuario usuario);
    public boolean modificarContraseña(String nueva);
    
}
