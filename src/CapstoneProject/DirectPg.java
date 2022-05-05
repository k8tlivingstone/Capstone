package CapstoneProject;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Admin.CurrentOnSite;
import Admin.CurrentOnSiteReport;
import Helper.ExcelHelper;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
//import com.poji.annotation.ExcelCellName;
//import com.poiji.annotation.ExcelRow;

public class DirectPg extends JPanel {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	String TitleMsg;
	private static JTable tableDirect;
	private static JTable tblDirect;
	static Validation val = new Validation();
	static CapstoneProject cp = new CapstoneProject();
	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private JTable tblDirectory;
	private static JTextField tfSearch = new JTextField();
	private static String Employee;

	public static void loadExcel() throws Exception {
		fis = new FileInputStream("/resources/TestDirectory.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Sheet 1");
		fis.close();
	}

	private static JTextField setText(JTextField gettfFName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Create the panel.
	 * 
	 * @throws FileNotFoundException
	 */
	public DirectPg() {
		conn=dB_Connection.getDBConnection();
//		Update_table();
		setBorder(null);
		setMinimumSize(new Dimension(1195, 420));
		setPreferredSize(new Dimension(1220, 530));
		setMaximumSize(new Dimension(1194, 420));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

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
				String excelPath = ("C:\\Users\\klivingstone\\eclipse-workspace\\CapstoneProject\\"
						+ "resources\\Directory.xlsx");
				ExcelHelper eh = new ExcelHelper(excelPath);
				try {
					List<DirectorySort> listDirectorySort = eh.readData(DirectorySort.class.getName());
					DefaultTableModel dtm = new DefaultTableModel();
					dtm.addColumn("FName");
					dtm.addColumn("LName");
					dtm.addColumn("Dept");
					dtm.addColumn("Ext");
					for (DirectorySort ds : listDirectorySort) {
						dtm.addRow(new Object[] { ds.getRecord(), ds.getFname(), ds.getLname(), ds.getDepartment() });
					}
					DirectPg.getTableDirect().setModel(dtm);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
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

		setTableDirect(new JTable());
		getTableDirect().setBounds(10, 10, 416, 197);
		this.add(getTableDirect(), BorderLayout.CENTER);
		
		tblDirectory = new JTable();
		tblDirectory.setCellSelectionEnabled(true);
		tblDirectory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblDirectory.setForeground(new Color(0, 0, 102));
		tblDirectory.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"First Name", "Last Name", "Dept", "Ext"
			}
		));
		add(tblDirectory, BorderLayout.WEST);

	}
	
	private void Update_table(String Employee) {
		try {
			String str = tfSearch.getText();
			String sql = ("SELECT FName LName Dept Ext * FROM Directory WHERE Employee=?");
			pst.setString(1, str);
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			tblDirectory.setModel(DbUtils.resultSetToTableModel(rs));
			if (rs.next()) {
				String s1 = rs.getString(1);
				String s2 = rs.getString(2);
				String s3 = rs.getString(3);
				String s4 = rs.getString(4);
				//set records in textfields
				int ans = JOptionPane.showConfirmDialog(null, "message here","Confirm Contact Person",JOptionPane.YES_NO_CANCEL_OPTION);
				if(ans == JOptionPane.YES_OPTION) {
					//do something - email person and open closing screen
				} else if (ans == JOptionPane.NO_OPTION) {
					tfSearch.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Please enter the Last Name or the Department of the person you are here to meet");
					tfSearch.setText("");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static JTable getTableDirect() {
		return tableDirect;
	}

	private void setTableDirect(JTable tableDirect) {
		this.tableDirect = tableDirect;

	}

}
