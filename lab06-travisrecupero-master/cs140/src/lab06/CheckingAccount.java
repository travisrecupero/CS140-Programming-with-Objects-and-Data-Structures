package lab06;

public class CheckingAccount extends BankAccount {

	private int withdrawLimit = 0;
	private int withdrawCount = 0;

	public CheckingAccount(double balance, int limit) {
		super(balance);
		if (limit < 1) {
			throw new IllegalArgumentException("Limit can't be less than 1, must be positive.");
		} else {

			withdrawLimit = limit;
		}
	}

	public int getWithdrawLimit() {
		return withdrawLimit;
	}

	public int getWithdrawCount() {
		return withdrawCount;
	}

	@Override
	public double withdraw(double amount) {
		if (withdrawCount < withdrawLimit) {
			withdrawCount++;
			return super.withdraw(amount);
		} else if (withdrawCount >= withdrawLimit) {
			return 0;
		}
		return 0;
	}
/*
	 if(amount <= 0) {
			throw new IllegalArgumentException("Cant withdraw negative number or $0");
		} else if (amount > balance) {
			throw new IllegalArgumentException("Not enough in account to deposit");
		} else {
			balance -= amount;
			return amount;
		}
*/
	
	@Override
	public String toString() {
		return super.toString() + " " + withdrawCount + " / " + withdrawLimit;
	}

//	

}
