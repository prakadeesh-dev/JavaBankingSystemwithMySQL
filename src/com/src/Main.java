package com.src;

import com.src.*;
import java.sql.*;
import java.util.Scanner;


public class Main 
{
    public static void main(String[] args) 
    {
        DatabaseHandler db = new DatabaseHandler();		// initiate connection with the database
        
        Scanner scanner = new Scanner(System.in);		// scan user input from console

        while (true) 
        {
        	System.out.print("\n");
        	 
            System.out.println("1. Create Account");
            
            System.out.println("2. View Accounts");
            
            System.out.println("3. Deposit");
            
            System.out.println("4. Withdraw");
            
            System.out.println("5. Delete Account");
            
            System.out.println("6. Exit");
            
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
           
            switch (choice) 
            {
                case 1:
                	
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    
                    db.createAccount(name, balance);
                    
                    break;
                    
                case 2:
                	
                	 System.out.print("Enter name: ");
                     String searchName = scanner.nextLine();
                     
                     db.viewAccount(searchName);
                     
                     break;
                     
                case 3:
                	
                    System.out.print("Enter Account ID: ");
                    int depositId = scanner.nextInt();
                    
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    
                    db.deposit(depositId, depositAmount);
                    
                    break;
                    
                case 4:
                	
                    System.out.print("Enter Account ID: ");
                    int withdrawId = scanner.nextInt();
                    
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    
                    db.withdraw(withdrawId, withdrawAmount);
                    
                    break;
                    
                case 5:
                	
                    System.out.print("Enter Account ID to delete: ");
                    int deleteId = scanner.nextInt();
                    
                    db.deleteAccount(deleteId);
                    
                    break;
                    
                case 6:
                	
                    System.out.println("Exiting...");
                    
                    scanner.close();
                    
                    return;
                    
                default:
                	
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

