package com.topauto.capaaccesodatos;

import com.topauto.capaentidades.Comentario;
import com.topauto.capaentidades.Publicacion;

public class RepositorioPublicacion {

    public RepositorioPublicacion() {
    }
    
    public boolean persistirNuevaPublicacion(Publicacion publicacion){
        return true;
    }
    
    public boolean persistirPublicacionModificada(Publicacion publicacion){
        return true;
    }
    
    public boolean borrarPublicacion(String idPublicacion){
        return true;
    }
    
    public boolean persistirNuevoComentario(String idPublicacion, Comentario comentario){
        return true;
    }
}
