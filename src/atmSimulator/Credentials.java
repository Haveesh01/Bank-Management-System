package atmSimulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Credentials extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	JButton close;
	
	Credentials(String cardNo , String pin) {
		
		setTitle("ATM Machine");  //Setting a title for the Frame
		setLayout(null); //Nullify the default layout
		getContentPane().setBackground(Color.white); // Background colour of the frame
		
		JLabel heading = new JLabel("YOUR CREDENTIALS"); // Main Heading
		heading.setFont(new Font("Raleway",Font.BOLD,40)); // Set desired font
		heading.setBounds(240, 40, 420, 40);
		add(heading);
		
		JLabel cardNoLabel = new JLabel("Card No : "); 
		cardNoLabel.setFont(new Font("Raleway",Font.BOLD,30)); 
		cardNoLabel.setBounds(125, 150, 150, 40);
		add(cardNoLabel);
		
		JLabel cardNoText = new JLabel(cardNo); //Text field for card number
		cardNoText.setBounds(275,160,350,30);
		cardNoText.setFont(new Font("Arial",Font.BOLD,24));
		add(cardNoText);
		
		JLabel pinLabel = new JLabel("PIN : ");
		pinLabel.setFont(new Font("Raleway",Font.BOLD,30)); 
		pinLabel.setBounds(125, 220, 100, 40);
		add(pinLabel);
		
		JLabel pinNoField = new JLabel(pin); //Text field for pin
		pinNoField.setBounds(275,230,350,30);
		pinNoField.setFont(new Font("Arial",Font.BOLD,24));
		add(pinNoField);
		
		JLabel noteLabel = new JLabel("(Note down your credentials before closing this window or you may");
		noteLabel.setFont(new Font("Raleway",Font.BOLD,20)); 
		noteLabel.setBounds(125, 280, 700, 25);
		add(noteLabel);
		
		JLabel noteLabel2 = new JLabel("loose it forever)");
		noteLabel2.setFont(new Font("Raleway",Font.BOLD,20)); 
		noteLabel2.setBounds(125, 305, 700, 25);
		add(noteLabel2);
		
		close = new JButton("CLOSE"); // Create account Button
		close.setBounds(375,350,150,30);
		close.setBackground(Color.BLACK);
		close.setForeground(Color.WHITE);
		close.addActionListener(this);
		add(close);
		
		setSize(900,500);
		setVisible(true); 
		setLocation(350 , 200); //To open the frame on the middle of the screen
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		System.exit(0);
	}
}
