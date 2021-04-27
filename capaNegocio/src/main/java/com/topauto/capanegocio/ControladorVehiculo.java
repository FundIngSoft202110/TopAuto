package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioVehiculo;
import com.topauto.capaentidades.Fabricante;
import com.topauto.capaentidades.Pais;
import com.topauto.capaentidades.Vehiculo;
import com.topauto.capanegocio.interfaces.IControladorVehiculo;
import java.util.ArrayList;

public class ControladorVehiculo implements IControladorVehiculo{

    private RepositorioVehiculo persistenciaVehiculo;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Fabricante> fabricantes;
    private ArrayList<Pais> paises;

    public ControladorVehiculo() {
    }

    public RepositorioVehiculo getPersistenciaVehiculo() {
        return persistenciaVehiculo;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public ArrayList<Fabricante> getFabricantes() {
        return fabricantes;
    }

    public ArrayList<Pais> getPaises() {
        return paises;
    }
    
    public void setPersistenciaVehiculo(RepositorioVehiculo persistenciaVehiculo) {
        this.persistenciaVehiculo = persistenciaVehiculo;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setFabricantes(ArrayList<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }

    public void setPaises(ArrayList<Pais> paises) {
        this.paises = paises;
    }
    
    @Override
    public boolean descargarVehiculos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean descargarFabricantes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean crearVehiculo(Vehiculo vehiculo) {
        //Castri
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarVehiculo(Vehiculo vehiculo) {
        //Castri
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrarVehiculo(String idVehiculo) {
        //Castri
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean buscarVehiculo(String busqueda) {
        //Castri
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
