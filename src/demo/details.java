package demo;

import javax.swing.JPanel;
//dai
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class details extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldId_book;
	private JLabel jLabelId_book;
	private JPanel panel;
	private JTextField textFieldCallnumber;
	private JTextField textFieldISBN;
	private JTextField textFieldTittle;
	private JTextField textFieldAuthor;
	private JTextField textFieldIdUser;
	private JTextField textFieldNameUser;
	private JLabel lblCheckOutDate;
	private JLabel lblDueDate;
	private JLabel lblStatus;
	private JTextField jtextFieldDueDate;
	private JTextField jtextFieldCheckOutDate;
	private JTextField textField_2;
	private JButton jButtonBack;
	private JButton jButtonCancel;

	/**
	 * Create the panel.
	 */
	public details() {
		setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(26, 179, 230));
		panel.setBounds(32, 53, 535, 382);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("DETAILS");
		lblNewLabel.setBackground(new Color(128, 255, 255));
		lblNewLabel.setForeground(new Color(0, 0, 160));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(183, 11, 135, 41);
		panel.add(lblNewLabel);

		jLabelId_book = new JLabel("ID Book");
		jLabelId_book.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabelId_book.setForeground(new Color(0, 0, 128));
		jLabelId_book.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelId_book.setBounds(10, 67, 61, 17);
		panel.add(jLabelId_book);

		textFieldId_book = new JTextField();
		textFieldId_book.setBounds(81, 67, 119, 20);
		panel.add(textFieldId_book);
		textFieldId_book.setColumns(10);

		JLabel jLabelCallnumber = new JLabel("Call Number");
		jLabelCallnumber.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelCallnumber.setForeground(new Color(0, 0, 128));
		jLabelCallnumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabelCallnumber.setBounds(229, 67, 85, 17);
		panel.add(jLabelCallnumber);

		JLabel jLabelISBN = new JLabel("ISBN");
		jLabelISBN.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelISBN.setForeground(new Color(0, 0, 128));
		jLabelISBN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabelISBN.setBounds(10, 114, 61, 17);
		panel.add(jLabelISBN);

		JLabel jLabelTitle = new JLabel("Title");
		jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTitle.setForeground(new Color(0, 0, 128));
		jLabelTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabelTitle.setBounds(241, 114, 61, 17);
		panel.add(jLabelTitle);

		JLabel jLabelAuthor = new JLabel("Author");
		jLabelAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelAuthor.setForeground(new Color(0, 0, 128));
		jLabelAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabelAuthor.setBounds(10, 161, 61, 17);
		panel.add(jLabelAuthor);

		JLabel jLabelID_User = new JLabel("ID User");
		jLabelID_User.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelID_User.setForeground(new Color(0, 0, 128));
		jLabelID_User.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabelID_User.setBounds(241, 161, 61, 17);
		panel.add(jLabelID_User);

		JLabel jLabelName_User = new JLabel("Name User");
		jLabelName_User.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelName_User.setForeground(new Color(0, 0, 128));
		jLabelName_User.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabelName_User.setBounds(0, 206, 85, 17);
		panel.add(jLabelName_User);

		textFieldCallnumber = new JTextField();
		textFieldCallnumber.setColumns(10);
		textFieldCallnumber.setBounds(319, 67, 155, 20);
		panel.add(textFieldCallnumber);

		textFieldISBN = new JTextField();
		textFieldISBN.setColumns(10);
		textFieldISBN.setBounds(81, 114, 119, 20);
		panel.add(textFieldISBN);

		textFieldTittle = new JTextField();
		textFieldTittle.setColumns(10);
		textFieldTittle.setBounds(319, 114, 155, 20);
		panel.add(textFieldTittle);

		textFieldAuthor = new JTextField();
		textFieldAuthor.setColumns(10);
		textFieldAuthor.setBounds(81, 161, 119, 20);
		panel.add(textFieldAuthor);

		textFieldIdUser = new JTextField();
		textFieldIdUser.setColumns(10);
		textFieldIdUser.setBounds(319, 161, 155, 20);
		panel.add(textFieldIdUser);

		textFieldNameUser = new JTextField();
		textFieldNameUser.setColumns(10);
		textFieldNameUser.setBounds(81, 206, 119, 20);
		panel.add(textFieldNameUser);

		lblCheckOutDate = new JLabel("Check Out Date");
		lblCheckOutDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckOutDate.setForeground(new Color(0, 0, 128));
		lblCheckOutDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckOutDate.setBounds(210, 209, 104, 17);
		panel.add(lblCheckOutDate);

		lblDueDate = new JLabel("Due Date");
		lblDueDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDueDate.setForeground(new Color(0, 0, 128));
		lblDueDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDueDate.setBounds(10, 257, 61, 17);
		panel.add(lblDueDate);

		lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(new Color(0, 0, 128));
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(241, 260, 61, 17);
		panel.add(lblStatus);

		jtextFieldDueDate = new JTextField();
		jtextFieldDueDate.setColumns(10);
		jtextFieldDueDate.setBounds(81, 257, 119, 20);
		panel.add(jtextFieldDueDate);

		jtextFieldCheckOutDate = new JTextField();
		jtextFieldCheckOutDate.setColumns(10);
		jtextFieldCheckOutDate.setBounds(319, 206, 119, 20);
		panel.add(jtextFieldCheckOutDate);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(319, 257, 119, 20);
		panel.add(textField_2);

		jButtonBack = new JButton("Back");
		jButtonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonBack_actionPerformed(e);
			}
		});
		jButtonBack.setBounds(10, 334, 89, 23);
		panel.add(jButtonBack);

		jButtonCancel = new JButton("Cancel");
		jButtonCancel.setBounds(436, 334, 89, 23);
		panel.add(jButtonCancel);

		JButton jbuttonCancel = new JButton("Cancel");
		jbuttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonCancel_actionPerformed(e);
			}

			private void jButtonCancel_actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	protected void jButtonBack_actionPerformed(ActionEvent e) {
		home home = new home();

		home.setVisible(true);
		this.setVisible(false);
	}
	
}
