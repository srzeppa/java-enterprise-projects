package domain;

import java.io.Serializable;

public class Client implements Serializable {
	
	private long id;
	private String firstname;
	private String lastname;
	private int pesel;
			
	public Client(){
		
	}
	
	public Client(String firstname, String lastname, int pesel){
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.pesel = pesel;	
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getPesel() {
		return pesel;
	}
	public void setPesel(int pesel) {
		this.pesel = pesel;
	}
}
