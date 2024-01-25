package vt.project.mypart;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import database.Register;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
public class Admin extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nicknamefield;
	private JPasswordField passwordField;
	private Register registerFrame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}}});
	}
	public Admin(Register registerFrame) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Admin.class.getResource("/images/yildiz.png")));
		this.registerFrame = registerFrame;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(700,150, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 29, 86));
		panel.setBounds(0, 0, 586, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel nicknametext = new JLabel("Nickname:");
		nicknametext.setForeground(new Color(255, 255, 255));
		nicknametext.setFont(new Font("Arial", Font.PLAIN, 14));
		nicknametext.setBackground(new Color(255, 255, 255));
		nicknametext.setBounds(110, 180, 120, 40);
		panel.add(nicknametext);
		
		JLabel passwordtext = new JLabel("Password:");
		passwordtext.setForeground(new Color(255, 255, 255));
		passwordtext.setFont(new Font("Arial", Font.PLAIN, 14));
		passwordtext.setBackground(Color.WHITE);
		passwordtext.setBounds(110, 300, 120, 40);
		panel.add(passwordtext);
		
		nicknamefield = new JTextField();
		nicknamefield.setForeground(new Color(30, 29, 86));
		nicknamefield.setFont(new Font("Arial", Font.PLAIN, 14));
		nicknamefield.setBounds(209, 180, 270, 30);
		panel.add(nicknamefield);
		
		nicknamefield.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
		passwordField.setBounds(209, 300, 270, 30);
		panel.add(passwordField);
		
		JButton adminloginbutton = new JButton("LOG IN");
		adminloginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nickname;
                nickname = nicknamefield.getText();
                String pass = new String(passwordField.getPassword());
                if (pass.isEmpty() || nickname.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun.");
                    return;
                }               
                String query1 = "select count(*) from Admin where passwords = ? and nickname = ?";
                String query2 = "select count(*) from Admin where passwords = ?";
                String query3 = "select count(*) from Admin where nickname = ?";
                try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345");                		
                     PreparedStatement p1 = conn.prepareStatement(query1);
                     PreparedStatement p2 = conn.prepareStatement(query2);
                     PreparedStatement p3 = conn.prepareStatement(query3)) {
                    p1.setString(1, pass);
                    p1.setString(2, nickname);
                    try (ResultSet r1 = p1.executeQuery()) {
                        if (r1.next()) {
                            int count = r1.getInt(1);
                            if (count > 0) {
                                JOptionPane.showMessageDialog(null, "Admin girişi başarıyla yapıldı..");
                                
                                AdminPanelForm adminPanelForm = new AdminPanelForm();
                                adminPanelForm.setVisible(true);
                                adminPanelForm.pack();
                                adminPanelForm.setLocationRelativeTo(null);
                                adminPanelForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);                               
                                dispose();
                            } else {
                                p2.setString(1, pass);
                                p3.setString(1, nickname);
                                int count1 = 0, count2 = 0;
                                try (ResultSet r2 = p2.executeQuery()) {
                                    if (r2.next()) {
                                        count1 = r2.getInt(1);
                                    }}
                                try (ResultSet r3 = p3.executeQuery()) {
                                    if (r3.next()) {
                                        count2 = r3.getInt(1);
                                    }}
                                if (count1 > 0 || count2 > 0) {
                                    JOptionPane.showMessageDialog(null, "Girilen bilgiler hatalıdır. Lütfen tekrar deneyiniz.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Bu bilgilere sahip admin bulunamadı.");
                                }}}}}
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
			}});
		adminloginbutton.setForeground(new Color(30, 29, 86));
		adminloginbutton.setFont(new Font("Arial", Font.BOLD, 18));
		adminloginbutton.setBounds(107, 400, 380, 40);
		panel.add(adminloginbutton);
		
		JButton backpagebutton = new JButton("");
		backpagebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();  
				registerFrame.setVisible(true);
			}
		});
		backpagebutton.setBackground(new Color(30, 29, 86));
		backpagebutton.setBounds(20, 20, 64,64);
		backpagebutton.setIcon(new ImageIcon(Admin.class.getResource("/images/ret1.png")));
		panel.add(backpagebutton);
	}	
}