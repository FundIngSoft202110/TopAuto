package com.topauto.capanegocio.interfaces;

import com.topauto.capaentidades.Publicacion;

public interface IControladorPublicacion {
    public boolean descargarPublicaciones();
    public boolean crearPublicacion(Publicacion publicacion);
    public boolean modificarPublicacion(Publicacion publicacion);
    public boolean borrarPublicacion(String idPublicacion);
    public boolean denunciarPublicacion(String idPublicacion);
    public boolean puntuarPublicacion(String idPublicacion, boolean puntoEnContra);
}
