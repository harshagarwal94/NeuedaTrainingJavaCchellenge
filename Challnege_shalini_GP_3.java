import java.util.*;

class BankAccount {
    String name;
    double balance;
    String type= "standard";
    
    public BankAccount(String _name, double _balance) {
        this.name = x_name;
        this.balance = _balance;
    }
    
    void deposit(double amount) {
        this.balance += amount;
    }
    
    void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("amount is too high");
        } else {
            this.balance -= amount;
            System.out.println("successfully withdrawl in the system");
        }
    }
    
}

class SavingsAccount extends BankAccount {
    String type = "saving";
    SavingsAccount(String _name, double _balance) {
        super(_name, _balance);
    }
    
    @Override
    void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("amount too high");
        } else if (this.balance - amount < 100) {
            System.out.println("error");
        } else {
            this.balance -= amount;
            System.out.println("successfully withdrawn");
        }
    }
}

class Main  {
    public static void main(String args[]) {
        List<BankAccount> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        char choice;
        
        do {
            System.out.println("Choose an option:\n(a) Add Account\n(l) Display Accounts\n(q) Quit");
            choice = scanner.next().toCharArray()[0];
            switch(choice) {
                case 'a':
                    System.out.println("Type: ");
                    String type = scanner.nextLine();
                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Balance: ");
                    double balance = scanner.nextDouble();
                    if (type.equals("standard")) {
                        BankAccount account = new BankAccount(name, balance);
                        accounts.add(account);
                    } else if (type.equals("saving")) {
                        SavingsAccount account = new SavingsAccount(name, balance);
                        accounts.add(account);
                    } else {
                        System.out.println("choose valid type (standard/saving)");
                        break;
                    }
                    break;
                case 'l':
                    System.out.println("current accounts:\n");
                    for (BankAccount temp: accounts) {
                        System.out.println("Type: " + temp.type);
                        System.out.println("Name: " + temp.name);
                        System.out.println("Balance: " + temp.balance);
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println("retry");
                    break;
            }
        } while (choice != 'q');
        scanner.close();
    }
}
