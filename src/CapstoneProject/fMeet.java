package CapstoneProject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class fMeet extends JFrame {

	private final JPanel pMeet = new JPanel();
	JPanel Container = new JPanel();
	JScrollPane sPane = new JScrollPane(Container);
	CardLayout clMeet = new CardLayout();
	private SafetyPg safety = new SafetyPg();
	private PhotoPg photo = new PhotoPg();
	private NamePg name = new NamePg();
	private DirectPg direct = new DirectPg();
	private CloserPg closer = new CloserPg();

	private JButton btnCont_Safe = new JButton("NEXT");
	private JButton btnCont_Photo = new JButton("NEXT");
	private JButton btnClear = new JButton("CLEAR");
	private JButton btnCont_Name = new JButton("NEXT");
	private JButton btnCont_Direct = new JButton("NEXT");
	private JButton btnCont_Close = new JButton("FINISH");
	private final Component horizontalStrut = Box.createHorizontalStrut(20);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fMeet fmeet = new fMeet();
					fmeet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fMeet() {
		super("NAU-MAI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		// Holder for the keyboard display
		JPanel Keyboard = new JPanel();
		Keyboard.setBackground(Color.WHITE);
		getContentPane().add(Keyboard, BorderLayout.SOUTH);
		
		Box hBox3 = Box.createHorizontalBox();
		Keyboard.add(hBox3);
		hBox3.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Box hBox4 = Box.createHorizontalBox();
		Keyboard.add(hBox4);
		hBox4.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Box hBox5 = Box.createHorizontalBox();
		Keyboard.add(hBox5);
		hBox5.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Holder for the buttons in the application
		JPanel ButtonFrame = new JPanel();
		ButtonFrame.setBackground(Color.WHITE);
		getContentPane().add(ButtonFrame, BorderLayout.NORTH);

		Box hBox2 = Box.createHorizontalBox();
		ButtonFrame.add(hBox2);
		hBox2.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Button for Safety Message Card
		hBox2.add(btnCont_Safe);
		btnCont_Safe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clMeet.show(Container, "m3");
				btnCont_Safe.setVisible(false);
				btnCont_Photo.setVisible(true);
			}
		});
		btnCont_Safe.setPreferredSize(new Dimension(160, 50));
		btnCont_Safe.setMinimumSize(new Dimension(160, 50));
		btnCont_Safe.setMaximumSize(new Dimension(160, 50));
		btnCont_Safe.setMargin(new Insets(5, 15, 5, 15));
		btnCont_Safe.setHorizontalAlignment(SwingConstants.CENTER);
		btnCont_Safe.setForeground(Color.WHITE);
		btnCont_Safe.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCont_Safe.setFocusable(false);
		btnCont_Safe.setBorder(
				new BevelBorder(BevelBorder.RAISED, new Color(51, 153, 204), null, new Color(0, 0, 0), null));
		btnCont_Safe.setBackground(new Color(0, 0, 102));
		btnCont_Safe.setAlignmentY(0.0f);

		// Button for Photography Message Card
		ButtonFrame.add(hBox2);
		btnCont_Photo.setVisible(false);
		btnCont_Photo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clMeet.show(Container, "m4");
				btnCont_Photo.setVisible(false);
				btnClear.setVisible(true);
				btnCont_Name.setVisible(true);

			}
		});
		btnCont_Photo.setPreferredSize(new Dimension(160, 50));
		btnCont_Photo.setMinimumSize(new Dimension(160, 50));
		btnCont_Photo.setMaximumSize(new Dimension(160, 50));
		btnCont_Photo.setMargin(new Insets(5, 15, 5, 15));
		btnCont_Photo.setHorizontalAlignment(SwingConstants.CENTER);
		btnCont_Photo.setForeground(Color.WHITE);
		btnCont_Photo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCont_Photo.setFocusable(false);
		btnCont_Photo.setBorder(
				new BevelBorder(BevelBorder.RAISED, new Color(51, 153, 204), null, new Color(0, 0, 0), null));
		btnCont_Photo.setBackground(new Color(0, 0, 102));
		btnCont_Photo.setAlignmentY(0.0f);
		hBox2.add(btnCont_Photo);

		
		// Button for clearing textfields on name card
				btnClear.setVisible(false);
				btnClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//clear textfields
					}
				});
				btnClear.setPreferredSize(new Dimension(160, 50));
				btnClear.setMinimumSize(new Dimension(160, 50));
				btnClear.setMaximumSize(new Dimension(160, 50));
				btnClear.setMargin(new Insets(5, 15, 5, 15));
				btnClear.setHorizontalAlignment(SwingConstants.CENTER);
				btnClear.setForeground(Color.WHITE);
				btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnClear.setFocusable(false);
				btnClear.setBorder(
						new BevelBorder(BevelBorder.RAISED, new Color(51, 153, 204), null, new Color(0, 0, 0), null));
				btnClear.setBackground(new Color(0, 0, 102));
				btnClear.setAlignmentY(0.0f);
				hBox2.add(btnClear);
				
				
		// Button for Name Capture Card
		btnCont_Name.setVisible(false);
		btnCont_Name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clMeet.show(Container, "m5");
				btnCont_Name.setVisible(false);
				btnCont_Direct.setVisible(true);
				btnClear.setVisible(false);
			}
		});
		
		hBox2.add(horizontalStrut);
		btnCont_Name.setPreferredSize(new Dimension(160, 50));
		btnCont_Name.setMinimumSize(new Dimension(160, 50));
		btnCont_Name.setMaximumSize(new Dimension(160, 50));
		btnCont_Name.setMargin(new Insets(5, 15, 5, 15));
		btnCont_Name.setHorizontalAlignment(SwingConstants.CENTER);
		btnCont_Name.setForeground(Color.WHITE);
		btnCont_Name.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCont_Name.setFocusable(false);
		btnCont_Name.setBorder(
				new BevelBorder(BevelBorder.RAISED, new Color(51, 153, 204), null, new Color(0, 0, 0), null));
		btnCont_Name.setBackground(new Color(0, 0, 102));
		btnCont_Name.setAlignmentY(0.0f);
		hBox2.add(btnCont_Name);
		
		
		// Button for Directory lookup Card
				btnCont_Direct.setVisible(false);
				btnCont_Direct.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clMeet.show(Container, "m6");
						btnCont_Direct.setVisible(false);
						btnCont_Close.setVisible(true);
					}
				});
				btnCont_Direct.setPreferredSize(new Dimension(160, 50));
				btnCont_Direct.setMinimumSize(new Dimension(160, 50));
				btnCont_Direct.setMaximumSize(new Dimension(160, 50));
				btnCont_Direct.setMargin(new Insets(5, 20, 5, 15));
				btnCont_Direct.setHorizontalAlignment(SwingConstants.CENTER);
				btnCont_Direct.setForeground(Color.WHITE);
				btnCont_Direct.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnCont_Direct.setFocusable(false);
				btnCont_Direct.setBorder(
						new BevelBorder(BevelBorder.RAISED, new Color(51, 153, 204), null, new Color(0, 0, 0), null));
				btnCont_Direct.setBackground(new Color(0, 0, 102));
				btnCont_Direct.setAlignmentY(0.0f);
				hBox2.add(btnCont_Direct);
				
				// Button for Closer Card
				btnCont_Close.setVisible(false);
				btnCont_Close.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clMeet.show(Container, "m6");
						btnCont_Direct.setVisible(false);
						btnCont_Close.setVisible(true);
					}
				});
				btnCont_Close.setPreferredSize(new Dimension(160, 50));
				btnCont_Close.setMinimumSize(new Dimension(160, 50));
				btnCont_Close.setMaximumSize(new Dimension(160, 50));
				btnCont_Close.setMargin(new Insets(5, 20, 5, 15));
				btnCont_Close.setHorizontalAlignment(SwingConstants.CENTER);
				btnCont_Close.setForeground(Color.WHITE);
				btnCont_Close.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnCont_Close.setFocusable(false);
				btnCont_Close.setBorder(
						new BevelBorder(BevelBorder.RAISED, new Color(51, 153, 204), null, new Color(0, 0, 0), null));
				btnCont_Close.setBackground(new Color(0, 0, 102));
				btnCont_Close.setAlignmentY(0.0f);
				hBox2.add(btnCont_Close);

		
		// Scroll Pane for Cards to be visible
		sPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		Container.setBorder(null);
		Container.setPreferredSize(new Dimension(600, 430));
		Container.setMinimumSize(new Dimension(500, 430));
		getContentPane().add(sPane, BorderLayout.CENTER);

		JPanel sft = new JPanel();
		JPanel pht = new JPanel();
		JPanel nm = new JPanel();
		JPanel drct = new JPanel();
		JPanel clsr = new JPanel();

		sft = safety;
		pht = photo;
		nm = name;
		drct = direct;
		clsr = closer;

		Container.setLayout(clMeet);
		Container.setMaximumSize(new Dimension(725, 560));
		Container.add(sft, "m2");
		Container.add(pht, "m3");
		Container.add(nm, "m4");
		Container.add(drct, "m5");
		Container.add(clsr, "m6");
		clMeet.show(Container, "m2");
	}
}

