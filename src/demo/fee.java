package demo;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Fee;
import entities.User;
import models.FeeModel;
import models.UserModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

public class fee extends JPanel {
	private JTable table;
	private Map<String, Object> data= new HashMap<String, Object>();
	/**
	 * Create the panel.
	 */
	public fee() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("fee");
		lblNewLabel.setBounds(260, 10, 281, 50);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 78, 672, 335);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(219, 423, 336, 43);
		panel.add(btnNewButton);

	}
	public fee(Map<String, Object>data) {
		this();
		this.data = data;
		initJFrame();
	}
	private void initJFrame() {
		FeeModel feeModel =new FeeModel();
		fillDataToJTable(feeModel.find());

	}

	private void fillDataToJTable(List<Fee> fees) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		FeeModel feeModel =new FeeModel();
		model.addColumn("name_user");
		model.addColumn("title");
		model.addColumn("check_out_date");
		model.addColumn("due_date");
		model.addColumn("fee");
		for (Fee fee : fees) {
			model.addRow(new Object[] {
					fee.getName_user(), fee.getTitle(), fee.getCheck_out_date(), fee.getDue_date(), fee.getFee()
			});
		}
		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(55);
	}	
	
	
	protected void btnNewButton_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confim", JOptionPane.YES_NO_CANCEL_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			int selectedRow = table.getSelectedRow();
			String name_user = (String) table.getValueAt(selectedRow, 0);
			FeeModel feeModel =new FeeModel();
			if(feeModel.Delete(name_user)) {
				fillDataToJTable(feeModel.find());;
			}else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		}
	}
}
