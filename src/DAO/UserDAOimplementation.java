package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import BO.DoubleUserInput;
import BO.IntUserInput;

public class UserDAOimplementation implements UserDAO {
	
	 IntUserInput intUserInput = new IntUserInput();
	 DoubleUserInput doubleUserInput = new DoubleUserInput();
	 AdminDAOimplementation ADAO = new AdminDAOimplementation();


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
	public void setBalance(String username,double amount) {
		Connection connection = ConnectionManager.getInstance().getConnection();
		
        try (PreparedStatement pstmt = connection.prepareStatement("UPDATE ATM.Account SET balance=? WHERE username = ? ")) {
     
        	pstmt.setDouble(1, amount);
            pstmt.setString(2, username);

            pstmt.executeUpdate();

            System.out.println("Balance updated successfully!");

        } catch (SQLException ex) {
            Logger.getLogger(UserDAOimplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}

	@Override
	public void withdraw(String username,double amount) {
		double balance = getBalance(username);
		
		if(balance<amount){
			System.out.println("There is no enough money on your account.");
		}else {
			balance -= amount;
			setBalance(username,balance);
			System.out.println("\n\tYou withdrew " + amount + " .\n\tCurrent balance: " + balance + ".\n");

		}		
	}

	@Override
	public void deposit(String username,double amount) {
    double balance = getBalance(username);

			balance += amount;
			setBalance(username,balance);
			System.out.println("\n\t\tYou deposited " + amount + " .\n\t\tCurrent balance: " + balance + ".");

	}

	@Override
	public void transfer() {

		Connection connection = ConnectionManager.getInstance().getConnection();
        // connection.setAutoCommit(false);
        try (PreparedStatement pstmt = connection.prepareStatement(" DELIMITER $$ DROP PROCEDURE IF EXISTS balance_transfer $$ CREATE PROCEDURE balance_transfer() BEGIN SELECT @balance:=balance FROM Account WHERE CustomerID = ?; IF (@balance  >= ?) THEN START TRANSACTION; UPDATE account SET balance = (balance - ?) WHERE customerID = ?; UPDATE account SET balance = (balance + ?) WHERE customerID = ?;   COMMIT; END IF; END $$ DELIMITER ;  CALL balance_transfer; " ))
        	
        		 {
            double amount = doubleUserInput.getDouble("Enter the amount you want to transfer: ", 0);
            int ID = intUserInput.getInt("Enter your ID: ", 0);
            pstmt.setInt(1, ID);
            pstmt.setDouble(2, amount);
            pstmt.setDouble(3, amount);
            pstmt.setInt(4, ID);
            pstmt.setDouble(5, amount);
            pstmt.setInt(6, intUserInput.getInt("Enter the number of account to which you want to transfer: ", 0));

            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOimplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

	}

	
}
