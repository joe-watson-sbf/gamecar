package com.sofka.domain.podio;
import java.util.List;

import com.sofka.domain.juego.Jugador;

public class Podio {

    private Jugador primerLugar;
    private Jugador segundoLugar;
    private Jugador tercerLugar;

    public Podio() {}

    public void definirPuestos(List<Jugador> ganadores){
        if(this.primerLugar == null) this.primerLugar = ganadores.get(0);
        if(this.segundoLugar == null) this.segundoLugar = ganadores.get(1);
        if(this.tercerLugar == null) this.tercerLugar = ganadores.get(2);
        asignarPuntosAlGanadores();
    }

    private void asignarPuntosAlGanadores(){
        this.primerLugar.asignarPuntos(1);
        this.primerLugar.setPuesto(1);
        this.segundoLugar.asignarPuntos(1);
        this.segundoLugar.setPuesto(2);
        this.tercerLugar.asignarPuntos(1);
        this.tercerLugar.setPuesto(3);
    }

    public Jugador getPrimerLugar() {
        return primerLugar;
    }

    public Jugador getSegundoLugar() {
        return segundoLugar;
    }

    public Jugador getTercerLugar() {
        return tercerLugar;
    }

    @Override
    public String toString() {
        return "\n\tPODIO " + 
                "\n========= Primer Puesto ========= \n" +
                primerLugar.imprimir() +
                "\n========= Segundo Puesto ========= \n" +
                segundoLugar.imprimir() +
                "\n========= Tercer Puesto ========= \n" +
                tercerLugar.imprimir();
    }
}
