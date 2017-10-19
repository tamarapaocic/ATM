package DAO;

import DTO.Account;
import DTO.Customer;
import java.util.List;

public interface AdminDAO {
	
	
    public void addCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(int ID);
    
	public List<Account> getAllCustomersWithAccount();

	public List<Account> getCustomersInfo(String username);
	
	public int getCustomersID(Customer customer);
	
	public int getCustomersID(String username);

    public Account getAccount(int ID);

    public void addAccount(Account account);

    public void updateAccount(Account account,int ID);

    public void deleteAccount(int ID);

    public List<String> getUsernames();
    
    public List<Integer> getIDsFromCustomerTable();
    
    public List<Integer> getIDsFromAccountTable();


    
}
