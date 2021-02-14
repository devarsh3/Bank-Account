import javax.imageio.*;
//Devarsh
//Dec 2018
//

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WelcomePage extends JFrame implements ActionListener {

	private ImagePicture logo;
	private ImageIcon image;
	private JButton btnLogin, btnHelp, btnExit;
	private Login loginPage;
	private TermsAndConditions helpPage;

	public WelcomePage() {
		// create components
		try {
			image = new ImageIcon(ImageIO.read(getClass().getResource("goldlogo.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Image not found!");
		} // background photo
		logo = new ImagePicture(image, 0, 0);
		btnLogin = new JButton("Login");
		btnHelp = new JButton("Help");
		btnExit = new JButton("Exit");

		// set buttons
		btnLogin.setBackground(new Color(212, 175, 55));
		btnLogin.setFont(new Font("Helvetica", Font.ITALIC, 20));
		btnLogin.setBounds(390, 500, 140, 30);
		add(btnLogin);

		btnHelp.setBackground(new Color(212, 175, 55));
		btnHelp.setFont(new Font("Helvetica", Font.ITALIC, 20));
		btnHelp.setBounds(100, 500, 140, 30);
		add(btnHelp);

		btnExit.setBackground(new Color(212, 175, 55));
		btnExit.setFont(new Font("Helvetica", Font.ITALIC, 20));
		btnExit.setBounds(700, 500, 140, 30);
		add(btnExit);

		// set the background
		logo.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		add(logo);

		// make buttons listen
		btnLogin.addActionListener(this);
		btnHelp.addActionListener(this);
		btnExit.addActionListener(this);

		setLayout(null);
		setSize(image.getIconWidth(), image.getIconHeight());
		setVisible(true);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnExit) {
			System.exit(0); // exit
		}

		if (e.getSource() == btnLogin) {
			loginPage = new Login(); // open the login window
			dispose();
		}

		if (e.getSource() == btnHelp) { // open help window
			helpPage = new TermsAndConditions();
			dispose();
		}

	}

	public static void main(String[] args) {
		WelcomePage gui = new WelcomePage();

	}

}
