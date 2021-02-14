//Devarsh patwa
//Dec 2018
//This is the chequing account that reduces the fees

import java.text.NumberFormat;

import javax.swing.JOptionPane;

// Chequing Class partial template
// Very similar to the Savings account except the
// widthdraw method is different.

public class Chequing extends Account// inherits from Account
{
	// class data (only some is here, you may need more)
	// fees for transactions
	private double wdFee;
	private double serviceFee;

	// default constructor
	public Chequing() {
		// constructor to create a Chequing Account
		// should call the parent constructor
		wdFee = 0.5;
		serviceFee = 1.50;

	}

	// overloaded constructor that takes in a customer object and initializes data
	public Chequing(Customer owner) {
		super(owner);
		wdFee = 0.5;
		serviceFee = 1.50;
	}

	// method to set the withdrawal fee
	public void setWdFee(double wdFee) {
		this.wdFee = wdFee; // *100 since its in percentage
	}
	
	public double getWdFee() {
		return wdFee;
	}

	public void deposit(double amt) {
		amt = amt - serviceFee; // deducts the service fee
		super.deposit(amt);
	}

	public boolean withdraw(double amt) {
		amt += (getBalance() * wdFee / 100); // deducts fee
		if (super.withdraw(amt)) { // checks if balance is sufficient and withdraws
			return true;
		} else {
			return false; // if unsuccessful
		}
	}

	public static void main(String args[]) {

		Customer tony = new Customer("Random Street Name 1234", "Name Random", "904 123 1234");
		Chequing c = new Chequing(tony);

		NumberFormat money = NumberFormat.getCurrencyInstance(); // format currency

		// check starting balance
		System.out.println(money.format(c.getBalance()));

		// deposit money into balance
		c.deposit(1000);
		System.out.println(money.format(c.getBalance()));

		// withdraw money
		c.withdraw(500);
		System.out.println(money.format(c.getBalance()));

		c.setWdFee(2); // sets the fee to 2%
		System.out.println(c.wdFee + "%"); // check the fee

		c.withdraw(200);
		System.out.println(money.format(c.getBalance()));

		if (c.withdraw(1000) == false) { // tests if the balance is not sufficient
			System.out.println("not enough balance");
		}

	}

}
