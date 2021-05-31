package com.topauto.capaaccesodatos;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.topauto.capaentidades.Comentario;
import com.topauto.capaentidades.PRgeneral;
import com.topauto.capaentidades.PRrelacionada;
import com.topauto.capaentidades.Publicacion;
import com.topauto.capaentidades.Resenia;
import com.topauto.capaentidades.Usuario;
import com.topauto.capaentidades.Vehiculo;
import java.util.ArrayList;
import org.bson.Document;

public class RepositorioPublicacion {

    public RepositorioPublicacion() {
    }
    
    public ArrayList<Publicacion> descargarPublicaciones(){
        try(MongoClient mongoClient = MongoClients.create(ConstantesConexion.CONNECTION_STRING)){
            MongoCollection<Document> coleccionPublicacion = mongoClient.getDatabase("entities").getCollection("publicacion");
            ArrayList<Document> docsPublicaciones = coleccionPublicacion.find().into(new ArrayList<>());
            ArrayList<Publicacion> publicaciones = new ArrayList<>();
            for (Document docPublicacion : docsPublicaciones) {
                if(docPublicacion.getString("id").startsWith("RES")){
                    Resenia resenia = new Resenia();
                    resenia.setId(docPublicacion.getString("id"));
                    resenia.setTitulo(docPublicacion.getString("titulo"));
                    resenia.setDescripcion(docPublicacion.getString("descripcion"));
                    resenia.setFecha(docPublicacion.getDate("fecha"));
                    resenia.setNumVotos(docPublicacion.getDouble("numVotos").intValue());
                    resenia.setNumDenuncias(docPublicacion.getDouble("numDenuncias").intValue());
                    resenia.setComentarios(new ArrayList<>());
                    ArrayList<Document> docsComentarios = (ArrayList<Document>) docPublicacion.get("comentarios");
                    for (Document docComentario : docsComentarios) {
                        Comentario comentario = new Comentario();
                        comentario.setDescripcion(docComentario.getString("descripcion"));
                        comentario.setFecha(docComentario.getDate("fecha"));

                        resenia.getComentarios().add(comentario);
                    }
                    Usuario propietario = new Usuario();
                    propietario.setUserName(docPublicacion.getString("propietario"));
                    resenia.setPropietario(propietario);
                    Vehiculo vehiculo = new Vehiculo();
                    vehiculo.setId(docPublicacion.getString("idVehiculo"));
                    resenia.setVehiculo(vehiculo);
                    resenia.setPuntuacion(docPublicacion.getDouble("puntuacion").intValue());
                    
                    publicaciones.add(resenia);
                }
                else if(docPublicacion.getString("id").startsWith("PRA")){
                    PRrelacionada relacionada = new PRrelacionada();
                    relacionada.setId(docPublicacion.getString("id"));
                    relacionada.setTitulo(docPublicacion.getString("titulo"));
                    relacionada.setDescripcion(docPublicacion.getString("descripcion"));
                    relacionada.setFecha(docPublicacion.getDate("fecha"));
                    relacionada.setNumVotos(docPublicacion.getDouble("numVotos").intValue());
                    relacionada.setNumDenuncias(docPublicacion.getDouble("numDenuncias").intValue());
                    relacionada.setComentarios(new ArrayList<>());
                    ArrayList<Document> docsComentarios = (ArrayList<Document>) docPublicacion.get("comentarios");
                    for (Document docComentario : docsComentarios) {
                        Comentario comentario = new Comentario();
                        comentario.setDescripcion(docComentario.getString("descripcion"));
                        comentario.setFecha(docComentario.getDate("fecha"));

                        relacionada.getComentarios().add(comentario);
                    }
                    Usuario propietario = new Usuario();
                    propietario.setUserName(docPublicacion.getString("propietario"));
                    relacionada.setPropietario(propietario);
                    Vehiculo vehiculo = new Vehiculo();
                    vehiculo.setId(docPublicacion.getString("idVehiculo"));
                    relacionada.setVehiculo(vehiculo);
                    
                    publicaciones.add(relacionada);
                }
                else if(docPublicacion.getString("id").startsWith("PRG")){
                    PRgeneral general = new PRgeneral();
                    general.setId(docPublicacion.getString("id"));
                    general.setTitulo(docPublicacion.getString("titulo"));
                    general.setDescripcion(docPublicacion.getString("descripcion"));
                    general.setFecha(docPublicacion.getDate("fecha"));
                    general.setNumVotos(docPublicacion.getDouble("numVotos").intValue());
                    general.setNumDenuncias(docPublicacion.getDouble("numDenuncias").intValue());
                    general.setComentarios(new ArrayList<>());
                    ArrayList<Document> docsComentarios = (ArrayList<Document>) docPublicacion.get("comentarios");
                    for (Document docComentario : docsComentarios) {
                        Comentario comentario = new Comentario();
                        comentario.setDescripcion(docComentario.getString("descripcion"));
                        comentario.setFecha(docComentario.getDate("fecha"));

                        general.getComentarios().add(comentario);
                    }
                    Usuario propietario = new Usuario();
                    propietario.setUserName(docPublicacion.getString("propietario"));
                    general.setPropietario(propietario);
                    general.setTags(new ArrayList<>());
                    ArrayList<String> tags = (ArrayList<String>) docPublicacion.get("tags");
                    for (String tag : tags) {
                        general.getTags().add(tag);
                    }
                    
                    publicaciones.add(general);
                } 
            }
            
            return publicaciones;
        }
    }
    
    public boolean persistirNuevaPublicacion(Publicacion publicacion){
        try(MongoClient mongoClient = MongoClients.create(ConstantesConexion.CONNECTION_STRING)){
            MongoCollection<Document> coleccionPublicacion = mongoClient.getDatabase("entities").getCollection("publicacion");
            if(publicacion.getId().startsWith("RES"))
            {
                if(coleccionPublicacion.insertOne(new Document("id", publicacion.getId())
                        .append("titulo", publicacion.getTitulo())
                        .append("descripcion", publicacion.getDescripcion())
                        .append("fecha", publicacion.getFecha())
                        .append("numVotos", (double) publicacion.getNumVotos())
                        .append("numDenuncias", (double) publicacion.getNumDenuncias())
                        .append("comentarios", publicacion.getComentarios())
                        .append("propietario", publicacion.getPropietario().getUserName())
                        .append("idVehiculo", ((Resenia)publicacion).getVehiculo().getId())
                        .append("puntuacion", (double) ((Resenia)publicacion).getPuntuacion())) != null)
                {
                    return true;
                }
            }
            else if(publicacion.getId().startsWith("PRA"))
            {
                if(coleccionPublicacion.insertOne(new Document("id", publicacion.getId())
                        .append("titulo", publicacion.getTitulo())
                        .append("descripcion", publicacion.getDescripcion())
                        .append("fecha", publicacion.getFecha())
                        .append("numVotos", (double) publicacion.getNumVotos())
                        .append("numDenuncias", (double) publicacion.getNumDenuncias())
                        .append("comentarios", publicacion.getComentarios())
                        .append("propietario", publicacion.getPropietario().getUserName())
                        .append("idVehiculo", ((PRrelacionada)publicacion).getVehiculo().getId())) != null)
                {
                    return true;
                }                
            }
            else if(publicacion.getId().startsWith("PRG"))
            {
                if(coleccionPublicacion.insertOne(new Document("id", publicacion.getId())
                        .append("titulo", publicacion.getTitulo())
                        .append("descripcion", publicacion.getDescripcion())
                        .append("fecha", publicacion.getFecha())
                        .append("numVotos", (double) publicacion.getNumVotos())
                        .append("numDenuncias", (double) publicacion.getNumDenuncias())
                        .append("comentarios", publicacion.getComentarios())
                        .append("propietario", publicacion.getPropietario().getUserName())
                        .append("tags", ((PRgeneral)publicacion).getTags())) != null)
                {
                    return true;
                }                
            }
        }
        
        return false;
    }
    
    public boolean persistirPublicacionModificada(Publicacion publicacion){
        try(MongoClient mongoClient = MongoClients.create(ConstantesConexion.CONNECTION_STRING)){
            MongoCollection<Document> coleccionPublicacion = mongoClient.getDatabase("entities").getCollection("publicacion");
            if(publicacion.getId().startsWith("RES"))
            {
                if(coleccionPublicacion.replaceOne(eq("id", publicacion.getId()), new Document("id", publicacion.getId())
                        .append("titulo", publicacion.getTitulo())
                        .append("descripcion", publicacion.getDescripcion())
                        .append("fecha", publicacion.getFecha())
                        .append("numVotos", (double) publicacion.getNumVotos())
                        .append("numDenuncias", (double) publicacion.getNumDenuncias())
                        .append("comentarios", publicacion.getComentarios())
                        .append("propietario", publicacion.getPropietario().getUserName())
                        .append("idVehiculo", ((Resenia)publicacion).getVehiculo().getId())
                        .append("puntuacion", ((Resenia)publicacion).getPuntuacion())) != null)
                {
                    return true;
                }
            }
            else if(publicacion.getId().startsWith("PRA"))
            {
                if(coleccionPublicacion.replaceOne(eq("id", publicacion.getId()), new Document("id", publicacion.getId())
                        .append("titulo", publicacion.getTitulo())
                        .append("descripcion", publicacion.getDescripcion())
                        .append("fecha", publicacion.getFecha())
                        .append("numVotos", publicacion.getNumVotos())
                        .append("numDenuncias", publicacion.getNumDenuncias())
                        .append("comentarios", publicacion.getComentarios())
                        .append("propietario", publicacion.getPropietario().getUserName())
                        .append("idVehiculo", ((PRrelacionada)publicacion).getVehiculo().getId())) != null)
                {
                    return true;
                }                
            }
            else if(publicacion.getId().startsWith("PRG"))
            {
                if(coleccionPublicacion.replaceOne(eq("id", publicacion.getId()), new Document("id", publicacion.getId())
                        .append("titulo", publicacion.getTitulo())
                        .append("descripcion", publicacion.getDescripcion())
                        .append("fecha", publicacion.getFecha())
                        .append("numVotos", publicacion.getNumVotos())
                        .append("numDenuncias", publicacion.getNumDenuncias())
                        .append("comentarios", publicacion.getComentarios())
                        .append("propietario", publicacion.getPropietario().getUserName())
                        .append("tags", ((PRgeneral)publicacion).getTags())) != null)
                {
                    return true;
                }                
            }
        }
        
        return false;
    }
    
    public boolean borrarPublicacion(String idPublicacion){
        try(MongoClient mongoClient = MongoClients.create(ConstantesConexion.CONNECTION_STRING)){
            MongoCollection<Document> coleccionPublicacion = mongoClient.getDatabase("entities").getCollection("publicacion");
            if(coleccionPublicacion.deleteOne(eq("id", idPublicacion)) != null)
            {
                return true;
            }
        }
        
        return false;
    }
}
