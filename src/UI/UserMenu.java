package UI;

import BO.IntUserInput;
import BO.UserHandler;

public class UserMenu {

	 IntUserInput intUserInput = new IntUserInput();
	 UserHandler userHandler = new UserHandler();
	 
	public void getUserMenu(){
		printUserMenu();
	    int option = getUserOption();
	    if (option == 1){
			// userHandler.getBalance();
		} else if(option == 2 ){
			// userHandler.withdraw();
		} else if(option == 3){
		    // userHandler.deposit();
		} else if(option == 4){
			// userHandler.transfer();
		} 
	}
	
	public void printUserMenu(){
		System.out.println("\n1.Get balance \n2.Withdraw \n3.Deposit \n4.Transfer \n\nEnter the option 1-4: ");
	}
	
	
	public int getUserOption(){
		while(true){
			try{
			return intUserInput.getInt("", 1, 8);
		} catch (Exception e){}
	}
	}
	
}
