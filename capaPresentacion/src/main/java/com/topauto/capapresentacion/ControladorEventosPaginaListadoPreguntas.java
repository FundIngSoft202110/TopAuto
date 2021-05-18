package com.topauto.capapresentacion;

import com.topauto.capaentidades.PRrelacionada;
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
import com.topauto.capaentidades.Usuario;
import java.util.ArrayList;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

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
    @FXML
    private ImageView imagenUsuario;
    
    private final String urlImage = "imagenes/panel_vehiculo_pregunta.png";
    ArrayList<Pregunta> misPreguntas = new ArrayList<>();
    int noPreguntasMaxXPagina = 4;
    int minPreg = 0, maxPreg = noPreguntasMaxXPagina;
    
    private Usuario usuarioLogeado = new Usuario();
    
    
    private void handlePreguntasInit() 
    {
        paneVerticalPreguntas.getItems().clear(); //Clear for reset purposes!
        int noPreguntas = misPreguntas.size();
        int contador = 0;
        String miOrigin;
        if (noPreguntas < maxPreg)
        {
            maxPreg = noPreguntas;
        }
        AnchorPane localAPane;
        float incrementPerDivision = 1.0f / (float) noPreguntasMaxXPagina;
       
        for (Pregunta p : misPreguntas.subList(minPreg, maxPreg))
        {
            
            if (p instanceof PRrelacionada)
            {
                miOrigin = ((PRrelacionada)p).getVehiculo().getModelo();
            }
            else
            {
                miOrigin = "General";
            }
            localAPane = setUpAnchorPane( p.getPropietario().getUserName(), p.getDescripcion(), p.getTitulo(),
                    p.getFecha().toString(), miOrigin);

            this.paneVerticalPreguntas.getItems().add(localAPane);
            this.paneVerticalPreguntas.setDividerPosition(contador, (float)contador * incrementPerDivision);
            contador++; 
        }
    }
    
    private AnchorPane setUpAnchorPane(String miUsername, String miDescripcion, String miTitulo, String miFecha, String miOrigin)
    {
        AnchorPane localAPane = new AnchorPane();
        Label owner = new Label(), contents = new Label(), titulo = new Label(), fecha = new Label();
        Label origin = new Label();
        double offset = 10.0;
        double anchorPanesHeight = this.paneVerticalPreguntas.getPrefHeight() / this.noPreguntasMaxXPagina;
        double anchorPanesWidth = this.paneVerticalPreguntas.getPrefWidth();
        
        owner.setText(miUsername); //El usuario que le pertenece
        contents.setText(miDescripcion);
        titulo.setText(miTitulo);
        fecha.setText(miFecha);
        origin.setText(miOrigin);
        contents.setPrefWidth(anchorPanesWidth - offset);
        contents.setPrefHeight(anchorPanesHeight - offset);
        contents.setFont(new Font(20)); 
        contents.setWrapText(true);
        AnchorPane.setTopAnchor(contents, (anchorPanesHeight / 2)- offset);
        AnchorPane.setLeftAnchor(contents, offset);
        localAPane.getChildren().add(contents);
        return localAPane;
            
            
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        ArrayList<Publicacion> listaTotal;
        setUpImages(); 
        //initializa preguntas:
        ControladorPublicacion controladorLocal = new ControladorPublicacion();
        controladorLocal.descargarDatos();
        listaTotal = controladorLocal.getPublicaciones();
        this.misPreguntas = searchPreguntas(listaTotal); //Encuentro mis preguntas para usar.
        handlePreguntasInit();
        //setUsuarioImage();
        //Pass pagina TODO y Respuestas TODO.
        
    }
    
    public void setUsuario(Usuario miUsuario)
    {
        this.usuarioLogeado = miUsuario;
    }
    private void setUsuarioImage()
    {
        Image miImagen;
        try{
        miImagen = new Image (this.usuarioLogeado.getFoto().getPath());
        this.imagenUsuario.setImage(miImagen);
        }
        catch(IllegalArgumentException e)
        {
            miImagen = new Image("imagenes/perfil.png");
            this.imagenUsuario.setImage(miImagen);
        }
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
    private ArrayList<Pregunta> searchPreguntas(ArrayList<Publicacion> listaTotal)
    {
        ArrayList<Pregunta> preguntasLocales = new ArrayList<>();
        if (! listaTotal.isEmpty())
        {
            for (Publicacion p : listaTotal)
            {
                if (p instanceof Pregunta)
                {
                    preguntasLocales.add((Pregunta)p);
                }
            }
        }
        return preguntasLocales;
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
