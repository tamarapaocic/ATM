package BO;

import java.util.HashMap;

import DAO.LoginDAOimplementation;
import UI.AdminMenu;
import UI.UserMenu;

public class LoginHandler {


	 AdminMenu adminMenu = new AdminMenu();
	 UserMenu userMenu = new UserMenu();
	 LoginDAOimplementation LDAO = new LoginDAOimplementation();
	 StringUserInput stringUserInput = new StringUserInput();
	 
    
	public  void login() {
		String username = stringUserInput.getString("Enter username: ");
		String pin = stringUserInput.getString("Enter pin: ");
		if (validateUser(username, pin)){
		checkRole(username);
		LoginDAOimplementation.loginList.add(username);
		}
	}
	
	public void logout(){
		LoginDAOimplementation.loginList.removeLast();
	}
	
	 public void checkRole(String username){
		 if(getRole(username).equals("admin")){
			 adminMenu.getAdminMenu();
		 }else {
			 userMenu.getUserMenu();
		 }
	 }
	 
	 
	public String getRole(String username){
		return LDAO.getRole(username);
		}
	
	
        public boolean validateUser(String username, String pin) {
		if (isAccountInList(username)){
			validatePin(username, pin);
                        return true;
		} else {
			System.out.println("Wrong username! Try again!");
                        return false;
			}
	}


        public  boolean isAccountInList(String username) {
		HashMap<String,String> accounts = usernameAndPin();
		return accounts.containsKey(username);
	}

        
   	 public HashMap<String,String> usernameAndPin(){
		 return LDAO.usernameAndPin();
	 }
   	 
   	 
        public  boolean validatePin(String username, String pin) {
		if (isPinValid(username, pin)){
			return true;
		} else {
			System.out.println("Wrong password! Try again!");
            return false;
			}
	}
 
        public  boolean isPinValid(String username, String pin) {
		HashMap<String, String> accounts = usernameAndPin();
		return accounts.get(username).equals(pin);
	}
	
}
