package vt.project.mypart;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.UIManager;


public class DisplayCertificates extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    public static JPanel contentPane;
    private JTextField textField;
    private SertifikaBasvurularimPanel basvurularimPanel; // SertifikaBasvurularimPanel referansını tutmak için alan ekleyin

    public static void main(String[] args) {
        try {
                Connection conn = MyConnection.getConnection();
        }catch(Exception e) {
                e.printStackTrace();
                }
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                        try {
                                DisplayCertificates frame = new DisplayCertificates();
                                frame.setVisible(true);
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }
        });
    }

    public DisplayCertificates() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(DisplayCertificates.class.getResource("/images/yildiz.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(460, 100, 1080, 680);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenuItem profilField = new JMenuItem("Profil");
        profilField.setBackground(UIManager.getColor("Slider.shadow"));
        profilField.setIcon(new ImageIcon(DisplayCertificates.class.getResource("/images/profile.png")));
        menuBar.add(profilField);
        DisplayCertificates current = this;
        profilField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ProfilDeneme profileWindow = new ProfilDeneme();
                profileWindow.getFrame().setVisible(true);
                current.setVisible(false);
            }
		});
        
        JMenuItem homeField = new JMenuItem("Home");
        homeField.setBackground(UIManager.getColor("Slider.shadow"));
        homeField.setIcon(new ImageIcon(DisplayCertificates.class.getResource("/images/icons8-home-48.png")));
        menuBar.add(homeField);
        homeField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	Menu homeArayuz = new Menu(null);
				homeArayuz.getFrame().setVisible(true);
                current.setVisible(false);
            }
		});
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(30, 29, 86));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Sertifika Programları");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        lblNewLabel.setBounds(450, 5, 200, 32);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(451, 40, 194, 30);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnAra = new JButton("Ara");
        btnAra.setBounds(657, 43, 90, 25);
        contentPane.add(btnAra);

        JComboBox comboBox = new JComboBox();
        comboBox.setToolTipText("");
        comboBox.setBounds(318, 75, 200, 25);
        contentPane.add(comboBox);
        // JComboBox için veriler sertifika_programlari tablosundan doldurulacak
        fillComboBoxWithCertificates(comboBox);


        JCheckBox chckbxYenidenEskiye = new JCheckBox("Yeniden Eskiye");
        chckbxYenidenEskiye.setBounds(530, 76, 167, 23);
        contentPane.add(chckbxYenidenEskiye);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(318, 112, 527, 513);
        contentPane.add(scrollPane);

        // Scroll pane içine sertifika programı panellerini eklemek için bir iç panel oluşturuldu
        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(Color.blue);
        // Check box'a ItemListener ekleyelim
        chckbxYenidenEskiye.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Yeniden Eskiye seçildiğinde çalışacak kod
                    String aramaKelimesi = textField.getText();
                    aramaYap(innerPanel, aramaKelimesi, true);
                } else {
                    // Yeniden Eskiye seçilmediğinde çalışacak kod
                    String aramaKelimesi = textField.getText();
                    aramaYap(innerPanel, aramaKelimesi, false);
                }
            }
	});
        // Ara butonuna ActionListener ekle
                btnAra.addActionListener(e -> {
                    String aramaKelimesi = textField.getText();
                    aramaYap(innerPanel, aramaKelimesi, false);
                });
        // JComboBox için ActionListener ekleyin
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JComboBox'te seçilen programa göre sertifika programlarını listele
                String selectedProgram = comboBox.getSelectedItem().toString();
                programaGoreListele(innerPanel,selectedProgram);
            }
        });

        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(innerPanel);

        sertifikaProgramlariniListele(innerPanel);
    }
    // JComboBox için sertifika programlarının verilerini dolduran metod
    private void fillComboBoxWithCertificates(JComboBox comboBox ) {
    	comboBox.addItem("Sertifika Programları--");
        try {
            Connection conn = MyConnection.getConnection();
            String query = "SELECT DISTINCT sertifika_adi FROM sertifika_programlari";
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    String sertifika_adi = rs.getString("sertifika_adi");
                    comboBox.addItem(sertifika_adi);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void programaGoreListele(JPanel innerPanel, String program) {
    	 try {
                Connection conn = MyConnection.getConnection();
                String query;
                int flag = 0;
                if(program.equals("Sertifika Programları--")){
                    query = "SELECT sertifika_id, sertifika_adi, company_id, sertifika_tarihi FROM sertifika_programlari"; 
                } else {
                   query = "SELECT sertifika_id, sertifika_adi, company_id, sertifika_tarihi FROM sertifika_programlari WHERE sertifika_adi = ?"; 
                   flag = 1;
                }
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    if(flag == 1) {
                        ps.setString(1, program);
                    }
                    try (ResultSet rs = ps.executeQuery()) {
                            if (!rs.next()) {
                	        // ResultSet boş
                		JOptionPane.showMessageDialog(null, "Böyle bir program bulunmamaktadır.");
                	    } else {
                	        // ResultSet dolu, işlemlere buradan devam edebiliriz.
                	    	innerPanel.removeAll();
                	        do {
                	            int sertifika_id = rs.getInt("sertifika_id");
                	            String sertifika_adi = rs.getString("sertifika_adi");
                	            int companyId = rs.getInt("company_id");
                	            String sertifika_tarihi = rs.getString("sertifika_tarihi");
                	            System.out.println(sertifika_id);
                	            listeleSertifikaProgramlari(innerPanel, sertifika_id, sertifika_adi, companyId, sertifika_tarihi);
                	        } while (rs.next());
                            }
                    }
                }
    	    }catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    // Veritabanından sertifika programlarını çekip panellere ekleyen metod
    private void sertifikaProgramlariniListele(JPanel innerPanel) {
        try {
            Connection conn = MyConnection.getConnection();
            String query = "SELECT sertifika_adi, sertifika_id, company_id, sertifika_tarihi FROM sertifika_programlari";
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    String sertifika_adi = rs.getString("sertifika_adi");
                    int  sertifika_id = rs.getInt("sertifika_id");
                    int companyId = rs.getInt("company_id");
                    String sertifika_tarihi = rs.getString("sertifika_tarihi");
                    listeleSertifikaProgramlari(innerPanel, sertifika_id, sertifika_adi, companyId, sertifika_tarihi);
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Başvuru yapılmış mı kontrolü
    private boolean isBasvuruYapilmis(int sertifika_id, int basvuran_id) throws SQLException, IOException {
        Connection conn = MyConnection.getConnection();
        String query = "SELECT * FROM Sertifika_basvuru WHERE sertifika_id = ? AND basvuran_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, sertifika_id);
            ps.setInt(2, basvuran_id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
    // Veritabanından sertifika program bilgilerini çekip panellere ekleyen metod
    private void aramaYap(JPanel innerPanel, String kelime, boolean yenidenEskiye) {
        try {
            Connection conn = MyConnection.getConnection();
            String query = "SELECT sertifika_id, sertifika_adi, company_id, sertifika_tarihi " +
               "FROM sertifika_programlari " +
               "WHERE sertifika_adi ILIKE ? " +
               "UNION " +
               "SELECT sertifika_id, sertifika_adi, company_id, sertifika_tarihi " +
               "FROM sertifika_programlari " +
               "WHERE company_id IN (SELECT company_id FROM company WHERE company_name ILIKE ?)" +
               (yenidenEskiye ? "ORDER BY sertifika_tarihi DESC" : "");  // Eğer Yeniden Eskiye seçiliyse sıralama yap
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, "%" + kelime + "%");  // Sertifika program adı araması
                ps.setString(2, "%" + kelime + "%");  // Şirket adı araması

                try (ResultSet rs = ps.executeQuery()) {
                    // Her seferinde innerPanel'i temizleyerek yeni sonuçları ekleyeceğiz
                    innerPanel.removeAll();

                    // Sonuçları işleyin
                    while (rs.next()) {
                        int sertifika_id = rs.getInt("sertifika_id");
                        String sertifika_adi = rs.getString("sertifika_adi");
                        int companyId = rs.getInt("company_id");
                        String sertifika_tarihi = rs.getString("sertifika_tarihi");
                        listeleSertifikaProgramlari(innerPanel, sertifika_id, sertifika_adi, companyId, sertifika_tarihi);
                    }

                    // İç panele yapılan değişiklikleri güncelleyin
                    innerPanel.revalidate();
                    innerPanel.repaint();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getMaxBasvuruId(Connection connection) throws SQLException {
        String query = "SELECT MAX(basvuru_id) FROM Sertifika_basvuru";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

            return 0; // Eğer tablo boşsa veya bir hata oluşursa
        }
    }
    
    // Başvuru ekleme
    private int insertBasvuru(int userId, int sertifikaID) throws SQLException, IOException {
        int basvuruId = 0;
        try (Connection conn = MyConnection.getConnection()) {
            int maxBasvuruId = getMaxBasvuruId(conn);
            maxBasvuruId++; 
            String query = "INSERT INTO Sertifika_basvuru (basvuru_id, sertifika_id, basvuran_id) VALUES (?, ?, ?) RETURNING basvuru_id";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, maxBasvuruId);
                ps.setInt(2, sertifikaID);
                ps.setInt(3, userId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        basvuruId = rs.getInt("basvuru_id");
                    }
                }
            }
        }
        return basvuruId;
    }

    private void listeleSertifikaProgramlari(JPanel innerPanel, int sertifikaID, String sertifika_adi,int companyId,String sertifika_tarihi) {
    	// Her bir sertifika ilanı için panel oluştur
        JPanel ilanPanel = new JPanel();
        ilanPanel.setPreferredSize(new Dimension(500, 100));
        ilanPanel.setLayout(new BoxLayout(ilanPanel, BoxLayout.X_AXIS));
        ilanPanel.setAlignmentX(Component.LEFT_ALIGNMENT);  // Sola hizalama

        JLabel lblSertifikaAd = new JLabel("Sertifika Pragramı: " + sertifika_adi);
        JLabel lblSirketIsmi = new JLabel("Şirket İsmi: " + getSirketIsmi(companyId));
        JLabel lblSertifikaPrgTarihiLabel = new JLabel("Yayın Tarihi: " + sertifika_tarihi);

        // Başvur butonu
        JButton btnBasvur = new JButton("Başvur");
        btnBasvur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Başvuru yapma işlemleri
                    int userId = Session.getLoggedInUser().getUserId();//getUserId() Kullanıcı ID'sini alır

                    // Başvuru yapılmamışsa
                    if (!isBasvuruYapilmis(sertifikaID, userId)) {
                        // Başvuruyu ekleyin
                        int basvuru_id= insertBasvuru(userId, sertifikaID);

                        // Butonun metnini ve etkinliğini güncelleyin
                        btnBasvur.setText("Başvuruldu");
                        btnBasvur.setEnabled(false);

                        JOptionPane.showMessageDialog(null, "Başvuru yapıldı!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Bu ilana daha önce başvuru yapılmış.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    Logger.getLogger(DisplayCertificates.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Başvur butonunu sağ üst köşeye taşı
        ilanPanel.add(btnBasvur);

     // Sertifika adı ve şirket adı paneli
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.add(lblSertifikaAd);
        infoPanel.add(lblSirketIsmi);
        infoPanel.add(lblSertifikaPrgTarihiLabel);

        // Başvur butonunu sağ üst köşeye taşı
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.add(btnBasvur);
        infoPanel.add(btnPanel);

        // İlan paneline ekle
        ilanPanel.add(infoPanel, BorderLayout.CENTER);

        // İç panele ekle
        innerPanel.add(ilanPanel);
        innerPanel.add(Box.createRigidArea(new Dimension(0, 20)));  // Her ilan arasında boşluk bırak
    }


    // Şirket adını getiren metod
    private String getSirketIsmi(int companyId) {
        try {
            Connection conn = MyConnection.getConnection();
            String query = "SELECT get_company_name(" + companyId + ")"; // Veri Tabanında tanımlı olan, companyId alarak o ID'deki şirket isimini dönen fonksiyon
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)) {
                if (rs.next()) {
                    return rs.getString(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
