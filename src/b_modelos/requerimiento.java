/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b_modelos;

import conexion_bbdd.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan-jolo
 */
public class requerimiento {
   private int id_requerimiento;

    public requerimiento(String nombre_req, String descripcion, String fechaDeEntrega, double pagoEstimado, String RUCEmpresa, String nombre_emp, String calidad_req, String compromiso_pago, String fecha_registro, double cantidad_productos) {
        this.nombre_req = nombre_req;
        this.descripcion = descripcion;
        this.fechaDeEntrega = fechaDeEntrega;
        this.pagoEstimado = pagoEstimado;
        this.RUCEmpresa = RUCEmpresa;
        this.nombre_emp = nombre_emp;
        this.calidad_req = calidad_req;
        this.compromiso_pago = compromiso_pago;
        this.fecha_registro = fecha_registro;
        this.cantidad_productos = cantidad_productos;
    }

    public requerimiento(int id_requerimiento, String nombre_req, double pagoEstimado, String RUCEmpresa) {
        this.id_requerimiento = id_requerimiento;
        this.nombre_req = nombre_req;
        this.pagoEstimado = pagoEstimado;
        this.RUCEmpresa = RUCEmpresa;
    }

    public int getId_requerimiento() {
        return id_requerimiento;
    }

    public String getNombre_req() {
        return nombre_req;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaDeEntrega() {
        return fechaDeEntrega;
    }

    public double getPagoEstimado() {
        return pagoEstimado;
    }

    public String getRUCEmpresa() {
        return RUCEmpresa;
    }

    public String getNombre_emp() {
        return nombre_emp;
    }

    public String getCalidad_req() {
        return calidad_req;
    }

    public String getCompromiso_pago() {
        return compromiso_pago;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public double getCantidad_productos() {
        return cantidad_productos;
    }


   private String nombre_req;
   private String descripcion;
   private String fechaDeEntrega;
   private double pagoEstimado;
   private String RUCEmpresa;
   private String nombre_emp;
   private String calidad_req;
   private String compromiso_pago;
   private String fecha_registro;
   private double cantidad_productos;
  // public produccion theProduccion;
   
   /**
   @roseuid 5D3151990148
    */
   public requerimiento() 
   {
    
   }
   
     public void guardarBBDD() 
   {
    try {
            // TODO add your handling code here:
            Conexion c = new Conexion();
            PreparedStatement ps = c.getConexion().prepareStatement("insert into requerimiento (nombreReq,descripcion,"
                    + "fechaEntrega,pagoEstimado,RUCempresa,nombre_emp,calidadReq,compromisoPago,"
                    + "fecha_registro,cantidad_productos) values (?,?,STR_TO_DATE(?,'%Y-%m-%d'),?,?,?,?,?,STR_TO_DATE(?,'%Y-%m-%d'),?)");
            ps.setString(1, nombre_req);
            ps.setString(2, descripcion);
            ps.setString(3,fechaDeEntrega);
            ps.setDouble(4, pagoEstimado);
            ps.setString(5, RUCEmpresa);
            ps.setString(6, nombre_emp);
            ps.setString(7, calidad_req);
            ps.setString(8,compromiso_pago);
            ps.setString(9,fecha_registro);
            ps.setDouble(10, cantidad_productos);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   }
}
