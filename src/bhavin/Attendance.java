package bhavin;

import java.sql.*;

@SuppressWarnings("unused")
public class Attendance {
	private int Uid;
	private String Cname;
	private String Status;
	private java.sql.Date  date;
	
	
	
	
	public int getUid() {
		return Uid;
	}
	public void setUid(int uid) {
		Uid = uid;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	
	

}
