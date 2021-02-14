import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Devarsh Patwa
//October 2018
//this class displays a text and tests it with all the setters from picture class


public class TextPicture extends Picture {


    private String title;
    private Color c;
    private Font font;
	
	public TextPicture() {
		this.font = new Font("Times New Roman",Font.PLAIN,20);
		setFont(font);
		setColor(Color.BLUE);
		setMyTitle("Wasup");
		setxPos(30);
		setyPos(30);
		repaint();
	}
	
	// Constructor to for specific location and title
	public TextPicture(String title,int x, int y) {
		super();
		setxPos(x);
		setyPos(y);
		setMyTitle(title);
		this.font = new Font("Monospaced", Font.PLAIN, 12);
		
		repaint();
	}

	

	
	public String getTitle() {
		return title;
	}



	public void setMyTitle(String title) {
		this.title = title;
		repaint();
	}



	public void setMyFont(Font font) {
		this.font = font;
		repaint();
	}
	public Font getFont() {
		return font;
	}




	public void paint (Graphics g) {
		g.setFont(getFont());
		g.setColor(getColor());
		g.drawString(title, this.getxPos(), this.getyPos());
	}
	
	
	public static void main(String[] args) {

        //set window
		JFrame f = new JFrame("Testing");
		f.setSize(400,350);
		//create a textPicture object
		TextPicture p = new TextPicture();
		f.add(p);
		f.setVisible(true);
		
		//test setColor
		JOptionPane.showMessageDialog(null, "Wait");
		p.setColor(Color.RED);		
		f.setVisible(true);
		
		//test setColor(RBG)
		JOptionPane.showMessageDialog(null, "Wait");
		p.setColor(50,50,50);
		f.setVisible(true);
		
		//test setXPos
		JOptionPane.showMessageDialog(null, "Wait");
		p.setxPos(150);
		f.setVisible(true);
		
		//test setYPos
		JOptionPane.showMessageDialog(null, "Wait");
		p.setyPos(200);
		f.setVisible(true);
		
		//test setTitle
		p.setMyTitle("sup");
		f.setVisible(true);
		
		//test setMyheight
		JOptionPane.showMessageDialog(null, "Wait");
		p.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		f.setVisible(true);
		
		
		JOptionPane.showMessageDialog(null, "Wait");
		f.remove(p);
		p = new TextPicture("Hello",50,50);
		f.add(p);
		f.setVisible(true);
	}

}
