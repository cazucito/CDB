/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gs.cdb.model.data;

/**
 *
 * @author cazucito
 */
public class Accion {

    private String simbolo;
    private double precio;
    private int cantidad;

    public Accion(String simbolo, double precio, int cantidad) {
        this.simbolo = simbolo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /**
     * @return the simbolo
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

}
