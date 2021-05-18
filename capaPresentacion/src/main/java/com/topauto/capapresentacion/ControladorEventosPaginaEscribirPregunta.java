package com.topauto.capapresentacion;

import com.topauto.capaentidades.Usuario;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ControladorEventosPaginaEscribirPregunta implements Initializable {
    
    private Label label;
    @FXML
    private Button resPregunta;
    @FXML
    private Button hazReseña;
    @FXML
    private Button perfil;
    @FXML
    private Button usuario;
    @FXML
    private Button topAuto;
    @FXML
    private ImageView imagenUsuario;
    @FXML
    private Text textoNombreUsuario;
    private Usuario miUsuario;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
        public void setUsuario(Usuario miUsuario) 
    {
        this.miUsuario = miUsuario;
        setUsuarioImage();
    }
    private void setUsuarioImage()
    {
        Image miImagen;
        try{
        miImagen = new Image (this.miUsuario.getFoto().getPath());
        this.imagenUsuario.setImage(miImagen);
        }
        catch(IllegalArgumentException e)
        {
            miImagen = new Image("imagenes/perfil.png");
            this.imagenUsuario.setImage(miImagen);
        }
        this.textoNombreUsuario.setText(this.miUsuario.getUserName());
    }

    @FXML
    private void responder(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaListadoPreguntasScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaListadoPreguntas controlador = loader.getController();
            controlador.setUsuario(miUsuario);
            
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
    private void reseñar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaEscribirReseniaScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaEscribirResenia controlador = loader.getController();
            controlador.setUsuario(miUsuario);
            
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
    private void verPerfil(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaPerfilScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaPerfil controlador = loader.getController();
            controlador.setUsuario(miUsuario);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Perfil Usuario");
            
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
                        
            Stage myStage = (Stage) this.perfil.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Setea Usuario
    @FXML
    private void menu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaPrincipalScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaPrincipal controlador = loader.getController();
            controlador.setUsuario(miUsuario);
            
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
