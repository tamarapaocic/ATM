package BO;

import DAO.GuestDAOimplementation;

public class GuestHandler {

	GuestDAOimplementation GDAO = new GuestDAOimplementation();
	
	public void register(){
		if(GDAO.register() == true){
			System.out.println(" ");
		}else {
			System.out.println("An error occurred. Please try again later!");
		}
	}
	
	public void transfer() {
		try {  
			GDAO.transfer();
			System.out.println("\nSuccessfully transfered! \n\n");
		}catch(Exception e){
			System.err.println(e);
		}
	}
}
