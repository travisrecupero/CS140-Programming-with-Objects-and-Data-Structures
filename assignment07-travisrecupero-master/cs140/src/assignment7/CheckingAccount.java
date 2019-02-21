package assignment7;

public class CheckingAccount extends BankAccount {

	private int withdrawLimit = 0;
	private int withdrawCount = 0;
	private int nextCheckNum = 101;
	private double checkFee;
	

	public CheckingAccount(double balance, int limit) {
		super(balance);
		if (limit < 1) {
			throw new IllegalArgumentException("Limit can't be less than 1, must be positive.");
		} else {
			withdrawLimit = limit;
		}
		
	}

	void reset() {
		nextCheckNum = 101;
	}
	
	//no access modifier means only package can see it
	int getNextCheckNum() {
		return nextCheckNum;
	}

	public int getWithdrawLimit() {
		return withdrawLimit;
	}

	public int getWithdrawCount() {
		return withdrawCount;
	}

	public void setCheckFee(double checkFee) {
		this.checkFee = checkFee;
	}
	
	public double writeCheck(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount can't be negative.");
		} else {
			nextCheckNum++;
			withdrawCount++;
		}
		return withdraw(amount);
	}
	

	@Override
	public void monthlyAdjustment() {
		if(withdrawCount > withdrawLimit) {
			withdraw(checkFee * (withdrawCount-withdrawLimit));
			withdrawCount = 0;
		}
		int temp = (int) (super.getBalance() / 1000);
		withdrawLimit += temp;
		
	}
	
	@Override
	public String toString() {
		return String.format("Acct. has $%.2f", super.getBalance());
	}

	


}
