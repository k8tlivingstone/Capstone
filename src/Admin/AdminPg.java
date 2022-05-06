package Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import Capstone.Capstone;

@SuppressWarnings("serial")
public class AdminPg extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPg frame = new AdminPg();
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
	public AdminPg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lbAdminTitle = new JLabel("Nau-Mai Admin Section");
		lbAdminTitle.setForeground(Color.WHITE);
		lbAdminTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
		lbAdminTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbAdminTitle, BorderLayout.NORTH);

		Box hBox_Buttons = Box.createHorizontalBox();
		hBox_Buttons.setBorder(null);
		hBox_Buttons.setAlignmentY(Component.CENTER_ALIGNMENT);
		contentPane.add(hBox_Buttons, BorderLayout.CENTER);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setMaximumSize(new Dimension(120, 32767));
		hBox_Buttons.add(horizontalStrut);

		Box vBox_left = Box.createVerticalBox();
		vBox_left.setBorder(null);
		hBox_Buttons.add(vBox_left);

		JButton btnOnSite = new JButton();
		btnOnSite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// View On-site Report pulled from database

			}
		});
		btnOnSite.setLayout(new BorderLayout());
		JLabel label1 = new JLabel("Currently");
		label1.setVerticalAlignment(SwingConstants.BOTTOM);
		label1.setPreferredSize(new Dimension(43, 50));
		label1.setMinimumSize(new Dimension(43, 50));
		label1.setMaximumSize(new Dimension(43, 50));
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Calibri", Font.BOLD, 20));
		label1.setForeground(new Color(0, 153, 153));
		label1.setBackground(new Color(253, 245, 230));
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel label2 = new JLabel("On-Site");
		label2.setVerticalAlignment(SwingConstants.TOP);
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		label2.setPreferredSize(new Dimension(34, 50));
		label2.setBackground(new Color(253, 245, 230));
		label2.setForeground(new Color(0, 153, 153));
		label2.setFont(new Font("Calibri", Font.BOLD, 20));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setHorizontalTextPosition(SwingConstants.CENTER);

		btnOnSite.add(BorderLayout.NORTH, label1);
		btnOnSite.add(BorderLayout.SOUTH, label2);
		btnOnSite.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnOnSite.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOnSite.setMargin(new Insets(5, 15, 5, 15));
		btnOnSite.setMaximumSize(new Dimension(100, 100));
		btnOnSite.setMinimumSize(new Dimension(100, 100));
		btnOnSite.setPreferredSize(new Dimension(100, 100));
		btnOnSite.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnOnSite.setFocusable(false);
		btnOnSite.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnOnSite.setForeground(new Color(0, 153, 153));
		btnOnSite.setBackground(new Color(253, 245, 230));
		btnOnSite.setFont(new Font("Calibri", Font.BOLD, 20));
		btnOnSite.setBounds(295, 285, 116, 46);
		vBox_left.add(btnOnSite);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setMaximumSize(new Dimension(200, 25));
		vBox_left.add(verticalStrut);

		JButton btnLog = new JButton();
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Excel file data on log sheet
			}
		});
		btnLog.setLayout(new BorderLayout());
		JLabel label3 = new JLabel("Log");
		label3.setVerticalAlignment(SwingConstants.BOTTOM);
		label3.setPreferredSize(new Dimension(43, 50));
		label3.setMinimumSize(new Dimension(43, 50));
		label3.setMaximumSize(new Dimension(43, 50));
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Calibri", Font.BOLD, 20));
		label3.setForeground(new Color(0, 153, 153));
		label3.setBackground(new Color(253, 245, 230));
		label3.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel label4 = new JLabel("Report");
		label4.setVerticalAlignment(SwingConstants.TOP);
		label4.setAlignmentX(Component.CENTER_ALIGNMENT);
		label4.setPreferredSize(new Dimension(34, 50));
		label4.setBackground(new Color(253, 245, 230));
		label4.setForeground(new Color(0, 153, 153));
		label4.setFont(new Font("Calibri", Font.BOLD, 20));
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setHorizontalTextPosition(SwingConstants.CENTER);

		btnLog.add(BorderLayout.NORTH, label3);
		btnLog.add(BorderLayout.SOUTH, label4);
		btnLog.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnLog.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLog.setMargin(new Insets(5, 15, 5, 15));
		btnLog.setPreferredSize(new Dimension(100, 100));
		btnLog.setMinimumSize(new Dimension(100, 100));
		btnLog.setMaximumSize(new Dimension(100, 100));
		btnLog.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLog.setBackground(new Color(253, 245, 230));
		btnLog.setForeground(new Color(0, 153, 153));
		btnLog.setFocusable(false);
		btnLog.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLog.setFont(new Font("Calibri", Font.BOLD, 20));
		btnLog.setBounds(295, 285, 116, 46);
		vBox_left.add(btnLog);

		/**************** Center Buttons ********************/
		Box vBox_mid = Box.createVerticalBox();
		vBox_mid.setBorder(null);
		hBox_Buttons.add(vBox_mid);

		JButton btnBlank1 = new JButton();
		btnBlank1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnBlank1, "Button has not been assigned an action!");
			}
		});
		btnBlank1.setLayout(new BorderLayout());
		JLabel label5 = new JLabel("Blank");
		label5.setVerticalAlignment(SwingConstants.BOTTOM);
		label5.setPreferredSize(new Dimension(43, 50));
		label5.setMinimumSize(new Dimension(43, 50));
		label5.setMaximumSize(new Dimension(43, 50));
		label5.setHorizontalTextPosition(SwingConstants.CENTER);
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setFont(new Font("Calibri", Font.BOLD, 20));
		label5.setForeground(new Color(0, 153, 153));
		label5.setBackground(new Color(253, 245, 230));
		label5.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel label6 = new JLabel("Button");
		label6.setVerticalAlignment(SwingConstants.TOP);
		label6.setAlignmentX(Component.CENTER_ALIGNMENT);
		label6.setPreferredSize(new Dimension(34, 50));
		label6.setBackground(new Color(253, 245, 230));
		label6.setForeground(new Color(0, 153, 153));
		label6.setFont(new Font("Calibri", Font.BOLD, 20));
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setHorizontalTextPosition(SwingConstants.CENTER);

		btnBlank1.add(BorderLayout.NORTH, label5);
		btnBlank1.add(BorderLayout.SOUTH, label6);
		btnBlank1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnBlank1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBlank1.setMargin(new Insets(5, 15, 5, 15));
		btnBlank1.setMaximumSize(new Dimension(100, 100));
		btnBlank1.setMinimumSize(new Dimension(100, 100));
		btnBlank1.setPreferredSize(new Dimension(100, 100));
		btnBlank1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBlank1.setFocusable(false);
		btnBlank1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBlank1.setForeground(new Color(0, 153, 153));
		btnBlank1.setBackground(new Color(253, 245, 230));
		btnBlank1.setFont(new Font("Calibri", Font.BOLD, 20));
		btnBlank1.setBounds(295, 285, 116, 46);
		vBox_mid.add(btnBlank1);

		Component vStrut_mid = Box.createVerticalStrut(20);
		vStrut_mid.setMaximumSize(new Dimension(200, 25));
		vBox_mid.add(vStrut_mid);

		JButton btnBlank2 = new JButton();
		btnBlank2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnBlank2, "Button has not been assigned an action!");
			}
		});
		btnBlank2.setLayout(new BorderLayout());
		JLabel label7 = new JLabel("Blank");
		label7.setVerticalAlignment(SwingConstants.BOTTOM);
		label7.setPreferredSize(new Dimension(43, 50));
		label7.setMinimumSize(new Dimension(43, 50));
		label7.setMaximumSize(new Dimension(43, 50));
		label7.setHorizontalTextPosition(SwingConstants.CENTER);
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		label7.setFont(new Font("Calibri", Font.BOLD, 20));
		label7.setForeground(new Color(0, 153, 153));
		label7.setBackground(new Color(253, 245, 230));
		label7.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel label8 = new JLabel("Button");
		label8.setVerticalAlignment(SwingConstants.TOP);
		label8.setAlignmentX(Component.CENTER_ALIGNMENT);
		label8.setPreferredSize(new Dimension(34, 50));
		label8.setBackground(new Color(253, 245, 230));
		label8.setForeground(new Color(0, 153, 153));
		label8.setFont(new Font("Calibri", Font.BOLD, 20));
		label8.setHorizontalAlignment(SwingConstants.CENTER);
		label8.setHorizontalTextPosition(SwingConstants.CENTER);

		btnBlank2.add(BorderLayout.NORTH, label7);
		btnBlank2.add(BorderLayout.SOUTH, label8);
		btnBlank2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnBlank2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBlank2.setMargin(new Insets(5, 15, 5, 15));
		btnBlank2.setPreferredSize(new Dimension(100, 100));
		btnBlank2.setMinimumSize(new Dimension(100, 100));
		btnBlank2.setMaximumSize(new Dimension(100, 100));
		btnBlank2.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBlank2.setBackground(new Color(253, 245, 230));
		btnBlank2.setForeground(new Color(0, 153, 153));
		btnBlank2.setFocusable(false);
		btnBlank2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBlank2.setFont(new Font("Calibri", Font.BOLD, 20));
		btnBlank2.setBounds(295, 285, 116, 46);
		vBox_mid.add(btnBlank2);

		/**************** Right Buttons ********************/
		Box vBox_right = Box.createVerticalBox();
		vBox_right.setBorder(null);
		hBox_Buttons.add(vBox_right);

		JButton btnBlank3 = new JButton();
		btnBlank3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Capstone();
				Capstone.getFrame().setVisible(true);
			}
		});
		btnBlank3.setLayout(new BorderLayout());
		JLabel label9 = new JLabel("Home");
		label9.setVerticalAlignment(SwingConstants.BOTTOM);
		label9.setPreferredSize(new Dimension(43, 50));
		label9.setMinimumSize(new Dimension(43, 50));
		label9.setMaximumSize(new Dimension(43, 50));
		label9.setHorizontalTextPosition(SwingConstants.CENTER);
		label9.setHorizontalAlignment(SwingConstants.CENTER);
		label9.setFont(new Font("Calibri", Font.BOLD, 20));
		label9.setForeground(new Color(0, 153, 153));
		label9.setBackground(new Color(253, 245, 230));
		label9.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel label10 = new JLabel("Page");
		label10.setVerticalAlignment(SwingConstants.TOP);
		label10.setAlignmentX(Component.CENTER_ALIGNMENT);
		label10.setPreferredSize(new Dimension(34, 50));
		label10.setBackground(new Color(253, 245, 230));
		label10.setForeground(new Color(0, 153, 153));
		label10.setFont(new Font("Calibri", Font.BOLD, 20));
		label10.setHorizontalAlignment(SwingConstants.CENTER);
		label10.setHorizontalTextPosition(SwingConstants.CENTER);

		btnBlank3.add(BorderLayout.NORTH, label9);
		btnBlank3.add(BorderLayout.SOUTH, label10);
		btnBlank3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnBlank3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBlank3.setMargin(new Insets(5, 15, 5, 15));
		btnBlank3.setMaximumSize(new Dimension(100, 100));
		btnBlank3.setMinimumSize(new Dimension(100, 100));
		btnBlank3.setPreferredSize(new Dimension(100, 100));
		btnBlank3.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBlank3.setFocusable(false);
		btnBlank3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBlank3.setForeground(new Color(0, 153, 153));
		btnBlank3.setBackground(new Color(253, 245, 230));
		btnBlank3.setFont(new Font("Calibri", Font.BOLD, 20));
		btnBlank3.setBounds(295, 285, 116, 46);
		vBox_right.add(btnBlank3);

		Component vStrut_right = Box.createVerticalStrut(20);
		vStrut_right.setMaximumSize(new Dimension(200, 25));
		vBox_right.add(vStrut_right);

		JButton btnBlank4 = new JButton();
		btnBlank4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnBlank4.setLayout(new BorderLayout());
		JLabel label11 = new JLabel("Exit");
		label11.setVerticalAlignment(SwingConstants.BOTTOM);
		label11.setPreferredSize(new Dimension(43, 50));
		label11.setMinimumSize(new Dimension(43, 50));
		label11.setMaximumSize(new Dimension(43, 50));
		label11.setHorizontalTextPosition(SwingConstants.CENTER);
		label11.setHorizontalAlignment(SwingConstants.CENTER);
		label11.setFont(new Font("Calibri", Font.BOLD, 20));
		label11.setForeground(new Color(0, 153, 153));
		label11.setBackground(new Color(253, 245, 230));
		label11.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel label12 = new JLabel("Program");
		label12.setVerticalAlignment(SwingConstants.TOP);
		label12.setAlignmentX(Component.CENTER_ALIGNMENT);
		label12.setPreferredSize(new Dimension(34, 50));
		label12.setBackground(new Color(253, 245, 230));
		label12.setForeground(new Color(0, 153, 153));
		label12.setFont(new Font("Calibri", Font.BOLD, 20));
		label12.setHorizontalAlignment(SwingConstants.CENTER);
		label12.setHorizontalTextPosition(SwingConstants.CENTER);

		btnBlank4.add(BorderLayout.NORTH, label11);
		btnBlank4.add(BorderLayout.SOUTH, label12);
		btnBlank4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnBlank4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBlank4.setMargin(new Insets(5, 15, 5, 15));
		btnBlank4.setPreferredSize(new Dimension(100, 100));
		btnBlank4.setMinimumSize(new Dimension(100, 100));
		btnBlank4.setMaximumSize(new Dimension(100, 100));
		btnBlank4.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBlank4.setBackground(new Color(253, 245, 230));
		btnBlank4.setForeground(new Color(0, 153, 153));
		btnBlank4.setFocusable(false);
		btnBlank4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBlank4.setFont(new Font("Calibri", Font.BOLD, 20));
		btnBlank4.setBounds(295, 285, 116, 46);
		vBox_right.add(btnBlank4);
	}

}
