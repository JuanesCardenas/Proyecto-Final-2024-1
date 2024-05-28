package com.proyectofinal.patrones;

import com.proyectofinal.model.MetodoDePago;
import com.proyectofinal.model.UsuarioCliente;
import com.proyectofinal.model.Videojuego;

public interface CompraInterface {
    UsuarioCliente getCliente();
    Videojuego getJuego();
    MetodoDePago getMetodoDePago();
    int getDineroPagado();
    void comprarJuego();
}
