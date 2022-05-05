package CapstoneProject;

import java.util.*;

public class DirectorySort {
	private int Record;
	private String Fname;
	private String Lname;
	private String Department;

	/********* Getters & Setters **************/
	public int getRecord() {
		return Record;
	}
	public void setRecord(int record) {
		Record = record;
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
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public DirectorySort(int record, String fname, String lname, String department) {
		super();
		Record = record;
		Fname = fname;
		Lname = lname;
		Department = department;
	}
	public DirectorySort() {
		super();
	}
	
}
