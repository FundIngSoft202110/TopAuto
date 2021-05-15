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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    private TextField texto;
    @FXML
    private Button topAuto;
    @FXML
    private ImageView norAmerica;
    @FXML
    private Button botonContinente;
    @FXML
    private Button botonContinente2;
    @FXML
    private Button botonContinente3;
    @FXML
    private Button botonPais;
    @FXML
    private Button botonVehiculo;

    
        //            EventHandlers - ActionEvents asignados a botones:
    EventHandler<ActionEvent> ButtonHandlerPais;
    EventHandler<ActionEvent> ButtonHandlerMarca;
    EventHandler<ActionEvent> ButtonHandlerVehiculo;
    ControladorVehiculo ControllerDatos;
    
          //            Variables locales de la clase:
    private ArrayList<Pais> MisPaises;
    private ArrayList<Pais> PaisesActuales = new ArrayList<Pais>();
    private ArrayList<Fabricante> FabricantesActuales = new ArrayList<Fabricante>();
    private ArrayList<Vehiculo> VehiculosActuales = new ArrayList<Vehiculo>();
    private final int VehiculosXPagina = 6;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
     //Mi creacion del Controlador de Datos y la obtencion de estos de la base de datos:
     this.ControllerDatos = new ControladorVehiculo();
     ControllerDatos.descargarDatos();
     
     
     this.MisPaises = ControllerDatos.getPaises();

     
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
                    crearBotonesDeMarca((Button)event.getSource());
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
        countries.getChildren().clear();
        marcas.getChildren().clear();
        vehiculos.getChildren().clear();
        
        ArrayList<Button> but = new ArrayList<Button>();
        double ButtonWidth, ButtonHeight;
        int cont = 0;
        
        //Recibo el nombre del continente colocado...
        String nameContinent = clickedButton.getText();
        
        //Hay tres areas programadas estáticamente - América, Europa y Asia:
        if(nameContinent.equals("America") || nameContinent.equals("Europa") || nameContinent.equals("Asia"))
        {
            for ( Pais v : this.MisPaises)
            {
                if(v.getNombre().equals(nameContinent))
                {
                    this.PaisesActuales.add(v);
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
        ArrayList<Button> ButtonList = new ArrayList<Button>();
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
                ButtonList.get(Cont).setOnAction(this.ButtonHandlerMarca);
                AnchorPane.setLeftAnchor(ButtonList.get(Cont), (double)(Cont * ButtonWidth));
                countries.getChildren().add(ButtonList.get(Cont));
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
        ArrayList<AnchorPane> PaneList = new ArrayList<AnchorPane>();
        ImageView FotoActual;
        Image miImage;
        Imagen miImagen;
        Text miTextCar = new Text();
        Button miBoton = new Button();
        double AnchorHeight = this.vehiculos.getPrefHeight() / VehiculosXPagina;
        double AnchorWidth = (5/6) * this.vehiculos.getPrefWidth(), offsetText = 10.0;
        int contador = 0, fontSize = 20;
        String nameMarca = clickedButton.getText();
         
         for( Fabricante v : this.FabricantesActuales)
         {
            if(nameMarca.equals(v.getNombre()))
            {
                this.VehiculosActuales = v.getVehiculos();
            }
         }
         if (!this.VehiculosActuales.isEmpty())
         {
            //Crear Imagen, Texto y Boton por ahora.
            
             for(Vehiculo v : this.VehiculosActuales)
             {
                 //Extaigo el path de la imagen y creo mi variable tipo Image...
                 miImagen = v.getFotos().get(0); //Como es un array de imagenes - Siempre acepta la primera.
                 miImage = new Image(miImagen.getPath());
                 FotoActual = new ImageView();
                 FotoActual.setImage(miImage);
                 FotoActual.setFitHeight(AnchorHeight);
                 FotoActual.setFitWidth(AnchorWidth / 4); //Width de Foto : Width / 4
                 //Extraigo el texto con el nombre del Vehiculo:
                 miTextCar.setText(v.getModelo());
                 miTextCar.setFont(new Font(fontSize));
                 miTextCar.setWrappingWidth((((3 *AnchorWidth) / 4)) - offsetText); //Max Width de texto : 3/4 * Width - offset
                 //Creo el boton necesario:
                 miBoton.setText("Ver mas");
                 miBoton.setOnAction(this.ButtonHandlerVehiculo); //Seteo mi action event!
                 miBoton.setPrefHeight(AnchorHeight / 4);
                 miBoton.setPrefWidth(AnchorWidth / 4);
                                  
                 //Añado a los tres elementos a su padre - Asumiendo que se posiciones desde un pivote central:
                  //Ajusto posicion de nuestra imagen:
                 AnchorPane.setTopAnchor(FotoActual, AnchorHeight / 2);
                 AnchorPane.setLeftAnchor(FotoActual, 0.0);
                  //Ajusto posicion de nuestro texto:
                 AnchorPane.setLeftAnchor(miTextCar, (AnchorWidth / 4) + offsetText);
                 AnchorPane.setBottomAnchor(miTextCar, (double)fontSize / 2);
                  //Ajusto posicion de nuestro boton de carro:
                 AnchorPane.setLeftAnchor(miBoton, (AnchorWidth / 4) + offsetText);
                 AnchorPane.setTopAnchor(miBoton, AnchorHeight / 8);
                 //Creación de mi AnchorPane
                 PaneList.add(new AnchorPane());
                 PaneList.get(contador).getChildren().addAll(FotoActual, miTextCar, miBoton);
                 
                 //Posicion del AnchorPane en el Global
                 AnchorPane.setTopAnchor(PaneList.get(contador), AnchorHeight * contador);
                 this.vehiculos.getChildren().add (PaneList.get(contador));
                 contador++;
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
