package demo;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import entities.User;
import models.UserModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;

public class updateuser extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField address;
	private JTextField phone;
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
		setBounds(100, 100, 890, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("update");
		lblNewLabel.setBounds(282, 10, 178, 84);
		contentPane.add(lblNewLabel);
		
		idd = new JLabel("id");
		idd.setBounds(60, 133, 107, 34);
		contentPane.add(idd);
		
		namee = new JLabel("name");
		namee.setBounds(60, 205, 107, 34);
		contentPane.add(namee);
		
		addresss = new JLabel("address");
		addresss.setBounds(60, 279, 107, 34);
		contentPane.add(addresss);
		
		phonee = new JLabel("phone");
		phonee.setBounds(60, 357, 107, 34);
		contentPane.add(phonee);
		
		id = new JTextField();
		id.setBounds(231, 141, 229, 26);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(231, 213, 229, 26);
		contentPane.add(name);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(220, 287, 229, 26);
		contentPane.add(address);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(220, 365, 229, 26);
		contentPane.add(phone);
		
		JButton save = new JButton("save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save_actionPerformed(e);
			}
		});
		save.setBounds(83, 449, 133, 34);
		contentPane.add(save);
		
		JButton cancel = new JButton("cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel_actionPerformed(e);
			}
		});
		cancel.setBounds(296, 449, 144, 41);
		contentPane.add(cancel);
	}
	
	public updateuser(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}
	
	private void initJFrame() {
		UserModel userModel = new UserModel();
		DefaultComboBoxModel<User> model = new DefaultComboBoxModel<User>();
		for (User user : userModel.find()) {
			model.addElement(user);
		}
		User user = new User();
		user = userModel.find(Integer.parseInt(data.get("id").toString()));
		name.setText(user.getName());
		address.setText(user.getAddress());
		phone.setText(String.valueOf(user.getPhone()));
		
	}

	protected void save_actionPerformed(ActionEvent e) {
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
	
	
	protected void cancel_actionPerformed(ActionEvent e) {
		in4 tt = new in4();
		tt.setVisible(true);
		this.setVisible(false);
	}
}
