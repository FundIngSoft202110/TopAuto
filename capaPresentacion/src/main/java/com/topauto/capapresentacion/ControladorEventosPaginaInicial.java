package com.topauto.capapresentacion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorEventosPaginaInicial implements Initializable {

    @FXML
    private Button btnAdmin;
    @FXML
    private Button btnUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void administar(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaAdminScene.fxml"));
            stage.setMaxWidth(840);
            stage.setMaxHeight(500);
            stage.setTitle("Admin TopAuto");
            
            ControladorEventosPaginaAdmin controlador = loader.getController();
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            
            stage.show();
                        
            Stage myStage = (Stage) this.btnAdmin.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void acceder(ActionEvent event) {
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
                        
            Stage myStage = (Stage) this.btnUser.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
