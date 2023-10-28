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

public class home extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private JButton xemyc;
	private Map<String, Object> data=new HashMap<String, Object>();
	private JButton btnNewButton;

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
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton in4 = new JButton("Information account");
		
		in4.setBackground(Color.RED);
		in4.setForeground(new Color(34, 57, 100));
		in4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		in4.setContentAreaFilled(false);
		in4.setBorderPainted(false);
		panel.add(in4);
		
		JButton request = new JButton("Request");
		
		request.setForeground(Color.RED);
		request.setFont(new Font("Tahoma", Font.PLAIN, 20));
		request.setContentAreaFilled(false);
		request.setBorderPainted(false);
		panel.add(request);
		
		xemyc = new JButton("xem yeu cau");
		
		xemyc.setBorderPainted(false);
		xemyc.setBackground(Color.GRAY);
		xemyc.setForeground(Color.YELLOW);
		xemyc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(xemyc);
		
		JButton Exit = new JButton("Exit");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exit_actionPerformed(e);
			}
		});
		Exit.setContentAreaFilled(false);
		Exit.setBorderPainted(false);
		Exit.setBackground(Color.GRAY);
		Exit.setForeground(Color.GREEN);
		Exit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(Exit);
		
		btnNewButton = new JButton("Update");
		
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btnNewButton);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
	}
	
	

	
	
	
	protected void Exit_actionPerformed(ActionEvent e) {
		login dn = new login();
		dn.setVisible(true);
		this.setVisible(false);
	}
	
}
