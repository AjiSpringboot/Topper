package atm;
import java.util.Scanner;

public class ATMInterface {
    private static double balance = 1000.0; // Initial balance (you can change this)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to the ATM Interface!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");
            System.out.print("Please select an option (1-4): ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositFunds(scanner);
                    break;
                case 3:
                    withdrawFunds(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM Interface. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1-4).");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    private static void depositFunds(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        double depositAmount = scanner.nextDouble();

        if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("$" + depositAmount + " has been deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }

    private static void withdrawFunds(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        double withdrawAmount = scanner.nextDouble();

        if (withdrawAmount > 0) {
            if (withdrawAmount <= balance) {
                balance -= withdrawAmount;
                System.out.println("$" + withdrawAmount + " has been withdrawn successfully.");
            } else {
                System.out.println("Insufficient funds. Your current balance is $" + balance);
            }
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
        }
    }
}

