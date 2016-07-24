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
public class Movilizacion {
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
   
    private int idMovilizacion;
    private String Bien;
    private String Ubicacion_origen;
    private String Ubicacion_destino;
    private int Motivo_movilizacion;
    private String Detalle_movilizacion;
    private Usuario Responsable_transaccion;
    private String Fecha_movilizacion;
    private String Fecha_devolucion;
    private String Fecha_transaccion;
    private String Observacion;
    private String Movilizacioncol;
    private int idCambios;
    
    Bien BienBD;
    
    public Movilizacion(Connection con){
       this.con = con;
    }
    public Movilizacion(Connection con,String Bien,String Ubicacion_origen,String Ubicacion_destino,String Motivo_movilizacion,String Detalle_movilizacion,
            String Fecha_movilizacion,String Fecha_devolucion,String Fecha_transaccion,String Observacion,String Movilizacioncol,String username){
       this.con = con;
        //Inicializacion de clases DB
        this.Bien = Bien;
        BienBD = new Bien(this.con);
        this.Ubicacion_origen = Ubicacion_origen;
        this.Ubicacion_destino = Ubicacion_destino;
        this.Motivo_movilizacion = getMotivo(Motivo_movilizacion);
        this.Detalle_movilizacion = Detalle_movilizacion;
        this.Responsable_transaccion = new Usuario (con, username);
        this.Fecha_movilizacion = Fecha_movilizacion;
        this.Fecha_devolucion = Fecha_devolucion;
        this.Fecha_transaccion = Fecha_transaccion;
        this.Observacion = Observacion;
        this.Movilizacioncol = Movilizacioncol;
    }
        public Movilizacion(Connection con,String Bien,String Ubicacion_origen,String Ubicacion_destino,String Motivo_movilizacion,String Detalle_movilizacion,
            String Fecha_movilizacion,String Fecha_devolucion,String Fecha_transaccion,String Observacion,
            String Movilizacioncol,String username,int idCambios){
       this.con = con;
        //Inicializacion de clases DB
        this.Bien = Bien;
        BienBD = new Bien(this.con);
        this.Ubicacion_origen = Ubicacion_origen;
        this.Ubicacion_destino = Ubicacion_destino;
        this.Motivo_movilizacion = getMotivo(Motivo_movilizacion);
        this.Detalle_movilizacion = Detalle_movilizacion;
        this.Responsable_transaccion = new Usuario (con, username);
        this.Fecha_movilizacion = Fecha_movilizacion;
        this.Fecha_devolucion = Fecha_devolucion;
        this.Fecha_transaccion = Fecha_transaccion;
        this.Observacion = Observacion;
        this.Movilizacioncol = Movilizacioncol;
        this.idCambios = idCambios;
    }
    public String getMotivo_by_id(int id){
        try {        
            stmt = con.createStatement();
            //Buscamos el id del motivo
            if (stmt.execute(
                 "SELECT descripcion FROM motivo_movilizacion WHERE idMotivo_movilizacion = '" + id + "' "
                )) {
                
                rs = stmt.getResultSet();
                rs.beforeFirst();
                rs.next();
                return rs.getString("descripcion");
            }
           //No encontro Bien
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(Movilizacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;       
    }
    public int getMotivo(String motivo){
        try {        
            stmt = con.createStatement();
            //Buscamos el id del motivo
            if (stmt.execute(
                 "SELECT * FROM motivo_movilizacion WHERE Descripcion = '" + motivo + "' "
                )) {
                
                rs = stmt.getResultSet();
                rs.beforeFirst();
                rs.next();
                return rs.getInt("idMotivo_movilizacion");
            }
           //No encontro Bien
            return 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Movilizacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return -1;       
    }
    public ResultSet getMovilizacion(String idMovilizacion){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la Bien escogida
            if (stmt.execute(
                            "SELECT *\n" +
"                            FROM movilizacion\n" +
"                            JOIN bien \n" +
"                            ON movilizacion.bien = bien.codigo\n" +
"                            JOIN cambios\n" +
"                            ON movilizacion.idCambios = cambios.idCambios AND movilizacion.idMovilizacion = '"+idMovilizacion+"';"  
                )) {
                
                rs = stmt.getResultSet();
                rs.beforeFirst();
                rs.next();
            }
           //No encontro Bien
            return rs;
            
        } catch (SQLException ex) {
            Logger.getLogger(Movilizacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;
    }
 
    public ResultSet getAll(){
        try {        
            stmt = con.createStatement();
            if (stmt.execute(
                            "SELECT *\n" +
"                            FROM movilizacion\n" +
"                            JOIN bien \n" +
"                            ON movilizacion.bien = bien.codigo\n" +
"                            JOIN cambios\n" +
"                            ON movilizacion.idCambios = cambios.idCambios"

                )) {
                
                rs = stmt.getResultSet();
                
                return rs;
            }
           //No encontro odUicacion
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(Movilizacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;
    }
    public boolean insertar_movilizacion(String responsable,String estatus_ubi,String estatus_fis, String est_ubi_vij,String est_fis_vij,
    String responsable_vij){
        
        Cambios CambiosBD = new Cambios(con,this.Bien,est_fis_vij,estatus_fis,est_ubi_vij,estatus_ubi,responsable_vij,responsable,
        this.Responsable_transaccion.getUsername(),this.Motivo_movilizacion,this.Fecha_transaccion);
        /*, hacer cambios solos, actualizar cambios, 
        */
        if(CambiosBD.insertar_cambios(false)){
            Cambios camBD = new Cambios(con);
            try {
                // the mysql insert statement
                  String query = " INSERT INTO `inventario`.`movilizacion` (`Bien`, `Ubicacion_origen`, "
                          + "`Ubicacion_destino`, `Motivo_movilizacion`, `Detalle_movilizacion`, "
                          + "`Responsable_transaccion`, `Fecha_movilizacion`, "
                          + "`Fecha_devolucion`, `Fecha_transaccion`, `Observacion`, "
                          + "`Movilizacioncol`,`idCambios`) "
                          + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                  // create the mysql insert preparedstatement
                   preparedStmt = conexion.conexion().prepareStatement(query); 

                  preparedStmt.setString (1, this.Bien);       //bien
                  preparedStmt.setString (2, this.Ubicacion_origen);       //Ubicacion_origen
                  preparedStmt.setString (3, this.Ubicacion_destino);       //Ubicacion_destino
                  preparedStmt.setInt    (4, this.Motivo_movilizacion);       //Motivo_movilizacion
                  preparedStmt.setString (5, this.Detalle_movilizacion);     //Detalle_movilizacion
                  preparedStmt.setInt    (6, this.Responsable_transaccion.getIdUsuario());       //responsable
                  preparedStmt.setString (7, this.Fecha_movilizacion);       //Fecha_movilizacion
                  preparedStmt.setString (8, this.Fecha_devolucion);       //Fecha_devolucion
                  preparedStmt.setString (9, this.Fecha_transaccion);  //Fecha_transaccion
                  preparedStmt.setString (10, this.Observacion);     //Observacion
                  preparedStmt.setString (11, this.Movilizacioncol);     //Movilizacioncol
                  preparedStmt.setInt    (12, camBD.getLast());     //idCambios
                  Bien bBD = new Bien(this.con);
                  
                  // execute the preparedstatement
                  preparedStmt.execute();
                  if(bBD.actualizar_activo_movilizacion(this.Ubicacion_destino,responsable,estatus_ubi,estatus_fis,this.Bien)){                  
                      conexion.conexion().close();
                      return true; 
                  }else{
                      return false;
                  }
                  


            } catch (SQLException ex) {
                Logger.getLogger(Movilizacion.class.getName()).log(Level.SEVERE, null, ex);
            }          
        }
        return false;

    }
    public boolean actualizar_movilizacion (int idMovilizacion,String responsable,String estatus_ubi,String estatus_fis){
         Cambios CambiosBD = new Cambios(con);
        try {
            // the mysql insert statement
              String query = " UPDATE `inventario`.`movilizacion` SET "
                            + "`Ubicacion_origen`= '"+this.Ubicacion_origen+"', "
                            + "`Ubicacion_destino`= '"+this.Ubicacion_destino+"', "
                            + "`Motivo_movilizacion`='"+this.Motivo_movilizacion+"', "
                            + "`Detalle_movilizacion`='"+this.Detalle_movilizacion+"', "
                            + "`Responsable_transaccion`='"+this.Responsable_transaccion.getIdUsuario()+"', "
                            + "`Fecha_movilizacion`='"+this.Fecha_movilizacion+"', "
                            + "`Fecha_devolucion`='"+this.Fecha_devolucion+"', "
                            + "`Observacion`='"+this.Observacion+"', "
                            + "`Movilizacioncol`='"+this.Movilizacioncol+"'"
                            + " WHERE `idMovilizacion`= '" + idMovilizacion + "';";
              
              System.out.println(query);
              stmt = con.createStatement();
              stmt.execute(query);
              conexion.conexion().close();
               System.out.println("ID CAMBIOS: "+ this.idCambios);
               System.out.println("ID responsable: "+ responsable);
               System.out.println("ID estatus_ubi: "+ estatus_ubi);
               System.out.println("ID estatus_fis: "+ estatus_fis);
               CambiosBD.actualizar_cambios(this.idCambios,estatus_ubi,estatus_fis,responsable,this.Motivo_movilizacion,null,false);
               
              if(IsLast(idMovilizacion,this.Bien))
                  BienBD.actualizar_activo_movilizacion(this.Ubicacion_destino,responsable,estatus_ubi,estatus_fis,this.Bien);
              return true;

            
        } catch (SQLException ex) {
            Logger.getLogger(Movilizacion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }
    
    public boolean IsLast(int idMovilizacion,String codigo){
        try {        
            stmt = con.createStatement();
            //Buscamos el id del motivo
            if (stmt.execute(
                 "SELECT idMovilizacion FROM movilizacion WHERE idMovilizacion > '"+ idMovilizacion +"' AND movilizacion.bien = '"+ codigo +"';" 
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
    
    
    public String getBien() {
        return Bien;
    }

    public String getUbicacion_origen() {
        return Ubicacion_origen;
    }

    public String getUbicacion_destino() {
        return Ubicacion_destino;
    }

    public int getMotivo_movilizacion() {
        return Motivo_movilizacion;
    }

    public String getDetalle_movilizacion() {
        return Detalle_movilizacion;
    }

    public Usuario getResponsable_transaccion() {
        return Responsable_transaccion;
    }

    public String getFecha_movilizacion() {
        return Fecha_movilizacion;
    }

    public String getFecha_devolucion() {
        return Fecha_devolucion;
    }

    public String getFecha_transaccion() {
        return Fecha_transaccion;
    }

    public String getObservacion() {
        return Observacion;
    }

    public String getMovilizacioncol() {
        return Movilizacioncol;
    }

    public void setBien(String Bien) {
        this.Bien = Bien;
    }

    public void setUbicacion_origen(String Ubicacion_origen) {
        this.Ubicacion_origen = Ubicacion_origen;
    }

    public void setUbicacion_destino(String Ubicacion_destino) {
        this.Ubicacion_destino = Ubicacion_destino;
    }

    public void setMotivo_movilizacion(int Motivo_movilizacion) {
        this.Motivo_movilizacion = Motivo_movilizacion;
    }

    public void setDetalle_movilizacion(String Detalle_movilizacion) {
        this.Detalle_movilizacion = Detalle_movilizacion;
    }

    public void setResponsable_transaccion(Usuario Responsable_transaccion) {
        this.Responsable_transaccion = Responsable_transaccion;
    }

    public void setFecha_movilizacion(String Fecha_movilizacion) {
        this.Fecha_movilizacion = Fecha_movilizacion;
    }

    public void setFecha_devolucion(String Fecha_devolucion) {
        this.Fecha_devolucion = Fecha_devolucion;
    }

    public void setFecha_transaccion(String Fecha_transaccion) {
        this.Fecha_transaccion = Fecha_transaccion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public void setMovilizacioncol(String Movilizacioncol) {
        this.Movilizacioncol = Movilizacioncol;
    }
    
}
