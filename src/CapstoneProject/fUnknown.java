package CapstoneProject;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class fUnknown extends JFrame {
	private final JPanel interview_panel = new JPanel();
	JPanel Top_Pane = new JPanel();
	JScrollPane scrollPane = new JScrollPane(Top_Pane);
	
	//top section of application for interviewee options
	CardLayout clInter = new CardLayout();
	private SafetyPg safetyPg = new SafetyPg();
	private NamePg namePg = new NamePg();
	private PhotoPg photoPg = new PhotoPg();
	private DirectPg directPg = new DirectPg();
	private CloserPg closerPg = new CloserPg();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fUnknown finter = new fUnknown();
					finter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public fUnknown() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel ButtonFrame = new JPanel();
		ButtonFrame.setBackground(new Color(253, 245, 230));
		getContentPane().add(ButtonFrame, BorderLayout.SOUTH);
		
		Box horizontalBox = Box.createHorizontalBox();
		ButtonFrame.add(horizontalBox);
		horizontalBox.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnCont_Safe = new JButton("Continue");
		btnCont_Safe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clInter.show(Top_Pane, "int_2");
			}
		});
		
		btnCont_Safe.setPreferredSize(new Dimension(0,20));
		btnCont_Safe.setMinimumSize(new Dimension(160, 50));
		btnCont_Safe.setMaximumSize(new Dimension(160, 50));
		btnCont_Safe.setMargin(new Insets(5, 15, 5, 15));
		btnCont_Safe.setHorizontalAlignment(SwingConstants.LEFT);
		btnCont_Safe.setForeground(new Color(253, 245, 230));
		btnCont_Safe.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnCont_Safe.setFocusable(false);
		btnCont_Safe.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(51, 153, 204), null, new Color(0, 0, 0), null));
		btnCont_Safe.setBackground(new Color(102, 153, 204));
		btnCont_Safe.setAlignmentY(0.0f);
		horizontalBox.add(btnCont_Safe);
		
		getContentPane().add(scrollPane, BorderLayout.NORTH);
		JPanel safety = new JPanel();
		JPanel name = new JPanel();
		JPanel photo = new JPanel();
		JPanel direct = new JPanel();
		JPanel closer = new JPanel();
		safety = safetyPg;
		name = namePg;
		photo = photoPg;
		direct = directPg;
		closer = closerPg;
		
		Top_Pane.setLayout(clInter);
		Top_Pane.setMaximumSize(new Dimension(925, 660));
		Top_Pane.add(safety, "int_1");
		Top_Pane.add(name, "int_2");
		Top_Pane.add(photo, "int_4");
		Top_Pane.add(direct, "int_5");
		Top_Pane.add(closer, "int_6");
		clInter.show(Top_Pane, "1");
	}



}
