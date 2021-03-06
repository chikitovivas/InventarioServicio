/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventarioh.MenuBar.Proveedores_Donantes;

import DB.Proveedor;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


/**
 *
 * @author Usuario
 */
public class Agregar_proveedor extends javax.swing.JFrame {
    //Combobox de Proveedor
    java.awt.List Proveedor = null;
    //Nuevo ResultSet
    ResultSet rs = null;
    //Variable conexion a la DB
    Connection con = null;
    //Nuevo Callable
    Callable funciones;
    Callable refrescar;
    
    int id;
    
    /**
     * Creates new form Proveedor
     */
    public Agregar_proveedor(java.awt.List proveedor, Connection con, Callable hola, Callable refrescar) throws SQLException {
        initComponents();
        this.setTitle("Nueva Proveedor");
        //Le igualamos el combobox de la lista de Proveedor
        this.Proveedor = proveedor;
        //Conexion
        this.con = con;
        //Igualamos las funciones a nuestra variable
        this.funciones = hola;
        this.refrescar = refrescar;
        //Combobox Proveedor
        Proveedor pro = new Proveedor(con);
        //Se obtienen todas las descripciones de las Proveedor
        rs = pro.getAllid();
        
        if(rs.last()){
            this.id = rs.getInt("idProveedor") + 1;
            this.idProveedor.setText(Integer.toString(id));
            this.idProveedor.setBackground(Color.lightGray);
            this.idProveedor.setDisabledTextColor(Color.black);
            this.idProveedor.enable(false);
        }else{
            this.id =  1;
            this.idProveedor.setText(Integer.toString(id));
            this.idProveedor.setBackground(Color.lightGray);
            this.idProveedor.setDisabledTextColor(Color.black);
            this.idProveedor.enable(false); 
        }
        
        
        
        //Seteamos la Operacion de cierre, a solo esconder este frame
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descripcion2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        idProveedor2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        razon_social = new javax.swing.JTextField();
        agregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        idProveedor = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rif = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tlf2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tlf1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        contacto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jLabel5.setText("(*)Direccion:");

        jLabel6.setText("(*)RIF-Cedula:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("(*)Razon Social:");

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        jLabel2.setText("(*)ID:");

        idProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idProveedorActionPerformed(evt);
            }
        });

        jLabel3.setText("Direccion:");

        jLabel4.setText("(*)Razón Social/Nombre:");

        jLabel7.setText("Telefono 2:");

        jLabel8.setText("Telefono 1:");

        jLabel9.setText("Email:");

        jLabel10.setText("Contacto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(agregar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rif, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(razon_social)
                                        .addComponent(idProveedor)
                                        .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tlf1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tlf2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(razon_social, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tlf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tlf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(contacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(agregar)
                .addGap(30, 30, 30))
        );

        setSize(new java.awt.Dimension(375, 412));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
       //Nueva clase Proveedor
        Proveedor cat = new Proveedor(this.con);
        //Si el JtextField esta NO esta vacio
        if(this.razon_social.getText().replaceAll(" ", "").length() != 0){
            //Si se guarda Existosamente en la DB
            if(cat.insertar_proveedor(this.razon_social.getText().toString(),this.rif.getText().toString(),this.direccion.getText().toString(),
                    this.tlf1.getText().toString(),this.tlf2.getText().toString(),this.contacto.getText().toString(),
                    this.email.getText().toString()
            ) ){
                //Mensaje de Exito
                JOptionPane.showMessageDialog(null, "Proveedor agregada Exitosamente");
                //Buscamos todas las Proveedor actualizadas
                this.rs  = cat.getAll();
                //Removemos los Items que hay en el JComboBox ProveedorProveedor
                this.Proveedor.removeAll();
                //A#adimos cada una de las proveedor actualizadas al Combobox
                try {
                    while(rs.next()){
                        this.Proveedor.add(rs.getString("razon_social").toString());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Agregar_proveedor.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    //Llamamos a las funciones de borrar y reanudar
                    this.funciones.call();
                    this.refrescar.call();
                    //Ventana actual
                    this.razon_social.setText("");
                    this.rif.setText("");
                    this.direccion.setText("");
                    this.tlf1.setText("");
                    this.tlf2.setText("");
                    this.contacto.setText("");
                    this.email.setText("");
                    //Se obtienen todas las descripciones de las Proveedor
                    rs = cat.getAllid();

                    if(rs.last()){
                        this.id = rs.getInt("idProveedor") + 1;
                        this.idProveedor.setText(Integer.toString(id));
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Agregar_proveedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                //Mesanje de Error al introducir
                JOptionPane.showMessageDialog(null, "No se agrego el Proveedor.","Error al agregar"
                ,JOptionPane.ERROR_MESSAGE);
            }            
        }else{
            //Mensaje de Error si no estan llenos los campos
            JOptionPane.showMessageDialog(null, "Llenar Todos los Campos (*)","Error al agregar"
                ,JOptionPane.ERROR_MESSAGE);
        }

        
    }//GEN-LAST:event_agregarActionPerformed

    private void idProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProveedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Agregar_proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar_proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar_proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar_proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_categoria().setVisible(true);
            }
        //</editor-fold>

        /* Create and display the form */
      /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_categoria().setVisible(true);
            }
        //</editor-fold>

        /* Create and display the form */
      /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_categoria().setVisible(true);
            }
        //</editor-fold>

        /* Create and display the form */
      /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_categoria().setVisible(true);
            }
        //</editor-fold>

        /* Create and display the form */
      /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_categoria().setVisible(true);
            }
        //</editor-fold>

        /* Create and display the form */
      /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_categoria().setVisible(true);
            }
        //</editor-fold>

        /* Create and display the form */
      /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_categoria().setVisible(true);
            }
        //</editor-fold>

        /* Create and display the form */
      /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_categoria().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JTextField contacto;
    private javax.swing.JTextField descripcion2;
    private javax.swing.JTextField direccion;
    private javax.swing.JTextField email;
    private javax.swing.JTextField idProveedor;
    private javax.swing.JTextField idProveedor2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField razon_social;
    private javax.swing.JTextField rif;
    private javax.swing.JTextField tlf1;
    private javax.swing.JTextField tlf2;
    // End of variables declaration//GEN-END:variables
}
