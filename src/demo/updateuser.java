package demo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import entities.User;
import models.UserModel;

public class updateuser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField address;
	private JTextField phone;

	private JButton btnNewButton;
	private JButton Cancel;
	private JButton btnSave;

	private Map<String, Object> data;
	private JLabel idd;
	private JLabel namee;
	private JLabel addresss;
	private JLabel phonee;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateuser frame = new updateuser();
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
	public updateuser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 198, 198));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE USERS");
		lblNewLabel.setForeground(new Color(125, 125, 125));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 29, 906, 42);
		contentPane.add(lblNewLabel);
		

		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(134, 100, 107, 31);
		contentPane.add(lblNewLabel_1);

		idd = new JLabel("id");
		idd.setBounds(60, 133, 107, 34);
		contentPane.add(idd);

		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(134, 164, 107, 31);
		contentPane.add(lblNewLabel_1_1);

		namee = new JLabel("name");
		namee.setBounds(60, 205, 107, 34);
		contentPane.add(namee);

		JLabel lblNewLabel_1_2 = new JLabel("Address");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(new Color(134, 134, 134));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(134, 228, 107, 31);
		contentPane.add(lblNewLabel_1_2);

		addresss = new JLabel("address");
		addresss.setBounds(60, 279, 107, 34);
		contentPane.add(addresss);

		JLabel lblNewLabel_1_3 = new JLabel("Phone");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setForeground(new Color(134, 134, 134));
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(134, 302, 107, 31);
		contentPane.add(lblNewLabel_1_3);

		phonee = new JLabel("phone");
		phonee.setBounds(60, 357, 107, 34);
		contentPane.add(phonee);

		
		
		
		
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
		lblNewLabel_2_3.setBounds(240, 113, 448, 14);
		contentPane.add(lblNewLabel_2_3);
		
		id = new JTextField();
		id.setForeground(new Color(0, 0, 0));
		id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		id.setBorder(new LineBorder(new Color(255, 198, 198)));
		id.setBackground(new Color(255, 198, 198));
		id.setBounds(240, 100, 382, 23);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name.setColumns(10);
		name.setBorder(new LineBorder(new Color(255, 198, 198)));
		name.setBackground(new Color(255, 198, 198));
		name.setBounds(240, 164, 382, 23);
		contentPane.add(name);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		address.setColumns(10);
		address.setBorder(new LineBorder(new Color(255, 198, 198)));
		address.setBackground(new Color(255, 198, 198));
		address.setBounds(240, 228, 382, 23);
		contentPane.add(address);
		
		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phone.setColumns(10);
		phone.setBorder(new LineBorder(new Color(255, 198, 198)));
		phone.setBackground(new Color(255, 198, 198));
		phone.setBounds(240, 302, 382, 23);
		contentPane.add(phone);
		
		Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_Cancel_actionPerformed(e);
			}
		});
		Cancel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Cancel.setBorder(new LineBorder(new Color(134, 134, 134)));
		Cancel.setBackground(new Color(157, 255, 157));
		Cancel.setBounds(523, 371, 159, 36);
		contentPane.add(Cancel);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSave_actionPerformed(e);
			}
		});
		btnSave.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnSave.setBorder(new LineBorder(new Color(134, 134, 134)));
		btnSave.setBackground(new Color(157, 255, 157));
		btnSave.setBounds(240, 371, 159, 36);
		contentPane.add(btnSave);
	}
	
	protected void do_btnSave_actionPerformed(ActionEvent e) {
		try {
			UserModel userModel = new UserModel();
			User user = new User();
			user.setId(Integer.parseInt(id.getText()));
			user.setName(name.getText());
			user.setAddress(address.getText());
			user.setPhone(Integer.parseInt(phone.getText()));
			if (userModel.update(user)) {
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
	
	protected void do_Cancel_actionPerformed(ActionEvent e) {
		in4 tt = new in4();
		tt.setVisible(true);
		this.setVisible(false);
	}
}
