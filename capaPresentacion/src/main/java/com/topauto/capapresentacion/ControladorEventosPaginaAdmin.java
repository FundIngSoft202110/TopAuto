package com.topauto.capapresentacion;

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
    
    private ObservableList<Usuario> usuarios;
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
        this.colNombre.setCellFactory(new PropertyValueFactory("nombre"));
        this.colUsername.setCellFactory(new PropertyValueFactory("userName"));
        this.colCorreo.setCellFactory(new PropertyValueFactory("correo"));
        this.colClave.setCellFactory(new PropertyValueFactory("contrasenia"));
        
        controlPerfil.descargarDatos();
        ObservableList<Usuario> usuarios = FXCollections.observableArrayList(controlPerfil.getUsuarios());
            
        
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
            this.usuarios.remove(u);
            this.tablaUsuarios.refresh();
            
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setHeaderText(null);
            alerta.setTitle("Alerta");
            alerta.setContentText("Usuario eliminado correctamente.");
            alerta.showAndWait();
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

            Usuario aux=new Usuario(name,username,correo,clave,null);

            if(!this.usuarios.contains(aux)){
                u.setNombre(name);
                u.setUserName(username);
                u.setCorreo(correo);
                u.setContrasenia(clave);
                
                this.tablaUsuarios.refresh();
            }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("El usuario ya existe en el sistema.");
                alerta.showAndWait();
            }
        }
    }

    @FXML
    private void agregar(ActionEvent event) {
        String name=this.txtNombre.getText();
        String username=this.txtUserName.getText();
        String correo=this.txtCorreo.getText();
        String clave=this.txtClave.getText();
        
        Usuario u=new Usuario(name,username,correo,clave,null);
        
        if(!this.usuarios.contains(u)){
            this.usuarios.add(u);
            this.tablaUsuarios.setItems(usuarios);
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("El usuario ya existe en el sistema.");
            alerta.showAndWait();
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
