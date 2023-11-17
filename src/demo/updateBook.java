package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.events.EntityReference;

import com.toedter.calendar.IDateEditor;

import entities.Book;
import models.BookModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updateBook extends JFrame {

	private JPanel contentPane;
	private JTextField jtextField_Author;
	private JTextField jtextField_title;
	private JTextField jtextField_sequence;
	private JButton jbutton_Save;
	private JLabel lblId;
	private JTextField jtextField_Id;
	private JButton jbutton_cancel;
	private Book book;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateBook frame = new updateBook();
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
	public updateBook() {
		setTitle("Update Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Author");
		lblNewLabel.setBounds(122, 118, 63, 29);
		contentPane.add(lblNewLabel);

		jtextField_Author = new JTextField();
		jtextField_Author.setBounds(207, 122, 322, 29);
		contentPane.add(jtextField_Author);
		jtextField_Author.setColumns(10);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(122, 171, 63, 29);
		contentPane.add(lblTitle);

		jtextField_title = new JTextField();
		jtextField_title.setColumns(10);
		jtextField_title.setBounds(207, 175, 322, 29);
		contentPane.add(jtextField_title);

		JLabel lblSequence = new JLabel("Sequence");
		lblSequence.setBounds(122, 224, 63, 29);
		contentPane.add(lblSequence);

		jtextField_sequence = new JTextField();
		jtextField_sequence.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jtextField_sequence_keyTyped(e);
			}
		});
		jtextField_sequence.setColumns(10);
		jtextField_sequence.setBounds(207, 228, 322, 29);
		contentPane.add(jtextField_sequence);

		jbutton_Save = new JButton("Save");
		jbutton_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbutton_Save_actionPerformed(e);
			}
		});
		jbutton_Save.setBounds(427, 300, 89, 23);
		contentPane.add(jbutton_Save);

		lblId = new JLabel("Id");
		lblId.setBounds(122, 74, 63, 29);
		contentPane.add(lblId);

		jtextField_Id = new JTextField();
		jtextField_Id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				jtextField_Id_keyReleased(e);
			}
		});
		/*
		 * jtextField_Id.addKeyListener(new KeyAdapter() {
		 * 
		 * @Override /public void keyReleased(KeyEvent e) {
		 * jtextField_Id_keyReleased(e); } });
		 */
		jtextField_Id.setColumns(10);
		jtextField_Id.setBounds(207, 78, 322, 29);
		contentPane.add(jtextField_Id);

		jbutton_cancel = new JButton("Cancel");
		jbutton_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbutton_cancel_actionPerformed(e);
			}
		});
		jbutton_cancel.setBounds(427, 334, 89, 23);
		contentPane.add(jbutton_cancel);
	}

	protected void jtextField_sequence_keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (!Character.isDigit(c)) {
			e.consume();
		}
	}

	protected void jbutton_Save_actionPerformed(ActionEvent e) {
		try {
			BookModel bookModel = new BookModel();
			Book book = new Book();
			int id = Integer.parseInt(jtextField_Id.getText());
			book.setId(Integer.parseInt(jtextField_Id.getText()));
			book.setAuthor(jtextField_Author.getText());
			book.setSequence(Integer.parseInt(jtextField_sequence.getText()));
			book.setTitle(jtextField_title.getText());
			book.setCallnumber(bookModel.generateCallNumber(book));
			book.setIsbn(bookModel.generateISBN(book));

			if (bookModel.update(book,id)) {
				JOptionPane.showMessageDialog(null, "Success");
				book book1 = new book();
				book1.setVisible(true);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
			e2.printStackTrace();
		}
	}

	protected void jbutton_cancel_actionPerformed(ActionEvent e) {
		book book = new book();
		book.setVisible(true);
		this.setVisible(false);
	}

	protected void jtextField_Id_keyReleased(KeyEvent e) {
		int id = Integer.parseInt(jtextField_Id.getText());
		BookModel bookModel = new BookModel();
		book = bookModel.findIdBook(id);
		jtextField_title.setText(book.getTitle());
		jtextField_Author.setText(book.getAuthor());
		jtextField_sequence.setText(String.valueOf(book.getSequence()));
	}

}
