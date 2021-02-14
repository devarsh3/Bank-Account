import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * @author Jainil Patel 
 * Date: 12/4/2018 
 * Description: This class makes the main GUI of the project. It makes interactions with the user and uses uses
 *              other classes to simulate a banking applications. 
 * Method List: 
 * 		- public UserInterface(): create the frame of the program and adds components to it 
 * 		- public void actionPerformed(ActionEvent e): executes code based on button click 
 *      - public void calculations(StringtType, char aType): used to deposit or withdraw money from accounts 
 *      - public void insertTransaction(): used to insert each transaction into a list (array) 
 *      - public static void main(String[] args): calls the constructor and runs the program
 */
public class UserInterface extends JFrame implements ActionListener {

	// variable for account objects, class objects, pictures, and labels
	private Customer customer;
	private Chequing chequing;
	private Savings savings;
	private TransactionRecord record;
	private TransactionList list;
	private TextPicture lblInput, lblOutput, lblAmount, lblChoose, lblModify, lblAccount, lblTotal, lblCheq, lblSave,
			lblInform;
	private int width, height, count;;
	private NumberFormat money;

	// instance variable for components
	private JPanel enterPanel, transacPanel, cornerPanel, changePanel;
	private JButton btnEnter, btnExit, btnClear, btnDeposit, btnWithdraw, btnDisplay, btnSort, btnSearch, btnSave,
			btnLoad, btnModify, btnLogout;
	private JTextField txtInput, txtAmount, txtModify, txtAccount, txtTotal, txtCheq, txtSave, txtaType;
	private JTextArea textOutput;
	private JScrollPane scrollbar;
	private JFileChooser fileChose;

	/**
	 * Default Constructor
	 */
	public UserInterface() {
		super("Bank of Suzuki"); // calls constructor of inherited class

		// initialize the width and height of the frame
		width = 900;
		height = 650;

		setLayout(null); // free to move anything around

		// creating accounts and transaction list
		customer = new Customer();
		chequing = new Chequing();
		savings = new Savings();
		record = new TransactionRecord();
		list = new TransactionList();

		// setting withdraw/deposit count to 0
		count = 0;

		// to format the prices
		money = NumberFormat.getCurrencyInstance();

		// creating file chooser
		fileChose = new JFileChooser();

		// creating JPanel to set stuff on
		enterPanel = new JPanel(); // panel for enter button
		enterPanel.setBounds(0, height - 560, width - 500, 40);
		enterPanel.setBackground(new Color(17, 8, 25));

		transacPanel = new JPanel(); // panel for withdraw and deposit buttons
		transacPanel.setBounds(250, height - 390, width - 800, 100);
		transacPanel.setBackground(new Color(17, 8, 25));

		cornerPanel = new JPanel(); // panel for display, clear, and exit buttons
		cornerPanel.setBounds(400, height - 100, width - 450, 50);
		cornerPanel.setBackground(new Color(17, 8, 25));

		changePanel = new JPanel(); // panel for search and sort buttons
		changePanel.setBounds(0, height - 210, width - 500, 40);
		changePanel.setBackground(new Color(17, 8, 25));

		// creating textfields
		txtInput = new JTextField("Your Name/Address/Phone Number");
		txtAmount = new JTextField();
		txtModify = new JTextField();
		txtAccount = new JTextField();
		txtTotal = new JTextField();
		txtCheq = new JTextField();
		txtSave = new JTextField();
		txtaType = new JTextField();

		// setting location and bounds of textFields
		txtInput.setBounds(50, 55, 300, 25);
		txtAmount.setBounds(50, 320, 150, 25);
		txtModify.setBounds(50, 400, 300, 25);
		txtAccount.setBounds(50, 170, 300, 25);
		txtAccount.setEditable(false);
		txtCheq.setBounds(40, 515, 150, 25);
		txtCheq.setEditable(false);
		txtSave.setBounds(215, 515, 150, 25);
		txtSave.setEditable(false);
		txtTotal.setBounds(125, 570, 150, 25);
		txtTotal.setEditable(false);
		txtaType.setBounds(50, 245, 150, 25);

		// creating textarea
		textOutput = new JTextArea(5, 30);
		textOutput.setBounds(400, 55, 450, 450);
		textOutput.setEditable(false);

		// creating scrollbar
		scrollbar = new JScrollPane(textOutput); // scrollbar for the textArea
		scrollbar.getVerticalScrollBar().setBackground(new Color(212, 175, 55));
		scrollbar.setBounds(400, 55, width - 450, 450);

		// creating labels using textPicture
		lblInput = new TextPicture("Enter Name and Phone #:", 10, 10);
		lblInput.setMyFont(new Font("Arial", Font.PLAIN, 14));
		lblInput.setBounds(40, 30, 300, 25);

		lblOutput = new TextPicture("Output displays here:", 10, 10);
		lblOutput.setMyFont(new Font("Arial", Font.PLAIN, 14));
		lblOutput.setBounds(390, 30, 300, 25);

		lblAmount = new TextPicture("Enter Amount:", 10, 10);
		lblAmount.setMyFont(new Font("Arial", Font.PLAIN, 14));
		lblAmount.setBounds(40, 295, 300, 25);

		lblChoose = new TextPicture("Enter Account Type: (c or s)", 10, 10);
		lblChoose.setMyFont(new Font("Arial", Font.PLAIN, 14));
		lblChoose.setBounds(40, 220, 300, 25);

		lblModify = new TextPicture("Enter search amount here:", 10, 10);
		lblModify.setMyFont(new Font("Arial", Font.PLAIN, 14));
		lblModify.setBounds(40, 375, 300, 25);

		lblAccount = new TextPicture("Account Number:", 10, 10);
		lblAccount.setMyFont(new Font("Arial", Font.PLAIN, 14));
		lblAccount.setBounds(40, 145, 300, 25);

		lblTotal = new TextPicture("Total Balance:", 10, 10);
		lblTotal.setMyFont(new Font("Arial", Font.PLAIN, 14));
		lblTotal.setBounds(115, 550, 300, 25);

		lblCheq = new TextPicture("Chequing Balance:", 10, 10);
		lblCheq.setMyFont(new Font("Arial", Font.PLAIN, 14));
		lblCheq.setBounds(30, 495, 150, 25);

		lblSave = new TextPicture("Savings Balance:", 10, 10);
		lblSave.setMyFont(new Font("Arial", Font.PLAIN, 14));
		lblSave.setBounds(205, 495, 150, 25);

		lblInform = new TextPicture("Welcome!", 10, 10);
		lblInform.setMyFont(new Font("Arial", Font.BOLD, 18));
		lblInform.setColor(new Color(212, 175, 55));
		lblInform.setBounds(580, 530, 300, 45);

		// creating buttons
		btnEnter = new JButton("Enter");
		btnExit = new JButton("Exit");
		btnClear = new JButton("Clear");
		btnDeposit = new JButton("Deposit");
		btnWithdraw = new JButton("Withdraw");
		btnDisplay = new JButton("Display");
		btnSearch = new JButton("Search");
		btnSort = new JButton("Sort");
		btnSave = new JButton("Save");
		btnLoad = new JButton("Load");
		btnModify = new JButton("Modify");
		btnLogout = new JButton("Logout");

		// changing background color of buttons
		btnEnter.setBackground(new Color(212, 175, 55));
		btnExit.setBackground(new Color(212, 175, 55));
		btnClear.setBackground(new Color(212, 175, 55));
		btnDeposit.setBackground(new Color(212, 175, 55));
		btnWithdraw.setBackground(new Color(212, 175, 55));
		btnDisplay.setBackground(new Color(212, 175, 55));
		btnSearch.setBackground(new Color(212, 175, 55));
		btnSort.setBackground(new Color(212, 175, 55));
		btnSave.setBackground(new Color(212, 175, 55));
		btnLoad.setBackground(new Color(212, 175, 55));
		btnModify.setBackground(new Color(212, 175, 55));
		btnLogout.setBackground(new Color(212, 175, 55));

		// disabling modify buttons
		btnModify.setVisible(false);

		// adding buttons to control panel
		enterPanel.add(btnEnter);
		enterPanel.add(btnModify);
		transacPanel.add(btnDeposit);
		transacPanel.add(btnWithdraw);
		cornerPanel.add(btnDisplay);
		cornerPanel.add(btnSave);
		cornerPanel.add(btnLoad);
		cornerPanel.add(btnClear);
		cornerPanel.add(btnLogout);
		cornerPanel.add(btnExit);
		changePanel.add(btnSearch);
		changePanel.add(btnSort);

		// adding panels, images, and text to the frame
		add(enterPanel);
		add(transacPanel);
		add(cornerPanel);
		add(changePanel);
		add(lblInput);
		add(lblOutput);
		add(lblAmount);
		add(lblChoose);
		add(lblModify);
		add(lblAccount);
		add(lblCheq);
		add(lblSave);
		add(lblTotal);
		add(lblInform);
		add(scrollbar);
		add(txtInput);
		add(txtAmount);
		add(txtModify);
		add(txtAccount);
		add(txtTotal);
		add(txtCheq);
		add(txtSave);
		add(txtaType);

		// add buttons as a listener in this frame
		btnEnter.addActionListener(this);
		btnExit.addActionListener(this);
		btnClear.addActionListener(this);
		btnDeposit.addActionListener(this);
		btnWithdraw.addActionListener(this);
		btnSearch.addActionListener(this);
		btnSort.addActionListener(this);
		btnDisplay.addActionListener(this);
		btnSave.addActionListener(this);
		btnLoad.addActionListener(this);
		btnModify.addActionListener(this);
		btnLogout.addActionListener(this);

		// set size and location of frame
		setSize(width, height);
		// centers the frame on the screen
		// Obtained from:
		// https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		// set frame visible
		setVisible(true);
		// changes background color of frame
		getContentPane().setBackground(new Color(17, 8, 25));
		// close the frame on "x"
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// String value;
		char aType;
		double total;

		// if enter buttons is clicked
		if (e.getSource() == btnEnter) {
			customer.processCustomer(txtInput.getText()); // gets user input and creates customer (using setters)
			textOutput.setText(customer.toString() + "\n" + savings.toString()); // displays customer info and account
																					// info
			txtAccount.setText("" + savings.getAccountNum()); // displays account number
			lblInform.setMyTitle("Customer Created"); // informs user
			btnEnter.setVisible(false);
			btnModify.setVisible(true);
		}

		// if modify buttons is clicked
		else if (e.getSource() == btnModify) {
			customer.processCustomer(txtInput.getText()); // get new user input and makes a customer
			textOutput.setText(customer.toString() + "\n" + savings.toString()); // displays info to customer
			lblInform.setMyTitle("Customer Modified"); // informs user
		}

		// if withdraw buttons is clicked
		else if (e.getSource() == btnWithdraw) {
			if ((txtaType.getText().equals("c")) || (txtaType.getText().equals("s"))) {
				aType = txtaType.getText().charAt(0); // gets user input

				calculations("Withdraw", aType); // calls calculate method to withdraw

				insertTransaction(); // inserts transaction

				// updates total balance
				total = chequing.getBalance() + savings.getBalance();
				txtTotal.setText(String.valueOf(money.format(total)));
				lblInform.setMyTitle("Withdrawl Successful");

				// if transactions exceed 20
				if (count > 19) {
					lblInform.setMyTitle("Max Transactions Reached");
					btnWithdraw.setEnabled(false);
					btnDeposit.setEnabled(false);
				}

				lblChoose.setMyTitle("Please enter either 'c' or 's'");
				lblChoose.setColor(new Color(212, 175, 55));

				count++; // increases count by 1
			}

			else {
				lblChoose.setMyTitle("Enter Account Type: (c or s)");
				lblChoose.setColor(Color.RED);
			}

		}

		// if deposit buttons is clicked
		else if (e.getSource() == btnDeposit) {
			if ((txtaType.getText().equals("c")) || (txtaType.getText().equals("s"))) {
				aType = txtaType.getText().charAt(0); // gets user input of account type

				calculations("Deposit", aType); // calls calculate method to deposit

				insertTransaction(); // inserts transaction into record list

				// updates total balance
				total = chequing.getBalance() + savings.getBalance();
				txtTotal.setText(String.valueOf(money.format(total)));
				lblInform.setMyTitle("Deposit Successful");

				// if transactions exceed 20
				if (count > 19) {
					lblInform.setMyTitle("Max Transactions Reached");
					btnWithdraw.setEnabled(false);
					btnDeposit.setEnabled(false);
				}

				lblChoose.setMyTitle("Please enter either 'c' or 's'");
				lblChoose.setColor(new Color(212, 175, 55));

				count++; // increases count by 1
			} else {
				lblChoose.setMyTitle("Enter Account Type: (c or s)");
				lblChoose.setColor(Color.RED);
			}
		}

		// if clear buttons is clicked
		else if (e.getSource() == btnClear) {
			// clear all textfields
			txtaType.setText("");
			txtAmount.setText("");
			txtModify.setText("");
			txtCheq.setText("");
			txtSave.setText("");
			txtTotal.setText("");
			textOutput.setText("");
			// clearing transaction list
			list.setSize(0);
			count = 0; // resetting count
			btnWithdraw.setEnabled(true);
			btnDeposit.setEnabled(true);
			lblInform.setMyTitle("Cleared");
		}

		// if display button is clicked
		else if (e.getSource() == btnDisplay) {
			// displaying customer info, account info, and transaction list
			textOutput.setText(customer.toString() + "\n" + savings.toString() + "\n" + list.toString());
			lblInform.setMyTitle("Displayed");
		}

		// if search buttons is clicked
		else if (e.getSource() == btnSearch) {
			try {
				// gettind user input
				int check = list.linearSearch(Double.parseDouble(txtModify.getText()));
				// if item is found, then display it on the textArea
				if (check >= 0) {
					textOutput.setText("Transaction found at " + (check + 1) + "\nTransaction " + (check + 1) + ": "
							+ list.getList()[check].toString() + "\n" + customer.toString() + "n" + savings.toString()
							+ "\n" + list.toString());
					lblInform.setMyTitle("Record Found");
				} else { // otherwise inform user
					textOutput.setText("Record not found.");
					lblInform.setMyTitle("Record Not Found");
				}
				lblModify.setMyTitle("Enter search amount here:");
				lblModify.setColor(new Color(212, 175, 55));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				lblModify.setMyTitle("You can only enter numbers!");
				lblModify.setColor(Color.RED);
			}
		}

		// if sort buttons is clicked
		else if (e.getSource() == btnSort) {
			// sorts transaction list by ascending amount
			list.selectSort();
			textOutput.setText(customer.toString() + "\n" + savings.toString() + "\n" + list.toString());
			lblInform.setMyTitle("Sorted");
		}

		// if save buttons is clicked
		else if (e.getSource() == btnSave) {
			// asks user for file input
			String file = JOptionPane.showInputDialog(null, "Enter file name:", "file1.txt");
			try {
				// writes transac list to a file
				list.fileWriter(file);
				lblInform.setMyTitle("File Saved");
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Please check file");
			}
		}

		else if (e.getSource() == btnLoad) {
			// gets user input for file name
			String file = JOptionPane.showInputDialog(null, "Enter in location of file", "file1.txt");
			try {
				// reads transac list from file
				list.fileReader(file);
				lblInform.setMyTitle("File Loaded");
			} catch (NumberFormatException | IOException e1) {
				JOptionPane.showMessageDialog(null, "Please check file");
			}
			// displays list to user
			textOutput.setText(customer.toString() + "n" + savings.toString() + "\n" + list.toString());
		}

		// if logout buttons is clicked
		else if (e.getSource() == btnLogout) {
			new Login(); // go back to login screen
			dispose();
		}

		// if exit button is clicked
		else {
			JOptionPane.showMessageDialog(null, "Thank You for choosing 2DJ Bank :)");
			System.exit(0);
		}
	}

	public void calculations(String tType, char aType) {
		// making new record with user inputs
		try {
			record = new TransactionRecord(tType, Double.parseDouble(txtAmount.getText()), aType);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			lblAmount.setMyTitle("Please check amount.");
			lblAmount.setColor(Color.RED);
		}

		if (aType == 'c') { // if user input is chequing
			record.setStartBal(chequing.getBalance()); // setting starting balance
			if (tType.equalsIgnoreCase("Withdraw")) {
				try {
					if (!chequing.withdraw(Double.parseDouble(txtAmount.getText()))) { // depositing money
						lblInform.setMyTitle("Withdraw Unsuccessful");
					}
					else {
						lblInform.setMyTitle("Withdraw Successful");
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					lblAmount.setMyTitle("You can only enter numbers");
					lblAmount.setColor(Color.RED);
				}
			} else {
				try {
					chequing.deposit(Double.parseDouble(txtAmount.getText()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					lblAmount.setMyTitle("You can only enter numbers");
					lblAmount.setColor(Color.RED);
				} // depositing money
					
			}
			record.setEndBal(chequing.getBalance()); // setting end balance
			txtCheq.setText(String.valueOf(money.format(record.getEndBal()))); // displaying end balance
		}

		else { // if user input is savings
			record.setStartBal(savings.getBalance()); // setting starting balance
			if (tType.equalsIgnoreCase("Withdraw")) {
				try {
					if (!savings.withdraw(Double.parseDouble(txtAmount.getText()))) {// withdrawing money
						lblInform.setMyTitle("Withdraw Unsuccessful");
					}
					else {
						lblInform.setMyTitle("Withdraw Successful");
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					lblAmount.setMyTitle("You can only enter numbers");
					lblAmount.setColor(Color.RED);
				}
			} else {
				try {
					savings.deposit(Double.parseDouble(txtAmount.getText()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					lblAmount.setMyTitle("You can only enter numbers");
					lblAmount.setColor(Color.RED);
				} // withdrawing money
			}
			record.setEndBal(savings.getBalance()); // setting end balance
			txtSave.setText(String.valueOf(money.format(record.getEndBal()))); // displaying end balance
		}
	}

	/*
	 * Method to insert transaction
	 */
	public void insertTransaction() {
		String rec = record.processString(); // calls processString (converts everything back to "/")
		record.processTransaction(rec);
		list.insert(record); // inserts transactions
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// calls constructor (runs program)
		UserInterface UI = new UserInterface();
	}
}