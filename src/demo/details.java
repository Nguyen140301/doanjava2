package demo;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entities.Book;
import entities.Details;
import entities.User;
import models.AccountModel;
import models.BookModel;
import models.DetailsModel;
import models.UserModel;

import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class details extends JPanel {
	private JTable table;
	private Map<String, Object> data= new HashMap<String, Object>();
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextField tsarch;

	/**
	 * Create the panel.
	 */
	public details() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(66, 160, 255));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(72, 11, 637, 47);
		panel.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setForeground(new Color(64, 128, 128));
		scrollPane.setBackground(new Color(64, 128, 128));
		scrollPane.setBounds(72, 228, 637, 298);
		panel.add(scrollPane);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Return ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmNewMenuItem_actionPerformed(e);
			}
		});
		popupMenu.add(mntmNewMenuItem);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton add = new JButton("Add");
		add.setFont(new Font("Segoe UI", Font.BOLD, 20));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_actionPerformed(e);
			}
		});
		add.setBounds(104, 570, 113, 35);
		panel.add(add);
		
		JButton delete = new JButton("delete");
		delete.setFont(new Font("Tahoma", Font.BOLD, 20));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_actionPerformed(e);
			}
		});
		delete.setBounds(561, 571, 113, 35);
		panel.add(delete);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBorder(new LineBorder(new Color(66, 160, 255)));
		btnNewButton.setIcon(new ImageIcon(details.class.getResource("/asb/211817_search_strong_icon.png")));
		btnNewButton.setBounds(146, 126, 113, 30);
		panel.add(btnNewButton);
		
		tsarch = new JTextField();
		tsarch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				do_textField_keyReleased(e);
			}
		});
		tsarch.setBounds(255, 126, 369, 30);
		panel.add(tsarch);
		tsarch.setColumns(10);
		table.setComponentPopupMenu(popupMenu);
	}
	public details(Map<String, Object>data) {
		this();
		this.data = data;
		initJFrame();
	}
	private void initJFrame() {
		DetailsModel detailsModel=new DetailsModel();
		fillDataToJTable(detailsModel.fillAll());

	}
	
	private void fillDataToJTable(List<Details> details) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		DetailsModel detailsModel = new DetailsModel();
		model.addColumn("id_book");
		
		model.addColumn("title");
		model.addColumn("author");
		model.addColumn("id_user");
		model.addColumn("name_user");
		model.addColumn("check_out_date");
		model.addColumn("due_date");
		model.addColumn("issue_status");
		
		BookModel bookmodel = new BookModel();
		Book book = new Book();
		for (Details detail : details) {
			model.addRow(new Object[] {
					detail.getId_book(),  detail.getTitle(), detail.getAuthor(),
					detail.getId_user(), detail.getName_user(), detail.getCheck_out_date(), detail.getDue_date(), detail.getIssue_status()
			
			});
			
		}
		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(55);
	}	
	protected void delete_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confim", JOptionPane.YES_NO_CANCEL_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			int selectedRow = table.getSelectedRow();
			int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
			DetailsModel detailsModel = new DetailsModel();
			if(detailsModel.Delete(id)) {
				fillDataToJTable(detailsModel.fillAll());;
				
			}else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		}
	}
	protected void add_actionPerformed(ActionEvent e) {
		adddetail add = new adddetail();
		add.setVisible(true);
		
	}
	
	protected void do_textField_keyReleased(KeyEvent e) {
		DetailsModel d = new  DetailsModel();
		String t =  tsarch.getText().trim();
		String a =  tsarch.getText().trim();
		fillDataToJTable(d.Seacrh(t,a));
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	protected void mntmNewMenuItem_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confim", JOptionPane.YES_NO_CANCEL_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			int selectedRow = table.getSelectedRow();
			int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
			int id_user = Integer.parseInt(table.getValueAt(selectedRow, 3).toString());
			fee fee =new fee(id,id_user);
			this.removeAll();
			this.revalidate();
			this.add(fee);
			this.setVisible(true);
		}
	}
}