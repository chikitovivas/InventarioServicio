/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfazNueva;

import conexion.conexionDB;
import inventarioh.Bienvenido;
import inventarioh.MenuBar.Bienes.*;
import inventarioh.MenuBar.Configuracion.AgregarEditar_estatus;
import inventarioh.MenuBar.Configuracion.AgregarEditar_familia;
import inventarioh.MenuBar.Proveedores_Donantes.AgregarEditar_proveedor;
import inventarioh.MenuBar.Configuracion.AgregarEditar_ubicacion;
import inventarioh.MenuBar.Configuracion.AgregarPropietario;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Usuario
 */
public class menubar extends JMenuBar{
    
    Connection con = null;
    javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
    javax.swing.JMenu jMenu2 = new javax.swing.JMenu();
    javax.swing.JMenu jMenu3 = new javax.swing.JMenu();
    javax.swing.JMenu jMenu4 = new javax.swing.JMenu();
    javax.swing.JMenu jMenu5 = new javax.swing.JMenu();
    
    /*Sub-Menu Inventario*/
    javax.swing.JMenuItem jMenuItem1 = new javax.swing.JMenuItem();
    /************/
    
    /*Sub-Menu Bienes*/
    javax.swing.JMenuItem jMenuItem2 = new javax.swing.JMenuItem();
    javax.swing.JMenuItem jMenuItem3 = new javax.swing.JMenuItem();
    javax.swing.JMenuItem jMenuItem4 = new javax.swing.JMenuItem();
    /***********/
    
    /*Sub-Menu Seguridad*/
    javax.swing.JMenuItem jMenuItem5 = new javax.swing.JMenuItem();
    /**********/
    
    /*Sub-Menu Configuracion*/
    javax.swing.JMenuItem jMenuItem6 = new javax.swing.JMenuItem();
    javax.swing.JMenuItem jMenuItem7 = new javax.swing.JMenuItem();
    javax.swing.JMenuItem jMenuItem8 = new javax.swing.JMenuItem();
    javax.swing.JMenuItem jMenuItem9 = new javax.swing.JMenuItem();
    javax.swing.JMenuItem jMenuItem10 = new javax.swing.JMenuItem();
    /**
     *
     * @param anterior
     */
    public menubar(final JFrame anterior){
        /* Conexion DB */
        conexionDB conexion = new conexionDB();
        // Variable Connection, pasarsela a todas las vistas
        con = conexion.conexion();
        
        /* Menu Bienes */
        jMenu1.setText("Bienes");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Agregar Activo");
        jMenu1.add(jMenuItem2);
        
        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Lista de Activos");
        jMenu1.add(jMenuItem3);
        
        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Mover Activo");
        jMenu1.add(jMenuItem4);
        
        this.add(jMenu1);
        /***************/
        
        /* Inventario */
        jMenu2.setText("Inventario");

        jMenuItem1.setText("Ver inventario");
        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        
        jMenu2.add(jMenuItem1);

        this.add(jMenu2);
        
        /* Menu Cuentas */
        jMenu3.setText("Seguridad");
        
        jMenuItem5.setText("Cuentas y Privilegios");
        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenu3.add(jMenuItem5);
        
        this.add(jMenu3);
        /****************/
        
         /* Menu Configuracion */
        jMenu4.setText("Configuracion");
        
        //jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Nueva/Editar Familia");
        jMenu4.add(jMenuItem6);
        
        //jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Nuevo Proveedor");
        jMenu4.add(jMenuItem7);
        
       // jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Nuevo Status");
        jMenu4.add(jMenuItem8);
        
       //jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setText("Nueva Ubicacion");
        jMenu4.add(jMenuItem9);
        
        //jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("Nuevo Propietario");
        jMenu4.add(jMenuItem10);
        
        this.add(jMenu4);
        /****************/
        
        /* Acciones */
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_activo ventana = null;
                try {
                    ventana = new Agregar_activo(con);
                } catch (SQLException ex) {
                    Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
                }
                ventana.setVisible(true);
                anterior.setVisible(false);
            }
        });
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Lista_activo ventana = new Lista_activo(con);
                    ventana.setVisible(true);
                    anterior.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mover_activo ventana;
                try {
                    ventana = new Mover_activo(con);
                    ventana.setVisible(true);
                    anterior.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarEditar_familia ventana;
                try {
                    ventana = new AgregarEditar_familia(con);
                    ventana.setVisible(true);
                    anterior.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarEditar_proveedor ventana;
                try {
                    ventana = new AgregarEditar_proveedor(con);
                    ventana.setVisible(true);
                    anterior.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarEditar_estatus ventana;
                try {
                    ventana = new AgregarEditar_estatus(con);
                    ventana.setVisible(true);
                    anterior.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });   
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarEditar_ubicacion ventana;
                try {
                    ventana = new AgregarEditar_ubicacion(con);
                    ventana.setVisible(true);
                    anterior.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });  
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPropietario ventana;
                try {
                    ventana = new AgregarPropietario(con);
                    ventana.setVisible(true);
                    anterior.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });  
    }
}
