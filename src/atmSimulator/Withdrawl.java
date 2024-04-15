package atmSimulator;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	JTextField withdrawField;
	JButton withdraw , back;
	String cardnum;
	
	Withdrawl(String cardnum){
		this.cardnum = cardnum;
		setLayout(null);

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
		Image atmScaled = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon atm = new ImageIcon(atmScaled);
		JLabel atmimage = new JLabel(atm);
		atmimage.setBounds(0 , 0 , 900 , 900);
		add(atmimage);
		
		JLabel text = new JLabel("Enter the amount you want to Withdraw");
		text.setBounds(200 , 310 , 400 , 30);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("system",Font.BOLD,14));
		atmimage.add(text);
		
		withdrawField = new JTextField();
		withdrawField.setBounds(190, 360, 300, 20);
		withdrawField.setFont(new Font("Raleway" , Font.BOLD , 20));
		atmimage.add(withdrawField);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(360, 520, 150, 30);
		withdraw.addActionListener(this);
		atmimage.add(withdraw);
		
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
		if(ae.getSource()==withdraw){
			String amount = withdrawField.getText();
			int balance = 0;
			Date date = new Date();
			if(amount.equals("")) {
				JOptionPane.showMessageDialog(null, "Minimum Withdrawl amount is Rs.1");
			}else {
				Conn con = new Conn();
				String query = "insert into bank values('"+cardnum+"' , '"+date+"' , 'Withdraw' , '"+amount+"');";
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
						con.s.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Rs "+amount+" Withdrawn successfully");
					}
					
					setVisible(false);
					new Transactions(cardnum).setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(ae.getSource()==back){
			setVisible(false);
			new Transactions(cardnum);
		}
	}

}
