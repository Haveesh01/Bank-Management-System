package atmSimulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import javax.swing.*;


public class FastCash extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	JButton b1 , b2 , b3 , b4 , b5 , b6 , back;
	String cardnum;
	
	FastCash(String cardnum){
		this.cardnum = cardnum;
		setLayout(null);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
		Image atmScaled = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon atm = new ImageIcon(atmScaled);
		JLabel atmimage = new JLabel(atm);
		atmimage.setBounds(0 , 0 , 900 , 900);
		add(atmimage);
		
		JLabel text = new JLabel("Please select your Transaction");
		text.setBounds(225 , 310 , 400 , 30);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("system",Font.BOLD,14));
		atmimage.add(text);
		
		b1 = new JButton("Rs.100");
		b1.setBounds(160, 450, 150, 30);
		b1.addActionListener(this);
		atmimage.add(b1);
		
		b2 = new JButton("Rs.500");
		b2.setBounds(360, 450, 150, 30);
		b2.addActionListener(this);
		atmimage.add(b2);
		
		b3 = new JButton("Rs.1000");
		b3.setBounds(160, 485, 150, 30);
		b3.addActionListener(this);
		atmimage.add(b3);
		
		b4 = new JButton("Rs.2000");
		b4.setBounds(360, 485, 150, 30);
		b4.addActionListener(this);
		atmimage.add(b4);
		
		b5 = new JButton("Rs.5000");
		b5.setBounds(160, 520, 150, 30);
		b5.addActionListener(this);
		atmimage.add(b5);
		
		b6 = new JButton("Rs.10000");
		b6.setBounds(360, 520, 150, 30);
		b6.addActionListener(this);
		atmimage.add(b6);
		
		back = new JButton("Back");
		back.setBounds(360, 555, 150, 30);
		back.addActionListener(this);
		atmimage.add(back);
		
		setSize(900,900);
		setLocation(350,0);
		setUndecorated(true);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(cardnum);
		}else {
			String amount = ((JButton)ae.getSource()).getText().substring(3);
			
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
				
				if(balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
				}else {
					Date date = new Date();
					con.s.executeUpdate("insert into bank values('"+cardnum+"' , '"+date+"' , 'Withdraw' , '"+amount+"')");
					JOptionPane.showMessageDialog(null, "Rs "+amount+" Withdrawn successfully");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
