/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yanir
 */
public class Propietario {
    
    private int idPropietario;
    private String Razon_social;
    private String tlf_1;
    private String tlf_2;
    private String email;
    private String contacto;
    //Nueva statement
    Statement stmt = null;
    //Nuevo ResultSet
    ResultSet rs = null;
        //PreparedStmt
    PreparedStatement preparedStmt;
    
    private Connection con = null;
    
    public Propietario (Connection con, String Razon_social){
        this.con = con;
        this.Razon_social = Razon_social;
        idPropietario = Razon_social_idPropietario();
    }
    public Propietario (Connection con){
        this.con = con;
    }    
    public int Razon_social_idPropietario(){
        try {        
            stmt = con.createStatement();
            System.out.println(Razon_social);
            //Buscamos el id de la categoria escogida
            //this.Razon_social = this.Razon_social.replaceAll(" ","");
            if (stmt.execute(
                            "SELECT Rif_Cedula FROM inventario.propietario where Razon_Social = '" + Razon_social + "' "
                )) {
                rs = stmt.getResultSet();
                rs.next();
                return rs.getInt("Rif_Cedula");
            }
           //No encontro Status
            return 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Problema con la bd
        return -1;

    }
    
    
    public Propietario(int idPropietario, String Razon_social, String tlf_1, String tlf_2, String contacto) {
        this.idPropietario = idPropietario;
        this.Razon_social = Razon_social;
        this.tlf_1 = tlf_1;
        this.tlf_2 = tlf_2;
        this.contacto = contacto;
    }
    
    public boolean exist(int rif_cedula){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la propietario escogida
            if (stmt.execute(
                            "SELECT Rif_Cedula FROM propietario WHERE Rif_Cedula = '" + rif_cedula + "'"
                )) {               
                rs = stmt.getResultSet();
                
                if(rs.first()){
                    return true;
                }else{
                    return false;
                }
                
            }
           //No encontro propietario
            return false;
            
        } catch (SQLException ex) {
            Logger.getLogger(Propietario.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return false;
    }
    public boolean actualizar(String Razon_social, int RIF_cedula, String contacto,String email,String tlf_1,String tlf_2){
        this.Razon_social = Razon_social;
        this.idPropietario = RIF_cedula;
        this.contacto = contacto;
        this.email = email;
        this.tlf_1 = tlf_1;
        this.tlf_2 = tlf_2;
        try {
            //Query de update
            String query = "UPDATE propietario SET Razon_social = ?,Tlf_1 = ?,Tlf_2 = ?,Email = ?,"
                    + " Persona_contacto = ? WHERE Rif_Cedula = ?";
            //Preparamos el query
            preparedStmt = con.prepareStatement(query);
            //Introducimos las variables
              preparedStmt.setString (1, this.Razon_social);    //Razon_social
              preparedStmt.setString (2, this.tlf_1);           //tlf_1 
              preparedStmt.setString (3, this.tlf_2);           //tlf_2
              preparedStmt.setString (4, this.email);           //email
              preparedStmt.setString (5, this.contacto);        //contacto 
              preparedStmt.setInt (6, this.idPropietario);           //RIF_cedula 





            // execute the java preparedstatement
            if(preparedStmt.executeUpdate() != 0){
               return true; 
            }else{
               return false;
            }  
            
        } catch (SQLException ex) {
            Logger.getLogger(Propietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        //No se hizo la actualizacion
        return false;
    }
    public ResultSet getAll(){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT Rif_Cedula,Razon_Social,Persona_contacto FROM propietario "
                )) {
                
                rs = stmt.getResultSet();
                
                return rs;
            }
           //No encontro odUicacion
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(Propietario.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;
    }
    public ResultSet getPropietario ( String razon){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la Propietario escogida
            if (stmt.execute(
                            "SELECT * FROM propietario WHERE Razon_social = '" + razon + "'"
                )) {
                
                rs = stmt.getResultSet();
                rs.beforeFirst();
                rs.next();
            }
           //No encontro propietario
            return rs;
            
        } catch (SQLException ex) {
            Logger.getLogger(Propietario.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;
    }   
      public boolean agregar(String Razon_social, int RIF_cedula, String contacto,String email,String tlf_1,String tlf_2){
        this.Razon_social = Razon_social;
        this.idPropietario = RIF_cedula;
        this.contacto = contacto;
        this.email = email;
        this.tlf_1 = tlf_1;
        this.tlf_2 = tlf_2;
        
        try {
            // the mysql insert statement
              String query = " INSERT INTO propietario (Rif_Cedula,Razon_Social,Persona_contacto,Email,Tlf_1,Tlf_2)"
                            + " values (?,?,?,?,?,?)";

            System.out.println(this.idPropietario + this.Razon_social+this.contacto+this.email+this.tlf_1+this.tlf_2);
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query); 
              
              preparedStmt.setInt (1, this.idPropietario);           //RIF_cedula 
              preparedStmt.setString (2, this.Razon_social);    //Razon_social
              preparedStmt.setString (3, this.contacto);        //contacto 
              preparedStmt.setString (4, this.email);           //email
              preparedStmt.setString (5, this.tlf_1);           //tlf_1 
              preparedStmt.setString (6, this.tlf_2);           //tlf_2
              
              // execute the preparedstatement
              preparedStmt.execute();

              return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Propietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    public String getTlf_1() {
        return tlf_1;
    }

    public void setTlf_1(String tlf_1) {
        this.tlf_1 = tlf_1;
    }

    public String getTlf_2() {
        return tlf_2;
    }

    public void setTlf_2(String tlf_2) {
        this.tlf_2 = tlf_2;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getRazon_social() {
        return Razon_social;
    }

    public void setRazon_social(String Razon_social) {
        this.Razon_social = Razon_social;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
    
}
