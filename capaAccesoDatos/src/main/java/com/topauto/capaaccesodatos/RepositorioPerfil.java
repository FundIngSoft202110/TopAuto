package com.topauto.capaaccesodatos;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.topauto.capaentidades.Imagen;
import com.topauto.capaentidades.Pais;
import com.topauto.capaentidades.Usuario;
import java.util.ArrayList;
import org.bson.Document;

public class RepositorioPerfil {

    public RepositorioPerfil() {
    }
    
    public ArrayList<Usuario> descargarPerfiles(){
        try(MongoClient mongoClient = MongoClients.create(ConstantesConexion.CONNECTION_STRING)){
            MongoCollection<Document> coleccionUsuario = mongoClient.getDatabase("entities").getCollection("usuario");
            ArrayList<Document> docsUsuarios = coleccionUsuario.find().into(new ArrayList<>());
            ArrayList<Usuario> usuarios = new ArrayList<>();
            for (Document docUsuario : docsUsuarios) {
                Usuario usuario = new Usuario();
                usuario.setNombre(docUsuario.getString("nombre"));
                usuario.setUserName(docUsuario.getString("username"));
                usuario.setCorreo(docUsuario.getString("correo"));
                usuario.setDescripcion(docUsuario.getString("descripcion"));
                usuario.setContrasenia(docUsuario.getString("contrasenia"));
                usuario.setEstaVerficado(docUsuario.getBoolean("estaVerificado"));
                usuario.setFoto(new Imagen(docUsuario.getString("foto")));
                Pais pais = new Pais();
                pais.setNombre(docUsuario.getString("pais"));
                usuario.setPais(pais);
                        
                usuarios.add(usuario);
            }
            
            return usuarios;
        }
    }
    
    public boolean buscarCorreo(String correo){
        return true;
    }
    
    public boolean buscarUserName(String username){
        return true;
    }
    
    public boolean persistirNuevoUsuario(Usuario usuario){
        return true;
    }
    
    public boolean persistirPerfilModificado(Usuario usuario){
        return true;
    }
    
    public boolean persistirNuevaContrasenia(String contrasenia){
        return true;
    }
}
