package com.sofka.domain.juego;
import java.util.ArrayList;
import java.util.List;
import com.sofka.domain.pista.Carril;
import com.sofka.domain.pista.Pista;
import com.sofka.domain.podio.Podio;
import com.sofka.utils.Utils;

public class Juego {
    private int id;
    private List<Jugador> jugadores;
    private List<Jugador> ganadores;
    private Pista pista;

    public Juego(int id, List<Jugador> jugadores, Pista pista){
        this.id = id;
        this.jugadores = jugadores;
        this.pista = pista;
    }

    public boolean iniciar() {
        if(jugadores.size()>=3) {
            this.ganadores = new ArrayList<>();
            System.out.println("\nSe inicia el JUEGO " + id);
            return true;
        }
        return false;
    }

    public boolean isEjecutando() {
        return ganadores.size()<3;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    private void obtenerGanadores(Carril carril){
        if(carril.alacanzaLaMeta(pista.getKilometros())){
            if(!Utils.isExistJugador(ganadores, carril.getCarro().getJugador())){
                ganadores.add(carril.getCarro().getJugador());
            }
            
        }
    }

    public Podio ListarResultadoFinal(){
        Podio podio = new Podio();
        if(!isEjecutando()){
            podio.definirPuestos(ganadores);
            System.out.println(podio.toString());
        }
        return podio;
    }

    public void avanzarCarroEncarril(List<Carril> carriles){
        pista.setNumeroDeCarriles(carriles.size());
        System.out.println("\n________ JUEGO "+ id +" _________\n");
        carriles.stream().forEach(carril ->{
            carril.getCarro().avanzar();
            showProgresoEnCarriles(carril);
            obtenerGanadores(carril);
        });
        System.out.println("\n__________________________________\n");
    }

    private void showProgresoEnCarriles(Carril carril){
        String message = "\n\tINFO PISTA\n" + pista.toString() + 
        "\n\n\tPROGRESO EN EL CARRIL" +
        carril.toString().toUpperCase() + "\n" + carril.getCarro();
        System.out.println(message);
    }

    public int getId() {
        return id;
    }

    public  List<Jugador> getJugadores() {
        return jugadores;
    }

    public Pista getPista() {
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }

    public List<Jugador> getGanadores() {
        return ganadores;
    }
}
