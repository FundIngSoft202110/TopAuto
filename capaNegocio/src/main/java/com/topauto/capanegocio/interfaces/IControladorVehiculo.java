package com.topauto.capanegocio.interfaces;

import com.topauto.capaentidades.Vehiculo;

public interface IControladorVehiculo {
    public boolean crearVehiculo(Vehiculo vehiculo);
    public boolean modificarVehiculo(Vehiculo vehiculo);
    public boolean borrarVehiculo(String idVehiculo);
}
