package com.topauto.capapresentacion;

import com.topauto.capaentidades.Imagen;
import com.topauto.capaentidades.PRrelacionada;
import com.topauto.capaentidades.Publicacion;
import com.topauto.capaentidades.Resenia;
import com.topauto.capaentidades.Vehiculo;

import com.topauto.capaentidades.Usuario;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ControladorEventosPaginaBuscarVehiculo implements Initializable {

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
    private ImageView imagenUsuarioPerfil;

    private Usuario usuarioLogin;

    //////////////////////own attributes//////////////////////////
    private ArrayList<Vehiculo> listaVehiculos;

    private ArrayList<Vehiculo> encontrados = new ArrayList<>();

    com.topauto.capaaccesodatos.RepositorioVehiculo rVehiculos = new com.topauto.capaaccesodatos.RepositorioVehiculo();

    String palabraClave;
    int numVehiculos;
    int posicion;

    /////////////////////////////////////////////////////////////
    @FXML
    private ImageView imgVehiculosEncontrados;
    @FXML
    private Button botonAnterior;
    @FXML
    private Text textVehiculoEncontrado;
    @FXML
    private Button topAuto;
    @FXML
    private Text textoLosMasPopulares;
    @FXML
    private Text preguntasPopulares123;
    @FXML
    private Button botonSiguiente;

    //////////////////////own attributes//////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.botonIngresarOPerfil.setText("Ver Perfil");

        listaVehiculos = rVehiculos.descargarVehiculos();

        //Buscar Vehiculos asociados con el criterio de busqueda
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getMarca().getNombre().toLowerCase().contains(palabraClave) || listaVehiculos.get(i).getModelo().toLowerCase().contains(palabraClave)) {
                encontrados.add(listaVehiculos.get(i));
            }
        }

        numVehiculos = this.encontrados.size();

        //Si encuentra vehiculos ingrese la imagen del primer vehiculo encontrado
        if (!encontrados.isEmpty()) {
            try {
                //Poner Imagen

                for (Imagen img : encontrados.get(posicion).getFotos()) {
                    if (img.getPath().contains("general.jpg")) {
                        Image miImagen = new Image(img.getPath());
                        
                        this.textVehiculoEncontrado.setText(encontrados.get(posicion).getMarca().getNombre()+" - "+encontrados.get(posicion).getModelo());
                        this.imgVehiculosEncontrados.setImage(miImagen); 
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            this.textVehiculoEncontrado.setText("No se encontro el vehiculo solicitado");
        }

    }

    public void setPalabraClave(String miPalabra) {
        this.palabraClave = miPalabra;
        this.posicion = 0;
    }

    public void setUsuario(Usuario miUsuario) {
        usuarioLogin = miUsuario;
        setUsuarioImage();
    }

    private void setUsuarioImage() {
        Image miImagen;
        try {
            miImagen = new Image(this.usuarioLogin.getFoto().getPath());
            this.imagenUsuarioPerfil.setImage(miImagen);
        } catch (IllegalArgumentException e) {
            miImagen = new Image("imagenes/perfil.png");
            this.imagenUsuarioPerfil.setImage(miImagen);
        }
        this.textoNombreUsuario.setText(this.usuarioLogin.getUserName());
    }

    @FXML
    private void btnHazUnaPregunta(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaEscribirPreguntaScene.fxml"));

            Parent root = loader.load();

            ControladorEventosPaginaEscribirPregunta controlador = loader.getController();
            controlador.setUsuario(usuarioLogin);

            controlador.setUsuario(usuarioLogin);
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

            controlador.setUsuario(usuarioLogin);

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

            controlador.setUsuario(usuarioLogin);

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

        if (this.usuarioLogin != null) {
            this.botonIngresarOPerfil.setText("Ver Perfil");
        } else {
            this.botonIngresarOPerfil.setText("Ingresar");
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaPerfilScene.fxml"));

            Parent root = loader.load();

            ControladorEventosPaginaPerfil controlador = loader.getController();
            controlador.setUsuario(this.usuarioLogin);
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
    private void clkImgVehiculoEncontrado(MouseEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaVehiculoScene.fxml"));
            Parent root = loader.load();
            ControladorEventosPaginaVehiculo controlador = loader.getController();
            controlador.setUsuario(usuarioLogin);
            controlador.setVehiculo(encontrados.get(posicion)); //Envio mi vehiculo ...
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
            stage.close();
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void btnAnterior(ActionEvent event) {
        
        posicion--;
        if(this.posicion>=0)
        {
            try {
                //Poner Imagen

                for (Imagen img : encontrados.get(posicion).getFotos()) {
                    if (img.getPath().contains("general.jpg")) {
                        Image miImagen = new Image(img.getPath());
                        
                        this.textVehiculoEncontrado.setText(encontrados.get(posicion).getMarca().getNombre()+" - "+encontrados.get(posicion).getModelo());
                        this.imgVehiculosEncontrados.setImage(miImagen);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }else{
            posicion--;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Llego al inicio");
            alert.setContentText("Llego al inicio de la lista de vehiculos encontrados");
            alert.showAndWait();
        }
        
    }

    @FXML
    private void btnSiguiente(ActionEvent event) {
        
        posicion++;
        if(this.posicion<this.numVehiculos)
        {
            try {
                //Poner Imagen

                for (Imagen img : encontrados.get(posicion).getFotos()) {
                    if (img.getPath().contains("general.jpg")) {
                        Image miImagen = new Image(img.getPath());
                        
                        this.textVehiculoEncontrado.setText(encontrados.get(posicion).getMarca().getNombre()+" - "+encontrados.get(posicion).getModelo());
                        this.imgVehiculosEncontrados.setImage(miImagen);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }else{
            posicion--;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Llego al limite");
            alert.setContentText("Llego al ultimo vehiculo encontrado");
            alert.showAndWait();
        }
        
    }

    @FXML
    private void menu(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaPrincipalScene.fxml"));

            Parent root = loader.load();

            ControladorEventosPaginaPrincipal controlador = loader.getController();
            controlador.setUsuario(usuarioLogin);

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
            Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
