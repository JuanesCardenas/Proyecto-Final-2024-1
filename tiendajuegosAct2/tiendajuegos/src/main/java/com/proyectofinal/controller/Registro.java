package com.proyectofinal.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.proyectofinal.App;
import com.proyectofinal.VentanaMensaje;
import com.proyectofinal.model.TiendaVirtual;
import com.proyectofinal.model.UsuarioAdmin;
import com.proyectofinal.model.UsuarioCliente;
import com.proyectofinal.model.VideojuegoBuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Registro {
    //Datos de FXML
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField contraseñaRegistroTextField;

    @FXML
    private TextField nombreRegistroTextField;

    @FXML
    private ChoiceBox<String> tipoUsuarioChoice;


    @FXML
    void registrar(ActionEvent event) {
        //Asigna los datos ingresados en los campos de texto como variables.
        String nombreUsuario = nombreRegistroTextField.getText();
        String contraseñaUsuario = contraseñaRegistroTextField.getText();

        //Muestra ventana de error por si hay campos vacíos
        if (nombreUsuario.isEmpty() || contraseñaUsuario.isEmpty()) {
            VentanaMensaje.mostrarError("Hay campos sin rellenar.");
            return; //Evita que continúe el método
        }

        //Mira si existe el usuario
        boolean existe = verificarUsuarioExiste(nombreUsuario);
        
        if (!existe){
             // Obtener el tipo de usuario seleccionado
            String tipoUsuario = tipoUsuarioChoice.getValue();
            switch (tipoUsuario) {
                //Genera un usuario nuevo según su tipo.
                case "Cliente":
                    UsuarioCliente cliente = new UsuarioCliente(nombreUsuario, contraseñaUsuario, new ArrayList<>());
                    TiendaVirtual.getinstancia().agregarUsuario(cliente);
                    VentanaMensaje.mostrarExito("Usuario cliente creado correctamente! \nPuede volver al menú de login.");
                    break;
                case "Admin":
                    VideojuegoBuilder builder = new VideojuegoBuilder(); // No estoy seguro si esta es la forma correcta de crear un builder
                    UsuarioAdmin admin = new UsuarioAdmin(nombreUsuario, contraseñaUsuario, builder);
                    TiendaVirtual.getinstancia().agregarUsuario(admin);
                    VentanaMensaje.mostrarExito("Usuario admin creado correctamente! \nPuede volver al menú de login.");
                    break;
                default:
                    VentanaMensaje.mostrarError("Tipo de usuario inválido");
                    break;
            }
        }else {
        VentanaMensaje.mostrarError("Este usuario ya existe.");
        }
    }

    private boolean verificarUsuarioExiste(String nombreIngresado) {
        //Verifica la existencia del usuario por el nombre ingresado.
        boolean existe = TiendaVirtual.getinstancia().verificarUsuarioExiste(nombreIngresado);
        return existe;
    }

    @FXML
    void volver(ActionEvent event) {
        //Vuelve a la vista anterior.
        App.getInstance().goBack();
    }

    @FXML
    void initialize() {
        //En el ChoiceBox, añade las opciones de usuario.
        tipoUsuarioChoice.getItems().addAll("Cliente", "Admin");
        tipoUsuarioChoice.setValue("Cliente");
    }

}

