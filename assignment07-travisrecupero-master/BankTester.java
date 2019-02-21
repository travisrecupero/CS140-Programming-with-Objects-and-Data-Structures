package assignment07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

class BankTester {
	Bank testBank;
	String[] names = {"Jane Devon","John CornWall", "Jean Dorset", "James Hampshire"};

	@BeforeEach
	void initialize(){
		testBank = new Bank("NewNYBank");
		testBank.setBaseCheckLimit(5);
		testBank.setBaseRate(2);
		testBank.setCheckFee(1.50);
		testBank.addCustomer(names[0], 0, 200);
		testBank.addCustomer(names[1], 200, 99);
		testBank.addCustomer(names[2], 200, 300);
		testBank.addCustomer(names[3], 100000, 2000);
	}

	@AfterEach
	void resetIdNum(){
		testBank.reset();		
	}

	@Test
	@DisplayName("Check that all the accounts are set up correctly in the Bank")
	void testBankCustomerList() {
		Customer test0 = testBank.getCustomer(10000);
		Customer test1 = testBank.getCustomer(10001);
		Customer test2 = testBank.getCustomer(10002);
		Customer test3 = testBank.getCustomer(10003);
		Customer test4 = testBank.getCustomer(10004);
		try {
			assertAll(
					() -> assertNull(test0),
					() -> assertEquals(names[0], test1.getName()),
					() -> assertEquals(names[1], test2.getName()),
					() -> assertEquals(names[2], test3.getName()),
					() -> assertEquals(names[3], test4.getName()),
					() -> assertThrows(UnsupportedOperationException.class,
							() -> test1.getMySavingsBalance()),
					() -> assertEquals(200, test2.getMySavingsBalance(), 1e-6),
					() -> assertEquals(200, test3.getMySavingsBalance(), 1e-6),
					() -> assertEquals(100000, test4.getMySavingsBalance(), 1e-6)
					);
			// ADD CORRESPONDING ASSERTS FOR THE checking account balances or the exception			
		} catch(AssertionError e){
			System.out.println("The Bank Customers were no set up correctly: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests deposit method of a savings account")
	void testSavingsDeposit() {
		SavingsAccount test = new SavingsAccount(200, 5);
		test.deposit(500);
		try {
			assertEquals(700.00, test.getBalance(), 1e-6);
		} catch(AssertionError e){
			System.out.println("deposit() method in savings failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests that the deposit method of a savings account throws " +
			"illegal argument exception when argument is negative")
	void testSavings1Deposit() {
		SavingsAccount test = new SavingsAccount(200, 5);
		try {
			assertThrows(IllegalArgumentException.class,
					() -> {test.deposit(-10);});
		} catch(AssertionError e){
			System.out.println("deposit() method in savings failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests deposit method of mySavings in a Customer with only a savings account")
	void testCustomer1SavingsDeposit() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), null);
		test.depositSavings(500);
		try {
			assertEquals(700.00, test.getMySavingsBalance(), 1e-6);
		} catch(AssertionError e){
			System.out.println("depositSavings() method in customer failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests deposit method of mySavings in a Customer with savings and checking account")
	void testCustomer2SavingsDeposit() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), new CheckingAccount(200, 5));
		test.depositSavings(500);
		try {
			assertEquals(700.00, test.getMySavingsBalance(), 1e-6);
		} catch(AssertionError e){
			System.out.println("depositSavings() method in customer failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests deposit method of mySavings in Customer with only checking account")
	void testCustomer3SavingsDeposit() {
		Customer test = new Customer("Name", 1, null, new CheckingAccount(200, 5));
		// there is no savings account so we check the correct exception occurs
		try {
			assertThrows(UnsupportedOperationException.class,
					() -> {test.depositSavings(500);});
		} catch(AssertionError e){
			System.out.println("depositSavings() method failed to throw exception: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests withdraw method of a savings account")
	void testSavingsWithdraw() {
		SavingsAccount test = new SavingsAccount(200, 5);
		double retVal = test.withdraw(50);
		try {
			assertAll(
					() -> assertEquals(150.00, test.getBalance(), 1e-6),
					() -> assertEquals(50.00, retVal, 1e-6)
					);
		} catch(AssertionError e){
			System.out.println("withdraw() method in savings failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests withdraw method of a savings account when amount > balance")
	void testSavingsWithdraw1() {
		SavingsAccount test = new SavingsAccount(200, 5);
		double retVal = test.withdraw(250);
		try {
			assertAll(
					() -> assertEquals(0.00, test.getBalance(), 1e-6),
					() -> assertEquals(200.00, retVal, 1e-6)
					);
		} catch(AssertionError e){
			System.out.println("withdraw() method in savings failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests that the withdraw method of a savings account throws " +
			"illegal argument exception when argument is negative")
	void testSavings1Withdraw() {
		SavingsAccount test = new SavingsAccount(200, 5);
		try {
			assertThrows(IllegalArgumentException.class,
					() -> test.withdraw(-10));
		} catch(AssertionError e){
			System.out.println("withdraw() method in savings failed to throw exception: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests withdraw method of mySavings in a Customer with only a savings account")
	void testCustomer1SavingsWithdraw() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), null);
		double retVal = test.withdrawSavings(50);
		try {
			assertAll(
					() -> assertEquals(150.00, test.getMySavingsBalance(), 1e-6),
					() -> assertEquals(50.00, retVal, 1e-6)
					);
		} catch(AssertionError e){
			System.out.println("withdrawSavings() method in customer failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests withdraw method of mySavings in a Customer with only a savings account"
			+ "when amount > balance")
	void testCustomer1SavingsWithdraw1() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), null);
		double retVal = test.withdrawSavings(250);
		try {
			assertAll(
					() -> assertEquals(0.00, test.getMySavingsBalance(), 1e-6),
					() -> assertEquals(200.00, retVal, 1e-6)
					);
		} catch(AssertionError e){
			System.out.println("withdrawSavings() method in customer failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests withdraw method of mySavings in a Customer with savings and checking account")
	void testCustomer2SavingsWithdraw() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), new CheckingAccount(200, 5));
		double retVal = test.withdrawSavings(50);
		try {
			assertAll(
					() -> assertEquals(150.00, test.getMySavingsBalance(), 1e-6),
					() -> assertEquals(50.00, retVal, 1e-6)
					);
		} catch(AssertionError e){
			System.out.println("withdrawSavings() method in customer failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests withdraw method of mySavings in Customer with only checking account")
	void testCustomer3SavingsWithdraw() {
		Customer test = new Customer("Name", 1, null, new CheckingAccount(200, 5));
		// there is no savings account so we check the correct exception occurs
		try {
			assertThrows(UnsupportedOperationException.class,
					() -> test.withdrawSavings(500));
		} catch(AssertionError e){
			System.out.println("withdrawSavings() method failed to throw exception: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Testing doMonthlyAdjustment in Bank and thereby testing all the monthlyAdjustment methods"
			+ "in Customer, Checking") 
	void testBankDoMonthlyAdjustment() {
		//Bank was set up in Initialize() above
		//YOU MUST ADD TEST FOR CHECHKING, SO DO 
		// writeCheck with small amounts, 10 times

		Customer test1 = testBank.getCustomer(10001);
		Customer test2 = testBank.getCustomer(10002);
		Customer test3 = testBank.getCustomer(10003);
		Customer test4 = testBank.getCustomer(10004);
		testBank.doMonthlyAdjustment();
		try {
			assertAll(
					//test 1 does not have a savings account
					() -> assertEquals(200.333333, test2.getMySavingsBalance(), 1e-3),
					() -> assertEquals(200.333333, test3.getMySavingsBalance(), 1e-3),
					() -> assertEquals(100183.333333, test4.getMySavingsBalance(), 1e-3) // will need a comma
					// INSERT SIMILAR TESTS THAT THE BALANCES ARE CORRECT
					// AND THE withdrawCount IS BACK TO 0 FOR EACH test1, test3, test4
					);
		} catch(AssertionError e){
			System.out.println("doMonthlyAdjustment in Bank failed: " + e.getMessage());
			throw e;
		}
	}
}
