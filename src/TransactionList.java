import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

/**
 * @author Jainil Patel
 * Date: 12/3/2018
 * Description: This is the account class which makes a account for the customer
 * Method List: 
 * 		- public TransactionList(): default constructor which a list of records
 * 		- public boolean insert(TransactionRecord record): method used to insert records into list
 * 		- public int linearSearch(double search): method to search transactions by amount
 * 		- public void selectSort(): method to sort transactions by amount
 * 		- public void fileWriter(String fileName) throws IOException: method to write a file
 * 		- public void fileReader(String fileName) throws NumberFormatException, IOException: method to read a file
 * 		- public String toString(): method to print the list in a "sentence"
 * 		- public static void main(String[] args): main method for self-testing the program
 */
public class TransactionList {

	// instance variables
	private TransactionRecord list[]; // array of transac records
	private int maxSize; // max number of records
	private int size; // current size of records

	/**
	 * Default Constructor
	 */
	public TransactionList() {
		this.maxSize = 20;
		this.size = 0;
		list = new TransactionRecord[maxSize];
	}

	/**
	 * @return the list
	 */
	public TransactionRecord[] getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(TransactionRecord[] list) {
		this.list = list;
	}

	/**
	 * @return the maxSize
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * @param maxSize the maxSize to set
	 */
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/*
	 * Method to insert a record into my list Checks if size is below the maximum
	 * size increases the size adds it to the location just below the maximum size
	 * return true if it is able to add
	 */
	public boolean insert(TransactionRecord record) {
		if (this.size < maxSize) {
			size++;
			list[size - 1] = record;
			return true; // success
		}
		return false; // no more space
	}

	/*
	 * Method to search
	 */
	public int linearSearch(double search) {
		// loop through list
		for (int i = 0; i < size; i++) {
			if (list[i].getTransacAmt() == (search)) {
				return i; // key found at i
			}
		}
		return -1; // key not found
	}

	/*
	 * Selection sort method
	 */
	public void selectSort() {
		// loop through the array
		for (int top = size - 1; top > 0; top--) {
			int largest = 0;
			// starts at the bottom
			for (int i = 1; i <= top; i++)
				if (list[i].getTransacAmt() > list[largest].getTransacAmt()) // if transac amt at i is greater than largest
					largest = i;
			// swapping items
			TransactionRecord temp = list[top];
			list[top] = list[largest];
			list[largest] = temp;
		}
	}

	/*
	 * Method to write to files
	 */
	public void fileWriter(String fileName) throws IOException {
		try {
			PrintWriter fw = new PrintWriter(new FileWriter(fileName));
			fw.println(this.size);
			for (int i = 0; i < this.size; i++) { // runs for loop based off of number of lines
				fw.println(getList()[i].processString()); // writes each line into file
			}
			fw.close(); // closes printWriter
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Please check file name.");
		}
	}

	/*
	 * Method to read from file
	 */
	public void fileReader(String fileName) throws NumberFormatException, IOException {
		try {
			FileReader fr = new FileReader(fileName); // sets up filereader
			BufferedReader input = new BufferedReader(fr); // sets up bufferedreader
			int num = Integer.parseInt(input.readLine());
			for (int i = 0; i < num; i++) {
				insert(new TransactionRecord(input.readLine())); // read line and inserts record
			}
			input.close(); // closes file
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "File not found or corrupt.");
		}
	}

	/*
	 * toString() method
	 */
	public String toString() {
		String theList = "";
		for (int i = 0; i < size; i++) {
			theList += "Record " + (i + 1) + ": " + list[i].toString() + "\n";
		}
		return theList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// creating new transaction list
		TransactionList t = new TransactionList();
		TransactionRecord transac = new TransactionRecord();

		// for loop to insert transactions 20 times
		// transaction should not be added the 21st time
		for (int i = 0; i < 21; i++) {
			transac = new TransactionRecord();
			// tests process transaction
			transac.processTransaction("Deposit/1000/c/0/1000");

			System.out.println("Transaction: " + (i + 1) + " insert successful: " + t.insert(transac));
		}

		// testing binary search
		double amount = 1000;
		int location = t.linearSearch(amount);
		if (location >= 0) {
			System.out.println("\n" + amount + " successfully found at: " + location);
		} else {
			System.out.println("\n" + amount + " not found.");
		}

		// testing select sort and toString
		t.selectSort();
		System.out.println("\nList sorted by year:\n" + t.toString());

		try {
			t.fileWriter("file1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TransactionList testFile = new TransactionList();
		testFile.insert(new TransactionRecord("Deposit/1000/c/0/1000"));
		try {
			testFile.fileReader("file1.txt");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}