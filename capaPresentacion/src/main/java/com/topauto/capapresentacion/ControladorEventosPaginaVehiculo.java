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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.topauto.capaentidades.Vehiculo;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class ControladorEventosPaginaVehiculo implements Initializable {

    @FXML
    private Text tituloTop;
    @FXML
    private Text tituloAuto;
    @FXML
    private Button botonHazUnaPregunta;
    @FXML
    private Button botonHazUnaReseña;
    @FXML
    private Button botonRespondePreguntas;
    @FXML
    private Text textoNombreUsuario;
    @FXML
    private Button botonIngresarOPerfil;
    @FXML
    private Pane imagenUsuario;
    @FXML
    private Pane paneImagenVehiculo;
    @FXML
    private Text preguntasPopulares12;
    @FXML
    private Text preguntasPopulares121;
    @FXML
    private Text preguntasPopulares122;
    @FXML
    private Button botonImagenGeneral;
    @FXML
    private Button botonImagenFrente;
    @FXML
    private Button botonImagenLado;
    @FXML
    private Button botonImagenTrasero;
    @FXML
    private Button botonImagenMotor;
    @FXML
    private Button botonImagenInterior;
    @FXML
    private Pane paneLogoVehiculo;
    @FXML
    private Text preguntasPopulares1211;
    @FXML
    private Text preguntasPopulares1221;
    @FXML
    private Text textNombreVehiculo;
    @FXML
    private Text textNumeroReseñas;
    @FXML
    private ProgressBar progressBarVelocidadMaxima;
    @FXML
    private ProgressBar progressBarAceleracionMaxima;
    @FXML
    private Text cpMarca;
    @FXML
    private Text cpModelo;
    @FXML
    private Text cpAno;
    @FXML
    private Text cpRangoEstimado;
    @FXML
    private Text cpCeroACien;
    @FXML
    private Text cpVelocidadMaxima;
    @FXML
    private Text cpHorsePower;
    @FXML
    private Text cpPeso;
    @FXML
    private Text cpLlantas;
    @FXML
    private Text cpCargo;
    @FXML
    private Text cpVelocidadCarga;
    @FXML
    private VBox vBoxCaracteristicasAdicionales;
    @FXML
    private VBox vBoxConsigueTuVehiculoEn;
    @FXML
    private Button botonPreguntas;
    @FXML
    private Button botonResenas;
    @FXML
    private VBox vBoxResenasOPreguntas;
    @FXML
    private TextField textFieldResenasOPreguntas;
    @FXML
    private Button botonPublicarResenaOPregunta;
    
    private Vehiculo miVehiculo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void setVehiculo(Vehiculo miVehiculo)
    {
        this.miVehiculo = miVehiculo;
    }

    @FXML
    private void clickTop(MouseEvent event) {
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
                        
            Stage myStage = (Stage) this.tituloTop.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickAuto(MouseEvent event) {
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
                        
            Stage myStage = (Stage) this.tituloAuto.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnHazUnaPregunta(ActionEvent event) {
    }

    @FXML
    private void btnHazUnaReseña(ActionEvent event) {
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
                        
            Stage myStage = (Stage) this.botonHazUnaReseña.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaEscribirResenia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnRespondePreguntas(ActionEvent event) {
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
                        
            Stage myStage = (Stage) this.botonRespondePreguntas.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaListadoPreguntas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnIngresarOPerfil(ActionEvent event) {
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
                        
            Stage myStage = (Stage) this.botonIngresarOPerfil.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnImegenGeneral(ActionEvent event) {
    }

    @FXML
    private void btnImagenFrente(ActionEvent event) {
    }

    @FXML
    private void btnImagenLado(ActionEvent event) {
    }

    @FXML
    private void btnImagenTrasero(ActionEvent event) {
    }

    @FXML
    private void btnImagenMotor(ActionEvent event) {
    }

    @FXML
    private void btnImagenInterior(ActionEvent event) {
    }

    @FXML
    private void btnPreguntas(ActionEvent event) {
    }

    @FXML
    private void btnReseñas(ActionEvent event) {
    }

    @FXML
    private void btnPublicarResenaOPregunta(ActionEvent event) {
    }
    
}

