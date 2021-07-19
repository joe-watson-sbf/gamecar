package com.sofka.domain.juego;

public class Jugador {
    private Integer id;
    private String nombre;
    private int puesto;
    private Integer puntos;

    private Jugador(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.puntos = 0;
        this.puesto=0;
    }

    public static Jugador crear(Integer id, String nombre) {
        return new Jugador(id, nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public Integer getId() {
        return id;
    }

    public void asignarPuntos(Integer punto) {
        this.puntos += punto;
    }

    public String imprimir() {
        return "Id: " + this.getId() +
            "\nNombre: " + this.getNombre() +
            "\nPuntos: " + this.getPuntos() + "\n";
    }
    

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return new StringBuffer("{id : ").append(id)
                .append(", nombre: ").append(nombre)
                .append(", puntos : ").append(puntos)
                .append('}').toString();
    }
}
