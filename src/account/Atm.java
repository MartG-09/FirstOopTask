package account;

import javax.swing.*;

public class Atm {

    private static final Bank myBank = new Bank();

    public static void main(String[] args) {
        goToMainMenu();
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static void goToMainMenu() {

        String menu = """
        
        ==========================
        == WELCOME TO DRILL ATM ==
        ==========================
            1. Create Account
            2. Check Balance
            3. Deposit
            4. Withdraw
            5. Transfer
            0. Exit
        ==========================
        """;

        String option = input(menu);

        switch(option) {
            case "1": createAccount(); break;
            case "2": checkBalance(); break;
            case "3": deposit(); break;
            case "4": withdraw(); break;
            case "5": transfer(); break;
            case "0": exit(); break;
            default: JOptionPane.showMessageDialog(null, "Invalid input! Try Again"); goToMainMenu(); break;
        }
    }

    public static void createAccount() {

        String name = input("Enter Account Name: ");
        if(name == null)
            JOptionPane.showMessageDialog(null, "Invalid, Try Again");

        String pin = input("Enter you Pin: ");
        if(name == null || pin == null)
            JOptionPane.showMessageDialog(null, "Invalid, Try Again");

        String bankName = input("Enter Bank Name: ");
        if(name == null || pin == null || bankName == null)
            JOptionPane.showMessageDialog(null, "Invalid, Try Again");

        Account account = myBank.createAccount(name, pin, bankName);
        JOptionPane.showMessageDialog(null, "Your Account has successfully been created!"  + "\n" + "Your Account Number is " + account.getAccountNumber());
        goToMainMenu();
    }

    public static void checkBalance() {
        try {
            String accountNumber = input("Enter Account Number: ");
            String pin = input("Enter Pin: ");

            JOptionPane.showMessageDialog(null, "Your Balance is " + myBank.checkBalance(accountNumber, pin));
        } catch (Exception e) {
            JOptionPane.showInputDialog(null, e.getMessage(), JOptionPane.ERROR_MESSAGE);
        } finally {
            goToMainMenu();
        }
    }


public static void deposit() {
        try {
            String accountNumber = input("Enter Account Number: ");
            int amount = Integer.parseInt(input("Enter Amount: "));

            myBank.deposit(accountNumber, amount);
            JOptionPane.showMessageDialog(null, "You have successfully deposited " + amount);
        } catch (Exception e) {
            JOptionPane.showInputDialog(null, e.getMessage(), JOptionPane.ERROR_MESSAGE);
        } finally {
            goToMainMenu();
        }
    }

    public static void withdraw() {
        try {
            String accountNumb = input("Enter Account Number: ");
            String Pin = input("Enter Pin: ");
            int amounts = Integer.parseInt(input("Enter Amount: "));

            myBank.withdraw(accountNumb, Pin, amounts);
            JOptionPane.showMessageDialog(null, "You have successfully withdrawn " + amounts);
        } catch (Exception e) {
            JOptionPane.showInputDialog(null, e.getMessage(), JOptionPane.ERROR_MESSAGE);
        } finally {
            goToMainMenu();
        }
    }

    public static void transfer() {
        try {
            String senderAccountNumber = input("Enter your Account Number: ");
            String pins = input("Enter your Pin: ");
            String receiverAccountNumber = input("Enter Recipient's Account Number: ");
            int amount = Integer.parseInt(input("Enter Amount: "));

            Account myAccount = myBank.findAccount(receiverAccountNumber);

            myBank.transfer(senderAccountNumber, pins, receiverAccountNumber, amount);
            JOptionPane.showMessageDialog(null, "You have successfully transferred " + amount + " to " + myAccount.getAccountName() + "'s account.");
        } catch (Exception e) {
            JOptionPane.showInputDialog(null, e.getMessage(), JOptionPane.ERROR_MESSAGE);
        } finally {
            goToMainMenu();
        }
    }

    public static void exit() {
        JOptionPane.showMessageDialog(null, "Thank you for banking with us...");
        System.exit(0);
    }


    public static String input(String message) {
        return JOptionPane.showInputDialog(message);
    }

}
