package vt.project.mypart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class AddCompanyForm extends javax.swing.JFrame {

    public AddCompanyForm() {
    	setResizable(false);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(AddCompanyForm.class.getResource("/images/yildiz.png")));
        initComponents();
    }

    @SuppressWarnings("unchecked")

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
        jButton_Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(30, 29, 86));

        jLabel_title.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_title.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_title.setText("YENİ ŞİRKET EKLEME");

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

        jButton_Cancel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton_Cancel.setText("İptal");
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel_title))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_companyLoc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_companyLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_companyName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_companyName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_companyID)
                                .addGap(36, 36, 36)
                                .addComponent(jTextField_companyID, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_companyContact)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton_Cancel)
                                        .addGap(35, 35, 35)
                                        .addComponent(jButton_Add))
                                    .addComponent(jTextField_companyContact, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel_title)
                .addGap(24, 24, 24)
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
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Add)
                    .addComponent(jButton_Cancel))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void jTextField_companyIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_companyIDActionPerformed

    }

    private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed
        String company_id = jTextField_companyID.getText();
        String company_name = jTextField_companyName.getText();
        String konum = jTextField_companyLoc.getText();
        String iletisim = jTextField_companyContact.getText();
        
        if (company_id.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Sirket ID alanı boş bırakılamaz!");
        }
        else {
            Company cmpny = new Company();
            try {
                cmpny.insertUpdateDeleteCompany('i', company_id, company_name, konum, iletisim);
            } catch (SQLException ex) {
                Logger.getLogger(AddCompanyForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AddCompanyForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            ManageCompaniesForm.jTable_Company.setModel(new DefaultTableModel(null, new Object[]{"Şirket ID", "Şirket Adı", "Konum", "İletişim"}));
            try {
                cmpny.fillCompanyJTable(ManageCompaniesForm.jTable_Company, "");
            } catch (SQLException ex) {
                Logger.getLogger(AddCompanyForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AddCompanyForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
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
            java.util.logging.Logger.getLogger(AddCompanyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCompanyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCompanyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCompanyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCompanyForm().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton_Add;
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JLabel jLabel_companyContact;
    private javax.swing.JLabel jLabel_companyID;
    private javax.swing.JLabel jLabel_companyLoc;
    private javax.swing.JLabel jLabel_companyName;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_companyContact;
    private javax.swing.JTextField jTextField_companyID;
    private javax.swing.JTextField jTextField_companyLoc;
    private javax.swing.JTextField jTextField_companyName;

}
