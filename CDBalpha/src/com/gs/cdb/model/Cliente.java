package com.gs.cdb.model;

import java.time.LocalDate;

public class Cliente {
    private int idCliente;
    private String nombres;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String rfc;
    private LocalDate fechaNacimiento;
    private int idDomicilio;
    private int idPortafolio;

    public Cliente(int idCliente, String nombres, String apellidoMaterno, 
            String apellidoPaterno, String rfc, LocalDate fechaNacimiento, int idDomicilio, int idPortafolio) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.rfc = rfc;
        this.fechaNacimiento = fechaNacimiento;
        this.idDomicilio = idDomicilio;
        this.idPortafolio = idPortafolio;
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
    public int getIdDomicilio() {
        return idDomicilio;
    }

    /**
     * @return the idPortafolio
     */
    public int getIdPortafolio() {
        return idPortafolio;
    }
    
    
}
