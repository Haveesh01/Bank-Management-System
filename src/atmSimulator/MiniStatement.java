package atmSimulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class MiniStatement extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	JButton back;
	JTextArea statementsArea;
	String cardnum;
	
	MiniStatement(String cardnum){
		this.cardnum = cardnum;
		setLayout(null);
		
		JLabel heading = new JLabel("Mini Statement");
		heading.setBounds(210 , 20 , 400 , 30);
		heading.setFont(new Font("system",Font.BOLD,24));
		add(heading);
		
		JLabel statementHeading = new JLabel("Statements");
		statementHeading.setBounds(20 , 80 , 150 , 30);
		statementHeading.setFont(new Font("system",Font.BOLD,20));
		add(statementHeading);
		
		JLabel cardNo = new JLabel("Card Number : XXXX-XXXX-XXXX-" + cardnum.substring(12));
		cardNo.setBounds(20 , 120 , 450 , 30);
		cardNo.setFont(new Font("system",Font.BOLD,18));
		add(cardNo);
		
		statementsArea = new JTextArea();
        statementsArea.setBounds(10, 170, 580, 350);
        statementsArea.setFont(new Font("system", Font.BOLD, 14));
        statementsArea.setEditable(false); // Prevent editing
        JScrollPane scrollPane = new JScrollPane(statementsArea); // Add a scroll pane
        scrollPane.setBounds(10, 170, 580, 330);
        add(scrollPane);
		
		JLabel balanceText = new JLabel();
		balanceText.setBounds(20 , 510 , 300 , 30);
		balanceText.setFont(new Font("system",Font.BOLD,14));
		add(balanceText);
		
		back = new JButton("Back");
		back.setBounds(400, 555, 150, 30);
		back.addActionListener(this);
		add(back);
		
		Conn con = new Conn();
		try {
			ResultSet rs = con.s.executeQuery("select * from bank where card_number = '"+cardnum+"' ");
			while(rs.next()) {
				statementsArea.append(rs.getString("date") + "\t" + rs.getString("type") + "\t" + rs.getString("amount") + "\n\n");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		int balance = 0;
		try {
			ResultSet balrs = con.s.executeQuery("select * from bank where card_number = '"+cardnum+"' ");
			while(balrs.next()){
				if(balrs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(balrs.getString("amount"));
				}else {
					balance -= Integer.parseInt(balrs.getString("amount"));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		balanceText.setText("Your current account balance is "+balance);
		
		setSize(600,600);
		setLocation(450,100);
		setUndecorated(true);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
	}

}
