package atmSimulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	JPasswordField epin , repin;
	JButton change,back;
	String cardnum;
	
	PinChange(String cardnum){
		this.cardnum=cardnum;
		setLayout(null);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
		Image atmScaled = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon atm = new ImageIcon(atmScaled);
		JLabel atmimage = new JLabel(atm);
		atmimage.setBounds(0 , 0 , 900 , 900);
		add(atmimage);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setBounds(270 , 310 , 400 , 30);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("system",Font.BOLD,14));
		atmimage.add(text);
		
		JLabel etext = new JLabel("Enter new pin:");
		etext.setBounds(170 , 355 , 140 , 30);
		etext.setForeground(Color.WHITE);
		etext.setFont(new Font("system",Font.BOLD,14));
		atmimage.add(etext);
		
		epin = new JPasswordField();
		epin.setBounds(340, 360, 150, 20);
		epin.setFont(new Font("Raleway" , Font.BOLD , 20));
		atmimage.add(epin);
		
		JLabel retext = new JLabel("Re-enter new pin:");
		retext.setBounds(170 , 385 , 140 , 30);
		retext.setForeground(Color.WHITE);
		retext.setFont(new Font("system",Font.BOLD,14));
		atmimage.add(retext);
		
		repin = new JPasswordField();
		repin.setBounds(340, 390, 150, 20);
		repin.setFont(new Font("Raleway" , Font.BOLD , 20));
		atmimage.add(repin);
		
		change = new JButton("Change");
		change.setBounds(360, 520, 150, 30);
		change.addActionListener(this);
		atmimage.add(change);
		
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
			@SuppressWarnings("deprecation")
			String sepin =epin.getText();
			@SuppressWarnings("deprecation")
			String srepin=repin.getText();
			
			if(! sepin.equals(srepin)){
				JOptionPane.showMessageDialog(null, "New PIN numbers does not match");
				return;
			}
			if(sepin.equals("") || srepin.equals("")) {
				JOptionPane.showMessageDialog(null, "PIN numbers cannot be empty");
				return;
			}
			
			if(sepin.equals(srepin)){
				Conn con = new Conn();
				String query1 = "update login set pin = '"+srepin+"' where card_number = '"+cardnum+"' ";
				String query2 = "update signupthree set pin = '"+srepin+"' where card_Number = '"+cardnum+"' ";
				
				try {
					con.s.executeUpdate(query1);
					con.s.executeUpdate(query2);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
				setVisible(false);
				new Transactions(cardnum);
			}
			
		}
		
	}
}
