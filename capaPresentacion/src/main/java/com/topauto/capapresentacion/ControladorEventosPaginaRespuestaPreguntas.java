/*
 * AUTHOR:
by: Juan Pablo Amorocho
 */
package com.topauto.capapresentacion;

import com.topauto.capaentidades.Comentario;
import com.topauto.capaentidades.Pregunta;
import com.topauto.capaentidades.Usuario;
import com.topauto.capanegocio.ControladorPublicacion;
import java.io.IOException;
import static java.lang.Math.abs;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class ControladorEventosPaginaRespuestaPreguntas implements Initializable 
    {
    // VARIABLES LOCALES 
    private Usuario miUsuario; //Mi Usuario logueado!
    private Pregunta miPregunta; //Mi pregunta a mostrar
    @FXML
    private Button hazReseña, hazPregunta, resPregunta, perfil, topAuto; //Botones Default de cada Página
    // Control de Ventanas:
    @FXML
    private ScrollPane controlScrollPane;
    @FXML
    private SplitPane controlSplitPane;
    // Labels de la pregunta:
    @FXML
    private Label tituloPregunta, descripcionPregunta, usuarioPregunta, fechaPregunta, upvotes;
    @FXML
    private ImageView upvotePanel;
    @FXML
    private Button upvoteButton;
    @FXML
    private ImageView imagenUsuario;
    @FXML
    private AnchorPane panelPagina, panelPaginaPrev;
    @FXML
    private Text textoNombreUsuario;
    @FXML
    private TextArea areaComment;
    @FXML
    private Button sendComment;
    @FXML
    private Label errorLabel;
    private boolean isUpvoted = false, hitNextPage = false, hitPrevPage = false;
    private ControladorPublicacion miControladorPub;
    private final int comXPag = 2;
    private int noMinPag = 0, noMaxPag = comXPag;
    private int numChangeMax = comXPag;//noMaxPag no puede ser mayor que comXPag
    private Button sig, prev;
    EventHandler<ActionEvent> HandlerTurnNext, HandlerTurnBack;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //Seteo el Viewport de mi ScrollPane:
        miControladorPub = new ControladorPublicacion();
        miControladorPub.descargarDatos();
        Screen screen = Screen.getPrimary(); 
        Rectangle2D bounds = screen.getVisualBounds();
        this.controlScrollPane.setPrefViewportHeight(bounds.getHeight());
        this.controlScrollPane.setPrefViewportWidth(bounds.getWidth());
        errorLabel.setVisible(false);

        this.HandlerTurnNext = new EventHandler<ActionEvent>()
             {
                 @Override
                 public void handle (ActionEvent event)
                 {
                     activateNextPage();
                     ShowComentariosOnScreen();
                 }
             };
        this.HandlerTurnBack = new EventHandler<ActionEvent>()
             {
                 @Override
                 public void handle (ActionEvent event)
                 {
                     activateLastPage();
                     ShowComentariosOnScreen();
                 }
             };
        
        
    }
    /*ShowComentariosOnScreen()
    Shows the comments belonging to miPregunta on the FXML file associated to this controller.
    */
    private void ShowComentariosOnScreen()
    {
        //Start from a clean state... so I reset all the elements in my SplitPane:
        controlSplitPane.getItems().clear();
         panelPagina.getChildren().clear();
        panelPaginaPrev.getChildren().clear();
        
        int sizeComents = miPregunta.getComentarios().size();
        this.errorLabel.setVisible(false);
        AnchorPane localPane;
        double offset = 10.0;
        int contador = 0;
        float incrementPerDivision = 1.0f / (float) comXPag;
        boolean prevActivo = false, sigActivo = false;
        double anchorPaneHeight = this.controlSplitPane.getPrefHeight() / comXPag;
        double anchorPaneWidth = this.controlSplitPane.getPrefWidth();
        /*Checks if the buttons for next page or previous page were triggered. If that is the case...
        Change the minimun and maximum boundaries of the comments shown.*/
        if (this.hitNextPage == true)
        {
            noMinPag += comXPag;
            noMaxPag += numChangeMax;
        }
        else if (this.hitPrevPage == true)
        {
            noMinPag -= comXPag;
            noMaxPag -= numChangeMax;
            numChangeMax = comXPag;
        }
        //If the boundary surpasses the array size of comments, equal the boundary to the array size.
        //This could happen only if hitNextPage is triggered.
        if (sizeComents < noMaxPag && hitNextPage == true)
        {
            this.numChangeMax = abs(sizeComents - (noMaxPag - comXPag));
            noMaxPag = sizeComents;
            
        }
        else if (sizeComents < noMaxPag)
        {
            noMaxPag = sizeComents; //Bad case scenario...
        }
        
        //Comments only have two attributes -> String and the Date Shown ... post those on screen.
        if (!miPregunta.getComentarios().isEmpty())
        {
           System.out.print("Pagina desde ->" + String.valueOf(noMinPag) + " hasta " + String.valueOf(noMaxPag) + "\n");

            //Only show the requiered depending on the page boundaries: noMinPag and noMaxPag
            for (Comentario c : miPregunta.getComentarios().subList(noMinPag, noMaxPag))
            {
                localPane = new AnchorPane();
                localPane.setPrefSize(anchorPaneWidth, anchorPaneHeight);
                Label commentBody = new Label(),commentDate = new Label();
                
                /*Set up dimentions of the Pane -> Depends on how many I want to have in a page.
                Uses comXPag, which is exactly that...only in my height, tho.
                Also depends on the size of the SplitPane I'll put it in!
                */
                
                //Match my elements of the comentaries to the FXML Labels:
                commentBody.setText(c.getDescripcion());
                commentDate.setText(c.getFecha().toString());
                //Customize the properties of my Labels:
                commentBody.setPrefWidth(anchorPaneWidth - offset*2);
                commentBody.setPrefHeight(anchorPaneHeight - offset*2);
                commentBody.setFont(new Font(12)); 
                commentBody.setWrapText(true);
                AnchorPane.setTopAnchor(commentBody,  offset*3);
                AnchorPane.setLeftAnchor(commentBody, offset);
                //---------------------------------------------
                commentDate.setPrefWidth(anchorPaneWidth);
                commentDate.setPrefHeight(10);
                commentDate.setFont(new Font(10)); 
                commentDate.setWrapText(false);
                AnchorPane.setBottomAnchor(commentDate, 20.0);
                AnchorPane.setLeftAnchor(commentDate, 0.0);
                localPane.getChildren().addAll(commentBody,commentDate);
                
                this.controlSplitPane.getItems().add(localPane);
                this.controlSplitPane.setDividerPosition(contador, (float)contador * incrementPerDivision);
                contador++; 

            }
        }
        else
        {
            localPane = new AnchorPane();
            Label commentBody = new Label();
            commentBody.setText("No existen comentarios para esta pregunta. Se el primero!");
            commentBody.setPrefWidth(anchorPaneWidth - offset);
                commentBody.setPrefHeight(anchorPaneHeight - offset);
                commentBody.setFont(new Font(15)); 
                commentBody.setWrapText(true);
                AnchorPane.setTopAnchor(commentBody, (anchorPaneHeight / 2)- offset*3);
                AnchorPane.setLeftAnchor(commentBody, offset);
                this.controlSplitPane.getItems().add(localPane);
                this.controlSplitPane.setDividerPosition(contador, 0);
            
            //Print on screen that it is empty!
        }
        //Reset activation of buttons:
        if (sizeComents > noMaxPag)
        {
            sigActivo = true;
        }
        if (noMinPag > 0)
        {
            prevActivo = true;
        }
    createButtonsPagina (sigActivo, prevActivo);
        hitNextPage = false;
        hitPrevPage = false;
    }
    @FXML
    private void uploadComment (ActionEvent event)
    {
        String myComment = this.areaComment.getText();
        Date myCurrDate = new Date(); //Current Date
        ArrayList<Comentario> newList;
        if (myComment.isEmpty())
        {
            this.errorLabel.setVisible(true);
        }
        else
        {
            Comentario myNewComment = new Comentario();
            myNewComment.setDescripcion(myComment);
            myNewComment.setFecha(myCurrDate);
            newList = this.miPregunta.getComentarios();
            newList.add(myNewComment);
            this.miPregunta.setComentarios(newList);
            this.miControladorPub.modificarPublicacion(miPregunta);
            ShowComentariosOnScreen();
            
        }
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
    public void setPregunta (Pregunta miPregunta)
    {
        this.miPregunta = miPregunta;
        inXMLSetPregunta(miPregunta);
        ShowComentariosOnScreen();
    }
    public void setUsuario(Usuario miUsuario)
    {
        this.miUsuario = miUsuario;
        setUsuarioImage();
    }
    private void activateNextPage()
    {
        hitNextPage = true;
    }
    private void activateLastPage()
    {
        hitPrevPage = true;
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
    
    private void inXMLSetPregunta(Pregunta miPregunta)
    {
        this.tituloPregunta.setText(miPregunta.getTitulo());
        this.descripcionPregunta.setText(miPregunta.getDescripcion());
        this.fechaPregunta.setText(miPregunta.getFecha().toString());
        this.upvotes.setText(String.valueOf(miPregunta.getNumVotos()));
        this.usuarioPregunta.setText(miPregunta.getPropietario().getUserName());
        this.upvotePanel.setImage(new Image("imagenes/UpvoteBlack.png"));
        
    }
    @FXML
    private void clickOnUpvote(ActionEvent event)
    {
        if (this.isUpvoted == false)
        {
        this.upvotePanel.setImage(new Image("imagenes/UpvoteRed.png"));
        this.miPregunta.setNumVotos(this.miPregunta.getNumVotos()+1);
        this.upvotes.setText(String.valueOf(miPregunta.getNumVotos()));
        System.out.print(miPregunta.getId() + "\n");
        this.miControladorPub.modificarPublicacion(miPregunta); //Modifico mi publicacion con los nuevos votos.
        isUpvoted = true;
        }
        else
        {
            this.upvotePanel.setImage(new Image("imagenes/UpvoteBlack.png"));
            this.miPregunta.setNumVotos(this.miPregunta.getNumVotos()-1);
            this.upvotes.setText(String.valueOf(miPregunta.getNumVotos()));
            this.miControladorPub.modificarPublicacion(miPregunta);
            isUpvoted = false;
        }
    }
    /**
     * menu - Función de manejo para abrir la escena del menú principal.
     * @param event - N/A, miUsuario - Pasa el usuario guardado en este controlador a la siguiente.
     * @trigger - Botón de TopAuto en el archivo FXML
     */
    @FXML
    private void menu(ActionEvent event) {
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
                        
            Stage myStage = (Stage) this.topAuto.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * verPerfil - Función de manejo para abrir la escena del perfil.
     * @param event - N/A, miUsuario - Pasa el usuario guardado en este controlador a la siguiente.
     * @trigger - Botón de Perfil en el archivo FXML
     * 
     */
    @FXML
    private void verPerfil(ActionEvent event) {
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
                        
            Stage myStage = (Stage) this.perfil.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * responder - Función de manejo para abrir la escena de Responder Preguntas.
     * @param event - N/A,  miUsuario - Pasa el usuario guardado en este controlador a la siguiente.
     * @trigger - Botón de Responder Preguntas en el archivo FXML
     */
     @FXML
    private void responder(ActionEvent event) {
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
                        
            Stage myStage = (Stage) this.resPregunta.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * preguntas - Función de manejo para abrir la escena de creación de Preguntas.
     * @param event - N/A,  miUsuario - Pasa el usuario guardado en este controlador a la siguiente.
     * @trigger - Botón de Escribir Pregunta en el archivo FXML
     */
    @FXML
    private void preguntar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaEscribirPreguntaScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaEscribirPregunta controlador = loader.getController();
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
                        
            Stage myStage = (Stage) this.hazPregunta.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * reseñar - Función de manejo para abrir la escena de Escribir Reseña.
     * @param event - N/A,  miUsuario - Pasa el usuario guardado en este controlador a la siguiente.
     * @trigger - Botón de Escribir Reseña en el archivo FXML
     */
    @FXML
    private void reseñar(ActionEvent event) {
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
                        
            Stage myStage = (Stage) this.hazReseña.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
