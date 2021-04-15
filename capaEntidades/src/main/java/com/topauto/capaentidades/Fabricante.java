package com.topauto.capaentidades;

import com.topauto.capaentidades.enumerados.Region;
import java.util.ArrayList;

public class Fabricante {
    private String nombre;
    private Region region;
    private ArrayList<String> vehiculos;

    public Fabricante() {
    }
    
    public Fabricante(String nombre, Region region, ArrayList<String> vehiculos) {
        this.nombre = nombre;
        this.region = region;
        this.vehiculos = vehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public Region getRegion() {
        return region;
    }

    public ArrayList<String> getVehiculos() {
        return vehiculos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setVehiculos(ArrayList<String> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    public Fabricante copiar(){
        return new Fabricante(this.nombre, this.region, this.vehiculos);
    }
}
