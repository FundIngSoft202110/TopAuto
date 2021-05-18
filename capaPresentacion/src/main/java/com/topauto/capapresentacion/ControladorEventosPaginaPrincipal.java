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
    private Pane imagenPopulares2;
    @FXML
    private Text modeloPopulares2;
    @FXML
    private Text resenasPopulares2;
    @FXML
    private Text preguntasPopulares2;
    @FXML
    private Pane imagenPopulares3;
    @FXML
    private Text modeloPopulares3;
    @FXML
    private Text resenasPopulares3;
    @FXML
    private Text preguntasPopulares3;
    @FXML
    private Pane imagenPopulares4;
    @FXML
    private Text modeloPopulares4;
    @FXML
    private Text resenasPopulares4;
    @FXML
    private Text preguntasPopulares4;
    @FXML
    private Pane imagenPopulares5;
    @FXML
    private Text modeloPopulares5;
    @FXML
    private Text resenasPopulares5;
    @FXML
    private Text preguntasPopulares5;
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
    @FXML
    private ImageView imagenUsuarioPerfil;

    private Usuario usuarioLogin;

    //////////////////////own attributes//////////////////////////
    private ArrayList<Vehiculo> listaVehiculos;

    private ArrayList<Publicacion> listaPublicacion;
    
    private ArrayList<Vehiculo> top5 = new ArrayList<>();

    com.topauto.capaaccesodatos.RepositorioPublicacion rPublicacion = new com.topauto.capaaccesodatos.RepositorioPublicacion();
    com.topauto.capaaccesodatos.RepositorioVehiculo rVehiculos = new com.topauto.capaaccesodatos.RepositorioVehiculo();

    private ArrayList<Publicacion> listaPublicaciones;
    @FXML
    private Text motorPopulares1;
    @FXML
    private Text transmisionPopulares1;
    @FXML
    private Text motorPopulares2;
    @FXML
    private Text transmisionPopulares2;
    @FXML
    private Text motorPopulares3;
    @FXML
    private Text transmisionPopulares3;
    @FXML
    private Text motorPopulares4;
    @FXML
    private Text transmisionPopulares4;
    @FXML
    private Text motorPopulares5;
    @FXML
    private Text transmisionPopulares5;
    @FXML
    private ImageView imgt1;
    @FXML
    private ImageView imgt2;
    @FXML
    private ImageView imgt3;
    @FXML
    private ImageView imgt4;
    @FXML
    private ImageView imgt5;

    //////////////////////own attributes//////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.botonIngresarOPerfil.setText("Ver Perfil");
        
        listaVehiculos = rVehiculos.descargarVehiculos();
        
        /*
        ArrayList<Vehiculo> maxVehiculos = new ArrayList<>();
        listaPublicacion = rPublicacion.descargarPublicaciones();
                
        for(Publicacion auxP: listaPublicacion)
        {
            if(auxP instanceof PRrelacionada)
            {
                maxVehiculos.add(((PRrelacionada) auxP).getVehiculo());
            }
        }*/
        
        int pos;
        int cont=0;
        while(cont<5)
        {
            pos=(int) (Math.random()*(listaVehiculos.size()));
            if(!top5.contains(listaVehiculos.get(pos)))
            {
                top5.add(listaVehiculos.get(pos));
                cont++;
            }
        }
        for (Imagen img : top5.get(0).getFotos()) {
                if (img.getPath().contains("general.jpg")) {
                    Image miImagen = new Image(img.getPath());
                    this.imgt1.setImage(miImagen);
                    this.modeloPopulares1.setText(top5.get(0).getModelo());
                    this.motorPopulares1.setText(top5.get(0).getMotor().name());
                    this.transmisionPopulares1.setText(top5.get(0).getTransmision().name());
                }
            }       
        for (Imagen img : top5.get(1).getFotos()) {
                if (img.getPath().contains("general.jpg")) {
                    Image miImagen = new Image(img.getPath());
                    this.imgt2.setImage(miImagen);
                    this.modeloPopulares2.setText(top5.get(1).getModelo());
                    this.motorPopulares2.setText(top5.get(1).getMotor().name());
                    this.transmisionPopulares2.setText(top5.get(1).getTransmision().name());
                }
            } 
        for (Imagen img : top5.get(2).getFotos()) {
                if (img.getPath().contains("general.jpg")) {
                    Image miImagen = new Image(img.getPath());
                    this.imgt3.setImage(miImagen);
                    this.modeloPopulares3.setText(top5.get(2).getModelo());
                    this.motorPopulares3.setText(top5.get(2).getMotor().name());
                    this.transmisionPopulares3.setText(top5.get(2).getTransmision().name());
                }
            } 
        for (Imagen img : top5.get(3).getFotos()) {
                if (img.getPath().contains("general.jpg")) {
                    Image miImagen = new Image(img.getPath());
                    this.imgt4.setImage(miImagen);
                    this.modeloPopulares4.setText(top5.get(3).getModelo());
                    this.motorPopulares4.setText(top5.get(3).getMotor().name());
                    this.transmisionPopulares4.setText(top5.get(3).getTransmision().name());
                }
            } 
        for (Imagen img : top5.get(4).getFotos()) {
                if (img.getPath().contains("general.jpg")) {
                    Image miImagen = new Image(img.getPath());
                    this.imgt5.setImage(miImagen);
                    this.modeloPopulares5.setText(top5.get(4).getModelo());
                    this.motorPopulares5.setText(top5.get(4).getMotor().name());
                    this.transmisionPopulares5.setText(top5.get(4).getTransmision().name());
                }
            } 
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
        
        if(this.usuarioLogin!=null){
            this.botonIngresarOPerfil.setText("Ver Perfil");
        }else{
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

    //Pasa UsuarioLogin
    @FXML
    private void btnIrAlListado(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaListadoVehiculosScene.fxml"));

            Parent root = loader.load();

            ControladorEventosPaginaListadoVehiculos controlador = loader.getController();

            controlador.setUsuario(usuarioLogin);

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
        
        try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaVehiculoScene.fxml"));
                    Parent root = loader.load();
                    ControladorEventosPaginaVehiculo controlador = loader.getController();
                    controlador.setVehiculo(top5.get(0)); //Envio mi vehiculo ...
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

                    Stage myStage = (Stage) this.botonVerTop1.getScene().getWindow();
                    myStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }

    @FXML
    private void btnVerTop2(ActionEvent event) {
        
         try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaVehiculoScene.fxml"));
                    Parent root = loader.load();
                    ControladorEventosPaginaVehiculo controlador = loader.getController();
                    controlador.setVehiculo(top5.get(1)); //Envio mi vehiculo ...
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

                    Stage myStage = (Stage) this.botonVerTop2.getScene().getWindow();
                    myStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }

    @FXML
    private void btnVerTop3(ActionEvent event) {
        
         try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaVehiculoScene.fxml"));
                    Parent root = loader.load();
                    ControladorEventosPaginaVehiculo controlador = loader.getController();
                    controlador.setVehiculo(top5.get(2)); //Envio mi vehiculo ...
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

                    Stage myStage = (Stage) this.botonVerTop3.getScene().getWindow();
                    myStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }

    @FXML
    private void btnVerTop4(ActionEvent event) {
        
         try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaVehiculoScene.fxml"));
                    Parent root = loader.load();
                    ControladorEventosPaginaVehiculo controlador = loader.getController();
                    controlador.setVehiculo(top5.get(3)); //Envio mi vehiculo ...
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

                    Stage myStage = (Stage) this.botonVerTop4.getScene().getWindow();
                    myStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }

    @FXML
    private void btnVerTop5(ActionEvent event) {
        
         try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaVehiculoScene.fxml"));
                    Parent root = loader.load();
                    ControladorEventosPaginaVehiculo controlador = loader.getController();
                    controlador.setVehiculo(top5.get(4)); //Envio mi vehiculo ...
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

                    Stage myStage = (Stage) this.botonVerTop5.getScene().getWindow();
                    myStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }

    @FXML
    private void btnBuscar(ActionEvent event) {

        //Se carga la lista de vehículos de la base de datos
        String texto;
        texto = this.barraDeBusqueda.getText();
        boolean encontro = false;

        listaVehiculos = rVehiculos.descargarVehiculos();
        //Se busca si lo escrito en la barra de búsqueda coincide con marca o modelo y se redirige a la primera coincidencia
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if ((listaVehiculos.get(i).getMarca().getNombre().toLowerCase().contains(texto.toLowerCase())) || (listaVehiculos.get(i).getModelo().toLowerCase().contains(texto.toLowerCase()))) {
                try {
                    encontro=true;
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
            }
        }
        if(encontro==false)
        {
            this.barraDeBusqueda.setText("No se encontro ningun vehiculo con los criterios de busqueda");
        }
    }

}
