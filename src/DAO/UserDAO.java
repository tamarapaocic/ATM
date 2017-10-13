package DAO;
import DTO.Account;

public interface UserDAO {

	//login
	
	//logout
	
	public double getBalance(String username);
	
	public void setBalance(Account account,double amount);
	
	public void withdraw(Account account,double amount);
	
	public void deposit(Account account,double amount);
	
	public void transfer(Account account);

	
}
