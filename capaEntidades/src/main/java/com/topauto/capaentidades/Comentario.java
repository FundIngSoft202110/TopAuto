package com.topauto.capaentidades;

import java.util.Date;

public class Comentario {
    private String descripcion;
    private Date fecha;

    public Comentario() {
    }

    public Comentario(String descripcion, Date fecha) {
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Comentario copiar(){
        return new Comentario(this.descripcion, this.fecha);
    }
}
