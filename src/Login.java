 //Devarsh Patwa
//Dec 2018
//this is the login page for the user

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

	private String username, employeeUser;
	private String password, employeePass;
	private JPasswordField passField;
	private JTextField userField;
	private TextPicture userText, passText, heading, info;
	private JCheckBox show;
	private JButton btnLogin, btnBack, btnRegister;
	private WelcomePage welcomePage;
	private UserInterface mainGUI;


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param the pasword to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

	/**
	 * @return the employeeUser
	 */
	public String getEmployeeUser() {
		return employeeUser;
	}

	/**
	 * @param employeeUser the employeeUser to set
	 */
	public void setEmployeeUser(String employeeUser) {
		this.employeeUser = employeeUser;
	}

	/**
	 * @return the employeePass
	 */
	public String getEmployeePass() {
		return employeePass;
	}

	/**
	 * @param employeePass the employeePass to set
	 */
	public void setEmployeePass(String employeePass) {
		this.employeePass = employeePass;
	}

	public Login() {
		//create components
		setEmployeeUser("HardWorker");
		setEmployeePass("2djbank");
		userField = new JTextField();
		passField = new JPasswordField();
		userText = new TextPicture();
		passText = new TextPicture();
		show = new JCheckBox("Show Password");
		btnLogin = new JButton("Login");
		btnRegister = new JButton("Register");
		btnBack = new JButton("Back");
		heading = new TextPicture();
		info = new TextPicture();

		//set the user text
		userText.setMyTitle("Username");
		userText.setColor(new Color(212,175,55));
		userText.setBounds(130,150,150,30);
		userText.setFont(new Font("Monospaced", Font.BOLD, 18));

		//set the password text
		passText.setMyTitle("Password");
		passText.setColor(new Color(212,175,55));
		passText.setBounds(130,250,150,30);
		passText.setFont(new Font("Monospaced", Font.BOLD, 18));

		heading.setMyTitle("Login using either customer or employee credentials.");
		heading.setColor(new Color(212,175,55));
		heading.setBounds(30,100,450,40);
		heading.setFont(new Font("Monospaced", Font.BOLD, 14));

		info.setMyTitle("");
		info.setColor(new Color(212,175,55));
		info.setBounds(30,500,450,40);
		info.setFont(new Font("Monospaced", Font.BOLD, 18));

		//add the text
		add(userText);
		add(passText);
		add(heading);
		add(info);
		//set the fields
		userField.setBounds(160,190,150,30);
		add(userField);

		passField.setBounds(160,290,150,30);
		add(passField);

		//add check box for show password
		show.setBounds(260,325,150,25);
		show.setBackground(new Color (212,175,55));
		add(show);

		//add button
		btnLogin.setBounds(170,360,120,40);
		btnLogin.setBackground(new Color(212,175,55)); //set button gold color
		add(btnLogin);

		btnRegister.setBounds(170,410,120,40);
		btnRegister.setBackground(new Color(212,175,55)); //set button gold color
		add(btnRegister);

		btnBack.setBounds(10,10,70,40);
		btnBack.setBackground(new Color(212,175,55));
		add(btnBack);

		//listen to buttons
		btnLogin.addActionListener(this);
		show.addActionListener(this);
		btnBack.addActionListener(this);
		btnRegister.addActionListener(this);

		setLayout(null); //set the layout to null
		setSize(500,600); //set the window size
		// centers the frame on screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		// changes background color of frame
		getContentPane().setBackground(new Color (17, 8, 25));
		
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void fileWriter() throws IOException {
		PrintWriter fw = new PrintWriter(new FileWriter("login.txt"));
		fw.println("2");
		fw.println(getUsername());
		fw.println(getPassword());
		fw.close(); // closes printWriter
	}

	public void fileReader() throws NumberFormatException, IOException {
		FileReader fr = new FileReader("login.txt"); // sets up filereader
		BufferedReader input = new BufferedReader(fr); // sets up bufferedreader
		int num = Integer.parseInt(input.readLine());
		setUsername(input.readLine());
		setPassword(input.readLine());
		input.close(); // closes file
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {

		if(show.isSelected()) { //if show password is selected
			passField.setEchoChar((char)0); //show the password
		}
		else { //if it not selected
			passField.setEchoChar('\u2022'); //hide the password
		}

		if(e.getSource()==btnLogin) {
			try {
				fileReader();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(userField.getText().equals(getUsername()) && passField.getText().equals(getPassword())) { //if username and password is correct
				mainGUI = new UserInterface();
				dispose();
			}
			else if(userField.getText().equals(getEmployeeUser()) && passField.getText().equals(getEmployeePass())) { 
				new EmployeeGui();
				dispose();
			}

			//	else if(userField.getText)
			else {
				JOptionPane.showMessageDialog(null,"Wrong Username or Password"); //if incorrect
			}
		}

		if(e.getSource()==btnRegister) {
			if(userField.getText().equals("")|| passField.getText().equals("")) { //if the fields are empty
				info.setMyTitle("Please fill in the information!");
			}
			else {	
				setUsername(userField.getText());
				setPassword(passField.getText());
				try {
					fileWriter();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				info.setMyTitle("You are all set to go! Please Login!");
				userField.setText("");
				passField.setText("");
			}
		}

		if(e.getSource()==btnBack) {
			welcomePage = new WelcomePage();
			dispose();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login gui = new Login();

	}



}
