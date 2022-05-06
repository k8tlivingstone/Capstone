package Capstone;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PhotoPg extends JPanel {

	/**
	 * Create the panel.
	 */
	public PhotoPg() {
		Validation.TimerStart(this);
		setBorder(null);
		setMinimumSize(new Dimension(930, 450));
		setPreferredSize(new Dimension(930, 450));
		setMaximumSize(new Dimension(1194, 420));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JTextArea taNDA = new JTextArea();
		taNDA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		taNDA.setMaximumSize(new Dimension(1200, 100));
		taNDA.setBackground(Color.WHITE);
		taNDA.setForeground(new Color(0, 0, 102));
		taNDA.setWrapStyleWord(true);
		taNDA.setLineWrap(true);
		taNDA.setFont(new Font("Tahoma", Font.BOLD, 32));
		taNDA.setText("No photography or video recording allowed without the approval of Company management.");
		taNDA.setBounds(53, 359, 1131, 124);
		
		JLabel lblSecurityNotice = new JLabel("");
		lblSecurityNotice.setAlignmentX(Component.CENTER_ALIGNMENT);
		String ice3 = "C:\\Users\\KCStone\\eclipse-workspace\\Capstone\\src\\images\\PhotographyHold.jpg";
		ImageIcon icon3 = new ImageIcon(ice3);
		Image si2 = icon3.getImage().getScaledInstance(295, 170,Image.SCALE_DEFAULT);
		lblSecurityNotice.setIcon(new ImageIcon(ice3));
		lblSecurityNotice.setBounds(336, 81, 535, 318);
		
		JLabel lblPhotoNotice = new JLabel("SECURITY NOTICE");
		lblPhotoNotice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhotoNotice.setMaximumSize(new Dimension(600, 80));
		lblPhotoNotice.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPhotoNotice.setForeground(new Color(0, 0, 102));
		lblPhotoNotice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 48));
		lblPhotoNotice.setBounds(386, 21, 535, 50);
		
		Box vBox_nda = Box.createVerticalBox();
		this.add(vBox_nda, BorderLayout.CENTER);
		vBox_nda.add(lblPhotoNotice);
		
		JLabel lblEmpty1 = new JLabel("");
		lblEmpty1.setBorder(null);
		lblEmpty1.setBackground(Color.WHITE);
		lblEmpty1.setPreferredSize(new Dimension(50, 0));
		lblEmpty1.setMinimumSize(new Dimension(50, 0));
		lblEmpty1.setMaximumSize(new Dimension(50, 0));
		lblEmpty1.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(lblEmpty1, BorderLayout.WEST);
		JLabel lblEmpty2 = new JLabel("");
		lblEmpty2.setBorder(null);
		lblEmpty2.setBackground(Color.WHITE);
		lblEmpty2.setPreferredSize(new Dimension(50, 0));
		this.add(lblEmpty2, BorderLayout.EAST);
		
		vBox_nda.add(lblSecurityNotice);
		vBox_nda.add(taNDA);
		vBox_nda.setBorder(new EmptyBorder(25, 15, 25, 15));
	}

}
