# assignment07 DUE WEDNESDAY 10/10/18 AT 11:59pm
Put the code in `assignment07`

THERE IS A CORRECTION TO THE OVERRIDDEN `monthlyAdjustment` IN CHECKING ACCOUNT. It is changed below, but you only withdraw money if `withdrawCount > withdrawLimit`. Whether or not money is withdrawn, the `withdrawCount` is set to 0 by this method.

>>>>>>
JUnit TESTING. See the JUnit test `BankTester` that is now part of the repository. The testing of the SavingsAccount side is pretty thorough. You have to do the CheckingAccount side. In `testBankCustomerList()` there are 4 asserts missing dealing either with the balances of the Customer's checking accounts or with the fact that one Customer does not have a CheckingAccount.

You will have to examine how we test for thrown exceptions in JUnit 5. It involves a lambda expression () -> {....}, which we will soon study but for now just copy the format.

In the test `testBankDoMonthlyAdjustment()` you need to insert a series of "writeCheck" calls to the customers that have CheckingAcounts and then put in asserts for the new account balances and a check that the `withdrawCount` is reset to 0.

For every one of the 12 other tests, write a corresponding test for the CheckingAccount--in this case you also check that `withdrawCount` is increased.
>>>>>>

We are going to look at variations on the `BankAccount` idea.

Copy over your `lab06` classes. Delete the depost method in `SavingsAccount`. We are going to add interest in a different way. Also get rid of the fields `idNum` and `numAccounts` in BankAccount and remove the methods and instructions that relate to them.  Note that the rate in`SavingsAccount` is now the "annual percentage rate" so it could be at least 1.

In `CheckingAccount` add a private int field `nextCheckNum` initialized to 101 and a private double named `checkFee`. Add a `reset` method to put this field back to 101 if needed in testing. Write a setter method for `checkFee`. Delete the `withdraw` method you have from lab06 and put in a method `public double writeCheck(double amount)`. In writeCheck, you throw the usual exception if amount is negative, add 1 to `nextCheckNum` and add 1 to `withdrawCount` before returning `withdraw(amount)`, which is the inherited method from BankAccount. There are getter methods for `withdrawCount` and `withdrawLimit`. (Note we are not going to worry about bounced checks). Provide a package-private `int getNextCheckNum()` method that can be used in JUnit testing (make sure you have the other public methods from `lab06`.

Make the class `BankAccount` _abstract_: `public abstract class BankAccount`. Put in an abstract method
`public abstract void monthlyAdjustment();` In the classs `SavingsAccount`, and `CheckingAccount` just click on the error at the top of the class and double click on "Add unimplemented methods", which will insert an empty implementation of this abstract method in BankAccount. We will come back and fill them in.

In the `toString` of `BankAccount`, take advantage of the String `format` method to make the printing of double values predictable: for lab06, it would have been `return String.format("Acct. #%d has $%.2f", idNum, balance);` but now we do not have an `idNum`, so just `return String.format("Acct. has $%.2f", balance);`; do a similar adjustment to the toString in the subclasses. BUT note that in order to print a single percent sign in the formatted String you have to put `%%` in the first argument--since the single percent signs are associated with the [format patterns](https://docs.oracle.com/javase/10/docs/api/java/util/Formatter.html) such as %d and %f.

Make a class `Customer` with a private `String` field `name`, a private `int` field `idNum` and two private fields of type `BankAccount`, one called `mySavings` and one called `myChecking`. The account fields will initally be `null` by default.

Write a constructor `public Customer(String nm, int id, SavingsAccount savings, CheckingAccount checking)` that initializes the 4 fields. Note that we are forcing users of the constructor to provide the right kind of account types (or `null`). Provide getter methods for `name` and `idNum`. Provide delegate methods `public double getMySavingsBalance()` and `public double getMyCheckingBalance()` that return the balances in `mySavings` and `myChecking` respectively (when the accounts are not `null`). If either BankAccount is `null`, its corresponding delegate method throws an `UnsupportedOperationException` with a relevent message.

In `Customer` write a method `public void monthlyAdjustment()` that calls `monthlyAdjustment()` on its non-null account fields.

In `Customer` write methods `public boolean hasSavingsAccount()` (returns true if `mySavings` is not null), `public boolean hasCheckingAccount()` (returns true if `myChecking` is not null).

Additionally, add the following four delegate methods to `Customer`. `public void depositSavings(double amount)` which calls `mySavings.depost(amount)` if `mySavings` is not null, and similarly for `public void depositChecking(double amount)`, `public double withdrawSavings(double amount)`, `public double writeCheck(double amount)` (will need a cast to `CheckingAccount`). Throw an `UnsupportedOperationException` with a relevant message if there is a call to a null account in all four delegate methods mentioned here. 

In `Customer` write a `toString` so that `System.out.println(someCustomer)` would give

```
Customer id: 100002, Jennifer Smith
     Savings Account: none
     Checking Account Balance: $300.56
```
USE `StringBuilder` as on Slides 6-10, use `\n` for new-line, `\t` for the indentation on the 2nd and 3rd lines, use `String.Format` with the `%.2f` pattern to get the dollars-and-cents formatted with 2 decimal places. One nice thing about using the `StringBuilder` is that you can easily have if statements along the way to choose different outputs depending on which account is empty, if any.

Write a package-private `int getWithdrawCount()` and `int getNextCheckNum()` methods that return `myChecking.getWithdrawCount()` and `myChecking.getNextCheckNum()` if `myChecking` is non null. These can be used in JUnit testing.

Write a class `Bank` with a private `String` field `bankName`, a private `int` field `nextAccNum`, initialized to 10001 and a `List<Customer>` field `customers` instantiated as an ArrayList--don't forget we can use the diamond notation `new ArrayList<>()`. There is also a few more private fields, `double baseRate`, `int baseCheckLimit`, and `double checkFee`.

Write a constructor for `Bank` that sets the `bankName`. Write getter and setter methods for `baseRate`, `baseCheckLimit`, and `checkFee`, where the setter methods check that the values are not negative--note they can be 0. Otherwise, throw an `IllegalArgumentException` with a message if they negative. Provide a `reset` method that resets `nextAccNum` to 10001, ALSO it calls `customers.clear().`

In `Bank` write a method `public void addCustomer(String name, double savingsInit, double checkingInit)`. In this method, if `savingsInit` >= 100, it makes a `SavingsAccount` with initial balance `savingsInit` and `rate` equal to `baseRate`; then if `checkingInit` >= 100, it makes a `CheckingAccount` with initial balance `checkingInit` and `withdrawLimit` equal to `baseCheckLimit`; finally it adds a new `Customer` to its List of customers, where the `Customer` will have the `name` equal to  `name`, `id` equal to `nextAccNum`, the `SavingsAccount` just made or null, and the `CheckingAccount` just made or null. Note the accounts could be null if the Customer doesn't have enough initial money to open an account. If the `CheckingAccount` is not null, set its `checkFee` to the Bank's `checkFee`. Finally `nextAccNum` increased by 1.

In `Bank` write a method `public void doMonthlyAdjustment()`. It goes through all its Customers in the List and calls `monthlyAdjustment()` on each one.

Also in `Bank` write a method `public Customer getCustomer(int accId)` which returns the `Customer` from `customers` that has the given account id. It returns null if there is no such customer.

In Bank write a method `public void report()` which calls `System.out.println` on each customer in its List of customers

In `SavingsAccount`, override the `monthlyAdjustment` method so that it deposits `(rate/1200.0) * getBalance()` into the account. HOWEVER, for every $10000 in the account it increases the value of rate by 1%--for example if the account has $36700.25, and the rate is 5%, it is changed to 5.15% for that month's calculation.

In `CheckingAccount`, override the `monthlyAdjustment` method so that IF `withdrawCount > withdrawLimit` it computes `checkFee*(withdrawCount-withdrawLimit)`, does withdraw() of that amount and, in all cases, sets withdrawCount back to 0. HOWEVER, for every $1000 in the account it increases the `withdrawLimit` by 1 before doing this calculation for this month. (Note we are not going to worry abou the case where there is not enough balance to cover the fee).

We are developing a JUnit guideline for testing these classes. In the tester we will set up a Bank with 4 Customers. One of the Customers only has a SavingsAccount, one only has a CheckingAccount and the other two have both SavingsAccounts and CheckingAccounts. Tests will make sure that the HOWEVER parts of the two paragraphs above are tested. There is a chance we will need some more getter methods for the JUnit tests but we hope not.
