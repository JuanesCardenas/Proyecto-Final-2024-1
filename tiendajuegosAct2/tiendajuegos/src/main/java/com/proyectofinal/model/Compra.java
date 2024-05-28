package com.proyectofinal.model;

import com.proyectofinal.VentanaMensaje;

public class Compra {
    //atributos
    private UsuarioCliente cliente;
    private Videojuego juego;
    private MetodoDePago metodoDePago;
    private int dineroPagado;

    //constructor 
    public Compra(UsuarioCliente cliente, Videojuego juego, MetodoDePago metodoDePago, int dineroPagado) {
        this.cliente = cliente;
        this.juego = juego;
        this.metodoDePago = metodoDePago;
        this.dineroPagado = dineroPagado;
    }
    //getters y setters
    public UsuarioCliente getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioCliente cliente) {
        this.cliente = cliente;
    }

    public Videojuego getJuego() {
        return juego;
    }

    public void setJuego(Videojuego juego) {
        this.juego = juego;
    }

    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(MetodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public int getDineroPagado() {
        return dineroPagado;
    }

    public void setDineroPagado(int dineroPagado) {
        this.dineroPagado = dineroPagado;
    }

    //metodo para comprarJuego
    public void comprarJuego(UsuarioCliente cliente, Videojuego  juego, int dineroPagado){
        if(cliente.juegoYaComprado(juego) == false){
            if (dineroPagado >= juego.getPrecio()) {
                Videojuego juegoClon = juego.clonar();
                cliente.agregarJuegoComprado(juegoClon);
                VentanaMensaje.mostrarExito("Compra exitosa!\nSe ha añadido " + juego.getTitulo() + " a su lista de juegos.");
            }
            else{
                VentanaMensaje.mostrarError("Fondos insuficientes.");
            }
        }
        else{
            VentanaMensaje.mostrarError("Usted ya tiene este juego comprado.");
        }
    }


}
