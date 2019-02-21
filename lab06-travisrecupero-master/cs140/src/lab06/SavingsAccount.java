package lab06;

public class SavingsAccount extends BankAccount {

	private double rate;

	public SavingsAccount(double balance, double rate) {
		super(balance);
		if (rate <= 0) {
			throw new IllegalArgumentException("Rate cannot be negative or 0");
		}
		this.rate = rate;
	}

	@Override
	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Cant deposit negative number or $0");
		} else {
			super.deposit(amount * rate);
		}
	}

	public double getRate() {
		return rate;
	}

	@Override
	public String toString() {
		return super.toString() + " @" + rate + "%";
	}

}
