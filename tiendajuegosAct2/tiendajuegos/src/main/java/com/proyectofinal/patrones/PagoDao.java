package com.proyectofinal.patrones;
// Interfaz DAO

import com.proyectofinal.model.MetodoDePago;

public interface PagoDao {
    boolean procesarPago(MetodoDePago metodoDePago, int cantidad);
    boolean verificarMetodoDePago(MetodoDePago metodoDePago);
    boolean verificarFondos(int cantidad);
}