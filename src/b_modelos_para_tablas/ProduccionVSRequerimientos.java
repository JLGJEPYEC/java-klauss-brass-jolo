/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b_modelos_para_tablas;

/**
 *
 * @author juan-jolo
 */
public class ProduccionVSRequerimientos {
    private int idProduccion;
    private int idReq;
    private String nomReq;
    private double montoR;
    private String RUC;

    public ProduccionVSRequerimientos(int idProduccion, int idReq, String nomReq, double montoR, String RUC) {
        this.idProduccion = idProduccion;
        this.idReq = idReq;
        this.nomReq = nomReq;
        this.montoR = montoR;
        this.RUC = RUC;
    }

    
    
    /**
     * @return the idProduccion
     */
    public int getIdProduccion() {
        return idProduccion;
    }

    /**
     * @return the idReq
     */
    public int getIdReq() {
        return idReq;
    }

    /**
     * @return the nomReq
     */
    public String getNomReq() {
        return nomReq;
    }

    /**
     * @return the montoR
     */
    public double getMontoR() {
        return montoR;
    }

    /**
     * @return the RUC
     */
    public String getRUC() {
        return RUC;
    }
    
    
    
}
