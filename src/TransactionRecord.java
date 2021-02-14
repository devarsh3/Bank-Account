/**
 * @author Jainil Patel 
 * Date: 12/4/2018
 * Description: This class makes the transaction records
 * Method List:
 * 		- public TransactionRecord(): default constructor that creates a record
 * 		- public TransactionRecord(String tType, double tAmt, char aType): overloaded constructor that accepts transac type,
 * 																		   transac amount, and account type
 * 		- public TransactionRecord(String processData): overloaded constructor that accepts a processed data
 * 		- public void processTransaction(String record): process transaction uses a string input to split the objects and set them
 * 		- public String toString(): this method gets objects and put them into a string to be presentable
 * 		- public String processString(): processString method is to put the objects back into "\"
 * 		- public static void main(String[] args): the main method is for self-testing of the program
 */
public class TransactionRecord {

	private String transacType;
	private double transacAmt, startBal, endBal;
	private char accType;

	/**
	 * Default Constructor
	 */
	public TransactionRecord() {
		this.transacType = "";
		this.transacAmt = 0;
		this.startBal = 0;
		this.endBal = 0;
		this.accType = 0;
	}

	/*
	 * Overloaded more useful constructor
	 */
	public TransactionRecord(String tType, double tAmt, char aType) {
		this.transacType = tType;
		this.transacAmt = tAmt;
		this.startBal = 0;
		this.endBal = 0;
		this.accType = aType;
	}

	/*
	 * Overloaded more useful constructor
	 */
	public TransactionRecord(String processData) {
		processTransaction(processData);
	}

	/**
	 * @return the transacType
	 */
	public String getTransacType() {
		return transacType;
	}

	/**
	 * @param transacType the transacType to set
	 */
	public void setTransacType(String transacType) {
		this.transacType = transacType;
	}

	/**
	 * @return the transacAmt
	 */
	public double getTransacAmt() {
		return transacAmt;
	}

	/**
	 * @param transacAmt the transacAmt to set
	 */
	public void setTransacAmt(double transacAmt) {
		this.transacAmt = transacAmt;
	}

	/**
	 * @return the startBal
	 */
	public double getStartBal() {
		return startBal;
	}

	/**
	 * @param startBal the startBal to set
	 */
	public void setStartBal(double startBal) {
		this.startBal = startBal;
	}

	/**
	 * @return the endBal
	 */
	public double getEndBal() {
		return endBal;
	}

	/**
	 * @param endBal the endBal to set
	 */
	public void setEndBal(double endBal) {
		this.endBal = endBal;
	}

	/**
	 * @return the accType
	 */
	public char getAccType() {
		return accType;
	}

	/**
	 * @param accType the accType to set
	 */
	public void setAccType(char accType) {
		this.accType = accType;
	}

	/*
	 * Method to split a string into objects
	 */
	public void processTransaction(String record) {
		String transaction[];
		transaction = record.split("/"); // splits string by slashes
		setTransacType(transaction[0]);
		setTransacAmt(Double.parseDouble(transaction[1]));
		setAccType(transaction[2].charAt(0));
		setStartBal(Double.parseDouble(transaction[3]));
		setEndBal(Double.parseDouble(transaction[4]));
	}

	/*
	 * toString method to put the objects as a string for it to be displayed
	 */
	public String toString() {
		String accountType = "";

		// checking for account type (char) and switching it to string
		switch (getAccType()) {
		case 'c': {
			accountType = "Chequing";
			break;
		}
		case 's': {
			accountType = "Savings";
			break;
		}
		default:
			accountType = "Invalid";
			break;
		}

		return "\nTransaction Type: " + getTransacType() + "\nTransaction Amount: " + getTransacAmt()
				+ "\nAccount Type: " + accountType + "\nStart Balance: " + getStartBal() + "\nEnd Balance: "
				+ getEndBal() + "\n";

	}

	/*
	 * processString to put objects separated by slashes
	 */
	public String processString() {
		return getTransacType() + "/" + getTransacAmt() + "/" + getAccType() + "/" + getStartBal() + "/" + getEndBal();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TransactionRecord rec = new TransactionRecord(); // making new transaction

		// testing default constructor
		System.out.println(rec.toString());

		// testing getters
		System.out.println("\n" + rec.processString());

		// testing different cases in processTransaction
		// testing deposit in chequing
		String transac = "Deposit/1000/c/0/1000";
		rec.processTransaction(transac);
		System.out.println("\n" + rec.toString());

		// testing deposit in savings
		transac = "Deposit/1000/s/0/1000";
		rec.processTransaction(transac);
		System.out.println("\n" + rec.toString());

		// testing withdraw from chequing
		transac = "Withdraw/1000/c/1000/0";
		rec.processTransaction(transac);
		System.out.println("\n" + rec.toString());

		// testing withdraw from savings
		transac = "Withdraw/1000/s/1000/0";
		rec.processTransaction(transac);
		System.out.println("\n" + rec.toString());

		// testing processString
		System.out.println("\n" + rec.processString());

	}

}
