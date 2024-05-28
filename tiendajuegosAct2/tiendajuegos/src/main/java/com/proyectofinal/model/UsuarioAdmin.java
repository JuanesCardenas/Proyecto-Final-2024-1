package com.proyectofinal.model;

public class UsuarioAdmin extends Usuario {
    //atributos
    private Builder builder;

    //definicion constructor: UsuarioAdmin 
    public UsuarioAdmin(String nombre, String contraseña, Builder builder) {
        super(nombre, contraseña);
        this.builder = builder;
    }

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Videojuego constructJuego(String titulo, String genero, int almacenamiento, int precio){
        builder.setTitulo(titulo);
        builder.setGenero(genero);
        builder.setAlmacenamiento(almacenamiento);
        builder.setPrecio(precio);
        return builder.getResult();
    }

    //metodo verificarContraseña
    @Override
    public boolean verificarContraseña(String contraseñaIngresada) {
        return this.contraseña.equals(contraseñaIngresada);
    }

}
