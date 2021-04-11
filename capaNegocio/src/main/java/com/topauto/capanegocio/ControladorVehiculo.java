package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioVehiculo;
import com.topauto.capaentidades.Vehiculo;
import com.topauto.capanegocio.interfaces.IControladorVehiculo;

public class ControladorVehiculo implements IControladorVehiculo{

    private RepositorioVehiculo persistenciaVehiculo;

    public ControladorVehiculo() {
    }

    public RepositorioVehiculo getPersistenciaVehiculo() {
        return persistenciaVehiculo;
    }

    public void setPersistenciaVehiculo(RepositorioVehiculo persistenciaVehiculo) {
        this.persistenciaVehiculo = persistenciaVehiculo;
    }
    
    @Override
    public boolean crearVehiculo(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarVehiculo(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrarVehiculo(String idVehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
