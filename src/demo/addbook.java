package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Book;
import models.BookModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class addbook extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtextField_title;
	private JTextField jtextField_scequence;
	private JTextField jtextField_author;
	private JButton btnCancel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addbook frame = new addbook();
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
	public addbook() {
		setTitle("Add Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(183, 183, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add book");
		lblNewLabel.setForeground(new Color(58, 58, 58));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 10, 330, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		lblNewLabel_1.setBounds(72, 84, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sequence");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(72, 139, 79, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Author");
		lblNewLabel_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(72, 206, 79, 14);
		contentPane.add(lblNewLabel_1_2);
		
		jtextField_title = new JTextField();
		jtextField_title.setBorder(new LineBorder(new Color(183, 183, 183)));
		jtextField_title.setBackground(new Color(183, 183, 183));
		jtextField_title.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtextField_title.setBounds(198, 75, 169, 20);
		contentPane.add(jtextField_title);
		jtextField_title.setColumns(10);
		
		jtextField_scequence = new JTextField();
		jtextField_scequence.setBorder(new LineBorder(new Color(183, 183, 183)));
		jtextField_scequence.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtextField_scequence.setBackground(new Color(183, 183, 183));
		jtextField_scequence.setColumns(10);
		jtextField_scequence.setBounds(198, 145, 169, 20);
		contentPane.add(jtextField_scequence);
		
		jtextField_author = new JTextField();
		jtextField_author.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtextField_author.setBorder(new LineBorder(new Color(183, 183, 183)));
		jtextField_author.setBackground(new Color(183, 183, 183));
		jtextField_author.setColumns(10);
		jtextField_author.setBounds(198, 200, 169, 20);
		contentPane.add(jtextField_author);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBorder(new LineBorder(new Color(212, 212, 212)));
		btnNewButton.setBackground(new Color(212, 212, 212));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(98, 309, 89, 29);
		contentPane.add(btnNewButton);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new LineBorder(new Color(212, 212, 212)));
		btnCancel.setBackground(new Color(212, 212, 212));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCancel_actionPerformed(e);
			}
		});
		btnCancel.setBounds(355, 309, 89, 29);
		contentPane.add(btnCancel);
		
		lblNewLabel_2 = new JLabel("________________________");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(198, 209, 169, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("________________________");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(198, 155, 169, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("________________________");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(198, 84, 169, 17);
		contentPane.add(lblNewLabel_4);
	}
	
	protected void jtextField_scequence_keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(!Character.isDigit(c)) {
			e.consume();
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		try {
			BookModel bookModel = new BookModel();
			Book book = new Book();
			book.setAuthor(jtextField_author.getText());
			book.setTitle(jtextField_title.getText());
			book.setSequence(Integer.parseInt(jtextField_scequence.getText()));
			book.setCallnumber(bookModel.generateCallNumber(book));
			if (bookModel.create(book)) {
				JOptionPane.showMessageDialog(null, "Success");
				book a = new book();
				a.setVisible(true);
				this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.setVisible(false);

	}
}
