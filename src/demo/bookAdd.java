package demo;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entities.Book;
import models.BookModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class bookAdd extends JPanel {
	private JTextField jtextField_title;
	private JTextField jtextField_author;
	private JTextField jtextField_scequence;

	/**
	 * Create the panel.
	 */
	public bookAdd() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		jtextField_title = new JTextField();
		jtextField_title.setBounds(255, 95, 306, 20);
		panel_1.add(jtextField_title);
		jtextField_title.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Titile");
		lblNewLabel_1.setBounds(165, 95, 64, 20);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Author");
		lblNewLabel_1_1.setBounds(165, 154, 64, 20);
		panel_1.add(lblNewLabel_1_1);
		
		jtextField_author = new JTextField();
		jtextField_author.setBounds(255, 154, 306, 20);
		jtextField_author.setColumns(10);
		panel_1.add(jtextField_author);
		
		JButton jbuttonAdd = new JButton("Add");
		jbuttonAdd.setBounds(472, 173, 89, 23);
		jbuttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAdd_actionPerformed(e);
			}
		});
		panel_1.add(jbuttonAdd);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Sequence");
		lblNewLabel_1_1_1.setBounds(165, 123, 64, 20);
		panel_1.add(lblNewLabel_1_1_1);
		
		jtextField_scequence = new JTextField();
		jtextField_scequence.setBounds(255, 123, 306, 20);
		jtextField_scequence.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jtextField_scequence_keyTyped(e);
			}
		});
		jtextField_scequence.setColumns(10);
		panel_1.add(jtextField_scequence);
		initJFrame();
	}
	private void initJFrame() {
		
	}
	protected void jbuttonAdd_actionPerformed(ActionEvent e) {
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
				this.removeAll();
				this.revalidate();
				this.add(a);
				this.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
		
	}
	protected void jtextField_scequence_keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(!Character.isDigit(c)) {
			e.consume();
		}
	}
}