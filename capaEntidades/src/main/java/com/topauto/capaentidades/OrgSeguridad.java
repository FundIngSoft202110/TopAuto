package com.topauto.capaentidades;

import com.topauto.capaentidades.enumerados.Region;

public class OrgSeguridad {
    private String nombre;
    private Region region;
    private Imagen logo;
    private String link;

    public OrgSeguridad() {
    }

    public OrgSeguridad(String nombre, Region region, Imagen logo, String link) {
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
    
    public OrgSeguridad copiar(){
        return new OrgSeguridad(this.nombre, this.region, this.logo, this.link);
    }
}