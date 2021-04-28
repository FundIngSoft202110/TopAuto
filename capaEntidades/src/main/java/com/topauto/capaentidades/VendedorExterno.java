package com.topauto.capaentidades;

import com.topauto.capaentidades.enumerados.Region;

public class VendedorExterno {
    private String nombre;
    private Region region;
    private Imagen logo;
    private String link;

    public VendedorExterno() {
    }
    
    public VendedorExterno(String nombre, Region region, Imagen logo, String link) {
        this.nombre = nombre;
        this.region = region;
        this.logo = logo;
        this.link = link;
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

    public String getLink() {
        return link;
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

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "VendedorExterno{" + "nombre=" + nombre + ", region=" + region + ", logo=" + logo + ", link=" + link + '}';
    }
    
    public VendedorExterno copiar(){
        return new VendedorExterno(this.nombre, this.region, this.logo, this.link);
    }
}
