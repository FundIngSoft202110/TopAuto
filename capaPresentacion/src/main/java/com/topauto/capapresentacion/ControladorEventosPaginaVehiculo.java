package com.topauto.capapresentacion;

import com.topauto.capaentidades.Usuario;
import com.topauto.capaentidades.Imagen;
import com.topauto.capaentidades.Vehiculo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.topauto.capaentidades.Vehiculo;
import java.net.URISyntaxException;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ScrollPane;
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
    private ImageView imagenUsuario;
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
    private ProgressBar progressBarVelocidadMaxima;
    @FXML
    private ProgressBar progressBarAceleracionMaxima;
    @FXML
    private Text cpMarca;
    @FXML
    private Text cpModelo;
    @FXML
    private ImageView pantallaImagenesVehiculo;
    private TableColumn colCaracteristicasAdicionales;
    private TableColumn colUsuarioPregRes;
    private TableColumn colDescripcionPregRes;
    @FXML
    private Text cpMotor;
    @FXML
    private Text cpTransmision;
    @FXML
    private Text cpDireccion;
    @FXML
    private Text cpPuertas;
    @FXML
    private Text cpFrenos;
    @FXML
    private Text cpVelocidadMaxima;
    @FXML
    private Text cpHorsePower;
    @FXML
    private Text cpCeroACien;
    @FXML
    private Text cpCargo;
    @FXML
    private VBox vBoxConsigueTuVehiculoEn;
    @FXML
    private Button botonPreguntas;
    @FXML
    private Button botonResenas;
    @FXML
    private TextField textFieldResenasOPreguntas;
    @FXML
    private Button botonPublicarResenaOPregunta;
    //////////////////////own attributes//////////////////////////
    
    private Vehiculo miVehiculo;
    
    private Usuario miUsuario;

    private ArrayList<Vehiculo> listaVehiculos;
    
    private Vehiculo vehiculoCargar;

    private String caracteristicas;

    private ObservableList<String> carAd;
    @FXML
    private ImageView imgVendedorA1;
    @FXML
    private ImageView imgVendedorA2;
    @FXML
    private Text textTieneVidriosElectricos;
    @FXML
    private Text textTieneAireAcondicionado;
    @FXML
    private ImageView imgOrganizacionA1;
    @FXML
    private ImageView imgOrganizacionA2;
    @FXML
    private ImageView imgOrganizacionA3;

    //////////////////////////////////////////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void setVehiculo(Vehiculo miVehiculo)
    {
        this.vehiculoCargar = miVehiculo;
        setCarVehiculo();
        
    }
    private void setCarVehiculo ()
    {
        try {
            //Poner Imagen
            
            for (Imagen img : vehiculoCargar.getFotos()) {
                if (img.getPath().contains("general.jpg")) {
                    Image miImagen = new Image (img.getPath());

                    this.pantallaImagenesVehiculo.setImage(miImagen);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        //Poner Imagen Vendedores Asociados
        
        Image imagenA1 = new Image(vehiculoCargar.getVendedoresAsociados().get(0).getLogo().getPath());
        Image imagenA2 = new Image(vehiculoCargar.getVendedoresAsociados().get(1).getLogo().getPath());
        this.imgVendedorA1.setImage(imagenA1);
        this.imgVendedorA2.setImage(imagenA2);
        
        //Poner Imagen Organizaciones Asociadas
        
        Image imagenO1 = new Image(vehiculoCargar.getOrgAsociadas().get(0).getLogo().getPath());
        Image imagenO2 = new Image(vehiculoCargar.getOrgAsociadas().get(1).getLogo().getPath());
        Image imagenO3 = new Image(vehiculoCargar.getOrgAsociadas().get(2).getLogo().getPath());
        this.imgOrganizacionA1.setImage(imagenO1);
        this.imgOrganizacionA2.setImage(imagenO2);
        this.imgOrganizacionA3.setImage(imagenO3);
   
        
        //Poner barras de progreso
        
        this.textNombreVehiculo.setText(vehiculoCargar.getMarca().getNombre()+ " - "+vehiculoCargar.getModelo());
        this.progressBarVelocidadMaxima.setProgress((vehiculoCargar.getVelMax()) / 350);
        this.progressBarAceleracionMaxima.setProgress(((vehiculoCargar.getAccMax() / 150) - 1) * -1);

        //Caracteristicas Principales
        this.cpMarca.setText(vehiculoCargar.getMarca().getNombre());
        this.cpModelo.setText(vehiculoCargar.getModelo());
        this.cpMotor.setText(vehiculoCargar.getMotor().name());
        this.cpTransmision.setText(vehiculoCargar.getTransmision().name());
        this.cpFrenos.setText(vehiculoCargar.getFrenos().name());
        this.cpVelocidadMaxima.setText(vehiculoCargar.getVelMax() + "");
        this.cpHorsePower.setText(vehiculoCargar.getPotencia() + "");
        this.cpDireccion.setText(vehiculoCargar.getDireccion().name());
        this.cpCeroACien.setText(vehiculoCargar.getAccMax() + "");
        this.cpCargo.setText(vehiculoCargar.getMaxPasajeros() + "");
        this.cpPuertas.setText(vehiculoCargar.getNumPuertas() + "");
        
        //Caracteristicas Adicionales
        if(vehiculoCargar.isTieneAireAcondicionado())
        {
            this.textTieneAireAcondicionado.setText("Cuenta con Aire Acondicionado");
        }else{
            this.textTieneAireAcondicionado.setText("No Cuenta con Aire Acondicionado");
        }
        if(vehiculoCargar.isTieneVidriosElectricos())
        {
            this.textTieneVidriosElectricos.setText("Cuenta con Vidrios Electricos");
        }else{
            this.textTieneVidriosElectricos.setText("No Cuenta con Vidrios Electricos");
        }
        
    }
    public void setUsuario (Usuario miUsuario)
    {
        this.miUsuario = miUsuario;
        setUsuarioImage();
        this.botonIngresarOPerfil.setText("Ver Perfil");
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
    private void clickTop(MouseEvent event) {
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

            Stage myStage = (Stage) this.botonIngresarOPerfil.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnImegenGeneral(ActionEvent event) {
        try {
            //Poner Imagen
            for (Imagen img : vehiculoCargar.getFotos()) {
                if (img.getPath().contains("general.jpg")) {
                    Image miImagen = new Image(img.getPath());
                    this.pantallaImagenesVehiculo.setImage(miImagen);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void btnImagenFrente(ActionEvent event) {
        try {
            //Poner Imagen
            for (Imagen img : vehiculoCargar.getFotos()) {
                if (img.getPath().contains("frente.jpg")) {
                    Image miImagen = new Image(img.getPath());
                    this.pantallaImagenesVehiculo.setImage(miImagen);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void btnImagenLado(ActionEvent event) {
        try {
            //Poner Imagen
            for (Imagen img : vehiculoCargar.getFotos()) {
                if (img.getPath().contains("lado.jpg")) {
                    Image miImagen = new Image(img.getPath());
                    this.pantallaImagenesVehiculo.setImage(miImagen);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void btnImagenTrasero(ActionEvent event) {
        try {
            //Poner Imagen
            for (Imagen img : vehiculoCargar.getFotos()) {
                if (img.getPath().contains("trasero.jpg")) {
                    Image miImagen = new Image(img.getPath());
                    this.pantallaImagenesVehiculo.setImage(miImagen);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void btnImagenMotor(ActionEvent event) {
        try {
            //Poner Imagen
            for (Imagen img : vehiculoCargar.getFotos()) {
                if (img.getPath().contains("motor.jpg")) {
                    Image miImagen = new Image(img.getPath());
                    this.pantallaImagenesVehiculo.setImage(miImagen);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void btnImagenInterior(ActionEvent event) {
        try {
            //Poner Imagen
            for (Imagen img : vehiculoCargar.getFotos()) {
                if (img.getPath().contains("interior.jpg")) {
                    Image miImagen = new Image(img.getPath());
                    this.pantallaImagenesVehiculo.setImage(miImagen);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
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

    @FXML
    private void clkVA1(MouseEvent event) {
        
        if(java.awt.Desktop.isDesktopSupported()){
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            
            if(desktop.isSupported(java.awt.Desktop.Action.BROWSE)){
                try{
                    java.net.URI uri = new java.net.URI("https://www.tucarro.com.co/");
                    desktop.browse(uri);
                }catch(URISyntaxException | IOException ex){
                    System.out.println("Error: "+ex.getMessage());
                }
            }
        }
        
    }

    @FXML
    private void clkOA1(MouseEvent event) {
        
        if(java.awt.Desktop.isDesktopSupported()){
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            
            if(desktop.isSupported(java.awt.Desktop.Action.BROWSE)){
                try{
                    java.net.URI uri = new java.net.URI(vehiculoCargar.getOrgAsociadas().get(0).getLink());
                    desktop.browse(uri);
                }catch(URISyntaxException | IOException ex){
                    System.out.println("Error: "+ex.getMessage());
                }
            }
        }
        
    }

    @FXML
    private void clkOA2(MouseEvent event) {
        
        if(java.awt.Desktop.isDesktopSupported()){
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            
            if(desktop.isSupported(java.awt.Desktop.Action.BROWSE)){
                try{
                    java.net.URI uri = new java.net.URI(vehiculoCargar.getOrgAsociadas().get(1).getLink());
                    desktop.browse(uri);
                }catch(URISyntaxException | IOException ex){
                    System.out.println("Error: "+ex.getMessage());
                }
            }
        }
        
    }

    @FXML
    private void clkOA3(MouseEvent event) {
        
        if(java.awt.Desktop.isDesktopSupported()){
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            
            if(desktop.isSupported(java.awt.Desktop.Action.BROWSE)){
                try{
                    java.net.URI uri = new java.net.URI(vehiculoCargar.getOrgAsociadas().get(2).getLink());
                    desktop.browse(uri);
                }catch(URISyntaxException | IOException ex){
                    System.out.println("Error: "+ex.getMessage());
                }
            }
        }
        
    }

    @FXML
    private void clkVA2(MouseEvent event) {
        
        if(java.awt.Desktop.isDesktopSupported()){
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            
            if(desktop.isSupported(java.awt.Desktop.Action.BROWSE)){
                try{
                    java.net.URI uri = new java.net.URI("https://www.carroya.com//");
                    desktop.browse(uri);
                }catch(URISyntaxException | IOException ex){
                    System.out.println("Error: "+ex.getMessage());
                }
            }
        }
        
    }

}
