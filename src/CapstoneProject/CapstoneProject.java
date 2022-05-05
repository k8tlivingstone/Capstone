package CapstoneProject;

import java.awt.EventQueue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import static java.awt.Frame.MAXIMIZED_BOTH;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import Admin.LoginPg;

import java.awt.Rectangle;
import java.awt.Dimension;

public class CapstoneProject {

	// Opening screen for Visitor management application
	public static JFrame frame;
	protected static List<String> model = new ArrayList<String>();;

	/**
	 * Launch the Visitor Management System application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapstoneProject window = new CapstoneProject();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CapstoneProject() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		GraphicsEnvironment env =
				GraphicsEnvironment.getLocalGraphicsEnvironment();
		frame = new JFrame();
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setFocusable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1194, 834);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		// Button to open menu screen
				JButton btnStart = new JButton("TAP HERE TO BEGIN");
				btnStart.setAlignmentX(Component.CENTER_ALIGNMENT);
				btnStart.setBounds(new Rectangle(30, 50, 1500, 50));
				btnStart.setFocusable(false);
				btnStart.setHorizontalAlignment(SwingConstants.CENTER);
				btnStart.setBorder(new EmptyBorder(30, 75, 30, 75));
				btnStart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						MenuPage menu = new MenuPage();
						menu.setExtendedState(menu.getExtendedState() | JFrame.MAXIMIZED_BOTH);
						menu.setVisible(true);
					}
				});
				btnStart.setBorderPainted(false);
				btnStart.setForeground(SystemColor.info);
				btnStart.setBackground(new Color(0, 0, 102));
				btnStart.setFont(new Font("Tahoma", Font.BOLD, 24));
				btnStart.setBounds(324, 368, 541, 71);
				
				// Welcome Title Message
				JLabel lblProdTitle = new JLabel("Welcome Visitors");
				lblProdTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
				lblProdTitle.setHorizontalAlignment(SwingConstants.CENTER);
				lblProdTitle.setForeground(new Color(0, 0, 102));
				lblProdTitle.setFont(new Font("Arial Black", Font.BOLD, 72));
				lblProdTitle.setBounds(205, 206, 739, 93);
				
				// Brand Name
				JLabel lblNaumai = new JLabel("Nau-Mai");
				lblNaumai.setHorizontalAlignment(SwingConstants.CENTER);
				lblNaumai.setForeground(Color.BLACK);
				lblNaumai.setFont(new Font("Century Gothic", Font.BOLD, 60));
				lblNaumai.setBounds(452, 49, 274, 93);
				lblNaumai.setHorizontalAlignment(SwingConstants.CENTER);
				frame.getContentPane().add(lblNaumai);
				frame.getContentPane().add(lblNaumai, BorderLayout.NORTH);
				
				// Logo Button
				ImageIcon icon = new ImageIcon("C:\\Users\\klivingstone\\eclipse-workspace\\CapstoneProject\\images\\logo2.png");
				Image scaleImage = icon.getImage().getScaledInstance(90, 90,Image.SCALE_DEFAULT);
				JButton btnAdminArea = new JButton("");
				btnAdminArea.setHorizontalAlignment(SwingConstants.LEFT);
				btnAdminArea.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//opens the login window
						frame.dispose();
						LoginPg loginpg = new LoginPg();
						loginpg.setVisible(true);		
					}
				});
				btnAdminArea.setBorder(null);
				btnAdminArea.setBackground(Color.WHITE);
				btnAdminArea.setIcon(new ImageIcon(scaleImage));
				btnAdminArea.setBounds(26, 658, 103, 98);
				frame.getContentPane().add(btnAdminArea);
				frame.getContentPane().add(btnAdminArea, BorderLayout.SOUTH);
				
				Box vBox_center = Box.createVerticalBox();
				frame.getContentPane().add(vBox_center, BorderLayout.CENTER);
				
				Component verticalStrut_1 = Box.createVerticalStrut(20);
				verticalStrut_1.setMaximumSize(new Dimension(32767, 100));
				verticalStrut_1.setMinimumSize(new Dimension(0, 100));
				verticalStrut_1.setPreferredSize(new Dimension(0, 100));
				vBox_center.add(verticalStrut_1);
				vBox_center.add(lblProdTitle);
				
				Component verticalStrut = Box.createVerticalStrut(20);
				verticalStrut.setMaximumSize(new Dimension(32767, 100));
				verticalStrut.setPreferredSize(new Dimension(0, 100));
				verticalStrut.setMinimumSize(new Dimension(0, 100));
				verticalStrut.setBounds(new Rectangle(0, 0, 0, 100));
				vBox_center.add(verticalStrut);
				vBox_center.add(btnStart);
				vBox_center.setBorder(new EmptyBorder(25, 25, 25, 25));
				frame.getContentPane().add(vBox_center);
	}

}
