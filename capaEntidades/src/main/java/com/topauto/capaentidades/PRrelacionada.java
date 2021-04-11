package com.topauto.capaentidades;

import java.util.ArrayList;
import java.util.Date;

public class PRrelacionada extends Pregunta{
    private Vehiculo vehiculo;

    public PRrelacionada(Vehiculo vehiculo, String id, String titulo, String descripcion, Date fecha, int numVotos, int numDenuncias, Usuario propietario, ArrayList<Comentario> comentarios) {
        super(id, titulo, descripcion, fecha, numVotos, numDenuncias, propietario, comentarios);
        this.vehiculo = vehiculo;
    }

    public PRrelacionada(Vehiculo vehiculo, String id, String titulo, String descripcion, Date fecha, Usuario propietario) {
        super(id, titulo, descripcion, fecha, propietario);
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public PRrelacionada copiar(){
        return new PRrelacionada(this.vehiculo, this.id, this.titulo, this.descripcion, this.fecha, 
                this.numVotos, this.numDenuncias, this.propietario, this.comentarios);
    }

}
