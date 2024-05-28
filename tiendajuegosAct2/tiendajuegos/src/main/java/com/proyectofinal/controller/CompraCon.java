package com.proyectofinal.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.proyectofinal.VentanaMensaje;
import com.proyectofinal.model.Compra;
import com.proyectofinal.model.MetodoDePago;
import com.proyectofinal.model.SesionUsuario;
import com.proyectofinal.model.UsuarioCliente;
import com.proyectofinal.model.Videojuego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CompraCon {
    //Datos de FXML
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<MetodoDePago> pagoChoice;

    @FXML
    private TextField pagoText;

    @FXML
    private Text precioText;

    @FXML
    private Text tituloText;

    private Videojuego juegoAComprar;

    //Acción al presionar botón de comprar.
    @FXML
    void comprarJuego(ActionEvent event) {
        //Define la variable de lo que ingresó en el campo de texto
        String pagoStr = pagoText.getText();
        try{
            int pago = Integer.parseInt(pagoStr);
            //Hace referencia al usuario que está en sesión y efectúa la compra.
            UsuarioCliente usuario = (UsuarioCliente) SesionUsuario.getUsuarioActual();
            Compra compra = new Compra(usuario, juegoAComprar, pagoChoice.getValue(), pago);
            compra.comprarJuego(usuario, juegoAComprar, pago);
            
        }catch(NumberFormatException e){
            VentanaMensaje.mostrarError("Ingrese solo números.");
        }
    }

    //Constructor del Controlador.
    public CompraCon(Videojuego juego){
        this.juegoAComprar = juego;
    }

    @FXML
    void initialize() {
        //Define los valores de la caja de opciones y selecciona TARJETA por default.
        pagoChoice.getItems().addAll(MetodoDePago.values());
        pagoChoice.setValue(MetodoDePago.TARJETA);
        if (juegoAComprar != null) {
            // Inicializa la vista con los datos del juego.
            tituloText.setText(juegoAComprar.getTitulo());
            precioText.setText(String.valueOf(juegoAComprar.getPrecio()));
        } else {
            //Error por si el jueggo es nulo (Usado en pruebas de código)
            VentanaMensaje.mostrarError("Error: juegoAComprar es nulo.");
        }
    }
    

}