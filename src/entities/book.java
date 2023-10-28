package entities;

public class book {
	private int id;
	private String callnumber;
	private String isbn;
	private String title;
	private String author;
	//sadasdsa
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public book(int id, String callnumber, String isbn, String title, String author) {
		super();
		this.id = id;
		this.callnumber = callnumber;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}
	public book() {
		super();
	}
	
}
