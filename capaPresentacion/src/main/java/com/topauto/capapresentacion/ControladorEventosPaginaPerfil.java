package com.topauto.capapresentacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


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
    private AnchorPane countries;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void responder(ActionEvent event) {
    }

    @FXML
    private void preguntar(ActionEvent event) {
    }

    @FXML
    private void reseñar(ActionEvent event) {
    }

    @FXML
    private void menu(ActionEvent event) {
    }
    
}
