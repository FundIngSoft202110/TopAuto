package com.topauto.capapresentacion;

import com.topauto.capaentidades.Imagen;
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
import com.topauto.capaentidades.Pais;
import com.topauto.capanegocio.ControladorPerfil;
import java.io.File;
import static java.lang.Math.abs;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

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
    private Button butPreguntas, btnAceptar, btnEditar, btnCambioContrasenia;
    @FXML
    private Button butResenias;
    @FXML
    private AnchorPane countries;
    @FXML
    private Button cambiarFotoPerfil;
    @FXML
    private ImageView imagenUsuario;
    @FXML
    private ImageView imagenUsuario2;
    @FXML
    private Text textoNombreUsuario;
    // -- Editable text fields of Usuario
    @FXML
    private TextField labelNombreUsuario;
    @FXML
    private TextField labelNombre;
    @FXML
    private TextField labelPais;
    @FXML
    private TextField labelNoResenias;
    @FXML
    private TextField labelNoPreguntas;
    @FXML
    private Label labelAcceptC, labelDenyC, labelDenyC1;
    @FXML
    private TextArea descripcion;
    @FXML
    private TextField contraseniaActual;
    @FXML
    private TextField contraseniaNuevo;
    @FXML
    private AnchorPane parentContrasenia;
    @FXML
    private SplitPane paneGeneral;
    @FXML
    private AnchorPane panelPagina, panelPaginaPrev;
    
    private ControladorPerfil controladorPerfil = new ControladorPerfil();
    private ControladorPublicacion controladorPub = new ControladorPublicacion();
    private Button sig,prev;
    private Usuario usuarioLogeado = new Usuario();
    ArrayList<Publicacion> misPublicaciones = new ArrayList<>();
    ArrayList<Pregunta> misPreguntas = new ArrayList<>();
    int datosXPane = 2, numChangeMax = datosXPane, numChangeMaxP = datosXPane;
    int minPreg = 0, maxPreg = datosXPane;
    int minPub = 0, maxPub = datosXPane;
    //HANDLERS:
    EventHandler <ActionEvent> HandlerEraseElement, HandlerEditElement;
    EventHandler<ActionEvent> HandlerTurnNext, HandlerTurnBack;
    ArrayList<structPregButton> listCurrQuestionsDelete = new ArrayList<>();
    ArrayList<structResButton> listCurrPubsDelete = new ArrayList<>();
    ArrayList<structPregButton> listCurrQuestionsEdit = new ArrayList<>();
    ArrayList<structResButton> listCurrPubsEdit = new ArrayList<>();
    boolean isPreguntaOpen = false, hitNextPage = false, hitLastPage = false;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        changeAllLabels(false);
        this.cambiarFotoPerfil.setVisible(false);
        this.cambiarFotoPerfil.setDisable(true);
        controladorPerfil.descargarDatos();
        controladorPub.descargarDatos();
        resetCamps();
        this.HandlerEraseElement = new EventHandler<ActionEvent>()
             {
                 @Override
                 public void handle (ActionEvent event)
                 {
                     deleteElement((Button)event.getSource());
                 }
             };
        this.HandlerEditElement = new EventHandler<ActionEvent>()
             {
                 @Override
                 public void handle (ActionEvent event)
                 {
                     editElement((Button)event.getSource());
                 }
             };
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
    private void setPreguntas(ActionEvent event)
    {
         showPreguntasOnScreen();

    }
    @FXML private void setPublicaciones (ActionEvent event){
        showPubsOnScreen();
    }
    private boolean getPreguntaOn()
    {
        return this.isPreguntaOpen;
    }
    private void showPreguntasOnScreen()
    {
        this.listCurrQuestionsDelete.clear();
        this.paneGeneral.getItems().clear();
        panelPagina.getChildren().clear();
        panelPaginaPrev.getChildren().clear();
        double anchorPanesHeight = this.paneGeneral.getPrefHeight() / this.datosXPane+1;
        boolean prevActivo = false, sigActivo = false;
        double anchorPanesWidth = this.paneGeneral.getPrefWidth();
         int localDatXPane = this.datosXPane;
         this.isPreguntaOpen = true;
         changeAllLabels(false);
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
            structPregButton localStructD = new structPregButton();
            
            if (p instanceof PRrelacionada)
            {
                miOrigin = ((PRrelacionada)p).getVehiculo().getModelo();
            }
            else
            {
                miOrigin = "General";
            }
            localAPane = setUpAnchorPane( p.getPropietario().getUserName(), p.getDescripcion(), p.getTitulo(),
                    p.getFecha().toString(), miOrigin, contador);
            //Button DELETE is on location 4, Button EDIT is on location 5
            localStructD.preguntas = p;
            localStructD.miButton = (Button)localAPane.getChildren().get(4);
            this.listCurrQuestionsDelete.add(localStructD);
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
             owner.setText("Este Usuario no Tiene Preguntas!");
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
        this.listCurrPubsDelete.clear();
        panelPagina.getChildren().clear();
        panelPaginaPrev.getChildren().clear();
        this.paneGeneral.getItems().clear();
        int localDatXPane = this.datosXPane;
        double anchorPanesHeight = this.paneGeneral.getPrefHeight() / this.datosXPane;
        boolean prevActivo = false, sigActivo = false;
        double anchorPanesWidth = this.paneGeneral.getPrefWidth();
         this.isPreguntaOpen = false;
         changeAllLabels(false);
         
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
         for (Publicacion p : misPublicaciones.subList(minPub, maxPub))
         {
            structResButton localStructD = new structResButton();
            
            
            miOrigin = "Reseña";
            
            localAPane = setUpAnchorPane( p.getPropietario().getUserName(), p.getDescripcion(), p.getTitulo(),
                    p.getFecha().toString(), miOrigin, contador);
            //Button DELETE is on location 4, Button EDIT is on location 5
            localStructD.pub = p;
            localStructD.miButton = (Button)localAPane.getChildren().get(4);
            this.listCurrPubsDelete.add(localStructD);
            //Add my elements to the structures for easy comparison ^^
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
     private AnchorPane setUpAnchorPane(String miUsername, String miDescripcion, String miTitulo, String miFecha, String miOrigin, int contador)
    {
        AnchorPane localAPane = new AnchorPane();
        
        Label owner = new Label(), contents = new Label(), titulo = new Label();
        Label origin = new Label();
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
        contents.setPrefHeight(anchorPanesHeight/2 - offset + offset*7);
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
        
        //Delete Button
        Button delete = new Button();
        delete.setText("X");
        delete.setStyle("-fx-background-color: #CB3234"); //Set RED
        delete.setOnAction(this.HandlerEraseElement);
        delete.setFont(new Font(15));
        delete.setPrefSize(20, 20);
        delete.setId(String.valueOf(contador)); //Set ID
        AnchorPane.setTopAnchor(delete,offset);
        AnchorPane.setRightAnchor(delete, offset);

        
        
        localAPane.getChildren().addAll(origin, titulo, contents, owner, delete);
        return localAPane;
            
            
    }
    /**
     * 
     * @param isTrue If the labels should be turn on
     */
    private void changeAllLabels(boolean isTrue)
    {
        this.labelAcceptC.setVisible(isTrue);
        this.labelDenyC.setVisible(isTrue);
        this.labelDenyC1.setVisible(isTrue);

    }
    private void resetCamps()
    {
        //Block Fields so you can't edit them:
        descripcion.setEditable(false);
        descripcion.setStyle("-fx-background-color: #FFFFFF");
        this.labelNoPreguntas.setEditable(false);
        this.labelNoPreguntas.setStyle("-fx-background-color: #FFFFFF");
        this.labelNoResenias.setEditable(false);
        this.labelNoResenias.setStyle("-fx-background-color: #FFFFFF");
        this.labelNombreUsuario.setEditable(false);
        this.labelNombreUsuario.setStyle("-fx-background-color: #FFFFFF");
        this.labelNombre.setEditable(false);
        this.labelNombre.setStyle("-fx-background-color: #FFFFFF");
        this.labelPais.setEditable(false);
        this.labelPais.setStyle("-fx-background-color: #FFFFFF");
        // -------------------------------------
        // Adjust buttons to match a non-Edit view:
        this.btnAceptar.setDisable(true);
        this.btnAceptar.setVisible(false);
        this.btnCambioContrasenia.setDisable(true);
        this.btnCambioContrasenia.setVisible(false);
        this.btnEditar.setDisable(false);
        this.btnEditar.setVisible(true);
        // -------------------------------------
        // Make it so the Change Password fields are not visible or usable:
        this.parentContrasenia.setVisible(false);
        this.parentContrasenia.setDisable(true);
        // -------------------------------------
    }
    private void makeEditableCamps()
    {
        //Make it so you can write in fields:
        descripcion.setEditable(true);
        descripcion.setStyle(null);
        this.labelNombreUsuario.setEditable(true);
        this.labelNombreUsuario.setStyle(null);
        this.labelNombre.setEditable(true);
        this.labelNombre.setStyle(null);
        this.labelPais.setEditable(true);
        this.labelPais.setStyle(null);
        // -------------------------------------
        
        this.btnAceptar.setDisable(false);
        this.btnAceptar.setVisible(true);
        this.btnCambioContrasenia.setDisable(false);
        this.btnCambioContrasenia.setVisible(true);
        this.btnEditar.setDisable(true);
        this.btnEditar.setVisible(false);
    }
    
    @FXML
    private void editCamps(ActionEvent event)
    {
        
        makeEditableCamps();
        changeAllLabels(false);
    }
    @FXML
    private void acceptChanges(ActionEvent event)
    {
        //save values to database.
        //if could:
        saveTextFieldValuesToDB();
         
         resetCamps();

    }
    private void activateNextPage()
    {
        hitNextPage = true;
    }
    private void activateLastPage()
    {
        hitLastPage = true;
    }
    @FXML
    private void makeContraseniaEditable (ActionEvent event)
    {
        this.btnCambioContrasenia.setDisable(true);
        this.btnCambioContrasenia.setVisible(false); //Deactivate this button!
        
        this.parentContrasenia.setVisible(true);
        this.parentContrasenia.setDisable(false);
        
        
    }
    private boolean saveTextFieldValuesToDB()
    {
        // FALTA CORREO
        boolean isValid, cambioContrasenia = false;
        // Check for blank spaces or valid password or username
        if (!this.labelNombre.getText().isEmpty() && !this.labelNombreUsuario.getText().isEmpty() && !this.labelPais.getText().isEmpty())
        {
            if (this.parentContrasenia.isVisible())
            {
                if(this.contraseniaActual.getText().isEmpty() && this.contraseniaNuevo.getText().isEmpty())
                {
                    isValid = false;
                    this.labelDenyC1.setVisible(true);
                }
                else
                {
                    if (this.contraseniaActual.getText().equals(this.usuarioLogeado.getContrasenia()))
                    {
                        if(this.contraseniaNuevo.getText().length() > 4)
                        {
                            if (!this.contraseniaNuevo.getText().contains(" ") || !this.contraseniaNuevo.getText().contains("\n") || !this.contraseniaNuevo.getText().contains("\t"))
                            {
                                isValid = true;
                                cambioContrasenia = true;
                            }
                            else
                            {
                                isValid = false;
                                this.labelDenyC.setVisible(true);
                            }
                        }
                        else
                        {
                            isValid = false;
                            this.labelDenyC.setVisible(true);
                        }
                        
                    }
                    else
                    {
                        isValid = false;
                        this.labelDenyC.setVisible(true);
                    }
                }
            }
            else if(searchValidUsername(this.labelNombreUsuario.getText()))
            {
                isValid = true;
                
            }
            else
            {
                isValid = false;
                this.labelDenyC1.setVisible(true);
            }
        }
        else
        {
            isValid = false;
            this.labelDenyC1.setVisible(true);
        }
        
        if (isValid == true)
        {
            this.usuarioLogeado.setUserName(this.labelNombreUsuario.getText());
            if (!this.labelPais.getText().equals(this.usuarioLogeado.getPais().getNombre()))
            {
            this.usuarioLogeado.setPais(new Pais (this.labelPais.getText()));
            }
            this.usuarioLogeado.setDescripcion(descripcion.getText());
            this.usuarioLogeado.setNombre(this.labelNombre.getText());
            if (cambioContrasenia == true)
            {
                this.usuarioLogeado.setContrasenia(this.contraseniaNuevo.getText());
            }
            this.controladorPerfil.modificarPerfil(usuarioLogeado);  
            this.labelAcceptC.setVisible(true);
            
        }
        this.contraseniaNuevo.clear();
        this.contraseniaActual.clear();
        return isValid;
    
    }
    private boolean searchValidUsername(String toComp)
    {
        boolean answer = true;
        for (Usuario f : this.controladorPerfil.getUsuarios())
        {
            if (f.getUserName().equals(toComp))
            {
                answer = false;
            }
        }
        if (toComp.contains(" ") || toComp.contains("\n") || toComp.contains("\t"))
        {
            answer = false;
        }
        if (toComp.equals(this.usuarioLogeado.getUserName())) //if username wasn't changed.
        {
            answer = true;
        }
        return answer;
    }
    private void deleteElement(Button button)
    {

        if (isPreguntaOpen)
        {
            for ( structPregButton p : this.listCurrQuestionsDelete)
            {
                if (p.miButton.getId().equals(button.getId()))
                {
                    System.out.print("va a borrar: "+ p.preguntas.getId() + " \n");
                    this.usuarioLogeado.getPublicaciones().remove(p.preguntas);
                    this.controladorPub.borrarPublicacion(p.preguntas.getId());
                    break;
                }
            }
             setUsuarioImage();
             if (minPreg>0)
             {
                 minPreg = 0;
                 maxPreg = this.datosXPane;
                 numChangeMax = this.datosXPane;
             }
            
            showPreguntasOnScreen();

        }
        else
        {
            for ( structResButton p : this.listCurrPubsDelete)
            {
                if (p.miButton.getId().equals(button.getId()))
                {

                    this.usuarioLogeado.getPublicaciones().remove(p.pub);
                    this.controladorPub.borrarPublicacion(p.pub.getId());
                    break;
                }
            }
              setUsuarioImage();
             if (minPub>0)
             {
                 minPub = 0;
                 maxPub = this.datosXPane;
                 numChangeMaxP = this.datosXPane;
             }
            
            showPubsOnScreen();
        }
       
        
        
        
    }
    private void editElement(Button button)
    {
        button.setText("OK");
    }
    
    @FXML
    private void changeFoto(ActionEvent event) throws IOException
    {
        Imagen image = new Imagen();
        Stage stage = new Stage();
        FileChooser directoryChooser = new FileChooser();
        File selectedDirectory = directoryChooser.showOpenDialog(stage);
        Path target;
        String name;

        if(selectedDirectory == null){
          //No Directory selected
        }else{
            if (selectedDirectory.getAbsolutePath().contains(".jpg") || selectedDirectory.getAbsolutePath().contains(".JPG") || selectedDirectory.getAbsolutePath().contains(".png"))
            {
                Path resourceDirectory = Paths.get("src","main","resources","imagenes","fotosperfil");
                 String absolutePath = resourceDirectory.toFile().getAbsolutePath();

                 System.out.println(absolutePath + '\n');
                 
        Path targetDir = Paths.get(absolutePath);
        Path sourceDir = Paths.get(selectedDirectory.getAbsolutePath());
        if (selectedDirectory.getAbsolutePath().contains(".jpg"))
        {
        target = targetDir.resolve(this.usuarioLogeado.getUserName()+".jpg");
        name = this.usuarioLogeado.getUserName()+".jpg";
        }
        else if (selectedDirectory.getAbsolutePath().contains(".JPG"))
        {
        target = targetDir.resolve(this.usuarioLogeado.getUserName()+".JPG");  
        name = this.usuarioLogeado.getUserName()+".JPG";
        }
        else{
        target = targetDir.resolve(this.usuarioLogeado.getUserName()+".png");  
        name = this.usuarioLogeado.getUserName()+".png";
        }
        Files.copy(sourceDir, target, StandardCopyOption.REPLACE_EXISTING);
        
        image.setPath("imagenes/fotosperfil/"+name);
        System.out.print(image.getPath()+'\n');
        this.usuarioLogeado.setFoto(image);
        this.controladorPerfil.modificarPerfil(usuarioLogeado);
        
        setUsuarioImage();
            }
            else
            {
                System.out.print("Tipo de Archivo Invalido");
            }
        }
        

        
        
    }
     
    public void setUsuario(Usuario miUsuario)
    {
        this.usuarioLogeado = miUsuario;
        setUsuarioImage();
    }
    private void setUsuarioImage()
    {
        this.misPreguntas.clear();
        this.misPublicaciones.clear();
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
        this.labelNombre.setText(this.usuarioLogeado.getNombre());
        this.labelPais.setText(this.usuarioLogeado.getPais().getNombre());
        this.descripcion.setText(this.usuarioLogeado.getDescripcion());
        misPub = this.usuarioLogeado.getPublicaciones();
        for (Publicacion p : misPub)
        {
            if ( p instanceof Pregunta)
            {
                misPregN++;
                this.misPreguntas.add((Pregunta)p);
            }
            else if (p instanceof Publicacion)
            {
                misPublicaciones.add(p);
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
