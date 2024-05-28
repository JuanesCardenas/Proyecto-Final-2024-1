package com.proyectofinal.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.proyectofinal.VentanaMensaje;
import com.proyectofinal.model.TiendaVirtual;
import com.proyectofinal.model.Videojuego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditorCon {
    //Datos de FXML
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField almacenaEditTextField;

    @FXML
    private TextField generoEditTextField;

    @FXML
    private TextField precioEditTextField;

    @FXML
    private TextField tituloEditTextField;
    //Atributo del juego que se está editando.
    private Videojuego juegoAEditar;


    @FXML
    void guardarDatosJuego(ActionEvent event) {
        //Asigna los datos ingresados en los campos de texto como variables.
        String tituloNuevo = tituloEditTextField.getText();
        String generoNuevo = generoEditTextField.getText();

        if(tituloNuevo.isEmpty() || generoNuevo.isEmpty() || almacenaEditTextField.getText().isEmpty() || precioEditTextField.getText().isEmpty()){
            VentanaMensaje.mostrarError("Hay campos vacíos");
            return; //Evita que continúe el método.
        }

        int almacenaNuevo;
        int precioNuevo;

        try {
            //Intenta convertir los campos que usan enteros.
            almacenaNuevo = Integer.parseInt(almacenaEditTextField.getText());
            precioNuevo = Integer.parseInt(precioEditTextField.getText());
        } catch (NumberFormatException e) {
            //Si en uno de los campos no hay números válidos.
            VentanaMensaje.mostrarError("El valor de almacenamiento y precio deben ser números enteros.");
            return; //Evita que continúe el método.
        }

        // Actualiza los datos del juego con los datos introducidos o editados en los campos de texto.
        if(TiendaVirtual.getinstancia().verificarTitulo(tituloNuevo) ||  TiendaVirtual.getinstancia().verificarGenero(generoNuevo) || TiendaVirtual.getinstancia().verificarPrecio(precioNuevo) || TiendaVirtual.getinstancia().verificarAlmacenamiento(almacenaNuevo)){
            juegoAEditar.setTitulo(tituloNuevo);
            juegoAEditar.setGenero(generoNuevo);
            juegoAEditar.setPrecio(precioNuevo);
            juegoAEditar.setAlmacenamiento(almacenaNuevo);
        }
        else{
            VentanaMensaje.mostrarError("El nombre es igual a un juego existente.");
        }

    }

    @FXML
    void initialize() {
        //Asigna en los campos de texto los datos del juego por comodidad.
        tituloEditTextField.setText(juegoAEditar.getTitulo());
        generoEditTextField.setText(juegoAEditar.getGenero());
        precioEditTextField.setText(String.valueOf(juegoAEditar.getPrecio()));
        almacenaEditTextField.setText(String.valueOf(juegoAEditar.getAlmacenamiento()));
        
    }
    //Constructor del controlador
    public EditorCon(Videojuego juego){
        this.juegoAEditar = juego;
    }

}