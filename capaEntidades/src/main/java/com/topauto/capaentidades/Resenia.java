package com.topauto.capaentidades;

import java.util.ArrayList;
import java.util.Date;

public class Resenia extends Publicacion {
    private int puntuacion;
    private Vehiculo vehiculo;

    public Resenia() {
    }
    
    public Resenia(int puntuacion, Vehiculo vehiculo, String id, String titulo, String descripcion, Date fecha, int numVotos, int numDenuncias, Usuario propietario, ArrayList<Comentario> comentarios) {
        super(id, titulo, descripcion, fecha, numVotos, numDenuncias, propietario, comentarios);
        this.puntuacion = puntuacion;
        this.vehiculo = vehiculo;
    }
    
    public Resenia(int puntuacion, Vehiculo vehiculo, String id, String titulo, String descripcion, Date fecha, Usuario propietario) {
        super(id, titulo, descripcion, fecha, propietario);
        this.puntuacion = puntuacion;
        this.vehiculo = vehiculo;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public Resenia copiar(){
        return new Resenia(this.puntuacion, this.vehiculo, this.id, this.titulo, this.descripcion, this.fecha, this.numVotos,
                this.numDenuncias, this.propietario, this.comentarios);
    }
}
