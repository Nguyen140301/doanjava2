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
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class home extends JFrame {

	private JPanel contentPane;
	private Map<String, Object> data=new HashMap<String, Object>();
	private JPanel tab1;
	private JPanel tab2;
	private JPanel panel2;
	private JPanel pane1;

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
		setBounds(100, 100, 975, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 260, 583);
		panel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.setBackground(new Color(0, 128, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		tab1 = new JPanel();
		tab1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_tab1_mouseClicked(e);
			}
		});
		tab1.setBackground(new Color(198, 226, 255));
		tab1.setBorder(new LineBorder(new Color(0, 0, 0)));
		tab1.setBounds(0, 145, 260, 49);
		panel.add(tab1);
		tab1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Imformation Account");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 6, 230, 32);
		tab1.add(lblNewLabel);
		
		tab2 = new JPanel();
		tab2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_tab2_mouseClicked(e);
			}
		});
		tab2.setBackground(new Color(198, 226, 255));
		tab2.setBorder(new LineBorder(new Color(0, 0, 0)));
		tab2.setBounds(0, 217, 260, 49);
		panel.add(tab2);
		tab2.setLayout(null);
		
		JLabel lblRequest = new JLabel("Request");
		lblRequest.setHorizontalAlignment(SwingConstants.CENTER);
		lblRequest.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblRequest.setBounds(10, 11, 230, 32);
		tab2.add(lblRequest);
		
		JPanel tab3 = new JPanel();
		tab3.setBackground(new Color(198, 226, 255));
		tab3.setBorder(new LineBorder(new Color(0, 0, 0)));
		tab3.setBounds(0, 291, 260, 49);
		panel.add(tab3);
		tab3.setLayout(null);
		
		JLabel lblExit = new JLabel("Exit");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblExit.setBounds(10, 11, 230, 32);
		tab3.add(lblExit);
		
		JPanel tab4 = new JPanel();
		tab4.setBackground(new Color(198, 226, 255));
		tab4.setBorder(new LineBorder(new Color(0, 0, 0)));
		tab4.setBounds(0, 367, 260, 49);
		panel.add(tab4);
		tab4.setLayout(null);
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblUpdate.setBounds(10, 11, 230, 32);
		tab4.add(lblUpdate);
		
		JLabel lblNewLabel_1 = new JLabel("Library");
		lblNewLabel_1.setForeground(new Color(218, 218, 218));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1.setBounds(56, 39, 140, 49);
		panel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(56, 99, 140, 14);
		panel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(259, 0, 700, 583);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		pane1 = new JPanel();
		pane1.setBackground(new Color(0, 255, 0));
		pane1.setBounds(0, 0, 700, 583);
		panel_1.add(pane1);
		
		panel2 = new JPanel();
		panel2.setBackground(new Color(0, 0, 255));
		panel2.setBounds(0, 0, 700, 583);
		panel_1.add(panel2);
	}
	protected void do_tab1_mouseClicked(MouseEvent e) {
		pane1.setVisible(true);
		panel2.setVisible(false);
	}
	protected void do_tab2_mouseClicked(MouseEvent e) {
		panel2.setVisible(true);
		pane1.setVisible(false);
	}
}
