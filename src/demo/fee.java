package demo;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Details;
import entities.Fee;
import entities.User;
import models.DetailsModel;
import models.FeeModel;
import models.UserModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class fee extends JPanel {
	private JTable table;
	private Map<String, Object> data = new HashMap<String, Object>();

	/**
	 * Create the panel.
	 */
	public fee() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("History");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewLabel.setBounds(260, 10, 281, 50);
		panel.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 78, 672, 335);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(244, 441, 336, 43);
		panel.add(btnNewButton);

	}

	public fee(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}

	private void initJFrame() {

		FeeModel feeModel = new FeeModel();
		fillDataToJTable(feeModel.findall());

	}

	private void fillDataToJTable(List<Fee> fees) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		model.addColumn("Username");
		model.addColumn("Title");
		model.addColumn("Return date");
		model.addColumn("Due date");
		model.addColumn("Fee");
		for (Fee detail : fees) {
			model.addRow(new Object[] { detail.getName_user(), detail.getTitle(), detail.getReturn_date(),
					detail.getDue_date(), detail.getFee() });
		}
		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(55);
	}

	protected void btnNewButton_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confim", JOptionPane.YES_NO_CANCEL_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			int selectedRow = table.getSelectedRow();
			String name_user = (String) table.getValueAt(selectedRow, 0);
			FeeModel feeModel = new FeeModel();
			if (feeModel.Delete(name_user)) {
				fillDataToJTable2(feeModel.find());
				;
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		}
	}

	public fee(int id, int id_user) {

		this();
		List<Fee> fees = new ArrayList<Fee>();
		FeeModel feeModel = new FeeModel();
		DetailsModel detailsModel = new DetailsModel();
		Fee fee = new Fee();
		Details detailss = new Details();
		Date returndate = new Date();
		for (Details details : detailsModel.fillAll()) {
			feeModel.generatefee(details);

		}
		for (Details details : detailsModel.fillAll()) {

			if (id == details.getId_book() && id_user == details.getId_user()) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

				try {

					fee.setName_user(details.getName_user());
					fee.setTitle(details.getTitle());
					fee.setReturn_date(returndate);
					fee.setDue_date(details.getDue_date());
					fee.setFee(details.getFee());
					fees.add(fee);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

			}

		}

		fillDataToJTable2(fees);
	}

	private void fillDataToJTable2(List<Fee> fees) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		Date returndatee = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String returndate = dateFormat.format(returndatee);
		model.addColumn("Username");
		model.addColumn("Title");
		model.addColumn("Return date");
		model.addColumn("Due date");
		model.addColumn("Fee");
		for (Fee detail : fees) {
			model.addRow(new Object[] { detail.getName_user(), detail.getTitle(), returndate, detail.getDue_date(),
					detail.getFee() });
		}

		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(55);
	}
}
