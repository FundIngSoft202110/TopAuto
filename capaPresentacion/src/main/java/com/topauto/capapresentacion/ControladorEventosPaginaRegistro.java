package com.topauto.capapresentacion;

import com.topauto.capaentidades.Imagen;
import com.topauto.capaentidades.Pais;
import com.topauto.capaentidades.Publicacion;
import com.topauto.capaentidades.Usuario;
import com.topauto.capanegocio.ControladorPerfil;
import com.topauto.capanegocio.ControladorVehiculo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorEventosPaginaRegistro implements Initializable {
    
    private ControladorPerfil controlPerfil = new ControladorPerfil();
    private ControladorVehiculo controlCarro = new ControladorVehiculo();
    
    @FXML
    private Button btVolver;
    @FXML
    private Button btRegistro;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtClave;
    @FXML
    private ChoiceBox<String> listPaises;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controlPerfil.descargarDatos();
        controlCarro.descargarDatos();
        ObservableList<String> listaPaises;
        ArrayList<String> paises = new ArrayList<>();
        for(Pais pais : controlCarro.getPaises()){
            paises.add(pais.getNombre());
        }
        listaPaises = FXCollections.observableArrayList(paises);
        listPaises.setItems(listaPaises);
        
    }    

    @FXML
    private void regresar(ActionEvent event) {
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
            stage.show();
                        
            Stage myStage = (Stage) this.btVolver.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void registrar(ActionEvent event) {
        String nombre = this.txtNombre.getText();
        String username = this.txtUsername.getText();
        String correo = this.txtCorreo.getText();
        String contrasenia = this.txtClave.getText();
        String country = this.listPaises.getValue();
        Imagen imagen = new Imagen();
        imagen.setPath("");
        
        if(("".equals(nombre))||("".equals(username))||("".equals(correo))||("".equals(contrasenia))||("".equals(listPaises.getValue()))){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Los datos estan incompletos");
            alerta.showAndWait();
        }
        else{
            Pais pais=new Pais();
            for(Pais p:controlCarro.getPaises()){
                if(country.equals(p.getNombre())){
                    pais=p;
                }
            }
            
            Usuario usuario = new Usuario(nombre,username,correo,"",contrasenia,true, new ArrayList<Publicacion>(),imagen, pais);
            boolean encontro=false;
            for(Usuario u : controlPerfil.getUsuarios()){
                if((username.equals(u.getUserName())||(correo.equals(u.getCorreo())))){
                    encontro=true;
                }
            }
            
            if(encontro==false){
                if(controlPerfil.registrarPerfil(usuario)){
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setHeaderText(null);
                    alerta.setTitle("Exito");
                    alerta.setContentText("Usuario Registrado");
                    alerta.showAndWait();

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
                        stage.show();

                        Stage myStage = (Stage) this.btRegistro.getScene().getWindow();
                        myStage.close();

                    } catch (IOException ex) {
                        Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setHeaderText(null);
                    alerta.setTitle("Error");
                    alerta.setContentText("Error en la conexion con la base de datos");
                    alerta.showAndWait();
                    
                    this.txtNombre.setText("");
                    this.txtCorreo.setText("");
                    this.txtUsername.setText("");
                    this.txtClave.setText("");
                }            
                
            }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("Los datos que intentas registrar ya estan en plataforma");
                alerta.showAndWait();
            }
        }
        
    }
}
