import java.util.*;

class BankAcc {
    int bal;
    int prevTrans;
    String Name;
    String Id;
    int flag = 0;

    BankAcc(String cName, String cId) {
        Name = cName;
        Id = cId;
    }

    void checkId() {
        System.out.println("Welcome " + Name);
        System.out.println();
        System.out.print("Please enter the Customer ID or PIN: ");
        Scanner id = new Scanner(System.in);
        String chk = id.nextLine();
        if (chk.equals(Id)) {
            showMenu();
        } else {
            System.out.println("Wrong Login INFO!");

            if (flag < 3) {
                flag++;
                checkId();
            }
        }
    }

    void deposit(int amt) {
        if (amt != 0) {
            bal = bal + amt;
            prevTrans = amt;
        }
    }

    void withdraw(int amt) {
        if (this.bal > amt) {
            bal = bal - amt;
            prevTrans = -amt;
        } else {
            System.out.println("Insufficient balance, Withdrawal not Possible");
        }
    }

    void getPrevTrans() {
        if (prevTrans > 0) {
            System.out.println("Deposited: " + prevTrans);
        } else if (prevTrans < 0) {
            System.out.println("Withdraw: " + Math.abs(prevTrans));
        } else {
            System.out.println("No Transaction");
        }
    }

    public void transfer(double amt, BankAcc acc) {
        if (this.bal < amt) {
            System.out.println("Insufficient balance! Transfer Failed!");
        } else {
            this.bal -= amt;
            acc.bal += amt;
            System.out.println("Account of " + this.Name + " has $" + this.bal);
            System.out.println("Account of " + acc.Name + " has $" + acc.bal);
            System.out.println("\n");
        }
    }

    private void showMenu() {
        char opt;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + Name);
        System.out.println("Your ID is  " + Id);
        do {
            System.out.println("\n");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Transfer");
            System.out.println("F. Exit");
            System.out.println("Enter the option");
            opt = sc.next().charAt(0);
            opt = Character.toUpperCase(opt);
            System.out.println("\n");

            switch (opt) {
                case 'A':
                    System.out.println("Balance " + bal);
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("Enter the amount to deposit");
                    int amt = sc.nextInt();
                    deposit(amt);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("Enter the amount to withdraw");
                    int amt2 = sc.nextInt();
                    withdraw(amt2);
                    System.out.println("\n");
                    break;

                case 'D':
                    getPrevTrans();
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("To whom");
                    BankAcc bb = new BankAcc("Father", "9031");
                    System.out.println(bb.Name);
                    System.out.println("Amount to Transfer");
                    double am = sc.nextDouble();
                    transfer(am, bb);
                    break;

                case 'F':
                    break;

                default:

                    System.out.println("Invalid Option!!! Please Enter Again");
            }
        } while (opt != 'F');
        System.out.println("ThankYou!");

    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAcc ba = new BankAcc("Bappy", "6706");
        ba.checkId();
}

}
