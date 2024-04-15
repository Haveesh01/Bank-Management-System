package atmSimulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;

import javax.swing.*;


public class Deposits extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	JTextField depositField;
	JButton deposit , back;
	String cardnum;
	
	Deposits(String cardnum){
		this.cardnum = cardnum;
		setLayout(null);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
		Image atmScaled = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon atm = new ImageIcon(atmScaled);
		JLabel atmimage = new JLabel(atm);
		atmimage.setBounds(0 , 0 , 900 , 900);
		add(atmimage);
		
		JLabel text = new JLabel("Enter the amount you want to deposit");
		text.setBounds(200 , 310 , 400 , 30);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("system",Font.BOLD,14));
		atmimage.add(text);
		
		depositField = new JTextField();
		depositField.setBounds(190, 360, 300, 20);
		depositField.setFont(new Font("Raleway" , Font.BOLD , 20));
		atmimage.add(depositField);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(360, 520, 150, 30);
		deposit.addActionListener(this);
		atmimage.add(deposit);
		
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
		if(ae.getSource()==deposit){
			String money = depositField.getText();
			Date date = new Date();
			if(money.equals("")) {
				JOptionPane.showMessageDialog(null, "Minimum deposit amount is Rs.1");
			}else {
				Conn con = new Conn();
				String query = "insert into bank values('"+cardnum+"' , '"+date+"' , 'Deposit' , '"+money+"');";
				try {
					con.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs."+money+" deposited successfully");
					setVisible(false);
					new Transactions(cardnum).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else if(ae.getSource()==back){
			setVisible(false);
			new Transactions(cardnum);
		}
	}

}
