package com.topauto.capaentidades;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String userName;
    private String correo;
    private String descripcion;
    private String contrasenia;
    private boolean estaVerficado;
    private ArrayList<Publicacion> publicaciones;
    private Imagen foto;
    private Pais pais;

    public Usuario(String nombre, String userName, String correo, String descripcion, String contrasenia, boolean estaVerficado, ArrayList<Publicacion> publicaciones, Imagen foto, Pais pais) {
        this.nombre = nombre;
        this.userName = userName;
        this.correo = correo;
        this.descripcion = descripcion;
        this.contrasenia = contrasenia;
        this.estaVerficado = estaVerficado;
        this.publicaciones = publicaciones;
        this.foto = foto;
        this.pais = pais;
    }

    public Usuario(String nombre, String userName, String correo, String contrasenia, Pais pais) {
        this.nombre = nombre;
        this.userName = userName;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUserName() {
        return userName;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public boolean isEstaVerficado() {
        return estaVerficado;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public Imagen getFoto() {
        return foto;
    }

    public Pais getPais() {
        return pais;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setEstaVerficado(boolean estaVerficado) {
        this.estaVerficado = estaVerficado;
    }

    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public void setFoto(Imagen foto) {
        this.foto = foto;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Usuario copiar(){
        return new Usuario(this.nombre, this.userName, this.correo, this.descripcion, this.contrasenia, this.estaVerficado, 
                this.publicaciones, this.foto, this.pais);
    }
}
