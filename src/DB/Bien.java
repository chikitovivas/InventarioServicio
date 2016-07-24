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


public class Bien {
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
   
    
    //Variables del Bien
    private int idBien;
    private String codigo;
    private String nombre;
    private Proveedor proveedor;
    private Familia familia;
    private Ubicacion ubicacion;
    private String precio_unitario;
    private String costo_actual;
    private String fecha_adq;
    private Usuario responsable;
    private Propietario propietario;
    private Status status_ubi;
    private Status status_fisico;
    private String descripcion;
    

    public Bien(String codigo, String nombre, String proveedor, String categoria, String ubicacion, String precio_unitario, 
            String costo_actual, String fecha_adq, String responsable, String propietario, String status_ubi, String status_fisico, String descripcion) {
         //Conexion a la DB
        con = conexion.conexion();
        //Inicializacion de clases DB
        this.ubicacion = new Ubicacion(con,ubicacion);
        this.familia = new Familia(con, categoria);
        this.proveedor = new Proveedor(con, proveedor);
        this.responsable = new Usuario(con, responsable);
        this.propietario = new Propietario (con, propietario);
        this.status_ubi = new Status (con, status_ubi);
        this.status_fisico = new Status  (con, status_fisico);
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio_unitario = precio_unitario;
        this.costo_actual = costo_actual;
        this.fecha_adq = fecha_adq;
        this.descripcion = descripcion;
    }

    public Bien(Connection con) {
       this.con = con;
    }
    public boolean actualizar_activo_cambio(String Codigo,int ubicacion_nva,int fisico_nva,int responsable_nva){
        try {
            // the mysql insert statement
              String query = " UPDATE `inventario`.`bien` SET "
                            + "`Responsable_uso`= '"+responsable_nva+"', "
                            + "`Estatus_cond_ubicacion`='"+ubicacion_nva+"', "
                            + "`Estatus_cond_fisica`='"+fisico_nva+"' "
                            + "WHERE `Codigo`= '"+Codigo+"';";
              
              System.out.println(query);
              stmt = this.con.createStatement();
              stmt.execute(query);
              //conexion.conexion().close();
              return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Bien.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Entra false actualizar activo");
            return false;
        }
    }
    public boolean actualizar_activo_movilizacion(String ubicacion,String responsable,String estatus_ubi,String estatus_fis
            ,String codigo){
        System.out.println("Entra");
        this.responsable = new Usuario(con,responsable);
        this.ubicacion = new Ubicacion(con,ubicacion);
        this.status_fisico = new Status(con,estatus_fis);
        this.status_ubi = new Status(con,estatus_ubi);
        System.out.println("Llego a actualizar bien");
        try {
            // the mysql insert statement
              String query = " UPDATE `inventario`.`bien` SET "
                            + "`Ubicacion`= '"+this.ubicacion.descripcion_ubicacion()+"', "
                            + "`Responsable_uso`= '"+this.responsable.getIdUsuario()+"', "
                            + "`Estatus_cond_ubicacion`='"+this.status_ubi.Status_ubic()+"', "
                            + "`Estatus_cond_fisica`='"+this.status_fisico.Status_fisica()+"' "
                            + "WHERE `Codigo`= '"+codigo+"';";
              
              System.out.println(query);
              stmt = con.createStatement();
              stmt.execute(query);
              conexion.conexion().close();
              return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Bien.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Entra false actualizar activo");
            return false;
        }
    }
    
    public boolean insertar_activo(){
        
        
        try {
            // the mysql insert statement
              String query = " INSERT INTO `inventario`.`bien` (`Codigo`, `Familia`, "
                      + "`Descripcion`, `Descripcion_detallada`, `Ubicacion`, "
                      + "`Precio_referencial_unitario`, `Precio_actual`, "
                      + "`Fecha_adquisicion`, `Responsable_uso`, `Propietario`, "
                      + "`Proveedor_Donante_idProveedor`, `Estatus_cond_ubicacion`,"
                      + " `Estatus_cond_fisica`) "
                      + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

              // create the mysql insert preparedstatement
               preparedStmt = conexion.conexion().prepareStatement(query); 
               
            
              System.out.println("Ubicaciion : "+ this.status_ubi.Status_ubic());
               System.out.println("Estado fisico  : "+ this.status_fisico.Status_fisica());
               
              preparedStmt.setString (1, this.codigo);       //codigo
              preparedStmt.setString (2, this.familia.getIdFamilia());       //familia
              preparedStmt.setString (3, this.nombre);       //descripción
              preparedStmt.setString (4, this.descripcion);       //descripcion_detallada
              preparedStmt.setInt    (5, Integer.parseInt(ubicacion.getIdUbicacion()));     //ubicacion
              preparedStmt.setInt    (6, Integer.parseInt(this.precio_unitario));       //precio unitario
              preparedStmt.setInt    (7, Integer.parseInt(this.costo_actual));       //costo actual
              preparedStmt.setString (8, this.fecha_adq);       //fecha de adquisición
              preparedStmt.setInt    (9, this.responsable.getIdUsuario());  //Responsable de uso
              preparedStmt.setInt    (10, this.propietario.getIdPropietario());     //Propietario
              preparedStmt.setInt    (11, this.proveedor.getIdProveedor());     //Proveedor
              preparedStmt.setInt    (12, this.status_ubi.Status_ubic());     //Estado por ubicación
              preparedStmt.setInt    (13, this.status_fisico.Status_fisica());     //Estado físico
              
              // execute the preparedstatement
              preparedStmt.execute();

              conexion.conexion().close();
              return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Bien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    public ResultSet getBien ( String codigo, String familia){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la Bien escogida
            if (stmt.execute(
                "SELECT bien.codigo,ubicacion.descripcion as ubicacion,usuario.username as username, bien.Familia, bien.Descripcion, bien.Descripcion_detallada, usuario.Nombre as us_nombre, usuario.Apellido as us_apellido, bien.Precio_actual,bien.Fecha_adquisicion,bien.Precio_referencial_unitario,propietario.Razon_social as propietario, pd.Razon_social as proveedor,ecf.descripcion as con_fis, ecu.descripcion as con_ubi \n" +
                         "FROM bien, ubicacion, usuario,propietario, proveedor_donante as pd, estatus_cond_fisica as ecf, estatus_cond_ubicacion as ecu \n" +
                         "WHERE bien.ubicacion = ubicacion.idUbicacion AND bien.Responsable_uso = usuario.idUsuario AND bien.Propietario = propietario.Rif_Cedula AND bien.Proveedor_Donante_idProveedor = pd.idProveedor AND bien.Estatus_cond_ubicacion = ecu.idEstatus_ubicacion AND bien.Estatus_cond_fisica = ecf.idEstatus_fisico\n" +
                         "AND bien.Codigo = "+codigo+" AND bien.Familia = '"+familia+"' "  
                )) {
                
                rs = stmt.getResultSet();
                rs.beforeFirst();
                rs.next();
            }
           //No encontro Bien
            return rs;
            
        } catch (SQLException ex) {
            Logger.getLogger(Bien.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;
    }   
    public ResultSet getAll(){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT Codigo,Familia,Descripcion FROM bien "
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

    public conexionDB getConexion() {
        return conexion;
    }

    public void setConexion(conexionDB conexion) {
        this.conexion = conexion;
    }

    public int getIdBien() {
        return idBien;
    }

    public void setIdBien(int idBien) {
        this.idBien = idBien;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Familia getCategoria() {
        return familia;
    }

    public void setCategoria(Familia categoria) {
        this.familia = categoria;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getCosto_actual() {
        return costo_actual;
    }

    public void setCosto_actual(String costo_actual) {
        this.costo_actual = costo_actual;
    }

    public String getFecha_adq() {
        return fecha_adq;
    }

    public void setFecha_adq(String fecha_adq) {
        this.fecha_adq = fecha_adq;
    }

    public Usuario getResponsable() {
        return responsable;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Status getStatus_ubi() {
        return status_ubi;
    }

    public void setStatus_ubi(Status status_ubi) {
        this.status_ubi = status_ubi;
    }

    public Status getStatus_fisico() {
        return status_fisico;
    }

    public void setStatus_fisico(Status status_fisico) {
        this.status_fisico = status_fisico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public boolean actualizar_activo (){
        
        
        try {
            // the mysql insert statement
              String query = " UPDATE `inventario`.`bien` SET "
                            + "`Familia`= '"+this.familia.getIdFamilia()+"', "
                            + "`Descripcion`= '"+this.nombre+"', "
                            + "`Descripcion_detallada`= '"+this.descripcion+"', "
                            + "`Ubicacion`='"+Integer.parseInt(ubicacion.getIdUbicacion())+"', "
                            + "`Precio_referencial_unitario`='"+Integer.parseInt(this.precio_unitario)+"', "
                            + "`Precio_actual`='"+Integer.parseInt(this.costo_actual)+"', "
                            + "`Fecha_adquisicion`='"+this.fecha_adq+"', "
                            + "`Responsable_uso`='"+this.responsable.getIdUsuario()+"', "
                            + "`Propietario`='"+this.propietario.getIdPropietario()+"', "
                            + "`Proveedor_Donante_idProveedor`='"+this.proveedor.getIdProveedor()+"', "
                            + "`Estatus_cond_ubicacion`='"+this.status_ubi.Status_ubic()+"', "
                            + "`Estatus_cond_fisica`='"+this.status_fisico.Status_fisica()+"' "
                            + "WHERE `Codigo`= '"+this.codigo+"';";
              
              System.out.println(query);
              stmt = con.createStatement();
              stmt.execute(query);
              conexion.conexion().close();
              return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Bien.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        

    }
    
    
}
