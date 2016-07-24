/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazNueva;

/**
 *
 * @author Yanir
 */
public class FamiliaPanel extends javax.swing.JPanel {

    /**
     * Creates new form Familia
     */
    public FamiliaPanel() {
        initComponents();
        NuevaFamiliaPanel.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NuevaFamiliaPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        agregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        idFamilia = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        desc_categoria = new javax.swing.JTextField();
        id_categoria = new javax.swing.JTextField();
        agregar_categoria = new javax.swing.JButton();
        editar_categoria = new javax.swing.JButton();
        guardar_categoria = new javax.swing.JButton();
        cancelar_categoria = new javax.swing.JButton();
        Categorias = new java.awt.List();
        jLabel4 = new javax.swing.JLabel();

        NuevaFamiliaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Nueva familia"));

        jLabel1.setText("(*)Descripcion:");

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        jLabel2.setText("(*)ID:");

        javax.swing.GroupLayout NuevaFamiliaPanelLayout = new javax.swing.GroupLayout(NuevaFamiliaPanel);
        NuevaFamiliaPanel.setLayout(NuevaFamiliaPanelLayout);
        NuevaFamiliaPanelLayout.setHorizontalGroup(
            NuevaFamiliaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevaFamiliaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NuevaFamiliaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NuevaFamiliaPanelLayout.createSequentialGroup()
                        .addGroup(NuevaFamiliaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(NuevaFamiliaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripcion)
                            .addGroup(NuevaFamiliaPanelLayout.createSequentialGroup()
                                .addComponent(idFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(agregar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        NuevaFamiliaPanelLayout.setVerticalGroup(
            NuevaFamiliaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevaFamiliaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NuevaFamiliaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NuevaFamiliaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(agregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Familias"));

        jLabel3.setText("Descripcion:");

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

        jLabel4.setText("ID:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelar_categoria)
                        .addGap(18, 18, 18)
                        .addComponent(guardar_categoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editar_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(agregar_categoria)
                            .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(desc_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(id_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(desc_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editar_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelar_categoria)
                            .addComponent(guardar_categoria))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregar_categoria)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NuevaFamiliaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(NuevaFamiliaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        NuevaFamiliaPanel.setVisible(false);
        
        /*    //Nueva clase Familia
        Familia cat = new Familia(this.con);
        //Si el JtextField esta NO esta vacio
        if(this.descripcion.getText().replaceAll(" ", "").length() != 0){
            //Si se guarda Existosamente en la DB
            if(cat.insertar_familia(this.descripcion.getText().toString(),this.idFamilia.getText().toString()) ){
                //Mensaje de Exito
                JOptionPane.showMessageDialog(null, "Familia agregada Exitosamente");
                //Buscamos todas las Familias actualizadas
                this.rs  = cat.getAll();
                //Removemos los Items que hay en el JComboBox Familia
                this.Familia.removeAll();
                //A#adimos cada una de las familias actualizadas al Combobox
                try {
                    while(rs.next()){
                        this.Familia.add(rs.getString("descripcion").toString());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Agregar_familia.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    //Llamamos a las funciones de borrar y reanudar
                    this.funciones.call();
                    //Ventana actual
                    this.descripcion.setText("");
                    this.idFamilia.setText("");
                } catch (Exception ex) {
                    Logger.getLogger(Agregar_familia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                //Mesanje de Error al introducir
                JOptionPane.showMessageDialog(null, "No se agrego la familia.","Error al agregar"
                    ,JOptionPane.ERROR_MESSAGE);
            }
        }else{
            //Mensaje de Error si no estan llenos los campos
            JOptionPane.showMessageDialog(null, "Llenar Todos los Campos (*)","Error al agregar"
                ,JOptionPane.ERROR_MESSAGE);
        }*/

    }//GEN-LAST:event_agregarActionPerformed

    private void agregar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_categoriaActionPerformed
    
        NuevaFamiliaPanel.setVisible(true);
        
        /*    //Creamos un nueva Callable (Creamos una variable que guarda funciones)
        Callable<Void> prueba = new Callable<Void>() {
            //Funcion call(), la que se ejecutara desde la variable
            public Void call() {
                reanudar_Categoria();
                borrarS_Categoria();
                return null;
            }
        };
        //Abrimos un nuevo Jframe para agregar categoria
        Agregar_familia pantalla = new Agregar_familia(this.Categorias,this.con,prueba);
        pantalla.setVisible(true); */
    }//GEN-LAST:event_agregar_categoriaActionPerformed

    private void editar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_categoriaActionPerformed
    /*    //Si en el Combobox Categorias hay items, la funcion editar servira
        //Habilita los campos de descripcion y los botones de guardar y cancelar
        if(this.Categorias.getSelectedIndex() != -1){
            this.desc_categoria.enable(true);
            this.guardar_categoria.setVisible(true);
            this.cancelar_categoria.setVisible(true);
            this.editar_categoria.setVisible(false);
            this.desc_categoria.setBackground(Color.white);
        }*/
    }//GEN-LAST:event_editar_categoriaActionPerformed

    private void guardar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_categoriaActionPerformed
     /*   //Clase Categoria
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
        }
        //Se borran los campos descripcion y id de categorias
        this.borrarS_Categoria();
        //Se borran los campos descripcion, id, codigo de Subcategorias
        this.reanudar_Categoria();*/
    }//GEN-LAST:event_guardar_categoriaActionPerformed

    private void cancelar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_categoriaActionPerformed
        //Reanudo los campos de Categoria a deshabilitados
      //  this.reanudar_Categoria();
    }//GEN-LAST:event_cancelar_categoriaActionPerformed

    private void CategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriasActionPerformed
      /*  if(this.Categorias.getItemCount() != 0){//Entra en la condicion si hay mas de un Item en el ComboBox
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
        } */
    }//GEN-LAST:event_CategoriasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.List Categorias;
    private javax.swing.JPanel NuevaFamiliaPanel;
    private javax.swing.JButton agregar;
    private javax.swing.JButton agregar_categoria;
    private javax.swing.JButton cancelar_categoria;
    private javax.swing.JTextField desc_categoria;
    private javax.swing.JTextField descripcion;
    private javax.swing.JButton editar_categoria;
    private javax.swing.JButton guardar_categoria;
    private javax.swing.JTextField idFamilia;
    private javax.swing.JTextField id_categoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}