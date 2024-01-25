package vt.project;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class ProfilDeneme extends JFrame{
	private JFrame frmProfilYldz;
    JTextField deneyimTextField;
    private JTextField basvuruTextField;
    private JTextField egitimTextField;
    private JTextField isimtextField;
    private JTextField depttextField;
    private JTextArea sertifikaTextArea;

	public ProfilDeneme() 
	{
		initialize();

	}

	private void initialize() {
		frmProfilYldz = new JFrame();
		frmProfilYldz.setResizable(false);
		frmProfilYldz.getContentPane().setBackground(new Color(30, 29, 86));
		frmProfilYldz.getContentPane().setLayout(null);
		
		JButton profilDuzenle = new JButton("Profili D\u00FCzenle");
		profilDuzenle.setIcon(new ImageIcon(ProfilDeneme.class.getResource("/images/icons8-edit-32.png")));
		profilDuzenle.setFont(new Font("Arial Black", Font.BOLD, 12));
		profilDuzenle.setBounds(752, 62, 180, 41);
		frmProfilYldz.getContentPane().add(profilDuzenle);
		
		JLabel profilFotoLabel = new JLabel("");
		profilFotoLabel.setIcon(new ImageIcon(ProfilDeneme.class.getResource("/images/icons8-user-100.png")));
		profilFotoLabel.setBounds(51, 24, 116, 100);
		frmProfilYldz.getContentPane().add(profilFotoLabel);
		
		JPanel panelDeneyim = new JPanel();
		panelDeneyim.setBackground(UIManager.getColor("Slider.shadow"));
		panelDeneyim.setBounds(47, 177, 420, 151);
		frmProfilYldz.getContentPane().add(panelDeneyim);
		panelDeneyim.setLayout(null);
		
		JLabel deneyimLabel = new JLabel("Deneyim");
		deneyimLabel.setBounds(10, 10, 137, 25);
		panelDeneyim.add(deneyimLabel);
		deneyimLabel.setForeground(new Color(255, 255, 255));
		deneyimLabel.setFont(new Font("Arial Black", Font.BOLD, 17));
		
		deneyimTextField = new JTextField();
		deneyimTextField.setEditable(false);
		deneyimTextField.setBounds(10, 40, 400, 100);
		panelDeneyim.add(deneyimTextField);
		deneyimTextField.setColumns(10);
		
		JPanel panelSertifika = new JPanel();
		panelSertifika.setBackground(UIManager.getColor("Slider.shadow"));
		panelSertifika.setBounds(512, 177, 420, 151);
		frmProfilYldz.getContentPane().add(panelSertifika);
		panelSertifika.setLayout(null);
		
		JLabel certifLabel = new JLabel("Sertifikalar");
		certifLabel.setBounds(10, 10, 203, 21);
		certifLabel.setForeground(new Color(255, 255, 255));
		certifLabel.setFont(new Font("Arial Black", Font.BOLD, 17));
		panelSertifika.add(certifLabel);
		
		sertifikaTextArea = new JTextArea();
		sertifikaTextArea.setEditable(false);
		sertifikaTextArea.setBounds(10, 40, 400, 100);
		sertifikaTextArea.setLineWrap(true);
		panelSertifika.add(sertifikaTextArea);
		
		JPanel panelBasvuru = new JPanel();
		panelBasvuru.setBackground(UIManager.getColor("Slider.shadow"));
		panelBasvuru.setBounds(47, 385, 420, 151);
		frmProfilYldz.getContentPane().add(panelBasvuru);
		panelBasvuru.setLayout(null);
		
		JLabel basvuruLabel = new JLabel("Ba\u015Fvurular");
		basvuruLabel.setForeground(new Color(255, 255, 255));
		basvuruLabel.setFont(new Font("Arial Black", Font.BOLD, 17));
		basvuruLabel.setBounds(10, 10, 116, 30);
		panelBasvuru.add(basvuruLabel);
		
		basvuruTextField = new JTextField();
		basvuruTextField.setEditable(false);
		basvuruTextField.setBounds(10, 40, 400, 100);
		panelBasvuru.add(basvuruTextField);
		basvuruTextField.setColumns(10);
		
		JPanel panelEgitim = new JPanel();
		panelEgitim.setBackground(UIManager.getColor("Slider.shadow"));
		panelEgitim.setBounds(512, 385, 420, 151);
		frmProfilYldz.getContentPane().add(panelEgitim);
		panelEgitim.setLayout(null);
		
		JLabel egitimLabel = new JLabel("E\u011Fitim");
		egitimLabel.setForeground(new Color(255, 255, 255));
		egitimLabel.setFont(new Font("Arial Black", Font.BOLD, 17));
		egitimLabel.setBounds(10, 10, 105, 29);
		panelEgitim.add(egitimLabel);
		
		egitimTextField = new JTextField();
		egitimTextField.setEditable(false);
		egitimTextField.setBounds(10, 40, 400, 100);
		panelEgitim.add(egitimTextField);
		egitimTextField.setColumns(10);
		
		JRadioButton showProfilBilgi = new JRadioButton("Profil Bilgilerini G\u00F6ster");
		showProfilBilgi.setBounds(51, 138, 160, 22);
		frmProfilYldz.getContentPane().add(showProfilBilgi);
		
		isimtextField = new JTextField();
		isimtextField.setToolTipText("");
		isimtextField.setFont(new Font("Arial Black", Font.PLAIN, 12));
		isimtextField.setEditable(false);
		isimtextField.setForeground(new Color(255, 255, 255));
		isimtextField.setBackground(new Color(30, 29, 86));
		isimtextField.setBounds(169, 40, 180, 30);
		frmProfilYldz.getContentPane().add(isimtextField);
		isimtextField.setColumns(10);
		
		depttextField = new JTextField();
		depttextField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
		depttextField.setEditable(false);
		depttextField.setForeground(new Color(255, 255, 255));
		depttextField.setBackground(new Color(30, 29, 86));
		depttextField.setBounds(169, 84, 180, 22);
		frmProfilYldz.getContentPane().add(depttextField);
		depttextField.setColumns(10);
		showProfilBilgi.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
        			bilgiDeneyim();
        			bilgiBasvuru();
        			bilgiEgitim();
        			bilgiIsim();
        			bilgiDept();
        			bilgiSertifika();
        		}catch(NumberFormatException ex) 
        		{
        			ex.printStackTrace();
        		}
		    }});
		
		frmProfilYldz.setForeground(SystemColor.activeCaption);
		frmProfilYldz.setFont(new Font("Arial Black", Font.BOLD, 13));
		frmProfilYldz.setTitle("Profil - Y\u0131ld\u0131z");
		frmProfilYldz.setIconImage(Toolkit.getDefaultToolkit().getImage(ProfilDeneme.class.getResource("/images/yildiz.png")));
		frmProfilYldz.setBounds(530, 100, 987, 682);
		frmProfilYldz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmProfilYldz.setJMenuBar(menuBar);
		
		JMenuItem profilMenuField = new JMenuItem("Profil");
		profilMenuField.setBackground(UIManager.getColor("Slider.shadow"));
		profilMenuField.setIcon(new ImageIcon(ProfilDeneme.class.getResource("/images/profile.png")));
		menuBar.add(profilMenuField);
		
		JMenuItem homeMenuField = new JMenuItem("Home");
		homeMenuField.setBackground(UIManager.getColor("Slider.shadow"));
		homeMenuField.setIcon(new ImageIcon(ProfilDeneme.class.getResource("/images/icons8-home-48.png")));
		menuBar.add(homeMenuField);
		
		profilDuzenle.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // profilField'a tıklandığında yapılacak işlemler:
		        ProfiliDuzenle arayuz = new ProfiliDuzenle();  // ArayuzUpdate sınıfından bir nesne oluşturulur
		        arayuz.setVisible(true);  // Profili Düzenle arayüzü görünür hale gelir
		        frmProfilYldz.setVisible(false);  // Profil ekranını gizler profili düzenle ekranı açılınca
		    }
		});
		
		homeMenuField.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) 
			 {
				 Menu homeArayuz = new Menu(null);
				 homeArayuz.getFrame().setVisible(true);
				 frmProfilYldz.setVisible(false);
			 }
		 });
	
	}
	
	public void bilgiDeneyim() {
        int userId = Session.getLoggedInUser().getUserId();
        String url = "jdbc:postgresql://localhost:5432/dbproje";
        String user = "postgres";
        String password = "12345";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT deneyim FROM profil WHERE usr_id = ?";           
            try (PreparedStatement st = conn.prepareStatement(query)) {
                st.setInt(1, userId);
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    deneyimTextField.setText(rs.getString("deneyim"));
                } else {
                    JOptionPane.showMessageDialog(this, "Deneyim bilgisi bulunamadı.");
                    System.out.println(userId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void bilgiSertifika() {
        int userId = Session.getLoggedInUser().getUserId();
        String url = "jdbc:postgresql://localhost:5432/dbproje";
        String user = "postgres";
        String password = "12345";
        
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT sertifika_adi, company_name FROM sertifika WHERE basvuran_id = ?";
            
            try (PreparedStatement st = conn.prepareStatement(query)) {
                st.setInt(1, userId);
                ResultSet rs = st.executeQuery();                
                	if (rs.next()) {
                        String sertifIsmi = rs.getString("sertifika_adi");
                        String comp_ismi = rs.getString("company_name");
                        sertifikaTextArea.setText("Sertifika ismi: "+sertifIsmi+"\nSertifikanın verildiği şirket: "+comp_ismi);
                    } else {
                        JOptionPane.showMessageDialog(this, "Sertifika bilgisi bulunamadı.");
                    }
                 
            } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (SQLException e1) {
		e1.printStackTrace();
	}
	}
	
	public void bilgiBasvuru() {
        int userId = Session.getLoggedInUser().getUserId();
        String url = "jdbc:postgresql://localhost:5432/dbproje";
        String user = "postgres";
        String password = "12345";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT ilan_id FROM basvurular WHERE basvuran_id = ?";
            String query2 = "SELECT ilan_ismi, ilan_tarihi FROM ilanlar WHERE ilan_id = ?";           
            try (PreparedStatement st = conn.prepareStatement(query)) {
                st.setInt(1, userId);
                ResultSet rs = st.executeQuery();                
                if (rs.next()) {
                    int ilanId = rs.getInt("ilan_id");                   
                    //ikinci sorgu için preparedstatement:
                    try (PreparedStatement st2 = conn.prepareStatement(query2)) {
                        st2.setInt(1, ilanId);
                        ResultSet rs2 = st2.executeQuery(); 
                        if (rs2.next()) {
                            String ilanIsmi = rs2.getString("ilan_ismi");
                            String ilanTarihi = rs2.getString("ilan_tarihi");
                            basvuruTextField.setText(ilanId+": "+ilanIsmi+", "+ilanTarihi);
                        } else {
                            JOptionPane.showMessageDialog(this, "İlan bulunamadı.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Başvuru bilgisi bulunamadı.");
                    System.out.println(userId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void bilgiEgitim() {
        int userId = Session.getLoggedInUser().getUserId();
        String url = "jdbc:postgresql://localhost:5432/dbproje";
        String user = "postgres";
        String password = "12345";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT okul, department FROM profil WHERE usr_id = ?";           
            try (PreparedStatement st = conn.prepareStatement(query)) {
                st.setInt(1, userId);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                	String okulIsmi = rs.getString("okul");
                    String departman = rs.getString("department");
                    if (egitimTextField != null) {
                        egitimTextField.setText(okulIsmi + ", " + departman);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Eğitim bilgisi bulunamadı.");
                    System.out.println(userId); //yanlış bir userid mi gösteriyor diye kontrol etmek amacıyla yazdım bunu
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	public void bilgiIsim() {
        int userId = Session.getLoggedInUser().getUserId();
        String url = "jdbc:postgresql://localhost:5432/dbproje";
        String user = "postgres";
        String password = "12345";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT fname, lname FROM kullanici WHERE userid = ?";           
            try (PreparedStatement st = conn.prepareStatement(query)) {
                st.setInt(1, userId);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                	String name = rs.getString("fname");
                    String surname = rs.getString("lname");
                    if (isimtextField != null) {
                        isimtextField.setText(name + " " + surname);
                        System.out.println("Name set to label: " + name + " " + surname);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Kullanıcı bulunamadı.");
                    System.out.println(userId); //yanlış bir userid mi gösteriyor diye kontrol etmek amacıyla yazdım bunu
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void bilgiDept() {
        int userId = Session.getLoggedInUser().getUserId();
        String url = "jdbc:postgresql://localhost:5432/dbproje";
        String user = "postgres";
        String password = "12345";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT department FROM profil WHERE usr_id = ?";           
            try (PreparedStatement st = conn.prepareStatement(query)) {
                st.setInt(1, userId);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    String departman = rs.getString("department");
                    if (depttextField != null) {
                        depttextField.setText(departman);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Kullanıcı bulunamadı.");
                    System.out.println(userId); //yanlış bir userid mi gösteriyor diye kontrol etmek amacıyla yazdım bunu
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilDeneme window = new ProfilDeneme();
					window.frmProfilYldz.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JFrame getFrame() {
		return frmProfilYldz;
	}
}