package com.sofka.domain.carro;

public abstract class Conductor {
    private String nombre;

    public Conductor(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected abstract int lanzarDado();
}
