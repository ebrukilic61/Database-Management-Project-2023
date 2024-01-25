package vt.project.mypart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageCompaniesForm extends javax.swing.JFrame {

    Company cmpny = new Company();
    public ManageCompaniesForm() throws SQLException, IOException {
        initComponents();
        cmpny.fillCompanyJTable(jTable_Company, "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_title = new javax.swing.JLabel();
        jLabel_companyName = new javax.swing.JLabel();
        jLabel_companyID = new javax.swing.JLabel();
        jLabel_companyLoc = new javax.swing.JLabel();
        jLabel_companyContact = new javax.swing.JLabel();
        jTextField_companyID = new javax.swing.JTextField();
        jTextField_companyName = new javax.swing.JTextField();
        jTextField_companyLoc = new javax.swing.JTextField();
        jTextField_companyContact = new javax.swing.JTextField();
        jButton_Add = new javax.swing.JButton();
        jButton_Update = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Company = new javax.swing.JTable();
        jTextField_Val_Find = new javax.swing.JTextField();
        jLabel_Search = new javax.swing.JLabel();
        jButton_Exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(30, 29, 86));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_title.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_title.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_title.setText("ŞİRKET İŞLEMLERİ");

        jLabel_companyName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_companyName.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_companyName.setText("Şirket Adı:");

        jLabel_companyID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_companyID.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_companyID.setText("Şirket ID:");

        jLabel_companyLoc.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_companyLoc.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_companyLoc.setText("Konum:");

        jLabel_companyContact.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_companyContact.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_companyContact.setText("İletişim:");

        jTextField_companyID.setEditable(false);
        jTextField_companyID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_companyIDActionPerformed(evt);
            }
        });

        jButton_Add.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton_Add.setText("Ekle");
        jButton_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddActionPerformed(evt);
            }
        });

        jButton_Update.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton_Update.setText("Guncelle");
        jButton_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateActionPerformed(evt);
            }
        });

        jButton_Delete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton_Delete.setText("Sil");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });

        jTable_Company.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sirket ID", "Sirket Adı", "Konum", "İletişim"
            }
        ));
        jTable_Company.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CompanyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Company);

        jTextField_Val_Find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Val_FindActionPerformed(evt);
            }
        });
        jTextField_Val_Find.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_Val_FindKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Val_FindKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Val_FindKeyTyped(evt);
            }
        });

        jLabel_Search.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_Search.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Search.setText("Arama:");

        jButton_Exit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton_Exit.setText("Çıkış");
        jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_companyContact)
                            .addComponent(jLabel_companyLoc)
                            .addComponent(jLabel_companyName)
                            .addComponent(jLabel_companyID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_companyID)
                            .addComponent(jTextField_companyName)
                            .addComponent(jTextField_companyLoc)
                            .addComponent(jTextField_companyContact)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_Update, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jButton_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel_Search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_Val_Find, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(392, 392, 392)
                .addComponent(jLabel_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Val_Find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Search))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_companyID)
                            .addComponent(jTextField_companyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_companyName)
                            .addComponent(jTextField_companyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_companyLoc)
                            .addComponent(jTextField_companyLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_companyContact)
                            .addComponent(jTextField_companyContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Add)
                            .addComponent(jButton_Update)
                            .addComponent(jButton_Delete))
                        .addGap(35, 35, 35)
                        .addComponent(jButton_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_companyIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_companyIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_companyIDActionPerformed

    private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed
        AddCompanyForm AddCF = new AddCompanyForm();
        AddCF.setVisible(true);
        AddCF.pack();
        AddCF.setLocationRelativeTo(null);
        AddCF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton_AddActionPerformed

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformed
        String company_id = jTextField_companyID.getText();
        String company_name = jTextField_companyName.getText();
        String konum = jTextField_companyLoc.getText();
        String iletisim = jTextField_companyContact.getText();
        
        try {
            cmpny.insertUpdateDeleteCompany('u', company_id, company_name, konum, iletisim);
        } catch (SQLException ex) {
            Logger.getLogger(ManageCompaniesForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageCompaniesForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTable_Company.setModel(new DefaultTableModel(null, new Object[]{"Sirket ID", "Sirket AdÄ±", "Konum", "İletişim"}));
        try {
            cmpny.fillCompanyJTable(jTable_Company, "");
        } catch (SQLException ex) {
            Logger.getLogger(ManageCompaniesForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageCompaniesForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_UpdateActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        if(jTextField_companyID.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Bir Sirket Seçiniz!");
        }
        else {
            String company_id = jTextField_companyID.getText();
            try {
                cmpny.insertUpdateDeleteCompany('d', company_id, null, null, null);
            } catch (SQLException ex) {
                Logger.getLogger(ManageCompaniesForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManageCompaniesForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            jTextField_companyID.setText("");
            jTextField_companyName.setText("");
            jTextField_companyLoc.setText("");
            jTextField_companyContact.setText("");
        }
        jTable_Company.setModel(new DefaultTableModel(null, new Object[]{"Sirket ID", "Sirket Adı", "Konum", "İletişim"}));
        try {
            cmpny.fillCompanyJTable(jTable_Company, "");
        } catch (SQLException ex) {
            Logger.getLogger(ManageCompaniesForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageCompaniesForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jTable_CompanyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CompanyMouseClicked
        int rowIndex = jTable_Company.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)jTable_Company.getModel();
        
        jTextField_companyID.setText(model.getValueAt(rowIndex, 0).toString());
        jTextField_companyName.setText(model.getValueAt(rowIndex, 1).toString());
        jTextField_companyLoc.setText(model.getValueAt(rowIndex, 2).toString());
        jTextField_companyContact.setText(model.getValueAt(rowIndex, 3).toString());
    }//GEN-LAST:event_jTable_CompanyMouseClicked

    private void jTextField_Val_FindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Val_FindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Val_FindActionPerformed

    private void jTextField_Val_FindKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Val_FindKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Val_FindKeyTyped

    private void jTextField_Val_FindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Val_FindKeyPressed
        ManageCertificatesForm MCF = null;
        try {
            MCF = new ManageCertificatesForm();
        } catch (SQLException ex) {
            Logger.getLogger(ManageCompaniesForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageCompaniesForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        MCF.setVisible(true);
        MCF.pack();
        MCF.setLocationRelativeTo(null);
        MCF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jTextField_Val_FindKeyPressed

    private void jTextField_Val_FindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Val_FindKeyReleased
        jTable_Company.setModel(new DefaultTableModel(null, new Object[]{"Şirket ID", "Sirket Adı", "Konum", "İletisim"}));
        try {
            cmpny.fillCompanyJTable(jTable_Company, jTextField_Val_Find.getText());
        } catch (SQLException ex) {
            Logger.getLogger(ManageCompaniesForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageCompaniesForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField_Val_FindKeyReleased

    private void jButton_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_ExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManageCompaniesForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ManageCompaniesForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ManageCompaniesForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Exit;
    private javax.swing.JButton jButton_Update;
    private javax.swing.JLabel jLabel_Search;
    private javax.swing.JLabel jLabel_companyContact;
    private javax.swing.JLabel jLabel_companyID;
    private javax.swing.JLabel jLabel_companyLoc;
    private javax.swing.JLabel jLabel_companyName;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_Company;
    private javax.swing.JTextField jTextField_Val_Find;
    private javax.swing.JTextField jTextField_companyContact;
    public static javax.swing.JTextField jTextField_companyID;
    private javax.swing.JTextField jTextField_companyLoc;
    private javax.swing.JTextField jTextField_companyName;
    // End of variables declaration//GEN-END:variables
}
