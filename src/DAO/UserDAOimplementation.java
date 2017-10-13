package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.Account;
import BO.DoubleUserInput;
import BO.IntUserInput;

public class UserDAOimplementation implements UserDAO {
	
	 IntUserInput intUserInput = new IntUserInput();
	 DoubleUserInput doubleUserInput = new DoubleUserInput();


	@Override
	public double getBalance(String username) {
		ResultSet rs = null;
        Connection connection = ConnectionManager.getInstance().getConnection();
        double balance = 0;
        try (PreparedStatement pstmt = connection.prepareStatement("SELECT a.balance FROM ATM.Account AS `a` WHERE username = ?")) {

            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                balance =  rs.getDouble("balance");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOimplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return  balance;

	}
	
	@Override
	public void setBalance(Account account,double amount) {
		Connection connection = ConnectionManager.getInstance().getConnection();

        try (PreparedStatement pstmt = connection.prepareStatement("UPDATE ATM.Account SET balance=? WHERE customerID = ? ")) {
     
        	pstmt.setDouble(1, amount);
            pstmt.setInt(2, account.getCustomer().getID());

            pstmt.executeUpdate();

            System.out.println("Balance updated successfully!");

        } catch (SQLException ex) {
            Logger.getLogger(UserDAOimplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}

	@Override
	public void withdraw(Account account,double amount) {
		double balance = getBalance(account.getUsername());
		
		if(balance<amount){
			System.out.println("There is no enough money on your account.");
		}else {
			balance -= amount;
			setBalance(account,balance);
			System.out.println("\n\t\tYou withdrew " + amount + " .\n\t\tCurrent balance: " + balance + ".");

		}		
	}

	@Override
	public void deposit(Account account,double amount) {
    double balance = getBalance(account.getUsername());

			balance += amount;
			setBalance(account,balance);
			System.out.println("\n\t\tYou deposited " + amount + " .\n\t\tCurrent balance: " + balance + ".");

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
