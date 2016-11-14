/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventarioh.MenuBar.Configuracion;

import DB.Familia;
import interfazNueva.menubar;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class AgregarEditar_familia extends javax.swing.JFrame {
    //Nueva statement
    public Statement stmt = null;
    //Nuevo ResultSet
    ResultSet rs = null;
    //Variable conexion a la DB
    Connection con = null;
    Callable hola = null;
    Callable refrescar = null;
    
    /**
     * Creates new form Agregar_categoria
     */
    public AgregarEditar_familia(Connection con, Callable refrescar) throws SQLException {
        initComponents();
        //Conexion a la DB
        this.con = con;
        stmt = con.createStatement();
        /* Titulo del Jframe */
        this.setTitle("Categorias");
        //Combobox Categoria
        Familia ca = new Familia(con);
        //Se obtienen todas las descripciones de las categorias
        rs = ca.getAll();
        this.refrescar = refrescar;     
        // Anadimos cada una de las categorias al combobox Categoria
        while(rs.next()){
            this.Categorias.add(rs.getString("descripcion"));
        } 
      
        //Inicializaciones graficas de botones, jtextfields
        /************ Categorias *************/
            /* Botones */
        this.guardar_categoria.setVisible(false);
        this.cancelar_categoria.setVisible(false);
            /* Background */
        this.id_categoria.setBackground(Color.lightGray);
        this.desc_categoria.setBackground(Color.lightGray);
            /* Color del texto en Disabled */
        this.id_categoria.setDisabledTextColor(Color.black);
        this.desc_categoria.setDisabledTextColor(Color.black);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        desc_categoria = new javax.swing.JTextField();
        id_categoria = new javax.swing.JTextField();
        agregar_categoria = new javax.swing.JButton();
        editar_categoria = new javax.swing.JButton();
        guardar_categoria = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cancelar_categoria = new javax.swing.JButton();
        Categorias = new java.awt.List();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID:");

        jLabel2.setText("Descripcion:");

        desc_categoria.setEnabled(false);

        id_categoria.setEnabled(false);

        agregar_categoria.setText("+");
        agregar_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_categoriaActionPerformed(evt);
            }
        });

        editar_categoria.setText("Editar");
        editar_categoria.setPreferredSize(new java.awt.Dimension(71, 23));
        editar_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_categoriaActionPerformed(evt);
            }
        });

        guardar_categoria.setText("Guardar");
        guardar_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_categoriaActionPerformed(evt);
            }
        });

        jLabel6.setText("Categorias:");

        cancelar_categoria.setText("Cancelar");
        cancelar_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_categoriaActionPerformed(evt);
            }
        });

        Categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriasActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                        .addComponent(agregar_categoria))
                    .addComponent(Categorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelar_categoria)
                        .addGap(18, 18, 18)
                        .addComponent(guardar_categoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editar_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(desc_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(agregar_categoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(id_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(desc_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editar_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelar_categoria)
                            .addComponent(guardar_categoria))))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(604, 263));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriasActionPerformed
        if(this.Categorias.getItemCount() != 0){//Entra en la condicion si hay mas de un Item en el ComboBox
            //Buscar el id de Categoria con respecto a la descripcion
            Familia cat = new Familia(con);

            //Busqueda de DB, para la categoria seleccionada, y llenar los campos
            ResultSet cate = cat.getFamilia(Categorias.getSelectedItem().toString());
            try {
                this.id_categoria.setText(cate.getString("idFamilia"));
                this.desc_categoria.setText(cate.getString("descripcion"));
            } catch (SQLException ex) {
                Logger.getLogger(AgregarEditar_familia.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Cambios graficos al cambiar una categoria
            this.reanudar_Categoria();
        }
    }//GEN-LAST:event_CategoriasActionPerformed

    private void editar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_categoriaActionPerformed
        //Si en el Combobox Categorias hay items, la funcion editar servira
        //Habilita los campos de descripcion y los botones de guardar y cancelar
        if(this.Categorias.getSelectedIndex() != -1){
            this.desc_categoria.enable(true);
            this.guardar_categoria.setVisible(true);
            this.cancelar_categoria.setVisible(true);
            this.editar_categoria.setVisible(false);
            this.desc_categoria.setBackground(Color.white);
        }
    }//GEN-LAST:event_editar_categoriaActionPerformed

    private void guardar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_categoriaActionPerformed
        //Clase Categoria
        Familia cat = new Familia(con);
        //Si se Guarda la categoria Exitosamente
        if(cat.actualizar_familia(this.id_categoria.getText().toString(),this.desc_categoria.getText().toString())){
            JOptionPane.showMessageDialog(null, "Categoria actualizada Exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "No se actualizo la categoria.","Error al actualizar"
                ,JOptionPane.ERROR_MESSAGE);
        }
        //Remueve todos los Items del ComboBox Categoria
        this.Categorias.removeAll();
        //Y se agregan las nuevas categorias al comboBox pero actualizado
        try {
            this.refrescar.call();
            //Nueva Clase Categoria
            Familia ca = new Familia(con);
            //Se obtienen todas las descripciones de las categorias
            rs = ca.getAll();
            // Anadimos cada una de las categorias al combobox Categoria
            while(rs.next()){
                this.Categorias.add(rs.getString("descripcion"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AgregarEditar_familia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AgregarEditar_familia.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Se borran los campos descripcion y id de categorias
        this.borrarS_Categoria();
        //Se borran los campos descripcion, id, codigo de Subcategorias
        this.reanudar_Categoria();
    }//GEN-LAST:event_guardar_categoriaActionPerformed

    private void agregar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_categoriaActionPerformed
        //Creamos un nueva Callable (Creamos una variable que guarda funciones)
        Callable<Void> prueba = new Callable<Void>() {
            //Funcion call(), la que se ejecutara desde la variable
            public Void call() {
                reanudar_Categoria();
                borrarS_Categoria();
                return null;
            }
        };
        //Abrimos un nuevo Jframe para agregar categoria
        Agregar_familia pantalla = new Agregar_familia(this.Categorias,this.con,prueba,this.refrescar);
        pantalla.setVisible(true);
    }//GEN-LAST:event_agregar_categoriaActionPerformed

    private void cancelar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_categoriaActionPerformed
        //Reanudo los campos de Categoria a deshabilitados
        this.reanudar_Categoria();
    }//GEN-LAST:event_cancelar_categoriaActionPerformed


    /* Reanudar la seccion de Categorias a deshabilitado */
    public void reanudar_Categoria(){
        this.guardar_categoria.setVisible(false);
        this.cancelar_categoria.setVisible(false);
        this.editar_categoria.setVisible(true);
        this.desc_categoria.setBackground(Color.lightGray);    
    }
    /* Borrar los JtextFields de Categorias */
    public void borrarS_Categoria(){
        this.id_categoria.setText("");
        this.desc_categoria.setText("");
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
            java.util.logging.Logger.getLogger(AgregarEditar_familia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarEditar_familia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarEditar_familia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarEditar_familia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private java.awt.List Categorias;
    private javax.swing.JButton agregar_categoria;
    private javax.swing.JButton cancelar_categoria;
    private javax.swing.JTextField desc_categoria;
    private javax.swing.JButton editar_categoria;
    private javax.swing.JButton guardar_categoria;
    private javax.swing.JTextField id_categoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
