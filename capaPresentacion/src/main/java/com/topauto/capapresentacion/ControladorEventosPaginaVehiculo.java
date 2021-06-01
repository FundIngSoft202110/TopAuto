package com.topauto.capapresentacion;

import com.topauto.capaentidades.Usuario;
import com.topauto.capaentidades.Imagen;
import com.topauto.capaentidades.PRrelacionada;
import com.topauto.capaentidades.Pregunta;
import com.topauto.capaentidades.Publicacion;
import com.topauto.capaentidades.Resenia;
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
import com.topauto.capanegocio.ControladorPerfil;
import com.topauto.capanegocio.ControladorPublicacion;
import static java.lang.Math.abs;
import java.net.URISyntaxException;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
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
    @FXML
    private SplitPane paneGeneral;
    @FXML
    private AnchorPane panelPagina, panelPaginaPrev;
    private ControladorPublicacion controladorPub = new ControladorPublicacion();
    private Button sig,prev;
    int datosXPane = 2, numChangeMax = datosXPane, numChangeMaxP = datosXPane;
    int minPreg = 0, maxPreg = datosXPane;
    int minPub = 0, maxPub = datosXPane;
    EventHandler<ActionEvent> HandlerTurnNext, HandlerTurnBack;
    boolean isPreguntaOpen = false, hitNextPage = false, hitLastPage = false;
    ArrayList<Resenia> misPublicaciones = new ArrayList<>();
    ArrayList<PRrelacionada> misPreguntas = new ArrayList<>();
    

    //////////////////////////////////////////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Obtener data de controladores y guardar las indicadas en variables locales:
        
        this.HandlerTurnNext = new EventHandler<ActionEvent>()
             {
                 @Override
                 public void handle (ActionEvent event)
                 {
                     activateNextPage();
                     if (getPreguntaOn())
                {
                    showPreguntasOnScreen(); 
                }
                     else
                {
                    showPubsOnScreen();
                }
                         
                     
                 }
             };
        this.HandlerTurnBack = new EventHandler<ActionEvent>()
             {
                 @Override
                 public void handle (ActionEvent event)
                 {
                     activateLastPage();
                     
                     if (getPreguntaOn())
                {
                    showPreguntasOnScreen(); 
                }
                     else
                {
                    showPubsOnScreen();
                }
                 }
                 
             };
        
        
    }
    @FXML
    private void btnPreguntas(ActionEvent event) {
          showPreguntasOnScreen();
    }

    @FXML
    private void btnReseñas(ActionEvent event) {
        showPubsOnScreen();
    }
    private boolean getPreguntaOn()
    {
        return this.isPreguntaOpen;
    }
    private void showPreguntasOnScreen()
    {
        
        this.paneGeneral.getItems().clear();
        panelPagina.getChildren().clear();
        panelPaginaPrev.getChildren().clear();
        double anchorPanesHeight = this.paneGeneral.getPrefHeight() / this.datosXPane+1;
        boolean prevActivo = false, sigActivo = false;
        double anchorPanesWidth = this.paneGeneral.getPrefWidth();
         int localDatXPane = this.datosXPane;
         this.isPreguntaOpen = true;
         this.paneGeneral.getItems().clear();
         float incrementPerDivision = 1.0f / (float) this.datosXPane+1;
         String miOrigin;
         AnchorPane localAPane;
         int contador = 0;
         
         if (this.hitNextPage == true)
        {
            minPreg += datosXPane;
            maxPreg += numChangeMax;
        }
        else if (this.hitLastPage == true)
        {
            minPreg -= datosXPane;
            maxPreg -= numChangeMax;
            numChangeMax = datosXPane;
        }
        //If the boundary surpasses the array size of comments, equal the boundary to the array size.
        //This could happen only if hitNextPage is triggered.
        if (misPreguntas.size() < maxPreg && hitNextPage == true)
        {
            this.numChangeMax = abs(misPreguntas.size() - (maxPreg - datosXPane));
            maxPreg = misPreguntas.size();
            
        }
        else if (misPreguntas.size() < maxPreg)
        {
            maxPreg = misPreguntas.size(); //Bad case scenario...
        }
         
        
         if (!this.misPreguntas.isEmpty())
         {
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
                    p.getFecha().toString(), miOrigin, contador, "");
            //Button DELETE is on location 4, Button EDIT is on location 5

            //Add my elements to the structures for easy comparison ^^

            this.paneGeneral.getItems().add(localAPane);
            this.paneGeneral.setDividerPosition(contador, (float)contador * incrementPerDivision);
            contador++; 
             localDatXPane --;
        }
         }
         else
         {
             
             localAPane = new AnchorPane();
             localAPane.setPrefSize(anchorPanesWidth, anchorPanesHeight);
             Label owner = new Label();
             owner.setText("Este Vehiculo no Tiene Preguntas!");
             owner.setFont(new Font(40));
             owner.setPrefSize(this.paneGeneral.getPrefWidth()-10.0, 60);
             AnchorPane.setTopAnchor(owner, 10.0);
             AnchorPane.setLeftAnchor(owner, 10.0);
             localAPane.getChildren().add(owner);
             this.paneGeneral.getItems().add(localAPane);
             this.paneGeneral.setDividerPosition(0, 0);
             localDatXPane --;
             
         }
         contador = this.datosXPane-localDatXPane;
         if (localDatXPane > 0)
         {
             for (int i = localDatXPane; i>0;i--)
             {
                 localAPane = new AnchorPane();
                 localAPane.setPrefSize(anchorPanesWidth, anchorPanesHeight);
                 this.paneGeneral.getItems().add(localAPane);
                 this.paneGeneral.setDividerPosition(contador, (float)contador * incrementPerDivision);
                 contador++;
             }
         }
         //Reset activation of buttons:
        if (misPreguntas.size() > maxPreg)
        {
            sigActivo = true;
        }
        if (minPreg > 0)
        {
            prevActivo = true;
        }
        hitNextPage = false;
        hitLastPage = false;
        createButtonsPagina (sigActivo, prevActivo);
 
    }
    
     private void showPubsOnScreen()
    {
        panelPagina.getChildren().clear();
        panelPaginaPrev.getChildren().clear();
        this.paneGeneral.getItems().clear();
        int localDatXPane = this.datosXPane;
        double anchorPanesHeight = this.paneGeneral.getPrefHeight() / this.datosXPane;
        boolean prevActivo = false, sigActivo = false;
        double anchorPanesWidth = this.paneGeneral.getPrefWidth();
         this.isPreguntaOpen = false;
         
         float incrementPerDivision = 1.0f / (float) this.datosXPane;
         String miOrigin;
         AnchorPane localAPane;
         int contador = 0;
          if (this.hitNextPage == true)
        {
            minPub += datosXPane;
            maxPub += numChangeMaxP;
        }
        else if (this.hitLastPage == true)
        {
            minPub -= datosXPane;
            maxPub -= numChangeMaxP;
            numChangeMaxP = datosXPane;
        }
        //If the boundary surpasses the array size of comments, equal the boundary to the array size.
        //This could happen only if hitNextPage is triggered.
        if (misPublicaciones.size() < maxPub && hitNextPage == true)
        {
            this.numChangeMaxP = abs(misPublicaciones.size() - (maxPub - datosXPane));
            maxPub = misPublicaciones.size();
            
        }
        else if (misPublicaciones.size() < maxPub)
        {
            maxPub = misPublicaciones.size(); //Bad case scenario...
        }
         if (!this.misPublicaciones.isEmpty())
         {
         for (Resenia p : misPublicaciones.subList(minPub, maxPub))
         {

            
            miOrigin = "Reseña";
            
            localAPane = setUpAnchorPane( p.getPropietario().getUserName(), p.getDescripcion(), p.getTitulo(),
                    p.getFecha().toString(), miOrigin, contador, String.valueOf(p.getPuntuacion()));
            this.paneGeneral.getItems().add(localAPane);
            this.paneGeneral.setDividerPosition(contador, (float)contador * incrementPerDivision);
            contador++; 
            localDatXPane --;
         }
         }
         else
         {
             System.out.print("Entra acá a Nada\n");
             localAPane = new AnchorPane();
             localAPane.setPrefSize(anchorPanesWidth, anchorPanesHeight);
             Label owner = new Label();
             owner.setText("Este Usuario no Tiene Reseñas!");
             owner.setFont(new Font(40));
             owner.setPrefSize(this.paneGeneral.getPrefWidth()-10.0, 60);
             AnchorPane.setTopAnchor(owner, 10.0);
             AnchorPane.setLeftAnchor(owner, 10.0);
             localAPane.getChildren().add(owner);
             this.paneGeneral.getItems().add(localAPane);
             this.paneGeneral.setDividerPosition(0, 0);
             localDatXPane --;
             
         }
         
         if (localDatXPane > 0)
         {
            contador = this.datosXPane-localDatXPane;
             for (int i = localDatXPane; i>0;i--)
             {
                 
                 localAPane = new AnchorPane();
                 localAPane.setPrefSize(anchorPanesWidth, anchorPanesHeight);
                 this.paneGeneral.getItems().add(localAPane);
                 this.paneGeneral.setDividerPosition(contador, (float)contador * incrementPerDivision);
                 contador++;
             }
         }
         //Reset activation of buttons:
        if (misPublicaciones.size() > maxPub)
        {
            sigActivo = true;
        }
        if (minPub > 0)
        {
            prevActivo = true;
        }
        hitNextPage = false;
        hitLastPage = false;
        createButtonsPagina (sigActivo, prevActivo);
        
    }
      private void createButtonsPagina (boolean isSigTrue, boolean isPrevTrue)
    {
        panelPagina.getChildren().clear();
        panelPaginaPrev.getChildren().clear();
        
       if ( isSigTrue == true)
        {
            
            sig = new Button();
            sig.setText("Sig. Pagina");
            sig.setStyle("-fx-background-color: #DFDFE5"); //White-ish Gray
            sig.setPrefSize(100, 40);
            sig.setFont(new Font(15));
            sig.setOnAction(this.HandlerTurnNext);
            AnchorPane.setTopAnchor(sig, 0.0);
            AnchorPane.setLeftAnchor(sig,0.0);
            this.panelPagina.getChildren().add(sig);
        }
        if (isPrevTrue==true)
        {
            prev = new Button();
            prev.setText("Prev. Pagina");
            prev.setStyle("-fx-background-color: #DFDFE5"); //White-ish Gray
            prev.setPrefSize(100, 40);
            prev.setFont(new Font(15));
            prev.setOnAction(this.HandlerTurnBack);
            AnchorPane.setTopAnchor(prev, 0.0);
            AnchorPane.setLeftAnchor(prev,0.0);
            this.panelPaginaPrev.getChildren().add(prev);
        }
    }
      
      private AnchorPane setUpAnchorPane(String miUsername, String miDescripcion, String miTitulo, String miFecha, String miOrigin, int contador, String puntaje)
    {
        AnchorPane localAPane = new AnchorPane();
        
        Label owner = new Label(), contents = new Label(), titulo = new Label();
        Label origin = new Label(), puntajeMio = new Label();
        double offset = 10.0;
        double anchorPanesHeight = this.paneGeneral.getPrefHeight() / this.datosXPane;
        double anchorPanesWidth = this.paneGeneral.getPrefWidth();
        localAPane.setPrefSize(anchorPanesWidth, anchorPanesHeight);
        owner.setText("By " + miUsername + " - " + miFecha); //El usuario que le pertenece
        contents.setText(miDescripcion);
        titulo.setText(miTitulo);
        origin.setText(miOrigin);
        
        //Contenido - MiddeWay:
        contents.setPrefWidth(anchorPanesWidth - offset);
        contents.setPrefHeight(anchorPanesHeight/2 - offset + offset*9);
        contents.setFont(new Font(15)); 
        contents.setWrapText(true);
        AnchorPane.setTopAnchor(contents, ((anchorPanesHeight / 2)- offset*6)/3);
        AnchorPane.setLeftAnchor(contents, offset);
        
        // Owner y Fecha - Bottom Middle
        owner.setPrefWidth(anchorPanesWidth);
        owner.setPrefHeight(20);
        owner.setFont(new Font(14)); 
        owner.setWrapText(false);
        AnchorPane.setBottomAnchor(owner, 25.0);
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
        if (!this.getPreguntaOn())
        {
            puntajeMio.setText(puntaje+"/10");
            puntajeMio.setPrefWidth(90);
            puntajeMio.setPrefHeight(20);
            puntajeMio.setFont(new Font(15)); 
            puntajeMio.setWrapText(true);
            AnchorPane.setTopAnchor(puntajeMio, 0.0);
            AnchorPane.setRightAnchor(puntajeMio, 0.0);
        }
        else
        {
             puntajeMio.setText("");
        }
       

        
        
        localAPane.getChildren().addAll(origin, titulo, contents, owner, puntajeMio);
        return localAPane;
            
            
    }
      private void activateNextPage()
    {
        hitNextPage = true;
    }
    private void activateLastPage()
    {
        hitLastPage = true;
    }
    public void setVehiculo(Vehiculo miVehiculo)
    {
        this.vehiculoCargar = miVehiculo;
        setCarVehiculo();
        
    }
    private void setCarVehiculo ()
    {
        controladorPub.descargarDatos();
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
        
        for (Publicacion p : controladorPub.getPublicaciones())
        {
            if (p instanceof PRrelacionada)
            {
                if (((PRrelacionada) p).getVehiculo().getId().equals(this.vehiculoCargar.getId()))
                {
                    misPreguntas.add((PRrelacionada)p);
                }
            }
            else if (p instanceof Resenia)
            {
                if (((Resenia) p).getVehiculo().getId().equals(this.vehiculoCargar.getId()))
                {
                    misPublicaciones.add((Resenia)p);
                }
            }
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
