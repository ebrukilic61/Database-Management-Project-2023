package vt.project.mypart;

import javax.swing.JFrame;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfiliDuzenle extends JFrame {
	JTextField userIDField; //Menuden erişebilmek için private değil public yaptım
    JTextField newOkulField;
    JTextField newDeptField;
    JTextField newDeneyimField;
    JTextField newEmailField;
    private JButton updateButton;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton addCertifButton;
    private JToggleButton profilKapatBtn;

    public ProfiliDuzenle() {
    	setResizable(false);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(ProfiliDuzenle.class.getResource("/images/yildiz.png")));
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Profil Bilgilerini G\u00FCncelleme Ekran\u0131");
        setBounds(650, 100, 628, 704);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 29, 86));
        panel.setLayout(null);

        JLabel userIDLabel = new JLabel("User ID:");
        userIDLabel.setFont(new Font("Arial Black", Font.BOLD, 13));
        userIDLabel.setForeground(new Color(255, 255, 255));
        userIDLabel.setBounds(59, 134, 133, 72);
        userIDLabel.setBackground(new Color(0, 0, 68));
        panel.add(userIDLabel);

        JLabel okulLabel = new JLabel("Okul:");
        okulLabel.setForeground(new Color(255, 255, 255));
        okulLabel.setFont(new Font("Arial Black", Font.BOLD, 13));
        okulLabel.setBounds(59, 210, 133, 78);
        panel.add(okulLabel);

        JLabel deptLabel = new JLabel("Department: ");
        deptLabel.setFont(new Font("Arial Black", Font.BOLD, 13));
        deptLabel.setForeground(new Color(255, 255, 255));
        deptLabel.setBounds(59, 286, 133, 72);
        panel.add(deptLabel);

        JLabel deneyimLabel = new JLabel("Deneyim: ");
        deneyimLabel.setForeground(new Color(255, 255, 255));
        deneyimLabel.setFont(new Font("Arial Black", Font.BOLD, 13));
        deneyimLabel.setBounds(59, 362, 133, 72);
        panel.add(deneyimLabel);

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Arial Black", Font.BOLD, 13));
        emailLabel.setForeground(new Color(255, 255, 255));
        emailLabel.setBounds(59, 438, 133, 72);
        panel.add(emailLabel);
        
        JLabel profilBaslikLabel = new JLabel(" PROF\u0130L\u0130 D\u00DCZENLE");
        profilBaslikLabel.setIcon(null);
        profilBaslikLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
        profilBaslikLabel.setForeground(new Color(255, 255, 255));
        profilBaslikLabel.setBounds(215, 85, 187, 39);
        panel.add(profilBaslikLabel);
        
        userIDField = new JTextField();
        userIDField.setBounds(312, 148, 240, 46);
        panel.add(userIDField);
        userIDField.setColumns(50);
        
        newOkulField = new JTextField();
        newOkulField.setBounds(312, 224, 240, 46);
        panel.add(newOkulField);
        newOkulField.setColumns(50);
        
        newDeptField = new JTextField();
        newDeptField.setBounds(312, 300, 240, 46);
        panel.add(newDeptField);
        newDeptField.setColumns(50);
        
        newDeneyimField = new JTextField();
        newDeneyimField.setBounds(312, 376, 240, 46);
        panel.add(newDeneyimField);
        newDeneyimField.setColumns(50);
        
        newEmailField = new JTextField();
        newEmailField.setBounds(312, 452, 240, 46);
        panel.add(newEmailField);
        newEmailField.setColumns(50);

        updateButton = new JButton("Profil Bilgisini Güncelle");
        updateButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
        updateButton.setBounds(229, 585, 187, 46);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                	updateProfile();
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    showErrorMessage("Hata oluştu: " + ex.getMessage());
                }
            }
        });
        panel.add(updateButton);

        insertButton = new JButton("Profil Bilgisi Ekle");
        insertButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
        insertButton.setBounds(59, 585, 150, 46);
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    insertProfil();
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    showErrorMessage("Hata oluştu: " + ex.getMessage());
                }
            }
        });
        panel.add(insertButton);
        
        deleteButton = new JButton("Profili Sil");
        deleteButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
        deleteButton.setBounds(434, 585, 118, 46);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteProfil();
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    showErrorMessage("Hata oluştu: " + ex.getMessage());
                }
            }
        });
        panel.add(deleteButton);
               
        getContentPane().add(panel);
        
        JRadioButton profilBilgiButton = new JRadioButton("profil bilgilerini göster");
        profilBilgiButton.setBackground(UIManager.getColor("Slider.shadow"));
        profilBilgiButton.setBounds(312, 525, 150, 22);
        panel.add(profilBilgiButton);
        profilBilgiButton.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) 
        	{
        		try {
        			showProfil();
        		}catch(NumberFormatException ex) 
        		{
        			ex.printStackTrace();
        			showErrorMessage("Hata oluştu: "+ex.getMessage());
        		}
        	}
        });
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(ProfiliDuzenle.class.getResource("/images/icons8-test-account-40.png")));
        lblNewLabel.setBounds(274, 26, 51, 55);
        panel.add(lblNewLabel);
        
        JToggleButton profilKapatBtn = new JToggleButton("");
        profilKapatBtn.setIcon(new ImageIcon(ProfiliDuzenle.class.getResource("/images/lightyellowclosebtn.png")));
        profilKapatBtn.setBounds(573, 10, 31, 31);
        panel.add(profilKapatBtn);
        ProfiliDuzenle current = this;
        profilKapatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ProfilDeneme profileWindow = new ProfilDeneme();
                profileWindow.getFrame().setVisible(true);
                // Hide the current instance of ProfiliDuzenle
                current.setVisible(false);
            }
        });  
    }
    
    private void updateProfile() {
        int userId = Integer.parseInt(userIDField.getText());
        String newOkul = newOkulField.getText();
        String newDepartment = newDeptField.getText();
        String newDeneyim = newDeneyimField.getText();
        String newEmail = newEmailField.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345")) {
            String query = "SELECT * FROM profil_guncelle2(?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setInt(1, userId);
                statement.setString(2, newOkul);
                statement.setString(3, newDepartment);
                statement.setString(4, newDeneyim);
                statement.setString(5, newEmail);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String updatedOkul = resultSet.getString("new_okul");
                    String updatedDept = resultSet.getString("new_dept");
                    String updatedDeneyim = resultSet.getString("new_deneyim");
                    String updatedEmail = resultSet.getString("new_email");

                    // Güncellenmiş profil bilgilerini kullan
                    System.out.println("Güncellenmiş Okul: " + updatedOkul);
                    System.out.println("Güncellenmiş Departman: " + updatedDept);
                    System.out.println("Güncellenmiş Deneyim: " + updatedDeneyim);
                    System.out.println("Güncellenmiş Email: " + updatedEmail);
                }

                JOptionPane.showMessageDialog(this, "Profil bilgisi güncellendi.");
                System.out.println("Profil bilgisi güncellendi.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "HATA! Profil bilgisi güncellenemedi!");
            System.out.println("Hata oluştu: " + ex.getMessage());
        }
    }
    
    private void showProfil() //kayıtlı olan tüm bilgileri görebilmek adına bunu ekledim, bu sayede sadece istenilen bilgiler değiştirilip güncellenebiliyor
    {
    	int userId = Session.getLoggedInUser().getUserId();
    	
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345")) {
            String query = "SELECT * FROM profil where usr_id = ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setInt(1, userId);
                ResultSet rs = statement.executeQuery();
                
                if (rs.next()) {
                    //Profil bilgilerini ilgili JTextField'lara set et:
                	userIDField.setText(rs.getString("usr_id"));
                    newOkulField.setText(rs.getString("okul"));
                    newDeptField.setText(rs.getString("department"));
                    newDeneyimField.setText(rs.getString("deneyim"));
                    newEmailField.setText(rs.getString("email"));
                } else {
                    JOptionPane.showMessageDialog(this, "Kullanıcı bulunamadı.");
                    return;
                }
                statement.close();
                rs.close();
                }catch(SQLException ex) 
                {
                	ex.printStackTrace();           
                    System.out.println("Hata oluştu: " + ex.getMessage());
                }
            } catch (SQLException e) {
				e.printStackTrace();
			}
    }
    
    private void insertProfil() {
    	int userId = Session.getLoggedInUser().getUserId();
        String newOkul = newOkulField.getText();
        String newDepartment = newDeptField.getText();
        String newDeneyim = newDeneyimField.getText();
        String newEmail = newEmailField.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345")) {
            String query = "INSERT INTO profil (usr_id, okul, department, deneyim, email) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
            	statement.setInt(1, userId);
            	statement.setString(2, newOkul);
                statement.setString(3, newDepartment);
                statement.setString(4, newDeneyim);
                statement.setString(5, newEmail);
                statement.executeUpdate();
            }
            JOptionPane.showMessageDialog(this, "Profil bilgisi eklendi.");
            System.out.println("Profil bilgisi eklendi.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "HATA! Profil bilgisi eklenemedi!");
            System.out.println("Hata oluştu: " + ex.getMessage());
        }
    }
    
    private void deleteProfil() {
        int userId = Integer.parseInt(userIDField.getText());
        
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345")) {
            String query = "DELETE FROM profil WHERE usr_id = ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setInt(1, userId);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Profil başarıyla silindi.", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Profil başarıyla silindi.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "HATA! Profil bilgisi silinemedi!");
            System.out.println("Hata oluştu: " + ex.getMessage());
        }
    }
    
    private void showErrorMessage(String message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(ProfiliDuzenle.this, message, "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
       
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProfiliDuzenle().setVisible(true);
            }
        });
    }
}