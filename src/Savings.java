//Devarsh patwa
//Dec 2018
//This is the savings account that reduces the fees and checks for minimum amount

import java.text.NumberFormat;


public class Savings extends Account  // inherits from Account
{

	
	private double fee; //fee to charge
	private double minAmt; //fee gets charged below this minimum

	//default constructor
	public Savings() { 
		// constructor to create a Checking Account
		// should call the parent constructor
		fee = 1.25;
		minAmt = 2000;
	}

	// overloaded constructor that takes in a customer object and initializes data
	public Savings(Customer owner) {
		super(owner);
		fee = 1.25;
		minAmt = 2000;
	}
	
	
	
	public void setMinAmt(double minAmt) {
		this.minAmt = minAmt;
	}
	

	/**
	 * @return the minAmt
	 */
	public double getMinAmt() {
		return minAmt;
	}

	public boolean withdraw (double amt)
	{
		// checks if balance is sufficient
		if(getBalance()<getMinAmt()) {
			amt = amt + fee; // charges a fee if balance is below minimum
			if(super.withdraw(amt)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			super.withdraw(amt); //no fee charged
			return false;
		}
		
		// returns true if successful and false if not
	}


	public static void main(String[] args) { 
		
		Customer tony = new Customer("Random Street Name 1234" , "Name Random", "904 123 1234");
		Savings s = new Savings(tony);
		
		 NumberFormat money = NumberFormat.getCurrencyInstance(); //format currency
		
		//check starting balance
		System.out.println(money.format(s.getBalance()));
		
		s.deposit(2500); //deposit money in the account
		System.out.println(money.format(s.getBalance()));
		
		s.withdraw(600); //withdraw money 
		System.out.println(money.format(s.getBalance()));
		
		s.withdraw(100);
		System.out.println(money.format(s.getBalance()));
		
		s.setMinAmt(1000);
		s.withdraw(100);
		System.out.println(money.format(s.getBalance()));
		
		
		if(s.withdraw(5000)==false) { //tests if the balance is not sufficient
			System.out.println("not enough balance");
		}
	}


}
