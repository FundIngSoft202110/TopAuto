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
import com.topauto.capaentidades.Pais;
import com.topauto.capanegocio.ControladorPerfil;
import javafx.event.EventHandler;
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
    private Button butPreguntas, btnAceptar, btnEditar, btnCambioContrasenia;
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
    
    private ControladorPerfil controladorPerfil = new ControladorPerfil();
    private ControladorPublicacion controladorPub = new ControladorPublicacion();
    private Usuario usuarioLogeado = new Usuario();
    ArrayList<Publicacion> misPublicaciones = new ArrayList<>();
    ArrayList<Pregunta> misPreguntas = new ArrayList<>();
    int datosXPane = 4;
    int minPreg = 0, maxPreg = datosXPane;
    EventHandler <ActionEvent> HandlerEraseElement, HandlerEditElement;
    ArrayList<structPregButton> listCurrQuestionsDelete = new ArrayList<>();
    ArrayList<structResButton> listCurrPubsDelete = new ArrayList<>();
    ArrayList<structPregButton> listCurrQuestionsEdit = new ArrayList<>();
    ArrayList<structResButton> listCurrPubsEdit = new ArrayList<>();
    boolean isPreguntaOpen = false;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        changeAllLabels(false);
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
    } 
    @FXML
    private void setPreguntas(ActionEvent event)
    {
         showPreguntasOnScreen();

    }
    private void showPreguntasOnScreen()
    {
        this.isPreguntaOpen = true;
         changeAllLabels(false);
         this.paneGeneral.getItems().clear();
         float incrementPerDivision = 1.0f / (float) this.datosXPane;
         String miOrigin;
         AnchorPane localAPane;
         int contador = 0;
         if ( misPreguntas.size()< maxPreg) maxPreg = misPreguntas.size();
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
            localStructD.miButton = (Button)localAPane.getChildren().get(5);
            this.listCurrQuestionsEdit.add(localStructD);
            //Add my elements to the structures for easy comparison ^^

            this.paneGeneral.getItems().add(localAPane);
            this.paneGeneral.setDividerPosition(contador, (float)contador * incrementPerDivision);
            contador++; 
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
        
        //Delete Button
        Button delete = new Button();
        delete.setText("X");
        delete.setStyle("-fx-background-color: #CB3234"); //Set RED
        delete.setOnAction(this.HandlerEraseElement);
        delete.setFont(new Font(15));
        delete.setPrefSize(20, 20);
        delete.setId(String.valueOf(contador)); //Set ID
        AnchorPane.setBottomAnchor(delete,0.0);
        AnchorPane.setRightAnchor(delete, offset);
        
        //Edit Button
        Button edit = new Button();
        edit.setText("edit");
        edit.setStyle("-fx-background-color: #00913f"); //GREEN
        edit.setOnAction(HandlerEditElement);
        edit.setFont(new Font(10));
        edit.setPrefSize(50, 20);
        edit.setId(String.valueOf(contador)); //Set ID
        AnchorPane.setTopAnchor(edit, 0.0);
        AnchorPane.setRightAnchor(edit, offset);

        
        
        localAPane.getChildren().addAll(origin, titulo, contents, owner, delete, edit);
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
                    System.out.print("va a borrar: "+ p.preguntas.getTitulo() + " \n");
                    this.controladorPub.borrarPublicacion(p.preguntas.getId());
                }
            }

        }
        else
        {
            for ( structResButton p : this.listCurrPubsDelete)
            {
                if (p.miButton.getId().equals(button.getId()))
                {

                    this.controladorPub.borrarPublicacion(p.pub.getId());
                }
            }
        }
        refreshPubs();
        showPreguntasOnScreen();
    }
    private void editElement(Button button)
    {
        button.setText("OK");
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
    private void refreshPubs()
    {
        this.misPreguntas.clear();
        this.misPublicaciones.clear();
        ArrayList<Publicacion> misPub;
        misPub = this.usuarioLogeado.getPublicaciones();
        for (Publicacion p : misPub)
        {
            if ( p instanceof Pregunta)
            {
                
                this.misPreguntas.add((Pregunta)p);
            }
            else if (p instanceof Publicacion)
            {
                misPublicaciones.add(p);
                
            }
        }
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
