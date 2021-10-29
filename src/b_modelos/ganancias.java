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
public class ganancias {
    private int Id_producción;
    private String ruc_empresa_pagadora;
   private double monto_final;
   private String fecha_pago;
   private String detalles_adicionales;
   private String codOperacion;
   private int id_ganancia;
   
   /**
   @roseuid 5D3151990187
    */
   public ganancias() 
   {
    
   }

    public ganancias(int Id_producción, String ruc_empresa_pagadora, double monto_final, String fecha_pago, String detalles_adicionales, String codOperacion) {
        this.Id_producción = Id_producción;
        this.ruc_empresa_pagadora = ruc_empresa_pagadora;
        this.monto_final = monto_final;
        this.fecha_pago = fecha_pago;
        this.detalles_adicionales = detalles_adicionales;
        this.codOperacion = codOperacion;
    }

   
   
    public String getCodOperacion() {
        return codOperacion;
    }



   
   
   
    public int getId_producción() {
        return Id_producción;
    }

    public String getRuc_empresa_pagadora() {
        return ruc_empresa_pagadora;
    }

    public double getMonto_final() {
        return monto_final;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public String getDetalles_adicionales() {
        return detalles_adicionales;
    }

    public int getId_ganancia() {
        return id_ganancia;
    }
   
   
   
   /**
   @roseuid 5D32C0DD0204
    */
   public void guardarBBDD() 
   {
        try {
            // TODO add your handling code here:
            Conexion c = new Conexion();
            PreparedStatement ps = c.getConexion().prepareStatement("insert into ganancia "
                    + "(idProduccion,RUC_emp_pagadora,monto_final,fecha_pago,detalles,codOperacion) "
                    + "values (?,?,?,STR_TO_DATE(?,'%Y-%m-%d'),?,?)");
            ps.setInt(1,Id_producción );
            ps.setString(2, ruc_empresa_pagadora);
            ps.setDouble(3,monto_final);
            ps.setString(4, fecha_pago);
            ps.setString(5, detalles_adicionales);
            ps.setString(6, codOperacion);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   }
}
