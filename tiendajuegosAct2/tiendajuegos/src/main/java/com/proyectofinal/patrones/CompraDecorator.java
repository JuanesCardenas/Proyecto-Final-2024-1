package com.proyectofinal.patrones;

import com.proyectofinal.model.Compra;
import com.proyectofinal.model.MetodoDePago;
import com.proyectofinal.model.UsuarioCliente;
import com.proyectofinal.model.Videojuego;

public abstract class CompraDecorator implements CompraInterface {
     //atributos
    protected Compra compra;

    //constructor
    public CompraDecorator(Compra compra) {
        this.compra = compra;
    }

    //getters
    @Override
    public UsuarioCliente getCliente() {
        return compra.getCliente();
    }

    @Override
    public Videojuego getJuego() {
        return compra.getJuego();
    }

    @Override
    public MetodoDePago getMetodoDePago() {
        return compra.getMetodoDePago();
    }

    @Override
    public int getDineroPagado() {
        return compra.getDineroPagado();
    }

    //metodo
    @Override
    public void comprarJuego() {
        //compra.comprarJuego();
    }
    
}
