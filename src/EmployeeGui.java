
//Devarsh
//Dec 2018
//This the gui for the employee, which allows the employee to change the chequing withdrawal fee

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EmployeeGui extends JFrame implements ActionListener {

	private Chequing c;
	private Savings s;
	private TextPicture txtFee, txtTrans, txtAmt,txtDone;
	private JTextField feeArea, transArea, amtArea;
	private JButton btnApply, btnBack, btnExit;
	private TransactionList t;
	private Login login;

	public EmployeeGui() {
		txtFee = new TextPicture(); // create components
		txtTrans = new TextPicture();
		txtDone = new TextPicture();
		txtAmt = new TextPicture();
		feeArea = new JTextField();
		transArea = new JTextField();
		amtArea = new JTextField();
		btnApply = new JButton("Apply");
		btnBack = new JButton("Log Out");
		btnExit = new JButton("Exit");
		t = new TransactionList();
		c = new Chequing();
		s = new Savings();

		txtFee.setMyTitle("Change the Chequing withdrawal Fee(%)"); // heading fee
		txtFee.setColor(new Color(212, 175, 55)); // set color
		txtFee.setFont(new Font("Helvetica", Font.BOLD, 12)); // set font
		txtFee.setBounds(50, 30, 400, 40); // set position
		add(txtFee); // add

		feeArea.setBounds(80, 80, 300, 30); //set position
		feeArea.setText(""+c.getWdFee()); //set the default fee
		add(feeArea);

		txtTrans.setMyTitle("Change the maximum no. of Transactions");
		txtTrans.setColor(new Color(212, 175, 55));
		txtTrans.setFont(new Font("Helvetica", Font.BOLD, 12));
		txtTrans.setBounds(50, 120, 400, 60);
		add(txtTrans);

		transArea.setBounds(80, 160, 300, 30);
		transArea.setText(""+t.getMaxSize());
		add(transArea);
		
		txtAmt.setMyTitle("Change the minimum amount needed in Savings");
		txtAmt.setColor(new Color(212, 175, 55));
		txtAmt.setFont(new Font("Helvetica", Font.BOLD, 12));
		txtAmt.setBounds(30, 200, 420, 60);
		add(txtAmt);
		
		amtArea.setBounds(80,250,300,30);
		amtArea.setText(""+ s.getMinAmt());
		add(amtArea);
		
		txtDone.setMyTitle("");
		txtDone.setBounds(180, 300, 300, 40);
		txtDone.setColor(new Color(212, 175, 55));
		txtDone.setFont(new Font("Helvetica", Font.BOLD, 14));
		add(txtDone);

		btnApply.setBounds(80, 500, 80, 30);
		btnApply.setBackground(new Color(212, 175, 55));
		add(btnApply);

		btnBack.setBounds(170, 500, 100, 30);
		btnBack.setBackground(new Color(212, 175, 55));
		add(btnBack);

		btnExit.setBounds(280, 500, 100, 30);
		btnExit.setBackground(new Color(212, 175, 55));
		add(btnExit);

		// make the buttons listen
		btnApply.addActionListener(this);
		btnBack.addActionListener(this);
		btnExit.addActionListener(this);

		setLayout(null); // set the layout to null
		setSize(500, 600); // set the window size
		// centers the frame on screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		// changes background color of frame
		getContentPane().setBackground(new Color(17, 8, 25));

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnExit) { // exit the system
			System.exit(0);
		}

		if (e.getSource() == btnBack) { // if log out is clicked
			login = new Login(); // go back to login page
			dispose(); // close the current window
		}

		if (e.getSource() == btnApply) {
			if (feeArea.getText().equals("") && transArea.getText().equals("") && amtArea.getText().equals("")) { // if both fields are empty
				txtDone.setMyTitle("Please check inputs!");
			} else {
				c.setWdFee(Double.parseDouble(feeArea.getText())); // set the chequing fee
				t.setMaxSize(Integer.parseInt(transArea.getText())); // set the max size for the transactions	
				s.setMinAmt(Double.parseDouble(amtArea.getText())); //set the minimum account in savings account
				txtDone.setMyTitle("ALL DONE!"); //display
			}
		}

	}

	public static void main(String[] args) {

		EmployeeGui gui = new EmployeeGui();
	}

}
