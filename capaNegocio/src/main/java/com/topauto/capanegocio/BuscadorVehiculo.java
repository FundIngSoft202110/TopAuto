package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioVehiculo;
import com.topauto.capanegocio.interfaces.IBuscadorVehiculo;

public class BuscadorVehiculo implements IBuscadorVehiculo{

    private RepositorioVehiculo persistenciaBuscador;

    public BuscadorVehiculo() {
    }

    public RepositorioVehiculo getPersistenciaBuscador() {
        return persistenciaBuscador;
    }

    public void setPersistenciaBuscador(RepositorioVehiculo persistenciaBuscador) {
        this.persistenciaBuscador = persistenciaBuscador;
    }
    
    @Override
    public boolean buscarVehiculo(String busqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
