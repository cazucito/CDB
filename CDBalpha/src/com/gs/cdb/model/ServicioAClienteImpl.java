package com.gs.cdb.model;

import com.gs.cdb.model.data.Cliente;
import com.gs.cdb.model.data.ClienteDAO;
import com.gs.cdb.model.data.Domicilio;
import com.gs.cdb.model.data.GestorLlaves;
import com.gs.cdb.model.data.Portafolio;
import com.gs.cdb.test.ClienteDAOTest;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cazucito
 */
public class ServicioAClienteImpl implements ServicioAClientes {

    ClienteDAO dao;

    public ServicioAClienteImpl() {
        dao = new ClienteDAO();
    }

    @Override
    public void altaCliente(Cliente cliente) {
        dao.altaCliente(cliente);
    }

    @Override
    public void bajaCliente(int claveCliente) {
        dao.bajaCliente(claveCliente);
    }

    @Override
    public void cambioDatosCliente(Cliente cliente) {
        dao.cambioCliente(cliente);
    }

    @Override
    public Cliente consultaCliente(int claveCliente) {
        Cliente c = null;
        try {
            c = dao.obtenCliente(claveCliente);
        } catch (NoExisteClienteException ex) {
            System.out.println("\tNo Existe el cliente con id: " + claveCliente);;
        }
        return c;
    }

    @Override
    public void listarClientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> obtenerClientes(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
