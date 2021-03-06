/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

import DB.Usuario;
import interfazNueva.Index;
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
 * @author gerson
 */
public class agregarEditar_usuario extends javax.swing.JFrame {
    //Nueva statement
    public Statement stmt = null;
    //Nuevo ResultSet
    ResultSet rs = null;
    //Variable conexion a la DB
    Connection con = null;
    
    private String passwordAnt;
    /**
     * Creates new form crearUsuario
     * @param con
     * @throws java.sql.SQLException
     */
    public agregarEditar_usuario(Connection con) throws SQLException {
        initComponents();
        
        //Conexion a la DB
        this.con = con;
        stmt = con.createStatement();
        usuariosLista();
         this.remove(cancelar);
        this.remove(guardar);
        this.revalidate();
        this.repaint();
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
        cancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        agregar_Usuario = new javax.swing.JButton();
        usernameTxtField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nombreTxtField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        apellidoTxtField = new javax.swing.JTextField();
        editar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        tlf1TxtField = new javax.swing.JTextField();
        tlf2TxtField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        emailTxtField = new javax.swing.JTextField();
        usuariosList = new java.awt.List();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        adminRdioBtn = new javax.swing.JRadioButton();
        usuarioRdioBtn = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        passwordPassField = new javax.swing.JPasswordField();
        confirPassPassField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        passAntPassField = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        estatusUserCmBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel9.setText("Telefono 1:");

        agregar_Usuario.setText("+");
        agregar_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_UsuarioActionPerformed(evt);
            }
        });

        usernameTxtField.setEnabled(false);

        jLabel2.setText("(*)Apellido:");

        nombreTxtField.setEnabled(false);

        jLabel6.setText("Usuarios:");

        apellidoTxtField.setEnabled(false);

        editar.setText("Editar");
        editar.setPreferredSize(new java.awt.Dimension(71, 23));
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        tlf1TxtField.setEnabled(false);

        tlf2TxtField.setEnabled(false);

        jLabel4.setText("(*)Nombre:");

        jLabel5.setText("Telefono 2:");

        emailTxtField.setEnabled(false);

        usuariosList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosListActionPerformed(evt);
            }
        });

        jLabel7.setText("Email:");

        jLabel1.setText("(*)Username:");

        buttonGroup1.add(adminRdioBtn);
        adminRdioBtn.setText("Administrador");
        adminRdioBtn.setEnabled(false);

        buttonGroup1.add(usuarioRdioBtn);
        usuarioRdioBtn.setSelected(true);
        usuarioRdioBtn.setText("Usuario");
        usuarioRdioBtn.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cambiar password"));

        passwordPassField.setEnabled(false);

        confirPassPassField.setEnabled(false);

        jLabel3.setText("(*)Password:");

        jLabel10.setText("(*) Confirmar password:");

        jLabel8.setText("(*)Password anterior:");

        passAntPassField.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(70, 70, 70))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(26, 26, 26)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordPassField)
                    .addComponent(confirPassPassField)
                    .addComponent(passAntPassField)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(passAntPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirPassPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        jLabel11.setText("Estado:");

        estatusUserCmBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Vacaciones", "Reposo", "Desincorporado" }));
        estatusUserCmBox.setEnabled(false);
        estatusUserCmBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estatusUserCmBoxActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                        .addComponent(agregar_Usuario))
                    .addComponent(usuariosList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(adminRdioBtn)
                                    .addGap(18, 18, 18)
                                    .addComponent(usuarioRdioBtn))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel2))
                                                    .addGap(11, 11, 11)))
                                            .addGap(27, 27, 27))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addGap(56, 56, 56)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(estatusUserCmBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tlf1TxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                        .addComponent(nombreTxtField)
                                        .addComponent(usernameTxtField)
                                        .addComponent(apellidoTxtField)
                                        .addComponent(tlf2TxtField)
                                        .addComponent(emailTxtField))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(agregar_Usuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(jLabel11)
                            .addComponent(estatusUserCmBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminRdioBtn)
                            .addComponent(usuarioRdioBtn))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelar)
                            .addComponent(guardar)))
                    .addComponent(usuariosList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        reiniciarformulario();
    }//GEN-LAST:event_cancelarActionPerformed

    private void agregar_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_UsuarioActionPerformed
        try {
            Callable<Void> prueba = new Callable<Void>() {
            //Funcion call(), la que se ejecutara desde la variable
                public Void call() {
                    usuariosLista();
                    return null;
                }
            };
            agregarUsuario crearUsuario = new agregarUsuario (con,prueba);
            crearUsuario.setVisible(true);
            crearUsuario.setLocationRelativeTo(null);
            crearUsuario.setResizable(false);
        } catch (SQLException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_agregar_UsuarioActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed

        this.usernameTxtField.setEnabled(true);
        this.nombreTxtField.setEnabled(true);
        this.apellidoTxtField.setEnabled(true);
        this.passAntPassField.setEnabled(true);
        this.passwordPassField.setEnabled(true);
        this.confirPassPassField.setEnabled(true);
        this.tlf1TxtField.setEnabled(true);
        this.tlf2TxtField.setEnabled(true);
        this.emailTxtField.setEnabled(true);
        this.estatusUserCmBox.setEnabled(true);
        this.adminRdioBtn.setEnabled(true);
        this.usuarioRdioBtn.setEnabled(true);
        cancelar.setBounds(editar.getBounds());
        this.add(guardar);
        this.remove(editar);
        this.add(cancelar);
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_editarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
       int tipoUsuario;
       String query = null;
       String passAnt = new String (passAntPassField.getPassword());
       String passwordPass = new String (passwordPassField.getPassword());
       String confirPass = new String (confirPassPassField.getPassword());
        //Se verifica si todos los campos basicos estan llenos
        Usuario usuario = new Usuario(con,(String) usuariosList.getSelectedItem());
        
        
        if(adminRdioBtn.isSelected())
            tipoUsuario = 1;
        else
            tipoUsuario = 0; 
        
        
        if(!passAnt.equals("") || !passwordPass.equals("") || !confirPass.equals("")){
            if(!passAnt.equals("") && !passwordPass.equals("") && !confirPass.equals("")){

                        System.out.println("Pass anterior 1 : " +  passwordAnt);
                        System.out.println("Pass anterior 2 : " +  passAnt );
                        System.out.println("Pass nueva: " + passwordPass +" - " + passwordPass );
                        System.out.println("Pass confirmada: " + confirPass +" - " + confirPass);

                if(passAnt.equals(passwordAnt) )
                { 
                    if( passwordPass.equals(confirPass)){


                        query = " UPDATE `inventario`.`usuario` SET "
                                    +      "`Nombre`= '"+nombreTxtField.getText()+"', "
                                    +      "`Apellido`= '"+apellidoTxtField.getText()+"', "
                                    +      "`Password`= '"+ passwordPass +"', "
                                    +      "`Tlf_1`= '"+tlf1TxtField.getText()+"', "
                                    +      "`Tlf_2`= '"+tlf2TxtField.getText()+"', "
                                    +      "`Username`= '"+usernameTxtField.getText()+"', "
                                    +      "`Email`= '"+emailTxtField.getText()+"', "
                                    +      " `Estatus_usuario`= '"+estatusUserCmBox.getSelectedItem()+"', "
                                    +      " `Tipo`= '"+tipoUsuario+"' "
                                    + "     WHERE `idUsuario`= '"+usuario.getIdUsuario()+"' ; " ;
                    }else{
                        JOptionPane.showMessageDialog(null, "El password nuevo debe coincidir con el de confirmación" ,"Error.", JOptionPane.ERROR_MESSAGE); 
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Debe introducir su password actual en el campo 'Password anterior' " ,"Error.", JOptionPane.ERROR_MESSAGE);     
                }
            }else{
                JOptionPane.showMessageDialog(null, "Si desea cambiar su password debe completar todos los campos requeridos, si no debe dejarlos vacíos.","Error al agregar"
                     ,JOptionPane.ERROR_MESSAGE);
            }
            
        }else{   query = " UPDATE `inventario`.`usuario` SET "
                        +      "`Nombre`= '"+nombreTxtField.getText()+"', "
                        +      "`Apellido`= '"+apellidoTxtField.getText()+"', "
                        +      "`Tlf_1`='"+tlf1TxtField.getText()+"', "
                        +      "`Tlf_2`='"+tlf2TxtField.getText()+"', "
                        +      "`Username`='"+usernameTxtField.getText()+"', "
                        +      "`Email`='"+emailTxtField.getText()+"', "
                        +      " `Estatus_usuario`= '"+estatusUserCmBox.getSelectedItem()+"', "
                        +      " `Tipo`= '"+tipoUsuario+"' "
                        + "     WHERE `idUsuario`='"+usuario.getIdUsuario()+"' ; " ;
        }
        
        
            if( !usernameTxtField.getText().equals("") && !nombreTxtField.getText().equals("") && !apellidoTxtField.getText().equals("")){
            
                try {

                    stmt.execute(query);
                    JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito.");
                    reiniciarformulario();
                    
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
            JOptionPane.showMessageDialog(null, "Los campos con '(*)' deben ser debidamente llenados.","Error al agregar"
                     ,JOptionPane.ERROR_MESSAGE);
        }  
    }//GEN-LAST:event_guardarActionPerformed

    private void usuariosListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosListActionPerformed
   
        Usuario usuario = new Usuario(con,(String) usuariosList.getSelectedItem());
        this.usernameTxtField.setText(usuario.getUsername());
        this.nombreTxtField.setText(usuario.getNombre());
        this.apellidoTxtField.setText(usuario.getApellido());
        passwordAnt = usuario.getPassword();
        this.confirPassPassField.setText("");
        this.tlf1TxtField.setText(usuario.getTlf_1());
        this.tlf2TxtField.setText(usuario.getTlf_2());
        this.emailTxtField.setText(usuario.getEmail());
        this.estatusUserCmBox.setSelectedItem(usuario.getEstatus());
        if(usuario.getTipo() == 1 ){
            adminRdioBtn.setSelected(true);
        }else{
            usuarioRdioBtn.setSelected(true);
        }
    }//GEN-LAST:event_usuariosListActionPerformed

    private void estatusUserCmBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estatusUserCmBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estatusUserCmBoxActionPerformed

    public void usuariosLista(){
        try {
            rs = stmt.executeQuery("SELECT Username FROM inventario.usuario ;");
            rs.beforeFirst();
            this.usuariosList.removeAll();
            while (rs.next()) {
                usuariosList.add(rs.getString("Username"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(agregarEditar_usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private void limpiar_formulario(){
        
        this.usernameTxtField.setText("");
        this.nombreTxtField.setText("");
        this.apellidoTxtField.setText("");
        this.confirPassPassField.setText("");
        this.passAntPassField.setText("");
        this.passwordPassField.setText("");
        this.tlf1TxtField.setText("");
        this.tlf2TxtField.setText("");
        this.emailTxtField.setText("");
        this.estatusUserCmBox.setSelectedItem("Activo");
    }
    
    private void reiniciarformulario(){
        
        this.usernameTxtField.setEnabled(false);
        this.nombreTxtField.setEnabled(false);
        this.apellidoTxtField.setEnabled(false);
        this.passwordPassField.setEnabled(false);
        this.passAntPassField.setEnabled(false);
        this.confirPassPassField.setEnabled(false);
        this.tlf1TxtField.setEnabled(false);
        this.tlf2TxtField.setEnabled(false);
        this.emailTxtField.setEnabled(false);
        this.estatusUserCmBox.setEnabled(false);
        this.adminRdioBtn.setEnabled(false);
        this.usuarioRdioBtn.setEnabled(false);
        editar.setBounds(cancelar.getBounds());
        this.remove(cancelar);
        this.remove(guardar);
        this.add(editar);
        this.revalidate();
        this.repaint();
        limpiar_formulario();
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
            java.util.logging.Logger.getLogger(agregarEditar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agregarEditar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agregarEditar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agregarEditar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new crearUsuario().setVisible(true);
            }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new crearUsuario().setVisible(true);
            }
        }); */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton adminRdioBtn;
    private javax.swing.JButton agregar_Usuario;
    private javax.swing.JTextField apellidoTxtField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelar;
    private javax.swing.JPasswordField confirPassPassField;
    private javax.swing.JButton editar;
    private javax.swing.JTextField emailTxtField;
    private javax.swing.JComboBox<String> estatusUserCmBox;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreTxtField;
    private javax.swing.JPasswordField passAntPassField;
    private javax.swing.JPasswordField passwordPassField;
    private javax.swing.JTextField tlf1TxtField;
    private javax.swing.JTextField tlf2TxtField;
    private javax.swing.JTextField usernameTxtField;
    private javax.swing.JRadioButton usuarioRdioBtn;
    private java.awt.List usuariosList;
    // End of variables declaration//GEN-END:variables
}
