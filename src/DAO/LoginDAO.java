package DAO;

import java.util.LinkedList;
import java.util.Map;


public interface LoginDAO {
	
	LinkedList<String> loginList = new LinkedList<>();
	
    public Map<String,String> usernameAndPin();

	public String getRole(String username);
	
	public static LinkedList<String> getList(){
		return loginList;
	};
}
