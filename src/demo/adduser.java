package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import entities.User;
import models.UserModel;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adduser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField address;
	private JTextField phone;
	private JButton Cancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adduser frame = new adduser();
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
	public adduser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(193, 255, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD USERS");
		lblNewLabel.setForeground(new Color(155, 155, 155));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 29, 906, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setForeground(new Color(155, 155, 155));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(134, 96, 107, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(134, 134, 134));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(134, 164, 107, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Address");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(new Color(134, 134, 134));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(134, 228, 107, 31);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phone");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setForeground(new Color(134, 134, 134));
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(134, 302, 107, 31);
		contentPane.add(lblNewLabel_1_3);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewButton.setBorder(new LineBorder(new Color(134, 134, 134)));
		btnNewButton.setBackground(new Color(157, 255, 157));
		btnNewButton.setBounds(238, 371, 159, 36);
		contentPane.add(btnNewButton);
		
		Cancel = new JButton("Cancel");
		Cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_btnCancel_mouseClicked(e);
			}
		});
		Cancel.setBackground(new Color(157, 255, 157));
		Cancel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Cancel.setBounds(523, 371, 165, 36);
		contentPane.add(Cancel);
		
		JLabel lblNewLabel_2 = new JLabel("_______________________________________________________________");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(240, 315, 493, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("_______________________________________________________________");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setBounds(240, 241, 493, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("_______________________________________________________________");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBackground(Color.WHITE);
		lblNewLabel_2_2.setBounds(240, 177, 493, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("_______________________________________________________________");
		lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3.setBackground(new Color(193, 255, 193));
		lblNewLabel_2_3.setBounds(240, 109, 448, 14);
		contentPane.add(lblNewLabel_2_3);
		
		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		id.setBorder(new LineBorder(new Color(193, 255, 193)));
		id.setBackground(new Color(193, 255, 193));
		id.setBounds(239, 93, 382, 23);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name.setColumns(10);
		name.setBorder(new LineBorder(new Color(193, 255, 193)));
		name.setBackground(new Color(193, 255, 193));
		name.setBounds(240, 164, 382, 23);
		contentPane.add(name);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		address.setColumns(10);
		address.setBorder(new LineBorder(new Color(193, 255, 193)));
		address.setBackground(new Color(193, 255, 193));
		address.setBounds(239, 228, 382, 23);
		contentPane.add(address);
		
		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phone.setColumns(10);
		phone.setBorder(new LineBorder(new Color(193, 255, 193)));
		phone.setBackground(new Color(193, 255, 193));
		phone.setBounds(239, 302, 382, 23);
		contentPane.add(phone);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(adduser.class.getResource("/asb/idd.png")));
		lblNewLabel_3.setBounds(707, 82, 58, 41);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(adduser.class.getResource("/asb/u.png")));
		lblNewLabel_3_1.setBounds(707, 147, 58, 48);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(new ImageIcon(adduser.class.getResource("/asb/addres.png")));
		lblNewLabel_3_1_1.setBounds(707, 211, 58, 48);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("");
		lblNewLabel_3_1_1_1.setIcon(new ImageIcon(adduser.class.getResource("/asb/phone.png")));
		lblNewLabel_3_1_1_1.setBounds(707, 288, 58, 48);
		contentPane.add(lblNewLabel_3_1_1_1);
	}
	
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
		try {
			UserModel userModel = new UserModel();
			User user = new User();
			user.setId(Integer.parseInt(id.getText()));
			user.setName(name.getText());
			user.setAddress(address.getText());
			user.setPhone(Integer.parseInt(phone.getText()));
			if (userModel.create(user)) {
				JOptionPane.showMessageDialog(null, "Success");
				in4 tt = new in4();
				tt.setVisible(true);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
		
	}
	
protected void do_btnCancel_mouseClicked(MouseEvent e) {
		Cancel.setVisible(true);
		this.setVisible(false);
	}
}
