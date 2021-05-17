package com.topauto.capapresentacion;

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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class ControladorEventosPaginaPerfil implements Initializable {

    @FXML
    private Button resPregunta;
    @FXML
    private Button hazPregunta;
    @FXML
    private Button hazReseña;
    @FXML
    private Button topAuto;
    @FXML
    private AnchorPane countries;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void responder(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaListadoPreguntasScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaListadoPreguntas controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
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
                        
            Stage myStage = (Stage) this.resPregunta.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void preguntar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaEscribirPreguntaScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaEscribirPregunta controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
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
                        
            Stage myStage = (Stage) this.hazPregunta.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void reseñar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaEscribirReseniaScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaEscribirResenia controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
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
                        
            Stage myStage = (Stage) this.hazReseña.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void menu(ActionEvent event) {
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
                        
            Stage myStage = (Stage) this.topAuto.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
