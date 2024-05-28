package com.proyectofinal.model;

public abstract class Usuario {
    //atributos
    private String nombre;
    protected String contraseña;
    
    //definicion constructor
    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    //metodo
    public abstract boolean verificarContraseña(String contraseña);

}
