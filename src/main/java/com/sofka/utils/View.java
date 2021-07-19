package com.sofka.utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.sofka.domain.carro.Carro;
import com.sofka.domain.juego.Juego;
import com.sofka.domain.juego.Jugador;
import com.sofka.domain.pista.Pista;

public class View {

    private List<Carro> carros = new ArrayList<>();
    private View(){}

    public static View instance(){
        return new View();
    }

    public Juego crearJuego(){
        System.out.println("\n\t\tConfiguración del Juego");
        Scanner input = new Scanner(System.in);
        Juego juego = null;
        
        System.out.println("Id del juego: ");
        int idJuego = input.nextInt();
        System.out.println("Limite de la pista en kilometro: ");
        float limite = input.nextFloat();
        Utils.clearConsole();
        juego = new Juego(idJuego, ingresarJugadores(input), new Pista(limite));
        input.close();
        return juego;
    }

    private List<Jugador> ingresarJugadores(Scanner input){
        List<Jugador> jugadores = new ArrayList<>();
        System.out.println("Ingrese al menos 3 jugadores para cada juego...");
        int contador = 1;
        String option = "s";
        while(option.equals("s")){
            System.out.println("Ingresa el "+ contador + "° jugador" );
            System.out.println("Id: ");
            int id = input.nextInt();
            System.out.println("Nombre: ");
            String nombre = input.next();

            Jugador jugador = Jugador.crear(id, nombre);
            if(!Utils.isExistJugador(jugadores, jugador)){
                ingresarCarros(jugador, input, contador);
                jugadores.add(jugador);
                contador++;
            }else{
                System.out.println("Ya existe un jugador con el id " + id);
            }
            
            if(jugadores.size()>2){
                System.out.println("¿Desea Ingresar más? s/n ");
                option = input.next().toLowerCase();
            }
        }
        return jugadores;
    }


    private void ingresarCarros(Jugador jugador, Scanner input, int idCarro){
        System.out.println("\nGrabar un carro para " + jugador.getNombre().toUpperCase());

        System.out.println("Marca: ");
        String marca = input.next();
        System.out.println("Nombre del conductor: ");
        String nombreConductor = input.next();
        
        this.carros.add(new Carro(idCarro, jugador, marca, nombreConductor));
    }

    public List<Carro> getCarros() {
        return carros;
    }
}
