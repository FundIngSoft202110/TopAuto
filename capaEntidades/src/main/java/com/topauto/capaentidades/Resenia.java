package com.topauto.capaentidades;

import java.util.ArrayList;
import java.util.Date;

public class Resenia extends Publicacion {
    private int puntuacion;

    public Resenia(int puntuacion, String id, String titulo, String descripcion, Date fecha, int numVotos, int numDenuncias, Usuario propietario, ArrayList<Comentario> comentarios) {
        super(id, titulo, descripcion, fecha, numVotos, numDenuncias, propietario, comentarios);
        this.puntuacion = puntuacion;
    }
    
    public Resenia(int puntuacion, String id, String titulo, String descripcion, Date fecha, Usuario propietario) {
        super(id, titulo, descripcion, fecha, propietario);
        this.puntuacion = puntuacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    public Resenia copiar(){
        return new Resenia(this.puntuacion, this.id, this.titulo, this.descripcion, this.fecha, this.numVotos,
                this.numDenuncias, this.propietario, this.comentarios);
    }
}
