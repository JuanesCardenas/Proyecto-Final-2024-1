package com.proyectofinal.patrones;

import com.proyectofinal.model.MetodoDePago;

//clase concreta "Pago" que implementa PagoInterface
public class Pago implements PagoInterface {
    //atributos
    private MetodoDePago metodoDePago;

    //constructor
    public Pago(MetodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    //metodo para procesar pagos
    @Override
    public boolean procesarPago(int cantidad) {
        System.out.println("Procesando el pago de " + cantidad + " con " + metodoDePago);
        return true;
    }

}