package Capstone;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Capstone.MenuPage;

@SuppressWarnings("serial")
public class MenuPage extends JFrame {

	private JPanel contentPane;
	public static MenuPage frame;
	String purpose = null;
	public static String fName, lName, oRg;
	public static String ctz = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MenuPage();
					frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame for the Menu Page.
	 */
	public MenuPage() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1194, 834);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		fName = (NamePg.gettfFName());
		lName = (NamePg.gettfLName());
		oRg = (NamePg.getTfOrganization());
		ctz = (NamePg.getCitizen());

		// Button to open the interview
		JButton btnInterview = new JButton("");
		btnInterview.setFocusable(false);
		btnInterview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				purpose = "I";
				dispose();
				fInter intpage = new fInter();
				intpage.setExtendedState(intpage.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				intpage.setVisible(true);
			}
		});
		btnInterview.setBorderPainted(false);
		ImageIcon icon1 = new ImageIcon("C:\\Users\\KCStone\\eclipse-workspace\\Capstone\\src\\images\\interview2.png");
		Image scale1 = icon1.getImage().getScaledInstance(200, 180, Image.SCALE_DEFAULT);
		btnInterview.setIcon(new ImageIcon(scale1));
		btnInterview.setForeground(new Color(0, 0, 153));
		btnInterview.setBackground(Color.WHITE);
		btnInterview.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInterview.setBounds(143, 194, 239, 225);

		JButton btnExit = new JButton("");
		ImageIcon icon5 = new ImageIcon("C:\\Users\\KCStone\\eclipse-workspace\\Capstone\\src\\images\\warehouse.png");
		Image scale5 = icon5.getImage().getScaledInstance(230, 180, Image.SCALE_DEFAULT);
		btnExit.setFocusable(false);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				fWhse whse = new fWhse();
				whse.setExtendedState(whse.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				whse.setVisible(true);
			}
		});
		btnExit.setBorderPainted(false);
		btnExit.setIcon(new ImageIcon(scale5));
		btnExit.setBackground(Color.WHITE);
		btnExit.setForeground(new Color(0, 153, 153));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(301, 457, 239, 224);

		JButton btnMeeting = new JButton("");
		ImageIcon icon2 = new ImageIcon("C:\\Users\\KCStone\\eclipse-workspace\\Capstone\\src\\images\\meeting.png");
		Image scale2 = icon2.getImage().getScaledInstance(200, 180, Image.SCALE_DEFAULT);
		btnMeeting.setFocusable(false);
		btnMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				purpose = "M";
				Capstone.model.add(purpose);
				//Data check to ensure data is received
//				String m = "The Purpose is code: " + purpose;
//				JOptionPane.showMessageDialog(null, m);
				dispose();
				fMeet fM = new fMeet();
				fM.setExtendedState(fM.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				fM.setVisible(true);

			}
		});
		btnMeeting.setBorderPainted(false);
		btnMeeting.setBackground(Color.WHITE);
		btnMeeting.setIcon(new ImageIcon(scale2));
		btnMeeting.setBounds(493, 194, 239, 225);
		ImageIcon icon3 = new ImageIcon("C:\\Users\\KCStone\\eclipse-workspace\\Capstone\\src\\images\\exit.png");
		Image scale3 = icon3.getImage().getScaledInstance(210, 180, Image.SCALE_DEFAULT);

		JButton btnContractor = new JButton("");
		ImageIcon icon4 = new ImageIcon("C:\\Users\\KCStone\\eclipse-workspace\\Capstone\\src\\images\\contractor.png");
		Image scale4 = icon4.getImage().getScaledInstance(220, 180, Image.SCALE_DEFAULT);
		btnContractor.setFocusable(false);
		btnContractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				purpose = "C";
				Capstone.model.add(purpose);
				dispose();
				fCont contract = new fCont();
				contract.setExtendedState(contract.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				contract.setVisible(true);
			}
		});
		btnContractor.setBorderPainted(false);
		btnContractor.setBackground(Color.WHITE);
		btnContractor.setIcon(new ImageIcon(scale4));
		btnContractor.setBounds(867, 194, 239, 225);

		JLabel lblNaumai = new JLabel("Nau-Mai");
		lblNaumai.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaumai.setForeground(new Color(0, 0, 102));
		lblNaumai.setFont(new Font("Century Gothic", Font.BOLD, 48));
		lblNaumai.setBounds(504, 10, 228, 77);
		contentPane.add(lblNaumai, BorderLayout.NORTH);

		JLabel lblMenu = new JLabel("What is the purpose of your visit?");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setForeground(new Color(0, 0, 102));
		lblMenu.setFont(new Font("Century Gothic", Font.BOLD, 48));
		lblMenu.setBounds(504, 10, 228, 77);

		Box hBox_Title = Box.createHorizontalBox();
		hBox_Title.add(lblMenu);
		hBox_Title.setBorder(new EmptyBorder(25, 25, 25, 25));

		Box hBox_TopRow = Box.createHorizontalBox();
		hBox_TopRow.add(btnInterview);
		hBox_TopRow.add(btnMeeting);
		hBox_TopRow.add(btnContractor);
		hBox_TopRow.setBorder(new EmptyBorder(25, 25, 25, 25));

		Box hBox_MidRow = Box.createHorizontalBox();
		hBox_MidRow.add(btnExit);
		hBox_MidRow.setBorder(new EmptyBorder(25, 25, 25, 25));

		Box vBox_column = Box.createVerticalBox();
		contentPane.add(vBox_column, BorderLayout.CENTER);
		vBox_column.add(hBox_Title);
		vBox_column.add(hBox_TopRow);
		vBox_column.add(hBox_MidRow);
		
				JButton btnWhse = new JButton("");
				btnWhse.setFocusable(false);
				btnWhse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						purpose = "W";
						Capstone.model.add(purpose);
						dispose();
						fWhse checkout = new fWhse();
						checkout.setExtendedState(checkout.getExtendedState() | JFrame.MAXIMIZED_BOTH);
						checkout.setVisible(true);
					}
				});
				btnWhse.setBorderPainted(false);
				btnWhse.setBackground(Color.WHITE);
				btnWhse.setIcon(new ImageIcon(scale3));
				btnWhse.setBounds(694, 454, 228, 227);
				hBox_MidRow.add(btnWhse);
		vBox_column.setBorder(new EmptyBorder(25, 25, 25, 25));

	}

}
