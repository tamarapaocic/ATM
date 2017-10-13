package UI;

import BO.AdminHandler;
import BO.IntUserInput;
import BO.LoginHandler;


public class Menu {

	 LoginHandler loginHandler = new LoginHandler();
	 IntUserInput intUserInput = new IntUserInput();
	 AdminHandler adminHandler = new AdminHandler();
	 
	public void printMainMenu(){
		System.out.println("\tWelcome to ATM! \n\n1.Sign in \n2.Sign up \n3.Deposit \n\nEnter the option 1-3: ");
	}
	
	public int getUserOption(){
		while(true){
			try{
			return intUserInput.getInt("", 1, 3);
		} catch (Exception e){}
	}
	}
	
	public void startApp(){
		printMainMenu();
		int option = getUserOption();
		if (option == 1){
			loginHandler.login();
		} else if(option == 2 ){
			
			//register
			
		} else if(option == 3){
			
			//deposit for guest
		}
		
	}
	
	
}
