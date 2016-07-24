/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import conexion.conexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Cambios {
           //Conexion a DB;
    private conexionDB conexion = new conexionDB();
    //Nueva statement
    Statement stmt = null;
    //Nuevo ResultSet
    ResultSet rs = null;
    //Variable conexion a la DB
    Connection con = null; 
    //PreparedStmt
    PreparedStatement preparedStmt;
   
    private int idCambios;
    private String Bien_Codigo;
    private Status CFAnt;
    private Status CFNva;
    private Status CUAnt;
    private Status CUNva;
    private Usuario Responsable_anterior;
    private Usuario Responsable_nuevo;
    private Usuario Responsable_transaccion;
    private int Motivo;
    private String Fecha_transaccion;

    
    public Cambios(Connection con){
        this.con = con;
    }
    
    public Cambios(Connection con,String bien,String estatus_f_ant,String estatus_f_nva,String estatus_u_ant,
            String estatus_u_nva,String responsable_ant,String responsable_nvo,String responsable_trans,int Motivo, String Fecha){
        this.Bien_Codigo = bien;
        this.CFAnt = new Status(con,estatus_f_ant);
        this.CFNva = new Status(con,estatus_f_nva);
        this.CUAnt = new Status(con,estatus_u_ant);
        this.CUNva = new Status(con,estatus_u_nva);
        this.Responsable_anterior = new Usuario(con,responsable_ant);
        this.Responsable_nuevo = new Usuario(con,responsable_nvo);
        this.Responsable_transaccion = new Usuario(con,responsable_trans);
        this.Motivo = Motivo;
        this.Fecha_transaccion = Fecha;
        this.con = con;
    }
    public ResultSet getCambio(String idCambio){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la Bien escogida
            if (stmt.execute(
                 "SELECT * FROM cambios,bien WHERE cambios.Bien_Codigo = bien.codigo AND cambios.idCambios = '"+idCambio+"';"  
                )) {
                
                rs = stmt.getResultSet();
                rs.beforeFirst();
                rs.next();
            }
           //No encontro Bien
            return rs;
            
        } catch (SQLException ex) {
            Logger.getLogger(Cambios.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;
    }
    public int getLast(){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT idCambios FROM inventario.cambios ORDER BY idCambios desc "
                )) {
                rs = stmt.getResultSet();
                rs.next();
                return rs.getInt("idCambios");
            }
           //No encontro Status
            return 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Cambios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Problema con la bd
        return -1;
    }
    public ResultSet getAll(){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute( //Introducir el query
                            "SELECT cambios.idCambios,bien.Codigo,bien.Familia,bien.descripcion \n" +
                            "FROM cambios,bien\n" +
                            "WHERE bien.codigo = cambios.Bien_Codigo \n" +
                            "AND cambios.idCambios NOT IN (SELECT cambios.idCambios FROM movilizacion,cambios \n" +
                                                            "WHERE movilizacion.idCambios = cambios.idCambios)"
                )) {
                
                rs = stmt.getResultSet();
                
                return rs;
            }
           //No encontro odUicacion
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(Cambios.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;
    }    
    public boolean insertar_cambios(boolean flag){
        try {
            // the mysql insert statement
              String query = " INSERT INTO `inventario`.`cambios` (`Bien_Codigo`, `CFAnt`, "
                      + "`CFNva`, `CUAnt`, `CUNva`, "
                      + "`Responsable_anterior`, `Responsable_nuevo`, "
                      + "`Responsable_transaccion`, `Motivo`, `Fecha_transaccion`) "
                      + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

              // create the mysql insert preparedstatement
               preparedStmt = conexion.conexion().prepareStatement(query); 
               
              preparedStmt.setString (1, this.Bien_Codigo);       //bien
              preparedStmt.setInt (2, this.CFAnt.Status_fisica());       //estatus fisico anterior
              preparedStmt.setInt (3, this.CFNva.Status_fisica());       //estatus fisico nuevo
              preparedStmt.setInt (4, this.CUAnt.Status_ubic());       //estatus ubicacion anterior
              preparedStmt.setInt (5, this.CUNva.Status_ubic());     //estatus ubicacion nuevo
              preparedStmt.setInt (6, this.Responsable_anterior.getIdUsuario());       //responsable anterior
              preparedStmt.setInt (7, this.Responsable_nuevo.getIdUsuario());       //responsable nuevo
              preparedStmt.setInt (8, this.Responsable_transaccion.getIdUsuario());       //responsable transaccion
              preparedStmt.setInt (9, this.Motivo);  //motivo
              preparedStmt.setString (10, this.Fecha_transaccion);     //fecha transaccion
              
              Bien BienBD = new Bien(this.con);
              if(flag){ //Hacer actualizacion de bien
                  BienBD.actualizar_activo_cambio(this.Bien_Codigo,this.CUNva.Status_ubic(), this.CFNva.Status_fisica(), this.Responsable_nuevo.getIdUsuario());
              }
              // execute the preparedstatement
              preparedStmt.execute();

              //conexion.conexion().close();
              return true;
              
            
        } catch (SQLException ex) {
            Logger.getLogger(Cambios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    public boolean actualizar_cambios(int idCambios,String estatus_ubi,String estatus_fis,String responsable,int motivo, String codigo,boolean flag){
        this.CFNva = new Status(con,estatus_fis);
        this.CUNva = new Status(con,estatus_ubi);
        this.Responsable_nuevo = new Usuario(con,responsable);
        System.out.println("ID CAMBIOS: "+ idCambios);
        System.out.println("ID responsable: "+ responsable);
        System.out.println("ID estatus_ubi: "+ estatus_ubi);
        System.out.println("ID estatus_fis: "+ estatus_fis);
        try {
            // the mysql insert statement
              String query = " UPDATE `inventario`.`cambios` SET "
                            + "`CFNva`= '"+this.CFNva.Status_fisica()+"', "
                            + "`CUNva`='"+this.CUNva.Status_ubic()+"', "
                            + "`Responsable_nuevo`='"+this.Responsable_nuevo.getIdUsuario()+"', "
                            + "`Motivo`='"+motivo+"' "
                            + " WHERE `idCambios`= '" + idCambios + "';";
              Bien BienBD = new Bien(this.con);
              if(flag && IsLast(idCambios,codigo)){ //Hacer actualizacion de bien
                  BienBD.actualizar_activo_cambio(codigo,this.CUNva.Status_ubic(), this.CFNva.Status_fisica(), this.Responsable_nuevo.getIdUsuario());
              }  
              System.out.println(query);
              stmt = con.createStatement();
              stmt.execute(query);
              //conexion.conexion().close();
              return true;

            
        } catch (SQLException ex) {
            Logger.getLogger(Cambios.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }
    
    public boolean IsLast(int idCambio,String codigo){
        try {        
            stmt = con.createStatement();
            //Buscamos el id del motivo
            if (stmt.execute(
                 "SELECT idCambios FROM cambios WHERE idCambios > '"+ idCambio +"' AND cambios.bien_codigo = '"+ codigo +"';" 
                )) {
                
                rs = stmt.getResultSet();
                rs.beforeFirst();
                
                if(rs.next() == false){
                    return true;
                }
            }
           //No encontro Bien
            return false;
            
        } catch (SQLException ex) {
            Logger.getLogger(Bien.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return false;       
    }
    public String getBien_Codigo() {
        return Bien_Codigo;
    }

    public void setBien_Codigo(String Bien_Codigo) {
        this.Bien_Codigo = Bien_Codigo;
    }

    public Status getCFAnt() {
        return CFAnt;
    }

    public void setCFAnt(Status CFAnt) {
        this.CFAnt = CFAnt;
    }

    public Status getCFNva() {
        return CFNva;
    }

    public void setCFNva(Status CFNva) {
        this.CFNva = CFNva;
    }

    public Status getCUAnt() {
        return CUAnt;
    }

    public void setCUAnt(Status CUAnt) {
        this.CUAnt = CUAnt;
    }

    public Status getCUNva() {
        return CUNva;
    }

    public void setCUNva(Status CUNva) {
        this.CUNva = CUNva;
    }

    public Usuario getResponsable_anterior() {
        return Responsable_anterior;
    }

    public void setResponsable_anterior(Usuario Responsable_anterior) {
        this.Responsable_anterior = Responsable_anterior;
    }

    public Usuario getResponsable_nuevo() {
        return Responsable_nuevo;
    }

    public void setResponsable_nuevo(Usuario Responsable_nuevo) {
        this.Responsable_nuevo = Responsable_nuevo;
    }

    public Usuario getResponsable_transaccion() {
        return Responsable_transaccion;
    }

    public void setResponsable_transaccion(Usuario Responsable_transaccion) {
        this.Responsable_transaccion = Responsable_transaccion;
    }

    public int getMotivo() {
        return Motivo;
    }

    public void setMotivo(int Motivo) {
        this.Motivo = Motivo;
    }

    public String getFecha_transaccion() {
        return Fecha_transaccion;
    }

    public void setFecha_transaccion(String Fecha_transaccion) {
        this.Fecha_transaccion = Fecha_transaccion;
    }
        
}
