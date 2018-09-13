package com.gs.cdb.test;

import com.gs.cdb.model.NoExisteClienteException;
import com.gs.cdb.model.data.Cliente;
import com.gs.cdb.model.data.ClienteDAO;
import com.gs.cdb.model.data.Domicilio;
import com.gs.cdb.model.data.GestorLlaves;
import com.gs.cdb.model.data.Portafolio;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAOTest {

    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();
        System.out.println("||||| MUESTRA CLIENTES");
        dao.obtenListadoClientes().stream().forEach(Cliente::imprimeResumen);
        System.out.println("||||| OBTEN CLIENTE:id=10");
        try {
            dao.obtenCliente(10).imprimeResumen();
        } catch (NoExisteClienteException ex) {
            Logger.getLogger(ClienteDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("CLIENTE:id=00 [NO EXISTE]");
        try {
            dao.obtenCliente(0).imprimeResumen();
        } catch (NoExisteClienteException ex) {
            System.out.println("NO EXISTE EL CLIENTE: " + 0);
            Logger.getLogger(ClienteDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("||||| ALTA CLIENTE");
        int llaveCliente = GestorLlaves.obtenSigLlave("cliente", "clavecliente");
        int llaveDomicilio = GestorLlaves.obtenSigLlave("domicilio", "iddomicilio");
        Cliente c = new Cliente(
                llaveCliente, "NombreAlta" + llaveCliente, "APaternoAlta" + llaveCliente,
                "AMaternoAlta" + llaveCliente, "RFCAlta" + llaveCliente, LocalDate.of(1999, Month.JUNE, 15),
                new Domicilio(
                        llaveDomicilio,
                        "calleALta" + llaveDomicilio, llaveDomicilio + "Alta",
                        "ColAlta" + llaveDomicilio, "LocalidadAlta" + llaveDomicilio,
                        "EstadoAlta" + llaveDomicilio, llaveDomicilio), new Portafolio());
        dao.altaCliente(c);
        try {
            dao.obtenCliente(llaveCliente).imprimeResumen();
        } catch (NoExisteClienteException ex) {
            Logger.getLogger(ClienteDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("||||| ACTUALIZA CLIENTE");
        Cliente clienteActualizar=null;
        try {
            clienteActualizar = dao.obtenCliente(llaveCliente);
        } catch (NoExisteClienteException ex) {
            Logger.getLogger(ClienteDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        clienteActualizar.setNombres("ClienteACTUALIZADO" + clienteActualizar.getIdCliente());
        clienteActualizar.getDomicilio().setCalle("CalleACTUALIZADA" + clienteActualizar.getDomicilio().getIdDomicilio());
        try {
            dao.obtenCliente(llaveCliente).imprimeResumen();
        } catch (NoExisteClienteException ex) {
            Logger.getLogger(ClienteDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.cambioCliente(clienteActualizar);
        try {
            dao.obtenCliente(llaveCliente).imprimeResumen();
        } catch (NoExisteClienteException ex) {
            Logger.getLogger(ClienteDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("||||| BAJA CLIENTE");
        try {
            dao.obtenCliente(llaveCliente).imprimeResumen();
        } catch (NoExisteClienteException ex) {
            Logger.getLogger(ClienteDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.bajaCliente(llaveCliente);
        Cliente clienteBorrado=null;
        try {
            clienteBorrado = dao.obtenCliente(llaveCliente);
        } catch (NoExisteClienteException ex) {
            Logger.getLogger(ClienteDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clienteBorrado != null) {
            clienteBorrado.imprimeResumen();
        } else {
            System.out.println("\tCliente borrado id:" + llaveCliente);
        }
    }
}
