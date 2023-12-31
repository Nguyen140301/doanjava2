package entities;

import java.util.Date;

public class Details {
	private int id_book;
	private String callnumber;
	private String isbn;
	private String title;
	private String author;
	private int id_user;
	private String name_user;
	private Date check_out_date;
	private Date due_date;
	private String issue_status;
	private Double fee;
	public Details(int id_book, String callnumber, String isbn, String title, String author, int id_user,
			String name_user, Date check_out_date, Date due_date, String issue_status, Double fee) {
		super();
		this.id_book = id_book;
		this.callnumber = callnumber;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.id_user = id_user;
		this.name_user = name_user;
		this.check_out_date = check_out_date;
		this.due_date = due_date;
		this.issue_status = issue_status;
		this.fee = fee;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public int getId_book() {
		return id_book;
	}
	public void setId_book(int id_book) {
		this.id_book = id_book;
	}
	public String getCallnumber() {
		return callnumber;
	}
	public void setCallnumber(String callnumber) {
		this.callnumber = callnumber;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getName_user() {
		return name_user;
	}
	public void setName_user(String name_user) {
		this.name_user = name_user;
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
	public String Issue_status() {
		return issue_status;
	}
	public void setIssue_status(String issue_status) {
		this.issue_status = issue_status;
	}
	public Details(int id_book, String callnumber, String isbn, String title, String author, int id_user,
			String name_user, Date check_out_date, Date due_date, String issue_status) {
		super();
		this.id_book = id_book;
		this.callnumber = callnumber;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.id_user = id_user;
		this.name_user = name_user;
		this.check_out_date = check_out_date;
		this.due_date = due_date;
		this.issue_status = issue_status;
	}
	public String getIssue_status() {
		return issue_status;
	}
	public Details() {
		super();
	}
	
}
