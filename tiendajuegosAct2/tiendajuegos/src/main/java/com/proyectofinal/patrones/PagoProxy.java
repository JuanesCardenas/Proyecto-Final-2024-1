package com.proyectofinal.patrones;

import com.proyectofinal.model.MetodoDePago;

// Clase Proxy que utiliza el DAO
public class PagoProxy implements PagoInterface {
    private PagoDao pagoDao;
    private MetodoDePago metodoDePago;

    public PagoProxy(PagoDao pagoDao, MetodoDePago metodoDePago) {
        this.pagoDao = pagoDao;
        this.metodoDePago = metodoDePago;
    }

    public PagoProxy(MetodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
        this.pagoDao = new PagoDaoImpl();
    }

    @Override
    public boolean procesarPago(int cantidad) {
        if (pagoDao.verificarMetodoDePago(metodoDePago)) {
            if (pagoDao.verificarFondos(cantidad)) {
                return pagoDao.procesarPago(metodoDePago, cantidad);
            } else {
                System.out.println("Fondos insuficientes para " + metodoDePago);
                return false;
            }
        } else {
            System.out.println("Método de pago no es válido: " + metodoDePago);
            return false;
        }
    }
}