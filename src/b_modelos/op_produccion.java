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
public class op_produccion extends user {

    /**
     * @return the id_op
     */
    public int getId_op() {
        return id_op;
    }

    /**
     * @return the id_user
     */
    public int getId_user() {
        return id_user;
    }

    /**
     * @return the produccion
     */
    public int getProduccion() {
        return produccion;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }
    private int id_op;
    private int id_user;
    private int produccion;
    private String rol;

    public op_produccion(int id_user, int produccion, String rol) {
        this.id_user = id_user;
        this.produccion = produccion;
        this.rol = rol;
    }
    
    public void guardarBBDD() 
   {
    try {
            // TODO add your handling code here:
            Conexion c = new Conexion();
            PreparedStatement ps = c.getConexion().prepareStatement("insert into operarioproduccion "
                    + "(iduser,idProduccion,rol) values (?,?,?)");
            ps.setInt(1, id_user);
            ps.setInt(2, produccion);
            ps.setString(3,rol);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   }
    
    
    
}
