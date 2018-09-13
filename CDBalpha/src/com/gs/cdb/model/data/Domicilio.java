package com.gs.cdb.model.data;

public class Domicilio {

    private int idDomicilio;
    private String calle;
    private String numero;
    private String colonia;
    private String localidad;
    private String estado;
    private int codigoPostal;

    public Domicilio(int idDomicilio, String calle, String numero, String colonia, String localidad, String estado, int codigoPostal) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.localidad = localidad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    /**
     * @return the idDomicilio
     */
    public int getIdDomicilio() {
        return idDomicilio;
    }
    /**
     * 
     * @return 
     */
    public String getCalle() {
        return calle;
    }
    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @return the codigoPostal
     */
    public int getCodigoPostal() {
        return codigoPostal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id:").append(idDomicilio).append(", ");
        sb.append("rfc:").append(calle).append(", ");
        sb.append("número:").append(numero).append(", ");
        sb.append("cp:").append(codigoPostal);
        return sb.toString();
    }

    public void imprimeResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t<");
        sb.append(toString());
        sb.append("/>");
        System.out.println(sb.toString());
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @param codigoPostal the codigoPostal to set
     */
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
