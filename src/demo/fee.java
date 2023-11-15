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
		DetailsModel detailsModel = new DetailsModel();
		Fee fee = new Fee();
		Details detailss = new Details();
		for (Details details : detailsModel.fillAll()) {
			feeModel.generatefee(details);
		}
		fee.getName_user();
		fee.getTitle();
		fee.getReturn_date();
		fee.getDue_date();
		fee.getFee();
		fillDataToJTable(feeModel.find());

	}

	private void fillDataToJTable(List<Fee> fees) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		
		model.addColumn("name_user");
		model.addColumn("title");
		model.addColumn("return_date");
		model.addColumn("due_date");
		model.addColumn("fee");
		for (Fee detail : fees) {
			model.addRow(new Object[] {
					detail.getName_user(), detail.getTitle(), detail.getReturn_date(), detail.getDue_date(), detail.getFee() 
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
	public fee(int id, int id_user) {
		
		this();
		List<Fee> fees = new ArrayList<Fee>(); 
		FeeModel feeModel =new FeeModel();
		DetailsModel detailsModel = new DetailsModel();
		Fee fee = new Fee();
		Details detailss = new Details();
		
		for (Details details : detailsModel.fillAll()) {
			feeModel.generatefee(details);
			if(id == details.getId_book()&& id_user==details.getId_user()) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				Date date;
				try {
					date = dateFormat.parse("2023-11-20");
					
					fee.setName_user(details.getName_user());
					fee.setTitle(details.getTitle());
					fee.setReturn_date(date);
					
					System.out.println("asd"+ fee.getReturn_date()+date);
					fee.setDue_date(details.getDue_date());
					fee.setFee(details.getFee());
					fees.add(fee);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
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
		
		model.addColumn("name_user");
		model.addColumn("title");
		model.addColumn("return_date");
		model.addColumn("due_date");
		model.addColumn("fee");
		for (Fee detail : fees) {
			model.addRow(new Object[] {
					detail.getName_user(), detail.getTitle(), detail.getReturn_date(), detail.getDue_date(), detail.getFee() 
			});
		}
		
		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(55);
	}
}
