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
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import com.topauto.capanegocio.ControladorPublicacion;
import com.topauto.capaentidades.Pregunta;
import com.topauto.capaentidades.Publicacion;
import java.util.ArrayList;

public class ControladorEventosPaginaListadoPreguntas implements Initializable {
    
    private Label label;
    @FXML
    private Button hazPregunta;
    @FXML
    private Button hazReseña;
    @FXML
    private Button perfil;
    @FXML
    private AnchorPane countries;
    @FXML
    private Button topAuto;
    @FXML
    private AnchorPane paneImagenVehiculos;
    @FXML
    private SplitPane paneVerticalPreguntas;
    
    private final String urlImage = "imagenes/panel_vehiculo_pregunta.png";
    ArrayList<Pregunta> misPreguntas = new ArrayList<>();
    
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        setUpImages(); 
        pruebaStackPane();
        //initializa preguntas:
        ControladorPublicacion controladorLocal = new ControladorPublicacion();
        controladorLocal.descargarDatos();
        
    }
    /** setUpImages () - Privada:
     * En los Panes validos, les agrego mis imagenes guardadas localmente.
     * Depende que la variable local urlImage sea válida, en el caso que no, no coloca ninguna imagen.
     */    
    private void setUpImages()
    {
        Image localImagen;
        try{
        localImagen = new Image(this.urlImage);
        ImageView fxmlImage = new ImageView();
        fxmlImage.setImage(localImagen);
        AnchorPane.setTopAnchor(fxmlImage, 0.0);
        AnchorPane.setLeftAnchor(fxmlImage, 0.0);
        this.paneImagenVehiculos.getChildren().add(fxmlImage);
        }
        catch(IllegalArgumentException e)
        {
            //En logger, comentar advertencia.
           Logger.getLogger(ControladorEventosPaginaListadoPreguntas.class.getName()).log(Level.WARNING, "No pudo cargar imagen.", e);

        }
        

        
    }
    //TEMP - Probar como funciona esta herda. - IT WORKS! Guirse con esto.
    private void pruebaStackPane()
    {
        AnchorPane miAnchor1 = new AnchorPane();
        AnchorPane miAnchor2 = new AnchorPane();
        AnchorPane miAnchor3 = new AnchorPane(), miAnchor4 = new AnchorPane();
        this.paneVerticalPreguntas.getItems().addAll(miAnchor1,miAnchor2, miAnchor3, miAnchor4);
        //this.paneVerticalPreguntas.setDividerPositions(0.0f, 0.25f, 0.5f,0.75f);// IF i know the anchors.
        this.paneVerticalPreguntas.setDividerPosition(0, 0.0f);
        this.paneVerticalPreguntas.setDividerPosition(1, 0.25f);
        this.paneVerticalPreguntas.setDividerPosition(2, 0.5f);
        this.paneVerticalPreguntas.setDividerPosition(3, 0.75f);
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
    private void verPerfil(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaPerfilScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaPerfil controlador = loader.getController();
            
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
