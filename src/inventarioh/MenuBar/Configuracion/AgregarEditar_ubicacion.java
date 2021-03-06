/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioh.MenuBar.Configuracion;

import DB.Ubicacion;
import interfazNueva.menubar;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class AgregarEditar_ubicacion extends javax.swing.JFrame {
    //Nueva statement
    public Statement stmt = null;
    //Nuevo ResultSet
    ResultSet rs = null;
    //Variable conexion a la DB
    Connection con = null;
    Callable hola = null;
    Callable refrescar = null;
    /**
     * Creates new form AgregarEditar_ubicacion
     */
    public AgregarEditar_ubicacion(Connection con, Callable refrescar) throws SQLException{
        initComponents();
        //Conexion a la DB
        this.con = con;
        stmt = con.createStatement();
        /* Titulo del Jframe */
        this.setTitle("Ubicaciones");
        //Combobox Ubicacion
        Ubicacion ub = new Ubicacion(con);
        //Se obtienen todas las descripciones de las ubicacion
        rs = ub.getAll();
        this.refrescar = refrescar;      
        // Anadimos cada una de las Ubicacion al list ubicacion
        while(rs.next()){
            this.Ubicaciones.add(rs.getString("descripcion"));
        } 
      
        //Inicializaciones graficas de botones, jtextfields
        /************ Ubicaciones *************/
            /* Botones */
        this.guardar.setVisible(false);
        this.cancelar.setVisible(false);
            /* Background */
        this.id.setBackground(Color.lightGray);
        this.descripcion.setBackground(Color.lightGray);
            /* Color del texto en Disabled */
        this.id.setDisabledTextColor(Color.black);
        this.descripcion.setDisabledTextColor(Color.black);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        Ubicaciones = new java.awt.List();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        agregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        editar.setText("Editar");
        editar.setPreferredSize(new java.awt.Dimension(71, 23));
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        jLabel6.setText("Ubicaciones físicas:");

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        Ubicaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbicacionesActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Descripcion:");

        descripcion.setEnabled(false);

        id.setEnabled(false);

        agregar.setText("+");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addComponent(agregar))
                    .addComponent(Ubicaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelar)
                        .addGap(18, 18, 18)
                        .addComponent(guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(agregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelar)
                            .addComponent(guardar))
                        .addGap(0, 69, Short.MAX_VALUE))
                    .addComponent(Ubicaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(579, 331));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

 
    /* Reanudar la seccion de Ubicacion a deshabilitado */
    public void reanudar(){
        this.guardar.setVisible(false);
        this.cancelar.setVisible(false);
        this.editar.setVisible(true);
        this.descripcion.setBackground(Color.lightGray);    
    }
    /* Borrar los JtextFields de Ubicacion */
    public void borrarS(){
        this.id.setText("");
        this.descripcion.setText("");
    }     
    
    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        //Si en el Combobox ubicacion hay items, la funcion editar servira
        //Habilita los campos de descripcion y los botones de guardar y cancelar
        if(this.Ubicaciones.getSelectedIndex() != -1){
            this.descripcion.enable(true);
            this.guardar.setVisible(true);
            this.cancelar.setVisible(true);
            this.editar.setVisible(false);
            this.descripcion.setBackground(Color.white);
        }
    }//GEN-LAST:event_editarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        //Clase Ubicacion
        Ubicacion cat = new Ubicacion(con);
        //Si da la ubicacion Exitosamente
        if(cat.actualizar_ubicacion(this.id.getText().toString(),this.descripcion.getText().toString())){
            JOptionPane.showMessageDialog(null, "Ubicacion actualizada Exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "No se actualizo la ubicacion.","Error al actualizar"
                ,JOptionPane.ERROR_MESSAGE);
        }
        //Remueve todos los Items del ComboBox Ubicacion
        this.Ubicaciones.removeAll();
        //Y se agregan las nuevas Ubicacion al comboBox pero actualizado
        try {
            this.refrescar.call();
            //Nueva Clase ubicacion
            Ubicacion ca = new Ubicacion(con);
            //Se obtienen todas las descripciones de las ubicacion
            rs = ca.getAll();
            // Anadimos cada una de las Ubicacion al list ubicacion
            while(rs.next()){
                this.Ubicaciones.add(rs.getString("descripcion"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AgregarEditar_ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AgregarEditar_ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Se borran los campos descripcion y id de Ubicacion
        this.borrarS();
        //Se borran los campos descripcion, id
        this.reanudar();
    }//GEN-LAST:event_guardarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        //Reanudo los campos de Ubicacion a deshabilitados
        this.reanudar();
    }//GEN-LAST:event_cancelarActionPerformed

    private void UbicacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbicacionesActionPerformed
        if(this.Ubicaciones.getItemCount() != 0){//Entra en la condicion si hay mas de un Item en el List
            //Buscar el id de Ubicacion con respecto a la descripcion
            Ubicacion cat = new Ubicacion(con);

            //Busqueda de DB, para la ubicacion seleccionada, y llenar los campos
            ResultSet cate = cat.getUbicacion(this.Ubicaciones.getSelectedItem().toString());
            try {
                this.id.setText(cate.getString("idUbicacion"));
                this.descripcion.setText(cate.getString("descripcion"));
            } catch (SQLException ex) {
                Logger.getLogger(AgregarEditar_ubicacion.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Cambios graficos al cambiar una Ubicacion
            this.reanudar();
        }
    }//GEN-LAST:event_UbicacionesActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        //Creamos un nueva Callable (Creamos una variable que guarda funciones)
        Callable<Void> prueba = new Callable<Void>() {
            //Funcion call(), la que se ejecutara desde la variable
            public Void call() {
                reanudar();
                borrarS();
                return null;
            }
        };
        //Abrimos un nuevo Jframe para agregar Ubicacion
        Agregar_ubicacion pantalla;
        try {
            pantalla = new Agregar_ubicacion(this.Ubicaciones,this.con,prueba,this.refrescar);
            pantalla.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AgregarEditar_ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_agregarActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarEditar_ubicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarEditar_ubicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarEditar_ubicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarEditar_ubicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
     /*   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarEditar_ubicacion().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.List Ubicaciones;
    private javax.swing.JButton agregar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField descripcion;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
