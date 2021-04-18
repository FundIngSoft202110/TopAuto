package com.topauto.capaentidades;

import com.topauto.capaentidades.enumerados.Region;
import java.util.ArrayList;

public class Fabricante {
    private String nombre;
    private Region region;
    private Imagen logo;
    private Pais pais;
    private ArrayList<String> vehiculos;

    public Fabricante() {
    }
    
    public Fabricante(String nombre, Region region, Imagen logo, Pais pais, ArrayList<String> vehiculos) {
        this.nombre = nombre;
        this.region = region;
        this.logo = logo;
        this.pais = pais;
        this.vehiculos = vehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public Region getRegion() {
        return region;
    }

    public Imagen getLogo() {
        return logo;
    }

    public Pais getPais() {
        return pais;
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

    public void setLogo(Imagen logo) {
        this.logo = logo;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    public void setVehiculos(ArrayList<String> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    public Fabricante copiar(){
        return new Fabricante(this.nombre, this.region, this.logo, this.pais, this.vehiculos);
    }
}
