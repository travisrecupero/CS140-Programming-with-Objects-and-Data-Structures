package assignment7;

public class SavingsAccount extends BankAccount {

	private double rate;

	public SavingsAccount(double balance, double rate) {
		super(balance);
		if (rate <= 1) {
			throw new IllegalArgumentException("Rate cannot be negative or 0");
		}
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	@Override
	public void monthlyAdjustment() {
		deposit((rate / 1200.0) * getBalance());
	}

	@Override
	public String toString() {
		return String.format("Acct. has $%.2f", super.getBalance());
	}

}
