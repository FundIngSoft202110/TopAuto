package com.topauto.capapresentacion;

import com.topauto.capaentidades.Usuario;
import com.topauto.capanegocio.ControladorPerfil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ControladorEventosPaginaLogin implements Initializable {
    
    ControladorPerfil controlPerfil = new ControladorPerfil();
    Usuario usuario = new Usuario();
    
    @FXML
    private Button btIngreso;
    @FXML
    private Button btRegistro;
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtClave;
    @FXML
    private Button btInicial;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controlPerfil.descargarDatos();
    }    

    @FXML
    private void acceder(ActionEvent event) {
        String username = this.txtUser.getText();
        String clave = this.txtClave.getText();
        
        if(("".equals(username))||("".equals(clave))){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Los datos estan incompletos");
            alerta.showAndWait();
        }
        else{
            if(controlPerfil.acceder(username, clave)){
                
                for(Usuario u : controlPerfil.getUsuarios()){
                    if(u.getUserName().equals(username)){
                        this.usuario=u;
                    }
                }
                
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText(null);
                alerta.setTitle("Exito");
                alerta.setContentText("Acceso completado");
                alerta.showAndWait();
                
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaPrincipalScene.fxml"));

                    Parent root = loader.load();

                    ControladorEventosPaginaPrincipal controlador = loader.getController();

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setTitle("TopAuto");

                    stage.setScene(scene);
                    Screen screen = Screen.getPrimary(); //Get info from my screen!
                    Rectangle2D bounds = screen.getVisualBounds();
                    //Set visual bounds for MaximizedScreen:
                    stage.setX(bounds.getMinX());
                    stage.setY(bounds.getMinY());
                    stage.setWidth(bounds.getWidth());
                    stage.setHeight(bounds.getHeight());
                    //Adjust my code to the max boundaries of my screen.
                    stage.setMaximized(true); //Set it maximized
                    stage.show();

                    Stage myStage = (Stage) this.btIngreso.getScene().getWindow();
                    myStage.close();

                } catch (IOException ex) {
                    Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("Datos erroneos, intente nuevamente.");
                alerta.showAndWait();
            }
        }       
    }

    @FXML
    private void registrar(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaRegistroScene.fxml"));
            stage.setMaxWidth(840);
            stage.setMaxHeight(500);
            stage.setTitle("TopAuto Registro");
            
            ControladorEventosPaginaRegistro controlador = loader.getController();
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
                        
            Stage myStage = (Stage) this.btRegistro.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void inicio(ActionEvent event) {
        
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaInicialScene.fxml"));
            stage.setMaxWidth(840);
            stage.setMaxHeight(500);
            stage.setTitle("TopAuto");
            
            ControladorEventosPaginaInicial controlador = loader.getController();
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
                        
            Stage myStage = (Stage) this.btInicial.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
