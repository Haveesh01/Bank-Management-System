package atmSimulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	JButton deposit , cashWithdrawl , fastCash , miniStatement , pinChange , balanceEnquiry , exit;
	String cardnum;
	
	Transactions(String cardnum){
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
		
		deposit = new JButton("Deposit");
		deposit.setBounds(160, 450, 150, 30);
		deposit.addActionListener(this);
		atmimage.add(deposit);
		
		cashWithdrawl = new JButton("Cash Withdrawl");
		cashWithdrawl.setBounds(360, 450, 150, 30);
		cashWithdrawl.addActionListener(this);
		atmimage.add(cashWithdrawl);
		
		fastCash = new JButton("Fast Cash");
		fastCash.setBounds(160, 485, 150, 30);
		fastCash.addActionListener(this);
		atmimage.add(fastCash);
		
		miniStatement = new JButton("Mini Statement");
		miniStatement.setBounds(360, 485, 150, 30);
		miniStatement.addActionListener(this);
		atmimage.add(miniStatement);
		
		pinChange = new JButton("Pin Change");
		pinChange.setBounds(160, 520, 150, 30);
		pinChange.addActionListener(this);
		atmimage.add(pinChange);
		
		balanceEnquiry = new JButton("Balance Enquiry");
		balanceEnquiry.setBounds(360, 520, 150, 30);
		balanceEnquiry.addActionListener(this);
		atmimage.add(balanceEnquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(360, 555, 150, 30);
		exit.addActionListener(this);
		atmimage.add(exit);
		
		setSize(900,900);
		setLocation(350,0);
		setUndecorated(true);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			System.exit(0);
		}else if(ae.getSource()==deposit) {
			setVisible(false);
			new Deposits(cardnum);
		}else if(ae.getSource()==cashWithdrawl) {
			setVisible(false);
			new Withdrawl(cardnum);
		}else if(ae.getSource()==fastCash) {
			setVisible(false);
			new FastCash(cardnum);
		}else if(ae.getSource()==pinChange) {
			setVisible(false);
			new PinChange(cardnum);
		}else if(ae.getSource()==balanceEnquiry) {
			setVisible(false);
			new BalanceEnquiry(cardnum);
		}else if(ae.getSource()==miniStatement) {
			new MiniStatement(cardnum);
		}
	}

}
