package entities;

public class account {
	private String name;
	private String pass;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public account(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}
	public account() {
		super();
	}
	
	
}