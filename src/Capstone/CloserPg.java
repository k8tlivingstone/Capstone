package Capstone;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class CloserPg extends JPanel {

	/**
	 * Create the panel.
	 */
	public CloserPg() {
		Validation.TimerStart(this);
		setBounds(new Rectangle(0, 0, 834, 420));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JTextArea taClose = new JTextArea();
		taClose.setMaximumSize(new Dimension(1000, 300));
		taClose.setMinimumSize(new Dimension(300, 100));
		taClose.setPreferredSize(new Dimension(300, 100));
		taClose.setForeground(new Color(0, 0, 102));
		taClose.setLineWrap(true);
		taClose.setWrapStyleWord(true);
		taClose.setFont(new Font("Tahoma", Font.BOLD, 28));
		taClose.setText("We have notified your contact person. Please"
				+ " have a seat in the lobby until your contact person "
				+ "comes to get you. Remember you must wear a visitors pass"
				+ " in a location that is visible while on the property"
				+ ".\r\n\r\nHave a great day!");
		
		String msg = new String();
		msg = String.format("Nau-Mai");
		JLabel lbExit = new JLabel(msg);
		lbExit.setHorizontalAlignment(SwingConstants.CENTER);
		lbExit.setForeground(new Color(0, 0, 102));
		lbExit.setFont(new Font("Tahoma", Font.BOLD, 40));
		lbExit.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lbExit, BorderLayout.NORTH);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\KCStone\\eclipse-workspace\\Capstone\\src\\images\\logo2.png");
		Image scaleImage = icon.getImage().getScaledInstance(90, 85,Image.SCALE_DEFAULT);
		JButton btnLogo = new JButton("");
		btnLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLogo.setIcon(new ImageIcon(scaleImage));
		btnLogo.setBorder(null);
		btnLogo.setBackground(Color.WHITE);
		btnLogo.setForeground(new Color(0, 0, 0));
		btnLogo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		
		Box vBox_close = Box.createVerticalBox();
		this.add(vBox_close, BorderLayout.CENTER);
		vBox_close.add(btnLogo);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		vBox_close.add(verticalStrut);
		vBox_close.add(taClose);
		vBox_close.setBorder(new EmptyBorder(25, 15, 25, 15));

	}


}
