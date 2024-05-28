package com.proyectofinal.model;

import java.util.List;
import java.util.ArrayList;

public class TiendaVirtual {
    //atributos
    private List<Videojuego> juegos;
    private List<Usuario> usuarios;

    //instancia (singleton)
    private static TiendaVirtual instancia;

    //constructor  privado para evitar instancias fuera de la clase.
    private TiendaVirtual() {
        //inicializar listas
        juegos = new ArrayList<>();
        usuarios = new ArrayList<>();

        Videojuego juego1 = new Videojuego("Mario", "Plataforma", 3, 50);
        Videojuego juego2 = new Videojuego("Zelda", "Aventura", 8, 60);
        Videojuego juego3 = new Videojuego("Pikmin", "Quien sabe", 1, 40);
        Videojuego juego4 = new Videojuego("Doshin the Giant", "Simulador", 9, 20);

        List<Videojuego> juegos1 = new ArrayList<>();
        juegos1.add(juego1);
        juegos1.add(juego2);
        Builder builder = new VideojuegoBuilder();

        UsuarioCliente usuario1 = new UsuarioCliente("usu1", "con1", juegos1);
        UsuarioAdmin usuario2 = new UsuarioAdmin("admin1", "con2",builder);
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        juegos.add(juego1);
        juegos.add(juego2);
        juegos.add(juego3);
        juegos.add(juego4);

    }

    //metodo estatico para obtener la instancia(singleton)
    public static TiendaVirtual getinstancia(){
        if (instancia == null) {
            instancia = new TiendaVirtual();
            
        }
        return instancia;
    }

    //getters y setters
    public List<Videojuego> getJuegos() {
        return juegos;
    }
    public void setJuegos(List<Videojuego> juegos) {
        this.juegos = juegos;
    }
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    //metodo para comprarJuego
    public void comprarJuego(UsuarioCliente cliente, Videojuego juego, MetodoDePago metodoDePago, int dineroPagado){
        Compra compra = new Compra(cliente, juego, metodoDePago, dineroPagado);
        compra.comprarJuego(cliente, juego, dineroPagado);
    }

    //metodo para verificarAcceso de usuarios
    public boolean verificarAcceso(Usuario usuarioIngresado) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(usuarioIngresado.getNombre())) {
                return usuario.verificarContraseña(usuarioIngresado.getContraseña());
            }
        }
        return false;
    }

    //metodo para obtener los Usuarios desde la Tienda
    public Usuario obtenerUsuarioDesdeTienda(String nombreUsuario, String contraseña) {
        // Buscar un usuario en la lista de usuarios que coincida con el nombre de usuario y la contraseña
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                return usuario; // Devolver el usuario si se encuentra
            }
        }
        return null; // Devolver null si no se encuentra ningún usuario
    }

    //metodo agregar usuario
    public void agregarUsuario (Usuario usuario){
        usuarios.add(usuario);
    }

    //metodo verificarUsuarioExiste
    public boolean verificarUsuarioExiste(String nombre){
        boolean existe = false;
        for(Usuario usuario: usuarios){
            if(usuario.getNombre().equals(nombre)){
                existe = true;
                return existe;
            }
        }
        return existe;
    }

    //metodo para verificarTitulo
    public boolean verificarTitulo(String nombre){
        boolean existe = false;
        for(Videojuego juego: juegos){
            if(juego.getTitulo().equals(nombre)){
                existe = true;
                return existe;
            }
        }
        return existe;
    }
    
    //metodo verificarGenero
    public boolean verificarGenero(String genero){
        boolean existe = false;
        for(Videojuego juego: juegos){
            if(juego.getGenero().equals(genero)){
                existe = true;
                return existe;
            }
        }
        return existe;
    }

    //metodo para verificarPrecio
    public boolean verificarPrecio(int precio){
        boolean existe = false;
        for(Videojuego juego: juegos){
            if(juego.getPrecio() == (precio)){
                existe = true;
                return existe;
            }
        }
        return existe;
    }

    //metodo para verificarAlmacenamiento
    public boolean verificarAlmacenamiento(int almacenamiento){
        boolean existe = false;
        for(Videojuego juego: juegos){
            if(juego.getAlmacenamiento() == (almacenamiento)){
                existe = true;
                return existe;
            }
        }
        return existe;
    }
}
