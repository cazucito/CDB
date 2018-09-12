package com.gs.cdb.model;

import java.util.List;

public class ClienteDAOTest {

    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> clientes = dao.obtenListadoClientes();

    }
}
