/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingApplication;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class mainClass {
    Scanner inputValue = new Scanner(System.in);
    
    public static void registerMenu(){
        System.out.println("Register Menu");
        System.out.println("=============");
        System.out.println("Please Enter Your Account Name");
        String name = inputValue.nextLine();
        System.out.println("Please Enter Your Password");
        String pin = inputValue.nextLine();
        System.out.println("Please Enter First Deposit Money");
        float deposit = inputValue.nextFloat();
        Account newAccount = new Account(name, pin, deposit);
        System.out.println("Do You Want to Back to Main Menu ? (Y/N)");
        String selectedValue = inputValue.nextLine();
        if(selectedValue == "Y"){
            mainMenu();
        };
    }
    
    public static void mainMenu(){
        System.out.println("Welcome to Simple Banking Application");
        System.out.println("=====================================\n");
        System.out.println("1.Register");
        System.out.println("2.Show Data");
        int selectedOption = inputValue.nextInt();
        if(selectedOption == 1){
            registerMenu();
        }else if(selectedOption == 2){
            mainMenu();
        }
    }
    
    
    public static void main(String[] args) {
        mainMenu();
        
    }
}
