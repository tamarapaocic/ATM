package DAO;

import DTO.Account;
import DTO.Customer;
import java.util.List;
import java.util.Map;

public interface AdminDAO {
	
	//login
	
	//logout

    public void addCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(int ID);
    
	public List<Account> getAllCustomersWithAccount();

	public List<Account> getCustomersInfo(String username);

    public Account getAccount(int ID);

    public Map<String,String> usernameAndPin();

    public void addAccount(Account account);

    public void updateAccount(Account account,int ID);

    public void deleteAccount(int ID);

	
    
}
