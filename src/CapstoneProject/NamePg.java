package CapstoneProject;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;

public class NamePg extends JPanel {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	JPanel Holder = new JPanel();
	public static JTextField tfFName;
	public static JTextField tfLName;
	public static JTextField tfOrganization;
	private KeyboardPg kp = new KeyboardPg();
	public static JRadioButton rCitizen_Yes;
	public static JRadioButton rCitizen_No;
	public static JRadioButton rCitizen_Other;
	String citizen;
	static Validation val = new Validation();
	static CapstoneProject cp = new CapstoneProject();
	public static String getValue;

	/**
	 * Create the panel.
	 */
	public NamePg() {
		
		conn=dB_Connection.getDBConnection();
		
		setMaximumSize(new Dimension(1200, 32767));
		setBounds(new Rectangle(0, 0, 834, 420));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

		/***************** Labels ********************/
		JLabel lblFName = new JLabel("    First Name:");
		lblFName.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblFName.setForeground(new Color(0, 0, 102));
		lblFName.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFName.setBorder(new EmptyBorder(0, 10, 20, 0));
		lblFName.setBounds(238, 156, 151, 36);

		JLabel lblLName = new JLabel("    Last Name:");
		lblLName.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblLName.setForeground(new Color(0, 0, 102));
		lblLName.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLName.setBorder(new EmptyBorder(0, 10, 20, 0));
		lblLName.setBounds(238, 231, 151, 36);

		JLabel lblNameTitle = new JLabel("Welcome, what is your name?");
		lblNameTitle.setForeground(new Color(0, 0, 102));
		lblNameTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
		this.add(lblNameTitle, BorderLayout.NORTH);
		lblNameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameTitle.setBorder(new EmptyBorder(0, 10, 20, 0));
		lblNameTitle.setBounds(272, 48, 646, 61);

		JLabel lblOrg = new JLabel("Organization:");
		lblOrg.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblOrg.setForeground(new Color(0, 0, 102));
		lblOrg.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblOrg.setBorder(new EmptyBorder(0, 10, 20, 0));
		lblOrg.setBounds(218, 306, 171, 41);

		// Label for Citizenship check radio button group
		JLabel lblAreYouA = new JLabel("Are you a US Citizen?");
		lblAreYouA.setForeground(new Color(0, 0, 102));
		lblAreYouA.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAreYouA.setBorder(new EmptyBorder(0, 10, 20, 0));
		lblAreYouA.setBounds(270, 398, 331, 61);

		/*************** Textfields ******************/
		tfFName = new JTextField();
		tfFName.setPreferredSize(new Dimension(800, 50));
		tfFName.setMaximumSize(new Dimension(800, 50));
		tfFName.setBorder(new LineBorder(new Color(0, 0, 102)));
		tfFName.setBackground(new Color(253, 245, 230));
		tfFName.setForeground(new Color(0, 0, 102));
		tfFName.setFont(new Font("Tahoma", Font.BOLD, 20));
		tfFName.setBounds(399, 155, 488, 50);
		tfFName.setColumns(10);
		
		tfLName = new JTextField();
		tfLName.setMaximumSize(new Dimension(800, 50));
		tfLName.setPreferredSize(new Dimension(800, 50));
		tfLName.setBorder(new LineBorder(new Color(0, 0, 102)));
		tfLName.setBackground(new Color(253, 245, 230));
		tfLName.setFont(new Font("Tahoma", Font.BOLD, 20));
		tfLName.setBounds(399, 155, 488, 50);
		tfLName.setColumns(10);
		
		tfOrganization = new JTextField();
		tfOrganization.setPreferredSize(new Dimension(800, 50));
		tfOrganization.setMaximumSize(new Dimension(800, 200));
		tfOrganization.setBorder(new LineBorder(new Color(0, 0, 102)));
		tfOrganization.setBackground(new Color(253, 245, 230));
		tfOrganization.setFont(new Font("Tahoma", Font.BOLD, 20));
		tfOrganization.setBounds(399, 155, 488, 50);
		tfOrganization.setColumns(10);

		// Create Radio buttons for Citizenship check
		rCitizen_No = new JRadioButton("   NO");
		rCitizen_No.setForeground(new Color(0, 0, 102));
		rCitizen_No.setFont(new Font("Tahoma", Font.BOLD, 24));
		rCitizen_No.setBackground(Color.WHITE);
		rCitizen_No.setBorder(new EmptyBorder(0, 10, 20, 0));
		rCitizen_No.setBounds(729, 400, 120, 61);

		rCitizen_Yes = new JRadioButton("   YES");
		rCitizen_Yes.setForeground(new Color(0, 0, 102));
		rCitizen_Yes.setFont(new Font("Tahoma", Font.BOLD, 24));
		rCitizen_Yes.setBackground(Color.WHITE);
		rCitizen_Yes.setBorder(new EmptyBorder(0, 10, 20, 0));
		rCitizen_Yes.setBounds(607, 400, 120, 61);

		rCitizen_Other = new JRadioButton("??");
		rCitizen_Other.setVisible(false);
		rCitizen_Other.setForeground(new Color(0, 0, 102));
		rCitizen_Other.setFont(new Font("Calibri", Font.BOLD, 24));
		rCitizen_Other.setBackground(Color.WHITE);
		rCitizen_Other.setBorder(new EmptyBorder(0, 10, 20, 0));
		rCitizen_Other.setBounds(852, 400, 120, 61);

		// Create button group for radio buttons for Citizendship check
		ButtonGroup group = new ButtonGroup();
		group.add(rCitizen_Yes);
		group.add(rCitizen_No);
		group.add(rCitizen_Other);
		group.clearSelection();

		// Organization boxes for display
		Box vBox_label = Box.createVerticalBox();
		vBox_label.add(lblFName);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setMaximumSize(new Dimension(50, 20));
		vBox_label.add(verticalStrut_2);
		vBox_label.add(lblLName);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalStrut_3.setMaximumSize(new Dimension(50, 20));
		vBox_label.add(verticalStrut_3);
		vBox_label.add(lblOrg);
		vBox_label.setBorder(new EmptyBorder(5, 5, 5, 5));

		Box vBox_text = Box.createVerticalBox();
		vBox_text.add(tfFName);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setMaximumSize(new Dimension(50, 20));
		vBox_text.add(verticalStrut);
		vBox_text.add(tfLName);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setMaximumSize(new Dimension(50, 20));
		vBox_text.add(verticalStrut_1);
		vBox_text.add(tfOrganization);
		vBox_text.setBorder(new EmptyBorder(5, 5, 5, 5));

		Box hBox_input = Box.createHorizontalBox();
		hBox_input.add(vBox_label);
		hBox_input.add(vBox_text);
		hBox_input.setBorder(new EmptyBorder(5, 5, 5, 5));

		Box hBox_citizen = Box.createHorizontalBox();

		Component hStrut_1 = Box.createHorizontalStrut(20);
		hBox_citizen.add(hStrut_1);
		hBox_citizen.add(lblAreYouA);

		Component hStrut = Box.createHorizontalStrut(20);
		hBox_citizen.add(hStrut);
		hBox_citizen.add(rCitizen_Yes);

		Component hStrut_2 = Box.createHorizontalStrut(20);
		hBox_citizen.add(hStrut_2);
		hBox_citizen.add(rCitizen_No);
		hBox_citizen.add(rCitizen_Other);
		hBox_citizen.setBorder(new EmptyBorder(5, 5, 5, 5));

		Box vBox_name = Box.createVerticalBox();
		this.add(vBox_name, BorderLayout.CENTER);
		
		JButton Values = new JButton("");
		Values.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String sql = "select * from [SQL Table] where [SQL Table Name]=?";
//				try {
//					pst=conn.prepareStatement(sql);
//					pst.setString(1, [TextField].getText());
					
//					rs = pst.executeQuery();
//					if(rs.next){
//						JOptionPane.showMessageDialog(null, "input received");
//					}
//				} catch (Exception e) {
//					JOptionPane.showMessageDialog(null, e);
//					
//				}
			}
			
		});
		Values.setBackground(Color.WHITE);
		Values.setBorder(null);
		vBox_name.add(Values);
		vBox_name.add(hBox_input);
		vBox_name.add(hBox_citizen);
		vBox_name.setBorder(new EmptyBorder(5, 5, 5, 5));
		Holder.setMaximumSize(new Dimension(925, 300));
		
		Holder.add(kp);
		kp.setPreferredSize(new Dimension(915, 320));
		Holder.setPreferredSize(new Dimension(1000, 290));
		vBox_name.add(Holder);
	}

	/***************** Getters & Setters ***************/
	/**
	 * @return the tfFname
	 */
	public static JTextField gettfFName() {
		return tfFName;
	}

	/**
	 * @param tfFname the tfFname to set
	 */
	public void setTfFname(JTextField tfFname) {
		this.tfFName = tfFName;
		tfFname.setForeground(new Color(0, 153, 153));
		tfFname.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfFname.setAlignmentX(Component.LEFT_ALIGNMENT);
		tfFname.setMaximumSize(new Dimension(700, 100));
		tfFname.setMinimumSize(new Dimension(10, 50));
		tfFname.setPreferredSize(new Dimension(10, 50));
		tfFname.setBounds(new Rectangle(0, 100, 200, 100));
		tfFname.setBorder(new LineBorder(new Color(0, 0, 0)));
		tfFname.setSize(10, 45);
		tfFname.setBackground(new Color(255, 255, 240));
	}

	/**
	 * @return the tfLName
	 */
	public static JTextField gettfLName() {
		return tfLName;
	}

	/**
	 * @param tfLName the tfLName to set
	 */
	public void setTfLName(JTextField tfLName) {
		this.tfLName = tfLName;
		tfLName.setForeground(new Color(0, 153, 153));
		tfLName.setFont(new Font("Tahoma", Font.BOLD, 36));
		tfLName.setAlignmentX(Component.LEFT_ALIGNMENT);
		tfLName.setMaximumSize(new Dimension(700, 100));
		tfLName.setMinimumSize(new Dimension(10, 50));
		tfLName.setPreferredSize(new Dimension(10, 50));
		tfLName.setBounds(new Rectangle(0, 0, 200, 100));
		tfLName.setBorder(new LineBorder(new Color(0, 0, 0)));
		tfLName.setBackground(new Color(255, 255, 240));
	}

	/**
	 * @return the tfOrganization
	 */
	public JTextField getTfOrganization() {
		return tfOrganization;
	}

	/**
	 * @param tfLName the tfLName to set
	 */
	public void setTfOrganization(JTextField tfOrganization) {
		boolean f;
		this.tfOrganization = tfOrganization;
		tfOrganization.setForeground(new Color(0, 153, 153));
		tfOrganization.setAlignmentX(Component.LEFT_ALIGNMENT);
		tfOrganization.setMaximumSize(new Dimension(700, 100));
		tfOrganization.setMinimumSize(new Dimension(10, 50));
		tfOrganization.setPreferredSize(new Dimension(10, 50));
		tfOrganization.setBounds(new Rectangle(0, 0, 200, 100));
		tfOrganization.setBorder(new LineBorder(new Color(0, 0, 0)));
		tfOrganization.setBackground(new Color(255, 255, 240));
	}

	/**
	 * @param Citizen values
	 */
	public void setCitizen(String citizen) {
		this.citizen = citizen;
		cp.model.add(citizen);
	}

}
