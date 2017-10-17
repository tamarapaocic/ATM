package UI;

import BO.IntUserInput;
import DAO.LoginDAOimplementation;
import BO.AdminHandler;

public class AdminMenu {

	 IntUserInput intUserInput = new IntUserInput();
     AdminHandler adminHandler = new AdminHandler();
	 LoginDAOimplementation LDAO = new LoginDAOimplementation();

     
	public  void getAdminMenu(){
		int option;
		do {
    printAdminMenu();
    option = getUserOption();
    if (option == 1){
		adminHandler.getAllCustomersWithAccount();
	} else if(option == 2 ){
        adminHandler.addCustomer();
	} else if(option == 3){
        adminHandler.updateCustomer();
	} else if(option == 4){
        adminHandler.deleteCustomer();
	} else if(option == 5){
        adminHandler.getCustomersInfo();
	} else if(option == 6){
		adminHandler.addAccount();
	} else if(option == 7){
		adminHandler.updateAccount();
	} else if(option == 8){
		adminHandler.deleteAccount();
	} else if(option == 9){
		adminHandler.viewLoggedUsers();
	} else if(option == 10){
		//logout
	}
		}while(option != 10);
    
	}
	
	public void printAdminMenu(){
		System.out.println("\n\tADMIN'S MENU");
		System.out.println("\n1.List of all customers \n2.Add customer \n3.Update customer \n4.Delete customer \n5.Get customer's info \n6.Add account \n7.Update account \n8.Delete account \n9.View all logged users \n10.Logout \n\nEnter the option 1-10: ");
	}
	
	public int getUserOption(){
		while(true){
			try{
			return intUserInput.getInt("", 1, 10);
		} catch (Exception e){}
	}
	}
	
 	
}
