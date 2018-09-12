package com.gs.cdb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    private Connection obtenConexion() {
        try {
            cxn = DriverManager.getConnection(url, usuario, password);
        } catch (Exception ex) {
            System.err.println("CXN ERROR" + ex.getMessage());
        }
        return cxn;
    }
}
