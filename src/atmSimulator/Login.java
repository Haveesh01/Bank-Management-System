package atmSimulator;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	JButton login,clear ,create;
	JTextField cardNoText;
	JPasswordField pinNoField;
	Login()
	{
		setTitle("Login");  //Setting a title for the Frame
		setLayout(null); //Nullify the default layout
		getContentPane().setBackground(Color.white); // Background colour of the frame
		
		
		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("images/logo.jpg")); //Loading the image from local environment
		Image ics = ic.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);  //Scaled logo
		ImageIcon logo = new ImageIcon(ics);
		JLabel logoLabel = new JLabel(logo);
		logoLabel.setBounds(200,10,100,100);
		add(logoLabel); //adding label to the frame
		
		JLabel heading = new JLabel("Welcome to ATM"); // Main Heading
		heading.setFont(new Font("Osward",Font.BOLD,40)); // Set desired font
		heading.setBounds(325, 40, 400, 40);
		add(heading);
		
		JLabel cardNo = new JLabel("Card No : "); 
		cardNo.setFont(new Font("Raleway",Font.BOLD,30)); 
		cardNo.setBounds(125, 150, 150, 40);
		add(cardNo);
		
		cardNoText = new JTextField(); //Text field for card number
		cardNoText.setBounds(275,160,350,30);
		cardNoText.setFont(new Font("Arial",Font.BOLD,14));
		add(cardNoText);
		
		JLabel pin = new JLabel("PIN : ");
		pin.setFont(new Font("Raleway",Font.BOLD,30)); 
		pin.setBounds(125, 220, 100, 40);
		add(pin);
		
		pinNoField = new JPasswordField(); //Text field for pin
		pinNoField.setBounds(275,230,350,30);
		pinNoField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinNoField);
		
		login = new JButton("LOGIN"); // Login button
		login.setBounds(275,300,170,30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR"); // Clear Button
		clear.setBounds(455,300,170,30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		create = new JButton("CREATE ACCOUNT"); // Create account Button
		create.setBounds(275,350,350,30);
		create.setBackground(Color.BLACK);
		create.setForeground(Color.WHITE);
		create.addActionListener(this);
		add(create);
		
		setSize(900,500);
		setVisible(true); 
		setLocation(350 , 200); //To open the frame on the middle of the screen
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==clear) {
			cardNoText.setText("");
			pinNoField.setText("");
		}else if(ae.getSource()==login) {
			Conn con = new Conn();
			String cardnum = cardNoText.getText();
			@SuppressWarnings("deprecation")
			String pinno = pinNoField.getText();
			String query = "select * from login where card_Number = '"+cardnum+"' and pin = '"+pinno+"' ";
			try {
				ResultSet rs = con.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(cardnum);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Credentials");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==create) {
			setVisible(false);
			new SignUpOne();
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}

}
