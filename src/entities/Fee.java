package entities;

import java.util.Date;

public class Fee {
	private String name_user;
	private String title;
	private Date check_out_date;
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
	public Date getCheck_out_date() {
		return check_out_date;
	}
	public void setCheck_out_date(Date check_out_date) {
		this.check_out_date = check_out_date;
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
	public Fee(String name_user, String title, Date check_out_date, Date due_date, Double fee) {
		super();
		this.name_user = name_user;
		this.title = title;
		this.check_out_date = check_out_date;
		this.due_date = due_date;
		this.fee = fee;
	}
	public Fee() {
		super();
	}
	
}
