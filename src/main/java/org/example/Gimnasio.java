package org.example;

public class Gimnasio extends Edificio{
    private String nombre;
    private String direccion;
    private int numPisos;

    public Gimnasio(String nombre, String direccion, int numPisos) {
        super("Gimnasio");
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
