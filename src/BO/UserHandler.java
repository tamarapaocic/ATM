package BO;

import DTO.Account;
import DAO.UserDAOimplementation;

public class UserHandler {

	 UserDAOimplementation UDAO = new UserDAOimplementation();

	 BOHelper boHelper = new BOHelper();
	 IntUserInput intUserInput = new IntUserInput();
	 StringUserInput stringUserInput = new StringUserInput();
	 Account account = new Account();
	 
	public void getBalance(){
		 try{
			 
		 }catch(Exception e){
				System.err.println(e);
		 }
	 }
	 
	 
}
