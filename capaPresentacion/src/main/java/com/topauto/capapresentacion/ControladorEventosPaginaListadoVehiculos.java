package com.topauto.capapresentacion;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControladorEventosPaginaListadoVehiculos implements Initializable {

    @FXML
    private ImageView norAmerica;
    @FXML
    private Button botonAmerica;
    @FXML
    private Button botonEuropa;
    @FXML
    private Button botonAsia;
    @FXML
    private AnchorPane countries;
    @FXML
    private AnchorPane marcas;
    @FXML
    private AnchorPane vehiculos;
    
    EventHandler<ActionEvent> buttonHandlerUSA;
    EventHandler<ActionEvent> buttonHandlerEuropa;
    EventHandler<ActionEvent> buttonHandlerAsia;
    EventHandler<ActionEvent> buttonHandlerItalia;
    EventHandler<ActionEvent> buttonHandlerAlemania;
    EventHandler<ActionEvent> buttonHandlerJapon;
    EventHandler<ActionEvent> buttonHandlerChina;
    EventHandler<ActionEvent> buttonHandlerNA;
    EventHandler<ActionEvent> buttonHandlerEspaña;
    EventHandler<ActionEvent> buttonHandlerFrancia;
    EventHandler<ActionEvent> buttonHandlerUK;
    EventHandler<ActionEvent> buttonHandlerIndia;
    EventHandler<ActionEvent> buttonHandlerChevrolet;
    EventHandler<ActionEvent> buttonHandlerToyota;
    EventHandler<ActionEvent> buttonHandlerAlfaRomeo;
    EventHandler<ActionEvent> buttonHandlerGM;
    EventHandler<ActionEvent> buttonHandlerSAIC;
    EventHandler<ActionEvent> buttonHandlerMercedez;
    EventHandler<ActionEvent> buttonHandlerBMW;


    EventHandler<ActionEvent> buttonHandlerCanada;
    EventHandler<ActionEvent> buttonHandlerMexico;
    
   
    int noCountriesNA = 2;
    int noCountriesEU = 5;
    int noCountriesAS = 3;
    
    //Contadores de NoMarcas por Pais
    int marcasUSA = 3;
    int marcasMexico = 1;
    
    int marcasItalia = 2;
    int marcasAlemania = 2;
    int marcasFrancia = 3;
    int marcasEspaña = 1;
    int marcasUK=1;
    
    
    int marcasChina = 2;
    int marcasIndia = 1;
    int marcasJapon = 5;
    @FXML
    private Button resPregunta;
    @FXML
    private Button hazPregunta;
    @FXML
    private Button hazReseña;
    @FXML
    private Button perfil;
    @FXML
    private TextField texto;
    @FXML
    private Button topAuto;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
     
     buttonHandlerUSA = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          createButtonsUSA();
      }
     };
     
     buttonHandlerMexico = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          createButtonsMexico();
      }
     };
     
     buttonHandlerChina = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          createButtonsChina();
      }
     };
     
     buttonHandlerUK = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          createButtonsUK();
      }
     };
     buttonHandlerFrancia = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          createButtonsFrancia();
      }
     };
     buttonHandlerEspaña = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          createButtonsEspaña();
      }
     };
     buttonHandlerIndia = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          createButtonsIndia();
      }
     };
     
     buttonHandlerEuropa = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          createButtonsEuropa();
      }
     };
     
     buttonHandlerItalia = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          createButtonsItalia();
      }
     };
     
     buttonHandlerAlemania = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          createButtonsAlemania();
      }
     };
     
     buttonHandlerChevrolet = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          crearVehiculosChevrolet();
      }
     };
     
     buttonHandlerAlfaRomeo = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          crearVehiculosAlfaRomeo();
      }
     };
     
     buttonHandlerGM = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          crearVehiculosGM();
      }
     };
     
     buttonHandlerToyota = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          crearVehiculosToyota();
      }
     };
     buttonHandlerSAIC = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          crearVehiculosSAIC();
      }
     };
     
     buttonHandlerMercedez = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          crearVehiculosMercedez();
      }
     };
     
     buttonHandlerBMW = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          crearVehiculosBMW();
      }
     };
     buttonHandlerNA = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          crearVehiculosNA();
      }
     };
     
     buttonHandlerJapon = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) 
      {
          createButtonsJapon();
      }
     };
     
        // TODO
    }    
    @FXML
    private void clickNorAmerica (ActionEvent event)
    {
        this.texto.setText("America");
        //Crear Botones
      System.out.println("DEBUG: NA!");
     
        this.createButtonsNA();
        
    }
    @FXML
    private void clickAsia (ActionEvent event)
    {
        this.texto.setText("Asia");
        //Crear Botones
      System.out.println("DEBUG: ASIA!");
     
        this.createButtonsAsia();
        
    }
    
    @FXML
    private void clickEuropa (ActionEvent event)
    {
        this.texto.setText("Europa");
        //Crear Botones
        System.out.println("DEBUG: Europa!");
     
        this.createButtonsEuropa();
        
    }
    
    private void createButtonsNA()
    {
        countries.getChildren().clear();
        marcas.getChildren().clear();
        vehiculos.getChildren().clear();
        double buttonWidth = (this.countries.getPrefWidth() / this.noCountriesNA);
        double buttonHeight = this.countries.getPrefHeight();
        ArrayList<Button> but = new ArrayList<Button>();
        for(int i = 0; i < this.noCountriesNA; i++)
        {
            but.add(new Button());
            but.get(i).setPrefWidth(buttonWidth);
            but.get(i).setPrefHeight(buttonHeight);
            
            //Añade tres botones
        }
        //Set text
        but.get(0).setText("USA");
        but.get(1).setText("Mexico");
        //Set functionality
        but.get(0).setOnAction(buttonHandlerUSA);
        but.get(1).setOnAction(buttonHandlerMexico);
        
        AnchorPane.setLeftAnchor(but.get(0), 0.0);
        AnchorPane.setLeftAnchor(but.get(1), buttonWidth);

        countries.getChildren().addAll(but.get(0),but.get(1));
    }
    
    private void createButtonsEuropa()
    {
        countries.getChildren().clear();
        marcas.getChildren().clear();
        vehiculos.getChildren().clear();
        double buttonWidth = (this.countries.getPrefWidth() / this.noCountriesEU);
        double buttonHeight = this.countries.getPrefHeight();
        ArrayList<Button> but = new ArrayList<Button>();
        for(int i = 0; i < this.noCountriesEU; i++)
        {
            but.add(new Button());
            but.get(i).setPrefWidth(buttonWidth);
            but.get(i).setPrefHeight(buttonHeight);
            
            //Añade tres botones
        }
        //Set text
        but.get(0).setText("Italia");
        but.get(1).setText("Alemania");
        but.get(2).setText("España");
        but.get(3).setText("Reino Unido");
        but.get(4).setText("Francia");
        //Set functionality
        but.get(0).setOnAction(buttonHandlerItalia);
        but.get(1).setOnAction(buttonHandlerAlemania);
        but.get(2).setOnAction(buttonHandlerEspaña);
        but.get(3).setOnAction(buttonHandlerUK);
        but.get(4).setOnAction(buttonHandlerFrancia);
        
        AnchorPane.setLeftAnchor(but.get(0), 0.0);
        AnchorPane.setLeftAnchor(but.get(1), buttonWidth);
        AnchorPane.setLeftAnchor(but.get(2), buttonWidth * 2);
        AnchorPane.setLeftAnchor(but.get(3), buttonWidth * 3);
        AnchorPane.setLeftAnchor(but.get(4), buttonWidth * 4);

        countries.getChildren().addAll(but.get(0),but.get(1),but.get(2),but.get(3),but.get(4));
    }
    
    private void createButtonsAsia()
    {
        countries.getChildren().clear();
        marcas.getChildren().clear();
        vehiculos.getChildren().clear();
        double buttonWidth = (this.countries.getPrefWidth() / this.noCountriesAS);
        double buttonHeight = this.countries.getPrefHeight();
        ArrayList<Button> but = new ArrayList<Button>();
        for(int i = 0; i < this.noCountriesAS; i++)
        {
            but.add(new Button());
            but.get(i).setPrefWidth(buttonWidth);
            but.get(i).setPrefHeight(buttonHeight);
            
            //Añade tres botones
        }
        //Set text
        but.get(0).setText("Japon");
        but.get(1).setText("China");
        but.get(2).setText("India");
        //Set functionality
        but.get(0).setOnAction(buttonHandlerJapon);
        but.get(1).setOnAction(buttonHandlerChina);
        but.get(2).setOnAction(buttonHandlerIndia);
        
        AnchorPane.setLeftAnchor(but.get(0), 0.0);
        AnchorPane.setLeftAnchor(but.get(1), buttonWidth);
        AnchorPane.setLeftAnchor(but.get(2), buttonWidth * 2);


        countries.getChildren().addAll(but.get(0),but.get(1),but.get(2));
    }
    
private void createButtonsUSA()
{
    marcas.getChildren().clear();
    vehiculos.getChildren().clear();
    
    double buttonWidth = (this.marcas.getPrefWidth() / marcasUSA);
    double buttonHeight = this.marcas.getPrefHeight();
     ArrayList<Button> but = new ArrayList<Button>();
     for(int i = 0; i < this.marcasUSA; i++)
        {
            but.add(new Button());
            but.get(i).setPrefWidth(buttonWidth);
            but.get(i).setPrefHeight(buttonHeight);
            
            //Añade tres botones
        }
        //Set text
        but.get(0).setText("Chevrolet");
        but.get(1).setText("GMC");
        but.get(2).setText("Ford");
        
        //Set functionality
       but.get(0).setOnAction(buttonHandlerChevrolet);
       but.get(1).setOnAction(buttonHandlerGM);
       but.get(2).setOnAction(buttonHandlerNA);

        
        AnchorPane.setLeftAnchor(but.get(0), 0.0);
        AnchorPane.setLeftAnchor(but.get(1), buttonWidth);
        AnchorPane.setLeftAnchor(but.get(2), buttonWidth * 2);

        marcas.getChildren().addAll(but.get(0),but.get(1),but.get(2));
    }

private void createButtonsMexico()
{
    marcas.getChildren().clear();
    vehiculos.getChildren().clear();
    
    double buttonWidth = (this.marcas.getPrefWidth() / this.marcasMexico);
    double buttonHeight = this.marcas.getPrefHeight();
     ArrayList<Button> but = new ArrayList<Button>();
     for(int i = 0; i < this.marcasMexico; i++)
        {
            but.add(new Button());
            but.get(i).setPrefWidth(buttonWidth);
            but.get(i).setPrefHeight(buttonHeight);
            
            //Añade tres botones
        }
        //Set text
        but.get(0).setText("Alfa Romeo");

        //Set functionality
        but.get(0).setOnAction(buttonHandlerAlfaRomeo);
        
        AnchorPane.setLeftAnchor(but.get(0), 0.0);
        

        marcas.getChildren().addAll(but.get(0));
    }

private void createButtonsEspaña()
{
    marcas.getChildren().clear();
    vehiculos.getChildren().clear();
    
    double buttonWidth = (this.marcas.getPrefWidth() / this.marcasEspaña);
    double buttonHeight = this.marcas.getPrefHeight();
     ArrayList<Button> but = new ArrayList<Button>();
     for(int i = 0; i < this.marcasEspaña; i++)
        {
            but.add(new Button());
            but.get(i).setPrefWidth(buttonWidth);
            but.get(i).setPrefHeight(buttonHeight);
            
            //Añade tres botones
        }
        //Set text
        but.get(0).setText("Iveco-Pegaso");

        //Set functionality
        but.get(0).setOnAction(buttonHandlerNA);
        
        AnchorPane.setLeftAnchor(but.get(0), 0.0);
        

        marcas.getChildren().addAll(but.get(0));
    }
private void createButtonsUK()
{
    marcas.getChildren().clear();
    vehiculos.getChildren().clear();
    
    double buttonWidth = (this.marcas.getPrefWidth() / this.marcasUK);
    double buttonHeight = this.marcas.getPrefHeight();
     ArrayList<Button> but = new ArrayList<Button>();
     for(int i = 0; i < this.marcasUK; i++)
        {
            but.add(new Button());
            but.get(i).setPrefWidth(buttonWidth);
            but.get(i).setPrefHeight(buttonHeight);
            
            //Añade tres botones
        }
        //Set text
        but.get(0).setText("Bentley");

        //Set functionality
        but.get(0).setOnAction(buttonHandlerNA);
        
        AnchorPane.setLeftAnchor(but.get(0), 0.0);
        

        marcas.getChildren().addAll(but.get(0));
    }

private void createButtonsIndia()
{
    marcas.getChildren().clear();
    vehiculos.getChildren().clear();
    
    double buttonWidth = (this.marcas.getPrefWidth() / this.marcasIndia);
    double buttonHeight = this.marcas.getPrefHeight();
     ArrayList<Button> but = new ArrayList<Button>();
     for(int i = 0; i < this.marcasIndia; i++)
        {
            but.add(new Button());
            but.get(i).setPrefWidth(buttonWidth);
            but.get(i).setPrefHeight(buttonHeight);
            
            //Añade tres botones
        }
        //Set text
        but.get(0).setText("Mahindra & Mahindra");

        //Set functionality
        but.get(0).setOnAction(buttonHandlerNA);
        
        AnchorPane.setLeftAnchor(but.get(0), 0.0);
        

        marcas.getChildren().addAll(but.get(0));
    }

private void createButtonsFrancia()
{
    marcas.getChildren().clear();
    vehiculos.getChildren().clear();
    
    double buttonWidth = (this.marcas.getPrefWidth() / this.marcasFrancia);
    double buttonHeight = this.marcas.getPrefHeight();
     ArrayList<Button> but = new ArrayList<Button>();
     for(int i = 0; i < this.marcasFrancia; i++)
        {
            but.add(new Button());
            but.get(i).setPrefWidth(buttonWidth);
            but.get(i).setPrefHeight(buttonHeight);
            
            //Añade tres botones
        }
        //Set text
        but.get(0).setText("Renault");
        but.get(1).setText("Citroen");
        but.get(2).setText("Peugeot");

        //Set functionality
        but.get(0).setOnAction(buttonHandlerNA);
        but.get(1).setOnAction(buttonHandlerNA);
        but.get(2).setOnAction(buttonHandlerNA);
        
        AnchorPane.setLeftAnchor(but.get(0), 0.0);
        AnchorPane.setLeftAnchor(but.get(1), buttonWidth);
        AnchorPane.setLeftAnchor(but.get(2), buttonWidth * 2);
        

        marcas.getChildren().addAll(but.get(0), but.get(1), but.get(2));
    }



      private void createButtonsItalia()
      {
    marcas.getChildren().clear();
    vehiculos.getChildren().clear();
    
    double buttonWidth = (this.marcas.getPrefWidth() / this.marcasItalia);
    double buttonHeight = this.marcas.getPrefHeight();
     ArrayList<Button> but = new ArrayList<Button>();
     for(int i = 0; i < this.marcasItalia; i++)
        {
            but.add(new Button());
            but.get(i).setPrefWidth(buttonWidth);
            but.get(i).setPrefHeight(buttonHeight);
            
            //Añade tres botones
        }
        //Set text
        but.get(0).setText("FIAT");
        but.get(1).setText("Lamborghini");
        
        //Set functionality
     but.get(0).setOnAction(buttonHandlerNA);
     but.get(1).setOnAction(buttonHandlerNA);
        
        AnchorPane.setLeftAnchor(but.get(0), 0.0);
        AnchorPane.setLeftAnchor(but.get(1), buttonWidth);

        marcas.getChildren().addAll(but.get(0),but.get(1));
    }
      
      
      private void createButtonsChina()
      {
    marcas.getChildren().clear();
    vehiculos.getChildren().clear();
    
    double buttonWidth = (this.marcas.getPrefWidth() / this.marcasItalia);
    double buttonHeight = this.marcas.getPrefHeight();
     ArrayList<Button> but = new ArrayList<Button>();
     for(int i = 0; i < this.marcasItalia; i++)
        {
            but.add(new Button());
            but.get(i).setPrefWidth(buttonWidth);
            but.get(i).setPrefHeight(buttonHeight);
            
            //Añade tres botones
        }
        //Set text
        but.get(0).setText("SAIC");
        but.get(1).setText("Shangan Motors");
        but.get(0).setOnAction(buttonHandlerSAIC);
        but.get(1).setOnAction(buttonHandlerNA);
        //Set functionality
     
        
        AnchorPane.setLeftAnchor(but.get(0), 0.0);
        AnchorPane.setLeftAnchor(but.get(1), buttonWidth);

        marcas.getChildren().addAll(but.get(0),but.get(1));
    }
      
      private void createButtonsAlemania()
{
    marcas.getChildren().clear();
    vehiculos.getChildren().clear();
    
    double buttonWidth = (this.marcas.getPrefWidth() / this.marcasAlemania);
    double buttonHeight = this.marcas.getPrefHeight();
     ArrayList<Button> but = new ArrayList<Button>();
     for(int i = 0; i < this.marcasAlemania; i++)
        {
            but.add(new Button());
            but.get(i).setPrefWidth(buttonWidth);
            but.get(i).setPrefHeight(buttonHeight);
            
            //Añade tres botones
        }
        //Set text
        but.get(0).setText("BMW");
        but.get(1).setText("Mercedes-Benz");
        but.get(0).setOnAction(buttonHandlerBMW);
        but.get(1).setOnAction(buttonHandlerMercedez);
        //Set functionality
     
        

        
        AnchorPane.setLeftAnchor(but.get(0), 0.0);
        AnchorPane.setLeftAnchor(but.get(1), buttonWidth);


        marcas.getChildren().addAll(but.get(0),but.get(1));
    }
     

      
      private void createButtonsJapon()
{
    marcas.getChildren().clear();
    vehiculos.getChildren().clear();
    
    double buttonWidth = (this.marcas.getPrefWidth() / this.marcasJapon);
    double buttonHeight = this.marcas.getPrefHeight();
     ArrayList<Button> but = new ArrayList<Button>();
     for(int i = 0; i < this.marcasJapon; i++)
        {
            but.add(new Button());
            but.get(i).setPrefWidth(buttonWidth);
            but.get(i).setPrefHeight(buttonHeight);
            
            //Añade tres botones
        }
        //Set text
        but.get(0).setText("Toyota");
        but.get(1).setText("Lexus");
        but.get(2).setText("Suzuki");
        but.get(3).setText("Mazda");
        but.get(4).setText("Honda");

        
        //Set functionality
        but.get(0).setOnAction(buttonHandlerToyota);
                but.get(1).setOnAction(buttonHandlerNA);
                but.get(2).setOnAction(buttonHandlerNA);
                but.get(3).setOnAction(buttonHandlerNA);
                but.get(4).setOnAction(buttonHandlerNA);
        
        AnchorPane.setLeftAnchor(but.get(0), 0.0);
        AnchorPane.setLeftAnchor(but.get(1), buttonWidth);
        AnchorPane.setLeftAnchor(but.get(2), buttonWidth * 2);
        AnchorPane.setLeftAnchor(but.get(3), buttonWidth * 3);
        AnchorPane.setLeftAnchor(but.get(4), buttonWidth * 4);


        marcas.getChildren().addAll(but.get(0),but.get(1),but.get(2),but.get(3),but.get(4));
    }
   private void crearVehiculosChevrolet()
   {
       vehiculos.getChildren().clear();
       Rectangle carro1 = new Rectangle();
       carro1.setWidth(80);
       carro1.setHeight(80);
       
       Text textoCarro = new Text();
       textoCarro.setText("Spark GT 2019");
       textoCarro.setFont(new Font(15));
       textoCarro.setWrappingWidth(100);
       
       AnchorPane.setTopAnchor(carro1, 0.0);
       AnchorPane.setLeftAnchor(textoCarro, 90.0);
       AnchorPane.setTopAnchor(textoCarro, 30.0);
       
       vehiculos.getChildren().addAll(carro1,textoCarro);
       
       
   }
   
   private void crearVehiculosBMW()
   {
       vehiculos.getChildren().clear();
       Rectangle carro1 = new Rectangle();
       carro1.setWidth(80);
       carro1.setHeight(80);
       
       Text textoCarro = new Text();
       textoCarro.setText("BMW Coupé 2018");
       textoCarro.setFont(new Font(15));
       textoCarro.setWrappingWidth(100);
       
       AnchorPane.setTopAnchor(carro1, 0.0);
       AnchorPane.setLeftAnchor(textoCarro, 90.0);
       AnchorPane.setTopAnchor(textoCarro, 30.0);
       
       vehiculos.getChildren().addAll(carro1,textoCarro);
       
       
   }
   
   private void crearVehiculosAlfaRomeo()
   {
       vehiculos.getChildren().clear();
       Rectangle carro1 = new Rectangle();
       carro1.setWidth(80);
       carro1.setHeight(80);
       
       Text textoCarro = new Text();
       textoCarro.setText("Alfa Romeo Mito 2020");
       textoCarro.setFont(new Font(15));
       textoCarro.setWrappingWidth(100);
       
       AnchorPane.setTopAnchor(carro1, 0.0);
       AnchorPane.setLeftAnchor(textoCarro, 90.0);
       AnchorPane.setTopAnchor(textoCarro, 30.0);
       
       vehiculos.getChildren().addAll(carro1,textoCarro);
       
       
   }
   
   private void crearVehiculosSAIC()
   {
       vehiculos.getChildren().clear();
       Rectangle carro1 = new Rectangle();
       carro1.setWidth(80);
       carro1.setHeight(80);
       
       Text textoCarro = new Text();
       textoCarro.setText("SAIC MG EHS 2020");
       textoCarro.setFont(new Font(15));
       textoCarro.setWrappingWidth(100);
       
       AnchorPane.setTopAnchor(carro1, 0.0);
       AnchorPane.setLeftAnchor(textoCarro, 90.0);
       AnchorPane.setTopAnchor(textoCarro, 30.0);
       
       vehiculos.getChildren().addAll(carro1,textoCarro);
       
       
   }
   
   private void crearVehiculosNA()
   {
       vehiculos.getChildren().clear();
       
       
       Text textoCarro = new Text();
       textoCarro.setText("No existen Carros en esta categoria. Por favor seleccionar otra.");
       textoCarro.setFont(new Font(30));
       textoCarro.setWrappingWidth(1000);
       
      
       AnchorPane.setLeftAnchor(textoCarro, 180.0);
       AnchorPane.setTopAnchor(textoCarro, 90.0);
       
       vehiculos.getChildren().addAll(textoCarro);
       
       
   }
   
   
   
    private void crearVehiculosGM()
   {
       vehiculos.getChildren().clear();
       Rectangle carro1 = new Rectangle(), carro2 = new Rectangle(), carro3 = new Rectangle();
       carro1.setWidth(80);
       carro1.setHeight(80);
       carro2.setWidth(80);
       carro2.setHeight(80);
       carro3.setWidth(80);
       carro3.setHeight(80);
       Text textoCarro = new Text();
       textoCarro.setText("Buick Lacrosse 2021");
       textoCarro.setFont(new Font(15));
       textoCarro.setWrappingWidth(100);
       
       Text textoCarro2 = new Text();
       textoCarro2.setText("Pointiac Firebird 2021");
       textoCarro2.setFont(new Font(15));
       textoCarro2.setWrappingWidth(100);
       
       Text textoCarro3 = new Text();
       textoCarro3.setText("Oldsmovile Achieva 2021");
       textoCarro3.setFont(new Font(15));
       textoCarro3.setWrappingWidth(100);
       
       AnchorPane.setTopAnchor(carro1, 0.0);
       AnchorPane.setTopAnchor(carro2, 90.0);
       AnchorPane.setTopAnchor(carro3, 180.0);
       AnchorPane.setLeftAnchor(textoCarro, 90.0);
       AnchorPane.setTopAnchor(textoCarro, 30.0);
       AnchorPane.setLeftAnchor(textoCarro2, 90.0);
       AnchorPane.setTopAnchor(textoCarro2, 110.0);
       AnchorPane.setLeftAnchor(textoCarro3, 90.0);
       AnchorPane.setTopAnchor(textoCarro3, 200.0);
       
       vehiculos.getChildren().addAll(carro1,textoCarro, textoCarro2, carro2, carro3, textoCarro3);   
   } 
    
    private void crearVehiculosToyota()
   {
       vehiculos.getChildren().clear();
       Rectangle carro1 = new Rectangle(), carro2 = new Rectangle();
       carro1.setWidth(80);
       carro1.setHeight(80);
       carro2.setWidth(80);
       carro2.setHeight(80);
       Text textoCarro = new Text();
       textoCarro.setText("Toyota Etios 2021");
       textoCarro.setFont(new Font(15));
       textoCarro.setWrappingWidth(100);
       
       Text textoCarro2 = new Text();
       textoCarro2.setText("Toyota Yarias 2021");
       textoCarro2.setFont(new Font(15));
       textoCarro2.setWrappingWidth(100);
       
       
       
       AnchorPane.setTopAnchor(carro1, 0.0);
       AnchorPane.setTopAnchor(carro2, 90.0);
       AnchorPane.setLeftAnchor(textoCarro, 90.0);
       AnchorPane.setTopAnchor(textoCarro, 30.0);
       AnchorPane.setLeftAnchor(textoCarro2, 90.0);
       AnchorPane.setTopAnchor(textoCarro2, 110.0);
       
       
       vehiculos.getChildren().addAll(carro1,textoCarro, textoCarro2, carro2);   
   } 
    
    private void crearVehiculosMercedez()
   {
       vehiculos.getChildren().clear();
       Rectangle carro1 = new Rectangle(), carro2 = new Rectangle();
       carro1.setWidth(80);
       carro1.setHeight(80);
       carro2.setWidth(80);
       carro2.setHeight(80);
       Text textoCarro = new Text();
       textoCarro.setText("M-Benz AMG 2021");
       textoCarro.setFont(new Font(15));
       textoCarro.setWrappingWidth(100);
       
       Text textoCarro2 = new Text();
       textoCarro2.setText("C-300 Sport 2021");
       textoCarro2.setFont(new Font(15));
       textoCarro2.setWrappingWidth(100);
       
       
       
       AnchorPane.setTopAnchor(carro1, 0.0);
       AnchorPane.setTopAnchor(carro2, 90.0);
       AnchorPane.setLeftAnchor(textoCarro, 90.0);
       AnchorPane.setTopAnchor(textoCarro, 30.0);
       AnchorPane.setLeftAnchor(textoCarro2, 90.0);
       AnchorPane.setTopAnchor(textoCarro2, 110.0);
       
       
       vehiculos.getChildren().addAll(carro1,textoCarro, textoCarro2, carro2);   
   } 

    @FXML
    private void responder(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaginaListadoPreguntasScene.fxml"));
            
            Parent root = loader.load();
            
            ControladorEventosPaginaListadoPreguntas controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
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
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
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
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
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
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
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
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
                        
            Stage myStage = (Stage) this.topAuto.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
