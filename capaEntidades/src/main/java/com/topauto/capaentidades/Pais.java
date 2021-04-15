package com.topauto.capaentidades;

import java.util.ArrayList;

public class Pais {
    private String nombre;
    private Imagen bandera;
    private ArrayList<Fabricante> fabricantes;

    public Pais(String nombre, Imagen bandera, ArrayList<Fabricante> fabricantes) {
        this.nombre = nombre;
        this.bandera = bandera;
        this.fabricantes = fabricantes;
    }

    public String getNombre() {
        return nombre;
    }

    public Imagen getBandera() {
        return bandera;
    }

    public ArrayList<Fabricante> getFabricantes() {
        return fabricantes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBandera(Imagen bandera) {
        this.bandera = bandera;
    }

    public void setFabricantes(ArrayList<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }
    
    public Pais copiar(){
        return new Pais(this.nombre, this.bandera, this.fabricantes);
    }
    
}
