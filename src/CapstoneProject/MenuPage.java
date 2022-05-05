package CapstoneProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.Box;
import java.awt.Rectangle;

public class MenuPage extends JFrame {

	private JPanel contentPane;
	public static MenuPage frame;
	String purpose = null;
	static Validation val = new Validation();
	static CapstoneProject cp = new CapstoneProject();	
	
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
		ImageIcon icon1 = new ImageIcon("C:\\Users\\klivingstone\\eclipse-workspace\\CapstoneProject\\images\\interview2.png");
		Image scale1 = icon1.getImage().getScaledInstance(200, 180,Image.SCALE_DEFAULT);
		btnInterview.setIcon(new ImageIcon(scale1));
		btnInterview.setForeground(new Color(0, 0, 153));
		btnInterview.setBackground(Color.WHITE);
		btnInterview.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInterview.setBounds(143, 194, 239, 225);
//		contentPane.add(btnInterview);
		
		JButton btnExit = new JButton("");
		ImageIcon icon5 = new ImageIcon("C:\\Users\\klivingstone\\eclipse-workspace\\CapstoneProject\\images\\warehouse.png");
		Image scale5 = icon5.getImage().getScaledInstance(230, 180,Image.SCALE_DEFAULT);
		btnExit.setFocusable(false);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
//				WhsePage whse = new WhsePage();
//				whse.setExtendedState(whse.getExtendedState() | JFrame.MAXIMIZED_BOTH);
//				whse.setVisible(true);
			}
		});
		btnExit.setBorderPainted(false);
		btnExit.setIcon(new ImageIcon(scale5));
		btnExit.setBackground(Color.WHITE);
		btnExit.setForeground(new Color(0, 153, 153));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(301, 457, 239, 224);
//		contentPane.add(btnExit);
		
		JButton btnMeeting = new JButton("");
		ImageIcon icon2 = new ImageIcon("C:\\Users\\klivingstone\\eclipse-workspace\\CapstoneProject\\images\\meeting.png");
		Image scale2 = icon2.getImage().getScaledInstance(200, 180,Image.SCALE_DEFAULT);
		btnMeeting.setFocusable(false);
		btnMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				purpose = "M";
				cp.model.add(purpose);
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
//		contentPane.add(btnMeeting);
		
		JButton btnWhse = new JButton("");
		ImageIcon icon3 = new ImageIcon("C:\\Users\\klivingstone\\eclipse-workspace\\CapstoneProject\\images\\exit.png");
		Image scale3 = icon3.getImage().getScaledInstance(210, 180,Image.SCALE_DEFAULT);
		btnWhse.setFocusable(false);
		btnWhse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				purpose = "W";
				cp.model.add(purpose);
				dispose();
//				CheckoutPage checkout = new CheckoutPage();
//				checkout.setExtendedState(checkout.getExtendedState() | JFrame.MAXIMIZED_BOTH);
//				checkout.setVisible(true);
			}
		});
		btnWhse.setBorderPainted(false);
		btnWhse.setBackground(Color.WHITE);
		btnWhse.setIcon(new ImageIcon(scale3));
		btnWhse.setBounds(694, 454, 228, 227);
//		contentPane.add(btnWhse);
		
		JButton btnContractor = new JButton("");
		ImageIcon icon4 = new ImageIcon("C:\\Users\\klivingstone\\eclipse-workspace\\CapstoneProject\\images\\contractor.png");
		Image scale4 = icon4.getImage().getScaledInstance(220, 180,Image.SCALE_DEFAULT);
		btnContractor.setFocusable(false);
		btnContractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				purpose = "C";
				cp.model.add(purpose);
				dispose();
//				ContractorPage contract = new ContractorPage();
//				contract.setExtendedState(contract.getExtendedState() | JFrame.MAXIMIZED_BOTH);
//				contract.setVisible(true);
			}
		});
		btnContractor.setBorderPainted(false);
		btnContractor.setBackground(Color.WHITE);
		btnContractor.setIcon(new ImageIcon(scale4));
		btnContractor.setBounds(867, 194, 239, 225);
//		contentPane.add(btnContractor);
		
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
		hBox_MidRow.add(btnWhse);
		hBox_MidRow.add(btnExit);
		hBox_MidRow.setBorder(new EmptyBorder(25, 25, 25, 25));
		
		Box vBox_column = Box.createVerticalBox();
		contentPane.add(vBox_column, BorderLayout.CENTER);
		vBox_column.add(hBox_Title);
		vBox_column.add(hBox_TopRow);
		vBox_column.add(hBox_MidRow);
		vBox_column.setBorder(new EmptyBorder(25, 25, 25, 25));
         
	}

}
