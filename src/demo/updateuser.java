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

import org.w3c.dom.UserDataHandler;

import entities.User;
import models.BookModel;
import models.UserModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class updateuser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtextField_id;
	private JTextField name;
	private JTextField address;
	private JTextField phone;

	private JButton btnNewButton;
	private JButton Cancel;
	private JButton btnSave;
	private User user;
	private Map<String, Object> data;

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
		setTitle("Update User ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 198, 198));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("UPDATE USERS");
		lblNewLabel.setForeground(new Color(125, 125, 125));
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 31));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 29, 906, 42);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(134, 100, 107, 31);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_1_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(134, 164, 107, 31);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Address");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(new Color(134, 134, 134));
		lblNewLabel_1_2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(134, 228, 107, 31);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Phone");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setForeground(new Color(134, 134, 134));
		lblNewLabel_1_3.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(134, 302, 107, 31);
		contentPane.add(lblNewLabel_1_3);

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

		jtextField_id = new JTextField();
		jtextField_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				id_keyReleased(e);
			}
		});
		jtextField_id.setForeground(new Color(0, 0, 0));
		jtextField_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtextField_id.setBorder(new LineBorder(new Color(255, 198, 198)));
		jtextField_id.setBackground(new Color(255, 198, 198));
		jtextField_id.setBounds(240, 100, 382, 23);
		contentPane.add(jtextField_id);
		jtextField_id.setColumns(10);

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
		phone.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				phone_keyTyped(e);
			}
		});
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
			user.setId(Integer.parseInt(jtextField_id.getText()));
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

	protected void phone_keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (!Character.isDigit(c)) {
			e.consume();
		}
	}

	protected void id_keyReleased(KeyEvent e) {
		int id = Integer.parseInt(jtextField_id.getText());
		UserModel userModel = new UserModel();
		user = userModel.findIdUser(id);
		name.setText(user.getName());
		address.setText(user.getAddress());
		phone.setText(String.valueOf(user.getPhone()));
	}
}
