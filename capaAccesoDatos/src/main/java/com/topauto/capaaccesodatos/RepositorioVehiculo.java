package com.topauto.capaaccesodatos;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.topauto.capaentidades.Fabricante;
import com.topauto.capaentidades.Imagen;
import com.topauto.capaentidades.OrgSeguridad;
import com.topauto.capaentidades.Pais;
import com.topauto.capaentidades.Vehiculo;
import com.topauto.capaentidades.VendedorExterno;
import com.topauto.capaentidades.enumerados.*;
import java.util.ArrayList;
import org.bson.Document;

public class RepositorioVehiculo{
    
    public RepositorioVehiculo() {
    }
    
    public ArrayList<Vehiculo> descargarVehiculos(){
        try(MongoClient mongoClient = MongoClients.create(ConstantesConexion.CONNECTION_STRING)){
            MongoCollection<Document> coleccionVehiculo = mongoClient.getDatabase("entities").getCollection("vehiculo");
            ArrayList<Document> docsVehiculos = coleccionVehiculo.find().into(new ArrayList<>());
            ArrayList<Vehiculo> vehiculos = new ArrayList<>();
            for (Document docVehiculo : docsVehiculos) {
                Vehiculo vehiculo = new Vehiculo(); 
                vehiculo.setId(docVehiculo.getString("id"));
                vehiculo.setModelo(docVehiculo.getString("modelo"));
                vehiculo.setMarca(new Fabricante());
                vehiculo.getMarca().setNombre(docVehiculo.getString("marca"));
                vehiculo.setVelMax(docVehiculo.getDouble("velMax").floatValue());
                vehiculo.setAccMax(docVehiculo.getDouble("accMax").floatValue());
                vehiculo.setPotencia(docVehiculo.getDouble("potencia").floatValue());
                vehiculo.setCapacidadMotor(docVehiculo.getDouble("capacidadMotor").floatValue());
                vehiculo.setMotor(TipoMotor.valueOf(docVehiculo.getString("motor")));
                vehiculo.setFrenos(TipoFrenos.valueOf(docVehiculo.getString("frenos")));
                vehiculo.setDireccion(TipoDireccion.valueOf(docVehiculo.getString("direccion")));
                vehiculo.setTransmision(TipoTransmision.valueOf(docVehiculo.getString("transmision")));
                vehiculo.setTieneVidriosElectricos(docVehiculo.getBoolean("tieneVidriosElectricos"));
                vehiculo.setTieneAireAcondicionado(docVehiculo.getBoolean("tieneAireAcondicionado"));
                vehiculo.setMaxPasajeros(docVehiculo.getDouble("maxPasajeros").intValue());
                vehiculo.setNumPuertas(docVehiculo.getDouble("numPuertas").intValue());
                vehiculo.setFotos(new ArrayList<>());
                ArrayList<String> paths = (ArrayList<String>) docVehiculo.get("fotos");
                for (String path : paths) {
                    vehiculo.getFotos().add(new Imagen(path));
                }
                vehiculo.setOrgAsociadas(new ArrayList<>());
                ArrayList<Document> docsOrgsSeguridad = (ArrayList<Document>) docVehiculo.get("orgAsociadas");
                for (Document docOrgsSeguridad : docsOrgsSeguridad) {
                    OrgSeguridad org = new OrgSeguridad();
                    org.setNombre(docOrgsSeguridad.getString("nombre"));
                    org.setRegion(Region.valueOf(docOrgsSeguridad.getString("region")));
                    org.setLogo(new Imagen(docOrgsSeguridad.getString("logo")));
                    org.setLink(docOrgsSeguridad.getString("link"));
                    
                    vehiculo.getOrgAsociadas().add(org);
                }
                vehiculo.setVendedoresAsociados(new ArrayList<>());
                ArrayList<Document> docsVendedoresExternos = (ArrayList<Document>) docVehiculo.get("vendedoresAsociados");
                for (Document docVendedoresExternos : docsVendedoresExternos) {
                    VendedorExterno vendedor = new VendedorExterno();
                    vendedor.setNombre(docVendedoresExternos.getString("nombre"));
                    vendedor.setRegion(Region.valueOf(docVendedoresExternos.getString("region")));
                    vendedor.setLogo(new Imagen(docVendedoresExternos.getString("logo")));
                    vendedor.setLink(docVendedoresExternos.getString("link"));
                    
                    vehiculo.getVendedoresAsociados().add(vendedor);
                }

                vehiculos.add(vehiculo);
            }
            
            return vehiculos;
        }
    }
    
    public ArrayList<Fabricante> descargarFabricantes(){
        try(MongoClient mongoClient = MongoClients.create(ConstantesConexion.CONNECTION_STRING)){
            MongoCollection<Document> coleccionFabricante = mongoClient.getDatabase("entities").getCollection("fabricante");
            ArrayList<Document> docsFabricantes = coleccionFabricante.find().into(new ArrayList<>());
            ArrayList<Fabricante> fabricantes = new ArrayList<>();
            for (Document docFabricante : docsFabricantes) {
                Fabricante fabricante = new Fabricante();
                fabricante.setNombre(docFabricante.getString("nombre"));
                fabricante.setRegion(Region.valueOf(docFabricante.getString("region")));
                fabricante.setLogo(new Imagen(docFabricante.getString("logo")));
                Pais pais = new Pais();
                pais.setNombre(docFabricante.getString("pais"));
                fabricante.setPais(pais);
                
                fabricantes.add(fabricante);
            }
            
            return fabricantes;
        }
    }
    
    public ArrayList<Pais> descargarPaises(){
        try(MongoClient mongoClient = MongoClients.create(ConstantesConexion.CONNECTION_STRING)){
            MongoCollection<Document> coleccionPais = mongoClient.getDatabase("entities").getCollection("pais");
            ArrayList<Document> docsPaises = coleccionPais.find().into(new ArrayList<>());
            ArrayList<Pais> paises = new ArrayList<>();
            for (Document docPais : docsPaises) {
                Pais pais = new Pais();
                pais.setNombre(docPais.getString("nombre"));
                pais.setBandera(new Imagen(docPais.getString("bandera")));
               
                paises.add(pais);
            }
            
            return paises;
        }
    }
    
    public boolean persistirNuevoVehiculo(Vehiculo vehiculo) {
        try(MongoClient mongoClient = MongoClients.create(ConstantesConexion.CONNECTION_STRING)){
            MongoCollection<Document> coleccionVehiculo = mongoClient.getDatabase("entities").getCollection("vehiculo");
            if(coleccionVehiculo.insertOne(new Document("id", vehiculo.getId())
                    .append("modelo", vehiculo.getModelo())
                    .append("marca", vehiculo.getMarca().getNombre())
                    .append("velMax", vehiculo.getVelMax())
                    .append("accMax", vehiculo.getAccMax())
                    .append("potencia", vehiculo.getPotencia())
                    .append("capacidadMotor", vehiculo.getCapacidadMotor())
                    .append("motor", vehiculo.getMotor().toString())
                    .append("frenos", vehiculo.getFrenos().toString())
                    .append("direccion", vehiculo.getDireccion().toString())
                    .append("transmision", vehiculo.getTransmision().toString())
                    .append("tieneVidriosElectricos", vehiculo.isTieneVidriosElectricos())
                    .append("tieneAireAcondicionado", vehiculo.isTieneAireAcondicionado())
                    .append("maxPasajeros", vehiculo.getMaxPasajeros())
                    .append("numPuertas", vehiculo.getNumPuertas())
                    .append("fotos", vehiculo.getFotos())
                    .append("orgAsociadas", vehiculo.getOrgAsociadas())
                    .append("vendedoresAsociados", vehiculo.getVendedoresAsociados())) != null)
            {
                return true;
            }
        }
        
        return false;
    }

    public boolean persistirVehiculoModificado(Vehiculo vehiculo) {
        try(MongoClient mongoClient = MongoClients.create(ConstantesConexion.CONNECTION_STRING)){
            MongoCollection<Document> coleccionVehiculo = mongoClient.getDatabase("entities").getCollection("vehiculo");
            if(coleccionVehiculo.replaceOne(eq("id", vehiculo.getId()), new Document("id", vehiculo.getId())
                    .append("modelo", vehiculo.getModelo())
                    .append("marca", vehiculo.getMarca().getNombre())
                    .append("velMax", vehiculo.getVelMax())
                    .append("accMax", vehiculo.getAccMax())
                    .append("potencia", vehiculo.getPotencia())
                    .append("capacidadMotor", vehiculo.getCapacidadMotor())
                    .append("motor", vehiculo.getMotor().toString())
                    .append("frenos", vehiculo.getFrenos().toString())
                    .append("direccion", vehiculo.getDireccion().toString())
                    .append("transmision", vehiculo.getTransmision().toString())
                    .append("tieneVidriosElectricos", vehiculo.isTieneVidriosElectricos())
                    .append("tieneAireAcondicionado", vehiculo.isTieneAireAcondicionado())
                    .append("maxPasajeros", vehiculo.getMaxPasajeros())
                    .append("numPuertas", vehiculo.getNumPuertas())
                    .append("fotos", vehiculo.getFotos())
                    .append("orgAsociadas", vehiculo.getOrgAsociadas())
                    .append("vendedoresAsociados", vehiculo.getVendedoresAsociados())) != null)
            {
                return true;
            }
        }
        
        return false;
    }

    public boolean borrarVehiculo(String idVehiculo) {
        try(MongoClient mongoClient = MongoClients.create(ConstantesConexion.CONNECTION_STRING)){
            MongoCollection<Document> coleccionVehiculo = mongoClient.getDatabase("entities").getCollection("vehiculo");
            if(coleccionVehiculo.deleteOne(eq("id", idVehiculo)) != null)
            {
                return true;
            }
        }
        
        return false;
    }
 
}
