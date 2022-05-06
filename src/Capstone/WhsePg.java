package Capstone;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.JTextField;

import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class WhsePg extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel Holder = new JPanel();
	private KeyboardPg kp = new KeyboardPg();
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	ResultSet rs1;
	Statement st;
	public JButton tfSearch;
	

	static Validation val = new Validation();
	static Capstone cp = new Capstone();
	private JTextField textField;

	@SuppressWarnings("unused")
	private static JTextField setText(JTextField gettfFName) {
		return null;
	}

	/**
	 * Create the panel.
	 * 
	 * @throws FileNotFoundException
	 */
	public WhsePg() {
		Validation.TimerStart(this);
		conn = dB_Connection.getDBConnection();
		setBorder(null);
		setMinimumSize(new Dimension(1195, 420));
		setPreferredSize(new Dimension(998, 577));
		setMaximumSize(new Dimension(1194, 420));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		
		Holder.setMaximumSize(new Dimension(925, 300));
		Holder.add(kp);
		kp.setPreferredSize(new Dimension(915, 320));
		Holder.setPreferredSize(new Dimension(1000, 290));
		add(Holder, BorderLayout.SOUTH);		
		
		JTextArea taWhseTitle = new JTextArea();
		taWhseTitle.setPreferredSize(new Dimension(900, 200));
		taWhseTitle.setMaximumSize(new Dimension(900, 900));
		taWhseTitle.setForeground(new Color(0, 0, 102));
		taWhseTitle.setLineWrap(true);
		taWhseTitle.setWrapStyleWord(true);
		taWhseTitle.setText("      Enter the Order Number or Confirmation Code for the shipment you are here about. If you do not have those numbers, contact your dispatch for the necessary information. ");
		taWhseTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		add(taWhseTitle, BorderLayout.NORTH);
		
		Box horizontalBox = Box.createHorizontalBox();
		add(horizontalBox, BorderLayout.CENTER);
		
		JLabel lblOrder = new JLabel("Order Num. / Confirm Code");
		lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrder.setForeground(new Color(0, 0, 102));
		lblOrder.setAlignmentY(Component.TOP_ALIGNMENT);
		lblOrder.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox.add(lblOrder);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setMaximumSize(new Dimension(20, 50));
		horizontalBox.add(horizontalStrut);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setPreferredSize(new Dimension(300, 40));
		textField.setAlignmentY(Component.TOP_ALIGNMENT);
		textField.setMaximumSize(new Dimension(300, 40));
		textField.setForeground(new Color(0, 0, 102));
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox.add(textField);
		textField.setColumns(10);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setMaximumSize(new Dimension(20, 50));
		horizontalBox.add(horizontalStrut_1);
		
		JButton btnSearch = new JButton("ENTER");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSearch.setAlignmentY(Component.TOP_ALIGNMENT);
		horizontalBox.add(btnSearch);
		dockPlan();


		tfSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				/**
				 * Action to search open orders report
				 * to see if it matches the info entered
				 * by visitor
				 */

			}
		});

		tfSearch.setAlignmentX(Component.LEFT_ALIGNMENT);
		tfSearch.setMaximumSize(new Dimension(700, 100));
		tfSearch.setMinimumSize(new Dimension(10, 10));
		tfSearch.setPreferredSize(new Dimension(10, 50));
		tfSearch.setBounds(new Rectangle(0, 0, 200, 100));
		tfSearch.setBorder(new LineBorder(new Color(0, 0, 102)));
		tfSearch.setBackground(new Color(253, 245, 230));

		JTextField tfBlank = new JTextField();
		tfBlank.setBorder(new EmptyBorder(0, 0, 0, 0));
		tfBlank.setMaximumSize(new Dimension(400, 2147483647));
		tfBlank.setVisible(false);

		JButton btn_Search = new JButton("Search");
		btn_Search.setPreferredSize(new Dimension(160, 50));
		btn_Search.setMinimumSize(new Dimension(160, 50));
		btn_Search.setMaximumSize(new Dimension(160, 50));
		btn_Search.setMargin(new Insets(5, 15, 5, 15));
		btn_Search.setForeground(Color.WHITE);
		btn_Search.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Search.setFocusable(false);
		btn_Search.setBorder(
				new BevelBorder(BevelBorder.RAISED, new Color(51, 153, 204), null, new Color(0, 0, 0), null));
		btn_Search.setBackground(new Color(0, 0, 102));
		btn_Search.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		

	}

	public void dockPlan() {
		//Method to display where the driver should
		//go based on the data pulled from open
		//order report
		
	}


}
