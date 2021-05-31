package com.topauto.capapresentacion;

import com.topauto.capaentidades.Comentario;
import com.topauto.capaentidades.Fabricante;
import com.topauto.capaentidades.PRgeneral;
import com.topauto.capaentidades.Pais;
import com.topauto.capaentidades.Publicacion;
import com.topauto.capaentidades.Resenia;
import com.topauto.capaentidades.Usuario;
import com.topauto.capaentidades.Vehiculo;
import com.topauto.capanegocio.ControladorPerfil;
import com.topauto.capanegocio.ControladorPublicacion;
import com.topauto.capanegocio.ControladorVehiculo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ControladorEventosPaginaEscribirResenia implements Initializable {
    
    private ControladorVehiculo controlCarro = new ControladorVehiculo();
    ControladorPublicacion controlPublicacion = new ControladorPublicacion();
    
    
    private Label label;
    @FXML
    private Button resPregunta;
    @FXML
    private Button perfil;
    @FXML
    private Button topAuto;
    @FXML
    private Button hazPregunta;
    @FXML
    private ImageView imagenUsuario;
    @FXML
    private Text textoNombreUsuario;
    private Usuario miUsuario;
    @FXML
    private ComboBox<String> boxMarca;
    @FXML
    private ChoiceBox<String> boxModelo;
    @FXML
    private TextArea txtContenido;
    @FXML
    private ChoiceBox<String> boxPuntuacion;
    @FXML
    private CheckBox checkBox;
    @FXML
    private Button btReseña;
    @FXML
    private TextField txtTitulo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controlCarro.descargarDatos();
        controlPublicacion.descargarDatos();
        ObservableList<String> listaMarcas;
        ArrayList<String> marcas = new ArrayList<>();
        for(Fabricante f : controlCarro.getFabricantes()){
            marcas.add(f.getNombre());
        }
        listaMarcas = FXCollections.observableArrayList(marcas);
        boxMarca.setItems(listaMarcas);
        
        ObservableList<String> puntaje;
        puntaje = FXCollections.observableArrayList("1","2","3","4","5");
        boxPuntuacion.setItems(puntaje);
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

    @FXML
    private void reseñar(ActionEvent event) {
        if((!this.checkBox.isSelected())||("".equals(this.txtTitulo.getText()))||("".equals(this.boxMarca.getValue()))||("".equals(this.boxModelo.getValue()))||("".equals(this.txtContenido.getText()))){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Los datos estan incompletos");
            alerta.showAndWait();
        }else{
            
            ArrayList<Publicacion> publicaciones=controlPublicacion.getPublicaciones();
            ArrayList<Comentario> comentarios= new ArrayList<>();
            int count=0;
            
            for(Publicacion p : publicaciones){
               if(p.getId().contains("RES")){
                   count++;
               }
            }
            Vehiculo vehiculo= new Vehiculo();
            for(Vehiculo v: controlCarro.getVehiculos()){
                if(v.getModelo().equals(this.boxModelo.getValue())){
                    vehiculo = v;
                }
            }
            
            Resenia reseña = new Resenia(Integer.parseInt(this.boxPuntuacion.getValue()),vehiculo,"RES10"+count,this.txtTitulo.getText(),this.txtContenido.getText(),new Date(),0,0,this.miUsuario,comentarios);
            
            if(controlPublicacion.crearPublicacion(reseña)){
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText(null);
                alerta.setTitle("Exito");
                alerta.setContentText("Reseña realizada");
                alerta.showAndWait();
                this.txtContenido.setText("");
                this.boxMarca.setValue("");
                this.boxModelo.setValue("");
                this.boxPuntuacion.setValue("");
                this.txtTitulo.setText("");
            }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("Error al generar la reseña");
                alerta.showAndWait();
            }
        }
        
    }

    @FXML
    private void seleccionar(ActionEvent event) {
        
        ObservableList<String> listaModelos;
        ArrayList<String> modelos = new ArrayList<>();
        for(Vehiculo v : controlCarro.getVehiculos()){
            if(boxMarca.getValue().equals(v.getMarca().getNombre())){
                modelos.add(v.getModelo());
            }
        }
        listaModelos = FXCollections.observableArrayList(modelos);
        boxModelo.setItems(listaModelos);
        
    }
}
