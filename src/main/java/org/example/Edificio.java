package org.example;

public abstract class Edificio {
    protected String tipoEdificio;

    public Edificio(String tipoEdificio){
        this.tipoEdificio = tipoEdificio;
    }

    public String getTipoEdificio() {
        return tipoEdificio;
    }

    @Override
    public String toString() {
        return "Tipo de edificio: "+tipoEdificio;
    }
}
