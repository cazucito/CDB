package com.gs.cdb.model;

import com.gs.cdb.model.data.Accion;
import com.gs.cdb.model.data.Cliente;
import java.util.ArrayList;
import java.util.Optional;
import org.apache.derby.impl.store.access.btree.OpenBTree;

/**
 *
 */
public class CasaDeBolsa {

    private static CasaDeBolsa cdb = new CasaDeBolsa();
    ArrayList<Accion> acciones = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();

    private CasaDeBolsa() {
        acciones.add(new Accion("ACC1", 100, 10, 0));
        acciones.add(new Accion("ACC2", 100, 10, 0));
        acciones.add(new Accion("ACC3", 100, 10, 0));
    }

    public static CasaDeBolsa getSingleton() {
        return cdb;
    }

    public void agregaCliente(Cliente c) {
        clientes.add(c);
    }

    public void imprimeBienvenida() {
        StringBuilder sb = new StringBuilder();
        sb.append("||========================================================||").append("\n");
        sb.append("||               BIENVENIDO A CDB BITCOIN GS              ||").append("\n");
        sb.append("||========================================================||").append("\n");
        System.out.println(sb.toString());
    }

    public void imprimeAccionesDisponibles() {
        acciones.forEach(Accion::imprimeDetalles);
    }

    public Cliente obtenCliente(int idCliente) {
        Optional<Cliente> optC = Optional.empty();
        Cliente cliente = null;
        optC = clientes.stream().filter(c
                -> c.getIdCliente() == idCliente)
                .findFirst();
        if (optC.isPresent()) {
            cliente = optC.get();
        }
        return cliente;
    }

    public Accion obtenAccion(String simbolo) {
        Optional<Accion> optA = Optional.empty();
        Accion accion = null;
        optA = acciones.stream().filter(s
                -> s.getSimbolo().equals(simbolo))
                .findFirst();
        if (optA.isPresent()) {
            accion = optA.get();
        }
        return accion;
    }

    public void actualizaAccion(Accion a) {
        acciones.stream()
                .filter(acc -> acc.getSimbolo().equals(a.getSimbolo()))
                .forEach(acc2 -> acc2.setCantidad(acc2.getCantidad() - a.getCantidad()));

    }
}
