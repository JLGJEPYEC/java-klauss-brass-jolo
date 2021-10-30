/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b_metodos_conexion;

import b_modelos.requerimiento;
import b_modelos.user;
import conexion_bbdd.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import b_modelos.categorias_prod;
import b_modelos.Produccion;
import b_modelos_para_tablas.ProduccionVSRequerimientos;
import java.util.Date;
import b_metodos_conexion.gestion_fechas;

/**
 *
 * @author juan-jolo
 */
public class extraccion_tablas {
    PreparedStatement ps = null;
    ResultSet rs =null;
    
    
    public String UltimoElementoID (String nombreCampoID,String Tabla){
        String h="";
        try{
            Conexion c = new Conexion();
            ps = c.getConexion().prepareStatement("select "+nombreCampoID+" from "
                    +Tabla+" ORDER by "+nombreCampoID+" DESC LIMIT 1");
            rs = ps.executeQuery();
            int i=0;
            while(rs.next()){
                h=String.valueOf(rs.getInt(1));
            }
            c.Desconectar();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return h;
    }
    
    
    public  String FilaSeleccionadaID (int n,String nombreCampoID,String Tabla){
        String h="";
        try{
            Conexion c = new Conexion();
            ps = c.getConexion().prepareStatement("select "+nombreCampoID+" from "+Tabla);
            rs = ps.executeQuery();
            int i=0;
            while(rs.next() && i<=n){
                h=String.valueOf(rs.getInt(1));
                i++;
            }
            c.Desconectar();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return h;
    }
   
    public  String FilaSeleccionadaID (int n,String nombreCampoID,String Tabla, String join, String cond){
        String h="";
        try{
            Conexion c = new Conexion();
            ps = c.getConexion().prepareStatement("select "+nombreCampoID+" from "+Tabla+" inner join "+join+" on "+cond);
            rs = ps.executeQuery();
            int i=0;
            while(rs.next() && i<=n){
                h=String.valueOf(rs.getInt(1));
                i++;
            }
            c.Desconectar();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return h;
    }
    
    
    
    
    
        public ArrayList<requerimiento> elementos_requerimiento (){
        int n=0;
        ArrayList <requerimiento> lista_reqs = new ArrayList<requerimiento>();
        requerimiento temp_req = null;
        try{
            Conexion c = new Conexion();
            ps = c.getConexion().prepareStatement("select idrequerimiento,nombreReq,pagoEstimado,RUCempresa from requerimiento");
            rs = ps.executeQuery();
            while(rs.next()){
                temp_req=new requerimiento(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
                lista_reqs.add(temp_req);
            }
            c.Desconectar();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return lista_reqs;
    }

        public ArrayList <categorias_prod> categorias(){
        int n=0;
        ArrayList <categorias_prod> lista_cats = new ArrayList<categorias_prod>();
        categorias_prod temp_cat = null;
        try{
            Conexion c = new Conexion();
            ps = c.getConexion().prepareStatement("select * from categoria");
            rs = ps.executeQuery();
            while(rs.next()){
                temp_cat = new categorias_prod(rs.getInt(1),rs.getString(2));
              lista_cats.add(temp_cat);
            }
            c.Desconectar();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return lista_cats;
    }

    /* NO SE VA A USAR ---- REEMPLAZADO POR "TIPOSDEUSUARIO(STRING S) DONDE S
        ES EL VALOR DEL WHERE SQL
        
    public ArrayList<user> operarios_produccion(){
        int n=0;
        ArrayList <user> lista_reqs = new ArrayList<user>();
        user temp_user = null;
        try{
            Conexion c = new Conexion();
            ps = c.getConexion().prepareStatement("select idUser,Nombre1,Nombre2,ApellidoP,ApellidoM from "
                    + "usuario where tipoUsuario=\"Operario Produccion\"");
            rs = ps.executeQuery();
            while(rs.next()){
                temp_user=new user(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista_reqs.add(temp_user);
            }
            c.Desconectar();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return lista_reqs;
    }
    */
   
   public ArrayList<user> TipoDeUsuariosDeseados(String tipou){
        int n=0;
        ArrayList <user> lista_reqs = new ArrayList<user>();
        user temp_user = null;
        try{
            Conexion c = new Conexion();
            ps = c.getConexion().prepareStatement("select idUser,Nombre1,"
                    + "Nombre2,ApellidoP,ApellidoM from "
                    + "usuario where tipoUsuario=\""+tipou+"\"");
            rs = ps.executeQuery();
            while(rs.next()){
                temp_user=new user(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4),
                                    rs.getString(5));
                lista_reqs.add(temp_user);
            }
            c.Desconectar();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return lista_reqs;
    }
   
   public ArrayList<ProduccionVSRequerimientos> lista_prod_vs_req_JC(){
       ArrayList <ProduccionVSRequerimientos> lista_r = new ArrayList<ProduccionVSRequerimientos>();
       ProduccionVSRequerimientos r = null;
       try{
           Conexion c = new Conexion();
           ps = c.getConexion().prepareStatement("select idProduccion, "
                   + "fechaProduccion, urgencia, nombreReq, descripcion, "
                   + "fechaEntrega, nombre_emp, calidadReq, cantidad_productos "
                   + "from produccion "
                   + "inner join requerimiento "
                   + "on produccion.idrequerimiento=requerimiento.idrequerimiento "
                   + "where estadoProduccion=\"en Produccion\"");
           rs = ps.executeQuery();
           while(rs.next()){
               r = new ProduccionVSRequerimientos (rs.getInt(1),
                                      rs.getDate(2).toString(),
                                      rs.getString(3),
                                      rs.getString(4),
                                      rs.getString(5),
                                     rs.getDate(6).toString(),
                                      rs.getString(7),
                                      rs.getString(8),
                                      rs.getDouble(9)
                                      );
               lista_r.add(r);
           } 
           c.Desconectar();
       }catch (Exception e){
           e.printStackTrace();
       }
       return lista_r;
   }
   
  
   
    
    public ArrayList<ProduccionVSRequerimientos> lista_prod_vs_req(){
        int n=0;
        ArrayList <ProduccionVSRequerimientos> lista_pr = new ArrayList<ProduccionVSRequerimientos>();
        ProduccionVSRequerimientos join_1 = null;
        try{
            Conexion c = new Conexion();
            ps = c.getConexion().prepareStatement("select "
                    + "idProduccion,produccion.idrequerimiento,nombreReq,pagoEstimado,RUCempresa "
                    + "from produccion inner join requerimiento "
                    + "on produccion.idrequerimiento=requerimiento.idrequerimiento");
            rs = ps.executeQuery();
            while(rs.next()){
                int p1 = rs.getInt(1);
                int p2 = rs.getInt(2);
                String p3= rs.getString(3);
                double p4= rs.getDouble(4);
                String p5= rs.getString(5);
                join_1=new ProduccionVSRequerimientos(p2, p2, p5, p4, p5);
                lista_pr.add(join_1);
            }
            c.Desconectar();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return lista_pr;
    }
}
