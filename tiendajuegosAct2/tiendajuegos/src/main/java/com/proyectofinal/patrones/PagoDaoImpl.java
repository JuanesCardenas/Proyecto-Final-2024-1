package com.proyectofinal.patrones;

import com.proyectofinal.model.MetodoDePago;

// Implementación de la interfaz DAO
public class PagoDaoImpl implements PagoDao {

    @Override
    public boolean procesarPago(MetodoDePago metodoDePago, int cantidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'procesarPago'");
    }

    @Override
    public boolean verificarMetodoDePago(MetodoDePago metodoDePago) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificarMetodoDePago'");
    }

    @Override
    public boolean verificarFondos(int cantidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificarFondos'");
    }
    // Aquí puedes implementar los métodos de la interfaz DAO
}