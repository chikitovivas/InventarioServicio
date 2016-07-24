/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventarioh.MenuBar.Bienes;

import DB.Bien;
import DB.Familia;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import interfazNueva.menubar;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Usuario
 */
public class Agregar_activo extends javax.swing.JFrame {
    //Nueva statement
    Statement stmt = null;
    //Nuevo ResultSet
    ResultSet rs = null;
    //Variable conexion a la DB
    Connection con = null;
    
    Thread hilo = null;
    /**
     * Creates new form Agregar_activo
     */
    
    public Agregar_activo(Connection con) throws SQLException {
        initComponents();
        //Conexion a la DB
        this.con = con;
        /*MEnu*/
        menubar Menu = new menubar(this);
        setJMenuBar(Menu);
        /* Titulo del Jframe */
        this.setTitle("Agregar nuevo Activo o Inmueble");
        //Combobox Categoria
        //Creamos un nuevo statement
        stmt = con.createStatement(); 
        rellenar_CmBoxes();
        //Al presionar enter, el actionperformed del verificar se activara
        this.getRootPane().setDefaultButton(GuardarBtn);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        GuardarBtn = new javax.swing.JButton();
        BienPanel = new javax.swing.JPanel();
        CodigoTxt = new javax.swing.JTextField();
        CodigoLbl = new javax.swing.JLabel();
        NombreLbl = new javax.swing.JLabel();
        NombreTxt = new javax.swing.JTextField();
        Categoria = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        Proveedor = new javax.swing.JComboBox();
        ProveedorLbl = new javax.swing.JLabel();
        Ubicacion = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        PrecioRefLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PrecioRefText = new javax.swing.JTextField();
        Costo_actual = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Descripcion = new javax.swing.JTextArea();
        FechaAdquiLbl = new javax.swing.JLabel();
        FechaAdqiDChoser = new com.toedter.calendar.JDateChooser();
        EstadosPanel = new javax.swing.JPanel();
        StatusUbiLbl = new javax.swing.JLabel();
        StatusFisicoLbl = new javax.swing.JLabel();
        StatusUbiCmbox = new javax.swing.JComboBox();
        StatusFisicoCmbox = new javax.swing.JComboBox();
        UsuariosPanel = new javax.swing.JPanel();
        ResponsableCmbox = new javax.swing.JComboBox();
        ResponsableLbl = new javax.swing.JLabel();
        Propietario = new javax.swing.JLabel();
        PropietarioCmbox = new javax.swing.JComboBox();
        SalirBtn = new javax.swing.JButton();
        EditarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GuardarBtn.setText("Guardar");
        GuardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarBtnActionPerformed(evt);
            }
        });

        BienPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Bien"));

        CodigoTxt.setText("123");
        CodigoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigoTxtActionPerformed(evt);
            }
        });

        CodigoLbl.setText("(*)Codigo: ");

        NombreLbl.setText("(*)Nombre: ");

        NombreTxt.setText("Yanir");
        NombreTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreTxtActionPerformed(evt);
            }
        });

        Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriaActionPerformed(evt);
            }
        });

        jLabel3.setText("(*)Categoria:");

        Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProveedorActionPerformed(evt);
            }
        });

        ProveedorLbl.setText("(*)Proveedor:");

        Ubicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbicacionActionPerformed(evt);
            }
        });

        jLabel6.setText("(*)Ubicacion:");

        javax.swing.GroupLayout BienPanelLayout = new javax.swing.GroupLayout(BienPanel);
        BienPanel.setLayout(BienPanelLayout);
        BienPanelLayout.setHorizontalGroup(
            BienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BienPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(BienPanelLayout.createSequentialGroup()
                        .addComponent(ProveedorLbl)
                        .addGap(37, 37, 37)
                        .addComponent(Proveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BienPanelLayout.createSequentialGroup()
                        .addComponent(NombreLbl)
                        .addGap(47, 47, 47)
                        .addComponent(NombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BienPanelLayout.createSequentialGroup()
                        .addComponent(CodigoLbl)
                        .addGap(51, 51, 51)
                        .addComponent(CodigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69)
                .addGroup(BienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addGap(67, 67, 67)
                .addGroup(BienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        BienPanelLayout.setVerticalGroup(
            BienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BienPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BienPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(BienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CodigoLbl)
                            .addComponent(CodigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(5, 5, 5)
                .addGroup(BienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BienPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(BienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(Ubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BienPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(BienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NombreLbl)
                            .addComponent(NombreTxt))))
                .addGap(23, 23, 23)
                .addGroup(BienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProveedorLbl)
                    .addComponent(Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));

        PrecioRefLbl.setText("Precio referencuial:");

        jLabel8.setText("Costo actual:");

        PrecioRefText.setText("12345");
        PrecioRefText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecioRefTextActionPerformed(evt);
            }
        });

        Costo_actual.setText("1234");
        Costo_actual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Costo_actualActionPerformed(evt);
            }
        });

        jLabel9.setText("Bs.");

        jLabel10.setText("Bs.");

        jLabel11.setText("Descripcion:");

        Descripcion.setColumns(20);
        Descripcion.setRows(5);
        jScrollPane1.setViewportView(Descripcion);

        FechaAdquiLbl.setText("(*)Fecha de adquisicion:");

        EstadosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Estados"));

        StatusUbiLbl.setText("Ubicación:");

        StatusFisicoLbl.setText("Físico:");

        javax.swing.GroupLayout EstadosPanelLayout = new javax.swing.GroupLayout(EstadosPanel);
        EstadosPanel.setLayout(EstadosPanelLayout);
        EstadosPanelLayout.setHorizontalGroup(
            EstadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EstadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StatusFisicoLbl)
                    .addComponent(StatusUbiLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(EstadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StatusUbiCmbox, 0, 128, Short.MAX_VALUE)
                    .addComponent(StatusFisicoCmbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        EstadosPanelLayout.setVerticalGroup(
            EstadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadosPanelLayout.createSequentialGroup()
                .addGroup(EstadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatusUbiCmbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StatusUbiLbl))
                .addGap(18, 18, 18)
                .addGroup(EstadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatusFisicoLbl)
                    .addComponent(StatusFisicoCmbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        UsuariosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios"));

        ResponsableCmbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResponsableCmboxActionPerformed(evt);
            }
        });

        ResponsableLbl.setText("Responsable:");

        Propietario.setText("Propietario:");

        javax.swing.GroupLayout UsuariosPanelLayout = new javax.swing.GroupLayout(UsuariosPanel);
        UsuariosPanel.setLayout(UsuariosPanelLayout);
        UsuariosPanelLayout.setHorizontalGroup(
            UsuariosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsuariosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UsuariosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ResponsableLbl)
                    .addComponent(Propietario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(UsuariosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ResponsableCmbox, 0, 128, Short.MAX_VALUE)
                    .addComponent(PropietarioCmbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        UsuariosPanelLayout.setVerticalGroup(
            UsuariosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsuariosPanelLayout.createSequentialGroup()
                .addGroup(UsuariosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResponsableLbl)
                    .addComponent(ResponsableCmbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(UsuariosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Propietario)
                    .addComponent(PropietarioCmbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(FechaAdquiLbl)
                                .addGap(18, 18, 18)
                                .addComponent(FechaAdqiDChoser, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PrecioRefLbl)
                                    .addComponent(jLabel8))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Costo_actual, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PrecioRefText, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)))))
                    .addComponent(UsuariosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EstadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PrecioRefLbl)
                            .addComponent(PrecioRefText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Costo_actual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(FechaAdquiLbl)
                            .addComponent(FechaAdqiDChoser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(UsuariosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EstadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane1))
                .addGap(10, 10, 10))
        );

        SalirBtn.setText("Salir");
        SalirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirBtnActionPerformed(evt);
            }
        });

        EditarBtn.setText("Editar");
        EditarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(517, 517, 517)
                .addComponent(EditarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GuardarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SalirBtn)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BienPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(BienPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuardarBtn)
                    .addComponent(SalirBtn)
                    .addComponent(EditarBtn))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(752, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CodigoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodigoTxtActionPerformed

    private void NombreTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreTxtActionPerformed

    private void CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriaActionPerformed
        
  
    }//GEN-LAST:event_CategoriaActionPerformed

    private void ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProveedorActionPerformed

    private void UbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UbicacionActionPerformed

    private void PrecioRefTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecioRefTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecioRefTextActionPerformed

    private void Costo_actualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Costo_actualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Costo_actualActionPerformed

    private void GuardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarBtnActionPerformed
        
        //Si los campos codigo, nombre, categoria y subcategoria estan vacios, no entra
        if((CodigoTxt.getText().replaceAll(" ", "").length() != 0) && (NombreTxt.getText().replaceAll(" ", "").length() != 0) &&
                (Categoria.getSelectedItem().toString().replaceAll(" ", "").length() != 0) && FechaAdqiDChoser.getDate() != null){
            
            SimpleDateFormat formato = new SimpleDateFormat("YYYY/MM/dd");
            Bien nuevo = new Bien(CodigoTxt.getText(), 
            NombreTxt.getText(), 
            (String) Proveedor.getSelectedItem(),
            (String) Categoria.getSelectedItem(), 
            (String) Ubicacion.getSelectedItem(),
            PrecioRefText.getText(), 
            Costo_actual.getText(),
            formato.format(FechaAdqiDChoser.getDate()),
            (String) ResponsableCmbox.getSelectedItem(), 
            (String) PropietarioCmbox.getSelectedItem(), 
            (String) StatusUbiCmbox.getSelectedItem(),
            (String) StatusFisicoCmbox.getSelectedItem(), Descripcion.getText());
            
            if(nuevo.insertar_activo()){
                JOptionPane.showMessageDialog(null, "Activo agregado exitosamente.","Registro exitoso"
                        ,JOptionPane.INFORMATION_MESSAGE);
            }else{
                
                JOptionPane.showMessageDialog(null, "No se pudo registrar el Activo", "Error al registrar"
                        ,JOptionPane.ERROR_MESSAGE);
                               
            }    
        }else{
                JOptionPane.showMessageDialog(null, "Los campos (*) deben estar rellenados.","Warning"
                        ,JOptionPane.WARNING_MESSAGE);

        }
       
    }//GEN-LAST:event_GuardarBtnActionPerformed

    private void ResponsableCmboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResponsableCmboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResponsableCmboxActionPerformed

    private void SalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirBtnActionPerformed
        dispose();
    }//GEN-LAST:event_SalirBtnActionPerformed

    private void EditarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditarBtnActionPerformed

    private void rellenar_CmBoxes(){
        try {
            //Ejecutamos el query de busqueda de categorias
            if (stmt.execute("SELECT descripcion FROM familia ")) {
                rs = stmt.getResultSet();
                // Añadimos cada una de las categorias al combobox Categoria
                while(rs.next()){
                    Categoria.addItem(rs.getString("descripcion"));
                }
            }
            
            //ComboBox Proveedor
            //Ejecutamos el query de busqueda de Proveedor o donante
            if (stmt.execute("SELECT razon_social FROM Proveedor_Donante ")) {
                rs = stmt.getResultSet();
                // Añadimos cada una de los proveedores o donantes al combobox Proveedor
                while(rs.next()){
                    Proveedor.addItem(rs.getString("razon_social"));
                }
            }
            
            
            // ComoBox Ubicacion
            if (stmt.execute("SELECT descripcion FROM Ubicacion ")) {
                rs = stmt.getResultSet();
                // Añadimos cada una de las abucaciones al combobox Ubicacion
                while(rs.next()){
                    Ubicacion.addItem(rs.getString("descripcion"));
                }
            }
            
            
            // ComoBox Responsables de uso
            if (stmt.execute("SELECT Nombre, Apellido FROM inventario.usuario;")) {
                rs = stmt.getResultSet();
                // Añadimos cada uno de los usuarios existentes en el sistema al ComboBox
                while(rs.next()){
                    ResponsableCmbox.addItem(rs.getString("Nombre") + " " + rs.getString("Apellido"));
                }
            }
            
            
            // ComoBox Propietario
            if (stmt.execute("SELECT Razon_social FROM inventario.propietario;")) {
                rs = stmt.getResultSet();
                // Añadimos cada uno de los propietarios al ComboBox
                while(rs.next()){
                    PropietarioCmbox.addItem(rs.getString("Razon_social"));
                }
            }
            
            
             // ComoBox Status de ubicacion
            if (stmt.execute("SELECT Descripcion FROM inventario.estatus_cond_ubicacion;")) {
                rs = stmt.getResultSet();
                // Añadimos cada uno de los estados por ubicación al ComboBox
                while(rs.next()){
                    StatusUbiCmbox.addItem(rs.getString("Descripcion"));
                }
            }
            
            
            // ComoBox Status físico
            if (stmt.execute("SELECT Descripcion FROM inventario.estatus_cond_fisica;")) {
                rs = stmt.getResultSet();
                // Añadimos cada uno de los estados de condición fisica al ComboBox
                while(rs.next()){
                    StatusFisicoCmbox.addItem(rs.getString("Descripcion"));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Agregar_activo.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(Agregar_activo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar_activo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar_activo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar_activo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
              /*  try {
                    new Agregar_activo().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Agregar_activo.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BienPanel;
    private javax.swing.JComboBox Categoria;
    private javax.swing.JLabel CodigoLbl;
    private javax.swing.JTextField CodigoTxt;
    private javax.swing.JTextField Costo_actual;
    private javax.swing.JTextArea Descripcion;
    private javax.swing.JButton EditarBtn;
    private javax.swing.JPanel EstadosPanel;
    private com.toedter.calendar.JDateChooser FechaAdqiDChoser;
    private javax.swing.JLabel FechaAdquiLbl;
    private javax.swing.JButton GuardarBtn;
    private javax.swing.JLabel NombreLbl;
    private javax.swing.JTextField NombreTxt;
    private javax.swing.JLabel PrecioRefLbl;
    private javax.swing.JTextField PrecioRefText;
    private javax.swing.JLabel Propietario;
    private javax.swing.JComboBox PropietarioCmbox;
    private javax.swing.JComboBox Proveedor;
    private javax.swing.JLabel ProveedorLbl;
    private javax.swing.JComboBox ResponsableCmbox;
    private javax.swing.JLabel ResponsableLbl;
    private javax.swing.JButton SalirBtn;
    private javax.swing.JComboBox StatusFisicoCmbox;
    private javax.swing.JLabel StatusFisicoLbl;
    private javax.swing.JComboBox StatusUbiCmbox;
    private javax.swing.JLabel StatusUbiLbl;
    private javax.swing.JComboBox Ubicacion;
    private javax.swing.JPanel UsuariosPanel;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
