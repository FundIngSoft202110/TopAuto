package com.topauto.capaentidades;

import java.util.ArrayList;
import java.util.Date;

public class PRgeneral extends Pregunta{
    private ArrayList<String> tags;

    public PRgeneral(ArrayList<String> tags, String id, String titulo, String descripcion, Date fecha, int numVotos, int numDenuncias, Usuario propietario, ArrayList<Comentario> comentarios) {
        super(id, titulo, descripcion, fecha, numVotos, numDenuncias, propietario, comentarios);
        this.tags = tags;
    }

    public PRgeneral(ArrayList<String> tags, String id, String titulo, String descripcion, Date fecha, Usuario propietario) {
        super(id, titulo, descripcion, fecha, propietario);
        this.tags = tags;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public PRgeneral copiar(){
        return new PRgeneral(this.tags, this.id, this.titulo, this.descripcion, this.fecha, this.numVotos,
                this.numDenuncias, this.propietario, this.comentarios);
    }
}
