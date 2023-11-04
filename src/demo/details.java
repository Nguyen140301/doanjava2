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

import entities.Details;
import entities.User;
import models.AccountModel;
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

public class details extends JPanel {
	private JTable table;
	private Map<String, Object> data= new HashMap<String, Object>();
	private JPanel panel;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public details() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Information Users");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(296, 26, 274, 47);
		panel.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 83, 751, 298);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton add = new JButton("add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_actionPerformed(e);
			}
		});
		add.setBounds(59, 416, 167, 52);
		panel.add(add);
		
		JButton delete = new JButton("delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_actionPerformed(e);
			}
		});
		delete.setBounds(330, 410, 195, 65);
		panel.add(delete);
		
		JButton update = new JButton("update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_actionPerformed(e);
			}
		});
		update.setBounds(586, 409, 132, 59);
		panel.add(update);
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
		model.addColumn("callnumber");
		model.addColumn("isbn");
		model.addColumn("title");
		model.addColumn("author");
		model.addColumn("id_user");
		model.addColumn("name_user");
		model.addColumn("check_out_date");
		model.addColumn("due_date");
		model.addColumn("issue_status");
		
		
		for (Details detail : details) {
			model.addRow(new Object[] {
					detail.getId_book(), detail.getCallnumber(),detail.getIsbn(), detail.getTitle(), detail.getAuthor(),
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
		this.setVisible(false);
	}
	protected void update_actionPerformed(ActionEvent e) {
		updatedetails c = new updatedetails();
		c.setVisible(true);
		this.setVisible(false);
	}
}