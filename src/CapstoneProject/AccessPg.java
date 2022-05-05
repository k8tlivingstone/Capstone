package CapstoneProject;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import Admin.AdminPg;

import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class AccessPg extends JFrame {

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	ResultSet rs = null;
	Statement st;
	java.sql.ConnectionBuilder conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessPg window = new AccessPg();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	/**
	 * Create the application.
	 */
//	public AccessPg() {
//		initialize();
//		connection=dB_Connection.dbConnection();
//		JOptionPane.showMessageDialog(null, "Connection Success");
//	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 153));
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 12));
		frame.setBounds(200, 200, 596, 359);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUserName.setBounds(177, 126, 214, 32);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setFocusable(false);
		btnSignIn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSignIn.setForeground(new Color(0, 153, 153));
		btnSignIn.setBackground(new Color(253, 245, 230));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				String password = txtPassword.getText();
				String username = txtUserName.getText().toUpperCase(); 				
				
				try {
					
					/*Need to add database connection here */
					if(username!=null || password!="") {
						if(password.contains("nimda") && username.contains("ADMIN")) {
							frame.dispose();
							AdminPg adminPg = new AdminPg();
							adminPg.setVisible(true);
						} else {
							Validation.setWarningMsg("Username and Password does not match our records. Try Again!");
							txtPassword.setText("");
							txtUserName.setText("");
						}
					} else {
						Validation.setWarningMsg("Please fill in your username and password. Try Again!");
					}
					
						
						
					} catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Enter a valid username and password\n or select Forgot Password");
						txtPassword.setText(null);
						txtUserName.setText(null);
				}
			}
		});
		btnSignIn.setFont(new Font("Calibri", Font.BOLD, 20));
		btnSignIn.setBounds(225, 247, 116, 46);
		frame.getContentPane().add(btnSignIn);
		
		JLabel lblLoginTitle = new JLabel("Operations Price Estimator");
		lblLoginTitle.setForeground(new Color(255, 255, 255));
		lblLoginTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblLoginTitle.setBounds(159, 54, 281, 32);
		frame.getContentPane().add(lblLoginTitle);
		
		JLabel lbUserName = new JLabel("Username");
		lbUserName.setForeground(new Color(255, 255, 255));
		lbUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbUserName.setBounds(110, 130, 61, 23);
		frame.getContentPane().add(lbUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(110, 173, 61, 23);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPassword.setBounds(177, 169, 214, 32);
		frame.getContentPane().add(txtPassword);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(254, 97, 74, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\klivingstone\\eclipse-workspace\\CapstoneProject\\images\\logo2.png"));
		lblNewLabel_1.setBounds(238, 11, 103, 46);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnForget = new JButton("Forgot Password");
		btnForget.setFocusable(false);
		btnForget.setBackground(new Color(0, 153, 153));
		btnForget.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnForget.setForeground(new Color(253, 245, 230));
		btnForget.setFont(new Font("Century Gothic", Font.BOLD, 10));
		btnForget.setBounds(176, 203, 89, 23);
		frame.getContentPane().add(btnForget);
	}

}
