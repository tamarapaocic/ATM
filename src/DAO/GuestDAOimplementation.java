package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import BO.BOHelper;
import BO.DoubleUserInput;
import BO.IntUserInput;
import DAO.UserDAOimplementation;
import DTO.Account;
import DTO.Customer;

public class GuestDAOimplementation implements GuestDAO {

	 AdminDAOimplementation ADAO = new AdminDAOimplementation();
	 UserDAOimplementation UDAO = new UserDAOimplementation();
	 BOHelper boHelper = new BOHelper();
	 IntUserInput intUserInput = new IntUserInput();
	 DoubleUserInput doubleUserInput = new DoubleUserInput();

	@Override
	public boolean register() {
		   Customer customer;
        try {
            customer = boHelper.getCustomerInfo();
            ADAO.addCustomer(customer);
            System.out.println("Your ID is: " + ADAO.getCustomersID(customer) + "\n");
            Account account = boHelper.getAccountInfoWithID();
            List<String> usernames = ADAO.getUsernames();
            
            while (usernames.contains(account.getUsername())) {
                System.out.println("Username already exists, try again:");
                account = boHelper.getAccountInfo();
            }
            ADAO.addAccount(account);
            return true;
            
        } catch (Exception ex) {
            return false;
            }
        }
	

	@Override
	public void transfer(Account account) {
		// ResultSet rs = null;
        Connection connection = ConnectionManager.getInstance().getConnection();
        
        try (PreparedStatement pstmt = connection.prepareStatement(" DELIMITER $$ DROP PROCEDURE IF EXISTS balance_transfer $$ CREATE PROCEDURE balance_transfer() BEGIN SELECT @balance:=balance FROM Account WHERE CustomerID = ?; IF @balance  >= (amount = ?) THEN START TRANSACTION; UPDATE account SET balance = balance - amount WHERE customerID = ?; UPDATE account SET balance = balance + amount WHERE customerID = ?;   COMMIT; END IF; END $$ DELIMITER ;  CALL balance_transfer; " ))
        	
        		 {

            pstmt.setInt(1, account.getCustomer().getID());
            pstmt.setDouble(2, doubleUserInput.getDouble("Enter the amount you want to transfer: ", 0));
            pstmt.setInt(3, account.getCustomer().getID());
            pstmt.setInt(4, intUserInput.getInt("Enter the number of account to which you want to transfer", 0));

           pstmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAOimplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

	}


}
