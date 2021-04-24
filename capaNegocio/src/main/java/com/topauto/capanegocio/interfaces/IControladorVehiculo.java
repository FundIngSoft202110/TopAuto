package com.topauto.capanegocio.interfaces;

import com.topauto.capaentidades.Vehiculo;

public interface IControladorVehiculo {
    public boolean descargarVehiculos();
    public boolean descargarFabricantes();
    public boolean crearVehiculo(Vehiculo vehiculo);
    public boolean modificarVehiculo(Vehiculo vehiculo);
    public boolean borrarVehiculo(String idVehiculo);
    public boolean buscarVehiculo(String busqueda);
}
