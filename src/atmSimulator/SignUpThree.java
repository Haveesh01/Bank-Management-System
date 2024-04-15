package atmSimulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.*;

public class SignUpThree extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	String formNo;
	JRadioButton savingsAcc , fdAcc , currentAcc , recDepAcc;
	JCheckBox c1 , c2 , c3 , c4 , c5 , c6 , c7 ;
	JButton submit , cancel;
	
	SignUpThree(String formNo){
		this.formNo = formNo;
		setTitle("New Account Application Form - Page 3");
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel personalDetails = new JLabel("Page 3 : Account Details");
		personalDetails.setFont(new Font("Raleway" , Font.BOLD , 24));
		personalDetails.setBounds(265 , 80 , 300 , 30);
		add(personalDetails);
		
		JLabel accType = new JLabel("Account Type");
		accType.setFont(new Font("Raleway" , Font.BOLD , 22));
		accType.setBounds(120 , 140 , 300 , 25);
		add(accType);
		
		savingsAcc = new JRadioButton("Savings Account");
		savingsAcc.setFont(new Font("Raleway" , Font.BOLD , 18));
		savingsAcc.setBackground(Color.WHITE);
		savingsAcc.setBounds(120, 180, 200, 30);
		add(savingsAcc);
		
		fdAcc = new JRadioButton("Fixed Deposit Account");
		fdAcc.setFont(new Font("Raleway" , Font.BOLD , 18));
		fdAcc.setBackground(Color.WHITE);
		fdAcc.setBounds(360, 180, 250, 30);
		add(fdAcc);
		
		currentAcc = new JRadioButton("Current Account");
		currentAcc.setFont(new Font("Raleway" , Font.BOLD , 18));
		currentAcc.setBackground(Color.WHITE);
		currentAcc.setBounds(120, 220, 200, 30);
		add(currentAcc);
		
		recDepAcc = new JRadioButton("Recurring Deposit Account");
		recDepAcc.setFont(new Font("Raleway" , Font.BOLD , 18));
		recDepAcc.setBackground(Color.WHITE);
		recDepAcc.setBounds(360, 220, 270, 30);
		add(recDepAcc);
		
		ButtonGroup accTypeGroup = new ButtonGroup();
		accTypeGroup.add(savingsAcc);
		accTypeGroup.add(fdAcc);
		accTypeGroup.add(currentAcc);
		accTypeGroup.add(recDepAcc);
		
		
		JLabel cardNoText = new JLabel("Card Number ");
		cardNoText.setFont(new Font("Raleway" , Font.BOLD , 22));
		cardNoText.setBounds(120 , 290 , 300 , 25);
		add(cardNoText);
		
		JLabel cardNoDigits = new JLabel("5040-XXXX-XXXX-XXXX");
		cardNoDigits.setFont(new Font("Raleway" , Font.BOLD , 22));
		cardNoDigits.setBounds(320, 290, 400, 25);
		add(cardNoDigits);
		
		JLabel cardDesText = new JLabel("(Your 16 Digit Card Number)");
		cardDesText.setFont(new Font("Raleway" , Font.BOLD , 12));
		cardDesText.setBounds(120 , 315 , 300 , 25);
		add(cardDesText);
		
		JLabel pinText = new JLabel("PIN");
		pinText.setFont(new Font("Raleway" , Font.BOLD , 22));
		pinText.setBounds(120 , 360 , 300 , 25);
		add(pinText);
		
		JLabel PINDigits = new JLabel("XXXX");
		PINDigits.setFont(new Font("Raleway" , Font.BOLD , 22));
		PINDigits.setBounds(320, 360, 100, 25);
		add(PINDigits);
		
		JLabel pinDes = new JLabel("(Your 4 digit PIN)");
		pinDes.setFont(new Font("Raleway" , Font.BOLD , 12));
		pinDes.setBounds(120 , 385 , 300 , 25);
		add(pinDes);
		
		JLabel servicesText = new JLabel("Services Required");
		servicesText.setFont(new Font("Raleway" , Font.BOLD , 22));
		servicesText.setBounds(120 , 430 , 300 , 25);
		add(servicesText);
		
		c1 = new JCheckBox("ATM Card");
		c1.setFont(new Font("Raleway" , Font.BOLD , 18));
		c1.setBackground(Color.WHITE);
		c1.setBounds(120, 470, 200, 30);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setFont(new Font("Raleway" , Font.BOLD , 18));
		c2.setBackground(Color.WHITE);
		c2.setBounds(360, 470, 250, 30);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setFont(new Font("Raleway" , Font.BOLD , 18));
		c3.setBackground(Color.WHITE);
		c3.setBounds(120, 505, 200, 30);
		add(c3);
		
		c4 = new JCheckBox("EMAIL & SMS Alerts");
		c4.setFont(new Font("Raleway" , Font.BOLD , 18));
		c4.setBackground(Color.WHITE);
		c4.setBounds(360, 505, 250, 30);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setFont(new Font("Raleway" , Font.BOLD , 18));
		c5.setBackground(Color.WHITE);
		c5.setBounds(120, 540, 200, 30);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setFont(new Font("Raleway" , Font.BOLD , 18));
		c6.setBackground(Color.WHITE);
		c6.setBounds(360, 540, 250, 30);
		add(c6);
		
		c7 = new JCheckBox("I hereby declate that the above entered details are correct to the best of my knowledge");
		c7.setFont(new Font("Raleway" , Font.BOLD , 12));
		c7.setBackground(Color.WHITE);
		c7.setBounds(120 , 610 , 550 , 25);
		add(c7);
		
		submit = new JButton("SUBMIT");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(220, 670, 150, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("CANCEL");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(420, 670, 150, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		setSize(850 , 800);
		setLocation(350,10);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit){
			String sformNo = formNo;
			String accType = null;
			if(savingsAcc.isSelected()) {
				accType = "Savings Account";
			}else if(fdAcc.isSelected()) {
				accType = "Fixed Deposit Account";
			}else if(currentAcc.isSelected()) {
				accType = "Current Account";
			}else if(recDepAcc.isSelected()) {
				accType = "Recurring Deposit Account";
			}
			String services = "";
			if(c1.isSelected()) services += "ATM Card ";
            if(c2.isSelected()) services += "Internet Banking ";
            if(c3.isSelected()) services += "Mobile Banking ";
            if(c4.isSelected()) services += "EMAIL & SMS Alerts ";
            if(c5.isSelected()) services += "Cheque Book ";
            if(c6.isSelected()) services += "E-Statement ";
            
            Random ran = new Random();
			String cardNo = "" +Math.abs((ran.nextLong() % 90000000L) + 5040936000000000L);
			String pin = String.format("%04d", Math.abs((ran.nextInt() % 10000)));
			
			try {
				if(accType== null) {
					JOptionPane.showMessageDialog(null, "Account Type is Required");
				} else if(services.equals("")) {
					JOptionPane.showMessageDialog(null, "Atleast one service is Required");
				} else if(c7.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Please check the declaration");
				} else {
					Conn con = new Conn();
					String query1 = "INSERT INTO signupthree values('"+sformNo+"' , '"+accType+"' , '"+cardNo+"' , '"+pin+"' , '"+services+"' )";
					String query2 = "INSERT INTO login values('"+sformNo+"' , '"+cardNo+"' , '"+pin+"' )";
					con.s.executeUpdate(query1);
					con.s.executeUpdate(query2);
					
					setVisible(false);
					new Credentials(cardNo, pin);
				}
			}catch(Exception e){
				System.out.println(e);
			}
			
		}else if(ae.getSource()==cancel){
			Conn con = new Conn();
			String query1 = "DELETE FROM signup where formno = '"+formNo+"' ";
			String query2 = "DELETE FROM signuptwo where formno = '"+formNo+"' ";

			try {
				con.s.executeUpdate(query1);
				con.s.executeUpdate(query2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			setVisible(false);
			new Login();
		}
	}
}
