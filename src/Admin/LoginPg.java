package Admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import CapstoneProject.Validation;

import javax.swing.SwingConstants;
import java.awt.Component;

public class LoginPg extends JFrame {
//	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	public static LoginPg frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginPg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 749, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/************** Buttons Section **************/
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSignIn.setFocusable(false);
		btnSignIn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSignIn.setForeground(new Color(0, 153, 153));
		btnSignIn.setBackground(new Color(253, 245, 230));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				String password = txtPassword.getText();
				String username = txtUserName.getText().toUpperCase();

				try {

					if (username != null || password != "") {
						if (password.contains("nimda") && username.contains("ADMIN")) {
							dispose();
//							CapstoneProject.frame.dispose();
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

				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Enter a valid username and password\n or select Forgot Password");
					txtPassword.setText(null);
					txtUserName.setText(null);
				}
			}
		});
		btnSignIn.setFont(new Font("Calibri", Font.BOLD, 20));
		btnSignIn.setBounds(295, 285, 116, 46);
		contentPane.add(btnSignIn);

		JButton btnForget = new JButton("Forgot Password");
		btnForget.setFocusable(false);
		btnForget.setBackground(new Color(0, 153, 153));
		btnForget.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnForget.setForeground(new Color(253, 245, 230));
		btnForget.setFont(new Font("Century Gothic", Font.BOLD, 10));
		btnForget.setBounds(252, 239, 89, 23);
		contentPane.add(btnForget);

		/************** Labels Section **************/
		JLabel lblLoginTitle = new JLabel("Nau-Mai Administrative Section");
		lblLoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginTitle.setForeground(new Color(255, 255, 255));
		lblLoginTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblLoginTitle.setBounds(87, 90, 539, 32);
		contentPane.add(lblLoginTitle);

		JLabel lbUserName = new JLabel("Username");
		lbUserName.setForeground(new Color(255, 255, 255));
		lbUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbUserName.setBounds(186, 166, 61, 23);
		contentPane.add(lbUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(186, 209, 61, 23);
		contentPane.add(lblPassword);

		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(202, 133, 310, 18);
		contentPane.add(lblNewLabel);

		// Logo image resized to fit size label size for screen
		ImageIcon icon1 = new ImageIcon(
				"C:\\\\Users\\\\klivingstone\\\\eclipse-workspace\\\\CapstoneProject\\\\images\\\\logo2.png");
		Image scale1 = icon1.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT);
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(scale1));
		lblNewLabel_1.setBounds(308, 10, 103, 80);
		contentPane.add(lblNewLabel_1);

		/************** Textfields Section **************/
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUserName.setBounds(253, 162, 214, 32);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		/************** Password fields **************/
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPassword.setBounds(253, 205, 214, 32);
		contentPane.add(txtPassword);

	}

} // End of LoginPg Class
