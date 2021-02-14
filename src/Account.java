import java.text.NumberFormat;

/*
 * Author: Jainil Patel
 * Date: 11/30/2018
 * Description:Creates an account with Balance account number, and a customer
 * Method List:
 *  	- public Account(): creates a Account with a blank customer profile
 *  	- public Account(Customer theOwner): creates an account with a customer profile
 *  	- public void deposit(double amount): deposits a given balance
 *  	- public boolean withdraw(double amount): withdraws a given balance
 *  	- public String toString(): used to display variables and objects into a "sentence"
 *  	- public static void main(String args[]): self-testing for the class
 */
public class Account {
	// class data
	private double balance;// balance
	private long accountNum;// account number
	private Customer customer;// Customer object
	private NumberFormat money;

	// Default constructor
	public Account() {
		// initializes the balance
		balance = 0;
		// creates an account number
		accountNum = (long) ((Math.random() * 99999999999L) + 100000000000L);
		while (accountNum < 100000000000L) {
			accountNum = (long) ((Math.random() * 99999999999L) + 100000000000L);
		}
		// intializes Customer object
		customer = null;

		// to format the prices
		money = NumberFormat.getCurrencyInstance();
	}

	// Overloaded Constructor
	public Account(Customer theOwner) {
		// initializes balance
		balance = 0;
		// generates an account number
		accountNum = (long) ((Math.random() * 99999999999L) + 100000000000L);
		while (accountNum < 100000000000L) {
			accountNum = (long) ((Math.random() * 99999999999L) + 100000000000L);
		} // initializes customer object theOwner
		customer = theOwner;

		// to format the prices
		money = NumberFormat.getCurrencyInstance();
	}

	public void deposit(double amount) {
		balance += amount; // adds amount to balance
	}

	public boolean withdraw(double amount) {
		// Checks if the amount can be withdrawn
		// and returns true if it is possible
		// updates balance
		if (amount <= balance) {
			balance -= amount;
			return true;
		}
		return false;
	}

	public String toString() {
		return "Account Number: " + getAccountNum() + "\nBalance: "
				+ money.format(getBalance()) + "\n";
	}

	// getters and setters as needed
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @return the accountNum
	 */
	public long getAccountNum() {
		return accountNum;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	public static void main(String args[]) {
		// Self Testing Main
		Account s = new Account();
		System.out.println(s.getBalance());
		System.out.println(s.getAccountNum());
		System.out.println(s.getCustomer());

		// testing deposit
		s.deposit(709.99);
		System.out.println(s.getBalance());
		// testing withdraw
		s.withdraw(378.85);
		System.out.println(s.getBalance());

		// making new customer
		Customer y = new Customer("Random Street Name 1234", "Name Random", "904 123 1234");
		Account a = new Account(y);
		
		// getting account number
		System.out.println(a.getAccountNum());
		System.out.println(a.getCustomer());
	}

}
