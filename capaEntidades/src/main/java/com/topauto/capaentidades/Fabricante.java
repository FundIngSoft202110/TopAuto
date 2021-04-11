package com.topauto.capaentidades;

import com.topauto.capaentidades.enumerados.Region;
import java.util.ArrayList;

public class Fabricante {
    private String nombre;
    private Region region;
    private ArrayList<String> modelos;

    public Fabricante(String nombre, Region region, ArrayList<String> modelos) {
        this.nombre = nombre;
        this.region = region;
        this.modelos = modelos;
    }

    public String getNombre() {
        return nombre;
    }

    public Region getRegion() {
        return region;
    }

    public ArrayList<String> getModelos() {
        return modelos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setModelos(ArrayList<String> modelos) {
        this.modelos = modelos;
    }
    
    public Fabricante copiar(){
        return new Fabricante(this.nombre, this.region, this.modelos);
    }
}
