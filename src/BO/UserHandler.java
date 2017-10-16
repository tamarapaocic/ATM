package BO;

import DTO.Account;
import DAO.LoginDAOimplementation;
import DAO.UserDAOimplementation;

public class UserHandler {

	 UserDAOimplementation UDAO = new UserDAOimplementation();
	 LoginDAOimplementation LDAO = new LoginDAOimplementation();
	 BOHelper boHelper = new BOHelper();
	 IntUserInput intUserInput = new IntUserInput();
	 StringUserInput stringUserInput = new StringUserInput();
	 Account account = new Account();
	 
	public void getBalance(){
		 try{
			 String username = LoginDAOimplementation.loginList.getLast();
			 double balance = UDAO.getBalance(username);
			 System.out.println("Your current balance is " + balance + "\n");
		 }catch(Exception e){
				System.err.println(e);
		 }
	 }
	 
	public void transfer() {
		try {  
			UDAO.transfer();
			System.out.println("\nSuccessfully transfered!");
		}catch(Exception e){
			System.out.println("An error occurred. Please try again later!");
			System.err.println(e);
		}
	}
	 
}
