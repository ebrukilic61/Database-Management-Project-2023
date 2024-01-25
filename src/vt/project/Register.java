package vt.project;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import database.Admin;

import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
public class Register extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JTextField newNameField;
	private JTextField newLnameField;
	private JPasswordField passwordField;
	private Login loginFrame;
	private Admin adminFrame;
	
	public static void main(String[] args) throws IOException, SQLException{
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}}});
	}
	public Register() {
		frame = new JFrame();
        setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/images/yildiz.png")));
        setTitle("İş Bul - BLM3041");
		loginFrame = new Login(this);
		adminFrame = new Admin(this);
		setResizable(false);
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
		JButton registerSelectButtton = new JButton("REGISTER");
		registerSelectButtton.setForeground(new Color(30, 29, 86));
		registerSelectButtton.setFont(new Font("Arial", Font.BOLD, 18));
		registerSelectButtton.setBounds(140, 150, 200, 50);
		contentPane.add(registerSelectButtton);
		JButton loginSelectButton = new JButton("LOG IN");
		loginSelectButton.setForeground(new Color(160, 160, 160));
		loginSelectButton.setFont(new Font("Arial", Font.BOLD, 18));
		loginSelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();  
				loginFrame.setVisible(true);
			}});
		loginSelectButton.setBounds(360, 150, 200, 50);
		contentPane.add(loginSelectButton);
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setForeground(new Color(160, 160, 160));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(140, 259, 100, 50);
		contentPane.add(lblNewLabel);
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(new Color(160, 160, 160));
		lblLastName.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLastName.setBounds(140, 354, 100, 50);
		contentPane.add(lblLastName);
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(160, 160, 160));
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(140, 449, 100, 50);
		contentPane.add(lblPassword);
		newNameField = new JTextField();
		newNameField.setForeground(new Color(30, 29, 86));
		newNameField.setFont(new Font("Arial", Font.PLAIN, 14));
		newNameField.setBounds(260, 260, 300, 50);
		contentPane.add(newNameField);
		newNameField.setColumns(10);
		newLnameField = new JTextField();
		newLnameField.setForeground(new Color(30, 29, 86));
		newLnameField.setFont(new Font("Arial", Font.PLAIN, 14));
		newLnameField.setColumns(10);
		newLnameField.setBounds(260, 355, 300, 50);
		contentPane.add(newLnameField);
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(30, 29, 86));
		passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
		passwordField.setBounds(260, 450, 300, 50);
		contentPane.add(passwordField);
		JButton regButton = new JButton("REGISTER");
		regButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName, lastName;
                firstName = newNameField.getText();
                lastName = newLnameField.getText();
                String pass = new String(passwordField.getPassword());
                String query1 = "select count(*) from Kullanici where fname = ? and lname = ? and passwords = ?";
                String query2 = "select generate_nickname(get_userID(), ?, ?)";
                String query3 = "insert into Kullanici (userid, fname, lname, passwords, nickname) values (get_userID(), ?, ?, ?, ?)";
                if (firstName.isEmpty() || lastName.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun.");
                    return;
                }
                try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345");
                     PreparedStatement p1 = conn.prepareStatement(query1);
                     PreparedStatement p2 = conn.prepareStatement(query2);
                	 PreparedStatement p3 = conn.prepareStatement(query3)){
                            p1.setString(1, firstName);
                            p1.setString(2, lastName);
                            p1.setString(3, pass);
                            try (ResultSet r1 = p1.executeQuery()) {
                                if (r1.next()) {
                                    int count = r1.getInt(1);
                                    if (count > 0) {
                                        JOptionPane.showMessageDialog(null, "Bu bilgiler bir kullanıcıya ait. Lütfen GİRİŞ YAP sayfasına geçiniz");
                                    } else {
                                        p2.setString(1, firstName);
                                        p2.setString(2, lastName);
                                        try (ResultSet r2 = p2.executeQuery()) {
                                            if (r2.next()) {
                                                String nickname = r2.getString(1);
                                                p3.setString(1, firstName);
                                                p3.setString(2, lastName);
                                                p3.setString(3, pass);
                                                p3.setString(4, nickname);
                                                int affectedRows = p3.executeUpdate();
                                                if (affectedRows > 0) {
                                                	JOptionPane.showMessageDialog(null, "Kullanıcı " + nickname + " başarıyla kaydedildi. Lütfen GİRİŞ YAP sayfasına geçiniz.");
                                                }
                                                                                              
                                                }
                                            }
                                        }
                                    }
                                }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                    }}});
		regButton.setForeground(new Color(30, 29, 86));
		regButton.setFont(new Font("Arial", Font.PLAIN, 14));
		regButton.setBounds(140, 560, 420, 50);
		contentPane.add(regButton);
		
		 JMenuBar menuBar = new JMenuBar();
	        menuBar.setBackground(new Color(119, 136, 153));
	        setJMenuBar(menuBar);

	        JMenuItem userField = new JMenuItem("Kullanıcı Girisi");
	        userField.setBackground(UIManager.getColor("Slider.shadow"));
	        userField.setIcon(new ImageIcon(Register.class.getResource("/images/jobseeker.png")));
	        menuBar.add(userField);
	        userField.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	dispose();
	                getFrame();
	            }
	        });

	        JMenuItem adminField = new JMenuItem("Admin Girisi");
	        adminField.setBackground(UIManager.getColor("Slider.shadow"));
	        adminField.setIcon(new ImageIcon(Register.class.getResource("/images/admin.png")));
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
}