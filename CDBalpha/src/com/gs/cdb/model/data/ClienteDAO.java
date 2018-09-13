package com.gs.cdb.model.data;

import com.gs.cdb.model.NoExisteClienteException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    public ClienteDAO() {
    }

    public List<Cliente> obtenListadoClientes() {
        List<Cliente> clientes = null;
        var sqlSelect = "SELECT * FROM CLIENTE";
        Connection cxn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            cxn = GestorDeCxnABD.obtenConexion();
            pStmt = cxn.prepareStatement(sqlSelect);
            rs = pStmt.executeQuery();
            clientes = new ArrayList<>();
            DomicilioDAO domDAO = new DomicilioDAO();
            PortafolioDAO portDAO = new PortafolioDAO();
            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("CLAVECLIENTE"),
                        rs.getString("NOMBRES"),
                        rs.getString("APELLIDOPATERNO"),
                        rs.getString("APELLIDOMATERNO"),
                        rs.getString("RFC"),
                        (rs.getDate("FECHANACIMIENTO")).toLocalDate(),
                        domDAO.obtenPorId(rs.getInt("IDDOMICILIO")),
                        portDAO.obtenPorId(rs.getInt("IDPORTAFOLIO"))
                );
                clientes.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GestorDeCxnABD.cierraObjeto(rs, pStmt, cxn);
        }
        return clientes;
    }

    public Cliente obtenCliente(int id) throws NoExisteClienteException {
        var sqlSelect = "SELECT * FROM cliente WHERE clavecliente=?";
        Connection cxn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        Cliente c = null;
        try {
            cxn = GestorDeCxnABD.obtenConexion();
            pStmt = cxn.prepareStatement(sqlSelect);
            pStmt.setInt(1, id);
            rs = pStmt.executeQuery();
            DomicilioDAO domDAO = new DomicilioDAO();
            PortafolioDAO portDAO = new PortafolioDAO();
            while (rs.next()) {
                c = new Cliente(
                        rs.getInt("CLAVECLIENTE"),
                        rs.getString("NOMBRES"),
                        rs.getString("APELLIDOPATERNO"),
                        rs.getString("APELLIDOMATERNO"),
                        rs.getString("RFC"),
                        (rs.getDate("FECHANACIMIENTO")).toLocalDate(),
                        domDAO.obtenPorId(rs.getInt("IDDOMICILIO")),
                        portDAO.obtenPorId(rs.getInt("IDPORTAFOLIO"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GestorDeCxnABD.cierraObjeto(rs, pStmt, cxn);
        }
        if (c == null) {
            throw new NoExisteClienteException("No existe el cliente con el id: " + id);
        }

        return c;
    }

    public void cambioCliente(Cliente c) {
        var sqlSelect = "UPDATE cliente SET nombres=?, apellidopaterno=?, apellidomaterno=?,"
                + " fechanacimiento=?, rfc=?, iddomicilio=?, idportafolio=?"
                + " WHERE clavecliente=?";
        Connection cxn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        DomicilioDAO domDAO = new DomicilioDAO();
        domDAO.cambio(c.getDomicilio());
        try {
            cxn = GestorDeCxnABD.obtenConexion();
            pStmt = cxn.prepareStatement(sqlSelect);
            pStmt.setString(1, c.getNombres());
            pStmt.setString(2, c.getApellidoPaterno());
            pStmt.setString(3, c.getApellidoMaterno());
            pStmt.setDate(4, Date.valueOf(c.getFechaNacimiento()));
            pStmt.setString(5, c.getRfc());
            pStmt.setInt(6, c.getDomicilio().getIdDomicilio());
            pStmt.setInt(7, c.getPortafolio().getIdPortafolio());
            pStmt.setInt(8, c.getIdCliente());
            int res = pStmt.executeUpdate();
        } catch (SQLException ex) {
            domDAO.baja(c.getDomicilio());
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GestorDeCxnABD.cierraObjeto(rs, pStmt, cxn);
        }
    }

    public void altaCliente(Cliente c) {
        var sqlSelect = "INSERT INTO cliente (clavecliente, nombres, apellidopaterno, apellidomaterno, fechanacimiento, rfc, iddomicilio, idportafolio)"
                + "    VALUES (?,?,?,?,?,?,?,?)";
        Connection cxn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        DomicilioDAO domDAO = new DomicilioDAO();
        domDAO.alta(c.getDomicilio());
        try {
            cxn = GestorDeCxnABD.obtenConexion();
            pStmt = cxn.prepareStatement(sqlSelect);
            pStmt.setInt(1, c.getIdCliente());
            pStmt.setString(2, c.getNombres());
            pStmt.setString(3, c.getApellidoPaterno());
            pStmt.setString(4, c.getApellidoMaterno());
            pStmt.setDate(5, Date.valueOf(c.getFechaNacimiento()));
            pStmt.setString(6, c.getRfc());
            pStmt.setInt(7, c.getDomicilio().getIdDomicilio());
            pStmt.setInt(8, c.getPortafolio().getIdPortafolio());
            int res = pStmt.executeUpdate();
        } catch (SQLException ex) {
            domDAO.baja(c.getDomicilio());
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GestorDeCxnABD.cierraObjeto(rs, pStmt, cxn);
        }
    }

    public void bajaCliente(int idCliente) {
        var sqlSelect = "DELETE FROM cliente"
                + " WHERE clavecliente=?";
        Connection cxn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        DomicilioDAO domDAO = new DomicilioDAO();
        Cliente c=null;
        try {
            c = obtenCliente(idCliente);        
            cxn = GestorDeCxnABD.obtenConexion();
            pStmt = cxn.prepareStatement(sqlSelect);
            pStmt.setInt(1, c.getIdCliente());
            int res = pStmt.executeUpdate();
            domDAO.baja(c.getDomicilio());
        } catch (SQLException ex) {
            //TODO: El método alta debe lanzar excepción
            domDAO.alta(c.getDomicilio());
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoExisteClienteException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GestorDeCxnABD.cierraObjeto(rs, pStmt, cxn);
        }
    }
}
