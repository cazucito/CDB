package com.gs.cdb.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DomicilioDAO {

    public DomicilioDAO() {
    }

    public Domicilio obtenPorId(int id) {
        var sqlSelect = "SELECT * FROM domicilio WHERE iddomicilio=?";
        Connection cxn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        Domicilio dom = null;
        try {
            cxn = GestorDeCxnABD.obtenConexion();
            pStmt = cxn.prepareStatement(sqlSelect);
            pStmt.setInt(1, id);
            rs = pStmt.executeQuery();
            while (rs.next()) {
                dom = new Domicilio(
                        rs.getInt("IDDOMICILIO"),
                        rs.getString("CALLE"),
                        rs.getString("NUMERO"),
                        rs.getString("COLONIA"),
                        rs.getString("LOCALIDAD"),
                        rs.getString("ESTADO"),
                        rs.getInt("CODIGOPOSTAL")
                );
            }
        } catch (SQLException ex) {
            GestorDeCxnABD.cierraObjeto(rs, pStmt, cxn);
            Logger.getLogger(DomicilioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dom;
    }

    public void alta(Domicilio d) {
        var sqlSelect = "INSERT INTO domicilio (iddomicilio, calle, numero, colonia, localidad, estado, codigopostal)"
                + " VALUES (?,?,?,?,?,?,?)";
        Connection cxn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            cxn = GestorDeCxnABD.obtenConexion();
            pStmt = cxn.prepareStatement(sqlSelect);
            pStmt.setInt(1, d.getIdDomicilio());
            pStmt.setString(2, d.getCalle());
            pStmt.setString(3, d.getNumero());
            pStmt.setString(4, d.getColonia());
            pStmt.setString(5, d.getLocalidad());
            pStmt.setString(6, d.getEstado());
            pStmt.setInt(7, d.getCodigoPostal());
            int res = pStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GestorDeCxnABD.cierraObjeto(rs, pStmt, cxn);
        }
    }
    public void baja(Domicilio d) {
        var sqlSelect = "DELETE FROM domicilio WHERE iddomicilio=?";
        Connection cxn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            cxn = GestorDeCxnABD.obtenConexion();
            pStmt = cxn.prepareStatement(sqlSelect);
            pStmt.setInt(1, d.getIdDomicilio());
            int res = pStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DomicilioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GestorDeCxnABD.cierraObjeto(rs, pStmt, cxn);
        }
    }
        public void cambio(Domicilio d) {
        var sqlSelect = "UPDATE domicilio SET calle=?, numero=?, colonia=?, "
                + "localidad=?, estado=?, codigopostal=?"
                + " WHERE iddomicilio=?";
        Connection cxn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            cxn = GestorDeCxnABD.obtenConexion();
            pStmt = cxn.prepareStatement(sqlSelect);
            pStmt.setString(1, d.getCalle());
            pStmt.setString(2, d.getNumero());
            pStmt.setString(3, d.getColonia());
            pStmt.setString(4, d.getLocalidad());
            pStmt.setString(5, d.getEstado());
            pStmt.setInt(6, d.getCodigoPostal());
            pStmt.setInt(7, d.getIdDomicilio());
            int res = pStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GestorDeCxnABD.cierraObjeto(rs, pStmt, cxn);
        }
    }
}
