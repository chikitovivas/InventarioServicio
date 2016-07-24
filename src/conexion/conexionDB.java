/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class conexionDB {
    Connection conexion = null;
    
    public Connection conexion(){

        try{
           Class.forName("com.mysql.jdbc.Driver"); 
           conexion = DriverManager.getConnection("jdbc:mysql://localhost/inventario","root","y190193");
           // JOptionPane.showMessageDialog(null, "Se conecto Exitosamente /n");
           
        } catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "No se conecto/n" + e + "/n");
            System.exit(0);
        }
        
        return conexion;
    }
}
