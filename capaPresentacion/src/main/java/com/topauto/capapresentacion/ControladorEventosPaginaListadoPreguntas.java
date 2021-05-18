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
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ControladorEventosPaginaListadoPreguntas implements Initializable {
    
    @FXML
    private Button hazPregunta;
    @FXML
    private Button hazReseña;
    @FXML
    private Button perfil;
    @FXML
    private Button topAuto;
    @FXML
    private AnchorPane paneImagenVehiculos;
    @FXML
    private Text textoNombreUsuario;
    @FXML
    private SplitPane paneVerticalPreguntas;
    @FXML
    private ImageView imagenUsuario;
    @FXML
    private AnchorPane panelPagina;
    
    private final String urlImage = "imagenes/panel_vehiculo_pregunta.png";
    ArrayList<Pregunta> misPreguntas = new ArrayList<>();
    int noPreguntasMaxXPagina = 4;
    int minPreg = 0, maxPreg = noPreguntasMaxXPagina;
     private EventHandler<ActionEvent> HandlerResp;
     private EventHandler<ActionEvent> HandlerTurnPage;
     private Button sig, prev;
    
    private Usuario usuarioLogeado = new Usuario();
    
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
        //Pass pagina TODO y Respuestas TODO.
        this.HandlerResp = new EventHandler<ActionEvent>()
             {
                 @Override
                 public void handle (ActionEvent event)
                 {
                     System.out.println("No Entra aca \n");
                 }
             };
        
        this.HandlerTurnPage = new EventHandler<ActionEvent>()
             {
                 @Override
                 public void handle (ActionEvent event)
                 {
                     System.out.println("Entra aca \n");
                     handleTurnPagePregunta((Button)(event.getSource()));
                 }
             };
        
    }
    private void handleTurnPagePregunta(Button button)
    {
        paneVerticalPreguntas.getItems().clear(); //Clear for reset purposes!
        int noPreguntas = misPreguntas.size();
        int contador = 0;
        boolean willSigPass = false, willPrevPass = false;
        String miOrigin;
        System.out.println("Entra aca bien tambien?\n");
        if (button.getText().equals("Sig. Pagina"))
        {
            
            maxPreg += this.noPreguntasMaxXPagina;
            minPreg += this.noPreguntasMaxXPagina;
        }
        else if (button.getText().equals("Prev. Pagina"))
        {
            maxPreg -= this.noPreguntasMaxXPagina;
            minPreg -= this.noPreguntasMaxXPagina;
        }
        if(minPreg < 0) //Just in case...
        {
            System.out.println("No deberia de entrar aca");
            minPreg = 0;
            maxPreg = this.noPreguntasMaxXPagina;
        }
        
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
        if (noPreguntas > maxPreg)
        {
            willSigPass = true;
        }
        if (minPreg > 0)
        {
            willPrevPass = true;
        }
        createButtonsPagina (willSigPass, willPrevPass);
    }
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
        if (noPreguntas > maxPreg)
        {
            createButtonsPagina ( true ,false);
        }
    }
    /**
     * Creates the buttons for Previous Page and Siguiente Page - Name dependand, do not change it.
     * @param isSigTrue //If it can create Siguiente button, do it
     * @param isPrevTrue // If it can create Last button, do 
     */
    private void createButtonsPagina (boolean isSigTrue, boolean isPrevTrue)
    {
        panelPagina.getChildren().clear();
       if ( isSigTrue)
        {
            
            sig = new Button();
            sig.setText("Sig. Pagina");
            sig.setStyle("-fx-background-color: #DFDFE5"); //White-ish Gray
            sig.setPrefSize(100, 40);
            sig.setFont(new Font(15));
            sig.setOnAction(this.HandlerTurnPage);
            AnchorPane.setTopAnchor(sig, 0.0);
            AnchorPane.setRightAnchor(sig,0.0);
            this.panelPagina.getChildren().add(sig);
        }
        if (isPrevTrue)
        {
            prev = new Button();
            prev.setText("Prev. Pagina");
            prev.setStyle("-fx-background-color: #DFDFE5"); //White-ish Gray
            prev.setPrefSize(100, 40);
            prev.setFont(new Font(15));
            prev.setOnAction(this.HandlerTurnPage);
            AnchorPane.setTopAnchor(prev, 0.0);
            AnchorPane.setLeftAnchor(prev,0.0);
            this.panelPagina.getChildren().add(prev);
        }
    }
    
    private AnchorPane setUpAnchorPane(String miUsername, String miDescripcion, String miTitulo, String miFecha, String miOrigin)
    {
        AnchorPane localAPane = new AnchorPane();
        Label owner = new Label(), contents = new Label(), titulo = new Label();
        Label origin = new Label();
        Button respButton = new Button();
        double offset = 10.0;
        double anchorPanesHeight = this.paneVerticalPreguntas.getPrefHeight() / this.noPreguntasMaxXPagina;
        double anchorPanesWidth = this.paneVerticalPreguntas.getPrefWidth();
        
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
        
        //Titulo - Boton Respuesta 
        respButton.setText("Responder");
        respButton.setStyle("-fx-background-color: #DFDFE5"); //White-ish Gray
        respButton.setPrefSize(100, 40);
        respButton.setFont(new Font(15));
        respButton.setOnAction(HandlerResp);
        AnchorPane.setBottomAnchor(respButton, 0.0);
        AnchorPane.setRightAnchor(respButton,0.0);
        
        
        localAPane.getChildren().addAll(origin, titulo, contents, owner, respButton);
        return localAPane;
            
            
    }
    
    
    
    public void setUsuario(Usuario miUsuario)
    {
        this.usuarioLogeado = miUsuario;
        setUsuarioImage();
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
        this.textoNombreUsuario.setText(this.usuarioLogeado.getUserName());
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
            controlador.setUsuario(this.usuarioLogeado);
            
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
            controlador.setUsuario(this.usuarioLogeado);
            
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
            controlador.setUsuario(this.usuarioLogeado);
            
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
            controlador.setUsuario(this.usuarioLogeado);
            
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