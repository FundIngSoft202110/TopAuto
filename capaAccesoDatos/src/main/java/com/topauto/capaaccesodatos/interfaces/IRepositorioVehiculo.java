package com.topauto.capaaccesodatos.interfaces;

import com.topauto.capaentidades.Vehiculo;

public interface IRepositorioVehiculo {
    public boolean persistirNuevoVehiculo(Vehiculo vehiculo);
    public boolean persistirVehiculoModificado(Vehiculo vehiculo);
    public boolean borrarVehiculo(Vehiculo vehiculo);
}
