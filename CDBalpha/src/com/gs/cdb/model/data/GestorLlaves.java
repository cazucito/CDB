package com.gs.cdb.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cazucito
 */
public class GestorLlaves {

    private static int idPortafolio;

    {
        idPortafolio = 100;
    }

    public static int obtenSigLlave(String nombreTabla, String nombreColLlave) {
        int llaveSig = 0;
        switch (nombreTabla.toLowerCase()) {
            case "portafolio":
                llaveSig = idPortafolio;
                ++idPortafolio;
            default:
                //TODO: Refactoring para evitar propensión a inyección de SQL
                var sqlSelect = "SELECT MAX(" + nombreColLlave + ") AS " + nombreColLlave + " FROM " + nombreTabla;
                Connection cxn = null;
                PreparedStatement pStmt = null;
                ResultSet rs = null;

                try {
                    cxn = GestorDeCxnABD.obtenConexion();
                    pStmt = cxn.prepareStatement(sqlSelect);
                    rs = pStmt.executeQuery();
                    while (rs.next()) {
                        llaveSig = rs.getInt(nombreColLlave);
                    }
                } catch (SQLException ex) {
                    GestorDeCxnABD.cierraObjeto(rs, pStmt, cxn);
                    Logger.getLogger(DomicilioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        ++llaveSig;
        return llaveSig;
    }
}
