/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author juanpchica
 */
public class Molde {
    private String dimensiones,columna,lado,tipo,ubicacion;
    private int ID,estado,soporte,boquete;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getSoporte() {
        return soporte;
    }

    public void setSoporte(int soporte) {
        this.soporte = soporte;
    }

    public int getBoquete() {
        return boquete;
    }

    public void setBoquete(int boquete) {
        this.boquete = boquete;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion() {
        this.ubicacion = "C:"+this.columna+", "+"L:"+this.lado;
    }
    private int cantidad;
    
    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getLado() {
        return lado;
    }

    public void setLado(String lado) {
        this.lado = lado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }
}
