package com.sofka.domain.pista;

public class Pista {
    private float kilometros;
    private int numeroDeCarriles;

    public Pista(float kilometros) {
        this.kilometros = kilometros;
        this.numeroDeCarriles = 0;
    }

    public float getKilometros() {
        return kilometros;
    }

    public int getNumeroDeCarriles() {
        return numeroDeCarriles;
    }

    public float getMetros(){
        return kilometros*1000;
    }

    public void setNumeroDeCarriles(int numeroDeCarriles) {
        this.numeroDeCarriles = numeroDeCarriles;
    }

    @Override
    public String toString() {
        return "Distancia en kilometro: " + kilometros + " K"+
                "\nNumero de carriles: " + numeroDeCarriles;
    }
}
