package Capstone;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class dB_Connection {
	public String dbstatus;
	static Connection conn = null;
	static String connectionUrl;

	// Connect to database
	public static Connection getDBConnection() {

		try {
			if (conn == null) {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connectionUrl = "jdbc:sqlserver://klcapstone-server.database."
						+ "windows.net:1433;database=cap_2022_driverlogstystem;"
						+ "user=katliv@klcapstone-server;password=OrangeRoad929;"
						+ "encrypt=true;trustServerCertificate=false;"
						+ "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
				conn = DriverManager.getConnection(connectionUrl);
//				JOptionPane.showMessageDialog(null, "Connection Successful");
				//Passed multiple tests and is no longer needed for testing purposes
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		return conn;
	}
}
