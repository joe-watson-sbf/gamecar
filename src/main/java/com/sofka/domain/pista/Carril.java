package com.sofka.domain.pista;

import java.util.ArrayList;
import java.util.List;
import com.sofka.domain.carro.Carro;

public class Carril{
    private int idCarril;
    private Carro carro;

    private Carril(int idCarril, Carro carro) {
        this.carro = carro;
        this.idCarril = idCarril;
    }

    public static List<Carril> asignarCarro(List<Carro> carros){
        List<Carril> ListCarril = new ArrayList<>();
        int id = 761;
        for (Carro carro : carros) {
            ListCarril.add(new Carril(id, carro));
            id++;
        }
        return ListCarril;
    }

    public boolean alacanzaLaMeta(float kilometros) {
        return (kilometros * 1000) <= (this.carro.getDistancia());
    }

    public String posicionActualDelCarro(){
        String message = "\nPosicion actual del carro\n_________________\n" +
                        "Carril " + idCarril +
                        "\nDistancia " + carro.getDistancia() + "\n_________________\n";
        return message;
    }

    public int getIdCarril(){
        return idCarril;
    }

    public Carro getCarro() {
        return carro;
    }

    @Override
    public String toString() {
        return "\nCarril " + idCarril;
    }

}
