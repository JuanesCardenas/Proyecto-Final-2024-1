package com.proyectofinal;

import java.util.Stack;

public class VistaEstadoCuidador {
    private final Stack<VistaEstadoMemento> mementoStack;

    public VistaEstadoCuidador() {
        this.mementoStack = new Stack<>();
    }

    public void addMemento(VistaEstadoMemento memento) {
        mementoStack.push(memento);
    }

    public VistaEstadoMemento getPreviousState() {
        if (!mementoStack.isEmpty()) {
            return mementoStack.pop();
        }
        return null;
    }

    public Stack<VistaEstadoMemento> getStack(){
        return mementoStack;
    }
}
