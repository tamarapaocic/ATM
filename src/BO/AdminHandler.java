package BO;

import java.util.HashMap;
import java.util.List;
import DAO.AdminDAOimplementation;
import DTO.Account;
import DTO.Customer;
import BO.BOHelper;
import BO.IntUserInput;

public class AdminHandler {

	 AdminDAOimplementation ADAO = new AdminDAOimplementation();

	 BOHelper boHelper = new BOHelper();
	 IntUserInput intUserInput = new IntUserInput();
	 StringUserInput stringUserInput = new StringUserInput();

	
	 public HashMap<String,String> usernameAndPin(){
		 return ADAO.usernameAndPin();
	 }
	 
	 /**	Map<String, String> users = adminHandler.usernameAndPin();
		for (Map.Entry entry : users.entrySet()) {
		    System.out.println(entry.getKey() + ": " + entry.getValue()); } **/
	 
	 public void addCustomer(){
		 try{
			 Customer customer = boHelper.getCustomerInfo();
			  ADAO.addCustomer(customer);
			 } catch (Exception e){
		            System.err.println(e);

			 }
		 }
	 

	    public void updateCustomer(){
	    	try{
	    	Customer customer = boHelper.getCustomerInfoWithID();
	    	ADAO.updateCustomer(customer);
	    	}
	    	catch(Exception e){
	    		System.err.println(e);
	    	}
	    }

	    public void deleteCustomer(){
	    	 try {
	    		 int ID = intUserInput.getInt("Enter customer's ID: ",0);
	             ADAO.deleteCustomer(ID);
	         } catch (Exception ex) {
	             System.err.println(ex);
	         }
	    }
	    
		public void getAllCustomersWithAccount(){
			try { 
				List<Account> list = ADAO.getAllCustomersWithAccount();
				 for(Account customer : list) {
			            System.out.println(customer);
			        }

			}catch(Exception e){
				System.err.println(e);
			}
			
		}

		public void getCustomersInfo(){
			try{
				String username = stringUserInput.getString("Enter username: ");
				List<Account> list = ADAO.getCustomersInfo(username);
				for(Account customer : list) {
		            System.out.println(customer);
				}
			}catch(Exception e){
				System.err.println(e);
			}
			
		}

		public void getCustomersID(Customer customer) {
			try{
				int ID = ADAO.getCustomersID(customer);
				System.out.print(ID);
			}catch(Exception e){
				System.err.println(e);
			}
			
		}

	    public void addAccount(){
	    	 try{
				 Account account = boHelper.getAccountInfoWithID();
				  ADAO.addAccount(account);
				 } catch (Exception e){
			            System.err.println(e);

				 }
			 }

	    public void updateAccount(){
	    	try{
				 Account account = boHelper.getAccountInfoWithID();
	    		 int ID = intUserInput.getInt("Enter customer's ID: ",0);
                 ADAO.updateAccount(account, ID);
	    	}catch(Exception e){
	    		 System.err.println(e);
	    	}
	    }

	    public void deleteAccount(){
	    	try {
	    		 int ID = intUserInput.getInt("Enter customer's ID: ",0);
	             ADAO.deleteAccount(ID);
	         } catch (Exception ex) {
	             System.err.println(ex);
	         }
	    }
	
	
}
