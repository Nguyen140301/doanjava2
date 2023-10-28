package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;


import entities.account;
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

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private Map<String, Object> data = new HashMap<String, Object>();
	private List<account> accounts;
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
		setBounds(100, 100, 761, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JTextPane txtpnLogin = new JTextPane();
		txtpnLogin.setEditable(false);
		txtpnLogin.setForeground(Color.RED);
		txtpnLogin.setBackground(Color.GREEN);
		txtpnLogin.setFont(new Font("STLiti", Font.BOLD | Font.ITALIC, 65));
		txtpnLogin.setText("Login");
		panel.add(txtpnLogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setEditable(false);
		txtpnUsername.setBackground(Color.CYAN);
		txtpnUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtpnUsername.setText("Username:");
		txtpnUsername.setBounds(147, 46, 125, 36);
		panel_1.add(txtpnUsername);
		
		username = new JTextField();
		username.setBounds(303, 46, 249, 36);
		panel_1.add(username);
		username.setColumns(10);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setEditable(false);
		txtpnPassword.setBackground(Color.CYAN);
		txtpnPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtpnPassword.setText("Password:");
		txtpnPassword.setBounds(147, 109, 125, 36);
		panel_1.add(txtpnPassword);
		
		password = new JPasswordField();
		password.setBounds(303, 109, 249, 36);
		panel_1.add(password);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_actionPerformed(e);
			}
		});
		login.setForeground(Color.CYAN);
		login.setFont(new Font("Tahoma", Font.PLAIN, 25));
		login.setBackground(Color.GREEN);
		login.setBounds(128, 173, 191, 49);
		panel_1.add(login);
		
		
	}
	protected void login_actionPerformed(ActionEvent e) {
		
		String tdn = username.getText();
		String mk = new String(password.getPassword());
		AccountModel accountModel = new AccountModel();
		for(account account:accountModel.findAll()) {
			if (account.getName().equalsIgnoreCase(tdn)) {
				if (BCrypt.checkpw(mk, account.getPass())) {
					data.put("username", account.getName());
					home home = new home();
					home.setVisible(true);
					this.setVisible(false);
				}
				
			}
			
		}
		

		
		
	}
	
}
