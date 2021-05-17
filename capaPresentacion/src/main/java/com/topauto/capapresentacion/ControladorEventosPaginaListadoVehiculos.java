package com.topauto.capapresentacion;
//-- Falta probar --
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//  --Importaciones necesarias de otras capas: --
import com.topauto.capaentidades.Pais;
import com.topauto.capaentidades.Vehiculo;
import com.topauto.capaentidades.Fabricante;
import com.topauto.capaentidades.Imagen;
import com.topauto.capanegocio.ControladorVehiculo;
import com.topauto.capaentidades.enumerados.Region;
import java.util.Locale;


public class ControladorEventosPaginaListadoVehiculos implements Initializable {
    
    /* VARIABLES
     
                                -- VARIABLES FXML --:
    */
    @FXML
    private AnchorPane countries;
    @FXML
    private AnchorPane marcas;
    @FXML
    private AnchorPane vehiculos;
    @FXML
    private Button resPregunta;
    @FXML
    private Button hazPregunta;
    @FXML
    private Button hazReseña;
    @FXML
    private Button perfil;
    @FXML
    private Button topAuto;
    @FXML
    private Button botonContinente; //Corresponde a America.
    @FXML
    private Button botonContinente2; //Corresponde a Europa.
    @FXML
    private Button botonContinente3; //Corresponde a Asia.


    
        //            EventHandlers - ActionEvents asignados a botones:
    EventHandler<ActionEvent> ButtonHandlerPais;
    EventHandler<ActionEvent> ButtonHandlerMarca;
    EventHandler<ActionEvent> ButtonHandlerVehiculo;
    ControladorVehiculo ControllerDatos;
 
    
          //            Variables locales de la clase:
    //todo - variable obsoleta, al probar funcionalidad, borrar:
    private ArrayList<Fabricante> MisFabricantes;
    private ArrayList<Pais> PaisesActuales = new ArrayList<>();
    private ArrayList<Fabricante> FabricantesActuales = new ArrayList<>();
    private ArrayList<Vehiculo> VehiculosActuales = new ArrayList<>();
    private final int VehiculosXPagina = 4;
    private final String colorButton = "-fx-background-color: #DFDFE5", defaultImagePath = "imagenes/default-vehicle.png";
    private int ListaPagInicial = 0, ListaPagFinal = VehiculosXPagina - 1;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
     //Mi creacion del Controlador de Datos y la obtencion de estos de la base de datos:
     this.ControllerDatos = new ControladorVehiculo();
     ControllerDatos.descargarDatos();
     
     this.MisFabricantes = ControllerDatos.getFabricantes();

     
     //Creación de EventHandlers que se le asignaran a los botones creados:
     this.ButtonHandlerPais = new EventHandler<ActionEvent>()
             {
                 @Override
                 public void handle (ActionEvent event)
                 {
                     createButtonsDeCountry((Button)event.getSource());
                 }
             };
     this.ButtonHandlerMarca = new EventHandler<ActionEvent>()
             {
                 @Override
                 public void handle (ActionEvent event)
                {
                    
                    crearBotonesDeMarca((Button)event.getSource());
                }
             };
     this.ButtonHandlerVehiculo = new EventHandler<ActionEvent>()
             {
                 @Override
                 public void handle (ActionEvent event)
                {
                    
                }
             };
    }    
    // Ya que los botones de continentes son estáticos, no es necesario asignar un EventHandler dinamico:
    @FXML
    private void clickContinent(ActionEvent event)
    {
        this.createButtonsDeContinent((Button)event.getSource());
    }
    /** Nuestro handler cuando un Boton de Area/Continente es presionado:
     * @param clickedButton -- El boton activado - Depende del texto que contiene el botón:
     */
    private void createButtonsDeContinent(Button clickedButton)
    {
        
        //Borro los botones de anteriores busquedas, si hay:
        //todo - No me esta realizando el clear - FIX:
        countries.getChildren().clear();
        marcas.getChildren().clear();
        vehiculos.getChildren().clear();
        PaisesActuales.clear();
        
        ArrayList<Button> but = new ArrayList<>();
        double ButtonWidth, ButtonHeight;
        int cont = 0;
        
        boolean CountryExists = false;
        
        //Recibo el nombre del continente colocado...
        String nameContinent = clickedButton.getText();
        
        //Hay tres areas programadas estáticamente - América, Europa y Asia:
        //botonContinente = America, botonContinente2 = Europa, botonContinente3 = Asia
        if(clickedButton.equals(this.botonContinente) || clickedButton.equals(this.botonContinente2) || clickedButton.equals(this.botonContinente3))
        {
            // Igualo mis Enumerados REGION equivalentes dependiendo del boton activado:
            if ( clickedButton.equals(this.botonContinente)) nameContinent = Region.AMERICAS.toString();
            else if (clickedButton.equals(this.botonContinente2)) nameContinent = Region.EUROPA.toString();
            else if (clickedButton.equals(this.botonContinente3)) nameContinent = Region.ASIA.toString();
            for ( Fabricante f : this.MisFabricantes)
            {
                
                //getRegion() devuelve un enumerado, se convierte en un string y lo comparo con el anterior!
                if(f.getRegion().toString().equals(nameContinent))
                {
                    //Por el diseño y por tiempo, toca implementar otro for dentro, aumentando la complejidad.
                    if (! this.PaisesActuales.isEmpty())
                    {
                       for ( Pais p : this.PaisesActuales)
                       {
                          if ( p.equals(f.getPais()))
                          {
                              CountryExists = true;
                          }
                       }
                    }
                    if ( CountryExists == true)CountryExists = false;
                    else this.PaisesActuales.add(f.getPais());

                }
            }
            if(!this.PaisesActuales.isEmpty())
            {
               ButtonWidth = (this.countries.getPrefWidth() / (double)this.PaisesActuales.size());
               ButtonHeight = this.countries.getPrefHeight();
               for(Pais v : this.PaisesActuales)
               {
                   but.add(new Button());
                   but.get(cont).setPrefWidth(ButtonWidth);
                   but.get(cont).setPrefHeight(ButtonHeight);
                   but.get(cont).setText(v.getNombre());
                   but.get(cont).setStyle(this.colorButton);
                   but.get(cont).setOnAction(this.ButtonHandlerPais);
                   AnchorPane.setLeftAnchor(but.get(cont), (double)(cont * ButtonWidth));
                   countries.getChildren().add(but.get(cont));
                   cont++;
               }
               
            }
            else
            {
                System.out.println("No se encuentran paises en la base de datos para este Continente");
            }
        }
        else
        {
            System.out.println("Botón Inválido");
        }
   
        
    } 
    /**Nuestro handler cuando un boton tipo Country es activado
     * @param clickedButton - El botón activado, depende del texto contenido de este...
     */
    private void createButtonsDeCountry(Button clickedButton)
    {
        marcas.getChildren().clear();
        vehiculos.getChildren().clear();
        ArrayList<Button> ButtonList = new ArrayList<>();
        double ButtonWidth, ButtonHeight;
        int Cont = 0;
        
        //Consigo el nombre del pais desde el boton...
        String NameCountry = clickedButton.getText();
        
        for( Pais v : this.PaisesActuales)
        {
            if(NameCountry.equals(v.getNombre()))
            {
                this.FabricantesActuales = v.getFabricantes();
            }
        }
        
        if (!this.FabricantesActuales.isEmpty())
        {
            ButtonWidth = (this.marcas.getPrefWidth() / (double)this.FabricantesActuales.size());
            ButtonHeight = this.marcas.getPrefHeight();
            for(Fabricante f : this.FabricantesActuales)
            {
                ButtonList.add(new Button());
                ButtonList.get(Cont).setPrefWidth(ButtonWidth);
                ButtonList.get(Cont).setPrefHeight(ButtonHeight);
                ButtonList.get(Cont).setText(f.getNombre());
                ButtonList.get(Cont).setStyle(this.colorButton);
                ButtonList.get(Cont).setOnAction(this.ButtonHandlerMarca);
                AnchorPane.setLeftAnchor(ButtonList.get(Cont), (double)(Cont * ButtonWidth));
                marcas.getChildren().add(ButtonList.get(Cont));
                Cont ++;
            }
        }
        else
        {
         System.out.println("No se encuentran Fabricantes en la base de datos de este Pais");
        }
        
     }
    /**Nuestro handler cuando un boton tipo Marca es activado
     * @param clickedButton - El botón activado, depende del texto contenido de este...
     */
    private void crearBotonesDeMarca(Button clickedButton)
    {
        // Declaracion de Datos:
        vehiculos.getChildren().clear();
        ArrayList<AnchorPane> PaneList = new ArrayList<>();
        ImageView FotoActual;
        Image miImage;
        Imagen miImagen;
        Text miTextCar;
        Button miBoton;
        double AnchorHeight = this.vehiculos.getPrefHeight() / VehiculosXPagina;
        double AnchorWidth = (5/6) * this.vehiculos.getPrefWidth(), offsetText = 10.0;
        int contador = 0, fontSize = 20;
        String nameMarca = clickedButton.getText();
         
         if (!(clickedButton.getText().equals("Sig. Pagina")) || (clickedButton.getText().equals("Prev. Pagina")))
         {
             
             this.ListaPagFinal = this.VehiculosXPagina - 1;
             this.ListaPagInicial = 0;
         }
   
         
         for( Fabricante v : this.FabricantesActuales)
         {
            if(nameMarca.equals(v.getNombre()))
            {
                this.VehiculosActuales = v.getVehiculos();
            }
         }
         if (this.VehiculosActuales.size() < this.VehiculosXPagina)
         {
             this.ListaPagFinal = this.VehiculosActuales.size();
         }
         System.out.println(this.ListaPagInicial + " and " + this.ListaPagFinal + "\n");
         if (!this.VehiculosActuales.isEmpty())
         {
            //Crear Imagen, Texto y Boton por ahora.
            
             for(Vehiculo v : this.VehiculosActuales.subList(this.ListaPagInicial, this.ListaPagFinal))
             {
                 //Extaigo el path de la imagen y creo mi variable tipo Image...
                 miImagen = v.getFotos().get(0);
                 miTextCar = new Text();
                 miBoton = new Button();
                 //Como es un array de imagenes - Siempre acepta la primera.
                 try
                 {
                    miImage = new Image(miImagen.getPath());
                 }
                 catch(IllegalArgumentException e) 
                 {
                     System.out.printf("Entro al catch!\n");
                     miImage = new Image (this.defaultImagePath); //Este path debe de estar correcto.
                 }
                 FotoActual = new ImageView();
                 FotoActual.setImage(miImage);
                 FotoActual.setFitHeight(AnchorHeight);
                 FotoActual.setFitWidth(AnchorHeight); //Width de Foto : esCuadrado
                 //Extraigo el texto con el nombre del Vehiculo:
                 if (v.getModelo().isEmpty())
                 {
                     miTextCar.setText("Name not specified.");
                 }
                 else miTextCar.setText(v.getModelo());
                 
                 
                 miTextCar.setFont(new Font(fontSize));
                 miTextCar.setWrappingWidth((((3 *AnchorWidth) / 4)) - offsetText); //Max Width de texto : 3/4 * Width - offset
                 //Creo el boton necesario:
                 miBoton.setText("Ver mas");
                 miBoton.setFont(new Font(fontSize/2));
                 miBoton.setStyle(this.colorButton);
                 miBoton.setOnAction(this.ButtonHandlerVehiculo); //Seteo mi action event!
                 miBoton.setPrefHeight(AnchorHeight / 4);
                 miBoton.setPrefWidth(AnchorHeight);
                                  
                 //Añado a los tres elementos a su padre - Asumiendo que se posiciones desde un pivote central:
                  //Ajusto posicion de nuestra imagen:
                 AnchorPane.setTopAnchor(FotoActual, 0.0);
                 AnchorPane.setLeftAnchor(FotoActual, offsetText);
                  //Ajusto posicion de nuestro texto:
                 AnchorPane.setLeftAnchor(miTextCar, (AnchorHeight + (offsetText * 2)));
                 AnchorPane.setTopAnchor(miTextCar, 0.0);
                  //Ajusto posicion de nuestro boton de carro:
                 AnchorPane.setLeftAnchor(miBoton, (AnchorHeight + (offsetText * 2)));
                 AnchorPane.setBottomAnchor(miBoton, 0.0);
                 //Creación de mi AnchorPane
                 PaneList.add(new AnchorPane());
                 PaneList.get(contador).getChildren().addAll(FotoActual, miTextCar, miBoton);
                 
                 //Posicion del AnchorPane en el Global
                 AnchorPane.setTopAnchor(PaneList.get(contador), AnchorHeight * contador);
                 this.vehiculos.getChildren().add (PaneList.get(contador));
                 contador++;
             }
                //Creación de Botones de navegación de Página:
              if (this.ListaPagFinal < this.VehiculosActuales.size() )
              {
                  
                  Button nextPageButtn = new Button();
                  //Creo el botón de Siguiente Página...
                  nextPageButtn.setText("Sig. Pagina");
                  nextPageButtn.setFont(new Font(fontSize/2));
                  nextPageButtn.setStyle(this.colorButton);
                  nextPageButtn.setPrefHeight(AnchorHeight / 4);
                  nextPageButtn.setPrefWidth(AnchorHeight);
                  nextPageButtn.setOnAction(this.ButtonHandlerMarca);
                  //Re-defino los boundaries de la lista.
                  if (((this.VehiculosActuales.size()) - this.ListaPagFinal) < this.VehiculosXPagina )
                  {
                      this.ListaPagFinal = this.VehiculosActuales.size();
                  }
                  else
                  {
                      this.ListaPagFinal += this.VehiculosXPagina;
                  }
                  this.ListaPagInicial += this.VehiculosXPagina;
                  AnchorPane.setBottomAnchor(nextPageButtn, offsetText);
                  AnchorPane.setRightAnchor(nextPageButtn, offsetText);
                  this.vehiculos.getChildren().add(nextPageButtn);
                  
              }
              if (this.ListaPagInicial > 0)
              {
                  Button lastPageButtn = new Button();
                  //Creo el botón de Siguiente Página...
                  lastPageButtn.setText("Prev. Pagina");
                  lastPageButtn.setFont(new Font(fontSize/2));
                  lastPageButtn.setStyle(this.colorButton);
                  lastPageButtn.setPrefHeight(AnchorHeight / 4);
                  lastPageButtn.setPrefWidth(AnchorHeight);
                  lastPageButtn.setOnAction(this.ButtonHandlerMarca);
                  this.ListaPagInicial-=this.VehiculosXPagina;
                  this.ListaPagFinal-= this.VehiculosXPagina;
                  AnchorPane.setBottomAnchor(lastPageButtn, offsetText);
                  AnchorPane.setRightAnchor(lastPageButtn, AnchorHeight + offsetText*2);
                  this.vehiculos.getChildren().add(lastPageButtn);
                  
              }
                
         }
        else
        {
            //Coloco un mensaje de error:
            System.out.println("No se encuentran vehiculos en este pais");
            Text textoCarro = new Text();
            textoCarro.setText("No existen Carros en esta categoria. Por favor seleccionar otra.");
            textoCarro.setFont(new Font(30));
            textoCarro.setWrappingWidth(1000);
       
      
            AnchorPane.setLeftAnchor(textoCarro, 180.0);
            AnchorPane.setTopAnchor(textoCarro, 90.0);
            vehiculos.getChildren().addAll(textoCarro);
        }

    }
    
    private void handlerBotonVehiculo(Button clickedButton)
    {
        // Envio a nueva página de vehiculo!
        // T B D
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
            stage.setTitle("Perfil Usuario");
            
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
            stage.setTitle("TopAuto");
            
            stage.setScene(scene);
            stage.show();
                        
            Stage myStage = (Stage) this.topAuto.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorEventosPaginaListadoVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
