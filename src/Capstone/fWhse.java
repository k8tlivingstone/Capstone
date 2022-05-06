package Capstone;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class fWhse extends JFrame {

	JPanel Container = new JPanel();
	JScrollPane sPane = new JScrollPane(Container);
	CardLayout clWhse = new CardLayout();
	private WhsePg Whse = new WhsePg();
	private PhotoPg photo = new PhotoPg();
	private NamePg name = new NamePg();
	static Capstone cp = new Capstone();
	private JButton btnCont_Photo = new JButton("NEXT");
	private JButton btnClear = new JButton("CLEAR");
	private JButton btnCont_Name = new JButton("NEXT");
	private final Component horizontalStrut = Box.createHorizontalStrut(20);
	public static String Pur = "";
	public static String Purpose = "warehouse";
	public static String fName;
	public static String lName;
	public static String oRg;
	public static String cTz;
	Connection conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fWhse fWhse = new fWhse();
					fWhse.setExtendedState(fWhse.getExtendedState() | JFrame.MAXIMIZED_BOTH);
					fWhse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fWhse() {
		super("NAU-MAI");
		Pur = "W";
		Capstone.model.add(Pur);
		conn=dB_Connection.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		getContentPane().setLayout(new BorderLayout(0, 0));

		// Holder for the keyboard display
		JPanel Keyboard = new JPanel();
		Keyboard.setPreferredSize(new Dimension(500, 300));
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

		// Button for Photography Message Card
		ButtonFrame.add(hBox2);
		btnCont_Photo.setVisible(false);
		btnCont_Photo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clWhse.show(Container, "m4");
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
				// clear textfields
				NamePg.tfFName.setText("");
				NamePg.tfLName.setText("");
				NamePg.tfOrganization.setText("");
				NamePg.rCitizen_Other.isSelected();
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
				

				clWhse.show(Container, "m4");
				btnCont_Name.setVisible(false);
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


		// Scroll Pane for Cards to be visible
		sPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		Container.setBorder(null);
		Container.setPreferredSize(new Dimension(600, 430));
		Container.setMinimumSize(new Dimension(500, 430));
		getContentPane().add(sPane, BorderLayout.CENTER);

		JPanel pht = new JPanel();
		JPanel whse = new JPanel();
		JPanel nm = new JPanel();

		whse = Whse;
		pht = photo;
		nm = name;

		Container.setLayout(clWhse);
		Container.setMaximumSize(new Dimension(725, 560));
		Container.add(pht, "m2");
		Container.add(whse, "m3");
		Container.add(nm, "m4");
		clWhse.show(Container, "m2");
	}

	@SuppressWarnings("unused")
	private void data_Upload() throws SQLException {
		LocalDate.now();

		String query = "INSERT INTO Visitor_Log(Purpose, FName, LName, Org, Citizen, Dt_in) values(?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement prepstmt = conn.prepareStatement(query);

			prepstmt.setString(2, Pur);
			prepstmt.setString(3, fName);
			prepstmt.setString(4, lName);
			prepstmt.setString(5, oRg);
			prepstmt.setString(6, cTz);

			prepstmt.execute();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

}
