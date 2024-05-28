package com.proyectofinal.model;

public class SesionUsuario {
    //atributos
    private static Usuario usuarioActual;
    //constructor
    public static void setUsuarioActual(Usuario usuario) {
        usuarioActual = usuario;
    }
    //getters
    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }
}

