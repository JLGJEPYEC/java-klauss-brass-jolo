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
public class user {

    /**
     * @return the tipo_usuario
     */
    public String getTipo_usuario() {
        return tipo_usuario;
    }

    /**
     * @param tipo_usuario the tipo_usuario to set
     */
    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
   private int id_user;
   private String nombre1;
   private String nombre2;
   private String ap_p;
   private String ap_m;
   private double sueldo;
   private String tipo_contrato;
   private String email;
   private String password;
   private String tipo_usuario;


   
   
   //public jefe_area_conta theJefe_area_conta;

    public user(int id_user, String nombre1, String nombre2, String ap_p, String ap_m) {
        this.id_user = id_user;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.ap_p = ap_p;
        this.ap_m = ap_m;
    }

    public int getId_user() {
        return id_user;
    }

    public String getNombre1() {
        return nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public String getAp_p() {
        return ap_p;
    }

    public String getAp_m() {
        return ap_m;
    }

    public String getPassword() {
        return password;
    }


    public double getSueldo() {
        return sueldo;
    }

    public String getTipo_contrato() {
        return tipo_contrato;
    }

    public String getEmail() {
        return email;
    }



   
   /**
   @roseuid 5D3151980223
    */
   public user() 
   {
    
   }
   
   /**
   @roseuid 5D32BD190158
    */
   public void mostrarTodosUsuarios() 
   {
    
   }
   
   /**
   @roseuid 5D32BD230204
    */
   public void mostrarProveedores() 
   {
    
   }

    /**
     * @param id_user the id_user to set
     */
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    /**
     * @param nombre1 the nombre1 to set
     */
    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    /**
     * @param nombre2 the nombre2 to set
     */
    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    /**
     * @param ap_p the ap_p to set
     */
    public void setAp_p(String ap_p) {
        this.ap_p = ap_p;
    }

    /**
     * @param ap_m the ap_m to set
     */
    public void setAp_m(String ap_m) {
        this.ap_m = ap_m;
    }

    /**
     * @param sueldo the sueldo to set
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * @param tipo_contrato the tipo_contrato to set
     */
    public void setTipo_contrato(String tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void guardarBBDD() 
   {
    try {
            // TODO add your handling code here:
            Conexion c = new Conexion();
            PreparedStatement ps = c.getConexion().prepareStatement("insert into "
                    + "usuario (Nombre1,Nombre2, ApellidoP, ApellidoM, Contraseña, Sueldo, TipoContrato, Email, tipoUsuario) "
                    + "values  (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, nombre1);
            ps.setString(2, nombre2);
            ps.setString(3, ap_p);
            ps.setString(4, ap_m);
            ps.setString(5, password);
            ps.setFloat(6, (float) sueldo);
            ps.setString(7, tipo_contrato);
            ps.setString(8, email);
            ps.setString(9, tipo_usuario);
            ps.executeUpdate();
            c.Desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   }
    
    public void eliminarBBDD(){
        try {
            // TODO add your handling code here:
            Conexion c = new Conexion();
            PreparedStatement ps = c.getConexion().prepareStatement("delete from "
                    + "usuario where idUser=? ");
            ps.setInt(1, id_user);
            ps.executeUpdate();
            c.Desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void modificarBBDD(Object [] atributos, Object [] valores){
        /*
        atributos [] =   {
                        Contraseña, 
                        Sueldo, 
                        TipoContrato, 
                        Email, 
                        tipoUsuario}
        
        */
        String SentenciaSET = "";
        int y=0;
        for (int i = 0; i < atributos.length; i++) {
            if(atributos[i]!=null){
                SentenciaSET += " "+String.valueOf(atributos[i])+" = ";
                if (i==1){
                    SentenciaSET += String.valueOf(valores[i]);
                }else{
                    SentenciaSET += "\""+String.valueOf(valores[i])+"\"";
                }
                SentenciaSET+=",";
            }
            
            
        }       
        System.out.println(SentenciaSET);
        SentenciaSET = SentenciaSET.replaceFirst(".$","");
        System.out.println(SentenciaSET);
        if(SentenciaSET.equals("")){
            System.out.println("no hay nada por modificar");
        }else{
            try {
                // TODO add your handling code here:

                Conexion c = new Conexion();
                PreparedStatement ps = c.getConexion().prepareStatement("update usuario "
                        + "set"+ SentenciaSET +" "
                        + "where idUser=?");
                ps.setInt(1,id_user);
                ps.executeUpdate();
                c.Desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        
        
    }
    
    
    
   /**
   @roseuid 5D32C0E700EA
    */
 
}
