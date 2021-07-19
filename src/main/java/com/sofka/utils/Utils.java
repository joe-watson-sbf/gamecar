package com.sofka.utils;
import java.io.IOException;
import java.util.List;
import com.sofka.domain.juego.Jugador;

public class Utils {

    public static boolean isExistJugador(List<Jugador> jugadores, Jugador jugador){
        Jugador jugador2 = null;
        try {
            jugador2 = jugadores.stream()
                .filter( e -> e.getId() == jugador.getId())
                .findFirst().get();
        } catch (Exception e) {}

        return jugador2 !=null;
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {} catch (IOException e) {}
    }

    public static void Sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) { }
    }

}
