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

import entities.User;
import models.AccountModel;
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

public class in4 extends JPanel {
	private JTable table;
	private Map<String, Object> data= new HashMap<String, Object>();
	private JPanel panel;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public in4() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Information Account");
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
	public in4(Map<String, Object>data) {
		this();
		this.data = data;
		initJFrame();
	}
	private void initJFrame() {
		UserModel userModel = new UserModel();
		fillDataToJTable(userModel.find());

	}

	private void fillDataToJTable(List<User> users) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		UserModel userModel = new UserModel();
		model.addColumn("id");
		model.addColumn("name");
		model.addColumn("address");
		model.addColumn("phone");
		for (User user : users) {
			model.addRow(new Object[] {
					user.getId(), user.getName(),user.getAddress(),user.getPhone()
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
			UserModel userModel = new UserModel();
			if(userModel.Delete(id)) {
				fillDataToJTable(userModel.find());;
			}else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		}
	}
	protected void add_actionPerformed(ActionEvent e) {
		adduser add = new adduser();
		add.setVisible(true);
		this.setVisible(false);
	}
	protected void update_actionPerformed(ActionEvent e) {
		updateuser c = new updateuser();
		c.setVisible(true);
		this.setVisible(false);
	}
}
