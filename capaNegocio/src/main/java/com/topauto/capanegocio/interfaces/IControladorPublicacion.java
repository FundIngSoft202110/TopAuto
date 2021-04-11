package com.topauto.capanegocio.interfaces;

import com.topauto.capaentidades.Comentario;
import com.topauto.capaentidades.Publicacion;

public interface IControladorPublicacion {
    public boolean crearPublicacion(Publicacion publicacion);
    public boolean modificarPublicacion(Publicacion publicacion);
    public boolean borrarPublicacion(String idPublicacion);
    public boolean agregarComentario(String idPublicacion, Comentario cometario);
    public boolean denunciarPublicacion(String idPublicacion);
    public boolean puntuarPublicacion(String idPublicacion, boolean puntoEnContra);
}
