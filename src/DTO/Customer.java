package DTO;

public class Customer {

	private int ID;
	private String firstName;
	private String lastName;
	private String JMBG;
	private String email;
	
	public Customer(){
		
	}
	
	public Customer(int ID,String firstName, String lastName, String JMBG, String email) {
		super();
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.JMBG = JMBG;
		this.email = email;
	}
	
	public Customer(String firstName, String lastName, String JMBG, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.JMBG = JMBG;
		this.email = email;
	}
	
	public int getID(){
		return ID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
	public String getJMBG() {
		return JMBG;
	}
	public void setJMBG(String JMBG) {
		this.JMBG = JMBG;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString(){
		return "Customer " + ID + " --> First name: " + firstName + " Last Name: " + lastName + " JMBG: " + JMBG + " Email: " + email;
	}
	
	
	
}
