package UI;

import BO.IntUserInput;
import BO.UserHandler;

public class UserMenu {

	 IntUserInput intUserInput = new IntUserInput();
	 UserHandler userHandler = new UserHandler();
     
	 
	public void getUserMenu(){
		int option;
		do { printUserMenu();
	     option = getUserOption();
			if (option == 1){
	        userHandler.getBalance();
		} else if(option == 2 ){
			userHandler.withdraw();
		} else if(option == 3){
		    userHandler.deposit();
		} else if(option == 4){
			userHandler.transfer();
		} else if(option == 5){
			//logout
		}
		}while(option != 5);
	}
	
	
	public void printUserMenu(){
		System.out.println("\n\tUSER'S MENU");
		System.out.println("\n1.Get balance \n2.Withdraw \n3.Deposit \n4.Transfer \n5.Logout \n\nEnter the option 1-5: ");
	}
	
	
	public int getUserOption(){
		while(true){
			try{
			return intUserInput.getInt("", 1, 5);
		} catch (Exception e){}
	}
	}
	
}
