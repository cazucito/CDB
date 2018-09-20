package com.gs.cdb.model.data;

import com.gs.cdb.model.CasaDeBolsa;
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
        acciones = new ArrayList<>();
        movimientos = new ArrayList<>();
    }

    public Portafolio(int idPortafolio) {
        this.idPortafolio = idPortafolio;
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

    public void compraAcciones(Accion a, int cuantas) {
        Accion aC = a.customClone();
        aC.setPrecioCompra(a.getPrecio()); 
        aC.setCantidad(cuantas);
        if (acciones.stream()
                .filter(acc -> acc.getSimbolo().equals(a.getSimbolo())).count() == 0) {
            acciones.add(aC);
        } else {
            acciones.stream()
                    .filter(acc -> acc.getSimbolo().equals(aC.getSimbolo()))
                    .forEach(acc2 -> acc2
                            .setCantidad(acc2.getCantidad() 
                                    + aC.getCantidad()));
        }
        // ELIMINAR LAS COMPRADAS DE LA CDB
        CasaDeBolsa cdb = CasaDeBolsa.getSingleton();
        cdb.actualizaAccion(aC);
    }

    public void imprimeAccionesCliente() {
        acciones.forEach(Accion::imprimeDetalles);
    }
}
