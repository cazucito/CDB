package com.gs.cdb.model.data;

import java.time.LocalDate;
import com.gs.cdb.util.Imprimible;

public class Cliente implements Imprimible {

    private int idCliente;
    private String nombres;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String rfc;
    private LocalDate fechaNacimiento;
    private Domicilio domicilio;
    private Portafolio portafolio;

    public Cliente(int idCliente, String nombres, String apellidoMaterno,
            String apellidoPaterno, String rfc, LocalDate fechaNacimiento, Domicilio domicilio, Portafolio portafolio) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.rfc = rfc;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.portafolio = portafolio;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * @return the fechaNacimiento
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @return the idDomicilio
     */
    public Domicilio getDomicilio() {
        return domicilio;
    }

    /**
     * @return the idPortafolio
     */
    public Portafolio getPortafolio() {
        return portafolio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id:").append(idCliente).append(", ");
        sb.append("rfc:").append(rfc).append(", ");
        sb.append("nombres:").append(nombres).append(", ");
        sb.append("apellidos:").append(apellidoPaterno).append(" ").append(apellidoMaterno).append(", ");
        sb.append("domicilio:").append(domicilio.toString());
        sb.append("portafolio:").append(getPortafolio().toString());
        return sb.toString();
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @param portafolio the portafolio to set
     */
    public void setPortafolio(Portafolio portafolio) {
        this.portafolio = portafolio;
    }
    
}
