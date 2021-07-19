package com.sofka.domain.carro;
import java.util.Random;
import com.sofka.domain.juego.Jugador;

public class Carro extends Conductor{
    private int id;
    private Jugador Jugador;
    private String marca;
    private float distancia;

    public Carro(int id, Jugador Jugador, String marca, String nombreConductor) {
        super(nombreConductor);
        this.id = id;
        this.Jugador = Jugador;
        this.marca = marca;
        this.distancia = 0;
        definirConductor();
    }

    public Jugador getJugador() {
        return Jugador;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getDistancia() {
        return distancia;
    }

    private void setDistancia(float distanciaActual) {
        this.distancia += distanciaActual;
    }

    public int getCarroId(){
        return id;
    }

    public void avanzar(){
        setDistancia(lanzarDado());
    }

    @Override
    protected int lanzarDado() {
        Random random = new Random();
        return random.nextInt(6) * 100;
    }

    private void definirConductor(){
        /** Si el nombre del Conductor esta nulo o vacio 
         * entonces asignamos el Jugador como conductor */
        try {
            if(super.getNombre().trim().length() == 0) 
            super.setNombre(this.Jugador.getNombre());
        } catch (Exception e) {
            super.setNombre(" ");
            definirConductor();
        }   
    }

    @Override
    public String toString() {
        return "Nombre del Conductor: " + super.getNombre() + 
        "\nNombre del Jugador: " + this.Jugador.getNombre() +
        "\nMarca: " + this.marca + 
        "\nDistancia Recorrido: " + this.distancia + " m\n";
    }
}