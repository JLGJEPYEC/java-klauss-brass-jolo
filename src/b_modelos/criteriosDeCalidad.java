/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b_modelos;

import conexion_bbdd.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author juan-jolo
 */
public class criteriosDeCalidad {

    /**
     * @return the id_criteriocalidad
     */
    public int getId_criteriocalidad() {
        return id_criteriocalidad;
    }

    /**
     * @param id_criteriocalidad the id_criteriocalidad to set
     */
    public void setId_criteriocalidad(int id_criteriocalidad) {
        this.id_criteriocalidad = id_criteriocalidad;
    }

    /**
     * @return the estadioCriterio
     */
    public String getEstadioCriterio() {
        return estadioCriterio;
    }

    /**
     * @param estadioCriterio the estadioCriterio to set
     */
    public void setEstadioCriterio(String estadioCriterio) {
        this.estadioCriterio = estadioCriterio;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * @return the InspectorID
     */
    public int getInspectorID() {
        return InspectorID;
    }

    /**
     * @param InspectorID the InspectorID to set
     */
    public void setInspectorID(int InspectorID) {
        this.InspectorID = InspectorID;
    }
    
    
    private int InspectorID;

    public int getId_produccion() {
        return id_produccion;
    }

    public String getNombre_criterio() {
        return nombre_criterio;
    }

    public boolean isEsAceptable() {
        return esAceptable;
    }

    public criteriosDeCalidad(String nombre_criterio) {
        this.nombre_criterio = nombre_criterio;
    }
    private int id_produccion;
   private String nombre_criterio;
   private boolean esAceptable;
   private String estadioCriterio;
   private String observacion;
   private int id_criteriocalidad;
  // public jefe_produccion theJefe_produccion;
  // public produccion theProduccion;

    public criteriosDeCalidad(int id_produccion, String nombre_criterio, boolean esAceptable) {
        this.id_produccion = id_produccion;
        this.nombre_criterio = nombre_criterio;
        this.esAceptable = esAceptable;
    }

    public criteriosDeCalidad (){
        
    }

    public criteriosDeCalidad(int id_criteriocalidad, boolean esAceptable, String estadioCriterio, String observacion ) {
        this.esAceptable = esAceptable;
        this.estadioCriterio = estadioCriterio;
        this.observacion = observacion;
        this.id_criteriocalidad = id_criteriocalidad;
    }

    
    
    public criteriosDeCalidad(int InspectorID, int id_produccion ) {
        this.InspectorID = InspectorID;
        this.id_produccion = id_produccion;
    }


    public void guardarBBDD() 
   {
    try {
            // TODO add your handling code here:
            Conexion c = new Conexion();
            PreparedStatement ps = c.getConexion().prepareStatement("insert into "
                    + "criteriocalidad (nombreCrit,esAceptable,idProduccion,estadoCriterio, observacion) "
                    + "values  (?,?,?,?,?)");
            ps.setString(1, nombre_criterio);
            ps.setBoolean(2, false);
            ps.setInt(3,id_produccion);
            ps.setString(4, "sin asignar");
            /*
            ESTADOS DE CRITERIO SOLO HAY POCOS
            -sin asignar: al agregar, solo poner este estado. esaceptable:0 
            -asignado: cuando tiene un inspector pero sin revizar aun. esaceptable:0 
            -rechazado: cuando inspector detecta problemas, rechaza. esaceptable:0 
            -aprobado: cuando inspector reviza y comfirma.esaceptable:1
            */
            ps.setString(5, "aun no es revizada por algun inspector");
            ps.executeUpdate();
            c.Desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   }
    
    public void modificarBBDD_AsignarInspector(){
        try {
            // TODO add your handling code here:
            Conexion c = new Conexion();
            PreparedStatement ps = c.getConexion().prepareStatement("update criteriocalidad "
                    + "set IDInspector = ? where idProduccion= ?");
            ps.setInt(1, InspectorID);
            ps.setInt(2, id_produccion);
            ps.executeUpdate();
            c.Desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void modificarBBDD_RevisionHecha(){
        try {
            // TODO add your handling code here:
            Conexion c = new Conexion();
            PreparedStatement ps = c.getConexion().prepareStatement("update criteriocalidad "
                    + "set esAceptable=?, estadoCriterio= ?, observacion = ? "
                    + "where idcriterioCalidad=?");
            ps.setBoolean(1, isEsAceptable());
            ps.setString(2, getEstadioCriterio());
            ps.setString(3, getObservacion());
            ps.setInt(4, getId_criteriocalidad());
            ps.executeUpdate();
            c.Desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
