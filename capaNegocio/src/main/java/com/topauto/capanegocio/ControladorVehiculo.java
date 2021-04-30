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
        this.persistenciaVehiculo = new RepositorioVehiculo();
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
        paises = persistenciaVehiculo.descargarPaises();
        fabricantes = persistenciaVehiculo.descargarFabricantes();
        vehiculos = persistenciaVehiculo.descargarVehiculos();
        
        for (Fabricante fabricante: fabricantes) {
            for (Vehiculo vehiculo: vehiculos) {
                if(fabricante.getNombre().compareTo(vehiculo.getMarca().getNombre()) == 0){
                    vehiculo.setMarca(fabricante);
                    fabricante.getVehiculos().add(vehiculo);
                }
            }
        }
        
        for (Pais pais : paises) {
            for (Fabricante fabricante : fabricantes) {
                if(pais.getNombre().compareTo(fabricante.getPais().getNombre()) == 0){
                    fabricante.setPais(pais);
                    pais.getFabricantes().add(fabricante);
                }
            }
        }

        return !(paises.isEmpty() || fabricantes.isEmpty() || vehiculos.isEmpty());
    }

    public boolean crearVehiculo(Vehiculo vehiculo) {
        //Castri
        try{

            return vehiculos.add(vehiculo);

        }
        catch(Exception e){
            System.out.println("No se ha podido añadir el vehículo");
        }

        return false;
    }

    public boolean modificarVehiculo(Vehiculo vehiculo) {
        //Castri
        //Se hace la búsqueda con el ID como criterio...
        try{
            for(Vehiculo v : vehiculos){
                if(v.getId().equals(vehiculo.getId())){
                    int pos = vehiculos.indexOf(v);
                    vehiculos.set(pos, vehiculo);
                    return true;
                }
            }
        }
        catch(Exception e){
            System.out.println("No se ha podido modificar el vehículo");
        }

        return false;//return
    }

    public boolean borrarVehiculo(String idVehiculo) {
        //Castri
        try{
            for(Vehiculo v : vehiculos){
                if(v.getId().equals(idVehiculo)){
                    vehiculos.remove(vehiculos.indexOf(v));
                    return true;
                }
            }
        }
        catch(Exception e){
            System.out.println("No se ha podido borrar el vehículo");
        }

        return false;
    }

    public boolean buscarVehiculo(String busqueda) {
        //Castri
        try{
            for(Vehiculo v : vehiculos){
                //TODO: Averiguar cuál es el parámetro (criterio) de búsqueda
                //Por ahora es ID...
                if(v.getId().equals(busqueda)){
                    //Para qué se retorna el booleano?
                    return true;
                }
            }
        }

        catch(Exception e){
            System.out.println("No se ha encontrado el vehículo");
        }
        return false;
    }   
}
