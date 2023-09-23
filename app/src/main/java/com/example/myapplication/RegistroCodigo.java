package com.example.myapplication;

import java.io.Serializable;

public class RegistroCodigo implements Serializable {
    private String codigo;
    private String descripcion;
    private double costo;

    public RegistroCodigo(String codigo,String descripcion,double costo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
