package ocjp_cerification_concepts.encapsulation;
//Explanation of Concepts:
//Spotting Encapsulation Errors:
//        Fields like accountHolderName and balance are private.
//        Proper access via getter and setter methods ensures encapsulation.
//        Errors like missing access modifiers or lack of validation in setters are avoided.

//Encapsulation and Class Design:
//        Encapsulation allows controlled access to sensitive data (balance).
//        Validation logic in setters (setBalance) prevents invalid data.
//        Methods like deposit and withdraw encapsulate functionality and ensure reusability.

//Exam Pitfalls and Solutions:
//        Misunderstanding access modifiers: Fields are private; access is granted via public methods.
//        Forgetting data validation: The setBalance, deposit, and withdraw methods include validation to ensure integrity.
//        A class demonstrating encapsulation best practices, common errors, and solutions
class BankAccount {
    // Fields are private to ensure encapsulation
    private String accountHolderName; // Missing 'private' is a common error
    private double balance;

    // Constructor for initializing the object
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        setBalance(initialBalance); // Using setter for validation
    }

    // Getter for accountHolderName
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Setter for accountHolderName with basic validation
    public void setAccountHolderName(String accountHolderName) {
        if (accountHolderName == null || accountHolderName.isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be null or empty!");
        }
        this.accountHolderName = accountHolderName;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance with validation to prevent negative values
    public void setBalance(double balance) {
        if (balance < 0) { // A common pitfall is forgetting to validate here
            throw new IllegalArgumentException("Balance cannot be negative!");
        }
        this.balance = balance;
    }

    // Method to deposit money, showing controlled access to data
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero!");
        }
        balance += amount; // Controlled modification of private field
    }

    // Method to withdraw money with proper validation
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero!");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance!");
        }
        balance -= amount; // Controlled modification of private field
    }

    // Overriding toString() to provide meaningful information
    @Override
    public String toString() {
        return "BankAccount{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}

// Test Class to demonstrate encapsulation in action
public class EncapsulationMisc {
    public static void main(String[] args) {
        // Create a BankAccount instance
        BankAccount account = new BankAccount("John Doe", 500);

        // Access fields via getters and setters
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Initial Balance: " + account.getBalance());

        // Modify the balance securely using methods
        account.deposit(200);
        System.out.println("Balance after deposit: " + account.getBalance());

        try {
            account.withdraw(800); // Testing withdrawal with insufficient balance
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Print account details
        System.out.println(account);
    }
}
