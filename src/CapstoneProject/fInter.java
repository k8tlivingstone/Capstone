package CapstoneProject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class fInter extends JFrame {
	
	private JFrame frame2;
	static Validation val = new Validation();

//	private JPanel contentPane;
	private boolean flag;
	private JButton btnClear = new JButton("Clear");
	private JButton btnCont_Name = new JButton("Next");
	private JButton btnCont_Photo = new JButton("Continue");
	private JButton btnCont_Direct = new JButton("Next");
	private JButton btnCont_Close = new JButton("Ok");
	JPanel Cards = new JPanel();
//	public static Interview frame2;
	JScrollPane scrollPane = new JScrollPane(Cards);
//	static Validation val = new Validation();
	static CapstoneProject cp = new CapstoneProject();
	static MenuPage mp = new MenuPage();
	static NamePg n = new NamePg();
	static String fn;
	static String ln;
	static String o = NamePg.tfOrganization.getText();
	static boolean ctz = false;
	static String ctzn = null;

	// top section of application for interviewee options
	CardLayout clInter = new CardLayout();
	private SafetyPg safetyPg = new SafetyPg();
	private NamePg namePg = new NamePg();
	private PhotoPg photoPg = new PhotoPg();
	private DirectPg directPg = new DirectPg();
	private CloserPg exitPg = new CloserPg();
	static String path;
	JPanel contentPane;
	
//	static Map<String, Integer> tMap = new TreeMap<>();
	static ArrayList<String> values = new ArrayList<>();
	
	final JFileChooser fc = new JFileChooser();
	
	public void InterviewTest() {
		try {
			frame2 = new JFrame("Inter");
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setLocationByPlatform(true);
			frame2.setExtendedState(frame2.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			
			val.TimerStart(frame2);
			
			contentPane = new JPanel();
			contentPane.setLayout(new FlowLayout());
			
//			cl_Int = new clInter(this);
//			contentPane.add(cl_Int, BUTTONFRAME);

			frame2.getContentPane().add(contentPane);
			frame2.pack();
			frame2.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		public void swapView(String key) {
//			CardLayout cardLayout = (CardLayout) cl_Int.getLayout();
//		}
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					frame2 = new Interview();
//					frame2.setVisible(true);
//					frame2.setExtendedState(frame2.getExtendedState() | JFrame.MAXIMIZED_BOTH);
//					val.TimerStart(frame2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		StringBuilder cmd = new StringBuilder();
		cmd.append(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java ");
		for (String jvmArg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
			cmd.append(jvmArg + " ");
		}
		cmd.append("-cp ").append(ManagementFactory.getRuntimeMXBean().getClassPath()).append(" ");
		cmd.append(CapstoneProject.class.getName()).append(" ");
		for (String arg : args) {
			cmd.append(arg).append(" ");
		}
		Runtime.getRuntime().exec(cmd.toString());
		System.exit(0);
	}

	/**
	 * Create the frame.
	 */
	public fInter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1255, 689);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel ButtonFrame = new JPanel();
		ButtonFrame.setBackground(Color.WHITE);
		getContentPane().add(ButtonFrame, BorderLayout.CENTER);
		btnClear.setVisible(false);
		ButtonFrame.add(btnClear);

		JButton btnCont_Safe = new JButton("Continue");
		ButtonFrame.add(btnCont_Safe);
		btnCont_Safe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clInter.show(Cards, "int_2");
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
		Box horizontalBox = Box.createHorizontalBox();
		ButtonFrame.add(horizontalBox);
		horizontalBox.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Details about the clear button
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NamePg.tfFName.setText(" ");
				NamePg.tfLName.setText(" ");
				NamePg.tfOrganization.setText(" ");
				NamePg.rCitizen_Other.setSelected(true);
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
		btnCont_Name.setVisible(false);
		ButtonFrame.add(btnCont_Name);

		
		// Photo Policy button setup
		btnCont_Photo.setVisible(false);
		btnCont_Photo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clInter.show(Cards, "int_3");
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
		horizontalBox.add(btnCont_Photo);

		// Details about the Next button on the Name Screen
		btnCont_Name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				fn = NamePg.tfFName.getText();
				ln = NamePg.tfLName.getText();
				cp.model.add(fn);
				cp.model.add(ln);
				if (o.isBlank()) {
					 String other = "NA";
					cp.model.add(other);
				} else {
					cp.model.add(o);
				}
				
				
				if(NamePg.rCitizen_Yes.isSelected()) {
					ctz = true;
					ctzn = "good";
					cp.model.add("Yes");
					System.out.println("Yes checked");
				} else if (NamePg.rCitizen_No.isSelected()) {
					ctz = false;
					cp.model.add("No");
					ctzn = "good";
					System.out.println("No checked");
				} else if (NamePg.rCitizen_Other.isSelected()) {
					ctzn = "bad";
					System.out.println("Skipped");
					JOptionPane.showMessageDialog(null, "Please complete the citizenship "
							+ "question to proceed");
				}
				else {
					ctzn = "bad";
					System.out.println("Skipped");
					JOptionPane.showMessageDialog(null, "Please complete the citizenship "
							+ "question to proceed");
				}
				
				if (ctzn == "good") {
				clInter.show(Cards, "int_5");
				btnCont_Name.setVisible(false);
				btnCont_Direct.setVisible(true);
				} else {
					
				}

			}

		});

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

		// Details about the Next button
		btnCont_Direct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clInter.show(Cards, "int_6"); // raising the closing card
				btnCont_Direct.setVisible(false); // hide the select button
				btnCont_Close.setVisible(true); // make the ok button on the closing card visible
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				String CinDt = new String();
				CinDt = String.format(dtf.format(now));
				cp.model.add(CinDt);
			}

		});

		btnCont_Direct.setPreferredSize(new Dimension(160, 50));
		btnCont_Direct.setMinimumSize(new Dimension(160, 50));
		btnCont_Direct.setMaximumSize(new Dimension(160, 50));
		btnCont_Direct.setMargin(new Insets(5, 15, 5, 15));
		btnCont_Direct.setHorizontalAlignment(SwingConstants.CENTER);
		btnCont_Direct.setForeground(Color.WHITE);
		btnCont_Direct.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCont_Direct.setFocusable(false);
		btnCont_Direct.setBorder(
				new BevelBorder(BevelBorder.RAISED, new Color(51, 153, 204), null, new Color(0, 0, 0), null));
		btnCont_Direct.setBackground(new Color(0, 0, 102));
		btnCont_Direct.setAlignmentY(0.0f);
		btnCont_Direct.setVisible(false);
		ButtonFrame.add(btnCont_Direct);

		// Details about the Next button
		btnCont_Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCont_Direct.setVisible(false);
				btnClear.setVisible(false);
				btnCont_Close.setVisible(true);

				dispose();
				CapstoneProject window = new CapstoneProject();
				window.frame.setVisible(true);
			}
		});

		btnCont_Close.setPreferredSize(new Dimension(160, 50));
		btnCont_Close.setMinimumSize(new Dimension(160, 50));
		btnCont_Close.setMaximumSize(new Dimension(160, 50));
		btnCont_Close.setMargin(new Insets(5, 15, 5, 15));
		btnCont_Close.setHorizontalAlignment(SwingConstants.CENTER);
		btnCont_Close.setForeground(Color.WHITE);
		btnCont_Close.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCont_Close.setFocusable(false);
		btnCont_Close.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(51, 153, 204), null, new Color(0, 0, 0), null));
		btnCont_Close.setBackground(new Color(0, 0, 102));
		btnCont_Close.setAlignmentY(0.0f);
		btnCont_Close.setVisible(false);
		ButtonFrame.add(btnCont_Close);

		getContentPane().add(scrollPane, BorderLayout.NORTH);
		JPanel safety = new JPanel();
		JPanel name = new JPanel();
		JPanel photo = new JPanel();
		JPanel direct = new JPanel();
		JPanel closer = new JPanel();
		safety = safetyPg;
//		name = namePg;
//		photo = photoPg;
//		direct = directPg;
//		closer = exitPg;

		Cards.setLayout(clInter);
		Cards.setMaximumSize(new Dimension(925, 660));
		Cards.add(safety, "int_1");
		Cards.add(photo, "int_2");
		Cards.add(name, "int_3");
		Cards.add(direct, "int_5");
		Cards.add(closer, "int_6");
		clInter.show(Cards, "1");

	}

	/**
	 * Opens the directory file
	 * 
	 */
	public void actionPerformed(ActionEvent evt) {
		try {
			FileInputStream file = new FileInputStream(
	                new File("resources/PSI_Marvo_VisitorLog.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			XSSFSheet sheet = workbook.getSheetAt(1);
			Iterator<Row> rowIterator = sheet.iterator();
			
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					
				} System.out.println("");
			} file.close();
		}
		 catch (Exception e) {
			 e.printStackTrace();
		 }

	}

	/**
	 * check that the data is the correct format
	 *
	 * @return boolean flag
	 */
	@SuppressWarnings("static-access")
	private boolean chkFormats() {
		boolean flag = true;

        if (!fn.isEmpty() && !ln.isEmpty()) {
            if (!val.chkNum(fn)) {
            	NamePg.tfFName.setText("");
                flag = false;
            } else if (!val.chkNum(ln)) {
            	NamePg.tfLName.setText("");
                flag = false;
            }
            else {
                flag = true;
            }
        }
		return flag;
	}

	/**
	 * Check if the required field is empty. changes color
	 *
	 * @return boolean flag
	 */
	private boolean chkData() {
		boolean flag = true;

        if (fn.isBlank() || ln.isBlank()) {
        	System.out.println("name cells empty");
            flag = false;
        } else {
        	System.out.println("name cells are NOT empty");
        	flag = true;
        }
        if (!flag) {
        	JOptionPane.showMessageDialog(null, "Enter your name. Please "
        			+ "try again!");
        }
		return flag;
	}

}
