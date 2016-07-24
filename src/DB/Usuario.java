/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String password;
    private String tlf_1;
    private String tlf_2;
    private String username;
    private String email;
    private String estatus;
    private int tipo;

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    //Nueva statement
    Statement stmt = null;
    //Nuevo ResultSet
    ResultSet rs = null;
    
    private Connection con = null;
        public Usuario (Connection con){
        this.con = con;
    }
    public Usuario (Connection con, String username){
        this.con = con;
        this.username = username;
        this.idUsuario = nombre_idUsuario();
    }
    
    public int nombre_idUsuario(){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT * FROM usuario WHERE Username = '" + username + "' "
                )) {
                rs = stmt.getResultSet();
                rs.next();
                this.email = rs.getString("Email");
                this.tlf_1 = rs.getString("Tlf_1");
                this.tlf_2 = rs.getString("Tlf_2");
                this.nombre = rs.getString("nombre");
                this.apellido = rs.getString("apellido");
                this.tipo = rs.getInt("tipo");
                this.password = rs.getString("Password");
                this.estatus = rs.getString("Estatus_usuario"); 
                return rs.getInt("idUsuario");
            }
           //No encontro Status
            return 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Problema con la bd
        return -1;

    }
    public String Username_by_id(int id){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT username FROM inventario.usuario WHERE idUsuario = '" + id + "'"
                )) {
                rs = stmt.getResultSet();
                rs.next();
                return rs.getString("username");
            }
           //No encontro Status
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Problema con la bd
        return null;

    }    
    public int username_idUsuario(){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT idUsuario FROM inventario.usuario WHERE descripcion = '" + username + "'"
                )) {
                rs = stmt.getResultSet();
                rs.next();
                return rs.getInt("idUsuario");
            }
           //No encontro Status
            return 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Problema con la bd
        return -1;

    }
    
    public Usuario(int idUsuario, String nombre, String apellido, String password, String tlf_1, String tlf_2, String username) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.tlf_1 = tlf_1;
        this.tlf_2 = tlf_2;
        this.username = username;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
