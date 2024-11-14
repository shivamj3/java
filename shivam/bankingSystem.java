class Customer {
    private String name;             // ENCAPSULATION
    Account account;                 
    // Constructor
    public Customer(String name, Account account) {
        this.name = name;
        this.account = account;
    }
    // Getter method
    public String getName() {
        return name;
    }
}
class Transaction {
    String type;   // Transaction type Coulf be withdrae or depos
    double amount; // 
    // Constructor 
    public Transaction(double amount) {
        this.type = "Deposit";  //by  Default transaction type = deposite
        this.amount = amount;
    }
    //constructor overloading
    public Transaction(String type, double amount) {
        this.type = type; // imp line
        this.amount = amount;
    }
}
class Account {
    int accountNumber;        
    double balance;          
    Transaction[] transactions=new Transaction[50]; ; // Array to store transaction history , size fixed
    int transactionCount = 0; 
    // Constructor 
    public Account(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    // Method to deposit 
    public void deposit(double amount) {
        if (transactionCount < 50) { // array full or space left checking
            balance += amount;  // Increase balance 
            transactions[transactionCount++] = new Transaction(amount); // updayte transaction arrya
        } else {
            System.out.println("Transaction limit reached.");
        }
    }
    // Method to withdraw 
    public void withdraw(double amount) {
        if (balance >= amount) {  //  balance is sufficient  check for withdrawal
            if (transactionCount < 50) { // array full or space left checking
                balance -= amount;  // Decrease balance 
                transactions[transactionCount++] = new Transaction("Withdrawal", amount);  // updayte transaction arrya
            } else {
                System.out.println("Transaction limit reached");
            }
        } else {
            // Insufficient balance message along with loan offer
            System.out.println("Insufficient balance. Apply for a loan at minimal interest rate.");
        }
    }
}
class SavingsAccount extends Account {
    // Static final interest rate
    static final double INTEREST_RATE = 0.04;  // 4% interest rate
    // Constructor 
    public SavingsAccount(int accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);  // Call the superclass constructor 
    }
}
class CheckingAccount extends Account {
    // Constructor 
    public CheckingAccount(int accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);  // Call the superclass constructor 
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        // Creating a customer with a savings account
        Account savings = new SavingsAccount(12345, 1000);  
        Customer customer = new Customer("shaurya", savings);  
        // Demonstrating deposit and withdrawal operations
        savings.deposit(500);  // Deposit 500 into the account
        savings.withdraw(200); // Withdraw 200 from the accoun
        System.out.println("Customer Name: " + customer.getName());  // Display the customer name using the getter
        System.out.println("Savings Account Number: " + savings.accountNumber); 
        System.out.println("Savings Account Balance: " + savings.balance); 
        System.out.println("Interest Rate for Savings Account: " + SavingsAccount.INTEREST_RATE);
    }
}