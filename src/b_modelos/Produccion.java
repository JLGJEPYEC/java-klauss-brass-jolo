/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b_modelos;

import conexion_bbdd.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author juan-jolo
 */
public class Produccion {

    /**
     * @return the id_produccion
     */
    public int getId_produccion() {
        return id_produccion;
    }

    /**
     * @return the id_req
     */
    public int getId_req() {
        return id_req;
    }

    /**
     * @return the id_cat
     */
    public int getId_cat() {
        return id_cat;
    }

    /**
     * @return the fecha_inicio
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    public Produccion(int id_produccion) {
        this.id_produccion = id_produccion;
    }
    private int id_produccion;
    private int id_req;
    private int id_cat;
    private String fecha_inicio;
    private String categoria;
    private String estadoProduccion;

    public Produccion(int id_produccion, int id_req, int id_cat, String fecha_inicio, String categoria) {
        this.id_produccion = id_produccion;
        this.id_req = id_req;
        this.id_cat = id_cat;
        this.fecha_inicio = fecha_inicio;
        this.categoria = categoria;
        this.estadoProduccion="en Produccion";
    }
    
    public Produccion(int id_req, int id_cat, String fecha_inicio, String categoria) {
        this.id_req = id_req;
        this.id_cat = id_cat;
        this.fecha_inicio = fecha_inicio;
        this.categoria = categoria;
        this.estadoProduccion="en Produccion";
    }
    
     public void guardarBBDD() 
   {
    try {
            // TODO add your handling code here:
            Conexion c = new Conexion();
            PreparedStatement ps = c.getConexion().prepareStatement("insert into produccion "
                    + "(idCategoria,idrequerimiento,fechaProduccion,urgencia,estadoProduccion) values (?,?,STR_TO_DATE(?,'%Y-%m-%d'),?,?)");
            ps.setInt(1, id_cat);
            ps.setInt(2, id_req);
            ps.setString(3,fecha_inicio);
            ps.setString(4, categoria);
            ps.setString(5, estadoProduccion);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   }
     public void CambiarEstadoToPagado(){
         try {
            // TODO add your handling code here:
            Conexion c = new Conexion();
            PreparedStatement ps = c.getConexion().prepareStatement("update produccion"
                    + " set estadoProduccion = \"Pagado\" where idProduccion=?");
            ps.setInt(1, id_produccion);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     
     public String ObtenerRUC(){
         String s=""; 
         try {
            // TODO add your handling code here:
            Conexion c = new Conexion();
            PreparedStatement ps = c.getConexion().prepareStatement("select RUCempresa from requerimiento"
                    + " inner join produccion "
                    + "on produccion.idrequerimiento=requerimiento.idrequerimiento "
                    + "and produccion.idrequerimiento=?;");
            ps.setInt(1, id_produccion);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                s=rs.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return s;
     }
    
    
}
