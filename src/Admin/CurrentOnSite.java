package Admin;

import java.util.*;

public class CurrentOnSite {
	private int RecordId;	
	private String Purpose;	
	private String Fname;	
	private String Lname;	
	private String Org;	
	private String Citizen;	
	private String Status;	
	private String Contact;	
	private Date Dt_In;	
	private Date Dt_Out;
	
	public int getRecordId() {
		return RecordId;
	}
	public void setRecordId(int recordId) {
		RecordId = recordId;
	}
	public String getPurpose() {
		return Purpose;
	}
	public void setPurpose(String purpose) {
		Purpose = purpose;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getOrg() {
		return Org;
	}
	public void setOrg(String org) {
		Org = org;
	}
	public String getCitizen() {
		return Citizen;
	}
	public void setCitizen(String citizen) {
		Citizen = citizen;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public Date getDt_In() {
		return Dt_In;
	}
	public void setDt_In(Date dt_In) {
		Dt_In = dt_In;
	}
	public Date getDt_Out() {
		return Dt_Out;
	}
	public void setDt_Out(Date dt_Out) {
		Dt_Out = dt_Out;
	}
	public CurrentOnSite(String id, String name, int recordId, String purpose, String fname, String lname, String org,
			String citizen, String status, String contact, Date dt_In, Date dt_Out) {
		super();
		RecordId = recordId;
		Purpose = purpose;
		Fname = fname;
		Lname = lname;
		Org = org;
		Citizen = citizen;
		Status = status;
		Contact = contact;
		Dt_In = dt_In;
		Dt_Out = dt_Out;
	}
	public CurrentOnSite() {
		super();
	}
	
	
	

}
