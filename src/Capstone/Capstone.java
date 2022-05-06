package Capstone;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.List;
import Admin.LoginPg;
import java.util.*;

public class Capstone {

	private static JFrame frame;
	protected static List<String> model = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Capstone();
					Capstone.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Capstone() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GraphicsEnvironment.getLocalGraphicsEnvironment();
		setFrame(new JFrame());
		getFrame().setExtendedState(getFrame().getExtendedState() | JFrame.MAXIMIZED_BOTH);
		getFrame().getContentPane().setFocusable(false);
		getFrame().getContentPane().setBackground(Color.WHITE);
		getFrame().setBounds(100, 100, 1194, 834);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(new BorderLayout(0, 0));

		// Button to open menu screen
		JButton btnStart = new JButton("TAP HERE TO BEGIN");
		btnStart.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnStart.setBounds(new Rectangle(30, 50, 1500, 50));
		btnStart.setFocusable(false);
		btnStart.setHorizontalAlignment(SwingConstants.CENTER);
		btnStart.setBorder(new EmptyBorder(30, 75, 30, 75));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().dispose();
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
		getFrame().getContentPane().add(lblNaumai);
		getFrame().getContentPane().add(lblNaumai, BorderLayout.NORTH);

		// Logo Button
		ImageIcon icon = new ImageIcon("C:\\Users\\KCStone\\eclipse-workspace\\Capstone\\src\\images\\logo2.png");
		Image scaleImage = icon.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
		JButton btnAdminArea = new JButton("");
		btnAdminArea.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdminArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// opens the login window
				getFrame().dispose();
				LoginPg loginpg = new LoginPg();
				loginpg.setVisible(true);
			}
		});
		btnAdminArea.setBorder(null);
		btnAdminArea.setBackground(Color.WHITE);
		btnAdminArea.setIcon(new ImageIcon(scaleImage));
		btnAdminArea.setBounds(26, 658, 103, 98);
		getFrame().getContentPane().add(btnAdminArea);
		getFrame().getContentPane().add(btnAdminArea, BorderLayout.SOUTH);

		Box vBox_center = Box.createVerticalBox();
		getFrame().getContentPane().add(vBox_center, BorderLayout.CENTER);

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
		getFrame().getContentPane().add(vBox_center);
	}

	/**
	 * @return the frame
	 */
	public static JFrame getFrame() {
		try {
			return frame;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		Capstone.frame = frame;
	}

}
