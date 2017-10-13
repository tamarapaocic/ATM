package DAO;

import DTO.Account;

public interface GuestDAO {

	public boolean register();
	
	public void transfer(Account account);
}
