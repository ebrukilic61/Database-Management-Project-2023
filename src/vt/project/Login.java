package vt.project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private int userId;
	private JPanel contentPane;
	
	private JTextField newNicknameField;
	private JPasswordField passwordField;
	private Register registerFrame;
	private Admin adminFrame;
	private JFrame frame;
	private Menu menuScreen;
	private Login loginFrame;
	
	public static void main(String[] args) throws IOException, SQLException{
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}}});
	}
	
	public Login(Register registerFrame) {
		menuScreen = new Menu(this);
		setTitle("\u0130\u015E BUL - BLM3041");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/yildiz.png")));
		this.registerFrame = registerFrame;
		adminFrame = new Admin(registerFrame);
		menuScreen = new Menu(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(700,100,700,800);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 29, 86));
		contentPane.setForeground(new Color(30, 29, 86));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setForeground(new Color(30, 29, 86));
		panel.setBounds(5, 5, 0, 0);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton RegSelectButton = new JButton("REGISTER");
		RegSelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();  
                registerFrame.setVisible(true);
			}
		});
		RegSelectButton.setForeground(new Color(160, 160, 160));
		RegSelectButton.setFont(new Font("Arial", Font.BOLD, 18));
		RegSelectButton.setBounds(140, 150, 200, 50);
		contentPane.add(RegSelectButton);
		
		JButton loginSelectButton = new JButton("LOG IN");
		loginSelectButton.setForeground(new Color(30, 29, 86));
		loginSelectButton.setFont(new Font("Arial", Font.BOLD, 18));
		loginSelectButton.setBounds(360, 150, 200, 50);
		contentPane.add(loginSelectButton);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(160, 160, 160));
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(140, 420, 100, 50);
		contentPane.add(lblPassword);
		
		newNicknameField = new JTextField();
		newNicknameField.setForeground(new Color(30, 29, 86));
		newNicknameField.setFont(new Font("Arial", Font.PLAIN, 14));
		newNicknameField.setBounds(260, 290, 300, 50);
		contentPane.add(newNicknameField);
		newNicknameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(30, 29, 86));
		passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
		passwordField.setBounds(260, 420, 300, 50);
		contentPane.add(passwordField);
		
		JButton loginButton = new JButton("LOG IN");
				
		loginButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        ProfilDeneme profilDeneme = new ProfilDeneme();
		        String nickname;
		        nickname = newNicknameField.getText();
		        String pass = new String(passwordField.getPassword());
		        if (pass.isEmpty() || nickname.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun.");
		            return;
		        }
		        String query1 = "select count(*) from kullanici where passwords = ? and nickname = ?";
		        String query4 = "select count(*) from kullanici where passwords = ?";
		        String query5 = "select count(*) from kullanici where nickname = ?";
		        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345");
		             PreparedStatement p1 = conn.prepareStatement(query1);
		             PreparedStatement p4 = conn.prepareStatement(query4);
		             PreparedStatement p5 = conn.prepareStatement(query5);
		        ) {
		            p1.setString(1, pass);
		            p1.setString(2, nickname);
		            try (ResultSet r1 = p1.executeQuery()) {
		                if (r1.next()) {
		                    int count = r1.getInt(1);
		                    if (count > 0) {
		                        JOptionPane.showMessageDialog(null, "Kullanıcı girişi başarıyla yapıldı..");
		                        getUserIdDb();
		                        Session.setLoggedInUser(Login.this);
		                        profilDeneme.deneyimTextField.setText(Integer.toString(getUserId())); // getUserId kullanarak userId'yi al
		                        openMenuScreen();
		                    } else {
		                        p4.setString(1, pass);
		                        p5.setString(1, nickname);
		                        int count3 = 0, count4 = 0;
		                        try (ResultSet r4 = p4.executeQuery()) {
		                            if (r4.next()) {
		                                count3 = r4.getInt(1);
		                            }
		                        }
		                        try (ResultSet r5 = p5.executeQuery()) {
		                            if (r5.next()) {
		                                count4 = r5.getInt(1);
		                            }
		                        }
		                        if (count3 > 0 || count4 > 0) {
		                            JOptionPane.showMessageDialog(null, "Girilen bilgiler hatalıdır. Lutfen tekrar deneyiniz.");
		                        } else {
		                            JOptionPane.showMessageDialog(null, "Bu bilgilere sahip bir kullanıcı bulunamadı.");
		                        }
		                    }
		                }
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		});

		loginButton.setForeground(new Color(30, 29, 86));
		loginButton.setFont(new Font("Arial", Font.PLAIN, 14));
		loginButton.setBounds(140, 560, 420, 50);
		contentPane.add(loginButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nickname: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(160, 160, 160));
		lblNewLabel_1.setBounds(140, 290, 100, 50);
		contentPane.add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(119, 136, 153));
        setJMenuBar(menuBar);

        JMenuItem userField = new JMenuItem("Kullanıcı Girişi");
        userField.setBackground(UIManager.getColor("Slider.shadow"));
        userField.setIcon(new ImageIcon(Login.class.getResource("/images/jobseeker.png")));
        menuBar.add(userField);
        userField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getFrame();
            }
        });

        JMenuItem adminField = new JMenuItem("Admin Girişi");
        adminField.setBackground(UIManager.getColor("Slider.shadow"));
        adminField.setIcon(new ImageIcon(Login.class.getResource("/images/admin.png")));
        menuBar.add(adminField);
        adminField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                adminFrame.setVisible(true);
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }
	
    private int getUserIdDb() {
        String ncknm = newNicknameField.getText();
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345")) {
            String query = "SELECT userid FROM kullanici WHERE nickname = ?";
            String query1 = "INSERT INTO profil (usr_id) VALUES (?)";
            
            try (PreparedStatement st = conn.prepareStatement(query)) {
                st.setString(1, ncknm);

                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        userId = rs.getInt("userid");
                        setUserId(userId);
                        System.out.println("User ID: " + userId);
                        
                        // Insert into the 'profil' table
                        try (PreparedStatement st1 = conn.prepareStatement(query1)) {
                            st1.setInt(1, userId);
                            st1.executeUpdate();
                        }
                    } else {
                        System.out.println("Boyle bir kullanici bulunamadi");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userId;
    }

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	private void openMenuScreen() {
	    Menu menuScreen = new Menu(null);
	    JFrame menuFrame = menuScreen.getFrame();
	    if (menuFrame != null) {
	    	dispose();
	        menuFrame.setVisible(true);
	        
	    } else {
	        System.err.println("Menu frame is null.");
	    }
	}
}