package DTO;

public class Account {

	private Customer customer;
	private int customerID;
	private String username;
	private String pin;
	private double balance;
	private String role;
	
	

	public Account() {
		super();
		this.username = "";
		this.pin = "";
		this.balance = 0;
	}
	
	public Account(String username, String pin) {
		super();
		this.username = username;
		this.pin = pin;
	}
	
	public Account(String username, String pin, double balance) {
		super();
		this.username = username;
		this.pin = pin;
		this.balance = balance;
	}
	

	public Account(int customerID,String username, String pin) {
		super();
		this.customerID = customerID;
		this.username = username;
		this.pin = pin;
	}
	
	public Account(Customer customer,String username, String pin, double balance) {
		super();
		this.customer = customer;
		this.username = username;
		this.pin = pin;
		this.balance = balance;
	}

	public Customer getCustomer(){
		return this.customer;
	}
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString(){
	 return customer.toString() + "\nAccount --> Username: " + username + " Pin: " + pin + " Balance: " + balance + "\n";
	}
	
	
}
