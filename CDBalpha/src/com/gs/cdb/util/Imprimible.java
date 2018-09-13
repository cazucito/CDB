/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gs.cdb.util;

/**
 *
 * @author cazucito
 */
public interface Imprimible {

    public default void imprimeResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t<");
        sb.append(toString());
        sb.append("/>");
        System.out.println(sb.toString());
    }
}
