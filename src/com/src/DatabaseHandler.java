package com.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler
{
    private static final String URL = "jdbc:mysql://localhost:3306/bankdatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private Connection connect;

    public DatabaseHandler() 	// constructor
    {
        try
        {
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println("Welcome to Global Bank");
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    public boolean isUsernameTaken(String name) 
    {
        String query = "SELECT COUNT(*) FROM accounts WHERE name = ?";
        
        try (PreparedStatement pstmt = connect.prepareStatement(query)) 
        {
            pstmt.setString(1, name);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) 
            {
                return true;
            }
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }
    public void createAccount(String name, double balance)
    {
    	 if (isUsernameTaken(name)) 
    	 {
             System.out.println("Username already exists. Please choose a different name.");
             
             return;
         }
    	 
        String query = "INSERT INTO accounts (name, balance) VALUES (?, ?)";
        
        try (PreparedStatement preparestate = connect.prepareStatement(query)) 
        {
            preparestate.setString(1, name);
            
            preparestate.setDouble(2, balance);
            
            preparestate.executeUpdate();
            
            System.out.println("Account created successfully!");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void viewAccount(String name) 
    {
        String query = "SELECT * FROM accounts WHERE name = ?";
        
        try (PreparedStatement preparestate = connect.prepareStatement(query)) 
        {
        	preparestate.setString(1, name);
        	
            ResultSet rs = preparestate.executeQuery();
            
            while (rs.next()) 
            {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Balance: " + rs.getDouble("balance"));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public void deposit(int id, double amount)
    {
        String query = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        
        try (PreparedStatement preparestate = connect.prepareStatement(query))
        {
        	preparestate.setDouble(1, amount);
        	
        	preparestate.setInt(2, id);
        	
        	preparestate.executeUpdate();
            
        	System.out.println("Deposit successful!");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void withdraw(int id, double amount) 
    {
        String query = "UPDATE accounts SET balance = balance - ? WHERE id = ? AND balance >= ?";
        
        try (PreparedStatement preparestate = connect.prepareStatement(query)) 
        {
        	preparestate.setDouble(1, amount);
        	
        	preparestate.setInt(2, id);
        	
        	preparestate.setDouble(3, amount);
        	
            int rowsAffected = preparestate.executeUpdate();
            
            if (rowsAffected > 0) 
            {
                System.out.println("Withdrawal successful!");
            } 
            else 
            {
                System.out.println("Insufficient balance!");
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public void deleteAccount(int id) 
    {
        String query = "DELETE FROM accounts WHERE id = ?";
        
        try (PreparedStatement pstmt = connect.prepareStatement(query)) 
        {
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            
            System.out.println("Account deleted successfully!");
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}
