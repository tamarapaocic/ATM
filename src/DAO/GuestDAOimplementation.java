package DAO;
import java.util.List;

import BO.BOHelper;
import DAO.UserDAOimplementation;
import DTO.Account;
import DTO.Customer;

public class GuestDAOimplementation implements GuestDAO {

	 AdminDAOimplementation ADAO = new AdminDAOimplementation();
	 UserDAOimplementation UDAO = new UserDAOimplementation();
	 BOHelper boHelper = new BOHelper();

	@Override
	public boolean register() {
		   Customer customer;
        try {
            customer = boHelper.getCustomerInfo();
            ADAO.addCustomer(customer);
            System.out.println("Your ID is: " + ADAO.getCustomersID(customer) + "\n");
            Account account = boHelper.getAccountInfoWithID();
            List<String> usernames = ADAO.getUsernames();
            while (usernames.contains(account.getUsername())) {
                System.out.println("Username already exists, try again:");
                account = boHelper.getAccountInfo();
            }
            ADAO.addAccount(account);
            return true;
        } catch (Exception ex) {
            return false;
            }
        }
	

	@Override
	public void transfer() {
		
	}

}
