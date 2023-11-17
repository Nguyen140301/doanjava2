package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import entities.Book;
import entities.Details;
import entities.User;
import models.BookModel;
import models.DetailsModel;
import models.UserModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class adddetail extends JFrame {

	private JPanel contentPane;
	private JTextField idbook;
	private JTextField author;
	private JTextField nameuser;
	private JTextField title;
	private JTextField iduser;
	private JTextField status;
	private JLabel avda;
	private JDateChooser checkoutdate;
	private JButton cancel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private Book book;
	private User user;
	
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
		setTitle("Add Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 512);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Details");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(27, 26, 684, 27);
		contentPane.add(lblNewLabel);
		
		JLabel asd = new JLabel("Id book");
		asd.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		asd.setBounds(76, 133, 60, 27);
		contentPane.add(asd);
		
		JLabel dsf = new JLabel("Author");
		dsf.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		dsf.setBounds(76, 246, 60, 27);
		contentPane.add(dsf);
		
		JLabel asddsv = new JLabel("Username");
		asddsv.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		asddsv.setBounds(433, 183, 89, 27);
		contentPane.add(asddsv);
		
		JLabel vadv = new JLabel("Status");
		vadv.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		vadv.setBounds(76, 309, 89, 27);
		contentPane.add(vadv);
		
		avda = new JLabel("Check out date");
		avda.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		avda.setBounds(433, 301, 102, 27);
		contentPane.add(avda);
		
		JLabel asfvvd = new JLabel("Title");
		asfvvd.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		asfvvd.setBounds(76, 183, 89, 27);
		contentPane.add(asfvvd);
		
		JLabel avad = new JLabel("Id user");
		avad.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		avad.setBounds(433, 133, 89, 27);
		contentPane.add(avad);
		
		idbook = new JTextField();
		idbook.addKeyListener(new KeyAdapter() {

			
			@Override
			public void keyReleased(KeyEvent e) {
				idbook_keyReleased(e);
			}
		});
		idbook.setBorder(new LineBorder(new Color(192, 192, 192)));
		idbook.setAutoscrolls(false);
		idbook.setBackground(new Color(192, 192, 192));
		idbook.setBounds(178, 133, 96, 19);
		contentPane.add(idbook);
		idbook.setColumns(10);
		
		author = new JTextField();
		author.setBorder(new LineBorder(new Color(192, 192, 192)));
		author.setBackground(new Color(192, 192, 192));
		author.setColumns(10);
		author.setBounds(178, 246, 96, 19);
		contentPane.add(author);
		
		nameuser = new JTextField();
		nameuser.setBorder(new LineBorder(new Color(192, 192, 192)));
		nameuser.setBackground(new Color(192, 192, 192));
		nameuser.setColumns(10);
		nameuser.setBounds(515, 183, 96, 19);
		contentPane.add(nameuser);
		
		title = new JTextField();
		title.setBorder(new LineBorder(new Color(192, 192, 192)));
		title.setBackground(new Color(192, 192, 192));
		title.setColumns(10);
		title.setBounds(178, 189, 96, 19);
		contentPane.add(title);
		
		iduser = new JTextField();
		iduser.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				iduser_keyReleased(e);
			}
		});
		iduser.setBorder(new LineBorder(new Color(192, 192, 192)));
		iduser.setBackground(new Color(192, 192, 192));
		iduser.setColumns(10);
		iduser.setBounds(515, 133, 96, 19);
		contentPane.add(iduser);
		
		status = new JTextField();
		status.setBackground(new Color(192, 192, 192));
		status.setBorder(new LineBorder(new Color(192, 192, 192)));
		status.setColumns(10);
		status.setBounds(178, 309, 96, 19);
		contentPane.add(status);
		
		checkoutdate = new JDateChooser();
		checkoutdate.setBackground(new Color(192, 192, 192));
		checkoutdate.setBorder(new LineBorder(new Color(192, 192, 192)));
		checkoutdate.setBounds(564, 301, 110, 27);
		contentPane.add(checkoutdate);
		
		JButton save = new JButton("Save");
		save.setBackground(new Color(225, 225, 225));
		save.setFont(new Font("Tahoma", Font.PLAIN, 20));
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save_actionPerformed(e);
			}
		});
		save.setBounds(486, 357, 96, 35);
		contentPane.add(save);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(new Color(225, 225, 225));
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel_actionPerformed(e);
			}
		});
		cancel.setBounds(486, 403, 96, 34);
		contentPane.add(cancel);
		
		JLabel lblNewLabel_1 = new JLabel("______________");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(177, 141, 110, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("______________");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(175, 199, 110, 19);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("______________");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(175, 254, 110, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("______________");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(175, 315, 110, 19);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("______________");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(513, 139, 110, 19);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("______________");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(515, 189, 110, 19);
		contentPane.add(lblNewLabel_6);
	}
	protected void save_actionPerformed(ActionEvent e) {
		try {
			DetailsModel detailsModel = new DetailsModel();
			Details details = new Details();
			details.setId_book(Integer.parseInt(idbook.getText()));
			details.setAuthor(book.getAuthor());
			details.setName_user(user.getName());
			details.setTitle(book.getTitle());
			details.setId_user(Integer.parseInt(iduser.getText()));
			details.setCheck_out_date(checkoutdate.getDate());
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(checkoutdate.getDate());
			calendar.add(Calendar.DAY_OF_MONTH, 5);
			Date d = calendar.getTime();
			details.setDue_date(d);
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
	
	
	protected void idbook_keyReleased(KeyEvent e) {
		int id = Integer.parseInt(idbook.getText());
		BookModel bookModel = new BookModel();
		book = bookModel.findIdBook(id);
		title.setText(book.getTitle());
		author.setText(book.getAuthor());
	}
	protected void iduser_keyReleased(KeyEvent e) {
		int id = Integer.parseInt(iduser.getText());
		UserModel userModel = new UserModel();
		user = userModel.findIdUser(id);
		nameuser.setText(user.getName());
	}
}
