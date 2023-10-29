package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;


import entities.Account;
import models.AccountModel;

import javax.swing.JScrollPane;
import javax.security.auth.Subject;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class login extends JFrame {

	private JPanel contentPane;
	private Map<String, Object> data = new HashMap<String, Object>();
	private List<Account> accounts;
	private JTextField username;
	private JPasswordField password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		panel.setBackground(new Color(0, 128, 255));
		panel.setBounds(0, 0, 693, 527);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		lblNewLabel.setBounds(10, 22, 653, 49);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Hello! Let't get Started");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 83, 653, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(84, 115, 106, 40);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("________________________________________________________");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(84, 178, 419, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(login.class.getResource("/asb/ii.png")));
		lblNewLabel_4.setBounds(513, 133, 56, 71);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_2_1.setBounds(84, 219, 106, 40);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(login.class.getResource("/asb/yyy.png")));
		lblNewLabel_4_1.setBounds(513, 260, 48, 49);
		panel.add(lblNewLabel_4_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember Password ?");
		chckbxNewCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		chckbxNewCheckBox.setBackground(new Color(0, 128, 255));
		chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox.setBounds(84, 316, 159, 23);
		panel.add(chckbxNewCheckBox);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 17));
		username.setForeground(new Color(255, 255, 255));
		username.setBorder(new LineBorder(new Color(0, 128, 255)));
		username.setBackground(new Color(0, 128, 255));
		username.setSelectionColor(new Color(0, 128, 255));
		username.setSelectedTextColor(new Color(0, 128, 255));
		username.setBounds(84, 166, 378, 20);
		panel.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("________________________________________________________");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(84, 283, 419, 14);
		panel.add(lblNewLabel_3_1);
		
		password = new JPasswordField();
		password.setForeground(new Color(255, 255, 255));
		password.setFont(new Font("Tahoma", Font.PLAIN, 17));
		password.setBorder(new LineBorder(new Color(0, 128, 255)));
		password.setBackground(new Color(0, 128, 255));
		password.setBounds(84, 270, 338, 20);
		panel.add(password);
		
		JButton login = new JButton("LOGIN");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_login_actionPerformed(e);
			}
		});
		login.setBorder(new LineBorder(new Color(0, 128, 255)));
		login.setForeground(new Color(0, 128, 255));
		login.setFont(new Font("Segoe UI", Font.BOLD, 23));
		login.setBounds(84, 365, 477, 40);
		panel.add(login);
		
		
	}
	

	protected void do_login_actionPerformed(ActionEvent e) {
		
		String tdn = username.getText();
		String mk = new String(password.getPassword());
		AccountModel accountModel = new AccountModel();
		for(Account account:accountModel.findAll()) {
			if (account.getName().equalsIgnoreCase(tdn)&&account.getPass().equalsIgnoreCase(mk)) {
				
					home home = new home();
					home.setVisible(true);
					this.setVisible(false);
				
				
			}else {
				JOptionPane.showMessageDialog(null, "invalid");
			}
			
		}
	}
}
