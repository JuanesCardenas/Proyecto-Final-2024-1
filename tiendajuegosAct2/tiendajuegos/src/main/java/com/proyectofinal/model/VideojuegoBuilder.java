package com.proyectofinal.model;

public class VideojuegoBuilder implements Builder{
    //atributos
    private String titulo;
    private String genero;
    private int almacenamiento;
    private int precio;

    //builder set y get
    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    @Override
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    //
    public Videojuego getResult(){
        return new Videojuego(titulo, genero, almacenamiento, precio);
    }

}
