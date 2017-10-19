package BO;

import DTO.Account;
import DTO.Customer;


import BO.StringUserInput;
import DAO.AdminDAOimplementation;

public class BOHelper {

    StringUserInput stringUserInput = new StringUserInput();
    DoubleUserInput doubleUserInput = new DoubleUserInput();
    IntUserInput intUserInput = new IntUserInput();
	 AdminDAOimplementation ADAO = new AdminDAOimplementation();

   
	public  Customer getCustomerInfo() {
        String firstName = stringUserInput.getString("Enter first name: ");
        String lastName = stringUserInput.getString("Enter last name: ");
        String JMBG = stringUserInput.getString("Enter JMBG: ");
        String email = stringUserInput.getString("Enter email: ");
        
        return new Customer(firstName, lastName, JMBG, email);
    }
	
	public  Customer getCustomerInfoWithID() {
        String firstName = stringUserInput.getString("Enter first name: ");
        String lastName = stringUserInput.getString("Enter last name: ");
        String JMBG = stringUserInput.getString("Enter JMBG: ");
        String email = stringUserInput.getString("Enter email: ");
        int ID = intUserInput.getInt("Enter ID: ", 0);
        
        return new Customer(ID, firstName, lastName, JMBG, email);
    }
	
	public Account getAccountInfo(){
		 String username = stringUserInput.getString("Enter username: ");
		 String pin = stringUserInput.getString("Enter pin: ");
         Double balance = doubleUserInput.getDouble("Enter balance: ");
         
         return new Account(username, pin, balance);
	}
	
	public Account getAccountInfoWithID(){
		
		int ID;
		String username;
		String pin;

		do{
         ID = intUserInput.getInt("Enter ID: ", 0);
		}while ((ADAO.getIDsFromCustomerTable().contains(ID) != true) || (ADAO.getIDsFromAccountTable().contains(ID) != false));
		username = stringUserInput.getString("Enter username: ");
		 pin = stringUserInput.getString("Enter pin: ");
		 System.out.println();
        return new Account(ID, username, pin);
	    
       
	}
}
