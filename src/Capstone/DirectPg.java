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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import Capstone.DirectPg;


@SuppressWarnings("serial")
public class DirectPg extends JPanel {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	ResultSet rs1;
	Statement st;

	static JTable table;

	String[] columnNames = { "First Name", "Last Name", "Department", "Extension" };

	String TitleMsg;
	static Validation val = new Validation();
	static Capstone cp = new Capstone();
	public static String Contact;
	private static JTextField tfSearch = new JTextField();
	private JTable tblDirectory;

	@SuppressWarnings("unused")
	private static JTextField setText(JTextField gettfFName) {
		return null;
	}

	/**
	 * Create the panel.
	 * 
	 * @throws FileNotFoundException
	 */
	public DirectPg() {
		Validation.TimerStart(this);
		conn = dB_Connection.getDBConnection();
		setBorder(null);
		setMinimumSize(new Dimension(1195, 420));
		setPreferredSize(new Dimension(1220, 721));
		setMaximumSize(new Dimension(1194, 420));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		show_emp();

		// Title message for directory page
		TitleMsg = String.format("Welcome, who are you here to meet?");
		JLabel lblDirectoryTitle = new JLabel(TitleMsg);
		lblDirectoryTitle.setForeground(new Color(0, 0, 102));
		lblDirectoryTitle.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblDirectoryTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblDirectoryTitle.setBorder(new EmptyBorder(0, 0, 20, 0));
		lblDirectoryTitle.setBounds(272, 48, 646, 61);

		tfSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

//				String str = tfSearch.getText();
//				try {
//					Update_table(str);
//				} catch (SQLException e1) {
//					JOptionPane.showMessageDialog(null, e);
//					e1.printStackTrace();
//				}

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

		Box hBox_search = Box.createHorizontalBox();
		hBox_search.setBorder(new EmptyBorder(10, 10, 10, 10));

		Box hBox_Entry = Box.createHorizontalBox();
		hBox_Entry.add(tfSearch);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		hBox_Entry.add(horizontalStrut_2);

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
		hBox_Entry.add(btn_Search);
		hBox_Entry.add(tfBlank);
		hBox_Entry.setBorder(new EmptyBorder(10, 10, 10, 10));

		Box vBox_Search = Box.createVerticalBox();
		this.add(vBox_Search, BorderLayout.NORTH);
		vBox_Search.add(lblDirectoryTitle);
		vBox_Search.add(hBox_search);
		vBox_Search.add(hBox_Entry);
		vBox_Search.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		tblDirectory = new JTable();
		tblDirectory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(tblDirectory, BorderLayout.CENTER);
	}

	public void show_emp() {

		try {
			String query1 = "SELECT FName, LName, Dept, Ext FROM Directory";
			conn = dB_Connection.getDBConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query1);
			@SuppressWarnings("unused")
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model2 = (DefaultTableModel)tblDirectory.getModel();
			model2.setColumnIdentifiers(columnNames);
			String fname, lname, dept;
			Float ext;
			while(rs.next()) {
				fname=rs.getString(1);
				lname=rs.getString(2);
				dept=rs.getString(4);
				ext=rs.getFloat(6);
				Object [] row = {fname, lname, dept, ext};
				model2.addRow(row);
			}
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
