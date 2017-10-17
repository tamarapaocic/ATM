package DAO;

public interface UserDAO {

	
	public double getBalance(String username);
	
	public void setBalance(String username,double amount);
	
	public void withdraw(String username,double amount);
	
	public void deposit(String username,double amount);
	
	public void transfer(int id);

	
}
