package UI;

import BO.AdminHandler;
import BO.GuestHandler;
import BO.IntUserInput;
import BO.LoginHandler;


public class Menu {

	 LoginHandler loginHandler = new LoginHandler();
	 AdminHandler adminHandler = new AdminHandler();
	 GuestHandler guestHandler = new GuestHandler();
	 IntUserInput intUserInput = new IntUserInput();

	 
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
			guestHandler.register();
		} else if(option == 3){
			
			//deposit for guest
		}
		
	}
	
	
}
