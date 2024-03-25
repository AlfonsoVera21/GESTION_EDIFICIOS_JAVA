package org.example;

import java.util.ArrayList;
import java.util.List;

public class Residencial extends Edificio{
    //private List<String> inquilinos;
    private String nombre;
    private String direccion;
    private int numPisos;

    public Residencial(String nombre, String direccion, int numPisos) {
        super("Residencial");
        this.nombre = nombre;
        this.direccion = direccion;
        this.numPisos = numPisos;
    }

    @Override
    public String toString() {
        return  super.toString()+", nombre edificio: " + nombre + ", direccion: " + direccion +", numPisos: " + numPisos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNumPisos() {
        return numPisos;
    }
}
