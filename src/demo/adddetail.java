package demo;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import entities.Details;
import entities.User;
import models.DetailsModel;
import models.UserModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.BorderLayout;

public class adddetail extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public adddetail() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(26, 179, 230));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DETAILS");
		lblNewLabel.setBounds(183, 11, 135, 41);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 160));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBackground(new Color(128, 255, 255));
		panel.add(lblNewLabel);
		
		JLabel jLabelId_book = new JLabel("ID Book");
		jLabelId_book.setBounds(10, 67, 61, 17);
		jLabelId_book.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelId_book.setForeground(new Color(0, 0, 128));
		jLabelId_book.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(jLabelId_book);
		
		textField = new JTextField();
		textField.setBounds(81, 67, 119, 20);
		textField.setColumns(10);
		panel.add(textField);
		
		JLabel jLabelCallnumber = new JLabel("Call Number");
		jLabelCallnumber.setBounds(229, 67, 85, 17);
		jLabelCallnumber.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelCallnumber.setForeground(new Color(0, 0, 128));
		jLabelCallnumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(jLabelCallnumber);
		
		JLabel jLabelISBN = new JLabel("ISBN");
		jLabelISBN.setBounds(10, 114, 61, 17);
		jLabelISBN.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelISBN.setForeground(new Color(0, 0, 128));
		jLabelISBN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(jLabelISBN);
		
		JLabel jLabelTitle = new JLabel("Title");
		jLabelTitle.setBounds(241, 114, 61, 17);
		jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTitle.setForeground(new Color(0, 0, 128));
		jLabelTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(jLabelTitle);
		
		JLabel jLabelAuthor = new JLabel("Author");
		jLabelAuthor.setBounds(10, 161, 61, 17);
		jLabelAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelAuthor.setForeground(new Color(0, 0, 128));
		jLabelAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(jLabelAuthor);
		
		JLabel jLabelID_User = new JLabel("ID User");
		jLabelID_User.setBounds(241, 161, 61, 17);
		jLabelID_User.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelID_User.setForeground(new Color(0, 0, 128));
		jLabelID_User.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(jLabelID_User);
		
		JLabel jLabelName_User = new JLabel("Name User");
		jLabelName_User.setBounds(0, 206, 85, 17);
		jLabelName_User.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelName_User.setForeground(new Color(0, 0, 128));
		jLabelName_User.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(jLabelName_User);
		
		textField_1 = new JTextField();
		textField_1.setBounds(319, 67, 155, 20);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(81, 114, 119, 20);
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(319, 114, 155, 20);
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(81, 161, 119, 20);
		textField_4.setColumns(10);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(319, 161, 155, 20);
		textField_5.setColumns(10);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(81, 206, 119, 20);
		textField_6.setColumns(10);
		panel.add(textField_6);
		
		JLabel lblCheckOutDate = new JLabel("Check Out Date");
		lblCheckOutDate.setBounds(210, 209, 104, 17);
		lblCheckOutDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckOutDate.setForeground(new Color(0, 0, 128));
		lblCheckOutDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblCheckOutDate);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setBounds(10, 257, 61, 17);
		lblDueDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDueDate.setForeground(new Color(0, 0, 128));
		lblDueDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblDueDate);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(241, 260, 61, 17);
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(new Color(0, 0, 128));
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblStatus);
		
		JButton save = new JButton("Save");
		save.setBounds(70, 347, 85, 21);
		panel.add(save);
		
		JButton cancel = new JButton("cancel");
		cancel.setBounds(338, 347, 85, 21);
		panel.add(cancel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(325, 207, 73, 19);
		panel.add(dateChooser);
		
		JDateChooser duedate = new JDateChooser();
		duedate.setBounds(82, 255, 73, 19);
		panel.add(duedate);
		
		textField_7 = new JTextField();
		textField_7.setBounds(319, 258, 96, 19);
		textField_7.setColumns(10);
		panel.add(textField_7);

		
	}
}
