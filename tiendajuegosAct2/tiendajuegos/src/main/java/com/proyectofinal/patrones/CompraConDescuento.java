package com.proyectofinal.patrones;

import com.proyectofinal.model.Compra;

public class CompraConDescuento extends CompraDecorator {
    //atributos
    private int descuento;

    //constructor
    public CompraConDescuento(Compra compra, int descuento) {
        super(compra);
        this.descuento = descuento;
    }

    //metodo para comprar un juego y aplicar su descuento
    public void comprarJuego() {
        // Aplicar el descuento
        int precioOriginal = compra.getJuego().getPrecio();
        int precioConDescuento = precioOriginal - (precioOriginal * descuento / 100);
        compra.getJuego().setPrecio(precioConDescuento);
        super.comprarJuego();
        // Restaurar el precio original después de la compra
        compra.getJuego().setPrecio(precioOriginal);
    }
    
}
