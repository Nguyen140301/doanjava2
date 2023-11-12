package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class home extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private Map<String, Object> data=new HashMap<String, Object>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1102, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(5, 5, 254, 651);
		panel.setBackground(new Color(54, 33, 89));
		contentPane.add(panel);
		panel.setLayout(null);

		JButton details = new JButton("       +          Details");
		details.setFocusPainted(false);
		details.setHorizontalAlignment(SwingConstants.LEFT);
		details.setBackground(new Color(85, 65, 118));
		details.setBounds(0, 272, 254, 44);
		details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				details_actionPerformed(e);
			}
		});

		details.setForeground(new Color(192, 192, 192));
		details.setFont(new Font("Tahoma", Font.PLAIN, 15));
		details.setBorderPainted(false);
		panel.add(details);

		JButton Exit = new JButton("     +          Exit");
		Exit.setFocusPainted(false);
		Exit.setHorizontalAlignment(SwingConstants.LEFT);
		Exit.setBorderPainted(false);
		Exit.setBounds(0, 515, 254, 44);
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exit_actionPerformed(e);
			}
		});

		Exit.setBackground(new Color(85, 65, 118));
		Exit.setForeground(new Color(0, 0, 0));
		Exit.setFont(new Font("Tahoma", Font.PLAIN, 15));

		
		JButton book = new JButton("book");
		panel.add(book);
		Exit.setContentAreaFilled(false);
		Exit.setBorderPainted(false);
		Exit.setBackground(Color.GRAY);
		Exit.setForeground(Color.GREEN);
		Exit.setFont(new Font("Tahoma", Font.PLAIN, 20));

		panel.add(Exit);
		
		JButton btnBook = new JButton("       +          Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBook_actionPerformed(e);
			}
		});
		btnBook.setFocusPainted(false);
		btnBook.setHorizontalAlignment(SwingConstants.LEFT);
		btnBook.setBackground(new Color(85, 65, 118));
		btnBook.setForeground(new Color(192, 192, 192));
		btnBook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBook.setBorderPainted(false);
		btnBook.setBounds(0, 398, 254, 44);
		panel.add(btnBook);
		
				JButton in4 = new JButton("    Information users");
				in4.setFocusPainted(false);
				in4.setIcon(new ImageIcon(home.class.getResource("/asb/uq.png")));
				in4.setBorderPainted(false);
				in4.setBounds(0, 149, 254, 44);
				panel.add(in4);
				in4.setAutoscrolls(true);
				in4.setBorder(new LineBorder(new Color(255, 255, 0)));
				in4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						in4_actionPerformed(e);
					}
				});
				
						in4.setBackground(new Color(85, 65, 118));
						in4.setForeground(new Color(192, 192, 192));
						in4.setFont(new Font("Tahoma", Font.PLAIN, 15));
						
						JButton btnHome = new JButton("   Home");
						btnHome.setFocusPainted(false);
						btnHome.setIcon(new ImageIcon(home.class.getResource("/asb/h2.png")));
						btnHome.setForeground(new Color(158, 158, 158));
						btnHome.setFont(new Font("Tahoma", Font.PLAIN, 35));
						btnHome.setBorderPainted(false);
						btnHome.setBorder(new LineBorder(new Color(255, 255, 0)));
						btnHome.setBackground(new Color(54, 34, 99));
						btnHome.setAutoscrolls(true);
						btnHome.setBounds(0, 0, 254, 149);
						panel.add(btnHome);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(259, 5, 827, 651);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(122, 72, 221));
		panel_3.setBounds(0, 0, 825, 56);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Libary");
		lblNewLabel_1.setForeground(new Color(192, 192, 192));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(10, 11, 805, 31);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(home.class.getResource("/asb/tv.jpg")));
		lblNewLabel.setBounds(0, 54, 825, 595);
		panel_2.add(lblNewLabel);
	}






	protected void Exit_actionPerformed(ActionEvent e) {
		login dn = new login();
		dn.setVisible(true);
		this.setVisible(false);
	}

	protected void in4_actionPerformed(ActionEvent e) {
		in4 tt = new in4(data);
		panel_1.removeAll();
		panel_1.revalidate();
		panel_1.add(tt);
		panel_1.setVisible(true);
	}
	protected void details_actionPerformed(ActionEvent e) {
		details a = new details(data);
		panel_1.removeAll();
		panel_1.revalidate();
		panel_1.add(a);
		panel_1.setVisible(true);
	}

	protected void do_btnBook_actionPerformed(ActionEvent e) {
		book book = new book();
		panel_1.removeAll();
		panel_1.revalidate();
		panel_1.add(book);
		panel_1.setVisible(true);
	}
}