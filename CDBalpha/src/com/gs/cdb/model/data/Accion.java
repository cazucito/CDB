/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gs.cdb.model.data;

import javax.swing.AbstractAction;

/**
 *
 * @author cazucito
 */
public class Accion {

    private String simbolo;
    private double precio;
    private int cantidad;

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    private double precioCompra;

    public Accion(String simbolo, double precio, int cantidad, double precioCompra) {
        this.simbolo = simbolo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
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
        precio = precio * (Math.random()*20);
        return precio;
    }
    /**
     * 
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @return the precioCompra
     */
    public double getPrecioCompra() {
        return precioCompra;
    }

    /**
     * @param precioCompra the precioCompra to set
     */
    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[accion:");
        sb.append("nombre:").append(simbolo).append(", ");
        sb.append("precio actual:").append(precio).append(", ");
        sb.append("precio compra:").append(precioCompra).append(", ");
        sb.append("cantidad:").append(cantidad);
        sb.append("]");
        return sb.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    public void imprimeDetalles() {
        System.out.println(toString());
    }
    public Accion customClone(){
        return new Accion(simbolo, precio, cantidad, precioCompra);
    }
}
