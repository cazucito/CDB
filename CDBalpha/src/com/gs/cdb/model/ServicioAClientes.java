
package com.gs.cdb.model;

import com.gs.cdb.model.data.Cliente;
import java.util.List;

/**
 *
 */
public interface ServicioAClientes {
    public abstract void altaCliente(Cliente cliente);
    public abstract void bajaCliente(int claveCliente);
    public abstract void cambioDatosCliente(Cliente cliente);
    public abstract Cliente consultaCliente(int claveCliente);
    public abstract void listarClientes();
    public abstract List<Cliente> obtenerClientes(Cliente cliente);
}
