package UI;

import BO.GuestHandler;
import BO.IntUserInput;
import BO.LoginHandler;


public class Menu {

	 LoginHandler loginHandler = new LoginHandler();
	 GuestHandler guestHandler = new GuestHandler();
	 IntUserInput intUserInput = new IntUserInput();

	 
	public void printMainMenu(){
		System.out.println("\tWelcome to ATM! \n\n1.Sign in \n2.Sign up \n3.Transfer \n4.Exit \n\nEnter the option 1-4: ");
	}
	
	public int getUserOption(){
		while(true){
			try{
			return intUserInput.getInt("", 1, 4);
		} catch (Exception e){}
	}
	}
	
	public void startApp(){
		int option = getUserOption();
		if (option == 1){
			loginHandler.login();
		} else if(option == 2 ){
			guestHandler.register();
		} else if(option == 3){
		    guestHandler.transfer();
		} else if(option == 4){
			System.exit(0);
		}
		
	}
	
	public void run(){
		while (true) { 
		printMainMenu();
		startApp();
	        }
	}
	
	
	
}
