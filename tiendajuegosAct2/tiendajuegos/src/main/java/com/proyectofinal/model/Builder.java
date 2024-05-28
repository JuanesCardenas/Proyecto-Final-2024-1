package com.proyectofinal.model;
// Interface builder videojuegos
public interface Builder {
    public void setTitulo(String titulo);
    public void setGenero(String genero);
    public void setAlmacenamiento(int almacenamiento);
    public void setPrecio(int precio);
    public Videojuego getResult();
}
