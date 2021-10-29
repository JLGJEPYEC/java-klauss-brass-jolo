/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b_modelos;

/**
 *
 * @author juan-jolo
 */
public class user {
    private int id_user;
   private String nombre1;
   private String nombre2;
   private String ap_p;
   private String ap_m;
   private String password;
   private String fecha_registro;
   private String fecha_fin;
   private double sueldo;
   private String tipo_contrato;
   private String email;
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

    public String getFecha_registro() {
        return fecha_registro;
    }

    public String getFecha_fin() {
        return fecha_fin;
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
   @roseuid 5D32C0E700EA
    */
 
}
