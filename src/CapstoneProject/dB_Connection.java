package CapstoneProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class dB_Connection {
	public String dbstatus;
	static Connection conn = null;
	static String connectionUrl;
	
	// Connect to database
    public static Connection getDBConnection() {
		
		try {
			if (conn == null) {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connectionUrl = "jdbc:sqlserver://klcapstone-server.database.windows.net:1433;"
						+ "database=capstone;"
						+ "user=katliv@klcapstone-server;password={your_password_here};"
						+ "encrypt=true;trustServerCertificate=false;"
						+ "hostNameInCertificate=*.database.windows.net;"
						+ "loginTimeout=30; ";
				conn = DriverManager.getConnection(connectionUrl);
				JOptionPane.showMessageDialog(null, "Connection Successful");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		return conn;
	}
}
