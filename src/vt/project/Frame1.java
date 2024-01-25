package vt.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

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


public class Frame1 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
    private BasvurularimPanel basvurularimPanel; // BasvurularimPanel referansını tutmak için alan ekleyin

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345");
		}catch(Exception e) {
			e.printStackTrace();
			}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 frame = new Frame1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frame1() {
		setTitle("İlanlar");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame1.class.getResource("/images/yildiz.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(460, 100, 1080, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem profilField = new JMenuItem("Profil");
		profilField.setBackground(UIManager.getColor("Slider.shadow"));
		profilField.setIcon(new ImageIcon(Frame1.class.getResource("/images/profile.png")));
		menuBar.add(profilField);
		Frame1 current = this;
		profilField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ProfilDeneme profileWindow = new ProfilDeneme();
                profileWindow.getFrame().setVisible(true);
                current.setVisible(false);
            }
		});
		
		JMenuItem homeField = new JMenuItem("Home");
		homeField.setBackground(UIManager.getColor("Slider.shadow"));
		homeField.setIcon(new ImageIcon(Frame1.class.getResource("/images/icons8-home-48.png")));
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
		
		JLabel lblNewLabel = new JLabel("İlanlar");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(353, 20, 90, 32);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(451, 20, 194, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAra = new JButton("Ara");
		btnAra.setBounds(657, 25, 90, 25);
		contentPane.add(btnAra);
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(318, 75, 98, 25);
		contentPane.add(comboBox);
		// JComboBox için verileri doldurun (company tablosundan)
        fillComboBoxWithCities(comboBox);
        
		
		JCheckBox chckbxYenidenEskiye = new JCheckBox("Yeniden Eskiye");
		chckbxYenidenEskiye.setBounds(447, 76, 167, 23);
		contentPane.add(chckbxYenidenEskiye);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 112, 527, 513);
		contentPane.add(scrollPane);
		
		// Scroll pane içine ilan panellerini eklemek için bir iç panel oluşturuldu
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
	 		    aramaYap(innerPanel, aramaKelimesi,false);
	 		});
	 	// JComboBox için ActionListener ekleyin
	        comboBox.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // JComboBox'te seçilen şehre göre ilanları güncelle
	                String selectedCity = comboBox.getSelectedItem().toString();
	                sehireGoreListele(innerPanel,selectedCity);
	            }

		
	        });
	    

        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(innerPanel);

        ilanlariListele(innerPanel);
        
        		

		
	}
	// JComboBox için şehir verilerini dolduran metod
    private void fillComboBoxWithCities(JComboBox comboBox ) {
    	comboBox.addItem("Şehir--");
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345");
            String query = "SELECT DISTINCT konum FROM company";
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    String sehir = rs.getString("konum");
                    comboBox.addItem(sehir);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private int sehirİlanSayisi(String sehir, int companyId)throws SQLException {
    	int is = 0;
    	try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345")) {
    		String query = "select count(*) as s from company c, ilanlar i where c.company_id = i.company_id and i.company_id= ? group by c.konum having c.konum= ? ;";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, companyId);
                ps.setString(2, sehir);
                

                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            is = rs.getInt("s");
                        } 
                    }     
                
            }
    	
    	}
    	return is;
    	
    }
    private void sehireGoreListele(JPanel innerPanel, String sehir) {
    	int ilanSayisi=0;
    	 ArrayList<Integer> companyIdList = new ArrayList<>(); 


    	 try {
             Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345");
             String query = "SELECT ilan_id, ilan_ismi, i.company_id, ilan_tarihi FROM ilanlar i, company c WHERE i.company_id = c.company_id AND c.konum = ?";
             try (PreparedStatement ps = conn.prepareStatement(query)) {
                 ps.setString(1, sehir);

                 try (ResultSet rs = ps.executeQuery()) {
                	 if (!rs.next()) {
                	        // ResultSet boş
                		 JOptionPane.showMessageDialog(null, "Bu şehirde ilan bulunmamaktadır.");
                	    } else {
                	        // ResultSet dolu, işlemleri burada devam ettirebilirsiniz
                	    	innerPanel.removeAll();
                	    	
                	        do {
                	            int ilanId = rs.getInt("ilan_id");
                	            String ilanIsmi = rs.getString("ilan_ismi");
                	            int companyId = rs.getInt("company_id");
                	            String ilanTarihi = rs.getString("ilan_tarihi");
                	            System.out.println(ilanId);
                	            listeleİlan(innerPanel, ilanId, ilanIsmi, companyId, ilanTarihi);
                	           
                	            if (!companyIdList.contains(companyId)) {
                                    companyIdList.add(companyId);
                                }
                	            

                	            // Diğer işlemleri burada gerçekleştirin
                	        } while (rs.next());
                                // Sonucu pop-up olarak göster
                                
                                for (Integer companyId : companyIdList) {
 

                                    // Eğer ilan sayısını da almak istiyorsanız, sehirİlanSayisi fonksiyonunu çağırabilirsiniz
                                    ilanSayisi += sehirİlanSayisi(sehir, companyId);
                                }
                                JOptionPane.showMessageDialog(null, "Şirketin " + sehir + " şehrindeki ilan sayısı: " + ilanSayisi);
                	        
                	        
                 }
             }
             }
    	     }catch (Exception e) {
                 e.printStackTrace();
             }


    	
    }
	 // Veritabanından ilanları çekip panellere ekleyen metod
    private void ilanlariListele(JPanel innerPanel) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345");
            String query = "SELECT ilan_id, ilan_ismi, company_id,ilan_tarihi FROM ilanlar";
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    int ilanId = rs.getInt("ilan_id");
                    String ilanIsmi = rs.getString("ilan_ismi");
                    //String aciklama = rs.getString("aciklama");
                    int companyId = rs.getInt("company_id");
                    String ilanTarihi = rs.getString("ilan_tarihi");
                    listeleİlan(innerPanel, ilanId, ilanIsmi, companyId, ilanTarihi);
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 // Başvuru yapılmış mı kontrolü
    private boolean isBasvuruYapilmis(int ilanId, int basvuranId) throws SQLException {
    	try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345")) {
            String query = "SELECT * FROM basvurular WHERE basvuran_id = ? AND ilan_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, basvuranId);
                ps.setInt(2, ilanId);
                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next();  // Eğer sonuç varsa başvuru yapılmış demektir
                }
            }
        }
    }
 // Veritabanından ilanları çekip panellere ekleyen metod
    private void aramaYap(JPanel innerPanel, String kelime,boolean yenidenEskiye) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345");
            String query = "SELECT ilan_id, ilan_ismi, company_id, ilan_tarihi FROM ilanlar " +
                           "WHERE ilan_ismi ILIKE ? OR company_id IN (SELECT company_id FROM company WHERE company_name ILIKE ?)"+
                           (yenidenEskiye ? "ORDER BY ilan_tarihi DESC" : "");  // Eğer Yeniden Eskiye seçiliyse sıralama yap
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, "%" + kelime + "%");  // İlan adı araması
                ps.setString(2, "%" + kelime + "%");  // Şirket adı araması

                try (ResultSet rs = ps.executeQuery()) {
                    // Her seferinde innerPanel'i temizleyerek yeni sonuçları ekleyeceğiz
                    innerPanel.removeAll();

                    // Sonuçları işleyin
                    while (rs.next()) {
                        int ilanId = rs.getInt("ilan_id");
                        String ilanIsmi = rs.getString("ilan_ismi");
                        int companyId = rs.getInt("company_id");
                        String ilanTarihi = rs.getString("ilan_tarihi");
                        listeleİlan(innerPanel, ilanId, ilanIsmi, companyId, ilanTarihi);

                        
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
        String query = "SELECT MAX(basvuru_id) FROM basvurular";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

            return 0; // Eğer tablo boşsa veya bir hata oluşursa
        }
    }
 // Başvuru ekleme
    private int insertBasvuru(int userId, int ilanId) throws SQLException {
        int basvuruId = 0;
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345")) {
            int maxBasvuruId = getMaxBasvuruId(conn);
            maxBasvuruId++;
            String query = "INSERT INTO basvurular (basvuru_id, ilan_id, basvuran_id) VALUES (?, ?, ?) RETURNING basvuru_id";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, maxBasvuruId);
                ps.setInt(2, ilanId);
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

 // Başvuru sonucu ekleme
    private void insertBasvuruSonucu(int basvuru_id) throws SQLException {
    	
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345")) {
        	String query = "INSERT INTO basvuru_sonuclari (basvuru_id, sonuc_durumu) VALUES (?, 'Beklemede')";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, basvuru_id);
                ps.executeUpdate();
                
            }
        }
        
    }
    private int getBasvuruSayisi(int ilanId) throws SQLException {
        int basvuruSayisi = 0;

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345")) {
            String query = "SELECT COUNT(*) FROM basvurular WHERE ilan_id=?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, ilanId);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        basvuruSayisi = rs.getInt(1); // COUNT(*) sütunu
                    }
                }
            }
        }

        return basvuruSayisi;
    }




    private void listeleİlan(JPanel innerPanel,int ilanId,String ilanIsmi,int companyId,String ilanTarihi) {
    	// Her bir ilan için panel oluştur
        JPanel ilanPanel = new JPanel();
        ilanPanel.setPreferredSize(new Dimension(500, 100));
        ilanPanel.setLayout(new BoxLayout(ilanPanel, BoxLayout.X_AXIS));
        ilanPanel.setAlignmentX(Component.LEFT_ALIGNMENT);  // Sola hizalama

        JLabel lblMeslekAd = new JLabel("Meslek adı: " + ilanIsmi);
        JLabel lblSirketIsmi = new JLabel("Şirket İsmi: " + getSirketIsmi(companyId));
        JLabel lblIlanTarihiLabel = new JLabel("Yayın Tarihi: " + ilanTarihi);
     // İlan başvuru sayısı
        int basvuruSayisi = 0;
        try {
            basvuruSayisi = getBasvuruSayisi(ilanId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JLabel lblBasvuruSayisi = new JLabel("Başvuru Sayısı: " + basvuruSayisi);


     // Başvur butonu
        JButton btnBasvur = new JButton("Başvur");
        btnBasvur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Başvuru yapma işlemleri
                    //int userId = 253678;//getUserId();  // Kullanıcı ID'sini almak için uygun bir metod kullanın
                	int userId = Session.getLoggedInUser().getUserId();

                    // Başvuru yapılmamışsa
                    if (!isBasvuruYapilmis(ilanId, userId)) {
                        // Başvuruyu ekleyin
                        int basvuru_id= insertBasvuru(userId, ilanId);
                        insertBasvuruSonucu(basvuru_id);

                        // Butonun metnini ve etkinliğini güncelleyin
                        btnBasvur.setText("Başvuruldu");
                        btnBasvur.setEnabled(false);
                        
                        // Başvuru sayısını güncelleyin ve etiketi güncelleyin
                        int yeniBasvuruSayisi = getBasvuruSayisi(ilanId);
                        lblBasvuruSayisi.setText("Başvuru Sayısı: " + yeniBasvuruSayisi);

                        JOptionPane.showMessageDialog(null, "Başvuru yapıldı!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Bu ilana daha önce başvuru yapılmış.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JButton btnAciklama = new JButton("Açıklama");
        btnAciklama.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // İlanın açıklamasını al
                String ilanAciklama = getIlanAciklama(ilanId); // ilanId, seçili ilanın kimliğidir

                // Pop-up penceresi oluştur
                JOptionPane.showMessageDialog(null, ilanAciklama, "İlan Açıklaması", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Başvur butonunu sağ üst köşeye taşı
        ilanPanel.add(btnBasvur);
        ilanPanel.add(btnAciklama);

     // İlan adı ve şirket adı paneli
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.add(lblMeslekAd);
        infoPanel.add(lblSirketIsmi);
        infoPanel.add(lblIlanTarihiLabel);
        infoPanel.add(lblBasvuruSayisi);

        // Başvur butonunu sağ üst köşeye taşı
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.add(btnBasvur);
        btnPanel.add(btnAciklama);
        infoPanel.add(btnPanel);

        // İlan paneline ekle
        ilanPanel.add(infoPanel, BorderLayout.CENTER);

        // İç panele ekle
        innerPanel.add(ilanPanel);
        innerPanel.add(Box.createRigidArea(new Dimension(0, 20)));  // Her ilan arasında boşluk bırak
    }

    private String getIlanAciklama(int ilanId) {
        String aciklama = "";

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345");
            String query = "SELECT aciklama FROM ilanlar WHERE ilan_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, ilanId);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        aciklama = rs.getString("aciklama");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aciklama;
    }

    // Şirket adını getiren metod
    private String getSirketIsmi(int companyId) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345");
            String query = "SELECT company_name FROM company WHERE company_id = " + companyId;
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)) {
                if (rs.next()) {
                    return rs.getString("company_name");
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
