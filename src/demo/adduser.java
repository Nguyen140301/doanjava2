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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class adduser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
		setTitle("Add User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 514);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(193, 255, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ADD USERS");
		lblNewLabel.setBounds(10, 29, 817, 42);
		lblNewLabel.setForeground(new Color(155, 155, 155));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setBounds(130, 99, 107, 31);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(134, 134, 134));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Address");
		lblNewLabel_1_2.setBounds(130, 163, 107, 31);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(new Color(134, 134, 134));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Phone");
		lblNewLabel_1_3.setBounds(130, 237, 107, 31);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setForeground(new Color(134, 134, 134));
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1_3);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(529, 324, 159, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewButton.setBorder(new LineBorder(new Color(134, 134, 134)));
		btnNewButton.setBackground(new Color(157, 255, 157));
		contentPane.add(btnNewButton);

		Cancel = new JButton("Cancel");
		Cancel.setBounds(529, 371, 159, 36);
		Cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_btnCancel_mouseClicked(e);
			}
		});
		Cancel.setBackground(new Color(157, 255, 157));
		Cancel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		contentPane.add(Cancel);

		JLabel lblNewLabel_2 = new JLabel("_______________________________________________________________");
		lblNewLabel_2.setBounds(236, 250, 493, 14);
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("_______________________________________________________________");
		lblNewLabel_2_1.setBounds(236, 176, 493, 14);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBackground(Color.WHITE);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("_______________________________________________________________");
		lblNewLabel_2_2.setBounds(236, 112, 493, 14);
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBackground(Color.WHITE);
		contentPane.add(lblNewLabel_2_2);

		name = new JTextField();
		name.setBounds(236, 99, 382, 23);
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name.setColumns(10);
		name.setBorder(new LineBorder(new Color(193, 255, 193)));
		name.setBackground(new Color(193, 255, 193));
		contentPane.add(name);

		address = new JTextField();
		address.setBounds(235, 163, 382, 23);
		address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		address.setColumns(10);
		address.setBorder(new LineBorder(new Color(193, 255, 193)));
		address.setBackground(new Color(193, 255, 193));
		contentPane.add(address);

		phone = new JTextField();
		phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				phone_keyTyped(e);
			}
		});
		phone.setBounds(235, 237, 382, 23);
		phone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phone.setColumns(10);
		phone.setBorder(new LineBorder(new Color(193, 255, 193)));
		phone.setBackground(new Color(193, 255, 193));
		contentPane.add(phone);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(703, 82, 58, 48);
		lblNewLabel_3_1.setIcon(new ImageIcon(adduser.class.getResource("/asb/u.png")));
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setBounds(703, 146, 58, 48);
		lblNewLabel_3_1_1.setIcon(new ImageIcon(adduser.class.getResource("/asb/addres.png")));
		contentPane.add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("");
		lblNewLabel_3_1_1_1.setBounds(703, 223, 58, 48);
		lblNewLabel_3_1_1_1.setIcon(new ImageIcon(adduser.class.getResource("/asb/phone.png")));
		contentPane.add(lblNewLabel_3_1_1_1);
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {

		try {
			UserModel userModel = new UserModel();
			User user = new User();
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

	protected void phone_keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (!Character.isDigit(c)) {
			e.consume();
		}
	}
}
