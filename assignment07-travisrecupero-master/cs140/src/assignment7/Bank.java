package assignment7;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	private String bankName;
	private int nextAccNum = 10001;
	List<Customer> customers = new ArrayList<>();
	private double baseRate;
	private int baseCheckLimit;
	private double checkFee;

	public Bank(String bankName) {
		this.bankName = bankName;
	}

	public double getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(double baseRate) {
		if (baseRate > 0) {
			this.baseRate = baseRate;
		} else {
			throw new IllegalArgumentException("Base rate can't be negative.");
		}
	}

	public int getBaseCheckLimit() {
		return baseCheckLimit;
	}

	public void setBaseCheckLimit(int baseCheckLimit) {
		if (baseCheckLimit > 0) {
			this.baseCheckLimit = baseCheckLimit;
		} else {
			throw new IllegalArgumentException("Base check limit can't be negative.");
		}
	}

	public double getCheckFee() {
		return checkFee;
	}

	public void setCheckFee(double checkFee) {
		if (checkFee > 0) {
			this.checkFee = checkFee;
		} else {
			throw new IllegalArgumentException("Check fee can't be negative.");
		}
	}

	public void doMonthlyAdjustment() {
		for(int i = 0; i < customers.size(); i++) {
			customers.get(i).monthlyAdjustment();
		}
	}
	
	void reset() {
		nextAccNum = 10001;
		customers.clear();
	}

	public void addCustomer(String name, double savingsInit, double checkingInit) {
		SavingsAccount s = null;
		CheckingAccount c = null;
		if (savingsInit >= 100) {
			s = new SavingsAccount(savingsInit, baseRate);
		}
		if (checkingInit >= 100) {
			c = new CheckingAccount(checkingInit, baseCheckLimit);
		}

		
		//adds customer
		//customers.add(new Customer(name, nextAccNum, new SavingsAccount(savingsInit, baseRate),
		//		new CheckingAccount(checkingInit, baseCheckLimit)));
		customers.add(new Customer(name, nextAccNum, s, c));
		
		
		
		//sets this added customers checkFee to the banks checkFee
		//((CheckingAccount) customers.get(customers.size()).getMyChecking()).setCheckFee(getCheckFee());

		//increase account number by one because 'new Customer()'
		nextAccNum++;
	}
	
	public Customer getCustomer(int accId) {
		for(int i = 0; i < customers.size(); i++) {
			if(customers.get(i).getIdNum() == accId) {
				return customers.get(i);
			}
		}
		return null;
	}
	
	public void report() {
		for(int i = 0; i < customers.size(); i++) {
			System.out.println(customers.get(i).toString());
		}
	}
	
	
	
	

}
