package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;


public class LoginDAOimplementation implements LoginDAO {


    public static LinkedList<String> getList(){
		return loginList;
	}
	
	@Override
	public HashMap<String, String> usernameAndPin() {
		Connection connection = ConnectionManager.getInstance().getConnection();
		HashMap<String, String> users = new HashMap<>();
        String query = "SELECT username, pin FROM atm.account;";

        try (PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
            	users.put(rs.getString("username"), rs.getString("pin"));
            }

        } catch (Exception e) {
            System.err.println(e);
        }

        return users;
	}

	@Override
	public String getRole(String username){
		Connection connection = ConnectionManager.getInstance().getConnection();
		String role = "";
		String query = "SELECT role FROM atm.account WHERE username = ?;";
		
		try (PreparedStatement stmt = connection.prepareStatement(query);){
			stmt.setString(1,username);
                ResultSet rs = stmt.executeQuery();
                
        	if(rs.next()){
            role = rs.getString("role");
        	}
        	
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return role;
				
	}
}
