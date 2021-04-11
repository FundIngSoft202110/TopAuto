package com.topauto.capaaccesodatos;

import com.topauto.capaaccesodatos.interfaces.IBuscadorVehiculo;
import com.topauto.capaaccesodatos.interfaces.IRepositorioVehiculo;
import com.topauto.capaentidades.Vehiculo;

public class RepositorioVehiculo implements IRepositorioVehiculo, IBuscadorVehiculo{

    public RepositorioVehiculo() {
    }

    @Override
    public boolean persistirNuevoVehiculo(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean persistirVehiculoModificado(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrarVehiculo(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean buscarVehiculo(String idVehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
