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
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.FlatteningPathIterator;

public class book extends JPanel {
	private Map<String, Object> data = new HashMap<String, Object>();
	private JPanel panel;
	private JTable table;
	private JTextField tsearch;

	/**
	 * Create the panel.
	 */
	public book() {
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 161, 603, 297);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(297, 507, 133, 30);
		panel.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Book");
		lblNewLabel.setForeground(new Color(78, 78, 78));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(79, 11, 603, 30);
		panel.add(lblNewLabel);

		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_2.setIcon(new ImageIcon(book.class.getResource("/asb/211817_search_strong_icon.png")));
		btnNewButton_2.setBackground(new Color(167, 167, 167));
		btnNewButton_2.setBounds(141, 83, 127, 30);
		panel.add(btnNewButton_2);

		tsearch = new JTextField();
		tsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				do_textField_keyReleased(e);
			}
		});
		tsearch.setBounds(266, 83, 341, 30);
		panel.add(tsearch);
		tsearch.setColumns(10);

		JButton jButton_update = new JButton("Update");
		jButton_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_update_actionPerformed(e);
			}
		});
		jButton_update.setBounds(98, 511, 133, 30);
		panel.add(jButton_update);

		JButton jButton_delete = new JButton("Delete");
		jButton_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_delete_actionPerformed(e);
			}
		});
		jButton_delete.setBounds(501, 511, 133, 30);
		panel.add(jButton_delete);

		initFrame();
	}

	private void initFrame() {
		DefaultTableModel model = new DefaultTableModel();
		BookModel bookModel = new BookModel();
		filldata(bookModel.find());
	}

	private void filldata(List<Book> books) {
		DefaultTableModel model = new DefaultTableModel();
		BookModel bookModel = new BookModel();
		model.addColumn("Id");
		model.addColumn("Isbn");
		model.addColumn("Title");
		model.addColumn("Author");
		model.addColumn("Callnumber");
		model.addColumn("Sequence");
		for (Book book : books) {
			model.addRow(new Object[] { book.getId(), book.getIsbn(), book.getTitle(), book.getAuthor(),
					book.getCallnumber(), book.getSequence() });

		}
		table.setModel(model);
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		addbook v = new addbook();
		v.setVisible(true);
	}

	protected void do_textField_keyReleased(KeyEvent e) {
		BookModel b = new BookModel();
		String name = tsearch.getText().trim();
		filldata(b.Search(name));
	}

	protected void jButton_update_actionPerformed(ActionEvent e) {
		updateBook c = new updateBook();
		c.setVisible(true);
	}
	private void fillDataToJTable(List<Book> books) {
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		BookModel bookModel = new BookModel();
		model.addColumn("Id");
		model.addColumn("Isbn");
		model.addColumn("Title");
		model.addColumn("Author");
		model.addColumn("Callnumber");
		model.addColumn("Sequence");
		for (Book book : books) {
			model.addRow(new Object[] { book.getId(), book.getIsbn(), book.getTitle(), book.getAuthor(),
					book.getCallnumber(), book.getSequence() });
		}
		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(55);
	}

	protected void jButton_delete_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confim", JOptionPane.YES_NO_CANCEL_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			int sellectedRow = table.getSelectedRow();
			int id = Integer.parseInt(table.getValueAt(sellectedRow, 0).toString());
			BookModel bookModel = new BookModel();
			if (bookModel.Delete(id)) {
				fillDataToJTable(bookModel.find());
			} else {
				JOptionPane.showConfirmDialog(null, "Failed");
			}
		}
	}

}
