package com.proyectofinal;

import javafx.scene.Scene;

public class VistaEstadoMemento {
    private final Scene state;

    public VistaEstadoMemento(Scene state) {
        this.state = state;
    }

    public Scene getState() {
        return state;
    }
}
