package demo;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Book;
import models.BookModel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class book extends JPanel {
	private Map<String, Object> data=new HashMap<String, Object>();
	private JTable table;
	private JPanel panel;
	/**
	 * Create the panel.
	 */
	public book() {
		setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		JButton jButton_List = new JButton("List");
		jButton_List.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_List_actionPerformed(e);
			}
		});
		menuBar.add(jButton_List);
		
		JButton jButoon_Add = new JButton("Add");
		jButoon_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButoon_Add_actionPerformed(e);
			}
		});
		menuBar.add(jButoon_Add);
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.	setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 859, 434);
		panel.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		initFrame();
	}
	private void initFrame() {
		DefaultTableModel model = new DefaultTableModel();
		BookModel bookModel = new BookModel();
		filldata(bookModel.fillAll());
	}
	
	private void filldata(List<Book> books){
		DefaultTableModel model = new DefaultTableModel();
		BookModel bookModel= new BookModel();
		model.addColumn("id");
		model.addColumn("isbn");
		model.addColumn("title");
		model.addColumn("author");
		model.addColumn("callnumber");
		model.addColumn("sequence");
		for(Book book: books) {
			model.addRow(new Object[] {
					book.getId(),book.getIsbn(),book.getTitle(),book.getAuthor(),book.getCallnumber(),book.getSequence()
			});
		}
		table.setModel(model);
	}
	protected void jButoon_Add_actionPerformed(ActionEvent e) {
		try {
			bookAdd bookAdd = new bookAdd();
			panel.removeAll();
			panel.revalidate();
			panel.add(bookAdd);
			panel.setVisible(true);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	protected void jButton_List_actionPerformed(ActionEvent e) {
		book a = new book();
		this.removeAll();
		this.revalidate();
		this.add(a);
		this.setVisible(true);
	}
}