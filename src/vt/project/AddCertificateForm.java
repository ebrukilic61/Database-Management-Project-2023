package vt.project;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class AddCertificateForm extends javax.swing.JFrame {

    Certificate certificate = new Certificate();
    public AddCertificateForm() throws SQLException, IOException {
    	setTitle("Sertifika Ekle");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(AddCertificateForm.class.getResource("/images/yildiz.png")));
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
        jLabel_companyID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(30, 29, 86));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_title.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_title.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_title.setText("SERTİFİKA PROGRAMI EKLE");

        jLabel_certifName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_certifName.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_certifName.setText("Sertifika Adı:");

        jLabel_certifDate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_certifDate.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_certifDate.setText("Tarih:");

        jButton_Cancel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
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
                "Sertifika ID", "Şirket ID", "Sertifika Adı", "Tarih"
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
        jLabel_companyID.setText("Şirket ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_Search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_Val_Find, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_Add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_certifDate)
                                    .addComponent(jLabel_certifName)
                                    .addComponent(jLabel_companyID))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_companyID)
                                    .addComponent(jTextField_certifName, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(jDateChooser_certifDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jButton_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(jLabel_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel_title)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Val_Find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Search))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_companyID)
                            .addComponent(jTextField_companyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_certifName)
                            .addComponent(jTextField_certifName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_certifDate)
                            .addComponent(jDateChooser_certifDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(jButton_Add)
                        .addGap(30, 30, 30)
                        .addComponent(jButton_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_CancelActionPerformed

    private void jTable_CertificateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CertificateMouseClicked

    }//GEN-LAST:event_jTable_CertificateMouseClicked

    private void jTextField_Val_FindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Val_FindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Val_FindActionPerformed

    private void jTextField_Val_FindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Val_FindKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Val_FindKeyPressed

    private void jTextField_Val_FindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Val_FindKeyReleased

    }//GEN-LAST:event_jTextField_Val_FindKeyReleased

    private void jTextField_Val_FindKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Val_FindKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Val_FindKeyTyped

    private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed
        String company_id = jTextField_companyID.getText();
        String certificate_name = jTextField_certifName.getText();
        Object Certifdate = jDateChooser_certifDate.getDate();
        
        if(company_id.equals("") || certificate_name.equals("") || Certifdate == null) {
            JOptionPane.showMessageDialog(null, "Tüm alanları doldurunuz!");
        }
        else {
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(jDateChooser_certifDate.getDate());
            //System.out.println(date);
            
            Certificate certificate = new Certificate();

            try {
                certificate.insertUpdateDeleteCertificate('i', null, company_id, certificate_name, date);
            } catch (SQLException ex) {
                Logger.getLogger(AddCertificateForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AddCertificateForm.class.getName()).log(Level.SEVERE, null, ex);
            }


            jTable_Certificate.setModel(new DefaultTableModel(null, new Object[]{"Sertifika ID", "Şirket ID", "Sertifika Adı", "Tarih"}));

            try {
                certificate.fillCertificateJTable(jTable_Certificate, "");
            } catch (SQLException ex) {
                Logger.getLogger(AddCertificateForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AddCertificateForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ManageCertificatesForm.jTable_Certificate.setModel(new DefaultTableModel(null, new Object[]{"Sertifika ID", "Şirket ID", "Sertifika Adı", "Tarih"}));
            try {
                ManageCertificatesForm.certificate.fillCertificateJTable(ManageCertificatesForm.jTable_Certificate, ManageCertificatesForm.jTextField_Val_Find.getText());
            } catch (SQLException ex) {
                Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManageCertificatesForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddCertificateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCertificateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCertificateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCertificateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddCertificateForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AddCertificateForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AddCertificateForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private javax.swing.JButton jButton_Add;
    private javax.swing.JButton jButton_Cancel;
    private com.toedter.calendar.JDateChooser jDateChooser_certifDate;
    private javax.swing.JLabel jLabel_Search;
    private javax.swing.JLabel jLabel_certifDate;
    private javax.swing.JLabel jLabel_certifName;
    private javax.swing.JLabel jLabel_companyID;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_Certificate;
    private javax.swing.JTextField jTextField_Val_Find;
    private javax.swing.JTextField jTextField_certifName;
    private javax.swing.JTextField jTextField_companyID;
}
