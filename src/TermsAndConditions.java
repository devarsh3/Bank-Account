import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author Daunte
 *
 */
public class TermsAndConditions extends JFrame implements ActionListener {

	private JPanel jp = new JPanel();
	private JTextArea jf = new JTextArea(
			"Terms and Conditions:\n\n"
			+ "Creating an Account:\n"
			+ "If you do not have an account, input a username and password and click register to\n"
			+ "create one\n\n"
			+ "Savings Account:\n" + "If the balance is lower than 2000, a fee $1.25 is deducted for each withdrawal\n\n"
			+ "Chequing Account:\n"
			+ "Deducts a fee of .5% of current balance (before withdrawal) when money is \nwithdrawn"
			+ "Service fee of $1.50 each deposit\n\n"
			+ "");
	private JButton back = new JButton("Back");//declares back button
	private JButton exit = new JButton("Exit");//declares exit button
	private WelcomePage welcomePage;//declares welcome page

	public TermsAndConditions() {
		setLayout(null);

		jp.setBounds(0, 400, 500, 50);//sets the bounds 
		jp.setBackground(new Color(17, 8, 25));// sets background

		back.setBounds(50, 100, 100, 25);
		back.setBackground(new Color(212, 175, 55));
		exit.setBounds(100, 100, 100, 25);
		exit.setBackground(new Color(212, 175, 55));

		jf.setBounds(10, 10, 465, 375);
		jf.setEditable(false);// makes the text field not editable 

		jp.add(back);//adds back button 
		jp.add(exit);//adds exit button

		add(jp);
		add(jf);

		back.addActionListener(this);//listens to buttons
		exit.addActionListener(this);

		// changes background color of frame
		getContentPane().setBackground(new Color(17, 8, 25));
		setTitle("Terms and Conditions");
		setVisible(true);
		setSize(500, 500);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TermsAndConditions t = new TermsAndConditions();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {//if the back button is pressed go back to welcome page 
			welcomePage = new WelcomePage();
			dispose();
		} else {
			System.exit(0);
		}
	}

}