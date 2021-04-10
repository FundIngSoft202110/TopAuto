package com.topauto.capaentidades;

import java.util.ArrayList;
import java.util.Date;

public abstract class Publicacion {
    private String id;
    private String titulo;
    private String descripcion;
    private Date fecha;
    private int numVotos;
    private int numDenuncias;
    private Usuario propietario;
    private ArrayList<Comentario> comentarios;

    public Publicacion(String id, String titulo, String descripcion, Date fecha, int numVotos, int numDenuncias, Usuario propietario, ArrayList<Comentario> comentarios) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.numVotos = numVotos;
        this.numDenuncias = numDenuncias;
        this.propietario = propietario;
        this.comentarios = comentarios;
    }

    public Publicacion(String id, String titulo, String descripcion, Date fecha, Usuario propietario) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.numVotos = 0;
        this.numDenuncias = 0;
        this.propietario = propietario;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getNumVotos() {
        return numVotos;
    }

    public int getNumDenuncias() {
        return numDenuncias;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }

    public void setNumDenuncias(int numDenuncias) {
        this.numDenuncias = numDenuncias;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
