package com.topauto.capanegocio;

import com.topauto.capaaccesodatos.RepositorioVehiculo;
import com.topauto.capaentidades.Fabricante;
import com.topauto.capaentidades.Pais;
import com.topauto.capaentidades.Vehiculo;
import java.util.ArrayList;

public class ControladorVehiculo {

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

    public boolean descargarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean crearVehiculo(Vehiculo vehiculo) {
        //Castri
        try{
            vehiculos.add(vehiculo);
        }
        catch(Exception e){
            System.out.println("No se ha podido añadir el vehículo");
        }
    }

    public boolean modificarVehiculo(Vehiculo vehiculo) {
        //Castri
        //Se hace la búsqueda con el ID como criterio...
        try{
            for(Vehiculo v : vehiculos){
                if(v.getId() == vehiculo.getId()){
                    int pos = vehiculos.indexOf(v);
                    vehiculos.set(pos, vehiculo);
                    return true;
                }
            }
        }
        catch(Exception e){
            System.out.println("No se ha podido modificar el vehículo");
            return false;
        }
    }

    public boolean borrarVehiculo(String idVehiculo) {
        //Castri
        try{
            for(Vehiculo v : vehiculos){
                if(v.getId() == idVehiculo){
                    vehiculos.remove(vehiculos.indexOf(v));
                    return true;
                }
            }
        }
        catch(Exception e){
            System.out.println("No se ha podido borrar el vehículo");
            return false;
        }
    }

    public boolean buscarVehiculo(String busqueda) {
        //Castri
        for(Vehiculo v : vehiculos){
            //TODO: Averiguar cuál es el parámetro (criterio) de búsqueda
            //Por ahora es ID...
            if(v.getId() == busqueda){
                //Para qué se retorna el booleano?
                return true;
            }
        }
    }   
}
