package vt.project.mypart;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPanel;

public class Menu extends JFrame{

	private JFrame frmMenu;
	private Login loginFrame;
	public static Frame1 ilanPanel; 
	public static DisplayCertificates sertifikaIlanPanel;
	
	public static Frame1 getIlanPanel() {
		return ilanPanel;
	}
	private BasvurularimPanel basvurularimPanel;
	private SertifikaBasvurularimPanel sertifikaBasvurularımPanel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu(null);
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Menu(Login loginFrame) {
		initialize();
		this.loginFrame = loginFrame;
	}

	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setBackground(SystemColor.controlShadow);
		frmMenu.setTitle("Menu");
		frmMenu.getContentPane().setBackground(new Color(30, 29, 86));
		frmMenu.getContentPane().setLayout(null);
		
		
		JButton btnIlanlar = new JButton("İş İlanları");
		btnIlanlar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnIlanlar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ilanPanel == null) {
	                ilanPanel = new Frame1(); // İlk erişimde paneli oluşturun
	            }
	            ilanPanel.setVisible(true); // Paneli görünür yapın
				frmMenu.setVisible(false);
			}
		});
		btnIlanlar.setBounds(195, 130, 224, 104);
		frmMenu.getContentPane().add(btnIlanlar);
		
		JButton btnSertifikalar = new JButton("Sertifika İlanları");
		btnSertifikalar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSertifikalar.setBounds(650, 130, 217, 104);
		frmMenu.getContentPane().add(btnSertifikalar);
		btnSertifikalar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	           if (sertifikaIlanPanel == null) {
	                sertifikaIlanPanel = new DisplayCertificates(); // İlk erişimde paneli oluşturun
	            }
	            sertifikaIlanPanel.setVisible(true); // Paneli görünür yapın
	            frmMenu.setVisible(false);
	}
		});
		
		JButton btnIBavurular = new JButton("İş Başvuruları");
		btnIBavurular.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnIBavurular.setBounds(195, 385, 224, 104);
		btnIBavurular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            basvurularimPanel = new BasvurularimPanel(); // İlk erişimde paneli oluşturun
	            basvurularimPanel.setVisible(true); // Paneli görünür yapın
				frmMenu.setVisible(false);
			}
		});

		frmMenu.getContentPane().add(btnIBavurular);
		
		JButton btnSertifikaBavurular = new JButton("Sertifika Başvuruları");
		btnSertifikaBavurular.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSertifikaBavurular.setBounds(650, 385, 217, 104);
		frmMenu.getContentPane().add(btnSertifikaBavurular);
		frmMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/images/yildiz.png")));
		frmMenu.setBounds(460, 100, 1080, 680);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnSertifikaBavurular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try {
                                sertifikaBasvurularımPanel = new SertifikaBasvurularimPanel(); // İlk erişimde paneli oluşturun
                            } catch (SQLException ex) {
                                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                            }
	            sertifikaBasvurularımPanel.setVisible(true); // Paneli görünür yapın
				frmMenu.setVisible(false);
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(119, 136, 153));
		frmMenu.setJMenuBar(menuBar);
		
		JMenuItem profilField = new JMenuItem("Profil");
		profilField.setBackground(UIManager.getColor("Slider.shadow"));
		profilField.setIcon(new ImageIcon(Menu.class.getResource("/images/profile.png")));
		menuBar.add(profilField);
		
		JMenuItem homeField = new JMenuItem("Home");
		homeField.setBackground(UIManager.getColor("Slider.shadow"));
		homeField.setIcon(new ImageIcon(Menu.class.getResource("/images/icons8-home-48.png")));
		menuBar.add(homeField);
		
		 profilField.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	                ProfilDeneme profileWindow = new ProfilDeneme();
	                profileWindow.getFrame().setVisible(true);
	                frmMenu.setVisible(false); //profil ekranı açılınca menu kapanacak, daha dogrusu gizliyoruz görünürlüğünü setVisible'ı false yaparak
	            }
         });
	 
	}
	
	public JFrame getFrame() {
        return frmMenu;
    }
}