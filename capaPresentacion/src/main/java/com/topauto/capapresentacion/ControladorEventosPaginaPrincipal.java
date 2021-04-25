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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControladorEventosPaginaPrincipal implements Initializable {

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
    private VBox vboxMasPopulares;
    @FXML
    private AnchorPane vboxLosMasPopulares;
    @FXML
    private Pane imagenPopulares1;
    @FXML
    private Text modeloPopulares1;
    @FXML
    private Text resenasPopulares1;
    @FXML
    private Text reseñasPopulares1;
    @FXML
    private Text preguntasPopulares1;
    @FXML
    private Text preguntasPopulares11;
    @FXML
    private Text origenPopulares1;
    @FXML
    private Text tipoAutoPopulares1;
    @FXML
    private Pane imagenPopulares2;
    @FXML
    private Text modeloPopulares2;
    @FXML
    private Text resenasPopulares2;
    @FXML
    private Text preguntasPopulares2;
    @FXML
    private Text origenPopulares2;
    @FXML
    private Text tipoAutoPopulares2;
    @FXML
    private Pane imagenPopulares3;
    @FXML
    private Text modeloPopulares3;
    @FXML
    private Text resenasPopulares3;
    @FXML
    private Text preguntasPopulares3;
    @FXML
    private Text origenPopulares3;
    @FXML
    private Text tipoAutoPopulares3;
    @FXML
    private Pane imagenPopulares4;
    @FXML
    private Text modeloPopulares4;
    @FXML
    private Text resenasPopulares4;
    @FXML
    private Text preguntasPopulares4;
    @FXML
    private Text origenPopulares4;
    @FXML
    private Text tipoAutoPopulares4;
    @FXML
    private Pane imagenPopulares5;
    @FXML
    private Text modeloPopulares5;
    @FXML
    private Text resenasPopulares5;
    @FXML
    private Text preguntasPopulares5;
    @FXML
    private Text origenPopulares5;
    @FXML
    private Text tipoAutoPopulares5;
    @FXML
    private Pane imagenFondo;
    @FXML
    private TextField barraDeBusqueda;
    @FXML
    private Text preguntasPopulares12;
    @FXML
    private Text preguntasPopulares121;
    @FXML
    private Text preguntasPopulares122;
    @FXML
    private Text textoLosMasPopulares;
    @FXML
    private Text preguntasPopulares123;
    @FXML
    private Button botonIrAlListado;
    @FXML
    private Button botonVerTop1;
    @FXML
    private Button botonVerTop2;
    @FXML
    private Button botonVerTop3;
    @FXML
    private Button botonVerTop4;
    @FXML
    private Button botonVerTop5;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }

    @FXML
    private void btnHazUnaPregunta(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PaginaEscribirPreguntaScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaEscribirPregunta controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
                        
            Stage myStage = (Stage) this.botonHazUnaPregunta.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void btnHasUnaReseña(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PaginaEscribirReseniaScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaEscribirResenia controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
                        
            Stage myStage = (Stage) this.botonHazUnaReseña.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void btnRespondePreguntas(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PaginaListadoPreguntasScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaListadoPreguntas controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
                        
            Stage myStage = (Stage) this.botonHazUnaPregunta.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    @FXML
    private void btnIngresar(ActionEvent event) {
        
        String nombreBoton = this.botonIngresarOPerfil.getText();
        if(nombreBoton == "Ingresar")
        {
            
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PaginaLoginScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaLogin controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
                        
            Stage myStage = (Stage) this.botonIngresarOPerfil.getScene().getWindow();
            myStage.close();
            
            } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else{
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PaginaPerfilScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaPerfil controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
                        
            Stage myStage = (Stage) this.botonIngresarOPerfil.getScene().getWindow();
            myStage.close();
            
            } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }


    @FXML
    private void btnIrAlListado(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaListadoVehiculosScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaListadoVehiculos controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
                        
            Stage myStage = (Stage) this.botonIrAlListado.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void btnVerTop1(ActionEvent event) {
    }

    @FXML
    private void btnVerTop2(ActionEvent event) {
    }

    @FXML
    private void btnVerTop3(ActionEvent event) {
    }

    @FXML
    private void btnVerTop4(ActionEvent event) {
    }

    @FXML
    private void btnVerTop5(ActionEvent event) {
    }
    
}
