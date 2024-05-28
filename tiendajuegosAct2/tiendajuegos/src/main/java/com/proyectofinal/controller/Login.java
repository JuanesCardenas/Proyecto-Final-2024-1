package com.proyectofinal.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.proyectofinal.App;
import com.proyectofinal.VentanaMensaje;
import com.proyectofinal.model.SesionUsuario;
import com.proyectofinal.model.TiendaVirtual;
import com.proyectofinal.model.Usuario;
import com.proyectofinal.model.UsuarioAdmin;
import com.proyectofinal.model.UsuarioCliente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Login {
    //Datos de FXML
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField contraseñaLoginTextField;

    @FXML
    private TextField nombreLoginTextField;

    @FXML
    private Button cambiarARegistroButton;


    @FXML
    void cambiarARegistro(ActionEvent event){
        //Cambia la ventana a la de registro.
        App.getInstance().loadScene("/com/proyectofinal/registro.fxml");
    }

    @FXML
    void ingresar(ActionEvent event) {
        //Asigna los datos ingresados en los campos de texto como variables.
        String nombreUsuario = nombreLoginTextField.getText();
        String contraseñaUsuario = contraseñaLoginTextField.getText();
        //Genera la instancia de la tienda para ver si el usuario ya existe en esta.
        TiendaVirtual tienda = TiendaVirtual.getinstancia();
        Usuario usuario = tienda.obtenerUsuarioDesdeTienda(nombreUsuario, contraseñaUsuario);
        //Si el usuario no es null y sí existe
        if (usuario != null) {
            //Asigna este usuario como el usuario en sesión.
            SesionUsuario.setUsuarioActual(usuario);
            //Pasa a cargar la vista de tienda.
            cargarTienda(usuario);
        } else {
            // Autenticación fallida
            VentanaMensaje.mostrarError("Nombre de usuario o contraseña incorrectos.");
        }
    }
    @FXML
    void initialize() {
        assert contraseñaLoginTextField != null : "fx:id=\"contraseñaLoginTextField\" was not injected: check your FXML file 'login.fxml'.";
        assert nombreLoginTextField != null : "fx:id=\"nombreLoginTextField\" was not injected: check your FXML file 'login.fxml'.";

    }

    public void cargarTienda(Usuario usuario){
        if (usuario instanceof UsuarioCliente) {
            //Redirige a la vista de cliente si es un cliente.
            App.getInstance().loadScene("/com/proyectofinal/tiendaCliente.fxml");
        } else if (usuario instanceof UsuarioAdmin) {
            //Redirige a la vista de admin si es un admin.
            App.getInstance().loadScene("/com/proyectofinal/tiendaAdmin.fxml");
        } else {
            //Por si no es válido el usuario (Implementado probando el código)
            VentanaMensaje.mostrarError("Tipo de usuario no válido.");
        }
    }
}
