package atmSimulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	JButton back;
	String cardnum;
	
	BalanceEnquiry(String cardnum){
		this.cardnum = cardnum;
		setLayout(null);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
		Image atmScaled = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon atm = new ImageIcon(atmScaled);
		JLabel atmimage = new JLabel(atm);
		atmimage.setBounds(0 , 0 , 900 , 900);
		add(atmimage);
		
		JLabel text = new JLabel("Balance Enquiry");
		text.setBounds(275 , 310 , 400 , 30);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("system",Font.BOLD,14));
		atmimage.add(text);
		
		Conn con = new Conn();
		int balance = 0;
		
		try {
			ResultSet rs = con.s.executeQuery("select * from bank where card_number = '"+cardnum+"'");
			while(rs.next()){
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel retext = new JLabel("Your current account balance is Rs "+balance);
		retext.setBounds(170 , 350 , 450 , 30);
		retext.setForeground(Color.WHITE);
		retext.setFont(new Font("system",Font.BOLD,14));
		atmimage.add(retext);
		
		back = new JButton("Back");
		back.setBounds(360, 555, 150, 30);
		back.addActionListener(this);
		atmimage.add(back);
		
		setSize(900,900);
		setLocation(350,0);
		//setUndecorated(true);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(cardnum);
		}
	}
}
