package atmSimulator;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.*;

public class SignUpOne extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	String randomNo;
	JTextField nameTextField, fathersNameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
	JDateChooser dateChooser;
	JRadioButton male, female, other, married, unmarried, otherStatus;
	JButton next;
	
	SignUpOne(){
		Random ran = new Random();
		randomNo = String.format("%04d", Math.abs((ran.nextInt() % 10000)));
		
		setTitle("New Account Application Form - Page 1");
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel formNo = new JLabel("APPLICATION FORM NO - "+randomNo);
		formNo.setFont(new Font("Raleway" , Font.BOLD , 38));
		formNo.setBounds(150 , 20 , 600 , 40);
		add(formNo);
		
		JLabel personalDetails = new JLabel("Page 1 : Personal Details");
		personalDetails.setFont(new Font("Raleway" , Font.BOLD , 24));
		personalDetails.setBounds(265 , 80 , 300 , 30);
		add(personalDetails);
		
		JLabel name = new JLabel("Name :");
		name.setFont(new Font("Raleway" , Font.BOLD , 22));
		name.setBounds(120 , 140 , 300 , 25);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway" , Font.BOLD , 22));
		nameTextField.setBounds(320, 140, 400, 30);
		add(nameTextField);
		
		JLabel fathersName = new JLabel("Father's Name :");
		fathersName.setFont(new Font("Raleway" , Font.BOLD , 22));
		fathersName.setBounds(120 , 190 , 300 , 25);
		add(fathersName);
		
		fathersNameTextField = new JTextField();
		fathersNameTextField.setFont(new Font("Raleway" , Font.BOLD , 22));
		fathersNameTextField.setBounds(320, 190, 400, 30);
		add(fathersNameTextField);
		
		JLabel dob = new JLabel("Date of Birth :");
		dob.setFont(new Font("Raleway" , Font.BOLD , 22));
		dob.setBounds(120 , 240 , 300 , 25);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(320,240, 400, 25);
		dateChooser.setForeground(Color.black);
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender :");
		gender.setFont(new Font("Raleway" , Font.BOLD , 22));
		gender.setBounds(120 , 290 , 300 , 25);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(320, 290, 100, 25);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(470, 290, 100, 25);
		female.setBackground(Color.WHITE);
		add(female);
		
		other = new JRadioButton("Other");
		other.setBounds(620, 290, 100, 25);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup genderButton = new ButtonGroup();
		genderButton.add(male);
		genderButton.add(female);
		genderButton.add(other);
		
		JLabel email = new JLabel("Email address :");
		email.setFont(new Font("Raleway" , Font.BOLD , 22));
		email.setBounds(120 , 340 , 300 , 25);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway" , Font.BOLD , 22));
		emailTextField.setBounds(320, 340, 400, 30);
		add(emailTextField);
		
		JLabel marital = new JLabel("Marital Status :");
		marital.setFont(new Font("Raleway" , Font.BOLD , 22));
		marital.setBounds(120 , 390 , 300 , 25);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(320, 390, 100, 25);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(470, 390, 100, 25);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		otherStatus = new JRadioButton("Other");
		otherStatus.setBounds(620, 390, 100, 25);
		otherStatus.setBackground(Color.WHITE);
		add(otherStatus);
		
		ButtonGroup maritalButton = new ButtonGroup();
		maritalButton.add(married);
		maritalButton.add(unmarried);
		maritalButton.add(otherStatus);
		
		JLabel address = new JLabel("Address :");
		address.setFont(new Font("Raleway" , Font.BOLD , 22));
		address.setBounds(120 , 440 , 300 , 25);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway" , Font.BOLD , 22));
		addressTextField.setBounds(320, 440, 400, 30);
		add(addressTextField);
		
		JLabel city = new JLabel("City :");
		city.setFont(new Font("Raleway" , Font.BOLD , 22));
		city.setBounds(120 , 490 , 300 , 25);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway" , Font.BOLD , 22));
		cityTextField.setBounds(320, 490, 400, 30);
		add(cityTextField);
		
		JLabel state = new JLabel("State :");
		state.setFont(new Font("Raleway" , Font.BOLD , 22));
		state.setBounds(120 , 540 , 300 , 25);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway" , Font.BOLD , 22));
		stateTextField.setBounds(320, 540, 400, 30);
		add(stateTextField);
		
		JLabel pinCode = new JLabel("Pin Code :");
		pinCode.setFont(new Font("Raleway" , Font.BOLD , 22));
		pinCode.setBounds(120 , 590 , 300 , 20);
		add(pinCode);
		
		pinTextField = new JTextField();
		pinTextField.setFont(new Font("Raleway" , Font.BOLD , 22));
		pinTextField.setBounds(320, 590, 400, 30);
		add(pinTextField);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(640, 650, 80, 30);
		next.addActionListener(this);
		add(next);
		
		setSize(850 , 800);
		setLocation(350,10);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String formNo = randomNo; 
		String name = nameTextField.getText();
		String fathersName = fathersNameTextField.getText();
		String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}else if(female.isSelected()) {
			gender = "Female";
		}else if(other.isSelected()) {
			gender = "Other";
		}
		String email = emailTextField.getText();
		String marital = null;
		if(married.isSelected()) {
			marital = "Married";
		}else if(unmarried.isSelected()) {
			marital = "Unmarried";
		}else if(otherStatus.isSelected()) {
			marital = "Other";
		}
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pin = pinTextField.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			} else if(fathersName.equals("")) {
				JOptionPane.showMessageDialog(null, "Fathers Name is Required");
			} else if(dob.equals("")) {
				JOptionPane.showMessageDialog(null, "Date of Birth is Required");
			} else if(email.equals("")) {
				JOptionPane.showMessageDialog(null, "Email is Required");
			} else if(address.equals("")) {
				JOptionPane.showMessageDialog(null, "Address is Required");
			} else if(city.equals("")) {
				JOptionPane.showMessageDialog(null, "City is Required");
			} else if(state.equals("")) {
				JOptionPane.showMessageDialog(null, "State is Required");
			} else if(pin.equals("")) {
				JOptionPane.showMessageDialog(null, "Pincode is Required");
			} else {
				Conn con = new Conn();
				String query = "INSERT INTO signup values('"+formNo+"' , '"+name+"' , '"+fathersName+"' , '"+dob+"' , '"+gender+"' , '"+email+"' , '"+marital+"' , '"+address+"' , '"+city+"' , '"+state+"' , '"+pin+"' )";
				con.s.executeUpdate(query);
				
				setVisible(false);
				new SignUpTwo(formNo);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
