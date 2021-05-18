package com.topauto.capapresentacion;

import com.topauto.capaentidades.Usuario;
import com.topauto.capaentidades.PRgeneral;
import com.topauto.capaentidades.Publicacion;
import com.topauto.capaentidades.Usuario;
import com.topauto.capanegocio.ControladorPerfil;
import com.topauto.capanegocio.ControladorPublicacion;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ControladorEventosPaginaEscribirPregunta implements Initializable {
    
    ControladorPerfil controlPerfil = new ControladorPerfil();
    ControladorPublicacion controlPublicacion = new ControladorPublicacion();
    
    private Label label;
    @FXML
    private Button resPregunta;
    @FXML
    private Button hazReseña;
    @FXML
    private Button perfil;
    @FXML
    private Button topAuto;
    @FXML
    private ImageView imagenUsuario;
    @FXML
    private Text textoNombreUsuario;
    
    @FXML
    private Button btPregunta;
    @FXML
    private TextArea txtContenido;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtTags;
    @FXML
    private CheckBox checkBox;
    private Usuario miUsuario;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
        public void setUsuario(Usuario miUsuario) 
    {
        this.miUsuario = miUsuario;
        setUsuarioImage();
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

    @FXML
    private void verPerfil(ActionEvent event) {
        String nombreBoton = this.perfil.getText();
        if("Ingresar".equals(nombreBoton))
        {
            
            try {
            
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaLoginScene.fxml"));
            stage.setMaxWidth(840);
            stage.setMaxHeight(500);
            stage.setTitle("TopAuto Login");
            
            ControladorEventosPaginaLogin controlador = loader.getController();
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
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
        else{
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
            Logger.getLogger(ControladorEventosPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Setea Usuario
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

    @FXML
    private void preguntar(ActionEvent event) {
        if((!this.checkBox.isSelected())||("".equals(this.txtTitulo.getText()))||("".equals(this.txtContenido.getText()))||("".equals(this.txtTags.getText()))){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Los datos estan incompletos");
            alerta.showAndWait();
        }else{
            ArrayList<String> tags = new ArrayList<>();
            String tg[] = this.txtTags.getText().split(",");
            tags.addAll(Arrays.asList(tg));
            Usuario usuario = new Usuario();
            
            ArrayList<Publicacion> publicaciones=controlPublicacion.getPublicaciones();
            ArrayList<Integer> preguntasGenerales=new ArrayList<>();
            
            for(Publicacion p : publicaciones){
               if(p.getId().contains("PRG")){
                   preguntasGenerales.add(Integer.parseInt(p.getId().substring(3)));
               }
            }           
            int max=0;
            for (int i = 0; i < preguntasGenerales.size(); i++) {
                if (preguntasGenerales.get(i) > max) {
                    max = preguntasGenerales.get(i);
                }
            }
            
            PRgeneral pregunta = new PRgeneral(tags,"PRG"+(max++),this.txtTitulo.getText(),this.txtContenido.getText(),new Date(), usuario);
            
            if(controlPublicacion.crearPublicacion(pregunta)){
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText(null);
                alerta.setTitle("Exito");
                alerta.setContentText("Pregunta realizada");
                alerta.showAndWait();
                this.txtContenido.setText("");
                this.txtTags.setText("");
                this.txtTitulo.setText("");
            }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("Error al generar la pregunta");
                alerta.showAndWait();
            }
        }
        
    }
}
