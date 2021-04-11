package com.topauto.capaentidades;

public class Pais {
    private String nombre;
    private Imagen bandera;

    public Pais(String nombre, Imagen bandera) {
        this.nombre = nombre;
        this.bandera = bandera;
    }

    public String getNombre() {
        return nombre;
    }

    public Imagen getBandera() {
        return bandera;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBandera(Imagen bandera) {
        this.bandera = bandera;
    }
    
    public Pais copiar(){
        return new Pais(this.nombre, this.bandera);
    }
}
