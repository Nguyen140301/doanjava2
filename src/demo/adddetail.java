package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import entities.Details;
import entities.User;
import models.DetailsModel;
import models.UserModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adddetail extends JFrame {

	private JPanel contentPane;
	private JTextField idbook;
	private JTextField isbn;
	private JTextField author;
	private JTextField nameuser;
	private JTextField callnumber;
	private JTextField title;
	private JTextField iduser;
	private JTextField status;
	private JDateChooser duedate;
	private JLabel avda;
	private JDateChooser checkoutdate;
	private JButton cancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adddetail frame = new adddetail();
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
	public adddetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("details");
		lblNewLabel.setBounds(363, 26, 206, 27);
		contentPane.add(lblNewLabel);
		
		JLabel asd = new JLabel("id_book");
		asd.setBounds(27, 73, 79, 27);
		contentPane.add(asd);
		
		JLabel sad = new JLabel("isbn");
		sad.setBounds(27, 126, 97, 27);
		contentPane.add(sad);
		
		JLabel dsf = new JLabel("author");
		dsf.setBounds(27, 183, 114, 27);
		contentPane.add(dsf);
		
		JLabel asddsv = new JLabel("name_user");
		asddsv.setBounds(27, 235, 114, 27);
		contentPane.add(asddsv);
		
		JLabel asdasfv = new JLabel("due_date");
		asdasfv.setBounds(27, 288, 97, 27);
		contentPane.add(asdasfv);
		
		JLabel vadv = new JLabel("status");
		vadv.setBounds(400, 309, 114, 27);
		contentPane.add(vadv);
		
		avda = new JLabel("check_out_date");
		avda.setBounds(408, 254, 143, 27);
		contentPane.add(avda);
		
		JLabel asfvd = new JLabel("callnumber");
		asfvd.setBounds(408, 80, 107, 27);
		contentPane.add(asfvd);
		
		JLabel asfvvd = new JLabel("title");
		asfvvd.setBounds(408, 133, 89, 27);
		contentPane.add(asfvvd);
		
		JLabel avad = new JLabel("id_user");
		avad.setBounds(408, 194, 89, 27);
		contentPane.add(avad);
		
		idbook = new JTextField();
		idbook.setBounds(105, 77, 96, 19);
		contentPane.add(idbook);
		idbook.setColumns(10);
		
		isbn = new JTextField();
		isbn.setColumns(10);
		isbn.setBounds(105, 130, 96, 19);
		contentPane.add(isbn);
		
		author = new JTextField();
		author.setColumns(10);
		author.setBounds(105, 187, 96, 19);
		contentPane.add(author);
		
		nameuser = new JTextField();
		nameuser.setColumns(10);
		nameuser.setBounds(105, 239, 96, 19);
		contentPane.add(nameuser);
		
		callnumber = new JTextField();
		callnumber.setColumns(10);
		callnumber.setBounds(498, 84, 96, 19);
		contentPane.add(callnumber);
		
		title = new JTextField();
		title.setColumns(10);
		title.setBounds(498, 137, 96, 19);
		contentPane.add(title);
		
		iduser = new JTextField();
		iduser.setColumns(10);
		iduser.setBounds(483, 198, 96, 19);
		contentPane.add(iduser);
		
		status = new JTextField();
		status.setColumns(10);
		status.setBounds(473, 313, 96, 19);
		contentPane.add(status);
		
		duedate = new JDateChooser();
		duedate.setBounds(105, 296, 73, 19);
		contentPane.add(duedate);
		
		checkoutdate = new JDateChooser();
		checkoutdate.setBounds(521, 254, 73, 19);
		contentPane.add(checkoutdate);
		
		JButton save = new JButton("save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save_actionPerformed(e);
			}
		});
		save.setBounds(93, 420, 85, 21);
		contentPane.add(save);
		
		cancel = new JButton("cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel_actionPerformed(e);
			}
		});
		cancel.setBounds(443, 420, 85, 21);
		contentPane.add(cancel);
	}
	protected void save_actionPerformed(ActionEvent e) {
		try {
			DetailsModel detailsModel = new DetailsModel();
			Details details = new Details();
			details.setId_book(Integer.parseInt(idbook.getText()));
			details.setIsbn(isbn.getText());
			details.setAuthor(author.getText());
			details.setName_user(nameuser.getText());
			details.setDue_date(duedate.getDate());
			details.setCallnumber(callnumber.getText());
			details.setTitle(title.getText());
			details.setId_user(Integer.parseInt(iduser.getText()));
			details.setCheck_out_date(checkoutdate.getDate());
			details.setIssue_status(status.getText());
			if (detailsModel.create(details)) {
				JOptionPane.showMessageDialog(null, "Success");
				details tt = new details();
				tt.setVisible(true);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
	protected void cancel_actionPerformed(ActionEvent e) {
		cancel.setVisible(true);
		this.setVisible(false);
	}
}
