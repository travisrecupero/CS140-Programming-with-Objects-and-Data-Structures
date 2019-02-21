package lab06;

public class BankAccount {

	private double balance;
	private int idNum;
	private static int numAccounts = 0;

	public BankAccount(double balance) {
		if (balance >= 0) {
			this.balance = balance;
		} else {
			throw new IllegalArgumentException("Balance is negative.");
		}
		
		idNum = numAccounts;
		numAccounts++;
	}


	public double getBalance() {
		return balance;
	}

	public int getIdNum() {
		return idNum;
	}
	
	static void reset() {
		numAccounts = 0;
	}
	
	public void deposit(double amount) {
		if(amount <= 0) {
			throw new IllegalArgumentException("Cant deposit negative number or $0");
		} else {
			balance += amount;
		}
		
		
	}
	
	public double withdraw(double amount) {
		if(amount <= 0) {
			throw new IllegalArgumentException("Cant withdraw negative number or $0");
		} else if (amount > balance) {
			throw new IllegalArgumentException("Not enough in account to deposit");
		} else {
			balance -= amount;
			return amount;
		}
	}
	
	
	
	@Override // good habit to include
	public String toString() {
	    return "Acct. #" + idNum + " has $" + balance + " for an account with idNum = " + idNum + " and balance = " + balance;
		// should return the string "Acct. #3 has $50.0" for an account with idNum = 3 and balance = 50
	}
	
}


