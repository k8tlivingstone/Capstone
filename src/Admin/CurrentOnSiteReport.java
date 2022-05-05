package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;

public class CurrentOnSiteReport extends JFrame {

	private JPanel contentPane;
	private static JTable tableCurrent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrentOnSiteReport frame = new CurrentOnSiteReport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CurrentOnSiteReport() {
		setTitle("Current Visitors On-Site Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTableCurrent(new JTable());
		getTableCurrent().setBounds(10, 10, 416, 197);
		contentPane.add(getTableCurrent());
		
		JLabel lblViewTime = new JLabel("New label");
		lblViewTime.setFont(new Font("Calibri", Font.BOLD, 14));
		lblViewTime.setBounds(10, 228, 169, 25);
		contentPane.add(lblViewTime);
	}

	public static JTable getTableCurrent() {
		return tableCurrent;
	}

	public void setTableCurrent(JTable tableCurrent) {
		this.tableCurrent = tableCurrent;
	}
}
