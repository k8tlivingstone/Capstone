package CapstoneProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//SQL process to check-in someone
public class Check_in_Process {
	
	// @Column(name = "Record_id")
    private static Integer recordId;
    // @Basic(optional = false)
    // @Column(name = "Purpose")
    private static String purpose;
    // @Basic(optional = false)
    // @Column(name = "FName")
    private static String fName;
    // @Basic(optional = false)
    //@Column(name = "LName")
    private static String lName;
    // @Basic(optional = false)
    //@Column(name = "Org")
    private static String org;
    // @Basic(optional = false)
    // @Column(name = "Citizen")
    private static String citizen; 
    // @Basic(optional = false)
    // @Column(name = "Dt_in")
    private static String dT_in;
    // @Basic(optional = false)
  //@Column(name = "Status")
    private static String status;
    // @Basic(optional = false)
    //@Column(name = "Contact")
    private static String contact;
    // @Basic(optional = false)
    //@Column(name = "OrderId")
    private static String orderId;
    // @Basic(optional = false)
    //@Column(name = "ConfirmId")
    private static String confirmId;
    // @Basic(optional = false)
    //@Column(name = "Carrier")
    private static String carrier;
    // @Basic(optional = false)
    //@Column(name = "TrailerId")
    private static String trailer;
    // @Basic(optional = false)
    //@Column(name = "SealId")
    private static String seal;
    // @Basic(optional = false)
    
    

    private int user;
    static Validation val = new Validation();
   
    static Connection c = dB_Connection.getDBConnection();
    
    //Add all variables here
    private String name;
    
//    public Check_in_Process() {
//    	
//    }
//    
//    public Check_in_Process(Integer custId) {
//    	this.recordId = custId;
//    }
  
    public Check_in_Process(Integer custId, String fName, String lName, 
    		String org, String citizen, String dT_in, String status, 
    		String contact) {
    	this.recordId = custId;
    	this.fName = fName;
    	this.lName = lName;
    	this.org = org;
    	this.citizen = citizen;
    	this.dT_in = dT_in;
    	this.status = status;
    	this.contact = contact;
    	this.orderId = orderId;
    	this.confirmId = confirmId;
    	this.carrier = carrier;
    	this.trailer = trailer;
    	this.seal = seal;
    }
    /**------------------------------------------------------------- */
    
    
    /**
     * Base Log Table variables getter-setter functions
     * @return
     */
    public static String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    
    public static String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public static String getLName() {
        return lName;
    }

    public void setLName(String lname) {
        this.lName = lname;
    }
    
    public static String getOrg() {
        return org;
    }
    
    public void setOrg(String org) {
        this.org = org;
    }
    
    public static String getCitizen() {
        return citizen;
    }

    public void setCitizen(String citizen) {
        this.citizen = citizen;
    }
    
    public static String getDt_In() {
        return dT_in;
    }

    public void setDt_In(String Dt_in) {
        this.dT_in = Dt_in;
    }
    
    public static String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = "On_Site";
    }
    /**------------------------------------------------------------- */
    
    
    /**
     * Whse Log Table variables getter-setter functions
     * @return
     */
    public void setOrder(String OrderId) {
        this.orderId = OrderId;
    }
    
    public static String getOrder() {
        return orderId;
    }
    
    public void setConfirm(String confirm) {
        this.confirmId = confirm;
    }
    
    public static String getConfirm() {
        return confirmId;
    }
    
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
    
    public static String getCarrier() {
        return carrier;
    }
    
    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
    
    public static String getTrailer() {
        return trailer;
    }
    
    public void setSeal(String seal) {
        this.seal = seal;
    }
    
    public static String getSeal() {
        return seal;
    }
    /**------------------------------------------------------------- */
    

	/**
	 * This method inserts data into database tables BaseLog2022 and 	
	 * WhseLog2022
	 */
	public static void addVisitor() throws SQLException {
		
		String visitorNameQuery = "INSERT INTO BaseLog2022 ([Purpose],"
				+ "[Fname],[Lname],[Org],[Citizen],[Dt_In],[Dt_Out],"
				+ "[Contact]) values(?, ?, ?, ?, ?, ?, ?, ?) ";
		String whseDetailQuery = "INSERT INTO WhseLog2022 ([OrderId],"
				+ "[ConfirmId],[Carrier],[Trailer],[Seal]) values(?, ?, ?, ?, ?)";
		PreparedStatement pstUser = c.prepareStatement(visitorNameQuery, Statement.RETURN_GENERATED_KEYS);
		PreparedStatement pstWhse = c.prepareStatement(whseDetailQuery);
		
		pstUser.setString(1, getPurpose());
		pstUser.setString(2, getFName());
		pstUser.setString(3, getLName());
		pstUser.setString(4, getOrg());
		pstUser.setString(5, getCitizen());
		pstUser.setString(6, getDt_In());
		pstUser.setString(9, getContact());
		
		pstUser.executeUpdate();
		
		ResultSet rs = pstUser.getGeneratedKeys();
		
		if (rs.next()) {
			try {
				int userID = rs.getInt(1);
				pstWhse.setString(1, getOrder());
				pstWhse.setString(2, getConfirm());
				pstWhse.setString(3, getCarrier());
				pstWhse.setString(4, getTrailer());
				pstWhse.setString(5, getSeal());
				
				pstWhse.executeUpdate();
			} catch (SQLException e) {
				try {
					val.unexpectedError(e.toString());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
