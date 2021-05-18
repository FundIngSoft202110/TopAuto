package com.topauto.capapresentacion;

import com.topauto.capaentidades.Publicacion;
import com.topauto.capaentidades.Resenia;
import com.topauto.capaentidades.Vehiculo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
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
    @FXML
    private Button botonBuscar;

    //////////////////////own attributes//////////////////////////
    
    private ArrayList<Vehiculo> listaVehiculos;
    
    private ArrayList<Resenia> listaResenia;
    
    com.topauto.capaaccesodatos.RepositorioPublicacion rPublicacion = new com.topauto.capaaccesodatos.RepositorioPublicacion();
    com.topauto.capaaccesodatos.RepositorioVehiculo rVehiculos = new com.topauto.capaaccesodatos.RepositorioVehiculo();
    
    private ArrayList<Publicacion> listaPublicaciones;
    
    //////////////////////own attributes//////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }


    @FXML
    private void btnHazUnaPregunta(ActionEvent event) {

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

            Stage myStage = (Stage) this.botonHazUnaPregunta.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnHasUnaReseña(ActionEvent event) {

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
            Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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

            Stage myStage = (Stage) this.botonHazUnaPregunta.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnIngresar(ActionEvent event) {

        String nombreBoton = this.botonIngresarOPerfil.getText();
        if ("Ingresar".equals(nombreBoton)) {

            try {

                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaLoginScene.fxml"));
                stage.setMaxWidth(840);
                stage.setMaxHeight(500);
                stage.setTitle("TopAuto Login");

                ControladorEventosPaginaLogin controlador = loader.getController();
                Parent root = loader.load();
                Scene scene = new Scene(root);

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
                Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
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
            stage.setTitle("TopAuto Vehiculos");

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

    @FXML
    private void btnBuscar(ActionEvent event) {

        //Se carga la lista de vehículos de la base de datos
        String texto;
        texto = this.barraDeBusqueda.getText();

        listaVehiculos = rVehiculos.descargarVehiculos();
        //Se busca si lo escrito en la barra de búsqueda coincide con marca o modelo y se redirige a la primera coincidencia
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if ((listaVehiculos.get(i).getMarca().getNombre().indexOf(texto) != -1) || (listaVehiculos.get(i).getModelo().indexOf(texto) != -1)) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaVehiculoScene.fxml"));
                    Parent root = loader.load();
                    ControladorEventosPaginaVehiculo controlador = loader.getController();
                    controlador.setVehiculo(listaVehiculos.get(i)); //Envio mi vehiculo ...
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
                    //Show my screen!
                    stage.show();
                    
                    Stage myStage = (Stage) this.botonBuscar.getScene().getWindow();
                    myStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                this.barraDeBusqueda.setText("No se encontro ningun vehiculo con ese criterio");
            }
        }

    }

}
