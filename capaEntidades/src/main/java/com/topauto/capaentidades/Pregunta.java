package com.topauto.capaentidades;

import java.util.ArrayList;
import java.util.Date;

public abstract class Pregunta extends Publicacion{

    public Pregunta() {
    }

    public Pregunta(String id, String titulo, String descripcion, Date fecha, int numVotos, int numDenuncias, Usuario propietario, ArrayList<Comentario> comentarios) {
        super(id, titulo, descripcion, fecha, numVotos, numDenuncias, propietario, comentarios);
    }

    public Pregunta(String id, String titulo, String descripcion, Date fecha, Usuario propietario) {
        super(id, titulo, descripcion, fecha, propietario);
    }

}
