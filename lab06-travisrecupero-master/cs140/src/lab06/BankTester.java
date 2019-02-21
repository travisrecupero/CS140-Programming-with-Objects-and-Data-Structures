package lab06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

class BankTester {
	List<BankAccount> accounts;
	List<Object> objects;
	//we can initialize some objects to be used in later tests
	//using the BeforeEach keyword ensures this method is called before 
	//the test methods are called
	
	//Please note that this method is rerun before the start of each test,
	//which means the BankAccounts will have their numId's increased 
	//each time the account is called.
	
	//we will fix this issue by adding an @AfterEach method, which is run 
	//after each test ends
	@BeforeEach
	void initialize(){
		//NEEDS TO BE FILLED IN AS SPECIFIED
		accounts = new ArrayList<BankAccount>();
		accounts.add(new BankAccount(30000));
		accounts.add(new SavingsAccount(20000, 10)); //rate 10%
		accounts.add(new CheckingAccount(10000, 500)); //withdraw limit $500
		accounts.add(new BankAccount(15000));
		accounts.add(new SavingsAccount(1000, 5)); // rate 5%
		accounts.add(new CheckingAccount(8000, 1)); //withdraw limit $450
		
		
		objects = new ArrayList<Object>();
		objects.add("");
		objects.add(1000);
		objects.add(45);
		objects.add(3.141592653);
		objects.add("Hello World");
		//objects.add(null);
		objects.add(new BankAccount(30));
		
	}

	@AfterEach
	void resetIdNum(){
		BankAccount.reset();
		accounts.clear();
	}
	
	
	//the @Test is necessary, without it the test will not be run
	@Test
	@DisplayName("Tests deposit method of bank account")
	void testBankAccDeposit() {
		BankAccount bacc = new BankAccount(700.00);
		bacc.deposit(100);
		try {
			//when comparing two doubles, we need to give it some small value for it to see 
			//if the expected and actual value are close enough to equaling one another
			assertEquals(800.00, bacc.getBalance(), 1e-6);
		}
		//here if there is an assertion error, we can catch it 
		//and print the error message out, then throw the AssertionError
		//so that the test still fails. 
		catch(AssertionError e){
			System.out.println("BankAccount's deposit() method failed: " + e.getMessage());
			throw e;
		}
	}
	@Test
	@DisplayName("Tests withdraw method of checking account")
	void testCheckingAccWithdraw(){
		CheckingAccount checking = new CheckingAccount(1000.00, 10);
		for(int i = 0; i < 3; i++) checking.withdraw(100);
		try {
			//when comparing two doubles, we need to give it some small value for it to see 
			//if the expected and actual value are close enough to equaling one another
			assertEquals(700.00, checking.getBalance(), 1e-6);
		}
		//here if there is an assertion error, we can catch it 
		//and print the error message out, then throw the AssertionError
		//so that the test still fails. 
		catch(AssertionError e){
			System.out.println("CheckingAccount's withdraw() method failed: " + e.getMessage());
			throw e;
		}
	}
	@Test
	@DisplayName("Tests getter for withdrawCount of a CheckingAccount")
	void testCheckingAccGetWithdrawCount(){
		CheckingAccount checking = new CheckingAccount(1000.00, 10);
		for(int i = 0; i < 3; i++) checking.withdraw(100);
		try {
			//when comparing two integers, we don't need a third argument 
			//since ints can be checked for equality
			assertEquals(3, checking.getWithdrawCount());
		}
		//here if there is an assertion error, we can catch it 
		//and print the error message out, then throw the AssertionError
		//so that the test still fails. 
		catch(AssertionError e){
			System.out.println("CheckingAccount's getWithdrawCount() method failed: " + e.getMessage());
			System.out.println("Make sure you adjust the withdrawCount in your CheckingAccount's withdraw() method!");
			throw e;
		}
	}
	//TODO: Add some of your own additional tests. Keep each test in a separate test function.
	//This isolates testing a single method or case to a single testing method. Otherwise, 
	//if you try to do too much testing in one tester method, you could throw an error
	//for a test and never find the errors of the other tests you put in that method. 
	

	@Test
	@DisplayName("First Test Made by me...")
	void testForDeposit() {
		for(BankAccount b : accounts){
			b.deposit(500);
		}
		assertEquals(30500.00, accounts.get(0).getBalance());
		assertEquals(25000.00, accounts.get(1).getBalance());
		assertEquals(10500, accounts.get(2).getBalance());
		assertEquals(15500, accounts.get(3).getBalance());
		assertEquals(3500, accounts.get(4).getBalance());
		assertEquals(8500, accounts.get(5).getBalance());
		
	}
	
	@Test
	@DisplayName("Second Test Made by me...")
	void testForWithdraw() {
		System.out.println();
		for(int i = 0; i < 3; i++) {
			System.out.println("Deposit #: " + i);
			for(BankAccount b : accounts){
				System.out.println(b);
				}
			for(int j = 0; j < accounts.size(); j++) {
				accounts.get(j).withdraw(1);	
			}	
		}
		
	}
	
	@Test
	@DisplayName("Tests deposit method of bank account")
	void dynamicDispatchPrinting(){
		//FILL IN AS SPECIFIED
		System.out.println(accounts + "\n");
		
		for(BankAccount b : accounts){
			if(b instanceof SavingsAccount){
				System.out.println("SavingsAccount: ");
			}
			else if(b instanceof CheckingAccount){
				System.out.println("CheckingAccount: ");
			}
			//note that we do this as an else block
			//since SavingsAccount and CheckingAccounts are also
			//considered to be instances of BankAccount
			//since they are subclasses of BankAccount.
			else{
				System.out.println("BankAccount: ");
			}
			System.out.println(b);
			
			System.out.println("Objects: ");
			for(Object o : objects) {
//				if(o == null) {
//					throw new NullPointerException("This is null");
//				}
				System.out.println(o.toString());
			}
			
			
		}
	}
	
	
	

	
}
