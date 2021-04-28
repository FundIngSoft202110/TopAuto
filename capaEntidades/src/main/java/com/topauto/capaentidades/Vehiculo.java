package com.topauto.capaentidades;

import com.topauto.capaentidades.enumerados.*;
import java.util.ArrayList;

public class Vehiculo {
    private String id;
    private String modelo;
    private float velMax;
    private float accMax;
    private float potencia;
    private float capacidadMotor;
    private TipoMotor motor;
    private TipoFrenos frenos;
    private TipoDireccion direccion;
    private TipoTransmision transmision;
    private boolean tieneVidriosElectricos;
    private boolean tieneAireAcondicionado;
    private int maxPasajeros;
    private int numPuertas;
    private ArrayList<Imagen> fotos;
    private Fabricante marca;
    private ArrayList<OrgSeguridad> orgAsociadas;
    private ArrayList<VendedorExterno> vendedoresAsociados;

    public Vehiculo() {
    }
    
    public Vehiculo(String id, float velMax, float accMax, float potencia, float capacidadMotor, TipoMotor motor, TipoFrenos frenos, TipoDireccion direccion, TipoTransmision transmision, boolean tieneVidriosElectricos, boolean tieneAireAcondicionado, int maxPasajeros, int numPuertas, String modelo, ArrayList<Imagen> fotos, Fabricante marca, ArrayList<OrgSeguridad> orgAsociadas, ArrayList<VendedorExterno> vendedoresAsociados) {
        this.id = id;
        this.velMax = velMax;
        this.accMax = accMax;
        this.potencia = potencia;
        this.capacidadMotor = capacidadMotor;
        this.motor = motor;
        this.frenos = frenos;
        this.direccion = direccion;
        this.transmision = transmision;
        this.tieneVidriosElectricos = tieneVidriosElectricos;
        this.tieneAireAcondicionado = tieneAireAcondicionado;
        this.maxPasajeros = maxPasajeros;
        this.numPuertas = numPuertas;
        this.modelo = modelo;
        this.fotos = fotos;
        this.marca = marca;
        this.orgAsociadas = orgAsociadas;
        this.vendedoresAsociados = vendedoresAsociados;
    }

    public String getId() {
        return id;
    }

    public float getVelMax() {
        return velMax;
    }

    public float getAccMax() {
        return accMax;
    }

    public float getPotencia() {
        return potencia;
    }

    public float getCapacidadMotor() {
        return capacidadMotor;
    }

    public TipoMotor getMotor() {
        return motor;
    }

    public TipoFrenos getFrenos() {
        return frenos;
    }

    public TipoDireccion getDireccion() {
        return direccion;
    }

    public TipoTransmision getTransmision() {
        return transmision;
    }

    public boolean isTieneVidriosElectricos() {
        return tieneVidriosElectricos;
    }

    public boolean isTieneAireAcondicionado() {
        return tieneAireAcondicionado;
    }

    public int getMaxPasajeros() {
        return maxPasajeros;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public String getModelo() {
        return modelo;
    }

    public ArrayList<Imagen> getFotos() {
        return fotos;
    }

    public Fabricante getMarca() {
        return marca;
    }

    public ArrayList<OrgSeguridad> getOrgAsociadas() {
        return orgAsociadas;
    }

    public ArrayList<VendedorExterno> getVendedoresAsociados() {
        return vendedoresAsociados;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVelMax(float velMax) {
        this.velMax = velMax;
    }

    public void setAccMax(float accMax) {
        this.accMax = accMax;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public void setCapacidadMotor(float capacidadMotor) {
        this.capacidadMotor = capacidadMotor;
    }

    public void setMotor(TipoMotor motor) {
        this.motor = motor;
    }

    public void setFrenos(TipoFrenos frenos) {
        this.frenos = frenos;
    }

    public void setDireccion(TipoDireccion direccion) {
        this.direccion = direccion;
    }

    public void setTransmision(TipoTransmision transmision) {
        this.transmision = transmision;
    }

    public void setTieneVidriosElectricos(boolean tieneVidriosElectricos) {
        this.tieneVidriosElectricos = tieneVidriosElectricos;
    }

    public void setTieneAireAcondicionado(boolean tieneAireAcondicionado) {
        this.tieneAireAcondicionado = tieneAireAcondicionado;
    }

    public void setMaxPasajeros(int maxPasajeros) {
        this.maxPasajeros = maxPasajeros;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setFotos(ArrayList<Imagen> fotos) {
        this.fotos = fotos;
    }

    public void setMarca(Fabricante marca) {
        this.marca = marca;
    }

    public void setOrgAsociadas(ArrayList<OrgSeguridad> orgAsociadas) {
        this.orgAsociadas = orgAsociadas;
    }

    public void setVendedoresAsociados(ArrayList<VendedorExterno> vendedoresAsociados) {
        this.vendedoresAsociados = vendedoresAsociados;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", modelo=" + modelo + ", velMax=" + velMax + ", accMax=" + accMax + ", potencia=" + potencia + ", capacidadMotor=" + capacidadMotor + ", motor=" + motor + ", frenos=" + frenos + ", direccion=" + direccion + ", transmision=" + transmision + ", tieneVidriosElectricos=" + tieneVidriosElectricos + ", tieneAireAcondicionado=" + tieneAireAcondicionado + ", maxPasajeros=" + maxPasajeros + ", numPuertas=" + numPuertas + ", fotos=" + fotos + ", marca=" + marca + ", orgAsociadas=" + orgAsociadas + ", vendedoresAsociados=" + vendedoresAsociados + '}';
    }
    
    public Vehiculo copiar(){
        return new Vehiculo(this.id, this.velMax, this.accMax, this.potencia, this.capacidadMotor, this.motor, this.frenos, 
                this.direccion, this.transmision, this.tieneVidriosElectricos, this.tieneAireAcondicionado, this.maxPasajeros, 
                this.numPuertas, this.modelo, this.fotos, this.marca, this.orgAsociadas, this.vendedoresAsociados);
    }
}
