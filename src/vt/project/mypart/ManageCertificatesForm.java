package vt.project.mypart;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageCertificatesForm extends javax.swing.JFrame {

    static Certificate certificate = new Certificate();
    public ManageCertificatesForm() throws SQLException, IOException {
        initComponents();
        certificate.fillCertificateJTable(jTable_Certificate, "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_title = new javax.swing.JLabel();
        jLabel_certifName = new javax.swing.JLabel();
        jLabel_certifDate = new javax.swing.JLabel();
        jTextField_certifName = new javax.swing.JTextField();
        jButton_Cancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Certificate = new javax.swing.JTable();
        jLabel_Search = new javax.swing.JLabel();
        jTextField_Val_Find = new javax.swing.JTextField();
        jButton_Add = new javax.swing.JButton();
        jDateChooser_certifDate = new com.toedter.calendar.JDateChooser();
        jTextField_companyID = new javax.swing.JTextField();
        jTextField_companyID.setEnabled(false);
        jLabel_companyID = new javax.swing.JLabel();
        jLabel_certifID = new javax.swing.JLabel();
        jTextField_certifID = new javax.swing.JTextField();
        jTextField_certifID.setEnabled(false);
        jButton_Update = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(30, 29, 86));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_title.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel_title.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_title.setText("SERTİFİKA PROGRAMI EKLE");

        jLabel_certifName.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel_certifName.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_certifName.setText("Sertifika Adı:");

        jLabel_certifDate.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel_certifDate.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_certifDate.setText("Tarih:");

        jButton_Cancel.setFont(new java.awt.Font("Arial", 1, 14)); 
        jButton_Cancel.setText("Çıkış");
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });

        jTable_Certificate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sertifika ID", "Sirket ID", "Sertifika Adı", "Tarih"
            }
        ));
        jTable_Certificate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CertificateMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Certificate);

        jLabel_Search.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_Search.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Search.setText("Arama:");

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

        jButton_Add.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton_Add.setText("Ekle");
        jButton_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddActionPerformed(evt);
            }
        });

        jLabel_companyID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_companyID.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_companyID.setText("Sirket ID:");

        jLabel_certifID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_certifID.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_certifID.setText("Sertifika ID:");

        jTextField_certifID.setEditable(false);

        jButton_Update.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton_Update.setText("Güncelle");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel_title))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(jButton_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 142, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_Delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_Update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_Add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel_certifDate)
                                            .addComponent(jLabel_certifName)
                                            .addComponent(jLabel_companyID)
                                            .addComponent(jLabel_certifID))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_certifName, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField_companyID, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField_certifID)
                                            .addComponent(jDateChooser_certifDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_Search)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_Val_Find, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(320, 320, 320)))))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel_title)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_certifID)
                            .addComponent(jTextField_certifID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_companyID)
                            .addComponent(jTextField_companyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_certifName)
                            .addComponent(jTextField_certifName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_certifDate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser_certifDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jButton_Add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Delete)
                        .addGap(20, 20, 20)
                        .addComponent(jButton_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Val_Find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Search))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_CancelActionPerformed

    private void jTable_CertificateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CertificateMouseClicked
        int rowIndex = jTable_Certificate.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)jTable_Certificate.getModel();
        
        jTextField_certifID.setText(model.getValueAt(rowIndex, 0).toString());
        jTextField_companyID.setText(model.getValueAt(rowIndex, 1).toString());
        jTextField_certifName.setText(model.getValueAt(rowIndex, 2).toString());
        String dateString = model.getValueAt(rowIndex, 3).toString(); // Assuming the value is a String
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = dateFormat.parse(dateString);
            jDateChooser_certifDate.setDate(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTable_CertificateMouseClicked

    private void jTextField_Val_FindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Val_FindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Val_FindActionPerformed

    private void jTextField_Val_FindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Val_FindKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Val_FindKeyPressed

    private void jTextField_Val_FindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Val_FindKeyReleased
        jTable_Certificate.setModel(new DefaultTableModel(null, new Object[]{"Sertifika ID", "Sirket ID", "Sertifika Adı", "Tarih"}));
        try {
            certificate.fillCertificateJTable(jTable_Certificate, jTextField_Val_Find.getText());
        } catch (SQLException ex) {
            Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField_Val_FindKeyReleased

    private void jTextField_Val_FindKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Val_FindKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Val_FindKeyTyped

    private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed
        AddCertificateForm ACF = null;
        try {
            ACF = new AddCertificateForm();
        } catch (SQLException ex) {
            Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        ACF.setVisible(true);
        ACF.pack();
        ACF.setLocationRelativeTo(null);
        ACF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton_AddActionPerformed

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformed
        String certificate_id = jTextField_certifID.getText();
        String company_id = jTextField_companyID.getText();
        String certificate_name = jTextField_certifName.getText();
        Object Certifdate = jDateChooser_certifDate.getDate();
        
        if(company_id.equals("") || certificate_name.equals("") || Certifdate == null) {
            JOptionPane.showMessageDialog(null, "Bir sertifika programı seçip tüm alanların dolu olduğuna emin olunuz!");
        }
        else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(jDateChooser_certifDate.getDate());

            try {
                certificate.insertUpdateDeleteCertificate('u', certificate_id, company_id, certificate_name, date);
            } catch (SQLException ex) {
                Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
            }


            jTable_Certificate.setModel(new DefaultTableModel(null, new Object[]{"Sertifika ID", "Şirket ID", "Sertifika Adı", "Tarih"}));

            try {
                certificate.fillCertificateJTable(jTable_Certificate, "");
            } catch (SQLException ex) {
                Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_UpdateActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        if(jTextField_certifID.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Bir Sertifika Programı Seçiniz!");
        }
        else {
            String certifID = jTextField_certifID.getText();
            try {
                certificate.insertUpdateDeleteCertificate('d', certifID, null, null, null);
            } catch (SQLException ex) {
                Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            jTextField_certifID.setText("");
            jTextField_companyID.setText("");
            jTextField_certifName.setText("");
            jDateChooser_certifDate.setDate(null);
        }
        jTable_Certificate.setModel(new DefaultTableModel(null, new Object[]{"Sertifika ID", "Sirket ID", "Sertifika Adı", "Tarih"}));

        try {
            certificate.fillCertificateJTable(jTable_Certificate, "");
        } catch (SQLException ex) {
            Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton_DeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageCertificatesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCertificatesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCertificatesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCertificatesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManageCertificatesForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add;
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Update;
    private com.toedter.calendar.JDateChooser jDateChooser_certifDate;
    private javax.swing.JLabel jLabel_Search;
    private javax.swing.JLabel jLabel_certifDate;
    private javax.swing.JLabel jLabel_certifID;
    private javax.swing.JLabel jLabel_certifName;
    private javax.swing.JLabel jLabel_companyID;
    private javax.swing.JLabel jLabel_title;
    private static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_Certificate;
    public static javax.swing.JTextField jTextField_Val_Find;
    private javax.swing.JTextField jTextField_certifID;
    private javax.swing.JTextField jTextField_certifName;
    private javax.swing.JTextField jTextField_companyID;
    // End of variables declaration//GEN-END:variables
}
