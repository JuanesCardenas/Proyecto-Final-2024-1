package com.proyectofinal.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.proyectofinal.VentanaMensaje;
import com.proyectofinal.model.SesionUsuario;
import com.proyectofinal.model.TiendaVirtual;
import com.proyectofinal.model.UsuarioAdmin;
import com.proyectofinal.model.Videojuego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CrearCon {
    //Datos de FXML
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField almacenaCreaTextField;

    @FXML
    private TextField generoCreaTextField;

    @FXML
    private TextField precioCreaTextField;

    @FXML
    private TextField tituloCreaTextField;

    List<Videojuego> juegosTienda = TiendaVirtual.getinstancia().getJuegos();

    @FXML
    void crearJuego(ActionEvent event) {
        //Tiene en cuenta el usuario en sesión.
        UsuarioAdmin admin = (UsuarioAdmin) SesionUsuario.getUsuarioActual();

        //Asigna los datos ingresados en los campos de texto como variables.
        String titulo = tituloCreaTextField.getText();
        String genero = generoCreaTextField.getText();
        if(titulo.isEmpty() || genero.isEmpty() || almacenaCreaTextField.getText().isEmpty() || precioCreaTextField.getText().isEmpty()){
            VentanaMensaje.mostrarError("Hay campos vacíos");
            return; //Evita que continúe el método.
        }

        int almacena;
        int precio;

        try {
            //Intenta convertir los campos que usan enteros.
            almacena = Integer.parseInt(almacenaCreaTextField.getText());
            precio = Integer.parseInt(precioCreaTextField.getText());
        } catch (NumberFormatException e) {
            //Si en uno de los campos no hay números válidos.
            VentanaMensaje.mostrarError("El valor de almacenamiento y precio deben ser números enteros.");
            return; //Evita que continúe el método.
        }

        //El admin se encarga de crear el juego y verificar que no exista uno con el mismo nombre.
        Videojuego juegoCreado = admin.constructJuego(titulo, genero, almacena, precio);
        if(!TiendaVirtual.getinstancia().verificarTitulo(titulo)){
            juegosTienda.add(juegoCreado);
            VentanaMensaje.mostrarExito("Juego creado correctamente! \nPuede cerrar la pantalla de edición.");
        }
        else{
            VentanaMensaje.mostrarError("Este juego ya Existe.");
        }
    }

    @FXML
    void initialize() {
        
    }


}