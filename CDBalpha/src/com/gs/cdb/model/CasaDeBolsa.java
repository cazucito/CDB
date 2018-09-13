package com.gs.cdb.model;

/**
 *
 */
public class CasaDeBolsa {
    private static CasaDeBolsa cdb = new CasaDeBolsa();

    private CasaDeBolsa() {
    }
    
    public static CasaDeBolsa getSingleton() {
        return cdb;
    }
    
    public void imprimeBienvenida(){
        StringBuilder sb = new StringBuilder();
        sb.append("||========================================================||").append("\n");
        sb.append("||               BIENVENIDO A CDB BITCOIN GS              ||").append("\n");
        sb.append("||========================================================||").append("\n");
        System.out.println(sb.toString());
    }
}
