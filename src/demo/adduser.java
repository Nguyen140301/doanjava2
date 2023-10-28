package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import entities.User;

import models.UserModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;

public class adduser extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField address;
	private JTextField phone;

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
		setBounds(100, 100, 887, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("add");
		lblNewLabel.setBounds(306, 20, 197, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setBounds(54, 84, 70, 21);
		contentPane.add(lblNewLabel_1);
		
		id = new JTextField();
		id.setBounds(154, 79, 145, 31);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("name");
		lblNewLabel_1_1.setBounds(54, 163, 70, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("address");
		lblNewLabel_1_2.setBounds(54, 232, 70, 21);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("phone");
		lblNewLabel_1_3.setBounds(54, 296, 70, 21);
		contentPane.add(lblNewLabel_1_3);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(154, 152, 145, 31);
		contentPane.add(name);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(154, 233, 145, 31);
		contentPane.add(address);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(154, 297, 145, 31);
		contentPane.add(phone);
		
		JButton save = new JButton("save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save_actionPerformed(e);
			}
		});
		save.setBounds(115, 372, 165, 48);
		contentPane.add(save);
		
		JButton cancel = new JButton("cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel_actionPerformed(e);
			}
		});
		cancel.setBounds(400, 372, 145, 48);
		contentPane.add(cancel);
	}
	
	
	
	protected void save_actionPerformed(ActionEvent e) {
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
	protected void cancel_actionPerformed(ActionEvent e) {
		in4 tt = new in4();
		tt.setVisible(true);
		this.setVisible(false);
	}
}
