package com.gs.cdb.model.data;

import com.gs.cdb.util.Imprimible;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author cazucito
 */
public class Portafolio implements Imprimible {
    private int idPortafolio;
    private LocalDate fechaApertura;
    private LocalDate fechaCancelacion;
    private double saldoTotalAcciones;
    private ArrayList<Accion> acciones;
    private ArrayList<Movimiento> movimientos;
    /**
     * Portafolio vacío
     */
    public Portafolio() {
    }

    public Portafolio(int idPortafolio) {
        this.idPortafolio=idPortafolio;
    }

    public int getIdPortafolio() {
        return idPortafolio;
    }
    
       @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id:").append(idPortafolio);
        return sb.toString();
    }

    public void imprimeResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t<");
        sb.append(toString());
        sb.append("/>");
        System.out.println(sb.toString());
    }
}
