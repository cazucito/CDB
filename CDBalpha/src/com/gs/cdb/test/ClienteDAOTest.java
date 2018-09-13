package com.gs.cdb.test;

import com.gs.cdb.model.data.Cliente;
import com.gs.cdb.model.data.ClienteDAO;
import com.gs.cdb.model.data.Domicilio;
import com.gs.cdb.model.data.GestorLlaves;
import com.gs.cdb.model.data.Portafolio;
import java.time.LocalDate;
import java.time.Month;

public class ClienteDAOTest {

    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();
        System.out.println("||||| MUESTRA CLIENTES");
        dao.obtenListadoClientes().stream().forEach(Cliente::imprimeResumen);
        System.out.println("||||| OBTEN CLIENTE:id=10");
        dao.obtenCliente(10).imprimeResumen();
        //System.out.println("CLIENTE:id=00 [NO EXISTE]");
        //dao.obtenCliente(0).imprimeResumen();
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
        dao.obtenCliente(llaveCliente).imprimeResumen();
        System.out.println("||||| ACTUALIZA CLIENTE");
        Cliente clienteActualizar = dao.obtenCliente(llaveCliente);
        clienteActualizar.setNombres("ClienteACTUALIZADO" + clienteActualizar.getIdCliente());
        clienteActualizar.getDomicilio().setCalle("CalleACTUALIZADA" + clienteActualizar.getDomicilio().getIdDomicilio());
        dao.obtenCliente(llaveCliente).imprimeResumen();
        dao.cambioCliente(clienteActualizar);
        dao.obtenCliente(llaveCliente).imprimeResumen();
        System.out.println("||||| BAJA CLIENTE");
        dao.obtenCliente(llaveCliente).imprimeResumen();
        dao.bajaCliente(llaveCliente);
        Cliente clienteBorrado = dao.obtenCliente(llaveCliente);
        if (clienteBorrado != null) {
            clienteBorrado.imprimeResumen();
        } else {
            System.out.println("\tCliente borrado id:" + llaveCliente);
        }
    }
}
