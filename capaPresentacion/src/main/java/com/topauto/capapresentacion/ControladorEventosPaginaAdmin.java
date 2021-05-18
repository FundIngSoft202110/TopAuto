package com.topauto.capapresentacion;

import com.topauto.capaentidades.Imagen;
import com.topauto.capaentidades.Pais;
import com.topauto.capaentidades.Publicacion;
import com.topauto.capaentidades.Usuario;
import com.topauto.capanegocio.ControladorPerfil;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControladorEventosPaginaAdmin implements Initializable {
    
    private ControladorPerfil controlPerfil = new ControladorPerfil();
    private ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
    @FXML
    private Button btnVolver;
    @FXML
    private TableColumn<Usuario,String> colNombre;
    @FXML
    private TableColumn<Usuario,String> colUsername;
    @FXML
    private TableColumn<Usuario,String> colCorreo;
    @FXML
    private TableColumn<Usuario,String> colClave;
    @FXML
    private TableView<Usuario> tablaUsuarios;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnAgregar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtClave;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controlPerfil.descargarDatos();
        
        for(Usuario u : controlPerfil.getUsuarios()){
            usuarios.add(u);
        }
        
        this.colNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombre"));
        this.colUsername.setCellValueFactory(new PropertyValueFactory<Usuario, String>("userName"));
        this.colCorreo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("correo"));
        this.colClave.setCellValueFactory(new PropertyValueFactory<Usuario, String>("contrasenia"));
        
        tablaUsuarios.setItems(usuarios);

    }    

    @FXML
    private void regresar(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaInicialScene.fxml"));
            stage.setMaxWidth(840);
            stage.setMaxHeight(500);
            stage.setTitle("TopAuto");
            
            ControladorEventosPaginaRegistro controlador = loader.getController();
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
                        
            Stage myStage = (Stage) this.btnVolver.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void eliminar(ActionEvent event) {
        Usuario u = this.tablaUsuarios.getSelectionModel().getSelectedItem();
        
        if(u == null){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Debes seleccionar un usuario");
            alerta.showAndWait();
        }
        else{
            if(controlPerfil.borrarUsuario(u.getUserName())){
                this.usuarios.remove(u);
                this.tablaUsuarios.refresh();

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText(null);
                alerta.setTitle("Exito");
                alerta.setContentText("Usuario eliminado correctamente.");
                alerta.showAndWait();
            }
            else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("Usuario no se pudo eliminar");
                alerta.showAndWait();
            }
            
        }
    }

    @FXML
    private void modificar(ActionEvent event) {
        Usuario u = this.tablaUsuarios.getSelectionModel().getSelectedItem();
        
        if(u == null){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Debes seleccionar un usuario");
            alerta.showAndWait();
        }
        else{
            String name=this.txtNombre.getText();
            String username=this.txtUserName.getText();
            String correo=this.txtCorreo.getText();
            String clave=this.txtClave.getText();
            Pais pais=new Pais();
            Imagen imagen = new Imagen();
            ArrayList<Publicacion> publicaciones =new ArrayList<Publicacion>();
            for(Usuario us:controlPerfil.getUsuarios()){
                if(username.equals(us.getUserName())){
                    pais=us.getPais();
                    imagen = us.getFoto();
                    publicaciones = us.getPublicaciones();
                }
            }

            Usuario aux=new Usuario(name,username,correo,null,clave,true, publicaciones,imagen, pais);

            if(controlPerfil.modificarPerfil(aux)){
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText(null);
                alerta.setTitle("Exito");
                alerta.setContentText("El usuario ha sido actualizado.");
                alerta.showAndWait();
                this.usuarios.remove(u);
                this.usuarios.add(aux);
                this.tablaUsuarios.setItems(usuarios);
                controlPerfil.descargarDatos();
            }
            else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("No se pudo modificar el usuario");
                alerta.showAndWait();
            }
            this.tablaUsuarios.refresh();
        }
    }

    @FXML
    private void agregar(ActionEvent event) {
        
        String name=this.txtNombre.getText();
        String username=this.txtUserName.getText();
        String correo=this.txtCorreo.getText();
        String clave=this.txtClave.getText();
        String country = "Colombia";
        Pais pais= new Pais();
        Imagen imagen = new Imagen();
        imagen.setPath("/imagenes/perfil.jpg");
        
        for(Usuario us:controlPerfil.getUsuarios()){
            if(country.equals(us.getPais().getNombre())){
                pais=us.getPais();
            }
        }
        
        
        if(("".equals(name))||("".equals(username))||("".equals(correo))||("".equals(clave))){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Todos los campos deben estar llenos.");
            alerta.showAndWait();
        }
        else{
            Usuario u=new Usuario(name,username,correo,null,clave,true, new ArrayList<Publicacion>(),imagen, pais);
            boolean encontro=false;
            for(Usuario us : controlPerfil.getUsuarios()){
                if((username.equals(us.getUserName())||(correo.equals(us.getCorreo())))){
                    encontro=true;
                }
            }
            if(encontro==false){
                this.tablaUsuarios.setItems(usuarios);
                if(controlPerfil.registrarPerfil(u)){
                    this.usuarios.add(u);
                    this.tablaUsuarios.setItems(usuarios);
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setHeaderText(null);
                    alerta.setTitle("Exito");
                    alerta.setContentText("Usuario agregado correctamente");
                    alerta.showAndWait();
                    controlPerfil.descargarDatos();
                }else{
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setHeaderText(null);
                    alerta.setTitle("Error");
                    alerta.setContentText("Error para registrar usuario, verifique nuevamente");
                    alerta.showAndWait();
                }
            }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("Error para registrar usuario, verifique nuevamente");
                alerta.showAndWait();
            }            
        }
    }

    @FXML
    private void seleccionar(MouseEvent event) {
        Usuario u = this.tablaUsuarios.getSelectionModel().getSelectedItem();
        if(u != null){
            this.txtNombre.setText(u.getNombre());
            this.txtUserName.setText(u.getUserName());
            this.txtCorreo.setText(u.getCorreo());
            this.txtClave.setText(u.getContrasenia());
        }
    }
}
