package com.proyectofinal.model;

public class Videojuego implements PrototypeJuego {
    //atributos
    private String titulo;
    private String genero;
    private int almacenamiento;
    private int precio;

    
    
    //constructor privado para no instanciar desde afuera de la clase
    public Videojuego(String titulo, String genero, int almacenamiento, int precio) {
        this.titulo = titulo;
        this.genero = genero;
        this.almacenamiento = almacenamiento;
        this.precio = precio;
    }

    

    //getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    //metodo clonar
    public Videojuego clonar() {
        return new Videojuego(titulo, genero, almacenamiento, precio);
    }

    //metodo para iniciar juego
    public String iniciarJuego(){
        return ("Iniciando juego: " + titulo);
    }


    //metodo toString
    @Override
    public String toString() {
        return "Videojuego [titulo=" + titulo + ", genero=" + genero + ", almacenamiento=" + almacenamiento
                + ", precio=" + precio + "]";
    }

    
}
