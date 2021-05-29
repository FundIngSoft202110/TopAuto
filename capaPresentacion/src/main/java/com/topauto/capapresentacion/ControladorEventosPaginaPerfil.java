package com.topauto.capapresentacion;

import com.topauto.capaentidades.Pregunta;
import com.topauto.capaentidades.Publicacion;
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
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import com.topauto.capanegocio.ControladorPublicacion;
import com.topauto.capaentidades.Publicacion;
import com.topauto.capaentidades.Pregunta;
import com.topauto.capaentidades.PRrelacionada;
import javafx.scene.text.Font;

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
    private Button butPreguntas;
    @FXML
    private Button butResenias;
    @FXML
    private AnchorPane countries;
    @FXML
    private ImageView imagenUsuario;
    @FXML
    private ImageView imagenUsuario2;
    @FXML
    private Text textoNombreUsuario;
    @FXML
    private Label labelNombreUsuario;
    @FXML
    private Label labelNombre;
    @FXML
    private Label labelPais;
    @FXML
    private Label labelNoResenias;
    @FXML
    private Label labelNoPreguntas;
    @FXML
    private TextArea descripcion;
    @FXML
    private SplitPane paneGeneral;
    private Usuario usuarioLogeado = new Usuario();
    ArrayList<Publicacion> misPublicaciones = new ArrayList<>();
    ArrayList<Pregunta> misPreguntas = new ArrayList<>();
    int datosXPane = 4;
    int minPreg = 0, maxPreg = datosXPane;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    } 
    @FXML
    private void setPreguntas(ActionEvent event)
    {
         this.paneGeneral.getItems().clear();
         float incrementPerDivision = 1.0f / (float) this.datosXPane;
         String miOrigin;
         AnchorPane localAPane;
         int contador = 0;
         if ( misPreguntas.size()< maxPreg) maxPreg = misPreguntas.size();
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

            this.paneGeneral.getItems().add(localAPane);
            this.paneGeneral.setDividerPosition(contador, (float)contador * incrementPerDivision);
            contador++; 
        }
         
    }
     private AnchorPane setUpAnchorPane(String miUsername, String miDescripcion, String miTitulo, String miFecha, String miOrigin)
    {
        AnchorPane localAPane = new AnchorPane();
        Label owner = new Label(), contents = new Label(), titulo = new Label();
        Label origin = new Label();
        double offset = 10.0;
        double anchorPanesHeight = this.paneGeneral.getPrefHeight() / this.datosXPane;
        double anchorPanesWidth = this.paneGeneral.getPrefWidth();
        
        owner.setText("By " + miUsername + " - " + miFecha); //El usuario que le pertenece
        contents.setText(miDescripcion);
        titulo.setText(miTitulo);
        origin.setText(miOrigin);
        //Contenido - MiddeWay:
        contents.setPrefWidth(anchorPanesWidth - offset);
        contents.setPrefHeight(anchorPanesHeight - offset);
        contents.setFont(new Font(15)); 
        contents.setWrapText(true);
        AnchorPane.setTopAnchor(contents, (anchorPanesHeight / 2)- offset*3);
        AnchorPane.setLeftAnchor(contents, offset);
        
        // Owner y Fecha - Bottom Middle
        owner.setPrefWidth(anchorPanesWidth);
        owner.setPrefHeight(20);
        owner.setFont(new Font(14)); 
        owner.setWrapText(false);
        AnchorPane.setBottomAnchor(owner, 0.0);
        AnchorPane.setLeftAnchor(owner, 0.0);
        
        //Origen - Top Corner:
        origin.setPrefWidth(anchorPanesWidth - offset);
        origin.setPrefHeight(20);
        origin.setFont(new Font(15)); 
        origin.setWrapText(true);
        AnchorPane.setTopAnchor(origin, 0.0);
        AnchorPane.setLeftAnchor(origin, 0.0);
        
        //Titulo - Top middle
        titulo.setPrefHeight(20);
        titulo.setPrefWidth((2*anchorPanesWidth)/3);
        titulo.setFont(new Font(15)); 
        titulo.setWrapText(true);
        AnchorPane.setTopAnchor(titulo, 0.0);
        AnchorPane.setLeftAnchor(titulo, anchorPanesWidth/3);
        

        
        
        localAPane.getChildren().addAll(origin, titulo, contents, owner);
        return localAPane;
            
            
    }
     
     
    public void setUsuario(Usuario miUsuario)
    {
        this.usuarioLogeado = miUsuario;
        setUsuarioImage();
    }
    private void setUsuarioImage()
    {
        ArrayList<Publicacion> misPub;
        int misPubN = 0, misPregN = 0;
        Image miImagen;
        try{
        miImagen = new Image (this.usuarioLogeado.getFoto().getPath());
        this.imagenUsuario.setImage(miImagen);
        this.imagenUsuario2.setImage(miImagen);
        }
        catch(IllegalArgumentException e)
        {
            miImagen = new Image("imagenes/perfil.png");
            this.imagenUsuario.setImage(miImagen);
            this.imagenUsuario2.setImage(miImagen);
        }
        this.textoNombreUsuario.setText(
                this.usuarioLogeado.getUserName());
        this.labelNombreUsuario.setText(this.usuarioLogeado.getUserName());
        this.labelPais.setText(this.usuarioLogeado.getPais().getNombre());
        this.descripcion.setText(this.usuarioLogeado.getDescripcion());
        misPub = this.usuarioLogeado.getPublicaciones();
        this.misPublicaciones= this.usuarioLogeado.getPublicaciones();
        for (Publicacion p : misPub)
        {
            if ( p instanceof Pregunta)
            {
                
                misPregN++;
                this.misPreguntas.add((Pregunta)p);
            }
            else
            {
                misPubN++;
            }
        }
        this.labelNoPreguntas.setText(String.valueOf(misPregN));
        this.labelNoResenias.setText(String.valueOf(misPubN));
    }

    @FXML
    private void responder(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaListadoPreguntasScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaListadoPreguntas controlador = loader.getController();
            controlador.setUsuario(usuarioLogeado);
            
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
            controlador.setUsuario(usuarioLogeado);
            
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
            controlador.setUsuario(usuarioLogeado);
            
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
            controlador.setUsuario(usuarioLogeado);
            
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
