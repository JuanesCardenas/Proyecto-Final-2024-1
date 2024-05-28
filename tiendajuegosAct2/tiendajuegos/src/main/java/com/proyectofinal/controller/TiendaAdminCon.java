package com.proyectofinal.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.proyectofinal.App;
import com.proyectofinal.model.TiendaVirtual;
import com.proyectofinal.model.Videojuego;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TiendaAdminCon {
    //Datos de FXML
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Videojuego, Integer> disponiblesAlmacena;

    @FXML
    private TableColumn<Videojuego, String> disponiblesGenero;

    @FXML
    private TableColumn<Videojuego, String> disponiblesNombre;

    @FXML
    private TableColumn<Videojuego, Integer> disponiblesPrecio;

    @FXML
    private TableColumn<Videojuego, Void> columEditar;

    @FXML
    private TableColumn<Videojuego, Void> columEliminar;

    @FXML
    private TableView<Videojuego> tableJuegosTienda;


    @FXML
    void initialize() {
        iniciarTablaTienda();
    }

    @FXML
    void mostrarVentanaCrear(ActionEvent event) {
        try {
            //Cargar el archivo FXML de la ventana de compra
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/proyectofinal/creadorJuego.fxml"));
            Parent root = loader.load();

            //Crear una nueva ventana de diálogo modal para la ventana de compra
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setTitle("Creando ando.");
            dialogStage.setScene(new Scene(root));

            //Muestra la ventana de compra como un diálogo modal
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        iniciarTablaTienda();
    }
    

    public void iniciarTablaTienda(){
        List<Videojuego> juegosTienda = TiendaVirtual.getinstancia().getJuegos(); // Método para obtener la lista de juegos

        disponiblesNombre.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        disponiblesGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        disponiblesAlmacena.setCellValueFactory(new PropertyValueFactory<>("almacenamiento"));
        disponiblesPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        columEditar.setCellFactory(param -> new TableCell<>() {
            private final Button botonComprar = new Button("Editar");

            {
                //Acción al presionar el botón de compra
                botonComprar.setOnAction(event -> {
                    Videojuego juegoAEditar = getTableView().getItems().get(getIndex());
                    //Lógica para comprar el juego
                    System.out.println("Editando juego: " + juegoAEditar.getTitulo());
                    mostrarVentanaEditar(juegoAEditar);
                    iniciarTablaTienda();
                });
            }
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

        columEliminar.setCellFactory(param -> new TableCell<>() {
            private final Button botonComprar = new Button("Eliminar");

            {
                // Acción al presionar el botón de compra
                botonComprar.setOnAction(event -> {
                    Videojuego juegoAEliminar = getTableView().getItems().get(getIndex());
                    // Lógica para comprar el juego
                    juegosTienda.remove(juegoAEliminar);
                    iniciarTablaTienda();
                });
            }
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

    private void mostrarVentanaEditar(Videojuego juegoAEditar) {
        try {
            // Cargar el archivo FXML de la ventana de compra
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/proyectofinal/editor.fxml"));

            EditorCon controlador = new EditorCon(juegoAEditar);
            loader.setController(controlador);
        
            Parent root = loader.load();

            // Crear una nueva ventana de diálogo modal para la ventana de compra
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setTitle("Editando ando.");
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
