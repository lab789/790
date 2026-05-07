import java.util.Scanner;

class ATM {

    double balance = 10000;

    void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid Amount");
        }

        balance = balance + amount;
        System.out.println("Money Deposited");
    }

    void withdraw(double amount) {

        if (amount > balance) {
            throw new ArithmeticException("Insufficient Balance");
        }

        balance = balance - amount;
        System.out.println("Money Withdrawn");
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ATM a = new ATM();

        try {

            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    a.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter Amount: ");
                    double d = sc.nextDouble();

                    a.deposit(d);
                    a.checkBalance();
                    break;

                case 3:
                    System.out.print("Enter Amount: ");
                    double w = sc.nextDouble();

                    a.withdraw(w);
                    a.checkBalance();
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }

        catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        catch (Exception e) {
            System.out.println("Invalid Input");
        }

        finally {
            System.out.println("Thank You");
        }

        sc.close();
    }
}
