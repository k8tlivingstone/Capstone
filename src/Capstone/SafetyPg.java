package Capstone;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SafetyPg extends JPanel {

	/**
	 * Create the panel.
	 */
	public SafetyPg() {
		Validation.TimerStart(this);
		setBorder(null);
		setMinimumSize(new Dimension(0, 0));
		setPreferredSize(new Dimension(930, 450));
		setMaximumSize(new Dimension(1194, 420));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JTextArea taVisitorPass = new JTextArea();
		taVisitorPass.setPreferredSize(new Dimension(660, 190));
		taVisitorPass.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		taVisitorPass.setMaximumSize(new Dimension(670, 200));
		taVisitorPass.setMargin(new Insets(5, 2, 5, 2));
		taVisitorPass.setBackground(Color.WHITE);
		taVisitorPass.setForeground(new Color(0, 0, 102));
		taVisitorPass.setWrapStyleWord(true);
		taVisitorPass.setLineWrap(true);
		taVisitorPass.setFont(new Font("Tahoma", Font.BOLD, 24));
		taVisitorPass.setText("     Visitors are required to where their visitor passes while on site. Individuals who do not have a visitors pass and are not an active employee at the facility will be considered an unauthorized visitor. Unauthorized visitors will be escorted to the front office to receive a visitor's pass or escorted from the property.");
		taVisitorPass.setBounds(450, 50, 697, 212);
		
		JTextArea taRecordings = new JTextArea();
		taRecordings.setAlignmentY(Component.TOP_ALIGNMENT);
		taRecordings.setMaximumSize(new Dimension(650, 130));
		taRecordings.setBackground(Color.WHITE);
		taRecordings.setForeground(new Color(0, 0, 102));
		taRecordings.setWrapStyleWord(true);
		taRecordings.setText("     Any areas designated no electronics allowed, requires the electronics to either be stowed in their vehicle or in the designated electronics storage box. ");
		taRecordings.setLineWrap(true);
		taRecordings.setFont(new Font("Tahoma", Font.BOLD, 24));
		taRecordings.setBounds(450, 284, 697, 158);
		
		JLabel lblSafetyImage = new JLabel("");
		lblSafetyImage.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblSafetyImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		ImageIcon icon2 = new ImageIcon("C:\\Users\\KCStone\\eclipse-workspace\\Capstone\\src\\images\\SafetyWorker.jpg");
		Image si = icon2.getImage().getScaledInstance(188, 150,Image.SCALE_DEFAULT);
		lblSafetyImage.setIcon(new ImageIcon(si));
		lblSafetyImage.setBounds(29, 124, 370, 318);
		
		JLabel lblSafetyTitle = new JLabel("* IMPORTANT *");
		lblSafetyTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSafetyTitle.setMaximumSize(new Dimension(500, 60));
		lblSafetyTitle.setPreferredSize(new Dimension(300, 60));
		lblSafetyTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSafetyTitle.setForeground(new Color(0, 0, 102));
		lblSafetyTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
		lblSafetyTitle.setBounds(29, 48, 389, 50);
		lblSafetyTitle.setBorder(new EmptyBorder(0,10,20,0));

		Box vBox_right = Box.createVerticalBox();
		vBox_right.setAlignmentX(Component.CENTER_ALIGNMENT);
		vBox_right.add(taVisitorPass);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 10));
		verticalStrut.setMaximumSize(new Dimension(400, 10));
		vBox_right.add(verticalStrut);
		vBox_right.add(taRecordings);
		vBox_right.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Box hBox_safe = Box.createHorizontalBox();
		hBox_safe.setAlignmentY(Component.CENTER_ALIGNMENT);
		hBox_safe.add(lblSafetyImage);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setMaximumSize(new Dimension(20, 250));
		hBox_safe.add(horizontalStrut);
		hBox_safe.add(vBox_right);
		hBox_safe.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Box vBox_left = Box.createVerticalBox();
		this.add(vBox_left, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setPreferredSize(new Dimension(0, 10));
		verticalStrut_1.setMinimumSize(new Dimension(0, 10));
		vBox_left.add(verticalStrut_1);
		vBox_left.add(lblSafetyTitle);
		vBox_left.add(hBox_safe);
		vBox_left.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

}
