package BO;
import java.util.HashMap;
import UI.AdminMenu;
import UI.UserMenu;
import BO.AdminHandler;
import BO.StringUserInput;

public class LoginHandler {

	 AdminHandler adminHandler = new AdminHandler();
	 AdminMenu adminMenu = new AdminMenu();
	 UserMenu userMenu = new UserMenu();
	 StringUserInput stringUserInput = new StringUserInput();

    
	public  void login() {
		String username = stringUserInput.getString("Enter username: ");
		String pin = stringUserInput.getString("Enter pin: ");
		validateAdmin(username, pin);
	}

	public void validateAdmin(String username, String pin) {
		if (validateAdminsAccount(username) && validateAdminsPin(pin)) {
			adminMenu.getAdminMenu();
		} else {
			validateUser(username, pin);
		}
	}

	public  boolean validateAdminsAccount(String username) {
		return username.equalsIgnoreCase("admin");
	}

	public  boolean validateAdminsPin(String pin) {
		return pin.equals("comoestas77");
	}

	public void validateUser(String username, String pin) {
		if (isAccountInList(username)){
			validatePin(username, pin);
		} else {
			System.out.println("Wrong username! Try again!");
			}
	}

	public  boolean isAccountInList(String username) {
		HashMap<String,String> accounts = adminHandler.usernameAndPin();
		return accounts.containsKey(username);
	}

	public  void validatePin(String username, String pin) {
		if (isPinValid(username, pin)){
			userMenu.getUserMenu();
		} else {
			System.out.println("Wrong password! Try again!");
			}
	}

	public  boolean isPinValid(String username, String pin) {
		HashMap<String, String> accounts = adminHandler.usernameAndPin();
		return accounts.get(username).equals(pin);
	}
	
	
}