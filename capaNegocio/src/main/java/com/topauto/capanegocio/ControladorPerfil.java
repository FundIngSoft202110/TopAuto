package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioPerfil;
import com.topauto.capaentidades.Fabricante;
import com.topauto.capaentidades.PRrelacionada;
import com.topauto.capaentidades.Pais;
import com.topauto.capaentidades.Publicacion;
import com.topauto.capaentidades.Resenia;
import com.topauto.capaentidades.Usuario;
import com.topauto.capaentidades.Vehiculo;
import java.util.ArrayList;

public class ControladorPerfil {

    private RepositorioPerfil persistenciaPerfil;
    private ArrayList<Usuario> usuarios;

    public ControladorPerfil() {
        this.persistenciaPerfil = new RepositorioPerfil();
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
        ControladorPublicacion controladorPublicacion = new ControladorPublicacion();
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
        
        usuarios = persistenciaPerfil.descargarPerfiles();
        ArrayList<Publicacion> publicaciones = controladorPublicacion.getPersistenciaPublicacion().descargarPublicaciones();
        
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

        return !usuarios.isEmpty();
    }

    public boolean esCorreo(String cadena) {
            try{
                boolean correo =false;
                for(int n = 0; n < cadena.length (); n++){
                char c = cadena.charAt (n); System.out.println (c);
                    if(c == '@'){
                        correo = true;
                    }
                }
                String[] terminador = cadena.split(".");
                if(terminador.equals("com")){
                    correo = true;
                }
                if(terminador.equals("net")){
                    correo = true;
                }
                if(terminador.equals("org")){
                    correo = true;
                }
            }
            catch(Exception e){
                System.out.println("Ocurrio un error al verificar si es un correo.");
            }
            return false;
    }

    public boolean validarCorreo(String correo) {
        //Castri (yerro)
        try{
            for(Usuario u : usuarios){
                if(u.getCorreo().equals(correo)){
                    return true;
                }
            }
            return false;
                     
        }
        catch(Exception e){
            System.out.println("Ocurrio un error al verificar el correo.");
        }
        return false; 
    }

    public boolean validarUserName(String username) {
        //Castri (yerro)
        try{
            for(Usuario u : usuarios){
                if(u.getUserName().equals(username)){
                    return true;
                }
            }
            return false;
                     
        }
        catch(Exception e){
            System.out.println("Ocurrio un error al verificar el correo.");
        }
        return false; 
    }

    public boolean acceder(String identificador, String contrasenia) {
        //Yerro
        try{
            if(esCorreo(identificador) == true){
                for(Usuario u : usuarios){
                    if(u.getCorreo().equals(identificador) && u.getContrasenia().equals(contrasenia)){
                        
                        return true;
                    }
                }                
            }
            if(esCorreo(identificador) == false){
                for(Usuario u : usuarios){
                    if(u.getUserName().equals(identificador) && u.getContrasenia().equals(contrasenia)){
                        
                        return true;
                    }
                } 
            }
        }
        catch(Exception e){
            System.out.println("Ocurrio un error acceder.");
        }
        return false;
        
    }

    public boolean registrarPerfil(Usuario usuario) {
        boolean retorno = false;
        //Yerro
        try{
            persistenciaPerfil.persistirNuevoUsuario(usuario);
            retorno= true;           
        }
        catch(Exception e){
            System.out.println("Ocurrio un error al registrar el perfil");
        }
        return retorno;
    }

    public boolean borrarUsuario(String username) {
        //Castri
        try{
            for(Usuario u : usuarios){
                if(u.getUserName().equals(username)){
                    usuarios.remove(usuarios.indexOf(u));
                    persistenciaPerfil.borrarUsuario(username);
                    return true;
                }
            }
        }
        catch(Exception e){
            System.out.println("No se ha podido borrar el usuario");
        }

        return false;
    }
    
    public boolean modificarPerfil(Usuario usuario) {
        //Castri
        //Se hace la búsqueda con el userName como criterio...
        try{
            for(Usuario u : usuarios){
                if(u.getUserName().equals(usuario.getUserName())){
                    int pos = usuarios.indexOf(u);
                    usuarios.set(pos, usuario);
                    persistenciaPerfil.persistirPerfilModificado(usuario);
                    return true;
                }
            }
        }
        catch(Exception e){
            System.out.println("No se ha podido modificar el perfil");
        }

        return false;
    }

    public boolean modificarContraseña(String identificador, String nueva) {
        //Yerro
        try{
            for(Usuario u : usuarios){
                if(u.getUserName().equals(identificador)){
                    u.setContrasenia(nueva);
                    persistenciaPerfil.persistirPerfilModificado(u);
                    return true;
                }
            }
        }
        catch(Exception e){
            System.out.println("Ocurrio un error al modificar la contraseña.");
        }
        return false;
    }
    
}
