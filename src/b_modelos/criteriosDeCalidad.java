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
  // public jefe_produccion theJefe_produccion;
  // public produccion theProduccion;

    public criteriosDeCalidad(int id_produccion, String nombre_criterio, boolean esAceptable) {
        this.id_produccion = id_produccion;
        this.nombre_criterio = nombre_criterio;
        this.esAceptable = esAceptable;
    }
   
   
   
   
   /**
   @roseuid 5D31519900DB
    */
   public criteriosDeCalidad() 
   {
    
   }
   
   /**
   @roseuid 5D31BEE50204
    */
   public void ValidarCalidad() 
   {
    
   }
   
   /**
   @roseuid 5D315CA90148
    */
   public void isAceptable() 
   {
    
   }
   
   /**
   @roseuid 5D315CAF00FA
    */
   public void getCriterio() 
   {
    
   }

    public void guardarBBDD() 
   {
    try {
            // TODO add your handling code here:
            Conexion c = new Conexion();
            PreparedStatement ps = c.getConexion().prepareStatement("insert into "
                    + "criteriocalidad (nombreCrit,esAceptable,idProduccion) "
                    + "values  (?,?,?)");
            ps.setString(1, nombre_criterio);
            ps.setBoolean(2, false);
            ps.setInt(3,id_produccion);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   }

}
