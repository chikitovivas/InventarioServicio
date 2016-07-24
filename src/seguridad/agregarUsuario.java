/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gerson
 */
public class agregarUsuario extends javax.swing.JFrame {
    //Nueva statement
    public Statement stmt = null;
    //Nuevo ResultSet
    ResultSet rs = null;
    //Variable conexion a la DB
    Connection con = null;
    /**
     * Creates new form agregarUsuario
     * @param con
     * @throws java.sql.SQLException
     */
    public agregarUsuario(Connection con) throws SQLException {
        initComponents();
        this.con = con;
        stmt = con.createStatement();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        cancelarBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        passwordPassField = new javax.swing.JPasswordField();
        tlf1TxtField = new javax.swing.JTextField();
        confirPassPassField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tlf2TxtField = new javax.swing.JTextField();
        adminRdioBtn = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        usuarioRdioBtn = new javax.swing.JRadioButton();
        usernameTxtField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        emailTxtField = new javax.swing.JTextField();
        nombreTxtField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        apellidoTxtField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        estatusUserCmBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cancelarBtn.setText("Cancelar");
        cancelarBtn.setPreferredSize(new java.awt.Dimension(71, 23));
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        jLabel10.setText("(*) Confirmar password:");

        guardar.setText("Agregar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        jLabel3.setText("(*)Password:");

        jLabel9.setText("Telefono 1:");

        buttonGroup1.add(adminRdioBtn);
        adminRdioBtn.setText("Administrador");

        jLabel4.setText("(*)Nombre:");

        buttonGroup1.add(usuarioRdioBtn);
        usuarioRdioBtn.setSelected(true);
        usuarioRdioBtn.setText("Usuario");

        jLabel5.setText("Telefono 2:");

        jLabel2.setText("(*)Apellido:");

        jLabel7.setText("Email:");

        jLabel1.setText("(*)Username:");

        jLabel6.setText("Estado:");

        estatusUserCmBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Vacaciones", "Reposo", "Desincorporado" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(48, 48, 48))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel5)
                                .addComponent(jLabel10)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel7))
                            .addGap(1, 1, 1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(77, 77, 77)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(adminRdioBtn)
                                .addGap(18, 18, 18)
                                .addComponent(usuarioRdioBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(guardar)
                                .addGap(18, 18, 18)
                                .addComponent(cancelarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(usernameTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreTxtField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(apellidoTxtField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(estatusUserCmBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailTxtField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tlf2TxtField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tlf1TxtField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordPassField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(confirPassPassField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nombreTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(apellidoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(confirPassPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tlf1TxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tlf2TxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(estatusUserCmBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminRdioBtn)
                    .addComponent(usuarioRdioBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        int tipoUsuario;
        //Se verifica si todos los campos basicos estan llenos

        System.out.println("INSERT INTO `inventario`.`usuario` (`Nombre`, `Apellido`, `Password`, `Tlf_1`, `Tlf_2`, `Username`, `Email`, `Estatus_usuario`, `Tipo`) "
                                + "VALUES ('"+nombreTxtField.getText()+"' "
                                + " '"+apellidoTxtField.getText()+"', "
                                + " '"+passwordPassField.getPassword()+"', "
                                + " '"+tlf1TxtField.getText()+"', "
                                + " '"+tlf2TxtField.getText()+"', "
                                + " '"+usernameTxtField.getText()+"', "
                                + " '"+emailTxtField.getText()+"', "
                                + " '"+estatusUserCmBox.getSelectedItem()+"',  "
                                + " "+0+" ); " );

        if( !usernameTxtField.getText().equals("") && !nombreTxtField.getText().equals("") && !apellidoTxtField.getText().equals("")){
            
            
            
            if (Arrays.equals(passwordPassField.getPassword(), confirPassPassField.getPassword())){
                if(adminRdioBtn.isSelected())
                tipoUsuario = 1;
                else
                tipoUsuario = 0;

                try {
                    String query = "INSERT INTO `inventario`.`usuario` (`Nombre`, `Apellido`, `Password`, `Tlf_1`, `Tlf_2`, `Username`, `Email`, `Estatus_usuario`, `Tipo`) "
                                    + "VALUES ('"+nombreTxtField.getText()+"', "
                                    + " '"+apellidoTxtField.getText()+"', "
                                    + " '"+new String (passwordPassField.getPassword())+"', "
                                    + " '"+tlf1TxtField.getText()+"', "
                                    + " '"+tlf2TxtField.getText()+"', "
                                    + " '"+usernameTxtField.getText()+"', "
                                    + " '"+emailTxtField.getText()+"', "
                                    + " '"+estatusUserCmBox.getSelectedItem()+"', "
                                    + " "+tipoUsuario+" ); " ;

                    stmt.execute(query);
                    JOptionPane.showMessageDialog(null, "Usuario agregado exitósamente");
                    limpiarFormulario();
                } catch (SQLException ex) {
                    Logger.getLogger(agregarEditar_usuario.class.getName()).log(Level.SEVERE, null, ex);

                    switch (ex.getErrorCode()){
                        case 1062:
                        JOptionPane.showMessageDialog(null, "Codigo de error : " + ex.getErrorCode()  + " \n " + ex  + " \n "
                            + "Este usuario ya existe en la base de datos.\n Introduzca un username distinto." ,"Error.", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Los password deben coincidir.","Error al agregar"
                ,JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Los campos con '(*)' deben ser debidamente llenados.","Error al agregar"
                ,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_guardarActionPerformed
    
    public void limpiarFormulario (){
        nombreTxtField.setText("");
        apellidoTxtField.setText("");
        passwordPassField.setText("");
        confirPassPassField.setText("");
        tlf1TxtField.setText("");
        tlf2TxtField.setText("");
        usernameTxtField.setText("");
        emailTxtField.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(agregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agregarUsuario().setVisible(true);
            }
        }); */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton adminRdioBtn;
    private javax.swing.JTextField apellidoTxtField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JPasswordField confirPassPassField;
    private javax.swing.JTextField emailTxtField;
    private javax.swing.JComboBox<String> estatusUserCmBox;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nombreTxtField;
    private javax.swing.JPasswordField passwordPassField;
    private javax.swing.JTextField tlf1TxtField;
    private javax.swing.JTextField tlf2TxtField;
    private javax.swing.JTextField usernameTxtField;
    private javax.swing.JRadioButton usuarioRdioBtn;
    // End of variables declaration//GEN-END:variables
}