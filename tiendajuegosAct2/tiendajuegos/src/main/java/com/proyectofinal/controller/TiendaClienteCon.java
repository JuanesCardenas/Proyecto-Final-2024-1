package com.proyectofinal.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.proyectofinal.App;
import com.proyectofinal.model.SesionUsuario;
import com.proyectofinal.model.TiendaVirtual;
import com.proyectofinal.model.UsuarioCliente;
import com.proyectofinal.model.Videojuego;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TiendaClienteCon {
    //Datos de FXML
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<Videojuego> listaJuegosComprados;

    @FXML
    private TableView<Videojuego> tableJuegosComprados;
    
    @FXML
    private TableColumn<Videojuego, Integer> columnaAlmacena;

    @FXML
    private TableColumn<Videojuego, String> columnaGenero;

    @FXML
    private TableColumn<Videojuego, String> columnaNombre;

    @FXML
    private TableColumn<Videojuego, Integer> disponiblesAlmacena;

    @FXML
    private TableColumn<Videojuego, String> disponiblesGenero;

    @FXML
    private TableColumn<Videojuego, String> disponiblesNombre;

    @FXML
    private TableColumn<Videojuego, Integer> disponiblesPrecio;

    @FXML
    private TableColumn<Videojuego, Void> columCompra;

    @FXML
    private TableView<Videojuego> tableJuegosTienda;

    @FXML
    void initialize() {
        iniciarTablaComprados();
        iniciarTablaTienda();
    }

    public void iniciarTablaComprados(){
        // Obtener el usuario actual de la sesión
        UsuarioCliente cliente = (UsuarioCliente) SesionUsuario.getUsuarioActual(); 

        // Método para obtener la lista de juegos
        List<Videojuego> juegos = cliente.getJuegos(); 

        // Configurar las columnas
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        columnaGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        columnaAlmacena.setCellValueFactory(new PropertyValueFactory<>("almacenamiento"));

        // Obtener y establecer los datos en el TableView (lista de juegos)
        tableJuegosComprados.setItems(FXCollections.observableList(juegos));
    }

    public void iniciarTablaTienda(){
        // Método para obtener la lista de juegos
        List<Videojuego> juegosTienda = TiendaVirtual.getinstancia().getJuegos(); 

        // Configurar las celdas
        disponiblesNombre.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        disponiblesGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        disponiblesAlmacena.setCellValueFactory(new PropertyValueFactory<>("almacenamiento"));
        disponiblesPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        // Obtener y establecer los datos en el TableView (lista de juegos)
        columCompra.setCellFactory(param -> new TableCell<>() {
            private final Button botonComprar = new Button("Comprar");

            {
                // Acción al presionar el botón de compra
                botonComprar.setOnAction(event -> {
                    Videojuego juegoAComprar = getTableView().getItems().get(getIndex());
                    // Lógica para comprar el juego
                    mostrarVentanaCompra(juegoAComprar);
                    iniciarTablaComprados();
                });
            }

            // Actualizar el contenido de una celda en una tabla
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(botonComprar);
                }
            }
        });


        // Obtener y establecer los datos en el TableView (lista de juegos)
        tableJuegosTienda.setItems(FXCollections.observableList(juegosTienda));
    }

    private void mostrarVentanaCompra(Videojuego juegoAComprar) {
        try {
            // Cargar el archivo FXML de la ventana de compra
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/proyectofinal/compra.fxml"));

            /* Obtener el controlador de la ventana de compra
            CompraCon controlador = loader.getController();
            controlador.setJuego(juegoAComprar); // Configurar el juego seleccionado en el controlador
            controlador.initialize();*/

            CompraCon controlador = new CompraCon(juegoAComprar);
            loader.setController(controlador);
        
            Parent root = loader.load();

            // Crear una nueva ventana de diálogo modal para la ventana de compra
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setTitle("Realizar compra");
            dialogStage.setScene(new Scene(root));

            // Mostrar la ventana de compra como un diálogo modal
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void volver(ActionEvent event) {
        App.getInstance().goBack();
    }
    

}
