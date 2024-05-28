package com.proyectofinal.model;

import java.util.List;

public class UsuarioCliente extends Usuario {
    //atributos
    private List<Videojuego> juegos;

    //constructor
    public UsuarioCliente(String nombre, String contraseña, List<Videojuego> juegos) {
        super(nombre, contraseña);
        this.juegos = juegos;
    }

    //getters y setters
    public List<Videojuego> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<Videojuego> juegos) {
        this.juegos = juegos;
    }

    //metodo para agregar un juego comprado, a la lista de juegos.
    public void agregarJuegoComprado(Videojuego juego){
        juegos.add(juego);
    }

    //metodo juegoYaComprado
    public boolean juegoYaComprado(Videojuego juegoCompra){
        boolean comprado = false;
        for(Videojuego juego: juegos)
            if (juego.getTitulo() == juegoCompra.getTitulo()){
                comprado = true;
                break;
            }
        return comprado;
    }

    //metodo para verificar la contraseña
    @Override
    public boolean verificarContraseña(String contraseñaIngresada) {
        return this.contraseña.equals(contraseñaIngresada);
    }
}
