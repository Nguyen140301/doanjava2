package entities;

import java.util.Date;

public class Fee {
	private String name_user;
	private String title;
	private Date return_date;
	private Date due_date;
	private Double fee;
	public String getName_user() {
		return name_user;
	}
	public void setName_user(String name_user) {
		this.name_user = name_user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date Return_date) {
		this.return_date = return_date;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public Fee(String name_user, String title, Date return_date, Date due_date, Double fee) {
		super();
		this.name_user = name_user;
		this.title = title;
		this.return_date = return_date;
		this.due_date = due_date;
		this.fee = fee;
	}
	public Fee() {
		super();
	}
	
}
