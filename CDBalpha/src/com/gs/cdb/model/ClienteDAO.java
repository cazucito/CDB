package com.gs.cdb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    private Connection cxn;
    private String url = "jdbc:derby://localhost:1527/CasaDeBolsaDB";
    private String usuario = "usuario";
    private String password = "usuario";

    public ClienteDAO() {

    }

    public List<Cliente> obtenListadoClientes() {
        List<Cliente> clientes = null;
        var sqlSelect = "SELECT * FROM CLIENTE";
        try {
            PreparedStatement pstmt = obtenConexion().prepareStatement(sqlSelect);
            ResultSet rs = pstmt.executeQuery();
            clientes = new ArrayList<>();
            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("iDCLIENTE"),
                        rs.getString("NOMBRES"),
                        rs.getString("APELLIDOPATERNO"),
                        rs.getString("APELLIDOMATERNO"),
                        rs.getString("RFC"),
                        (rs.getDate("FECHANACIMIENTO")).toLocalDate(),
                        rs.getInt("IDDOMICILIO"),
                        rs.getInt("IDPORTAFOLIO")
                );
                clientes.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    public Cliente obtenCliente(int id) {
        Optional<Cliente> cl = obtenListaClientesMemoria().stream()
                .filter(c -> c.getIdCliente() == id).findFirst();
        Cliente clienteEncontrado = null;
        if (cl.isPresent()) {
            clienteEncontrado = cl.get();
        }
        return clienteEncontrado;
    }

    private Connection obtenConexion() {
        try {
            cxn = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException ex) {
            while (ex != null) {
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Error Code:" + ex.getErrorCode());
                System.out.println("Message: " + ex.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause:" + t);
                    t = t.getCause();
                }
                ex = ex.getNextException();
            }
        }
        return cxn;
    }

    private List<Cliente> obtenListaClientesMemoria() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(
                new Cliente(
                        10,
                        "Nombre1",
                        "Paterno1",
                        "Materno1",
                        "RFC1",
                        LocalDate.of(2000, Month.MARCH, 15),
                        10,
                        10
                )
        );
        clientes.add(
                new Cliente(
                        20,
                        "Nombre2",
                        "Paterno2",
                        "Materno2",
                        "RFC2",
                        LocalDate.of(2000, Month.MARCH, 15),
                        20,
                        20
                )
        );
        return clientes;
    }
}
