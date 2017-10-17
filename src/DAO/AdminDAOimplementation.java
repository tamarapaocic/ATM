package DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DTO.Account;
import DTO.Customer;

public class AdminDAOimplementation implements AdminDAO {


	private PreparedStatement prepareStatement(Customer customer) throws SQLException {
        Connection connection = ConnectionManager.getInstance().getConnection();
        String query = "INSERT INTO ATM.Customer (firstName, lastName, JMBG, email) VALUES(?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, customer.getFirstName());
        statement.setString(2, customer.getLastName());
        statement.setString(3, customer.getJMBG());
        statement.setString(4, customer.getEmail());
      
        return statement;
    }
	
	private PreparedStatement prepareUpdateStatement(Customer customer) throws SQLException {
        Connection connection = ConnectionManager.getInstance().getConnection();
        String query = "UPDATE ATM.Customer as `c` SET c.firstName =?, c.lastName=?, c.JMBG=?, c.eMail=? WHERE c.ID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, customer.getFirstName());
        statement.setString(2, customer.getLastName());
        statement.setString(3, customer.getJMBG());
        statement.setString(4, customer.getEmail());
        statement.setInt(5, customer.getID());

        return statement;
    }
	

	@Override
	public void addCustomer(Customer customer) {
		try (PreparedStatement pstmt = prepareStatement(customer)) {

            pstmt.executeUpdate();
            System.out.println("Customer added successfully!");

        } catch (SQLException ex) {
            System.err.println(ex);
        }
	}


	@Override
	public void updateCustomer(Customer customer) {
		try (PreparedStatement pstmt = prepareUpdateStatement(customer)) {

            pstmt.executeUpdate();
            System.out.println("Customer's info changed successfully!");

        } catch (SQLException ex) {
            System.err.println(ex);
        }
		
	}


	@Override
	public void deleteCustomer(int ID) {
		Connection connection = ConnectionManager.getInstance().getConnection();
        String query = "DELETE FROM `Customer` WHERE ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, ID);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
	}


	@Override
	public List<Account> getCustomersInfo(String username) {
		List<Account> customers = new ArrayList<>();
        Connection connection = ConnectionManager.getInstance().getConnection();
        String query = "SELECT c.ID, c.firstName, c.lastName, c.JMBG, c.email, a.username, a.pin, a.balance FROM Customer as `c` INNER JOIN Account as `a` ON c.ID = a.customerID  WHERE a.username = '" + username + "';";
        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
        customers.add(new Account((new Customer(rs.getInt("ID"),rs.getString("firstName"), rs.getString("lastName"), rs.getString("JMBG"), rs.getString("email"))), rs.getString("username"),rs.getString("pin"),rs.getDouble("balance")));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return customers;
	}

	@Override
	public int getCustomersID(Customer customer) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        String query = "SELECT c.ID FROM Customer as `c` WHERE firstName = '" + customer.getFirstName() + "';";
        int ID = -1;
        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
        	if(rs.next()){
         ID = rs.getInt("ID");
        	}
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return ID;
	}
	
	@Override
	public int getCustomersID(String username) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        String query = "SELECT a.customerID FROM Account as `a` WHERE username = '" + username + "';";
        int ID = -1;
        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
        	if(rs.next()){
         ID = rs.getInt("customerID");
        	}
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return ID;
	}
	
	
	@Override
	public List<Account> getAllCustomersWithAccount() {
		List<Account> customers = new ArrayList<>();
        Connection connection = ConnectionManager.getInstance().getConnection();
        String query = "SELECT c.ID, c.firstName, c.lastName, c.JMBG, c.email, a.username, a.pin, a.balance FROM Customer as `c` INNER JOIN Account as `a` ON c.ID = a.customerID;";
        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
        customers.add(new Account((new Customer(rs.getInt("ID"),rs.getString("firstName"), rs.getString("lastName"), rs.getString("JMBG"), rs.getString("email"))), rs.getString("username"),rs.getString("pin"),rs.getDouble("balance")));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return customers;
	}
	

	@Override
	public Account getAccount(int ID) {
		ResultSet rs = null;
        Connection connection = ConnectionManager.getInstance().getConnection();

        try (PreparedStatement pstmt = connection.prepareStatement("SELECT a.username, a.pin, a.balance FROM ATM.Account AS a WHERE customerID = ?")) {

            pstmt.setInt(1, ID);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Account(rs.getString("username"), rs.getString("pin"),rs.getDouble("balance"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAOimplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
	}


	

	@Override
	public void addAccount(Account account) {
		Connection connection = ConnectionManager.getInstance().getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Account(customerID,username, pin) VALUES(?,?,?);")) {
            pstmt.setInt(1, account.getCustomerID());
        	pstmt.setString(2, account.getUsername());
            pstmt.setString(3, account.getPin());

            pstmt.executeUpdate();
            System.out.println("Account added successfully!");

        } catch (SQLException ex) {
           Logger.getLogger(AdminDAOimplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}


	@Override
	public void updateAccount(Account account,int ID) {
		Connection connection = ConnectionManager.getInstance().getConnection();

        try (PreparedStatement pstmt = connection.prepareStatement("UPDATE Account SET username=? , pin = ? WHERE customerID = ? ")) {
     
        	pstmt.setString(1, account.getUsername());
            pstmt.setString(2, account.getPin());
            pstmt.setInt(3, account.getCustomer().getID());

            pstmt.executeUpdate();

            System.out.println("User info changed successfully!");

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAOimplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}


	@Override
	public void deleteAccount(int ID) {
		Connection connection = ConnectionManager.getInstance().getConnection();

        String query = "DELETE * FROM ATM.Account WHERE customerID = ID";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAOimplementation.class.getName()).log(Level.SEVERE, null, ex);
        }		
	}


	@Override
    public List<String> getUsernames() {
        Connection connection = ConnectionManager.getInstance().getConnection();
        List<String> usernames = new ArrayList<>();

        String query = "SELECT username FROM ATM.account;";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                usernames.add(rs.getString("username"));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return usernames;
    }
	
	
	
}
